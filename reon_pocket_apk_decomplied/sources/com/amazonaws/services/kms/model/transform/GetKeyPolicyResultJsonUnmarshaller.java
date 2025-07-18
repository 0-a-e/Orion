package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GetKeyPolicyResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GetKeyPolicyResultJsonUnmarshaller implements Unmarshaller<GetKeyPolicyResult, JsonUnmarshallerContext> {
    private static GetKeyPolicyResultJsonUnmarshaller instance;

    public GetKeyPolicyResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetKeyPolicyResult getKeyPolicyResult = new GetKeyPolicyResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Policy")) {
                getKeyPolicyResult.setPolicy(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PolicyName")) {
                getKeyPolicyResult.setPolicyName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getKeyPolicyResult;
    }

    public static GetKeyPolicyResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetKeyPolicyResultJsonUnmarshaller();
        }
        return instance;
    }
}
