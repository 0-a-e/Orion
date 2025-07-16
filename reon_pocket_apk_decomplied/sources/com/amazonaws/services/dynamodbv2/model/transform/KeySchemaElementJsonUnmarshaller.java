package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class KeySchemaElementJsonUnmarshaller implements Unmarshaller<KeySchemaElement, JsonUnmarshallerContext> {
    private static KeySchemaElementJsonUnmarshaller instance;

    KeySchemaElementJsonUnmarshaller() {
    }

    public KeySchemaElement unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        KeySchemaElement keySchemaElement = new KeySchemaElement();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("AttributeName")) {
                keySchemaElement.setAttributeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyType")) {
                keySchemaElement.setKeyType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return keySchemaElement;
    }

    public static KeySchemaElementJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new KeySchemaElementJsonUnmarshaller();
        }
        return instance;
    }
}
