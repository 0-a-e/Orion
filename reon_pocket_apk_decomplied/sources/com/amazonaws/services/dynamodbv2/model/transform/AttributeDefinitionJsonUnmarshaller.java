package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AttributeDefinitionJsonUnmarshaller implements Unmarshaller<AttributeDefinition, JsonUnmarshallerContext> {
    private static AttributeDefinitionJsonUnmarshaller instance;

    AttributeDefinitionJsonUnmarshaller() {
    }

    public AttributeDefinition unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AttributeDefinition attributeDefinition = new AttributeDefinition();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("AttributeName")) {
                attributeDefinition.setAttributeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AttributeType")) {
                attributeDefinition.setAttributeType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return attributeDefinition;
    }

    public static AttributeDefinitionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeDefinitionJsonUnmarshaller();
        }
        return instance;
    }
}
