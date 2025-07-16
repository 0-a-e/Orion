package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.RotateKeyOnDemandResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class RotateKeyOnDemandResultJsonUnmarshaller implements Unmarshaller<RotateKeyOnDemandResult, JsonUnmarshallerContext> {
    private static RotateKeyOnDemandResultJsonUnmarshaller instance;

    public RotateKeyOnDemandResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        RotateKeyOnDemandResult rotateKeyOnDemandResult = new RotateKeyOnDemandResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("KeyId")) {
                rotateKeyOnDemandResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return rotateKeyOnDemandResult;
    }

    public static RotateKeyOnDemandResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RotateKeyOnDemandResultJsonUnmarshaller();
        }
        return instance;
    }
}
