package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.LogConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.SetLogDeliveryConfigurationRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

public class SetLogDeliveryConfigurationRequestMarshaller implements Marshaller<Request<SetLogDeliveryConfigurationRequest>, SetLogDeliveryConfigurationRequest> {
    public Request<SetLogDeliveryConfigurationRequest> marshall(SetLogDeliveryConfigurationRequest setLogDeliveryConfigurationRequest) {
        if (setLogDeliveryConfigurationRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(setLogDeliveryConfigurationRequest, "AmazonCognitoIdentityProvider");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.SetLogDeliveryConfiguration");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (setLogDeliveryConfigurationRequest.getUserPoolId() != null) {
                    String userPoolId = setLogDeliveryConfigurationRequest.getUserPoolId();
                    jsonWriter.name("UserPoolId");
                    jsonWriter.value(userPoolId);
                }
                if (setLogDeliveryConfigurationRequest.getLogConfigurations() != null) {
                    List<LogConfigurationType> logConfigurations = setLogDeliveryConfigurationRequest.getLogConfigurations();
                    jsonWriter.name("LogConfigurations");
                    jsonWriter.beginArray();
                    for (LogConfigurationType next : logConfigurations) {
                        if (next != null) {
                            LogConfigurationTypeJsonMarshaller.getInstance().marshall(next, jsonWriter);
                        }
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
                jsonWriter.close();
                String stringWriter2 = stringWriter.toString();
                byte[] bytes = stringWriter2.getBytes(StringUtils.UTF8);
                defaultRequest.setContent(new StringInputStream(stringWriter2));
                defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
                if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
            }
        } else {
            throw new AmazonClientException("Invalid argument passed to marshall(SetLogDeliveryConfigurationRequest)");
        }
    }
}
