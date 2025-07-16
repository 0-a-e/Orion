package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.StreamSpecification;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class StreamSpecificationJsonUnmarshaller implements Unmarshaller<StreamSpecification, JsonUnmarshallerContext> {
    private static StreamSpecificationJsonUnmarshaller instance;

    StreamSpecificationJsonUnmarshaller() {
    }

    public StreamSpecification unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        StreamSpecification streamSpecification = new StreamSpecification();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("StreamEnabled")) {
                streamSpecification.setStreamEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("StreamViewType")) {
                streamSpecification.setStreamViewType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return streamSpecification;
    }

    public static StreamSpecificationJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new StreamSpecificationJsonUnmarshaller();
        }
        return instance;
    }
}
