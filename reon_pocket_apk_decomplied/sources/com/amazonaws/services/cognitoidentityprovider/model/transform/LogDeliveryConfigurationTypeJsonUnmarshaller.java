package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.LogDeliveryConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class LogDeliveryConfigurationTypeJsonUnmarshaller implements Unmarshaller<LogDeliveryConfigurationType, JsonUnmarshallerContext> {
    private static LogDeliveryConfigurationTypeJsonUnmarshaller instance;

    LogDeliveryConfigurationTypeJsonUnmarshaller() {
    }

    public LogDeliveryConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        LogDeliveryConfigurationType logDeliveryConfigurationType = new LogDeliveryConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("UserPoolId")) {
                logDeliveryConfigurationType.setUserPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LogConfigurations")) {
                logDeliveryConfigurationType.setLogConfigurations(new ListUnmarshaller(LogConfigurationTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return logDeliveryConfigurationType;
    }

    public static LogDeliveryConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LogDeliveryConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
