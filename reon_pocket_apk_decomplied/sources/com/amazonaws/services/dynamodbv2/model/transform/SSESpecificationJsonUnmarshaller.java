package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.SSESpecification;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class SSESpecificationJsonUnmarshaller implements Unmarshaller<SSESpecification, JsonUnmarshallerContext> {
    private static SSESpecificationJsonUnmarshaller instance;

    SSESpecificationJsonUnmarshaller() {
    }

    public SSESpecification unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SSESpecification sSESpecification = new SSESpecification();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Enabled")) {
                sSESpecification.setEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SSEType")) {
                sSESpecification.setSSEType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KMSMasterKeyId")) {
                sSESpecification.setKMSMasterKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return sSESpecification;
    }

    public static SSESpecificationJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SSESpecificationJsonUnmarshaller();
        }
        return instance;
    }
}
