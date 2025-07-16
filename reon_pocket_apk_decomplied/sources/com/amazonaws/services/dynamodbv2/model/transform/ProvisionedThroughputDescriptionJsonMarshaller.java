package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;

class ProvisionedThroughputDescriptionJsonMarshaller {
    private static ProvisionedThroughputDescriptionJsonMarshaller instance;

    ProvisionedThroughputDescriptionJsonMarshaller() {
    }

    public void marshall(ProvisionedThroughputDescription provisionedThroughputDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (provisionedThroughputDescription.getLastIncreaseDateTime() != null) {
            Date lastIncreaseDateTime = provisionedThroughputDescription.getLastIncreaseDateTime();
            awsJsonWriter.name("LastIncreaseDateTime");
            awsJsonWriter.value(lastIncreaseDateTime);
        }
        if (provisionedThroughputDescription.getLastDecreaseDateTime() != null) {
            Date lastDecreaseDateTime = provisionedThroughputDescription.getLastDecreaseDateTime();
            awsJsonWriter.name("LastDecreaseDateTime");
            awsJsonWriter.value(lastDecreaseDateTime);
        }
        if (provisionedThroughputDescription.getNumberOfDecreasesToday() != null) {
            Long numberOfDecreasesToday = provisionedThroughputDescription.getNumberOfDecreasesToday();
            awsJsonWriter.name("NumberOfDecreasesToday");
            awsJsonWriter.value((Number) numberOfDecreasesToday);
        }
        if (provisionedThroughputDescription.getReadCapacityUnits() != null) {
            Long readCapacityUnits = provisionedThroughputDescription.getReadCapacityUnits();
            awsJsonWriter.name("ReadCapacityUnits");
            awsJsonWriter.value((Number) readCapacityUnits);
        }
        if (provisionedThroughputDescription.getWriteCapacityUnits() != null) {
            Long writeCapacityUnits = provisionedThroughputDescription.getWriteCapacityUnits();
            awsJsonWriter.name("WriteCapacityUnits");
            awsJsonWriter.value((Number) writeCapacityUnits);
        }
        awsJsonWriter.endObject();
    }

    public static ProvisionedThroughputDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ProvisionedThroughputDescriptionJsonMarshaller();
        }
        return instance;
    }
}
