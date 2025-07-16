package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.util.json.AwsJsonWriter;

class AttributeDefinitionJsonMarshaller {
    private static AttributeDefinitionJsonMarshaller instance;

    AttributeDefinitionJsonMarshaller() {
    }

    public void marshall(AttributeDefinition attributeDefinition, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (attributeDefinition.getAttributeName() != null) {
            String attributeName = attributeDefinition.getAttributeName();
            awsJsonWriter.name("AttributeName");
            awsJsonWriter.value(attributeName);
        }
        if (attributeDefinition.getAttributeType() != null) {
            String attributeType = attributeDefinition.getAttributeType();
            awsJsonWriter.name("AttributeType");
            awsJsonWriter.value(attributeType);
        }
        awsJsonWriter.endObject();
    }

    public static AttributeDefinitionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeDefinitionJsonMarshaller();
        }
        return instance;
    }
}
