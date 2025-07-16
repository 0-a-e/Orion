package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.LogConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.LogDeliveryConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class LogDeliveryConfigurationTypeJsonMarshaller {
    private static LogDeliveryConfigurationTypeJsonMarshaller instance;

    LogDeliveryConfigurationTypeJsonMarshaller() {
    }

    public void marshall(LogDeliveryConfigurationType logDeliveryConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (logDeliveryConfigurationType.getUserPoolId() != null) {
            String userPoolId = logDeliveryConfigurationType.getUserPoolId();
            awsJsonWriter.name("UserPoolId");
            awsJsonWriter.value(userPoolId);
        }
        if (logDeliveryConfigurationType.getLogConfigurations() != null) {
            List<LogConfigurationType> logConfigurations = logDeliveryConfigurationType.getLogConfigurations();
            awsJsonWriter.name("LogConfigurations");
            awsJsonWriter.beginArray();
            for (LogConfigurationType next : logConfigurations) {
                if (next != null) {
                    LogConfigurationTypeJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static LogDeliveryConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new LogDeliveryConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
