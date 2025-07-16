package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.BackupDetails;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;

class BackupDetailsJsonMarshaller {
    private static BackupDetailsJsonMarshaller instance;

    BackupDetailsJsonMarshaller() {
    }

    public void marshall(BackupDetails backupDetails, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (backupDetails.getBackupArn() != null) {
            String backupArn = backupDetails.getBackupArn();
            awsJsonWriter.name("BackupArn");
            awsJsonWriter.value(backupArn);
        }
        if (backupDetails.getBackupName() != null) {
            String backupName = backupDetails.getBackupName();
            awsJsonWriter.name("BackupName");
            awsJsonWriter.value(backupName);
        }
        if (backupDetails.getBackupSizeBytes() != null) {
            Long backupSizeBytes = backupDetails.getBackupSizeBytes();
            awsJsonWriter.name("BackupSizeBytes");
            awsJsonWriter.value((Number) backupSizeBytes);
        }
        if (backupDetails.getBackupStatus() != null) {
            String backupStatus = backupDetails.getBackupStatus();
            awsJsonWriter.name("BackupStatus");
            awsJsonWriter.value(backupStatus);
        }
        if (backupDetails.getBackupType() != null) {
            String backupType = backupDetails.getBackupType();
            awsJsonWriter.name("BackupType");
            awsJsonWriter.value(backupType);
        }
        if (backupDetails.getBackupCreationDateTime() != null) {
            Date backupCreationDateTime = backupDetails.getBackupCreationDateTime();
            awsJsonWriter.name("BackupCreationDateTime");
            awsJsonWriter.value(backupCreationDateTime);
        }
        if (backupDetails.getBackupExpiryDateTime() != null) {
            Date backupExpiryDateTime = backupDetails.getBackupExpiryDateTime();
            awsJsonWriter.name("BackupExpiryDateTime");
            awsJsonWriter.value(backupExpiryDateTime);
        }
        awsJsonWriter.endObject();
    }

    public static BackupDetailsJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new BackupDetailsJsonMarshaller();
        }
        return instance;
    }
}
