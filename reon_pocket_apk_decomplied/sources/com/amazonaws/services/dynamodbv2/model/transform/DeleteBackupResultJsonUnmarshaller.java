package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DeleteBackupResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DeleteBackupResultJsonUnmarshaller implements Unmarshaller<DeleteBackupResult, JsonUnmarshallerContext> {
    private static DeleteBackupResultJsonUnmarshaller instance;

    public DeleteBackupResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeleteBackupResult deleteBackupResult = new DeleteBackupResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("BackupDescription")) {
                deleteBackupResult.setBackupDescription(BackupDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return deleteBackupResult;
    }

    public static DeleteBackupResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteBackupResultJsonUnmarshaller();
        }
        return instance;
    }
}
