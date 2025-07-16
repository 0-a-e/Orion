package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Capacity;
import com.amazonaws.services.dynamodbv2.model.ConsumedCapacity;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Map;

class ConsumedCapacityJsonMarshaller {
    private static ConsumedCapacityJsonMarshaller instance;

    ConsumedCapacityJsonMarshaller() {
    }

    public void marshall(ConsumedCapacity consumedCapacity, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (consumedCapacity.getTableName() != null) {
            String tableName = consumedCapacity.getTableName();
            awsJsonWriter.name("TableName");
            awsJsonWriter.value(tableName);
        }
        if (consumedCapacity.getCapacityUnits() != null) {
            Double capacityUnits = consumedCapacity.getCapacityUnits();
            awsJsonWriter.name("CapacityUnits");
            awsJsonWriter.value((Number) capacityUnits);
        }
        if (consumedCapacity.getTable() != null) {
            Capacity table = consumedCapacity.getTable();
            awsJsonWriter.name("Table");
            CapacityJsonMarshaller.getInstance().marshall(table, awsJsonWriter);
        }
        if (consumedCapacity.getLocalSecondaryIndexes() != null) {
            Map<String, Capacity> localSecondaryIndexes = consumedCapacity.getLocalSecondaryIndexes();
            awsJsonWriter.name("LocalSecondaryIndexes");
            awsJsonWriter.beginObject();
            for (Map.Entry next : localSecondaryIndexes.entrySet()) {
                Capacity capacity = (Capacity) next.getValue();
                if (capacity != null) {
                    awsJsonWriter.name((String) next.getKey());
                    CapacityJsonMarshaller.getInstance().marshall(capacity, awsJsonWriter);
                }
            }
            awsJsonWriter.endObject();
        }
        if (consumedCapacity.getGlobalSecondaryIndexes() != null) {
            Map<String, Capacity> globalSecondaryIndexes = consumedCapacity.getGlobalSecondaryIndexes();
            awsJsonWriter.name("GlobalSecondaryIndexes");
            awsJsonWriter.beginObject();
            for (Map.Entry next2 : globalSecondaryIndexes.entrySet()) {
                Capacity capacity2 = (Capacity) next2.getValue();
                if (capacity2 != null) {
                    awsJsonWriter.name((String) next2.getKey());
                    CapacityJsonMarshaller.getInstance().marshall(capacity2, awsJsonWriter);
                }
            }
            awsJsonWriter.endObject();
        }
        awsJsonWriter.endObject();
    }

    public static ConsumedCapacityJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ConsumedCapacityJsonMarshaller();
        }
        return instance;
    }
}
