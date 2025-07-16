package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AttributeValueUpdateJsonUnmarshaller implements Unmarshaller<AttributeValueUpdate, JsonUnmarshallerContext> {
    private static AttributeValueUpdateJsonUnmarshaller instance;

    AttributeValueUpdateJsonUnmarshaller() {
    }

    public AttributeValueUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AttributeValueUpdate attributeValueUpdate = new AttributeValueUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Value")) {
                attributeValueUpdate.setValue(AttributeValueJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals(JsonDocumentFields.ACTION)) {
                attributeValueUpdate.setAction(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return attributeValueUpdate;
    }

    public static AttributeValueUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeValueUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
