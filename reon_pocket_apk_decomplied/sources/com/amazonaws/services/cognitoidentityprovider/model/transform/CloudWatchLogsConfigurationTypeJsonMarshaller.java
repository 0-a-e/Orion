package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CloudWatchLogsConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;

class CloudWatchLogsConfigurationTypeJsonMarshaller {
    private static CloudWatchLogsConfigurationTypeJsonMarshaller instance;

    CloudWatchLogsConfigurationTypeJsonMarshaller() {
    }

    public void marshall(CloudWatchLogsConfigurationType cloudWatchLogsConfigurationType, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (cloudWatchLogsConfigurationType.getLogGroupArn() != null) {
            String logGroupArn = cloudWatchLogsConfigurationType.getLogGroupArn();
            awsJsonWriter.name("LogGroupArn");
            awsJsonWriter.value(logGroupArn);
        }
        awsJsonWriter.endObject();
    }

    public static CloudWatchLogsConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CloudWatchLogsConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
