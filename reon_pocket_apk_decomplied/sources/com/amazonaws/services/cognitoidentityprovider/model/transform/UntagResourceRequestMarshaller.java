package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.UntagResourceRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

public class UntagResourceRequestMarshaller implements Marshaller<Request<UntagResourceRequest>, UntagResourceRequest> {
    public Request<UntagResourceRequest> marshall(UntagResourceRequest untagResourceRequest) {
        if (untagResourceRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(untagResourceRequest, "AmazonCognitoIdentityProvider");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UntagResource");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (untagResourceRequest.getResourceArn() != null) {
                    String resourceArn = untagResourceRequest.getResourceArn();
                    jsonWriter.name("ResourceArn");
                    jsonWriter.value(resourceArn);
                }
                if (untagResourceRequest.getTagKeys() != null) {
                    List<String> tagKeys = untagResourceRequest.getTagKeys();
                    jsonWriter.name("TagKeys");
                    jsonWriter.beginArray();
                    for (String next : tagKeys) {
                        if (next != null) {
                            jsonWriter.value(next);
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
            throw new AmazonClientException("Invalid argument passed to marshall(UntagResourceRequest)");
        }
    }
}
