package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DescribeLimitsResultJsonUnmarshaller implements Unmarshaller<DescribeLimitsResult, JsonUnmarshallerContext> {
    private static DescribeLimitsResultJsonUnmarshaller instance;

    public DescribeLimitsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeLimitsResult describeLimitsResult = new DescribeLimitsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("AccountMaxReadCapacityUnits")) {
                describeLimitsResult.setAccountMaxReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AccountMaxWriteCapacityUnits")) {
                describeLimitsResult.setAccountMaxWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableMaxReadCapacityUnits")) {
                describeLimitsResult.setTableMaxReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableMaxWriteCapacityUnits")) {
                describeLimitsResult.setTableMaxWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeLimitsResult;
    }

    public static DescribeLimitsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeLimitsResultJsonUnmarshaller();
        }
        return instance;
    }
}
