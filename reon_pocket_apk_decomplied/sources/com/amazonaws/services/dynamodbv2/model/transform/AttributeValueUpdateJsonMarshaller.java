package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.util.json.AwsJsonWriter;

class AttributeValueUpdateJsonMarshaller {
    private static AttributeValueUpdateJsonMarshaller instance;

    AttributeValueUpdateJsonMarshaller() {
    }

    public void marshall(AttributeValueUpdate attributeValueUpdate, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (attributeValueUpdate.getValue() != null) {
            AttributeValue value = attributeValueUpdate.getValue();
            awsJsonWriter.name("Value");
            AttributeValueJsonMarshaller.getInstance().marshall(value, awsJsonWriter);
        }
        if (attributeValueUpdate.getAction() != null) {
            String action = attributeValueUpdate.getAction();
            awsJsonWriter.name(JsonDocumentFields.ACTION);
            awsJsonWriter.value(action);
        }
        awsJsonWriter.endObject();
    }

    public static AttributeValueUpdateJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeValueUpdateJsonMarshaller();
        }
        return instance;
    }
}
