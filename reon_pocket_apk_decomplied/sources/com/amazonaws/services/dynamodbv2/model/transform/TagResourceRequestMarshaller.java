package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.Tag;
import com.amazonaws.services.dynamodbv2.model.TagResourceRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

public class TagResourceRequestMarshaller implements Marshaller<Request<TagResourceRequest>, TagResourceRequest> {
    public Request<TagResourceRequest> marshall(TagResourceRequest tagResourceRequest) {
        if (tagResourceRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(tagResourceRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.TagResource");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (tagResourceRequest.getResourceArn() != null) {
                    String resourceArn = tagResourceRequest.getResourceArn();
                    jsonWriter.name("ResourceArn");
                    jsonWriter.value(resourceArn);
                }
                if (tagResourceRequest.getTags() != null) {
                    List<Tag> tags = tagResourceRequest.getTags();
                    jsonWriter.name("Tags");
                    jsonWriter.beginArray();
                    for (Tag next : tags) {
                        if (next != null) {
                            TagJsonMarshaller.getInstance().marshall(next, jsonWriter);
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
                    defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.0");
                }
                return defaultRequest;
            } catch (Throwable th) {
                throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
            }
        } else {
            throw new AmazonClientException("Invalid argument passed to marshall(TagResourceRequest)");
        }
    }
}
