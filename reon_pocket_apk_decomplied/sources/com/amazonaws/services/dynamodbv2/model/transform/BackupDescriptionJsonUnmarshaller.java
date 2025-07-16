package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.BackupDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class BackupDescriptionJsonUnmarshaller implements Unmarshaller<BackupDescription, JsonUnmarshallerContext> {
    private static BackupDescriptionJsonUnmarshaller instance;

    BackupDescriptionJsonUnmarshaller() {
    }

    public BackupDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        BackupDescription backupDescription = new BackupDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("BackupDetails")) {
                backupDescription.setBackupDetails(BackupDetailsJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SourceTableDetails")) {
                backupDescription.setSourceTableDetails(SourceTableDetailsJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SourceTableFeatureDetails")) {
                backupDescription.setSourceTableFeatureDetails(SourceTableFeatureDetailsJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return backupDescription;
    }

    public static BackupDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BackupDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
