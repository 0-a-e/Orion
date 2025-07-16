package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.LinkedList;
import java.util.List;

public class PaginatedParallelScanList<T> extends PaginatedList<T> {
    private final DynamoDBMapperConfig config;
    private final ParallelScanTask parallelScanTask;

    public PaginatedParallelScanList(DynamoDBMapper dynamoDBMapper, Class<T> cls, AmazonDynamoDB amazonDynamoDB, ParallelScanTask parallelScanTask2, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy, DynamoDBMapperConfig dynamoDBMapperConfig) {
        super(dynamoDBMapper, cls, amazonDynamoDB, paginationLoadingStrategy);
        this.parallelScanTask = parallelScanTask2;
        this.config = dynamoDBMapperConfig;
        this.allResults.addAll(marshalParallelScanResultsIntoObjects(parallelScanTask2.getNextBatchOfScanResults()));
        if (paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING) {
            loadAllResults();
        }
    }

    /* access modifiers changed from: protected */
    public boolean atEndOfResults() {
        return this.parallelScanTask.isAllSegmentScanFinished();
    }

    /* access modifiers changed from: protected */
    public List<T> fetchNextPage() {
        return marshalParallelScanResultsIntoObjects(this.parallelScanTask.getNextBatchOfScanResults());
    }

    private List<T> marshalParallelScanResultsIntoObjects(List<ScanResult> list) {
        LinkedList linkedList = new LinkedList();
        for (ScanResult next : list) {
            if (next != null) {
                linkedList.addAll(this.mapper.marshallIntoObjects(this.mapper.toParameters(next.getItems(), this.clazz, this.parallelScanTask.getTableName(), this.config)));
            }
        }
        return linkedList;
    }
}
