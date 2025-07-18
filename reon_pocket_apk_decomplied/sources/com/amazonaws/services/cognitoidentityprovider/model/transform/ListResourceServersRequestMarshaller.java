package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.ListResourceServersRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

public class ListResourceServersRequestMarshaller implements Marshaller<Request<ListResourceServersRequest>, ListResourceServersRequest> {
    public Request<ListResourceServersRequest> marshall(ListResourceServersRequest listResourceServersRequest) {
        if (listResourceServersRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(listResourceServersRequest, "AmazonCognitoIdentityProvider");
            defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.ListResourceServers");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (listResourceServersRequest.getUserPoolId() != null) {
                    String userPoolId = listResourceServersRequest.getUserPoolId();
                    jsonWriter.name("UserPoolId");
                    jsonWriter.value(userPoolId);
                }
                if (listResourceServersRequest.getMaxResults() != null) {
                    Integer maxResults = listResourceServersRequest.getMaxResults();
                    jsonWriter.name("MaxResults");
                    jsonWriter.value((Number) maxResults);
                }
                if (listResourceServersRequest.getNextToken() != null) {
                    String nextToken = listResourceServersRequest.getNextToken();
                    jsonWriter.name("NextToken");
                    jsonWriter.value(nextToken);
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
            throw new AmazonClientException("Invalid argument passed to marshall(ListResourceServersRequest)");
        }
    }
}
