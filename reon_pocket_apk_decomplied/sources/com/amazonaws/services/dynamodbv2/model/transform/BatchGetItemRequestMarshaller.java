package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

public class BatchGetItemRequestMarshaller implements Marshaller<Request<BatchGetItemRequest>, BatchGetItemRequest> {
    public Request<BatchGetItemRequest> marshall(BatchGetItemRequest batchGetItemRequest) {
        if (batchGetItemRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(batchGetItemRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.BatchGetItem");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (batchGetItemRequest.getRequestItems() != null) {
                    Map<String, KeysAndAttributes> requestItems = batchGetItemRequest.getRequestItems();
                    jsonWriter.name("RequestItems");
                    jsonWriter.beginObject();
                    for (Map.Entry next : requestItems.entrySet()) {
                        KeysAndAttributes keysAndAttributes = (KeysAndAttributes) next.getValue();
                        if (keysAndAttributes != null) {
                            jsonWriter.name((String) next.getKey());
                            KeysAndAttributesJsonMarshaller.getInstance().marshall(keysAndAttributes, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (batchGetItemRequest.getReturnConsumedCapacity() != null) {
                    String returnConsumedCapacity = batchGetItemRequest.getReturnConsumedCapacity();
                    jsonWriter.name("ReturnConsumedCapacity");
                    jsonWriter.value(returnConsumedCapacity);
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
            throw new AmazonClientException("Invalid argument passed to marshall(BatchGetItemRequest)");
        }
    }
}
