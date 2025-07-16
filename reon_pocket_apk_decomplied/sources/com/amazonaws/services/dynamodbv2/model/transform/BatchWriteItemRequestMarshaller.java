package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class BatchWriteItemRequestMarshaller implements Marshaller<Request<BatchWriteItemRequest>, BatchWriteItemRequest> {
    public Request<BatchWriteItemRequest> marshall(BatchWriteItemRequest batchWriteItemRequest) {
        if (batchWriteItemRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(batchWriteItemRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.BatchWriteItem");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (batchWriteItemRequest.getRequestItems() != null) {
                    Map<String, List<WriteRequest>> requestItems = batchWriteItemRequest.getRequestItems();
                    jsonWriter.name("RequestItems");
                    jsonWriter.beginObject();
                    for (Map.Entry next : requestItems.entrySet()) {
                        List<WriteRequest> list = (List) next.getValue();
                        if (list != null) {
                            jsonWriter.name((String) next.getKey());
                            jsonWriter.beginArray();
                            for (WriteRequest writeRequest : list) {
                                if (writeRequest != null) {
                                    WriteRequestJsonMarshaller.getInstance().marshall(writeRequest, jsonWriter);
                                }
                            }
                            jsonWriter.endArray();
                        }
                    }
                    jsonWriter.endObject();
                }
                if (batchWriteItemRequest.getReturnConsumedCapacity() != null) {
                    String returnConsumedCapacity = batchWriteItemRequest.getReturnConsumedCapacity();
                    jsonWriter.name("ReturnConsumedCapacity");
                    jsonWriter.value(returnConsumedCapacity);
                }
                if (batchWriteItemRequest.getReturnItemCollectionMetrics() != null) {
                    String returnItemCollectionMetrics = batchWriteItemRequest.getReturnItemCollectionMetrics();
                    jsonWriter.name("ReturnItemCollectionMetrics");
                    jsonWriter.value(returnItemCollectionMetrics);
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
            throw new AmazonClientException("Invalid argument passed to marshall(BatchWriteItemRequest)");
        }
    }
}
