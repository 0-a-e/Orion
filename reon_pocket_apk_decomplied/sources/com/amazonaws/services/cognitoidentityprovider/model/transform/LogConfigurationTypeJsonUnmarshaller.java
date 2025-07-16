package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.LogConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class LogConfigurationTypeJsonUnmarshaller implements Unmarshaller<LogConfigurationType, JsonUnmarshallerContext> {
    private static LogConfigurationTypeJsonUnmarshaller instance;

    LogConfigurationTypeJsonUnmarshaller() {
    }

    public LogConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        LogConfigurationType logConfigurationType = new LogConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("LogLevel")) {
                logConfigurationType.setLogLevel(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("EventSource")) {
                logConfigurationType.setEventSource(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("CloudWatchLogsConfiguration")) {
                logConfigurationType.setCloudWatchLogsConfiguration(CloudWatchLogsConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return logConfigurationType;
    }

    public static LogConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LogConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
