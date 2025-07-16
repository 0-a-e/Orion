package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class ScanRequestMarshaller implements Marshaller<Request<ScanRequest>, ScanRequest> {
    public Request<ScanRequest> marshall(ScanRequest scanRequest) {
        if (scanRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(scanRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.Scan");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (scanRequest.getTableName() != null) {
                    String tableName = scanRequest.getTableName();
                    jsonWriter.name("TableName");
                    jsonWriter.value(tableName);
                }
                if (scanRequest.getIndexName() != null) {
                    String indexName = scanRequest.getIndexName();
                    jsonWriter.name("IndexName");
                    jsonWriter.value(indexName);
                }
                if (scanRequest.getAttributesToGet() != null) {
                    List<String> attributesToGet = scanRequest.getAttributesToGet();
                    jsonWriter.name("AttributesToGet");
                    jsonWriter.beginArray();
                    for (String next : attributesToGet) {
                        if (next != null) {
                            jsonWriter.value(next);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (scanRequest.getLimit() != null) {
                    Integer limit = scanRequest.getLimit();
                    jsonWriter.name("Limit");
                    jsonWriter.value((Number) limit);
                }
                if (scanRequest.getSelect() != null) {
                    String select = scanRequest.getSelect();
                    jsonWriter.name("Select");
                    jsonWriter.value(select);
                }
                if (scanRequest.getScanFilter() != null) {
                    Map<String, Condition> scanFilter = scanRequest.getScanFilter();
                    jsonWriter.name("ScanFilter");
                    jsonWriter.beginObject();
                    for (Map.Entry next2 : scanFilter.entrySet()) {
                        Condition condition = (Condition) next2.getValue();
                        if (condition != null) {
                            jsonWriter.name((String) next2.getKey());
                            ConditionJsonMarshaller.getInstance().marshall(condition, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (scanRequest.getConditionalOperator() != null) {
                    String conditionalOperator = scanRequest.getConditionalOperator();
                    jsonWriter.name("ConditionalOperator");
                    jsonWriter.value(conditionalOperator);
                }
                if (scanRequest.getExclusiveStartKey() != null) {
                    Map<String, AttributeValue> exclusiveStartKey = scanRequest.getExclusiveStartKey();
                    jsonWriter.name("ExclusiveStartKey");
                    jsonWriter.beginObject();
                    for (Map.Entry next3 : exclusiveStartKey.entrySet()) {
                        AttributeValue attributeValue = (AttributeValue) next3.getValue();
                        if (attributeValue != null) {
                            jsonWriter.name((String) next3.getKey());
                            AttributeValueJsonMarshaller.getInstance().marshall(attributeValue, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (scanRequest.getReturnConsumedCapacity() != null) {
                    String returnConsumedCapacity = scanRequest.getReturnConsumedCapacity();
                    jsonWriter.name("ReturnConsumedCapacity");
                    jsonWriter.value(returnConsumedCapacity);
                }
                if (scanRequest.getTotalSegments() != null) {
                    Integer totalSegments = scanRequest.getTotalSegments();
                    jsonWriter.name("TotalSegments");
                    jsonWriter.value((Number) totalSegments);
                }
                if (scanRequest.getSegment() != null) {
                    Integer segment = scanRequest.getSegment();
                    jsonWriter.name("Segment");
                    jsonWriter.value((Number) segment);
                }
                if (scanRequest.getProjectionExpression() != null) {
                    String projectionExpression = scanRequest.getProjectionExpression();
                    jsonWriter.name("ProjectionExpression");
                    jsonWriter.value(projectionExpression);
                }
                if (scanRequest.getFilterExpression() != null) {
                    String filterExpression = scanRequest.getFilterExpression();
                    jsonWriter.name("FilterExpression");
                    jsonWriter.value(filterExpression);
                }
                if (scanRequest.getExpressionAttributeNames() != null) {
                    Map<String, String> expressionAttributeNames = scanRequest.getExpressionAttributeNames();
                    jsonWriter.name("ExpressionAttributeNames");
                    jsonWriter.beginObject();
                    for (Map.Entry next4 : expressionAttributeNames.entrySet()) {
                        String str = (String) next4.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next4.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (scanRequest.getExpressionAttributeValues() != null) {
                    Map<String, AttributeValue> expressionAttributeValues = scanRequest.getExpressionAttributeValues();
                    jsonWriter.name("ExpressionAttributeValues");
                    jsonWriter.beginObject();
                    for (Map.Entry next5 : expressionAttributeValues.entrySet()) {
                        AttributeValue attributeValue2 = (AttributeValue) next5.getValue();
                        if (attributeValue2 != null) {
                            jsonWriter.name((String) next5.getKey());
                            AttributeValueJsonMarshaller.getInstance().marshall(attributeValue2, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (scanRequest.getConsistentRead() != null) {
                    Boolean consistentRead = scanRequest.getConsistentRead();
                    jsonWriter.name("ConsistentRead");
                    jsonWriter.value(consistentRead.booleanValue());
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
            throw new AmazonClientException("Invalid argument passed to marshall(ScanRequest)");
        }
    }
}
