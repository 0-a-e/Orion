package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GenerateRandomResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GenerateRandomResultJsonUnmarshaller implements Unmarshaller<GenerateRandomResult, JsonUnmarshallerContext> {
    private static GenerateRandomResultJsonUnmarshaller instance;

    public GenerateRandomResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GenerateRandomResult generateRandomResult = new GenerateRandomResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Plaintext")) {
                generateRandomResult.setPlaintext(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("CiphertextForRecipient")) {
                generateRandomResult.setCiphertextForRecipient(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return generateRandomResult;
    }

    public static GenerateRandomResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GenerateRandomResultJsonUnmarshaller();
        }
        return instance;
    }
}
