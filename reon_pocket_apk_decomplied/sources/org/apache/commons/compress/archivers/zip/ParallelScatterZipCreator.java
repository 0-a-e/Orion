package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import jp.co.sony.reonpocket.util.service.LaunchApplicationNotificationService;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;
import org.apache.commons.compress.parallel.ScatterGatherBackingStoreSupplier;

public class ParallelScatterZipCreator {
    /* access modifiers changed from: private */
    public final ScatterGatherBackingStoreSupplier backingStoreSupplier;
    private long compressionDoneAt;
    private final ExecutorService es;
    private final Deque<Future<? extends ScatterZipOutputStream>> futures;
    private long scatterDoneAt;
    private final long startedAt;
    /* access modifiers changed from: private */
    public final Deque<ScatterZipOutputStream> streams;
    /* access modifiers changed from: private */
    public final ThreadLocal<ScatterZipOutputStream> tlScatterStreams;

    private static class DefaultBackingStoreSupplier implements ScatterGatherBackingStoreSupplier {
        final AtomicInteger storeNum;

        private DefaultBackingStoreSupplier() {
            this.storeNum = new AtomicInteger(0);
        }

        public ScatterGatherBackingStore get() throws IOException {
            return new FileBasedScatterGatherBackingStore(File.createTempFile("parallelscatter", "n" + this.storeNum.incrementAndGet()));
        }
    }

    /* access modifiers changed from: private */
    public ScatterZipOutputStream createDeferred(ScatterGatherBackingStoreSupplier scatterGatherBackingStoreSupplier) throws IOException {
        ScatterGatherBackingStore scatterGatherBackingStore = scatterGatherBackingStoreSupplier.get();
        return new ScatterZipOutputStream(scatterGatherBackingStore, StreamCompressor.create(-1, scatterGatherBackingStore));
    }

    public ParallelScatterZipCreator() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    public ParallelScatterZipCreator(ExecutorService executorService) {
        this(executorService, new DefaultBackingStoreSupplier());
    }

    public ParallelScatterZipCreator(ExecutorService executorService, ScatterGatherBackingStoreSupplier scatterGatherBackingStoreSupplier) {
        this.streams = new ConcurrentLinkedDeque();
        this.futures = new ConcurrentLinkedDeque();
        this.startedAt = System.currentTimeMillis();
        this.compressionDoneAt = 0;
        this.tlScatterStreams = new ThreadLocal<ScatterZipOutputStream>() {
            /* access modifiers changed from: protected */
            public ScatterZipOutputStream initialValue() {
                try {
                    ParallelScatterZipCreator parallelScatterZipCreator = ParallelScatterZipCreator.this;
                    ScatterZipOutputStream access$100 = parallelScatterZipCreator.createDeferred(parallelScatterZipCreator.backingStoreSupplier);
                    ParallelScatterZipCreator.this.streams.add(access$100);
                    return access$100;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        this.backingStoreSupplier = scatterGatherBackingStoreSupplier;
        this.es = executorService;
    }

    public void addArchiveEntry(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier inputStreamSupplier) {
        submitStreamAwareCallable(createCallable(zipArchiveEntry, inputStreamSupplier));
    }

    public void addArchiveEntry(ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        submitStreamAwareCallable(createCallable(zipArchiveEntryRequestSupplier));
    }

    public final void submit(final Callable<? extends Object> callable) {
        submitStreamAwareCallable(new Callable<ScatterZipOutputStream>() {
            public ScatterZipOutputStream call() throws Exception {
                callable.call();
                return (ScatterZipOutputStream) ParallelScatterZipCreator.this.tlScatterStreams.get();
            }
        });
    }

    public final void submitStreamAwareCallable(Callable<? extends ScatterZipOutputStream> callable) {
        this.futures.add(this.es.submit(callable));
    }

    public final Callable<ScatterZipOutputStream> createCallable(ZipArchiveEntry zipArchiveEntry, InputStreamSupplier inputStreamSupplier) {
        if (zipArchiveEntry.getMethod() != -1) {
            final ZipArchiveEntryRequest createZipArchiveEntryRequest = ZipArchiveEntryRequest.createZipArchiveEntryRequest(zipArchiveEntry, inputStreamSupplier);
            return new Callable<ScatterZipOutputStream>() {
                public ScatterZipOutputStream call() throws Exception {
                    ScatterZipOutputStream scatterZipOutputStream = (ScatterZipOutputStream) ParallelScatterZipCreator.this.tlScatterStreams.get();
                    scatterZipOutputStream.addArchiveEntry(createZipArchiveEntryRequest);
                    return scatterZipOutputStream;
                }
            };
        }
        throw new IllegalArgumentException("Method must be set on zipArchiveEntry: " + zipArchiveEntry);
    }

    public final Callable<ScatterZipOutputStream> createCallable(final ZipArchiveEntryRequestSupplier zipArchiveEntryRequestSupplier) {
        return new Callable<ScatterZipOutputStream>() {
            public ScatterZipOutputStream call() throws Exception {
                ScatterZipOutputStream scatterZipOutputStream = (ScatterZipOutputStream) ParallelScatterZipCreator.this.tlScatterStreams.get();
                scatterZipOutputStream.addArchiveEntry(zipArchiveEntryRequestSupplier.get());
                return scatterZipOutputStream;
            }
        };
    }

    public void writeTo(ZipArchiveOutputStream zipArchiveOutputStream) throws IOException, InterruptedException, ExecutionException {
        try {
            for (Future<? extends ScatterZipOutputStream> future : this.futures) {
                future.get();
            }
            this.es.shutdown();
            this.es.awaitTermination(LaunchApplicationNotificationService.BEACON_SCAN_CYCLE_MS, TimeUnit.SECONDS);
            this.compressionDoneAt = System.currentTimeMillis();
            for (Future<? extends ScatterZipOutputStream> future2 : this.futures) {
                ((ScatterZipOutputStream) future2.get()).zipEntryWriter().writeNextZipEntry(zipArchiveOutputStream);
            }
            for (ScatterZipOutputStream close : this.streams) {
                close.close();
            }
            this.scatterDoneAt = System.currentTimeMillis();
            closeAll();
        } catch (Throwable th) {
            closeAll();
            throw th;
        }
    }

    public ScatterStatistics getStatisticsMessage() {
        long j = this.compressionDoneAt;
        return new ScatterStatistics(j - this.startedAt, this.scatterDoneAt - j);
    }

    private void closeAll() {
        for (ScatterZipOutputStream close : this.streams) {
            try {
                close.close();
            } catch (IOException unused) {
            }
        }
    }
}
