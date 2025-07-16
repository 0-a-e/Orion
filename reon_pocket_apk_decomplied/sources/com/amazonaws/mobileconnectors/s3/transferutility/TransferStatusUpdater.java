package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class TransferStatusUpdater {
    static final Map<Integer, List<TransferListener>> LISTENERS = new ConcurrentHashMap<Integer, List<TransferListener>>() {
    };
    /* access modifiers changed from: private */
    public static final Log LOGGER = LogFactory.getLog((Class<?>) TransferStatusUpdater.class);
    private static final HashSet<TransferState> STATES_NOT_TO_NOTIFY = new HashSet<>(Arrays.asList(new TransferState[]{TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT}));
    static final String TEMP_FILE_PREFIX = "aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002";
    private static TransferDBUtil dbUtil;
    private static TransferStatusUpdater transferStatusUpdater;
    private Context context;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<Integer, TransferRecord> transfers = new ConcurrentHashMap();

    TransferStatusUpdater(TransferDBUtil transferDBUtil, Context context2) {
        dbUtil = transferDBUtil;
        this.context = context2;
    }

    public static synchronized TransferStatusUpdater getInstance(Context context2) {
        TransferStatusUpdater transferStatusUpdater2;
        synchronized (TransferStatusUpdater.class) {
            if (transferStatusUpdater == null) {
                TransferDBUtil transferDBUtil = new TransferDBUtil(context2);
                dbUtil = transferDBUtil;
                transferStatusUpdater = new TransferStatusUpdater(transferDBUtil, context2);
            }
            transferStatusUpdater2 = transferStatusUpdater;
        }
        return transferStatusUpdater2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Map<Integer, TransferRecord> getTransfers() {
        return Collections.unmodifiableMap(this.transfers);
    }

    /* access modifiers changed from: package-private */
    public synchronized void addTransfer(TransferRecord transferRecord) {
        this.transfers.put(Integer.valueOf(transferRecord.id), transferRecord);
    }

    /* access modifiers changed from: package-private */
    public synchronized TransferRecord getTransfer(int i) {
        return this.transfers.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeTransfer(int i) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.remove(Integer.valueOf(i));
        }
        this.transfers.remove(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeTransferRecordFromDB(int i) {
        TransferRecord transferById = dbUtil.getTransferById(i);
        if (transferById != null) {
            String str = transferById.file;
            if (new File(str).getName().startsWith(TEMP_FILE_PREFIX)) {
                new File(str).delete();
            }
        }
        S3ClientReference.remove(Integer.valueOf(i));
        dbUtil.deleteTransferRecords(i);
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateState(final int i, final TransferState transferState) {
        boolean contains = STATES_NOT_TO_NOTIFY.contains(transferState);
        TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i));
        if (transferRecord != null) {
            contains |= transferState.equals(transferRecord.state);
            transferRecord.state = transferState;
            if (dbUtil.updateTransferRecord(transferRecord) == 0) {
                Log log = LOGGER;
                log.warn("Failed to update the status of transfer " + i);
            }
        } else if (dbUtil.updateState(i, transferState) == 0) {
            Log log2 = LOGGER;
            log2.warn("Failed to update the status of transfer " + i);
        }
        if (!contains) {
            if (TransferState.COMPLETED.equals(transferState)) {
                removeTransferRecordFromDB(i);
            }
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                List<TransferListener> list = map.get(Integer.valueOf(i));
                if (list != null && !list.isEmpty()) {
                    for (final TransferListener transferListener : list) {
                        if (transferListener instanceof TransferObserver.TransferStatusListener) {
                            transferListener.onStateChanged(i, transferState);
                        } else {
                            this.mainHandler.post(new Runnable() {
                                public void run() {
                                    transferListener.onStateChanged(i, transferState);
                                }
                            });
                        }
                    }
                    if (TransferState.isFinalState(transferState)) {
                        list.clear();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateProgress(int i, long j, long j2, boolean z) {
        long j3 = j;
        synchronized (this) {
            TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i));
            if (transferRecord != null) {
                transferRecord.bytesCurrent = j3;
                transferRecord.bytesTotal = j2;
            } else {
                long j4 = j2;
            }
            dbUtil.updateBytesTransferred(i, j3);
            if (z) {
                Map<Integer, List<TransferListener>> map = LISTENERS;
                synchronized (map) {
                    List list = map.get(Integer.valueOf(i));
                    if (list != null) {
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                final TransferListener transferListener = (TransferListener) it.next();
                                final int i2 = i;
                                final long j5 = j;
                                Iterator it2 = it;
                                Handler handler = this.mainHandler;
                                AnonymousClass3 r10 = r1;
                                final long j6 = j2;
                                AnonymousClass3 r1 = new Runnable() {
                                    public void run() {
                                        transferListener.onProgressChanged(i2, j5, j6);
                                    }
                                };
                                handler.post(r10);
                                long j7 = j;
                                it = it2;
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void throwError(final int r6, final java.lang.Exception r7) {
        /*
            r5 = this;
            java.util.Map<java.lang.Integer, java.util.List<com.amazonaws.mobileconnectors.s3.transferutility.TransferListener>> r0 = LISTENERS
            monitor-enter(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0035 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0033
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0016
            goto L_0x0033
        L_0x0016:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0035 }
        L_0x001a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0035 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferListener r2 = (com.amazonaws.mobileconnectors.s3.transferutility.TransferListener) r2     // Catch:{ all -> 0x0035 }
            android.os.Handler r3 = r5.mainHandler     // Catch:{ all -> 0x0035 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$4 r4 = new com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$4     // Catch:{ all -> 0x0035 }
            r4.<init>(r2, r6, r7)     // Catch:{ all -> 0x0035 }
            r3.post(r4)     // Catch:{ all -> 0x0035 }
            goto L_0x001a
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.throwError(int, java.lang.Exception):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void clear() {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.clear();
        }
        this.transfers.clear();
    }

    static void registerListener(int i, TransferListener transferListener) {
        if (transferListener != null) {
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                List list = map.get(Integer.valueOf(i));
                if (list == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(transferListener);
                    map.put(Integer.valueOf(i), copyOnWriteArrayList);
                } else if (!list.contains(transferListener)) {
                    list.add(transferListener);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Listener can't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void unregisterListener(int r2, com.amazonaws.mobileconnectors.s3.transferutility.TransferListener r3) {
        /*
            if (r3 == 0) goto L_0x0022
            java.util.Map<java.lang.Integer, java.util.List<com.amazonaws.mobileconnectors.s3.transferutility.TransferListener>> r0 = LISTENERS
            monitor-enter(r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x001f }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001f }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x001d
            boolean r1 = r2.isEmpty()     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0018
            goto L_0x001d
        L_0x0018:
            r2.remove(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r2
        L_0x0022:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Listener can't be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.unregisterListener(int, com.amazonaws.mobileconnectors.s3.transferutility.TransferListener):void");
    }

    private class TransferProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private final TransferRecord transfer;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.transfer = transferRecord;
        }

        public synchronized void progressChanged(ProgressEvent progressEvent) {
            if (32 == progressEvent.getEventCode()) {
                TransferStatusUpdater.LOGGER.info("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.bytesTransferredSoFar = 0;
            } else {
                long bytesTransferred = this.bytesTransferredSoFar + progressEvent.getBytesTransferred();
                this.bytesTransferredSoFar = bytesTransferred;
                if (bytesTransferred > this.transfer.bytesCurrent) {
                    this.transfer.bytesCurrent = this.bytesTransferredSoFar;
                    TransferStatusUpdater.this.updateProgress(this.transfer.id, this.transfer.bytesCurrent, this.transfer.bytesTotal, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized ProgressListener newProgressListener(int i) {
        TransferRecord transfer;
        transfer = getTransfer(i);
        if (transfer != null) {
            Log log = LOGGER;
            log.info("Creating a new progress listener for transfer: " + i);
        } else {
            Log log2 = LOGGER;
            log2.info("TransferStatusUpdater doesn't track the transfer: " + i);
            throw new IllegalArgumentException("transfer " + i + " doesn't exist");
        }
        return new TransferProgressListener(transfer);
    }
}
