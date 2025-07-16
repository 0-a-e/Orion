package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.StreamSpecification;
import com.amazonaws.util.json.AwsJsonWriter;

class StreamSpecificationJsonMarshaller {
    private static StreamSpecificationJsonMarshaller instance;

    StreamSpecificationJsonMarshaller() {
    }

    public void marshall(StreamSpecification streamSpecification, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (streamSpecification.getStreamEnabled() != null) {
            Boolean streamEnabled = streamSpecification.getStreamEnabled();
            awsJsonWriter.name("StreamEnabled");
            awsJsonWriter.value(streamEnabled.booleanValue());
        }
        if (streamSpecification.getStreamViewType() != null) {
            String streamViewType = streamSpecification.getStreamViewType();
            awsJsonWriter.name("StreamViewType");
            awsJsonWriter.value(streamViewType);
        }
        awsJsonWriter.endObject();
    }

    public static StreamSpecificationJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new StreamSpecificationJsonMarshaller();
        }
        return instance;
    }
}
