package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

public class AssociateSoftwareTokenRequestMarshaller implements Marshaller<Request<AssociateSoftwareTokenRequest>, AssociateSoftwareTokenRequest> {
    public Request<AssociateSoftwareTokenRequest> marshall(AssociateSoftwareTokenRequest associateSoftwareTokenRequest) {
        if (associateSoftwareTokenRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(associateSoftwareTokenRequest, "AmazonCognitoIdentityProvider");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AssociateSoftwareToken");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (associateSoftwareTokenRequest.getAccessToken() != null) {
                    String accessToken = associateSoftwareTokenRequest.getAccessToken();
                    jsonWriter.name("AccessToken");
                    jsonWriter.value(accessToken);
                }
                if (associateSoftwareTokenRequest.getSession() != null) {
                    String session = associateSoftwareTokenRequest.getSession();
                    jsonWriter.name("Session");
                    jsonWriter.value(session);
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
            throw new AmazonClientException("Invalid argument passed to marshall(AssociateSoftwareTokenRequest)");
        }
    }
}
