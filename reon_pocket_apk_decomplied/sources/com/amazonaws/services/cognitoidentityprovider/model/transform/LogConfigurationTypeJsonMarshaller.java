package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CloudWatchLogsConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.LogConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;

class LogConfigurationTypeJsonMarshaller {
    private static LogConfigurationTypeJsonMarshaller instance;

    LogConfigurationTypeJsonMarshaller() {
    }

    public void marshall(LogConfigurationType logConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (logConfigurationType.getLogLevel() != null) {
            String logLevel = logConfigurationType.getLogLevel();
            awsJsonWriter.name("LogLevel");
            awsJsonWriter.value(logLevel);
        }
        if (logConfigurationType.getEventSource() != null) {
            String eventSource = logConfigurationType.getEventSource();
            awsJsonWriter.name("EventSource");
            awsJsonWriter.value(eventSource);
        }
        if (logConfigurationType.getCloudWatchLogsConfiguration() != null) {
            CloudWatchLogsConfigurationType cloudWatchLogsConfiguration = logConfigurationType.getCloudWatchLogsConfiguration();
            awsJsonWriter.name("CloudWatchLogsConfiguration");
            CloudWatchLogsConfigurationTypeJsonMarshaller.getInstance().marshall(cloudWatchLogsConfiguration, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static LogConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new LogConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
