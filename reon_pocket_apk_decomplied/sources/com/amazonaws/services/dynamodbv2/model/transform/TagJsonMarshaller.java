package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Tag;
import com.amazonaws.util.json.AwsJsonWriter;

class TagJsonMarshaller {
    private static TagJsonMarshaller instance;

    TagJsonMarshaller() {
    }

    public void marshall(Tag tag, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (tag.getKey() != null) {
            String key = tag.getKey();
            awsJsonWriter.name("Key");
            awsJsonWriter.value(key);
        }
        if (tag.getValue() != null) {
            String value = tag.getValue();
            awsJsonWriter.name("Value");
            awsJsonWriter.value(value);
        }
        awsJsonWriter.endObject();
    }

    public static TagJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new TagJsonMarshaller();
        }
        return instance;
    }
}
