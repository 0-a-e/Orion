package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListBackupsResultJsonUnmarshaller implements Unmarshaller<ListBackupsResult, JsonUnmarshallerContext> {
    private static ListBackupsResultJsonUnmarshaller instance;

    public ListBackupsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListBackupsResult listBackupsResult = new ListBackupsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("BackupSummaries")) {
                listBackupsResult.setBackupSummaries(new ListUnmarshaller(BackupSummaryJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LastEvaluatedBackupArn")) {
                listBackupsResult.setLastEvaluatedBackupArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listBackupsResult;
    }

    public static ListBackupsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListBackupsResultJsonUnmarshaller();
        }
        return instance;
    }
}
