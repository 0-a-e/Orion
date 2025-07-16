package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class GetItemRequestMarshaller implements Marshaller<Request<GetItemRequest>, GetItemRequest> {
    public Request<GetItemRequest> marshall(GetItemRequest getItemRequest) {
        if (getItemRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(getItemRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.GetItem");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (getItemRequest.getTableName() != null) {
                    String tableName = getItemRequest.getTableName();
                    jsonWriter.name("TableName");
                    jsonWriter.value(tableName);
                }
                if (getItemRequest.getKey() != null) {
                    Map<String, AttributeValue> key = getItemRequest.getKey();
                    jsonWriter.name("Key");
                    jsonWriter.beginObject();
                    for (Map.Entry next : key.entrySet()) {
                        AttributeValue attributeValue = (AttributeValue) next.getValue();
                        if (attributeValue != null) {
                            jsonWriter.name((String) next.getKey());
                            AttributeValueJsonMarshaller.getInstance().marshall(attributeValue, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (getItemRequest.getAttributesToGet() != null) {
                    List<String> attributesToGet = getItemRequest.getAttributesToGet();
                    jsonWriter.name("AttributesToGet");
                    jsonWriter.beginArray();
                    for (String next2 : attributesToGet) {
                        if (next2 != null) {
                            jsonWriter.value(next2);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (getItemRequest.getConsistentRead() != null) {
                    Boolean consistentRead = getItemRequest.getConsistentRead();
                    jsonWriter.name("ConsistentRead");
                    jsonWriter.value(consistentRead.booleanValue());
                }
                if (getItemRequest.getReturnConsumedCapacity() != null) {
                    String returnConsumedCapacity = getItemRequest.getReturnConsumedCapacity();
                    jsonWriter.name("ReturnConsumedCapacity");
                    jsonWriter.value(returnConsumedCapacity);
                }
                if (getItemRequest.getProjectionExpression() != null) {
                    String projectionExpression = getItemRequest.getProjectionExpression();
                    jsonWriter.name("ProjectionExpression");
                    jsonWriter.value(projectionExpression);
                }
                if (getItemRequest.getExpressionAttributeNames() != null) {
                    Map<String, String> expressionAttributeNames = getItemRequest.getExpressionAttributeNames();
                    jsonWriter.name("ExpressionAttributeNames");
                    jsonWriter.beginObject();
                    for (Map.Entry next3 : expressionAttributeNames.entrySet()) {
                        String str = (String) next3.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next3.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
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
            throw new AmazonClientException("Invalid argument passed to marshall(GetItemRequest)");
        }
    }
}
