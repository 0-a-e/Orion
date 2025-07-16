package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.PointInTimeRecoverySpecification;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class PointInTimeRecoverySpecificationJsonUnmarshaller implements Unmarshaller<PointInTimeRecoverySpecification, JsonUnmarshallerContext> {
    private static PointInTimeRecoverySpecificationJsonUnmarshaller instance;

    PointInTimeRecoverySpecificationJsonUnmarshaller() {
    }

    public PointInTimeRecoverySpecification unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        PointInTimeRecoverySpecification pointInTimeRecoverySpecification = new PointInTimeRecoverySpecification();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("PointInTimeRecoveryEnabled")) {
                pointInTimeRecoverySpecification.setPointInTimeRecoveryEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return pointInTimeRecoverySpecification;
    }

    public static PointInTimeRecoverySpecificationJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PointInTimeRecoverySpecificationJsonUnmarshaller();
        }
        return instance;
    }
}
