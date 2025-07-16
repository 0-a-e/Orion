package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.util.json.AwsJsonWriter;

class ProvisionedThroughputJsonMarshaller {
    private static ProvisionedThroughputJsonMarshaller instance;

    ProvisionedThroughputJsonMarshaller() {
    }

    public void marshall(ProvisionedThroughput provisionedThroughput, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (provisionedThroughput.getReadCapacityUnits() != null) {
            Long readCapacityUnits = provisionedThroughput.getReadCapacityUnits();
            awsJsonWriter.name("ReadCapacityUnits");
            awsJsonWriter.value((Number) readCapacityUnits);
        }
        if (provisionedThroughput.getWriteCapacityUnits() != null) {
            Long writeCapacityUnits = provisionedThroughput.getWriteCapacityUnits();
            awsJsonWriter.name("WriteCapacityUnits");
            awsJsonWriter.value((Number) writeCapacityUnits);
        }
        awsJsonWriter.endObject();
    }

    public static ProvisionedThroughputJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ProvisionedThroughputJsonMarshaller();
        }
        return instance;
    }
}
