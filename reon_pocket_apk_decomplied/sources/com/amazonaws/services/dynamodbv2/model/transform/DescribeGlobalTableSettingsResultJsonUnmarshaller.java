package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DescribeGlobalTableSettingsResultJsonUnmarshaller implements Unmarshaller<DescribeGlobalTableSettingsResult, JsonUnmarshallerContext> {
    private static DescribeGlobalTableSettingsResultJsonUnmarshaller instance;

    public DescribeGlobalTableSettingsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeGlobalTableSettingsResult describeGlobalTableSettingsResult = new DescribeGlobalTableSettingsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("GlobalTableName")) {
                describeGlobalTableSettingsResult.setGlobalTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaSettings")) {
                describeGlobalTableSettingsResult.setReplicaSettings(new ListUnmarshaller(ReplicaSettingsDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeGlobalTableSettingsResult;
    }

    public static DescribeGlobalTableSettingsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeGlobalTableSettingsResultJsonUnmarshaller();
        }
        return instance;
    }
}
