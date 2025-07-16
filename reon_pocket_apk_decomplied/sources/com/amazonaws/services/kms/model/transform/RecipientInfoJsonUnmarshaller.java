package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.RecipientInfo;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class RecipientInfoJsonUnmarshaller implements Unmarshaller<RecipientInfo, JsonUnmarshallerContext> {
    private static RecipientInfoJsonUnmarshaller instance;

    RecipientInfoJsonUnmarshaller() {
    }

    public RecipientInfo unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        RecipientInfo recipientInfo = new RecipientInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("KeyEncryptionAlgorithm")) {
                recipientInfo.setKeyEncryptionAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AttestationDocument")) {
                recipientInfo.setAttestationDocument(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return recipientInfo;
    }

    public static RecipientInfoJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RecipientInfoJsonUnmarshaller();
        }
        return instance;
    }
}
