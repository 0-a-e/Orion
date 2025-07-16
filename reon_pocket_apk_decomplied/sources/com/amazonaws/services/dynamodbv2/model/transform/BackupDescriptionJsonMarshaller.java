package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.BackupDescription;
import com.amazonaws.services.dynamodbv2.model.BackupDetails;
import com.amazonaws.services.dynamodbv2.model.SourceTableDetails;
import com.amazonaws.services.dynamodbv2.model.SourceTableFeatureDetails;
import com.amazonaws.util.json.AwsJsonWriter;

class BackupDescriptionJsonMarshaller {
    private static BackupDescriptionJsonMarshaller instance;

    BackupDescriptionJsonMarshaller() {
    }

    public void marshall(BackupDescription backupDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (backupDescription.getBackupDetails() != null) {
            BackupDetails backupDetails = backupDescription.getBackupDetails();
            awsJsonWriter.name("BackupDetails");
            BackupDetailsJsonMarshaller.getInstance().marshall(backupDetails, awsJsonWriter);
        }
        if (backupDescription.getSourceTableDetails() != null) {
            SourceTableDetails sourceTableDetails = backupDescription.getSourceTableDetails();
            awsJsonWriter.name("SourceTableDetails");
            SourceTableDetailsJsonMarshaller.getInstance().marshall(sourceTableDetails, awsJsonWriter);
        }
        if (backupDescription.getSourceTableFeatureDetails() != null) {
            SourceTableFeatureDetails sourceTableFeatureDetails = backupDescription.getSourceTableFeatureDetails();
            awsJsonWriter.name("SourceTableFeatureDetails");
            SourceTableFeatureDetailsJsonMarshaller.getInstance().marshall(sourceTableFeatureDetails, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static BackupDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new BackupDescriptionJsonMarshaller();
        }
        return instance;
    }
}
