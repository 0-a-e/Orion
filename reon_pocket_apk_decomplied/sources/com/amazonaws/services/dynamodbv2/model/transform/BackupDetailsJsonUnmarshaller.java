package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.BackupDetails;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class BackupDetailsJsonUnmarshaller implements Unmarshaller<BackupDetails, JsonUnmarshallerContext> {
    private static BackupDetailsJsonUnmarshaller instance;

    BackupDetailsJsonUnmarshaller() {
    }

    public BackupDetails unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        BackupDetails backupDetails = new BackupDetails();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("BackupArn")) {
                backupDetails.setBackupArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BackupName")) {
                backupDetails.setBackupName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BackupSizeBytes")) {
                backupDetails.setBackupSizeBytes(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BackupStatus")) {
                backupDetails.setBackupStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BackupType")) {
                backupDetails.setBackupType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BackupCreationDateTime")) {
                backupDetails.setBackupCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BackupExpiryDateTime")) {
                backupDetails.setBackupExpiryDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return backupDetails;
    }

    public static BackupDetailsJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BackupDetailsJsonUnmarshaller();
        }
        return instance;
    }
}
