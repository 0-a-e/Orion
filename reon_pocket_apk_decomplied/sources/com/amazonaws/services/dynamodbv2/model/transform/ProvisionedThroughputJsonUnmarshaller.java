package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ProvisionedThroughputJsonUnmarshaller implements Unmarshaller<ProvisionedThroughput, JsonUnmarshallerContext> {
    private static ProvisionedThroughputJsonUnmarshaller instance;

    ProvisionedThroughputJsonUnmarshaller() {
    }

    public ProvisionedThroughput unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ProvisionedThroughput provisionedThroughput = new ProvisionedThroughput();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("ReadCapacityUnits")) {
                provisionedThroughput.setReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("WriteCapacityUnits")) {
                provisionedThroughput.setWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return provisionedThroughput;
    }

    public static ProvisionedThroughputJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ProvisionedThroughputJsonUnmarshaller();
        }
        return instance;
    }
}
