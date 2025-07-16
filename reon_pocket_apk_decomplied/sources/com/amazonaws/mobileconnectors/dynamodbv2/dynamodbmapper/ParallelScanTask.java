package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelScanTask {
    private final AmazonDynamoDB dynamo;
    private final ExecutorService executorService;
    private final List<ScanRequest> parallelScanRequests;
    private final List<Future<ScanResult>> segmentScanFutureTasks;
    private final List<ScanResult> segmentScanResults;
    /* access modifiers changed from: private */
    public final List<SegmentScanState> segmentScanStates;
    private final int totalSegments;

    private enum SegmentScanState {
        Waiting,
        Scanning,
        Failed,
        HasNextPage,
        SegmentScanCompleted
    }

    @Deprecated
    public ParallelScanTask(DynamoDBMapper dynamoDBMapper, AmazonDynamoDB amazonDynamoDB, List<ScanRequest> list) {
        this(amazonDynamoDB, list);
    }

    ParallelScanTask(AmazonDynamoDB amazonDynamoDB, List<ScanRequest> list) {
        this.dynamo = amazonDynamoDB;
        this.parallelScanRequests = list;
        int size = list.size();
        this.totalSegments = size;
        this.executorService = Executors.newCachedThreadPool();
        this.segmentScanFutureTasks = Collections.synchronizedList(new ArrayList(size));
        this.segmentScanResults = Collections.synchronizedList(new ArrayList(size));
        this.segmentScanStates = Collections.synchronizedList(new ArrayList(size));
        initSegmentScanStates();
    }

    /* access modifiers changed from: package-private */
    public String getTableName() {
        return this.parallelScanRequests.get(0).getTableName();
    }

    public boolean isAllSegmentScanFinished() {
        synchronized (this.segmentScanStates) {
            for (int i = 0; i < this.totalSegments; i++) {
                if (this.segmentScanStates.get(i) != SegmentScanState.SegmentScanCompleted) {
                    return false;
                }
            }
            this.executorService.shutdown();
            return true;
        }
    }

    public List<ScanResult> getNextBatchOfScanResults() {
        List<ScanResult> marshalParallelScanResults;
        startScanNextPages();
        synchronized (this.segmentScanStates) {
            while (true) {
                if (!this.segmentScanStates.contains(SegmentScanState.Waiting)) {
                    if (!this.segmentScanStates.contains(SegmentScanState.Scanning)) {
                        marshalParallelScanResults = marshalParallelScanResults();
                    }
                }
                try {
                    this.segmentScanStates.wait();
                } catch (InterruptedException e) {
                    throw new AmazonClientException("Parallel scan interrupted by other thread.", e);
                }
            }
        }
        return marshalParallelScanResults;
    }

    private void startScanNextPages() {
        final int i = 0;
        while (i < this.totalSegments) {
            final SegmentScanState segmentScanState = this.segmentScanStates.get(i);
            if (segmentScanState != SegmentScanState.Scanning) {
                if (segmentScanState == SegmentScanState.Failed || segmentScanState == SegmentScanState.SegmentScanCompleted) {
                    this.segmentScanResults.set(i, (Object) null);
                } else {
                    synchronized (this.segmentScanStates) {
                        this.segmentScanStates.set(i, SegmentScanState.Scanning);
                        this.segmentScanStates.notifyAll();
                    }
                    this.segmentScanFutureTasks.set(i, this.executorService.submit(new Callable<ScanResult>() {
                        public ScanResult call() throws Exception {
                            try {
                                if (segmentScanState == SegmentScanState.HasNextPage) {
                                    return ParallelScanTask.this.scanNextPageOfSegment(i, true);
                                }
                                if (segmentScanState == SegmentScanState.Waiting) {
                                    return ParallelScanTask.this.scanNextPageOfSegment(i, false);
                                }
                                throw new AmazonClientException("Should not start a new future task");
                            } catch (Exception e) {
                                synchronized (ParallelScanTask.this.segmentScanStates) {
                                    ParallelScanTask.this.segmentScanStates.set(i, SegmentScanState.Failed);
                                    ParallelScanTask.this.segmentScanStates.notifyAll();
                                    throw e;
                                }
                            }
                        }
                    }));
                }
                i++;
            } else {
                throw new AmazonClientException("Should never see a 'Scanning' state when starting parallel scans.");
            }
        }
    }

    private List<ScanResult> marshalParallelScanResults() {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (i < this.totalSegments) {
            SegmentScanState segmentScanState = this.segmentScanStates.get(i);
            if (segmentScanState != SegmentScanState.Failed) {
                if (segmentScanState == SegmentScanState.HasNextPage || segmentScanState == SegmentScanState.SegmentScanCompleted) {
                    linkedList.add(this.segmentScanResults.get(i));
                } else if (segmentScanState == SegmentScanState.Waiting || segmentScanState == SegmentScanState.Scanning) {
                    throw new AmazonClientException("Should never see a 'Scanning' or 'Waiting' state when marshalling parallel scan results.");
                }
                i++;
            } else {
                try {
                    this.segmentScanFutureTasks.get(i).get();
                    throw new AmazonClientException("No Exception found in the failed scan task.");
                } catch (ExecutionException e) {
                    if (e.getCause() instanceof AmazonClientException) {
                        AmazonClientException amazonClientException = (AmazonClientException) e.getCause();
                        AmazonClientException amazonClientException2 = amazonClientException;
                        throw amazonClientException;
                    }
                    throw new AmazonClientException("Internal error during the scan on segment #" + i + InstructionFileId.DOT, e.getCause());
                } catch (Exception e2) {
                    throw new AmazonClientException("Error during the scan on segment #" + i + InstructionFileId.DOT, e2);
                }
            }
        }
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public ScanResult scanNextPageOfSegment(int i, boolean z) {
        ScanRequest scanRequest = this.parallelScanRequests.get(i);
        if (z) {
            scanRequest.setExclusiveStartKey(this.segmentScanResults.get(i).getLastEvaluatedKey());
        } else {
            scanRequest.setExclusiveStartKey((Map<String, AttributeValue>) null);
        }
        ScanResult scan = this.dynamo.scan((ScanRequest) DynamoDBMapper.applyUserAgent(scanRequest));
        this.segmentScanResults.set(i, scan);
        synchronized (this.segmentScanStates) {
            if (scan.getLastEvaluatedKey() == null) {
                this.segmentScanStates.set(i, SegmentScanState.SegmentScanCompleted);
            } else {
                this.segmentScanStates.set(i, SegmentScanState.HasNextPage);
            }
            this.segmentScanStates.notifyAll();
        }
        return scan;
    }

    private void initSegmentScanStates() {
        for (int i = 0; i < this.totalSegments; i++) {
            this.segmentScanFutureTasks.add((Object) null);
            this.segmentScanResults.add((Object) null);
            this.segmentScanStates.add(SegmentScanState.Waiting);
        }
    }
}
