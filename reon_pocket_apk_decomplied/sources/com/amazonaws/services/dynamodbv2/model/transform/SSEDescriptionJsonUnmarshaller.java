package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.SSEDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class SSEDescriptionJsonUnmarshaller implements Unmarshaller<SSEDescription, JsonUnmarshallerContext> {
    private static SSEDescriptionJsonUnmarshaller instance;

    SSEDescriptionJsonUnmarshaller() {
    }

    public SSEDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SSEDescription sSEDescription = new SSEDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Status")) {
                sSEDescription.setStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SSEType")) {
                sSEDescription.setSSEType(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KMSMasterKeyArn")) {
                sSEDescription.setKMSMasterKeyArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return sSEDescription;
    }

    public static SSEDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SSEDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
