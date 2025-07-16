package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AttributeValueJsonUnmarshaller implements Unmarshaller<AttributeValue, JsonUnmarshallerContext> {
    private static AttributeValueJsonUnmarshaller instance;

    AttributeValueJsonUnmarshaller() {
    }

    public AttributeValue unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AttributeValue attributeValue = new AttributeValue();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("S")) {
                attributeValue.setS(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("N")) {
                attributeValue.setN(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("B")) {
                attributeValue.setB(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SS")) {
                attributeValue.setSS(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NS")) {
                attributeValue.setNS(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BS")) {
                attributeValue.setBS(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("M")) {
                attributeValue.setM(new MapUnmarshaller(getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("L")) {
                attributeValue.setL(new ListUnmarshaller(getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NULL")) {
                attributeValue.setNULL(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("BOOL")) {
                attributeValue.setBOOL(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return attributeValue;
    }

    public static AttributeValueJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeValueJsonUnmarshaller();
        }
        return instance;
    }
}
