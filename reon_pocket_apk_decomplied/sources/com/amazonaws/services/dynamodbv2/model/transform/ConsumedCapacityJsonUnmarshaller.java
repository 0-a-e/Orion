package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ConsumedCapacity;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ConsumedCapacityJsonUnmarshaller implements Unmarshaller<ConsumedCapacity, JsonUnmarshallerContext> {
    private static ConsumedCapacityJsonUnmarshaller instance;

    ConsumedCapacityJsonUnmarshaller() {
    }

    public ConsumedCapacity unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ConsumedCapacity consumedCapacity = new ConsumedCapacity();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("TableName")) {
                consumedCapacity.setTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("CapacityUnits")) {
                consumedCapacity.setCapacityUnits(SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Table")) {
                consumedCapacity.setTable(CapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LocalSecondaryIndexes")) {
                consumedCapacity.setLocalSecondaryIndexes(new MapUnmarshaller(CapacityJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("GlobalSecondaryIndexes")) {
                consumedCapacity.setGlobalSecondaryIndexes(new MapUnmarshaller(CapacityJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return consumedCapacity;
    }

    public static ConsumedCapacityJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConsumedCapacityJsonUnmarshaller();
        }
        return instance;
    }
}
