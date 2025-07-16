package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.util.json.AwsJsonWriter;

class KeySchemaElementJsonMarshaller {
    private static KeySchemaElementJsonMarshaller instance;

    KeySchemaElementJsonMarshaller() {
    }

    public void marshall(KeySchemaElement keySchemaElement, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (keySchemaElement.getAttributeName() != null) {
            String attributeName = keySchemaElement.getAttributeName();
            awsJsonWriter.name("AttributeName");
            awsJsonWriter.value(attributeName);
        }
        if (keySchemaElement.getKeyType() != null) {
            String keyType = keySchemaElement.getKeyType();
            awsJsonWriter.name("KeyType");
            awsJsonWriter.value(keyType);
        }
        awsJsonWriter.endObject();
    }

    public static KeySchemaElementJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new KeySchemaElementJsonMarshaller();
        }
        return instance;
    }
}
