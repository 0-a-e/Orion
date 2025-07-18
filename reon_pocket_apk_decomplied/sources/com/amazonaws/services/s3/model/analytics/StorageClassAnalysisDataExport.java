package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public class StorageClassAnalysisDataExport implements Serializable {
    private AnalyticsExportDestination destination;
    private String outputSchemaVersion;

    public void setOutputSchemaVersion(StorageClassAnalysisSchemaVersion storageClassAnalysisSchemaVersion) {
        if (storageClassAnalysisSchemaVersion == null) {
            String str = null;
            setOutputSchemaVersion((String) null);
            return;
        }
        setOutputSchemaVersion(storageClassAnalysisSchemaVersion.toString());
    }

    public StorageClassAnalysisDataExport withOutputSchemaVersion(StorageClassAnalysisSchemaVersion storageClassAnalysisSchemaVersion) {
        setOutputSchemaVersion(storageClassAnalysisSchemaVersion);
        return this;
    }

    public String getOutputSchemaVersion() {
        return this.outputSchemaVersion;
    }

    public void setOutputSchemaVersion(String str) {
        this.outputSchemaVersion = str;
    }

    public StorageClassAnalysisDataExport withOutputSchemaVersion(String str) {
        setOutputSchemaVersion(str);
        return this;
    }

    public AnalyticsExportDestination getDestination() {
        return this.destination;
    }

    public void setDestination(AnalyticsExportDestination analyticsExportDestination) {
        this.destination = analyticsExportDestination;
    }

    public StorageClassAnalysisDataExport withDestination(AnalyticsExportDestination analyticsExportDestination) {
        setDestination(analyticsExportDestination);
        return this;
    }
}
