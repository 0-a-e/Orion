package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.RestoreSummary;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;

class RestoreSummaryJsonMarshaller {
    private static RestoreSummaryJsonMarshaller instance;

    RestoreSummaryJsonMarshaller() {
    }

    public void marshall(RestoreSummary restoreSummary, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (restoreSummary.getSourceBackupArn() != null) {
            String sourceBackupArn = restoreSummary.getSourceBackupArn();
            awsJsonWriter.name("SourceBackupArn");
            awsJsonWriter.value(sourceBackupArn);
        }
        if (restoreSummary.getSourceTableArn() != null) {
            String sourceTableArn = restoreSummary.getSourceTableArn();
            awsJsonWriter.name("SourceTableArn");
            awsJsonWriter.value(sourceTableArn);
        }
        if (restoreSummary.getRestoreDateTime() != null) {
            Date restoreDateTime = restoreSummary.getRestoreDateTime();
            awsJsonWriter.name("RestoreDateTime");
            awsJsonWriter.value(restoreDateTime);
        }
        if (restoreSummary.getRestoreInProgress() != null) {
            Boolean restoreInProgress = restoreSummary.getRestoreInProgress();
            awsJsonWriter.name("RestoreInProgress");
            awsJsonWriter.value(restoreInProgress.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static RestoreSummaryJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RestoreSummaryJsonMarshaller();
        }
        return instance;
    }
}
