package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.PointInTimeRecoverySpecification;
import com.amazonaws.util.json.AwsJsonWriter;

class PointInTimeRecoverySpecificationJsonMarshaller {
    private static PointInTimeRecoverySpecificationJsonMarshaller instance;

    PointInTimeRecoverySpecificationJsonMarshaller() {
    }

    public void marshall(PointInTimeRecoverySpecification pointInTimeRecoverySpecification, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (pointInTimeRecoverySpecification.getPointInTimeRecoveryEnabled() != null) {
            Boolean pointInTimeRecoveryEnabled = pointInTimeRecoverySpecification.getPointInTimeRecoveryEnabled();
            awsJsonWriter.name("PointInTimeRecoveryEnabled");
            awsJsonWriter.value(pointInTimeRecoveryEnabled.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static PointInTimeRecoverySpecificationJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new PointInTimeRecoverySpecificationJsonMarshaller();
        }
        return instance;
    }
}
