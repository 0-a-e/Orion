package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SetLogDeliveryConfigurationResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class SetLogDeliveryConfigurationResultJsonUnmarshaller implements Unmarshaller<SetLogDeliveryConfigurationResult, JsonUnmarshallerContext> {
    private static SetLogDeliveryConfigurationResultJsonUnmarshaller instance;

    public SetLogDeliveryConfigurationResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        SetLogDeliveryConfigurationResult setLogDeliveryConfigurationResult = new SetLogDeliveryConfigurationResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("LogDeliveryConfiguration")) {
                setLogDeliveryConfigurationResult.setLogDeliveryConfiguration(LogDeliveryConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return setLogDeliveryConfigurationResult;
    }

    public static SetLogDeliveryConfigurationResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetLogDeliveryConfigurationResultJsonUnmarshaller();
        }
        return instance;
    }
}
