package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DescribeGlobalTableResultJsonUnmarshaller implements Unmarshaller<DescribeGlobalTableResult, JsonUnmarshallerContext> {
    private static DescribeGlobalTableResultJsonUnmarshaller instance;

    public DescribeGlobalTableResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeGlobalTableResult describeGlobalTableResult = new DescribeGlobalTableResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("GlobalTableDescription")) {
                describeGlobalTableResult.setGlobalTableDescription(GlobalTableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeGlobalTableResult;
    }

    public static DescribeGlobalTableResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeGlobalTableResultJsonUnmarshaller();
        }
        return instance;
    }
}
