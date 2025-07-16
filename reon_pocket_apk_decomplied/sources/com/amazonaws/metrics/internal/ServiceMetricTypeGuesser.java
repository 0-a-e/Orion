package com.amazonaws.metrics.internal;

import com.amazonaws.Request;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.SimpleThroughputMetricType;
import com.amazonaws.metrics.ThroughputMetricType;
import com.amazonaws.services.s3.BuildConfig;

public enum ServiceMetricTypeGuesser {
    ;

    public static ThroughputMetricType guessThroughputMetricType(Request<?> request, String str, String str2) {
        if (!AwsSdkMetrics.isMetricsEnabled() || !request.getOriginalRequest().getClass().getName().startsWith(BuildConfig.LIBRARY_PACKAGE_NAME)) {
            return null;
        }
        return new SimpleThroughputMetricType("S3" + str, request.getServiceName(), "S3" + str2);
    }
}
