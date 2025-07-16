package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.GetKeyRotationStatusResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GetKeyRotationStatusResultJsonUnmarshaller implements Unmarshaller<GetKeyRotationStatusResult, JsonUnmarshallerContext> {
    private static GetKeyRotationStatusResultJsonUnmarshaller instance;

    public GetKeyRotationStatusResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetKeyRotationStatusResult getKeyRotationStatusResult = new GetKeyRotationStatusResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("KeyRotationEnabled")) {
                getKeyRotationStatusResult.setKeyRotationEnabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeyId")) {
                getKeyRotationStatusResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RotationPeriodInDays")) {
                getKeyRotationStatusResult.setRotationPeriodInDays(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("NextRotationDate")) {
                getKeyRotationStatusResult.setNextRotationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("OnDemandRotationStartDate")) {
                getKeyRotationStatusResult.setOnDemandRotationStartDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getKeyRotationStatusResult;
    }

    public static GetKeyRotationStatusResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetKeyRotationStatusResultJsonUnmarshaller();
        }
        return instance;
    }
}
