package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DescribeBackupResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DescribeBackupResultJsonUnmarshaller implements Unmarshaller<DescribeBackupResult, JsonUnmarshallerContext> {
    private static DescribeBackupResultJsonUnmarshaller instance;

    public DescribeBackupResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeBackupResult describeBackupResult = new DescribeBackupResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("BackupDescription")) {
                describeBackupResult.setBackupDescription(BackupDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeBackupResult;
    }

    public static DescribeBackupResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeBackupResultJsonUnmarshaller();
        }
        return instance;
    }
}
