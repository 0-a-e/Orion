package com.amazonaws.metrics;

import java.util.concurrent.TimeUnit;

class ByteThroughputHelper extends ByteThroughputProvider {
    private static final int REPORT_INTERVAL_SECS = 10;

    ByteThroughputHelper(ThroughputMetricType throughputMetricType) {
        super(throughputMetricType);
    }

    /* access modifiers changed from: package-private */
    public long startTiming() {
        if (TimeUnit.NANOSECONDS.toSeconds(getDurationNano()) > 10) {
            reportMetrics();
        }
        return System.nanoTime();
    }

    /* access modifiers changed from: package-private */
    public void reportMetrics() {
        if (getByteCount() > 0) {
            AwsSdkMetrics.getServiceMetricCollector().collectByteThroughput(this);
            reset();
        }
    }

    public void increment(int i, long j) {
        super.increment(i, j);
    }
}
