package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.DeriveSharedSecretResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DeriveSharedSecretResultJsonUnmarshaller implements Unmarshaller<DeriveSharedSecretResult, JsonUnmarshallerContext> {
    private static DeriveSharedSecretResultJsonUnmarshaller instance;

    public DeriveSharedSecretResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeriveSharedSecretResult deriveSharedSecretResult = new DeriveSharedSecretResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("KeyId")) {
                deriveSharedSecretResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SharedSecret")) {
                deriveSharedSecretResult.setSharedSecret(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("CiphertextForRecipient")) {
                deriveSharedSecretResult.setCiphertextForRecipient(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyAgreementAlgorithm")) {
                deriveSharedSecretResult.setKeyAgreementAlgorithm(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyOrigin")) {
                deriveSharedSecretResult.setKeyOrigin(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return deriveSharedSecretResult;
    }

    public static DeriveSharedSecretResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeriveSharedSecretResultJsonUnmarshaller();
        }
        return instance;
    }
}
