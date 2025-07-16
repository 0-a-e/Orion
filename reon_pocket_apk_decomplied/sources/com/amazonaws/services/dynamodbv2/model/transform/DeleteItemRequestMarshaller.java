package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

public class DeleteItemRequestMarshaller implements Marshaller<Request<DeleteItemRequest>, DeleteItemRequest> {
    public Request<DeleteItemRequest> marshall(DeleteItemRequest deleteItemRequest) {
        if (deleteItemRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(deleteItemRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.DeleteItem");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (deleteItemRequest.getTableName() != null) {
                    String tableName = deleteItemRequest.getTableName();
                    jsonWriter.name("TableName");
                    jsonWriter.value(tableName);
                }
                if (deleteItemRequest.getKey() != null) {
                    Map<String, AttributeValue> key = deleteItemRequest.getKey();
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
                if (deleteItemRequest.getExpected() != null) {
                    Map<String, ExpectedAttributeValue> expected = deleteItemRequest.getExpected();
                    jsonWriter.name("Expected");
                    jsonWriter.beginObject();
                    for (Map.Entry next2 : expected.entrySet()) {
                        ExpectedAttributeValue expectedAttributeValue = (ExpectedAttributeValue) next2.getValue();
                        if (expectedAttributeValue != null) {
                            jsonWriter.name((String) next2.getKey());
                            ExpectedAttributeValueJsonMarshaller.getInstance().marshall(expectedAttributeValue, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (deleteItemRequest.getConditionalOperator() != null) {
                    String conditionalOperator = deleteItemRequest.getConditionalOperator();
                    jsonWriter.name("ConditionalOperator");
                    jsonWriter.value(conditionalOperator);
                }
                if (deleteItemRequest.getReturnValues() != null) {
                    String returnValues = deleteItemRequest.getReturnValues();
                    jsonWriter.name("ReturnValues");
                    jsonWriter.value(returnValues);
                }
                if (deleteItemRequest.getReturnConsumedCapacity() != null) {
                    String returnConsumedCapacity = deleteItemRequest.getReturnConsumedCapacity();
                    jsonWriter.name("ReturnConsumedCapacity");
                    jsonWriter.value(returnConsumedCapacity);
                }
                if (deleteItemRequest.getReturnItemCollectionMetrics() != null) {
                    String returnItemCollectionMetrics = deleteItemRequest.getReturnItemCollectionMetrics();
                    jsonWriter.name("ReturnItemCollectionMetrics");
                    jsonWriter.value(returnItemCollectionMetrics);
                }
                if (deleteItemRequest.getConditionExpression() != null) {
                    String conditionExpression = deleteItemRequest.getConditionExpression();
                    jsonWriter.name("ConditionExpression");
                    jsonWriter.value(conditionExpression);
                }
                if (deleteItemRequest.getExpressionAttributeNames() != null) {
                    Map<String, String> expressionAttributeNames = deleteItemRequest.getExpressionAttributeNames();
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
                if (deleteItemRequest.getExpressionAttributeValues() != null) {
                    Map<String, AttributeValue> expressionAttributeValues = deleteItemRequest.getExpressionAttributeValues();
                    jsonWriter.name("ExpressionAttributeValues");
                    jsonWriter.beginObject();
                    for (Map.Entry next4 : expressionAttributeValues.entrySet()) {
                        AttributeValue attributeValue2 = (AttributeValue) next4.getValue();
                        if (attributeValue2 != null) {
                            jsonWriter.name((String) next4.getKey());
                            AttributeValueJsonMarshaller.getInstance().marshall(attributeValue2, jsonWriter);
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
            throw new AmazonClientException("Invalid argument passed to marshall(DeleteItemRequest)");
        }
    }
}
