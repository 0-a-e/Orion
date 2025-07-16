package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.TimeToLiveSpecification;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class TimeToLiveSpecificationJsonUnmarshaller implements Unmarshaller<TimeToLiveSpecification, JsonUnmarshallerContext> {
    private static TimeToLiveSpecificationJsonUnmarshaller instance;

    TimeToLiveSpecificationJsonUnmarshaller() {
    }

    public TimeToLiveSpecification unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        TimeToLiveSpecification timeToLiveSpecification = new TimeToLiveSpecification();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Enabled")) {
                timeToLiveSpecification.setEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AttributeName")) {
                timeToLiveSpecification.setAttributeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return timeToLiveSpecification;
    }

    public static TimeToLiveSpecificationJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TimeToLiveSpecificationJsonUnmarshaller();
        }
        return instance;
    }
}
