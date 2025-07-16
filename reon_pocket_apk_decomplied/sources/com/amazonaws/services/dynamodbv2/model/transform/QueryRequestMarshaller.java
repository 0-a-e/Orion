package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class QueryRequestMarshaller implements Marshaller<Request<QueryRequest>, QueryRequest> {
    public Request<QueryRequest> marshall(QueryRequest queryRequest) {
        if (queryRequest != null) {
            DefaultRequest defaultRequest = new DefaultRequest(queryRequest, "AmazonDynamoDB");
            defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20120810.Query");
            defaultRequest.setHttpMethod(HttpMethodName.POST);
            defaultRequest.setResourcePath("/");
            try {
                StringWriter stringWriter = new StringWriter();
                AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
                jsonWriter.beginObject();
                if (queryRequest.getTableName() != null) {
                    String tableName = queryRequest.getTableName();
                    jsonWriter.name("TableName");
                    jsonWriter.value(tableName);
                }
                if (queryRequest.getIndexName() != null) {
                    String indexName = queryRequest.getIndexName();
                    jsonWriter.name("IndexName");
                    jsonWriter.value(indexName);
                }
                if (queryRequest.getSelect() != null) {
                    String select = queryRequest.getSelect();
                    jsonWriter.name("Select");
                    jsonWriter.value(select);
                }
                if (queryRequest.getAttributesToGet() != null) {
                    List<String> attributesToGet = queryRequest.getAttributesToGet();
                    jsonWriter.name("AttributesToGet");
                    jsonWriter.beginArray();
                    for (String next : attributesToGet) {
                        if (next != null) {
                            jsonWriter.value(next);
                        }
                    }
                    jsonWriter.endArray();
                }
                if (queryRequest.getLimit() != null) {
                    Integer limit = queryRequest.getLimit();
                    jsonWriter.name("Limit");
                    jsonWriter.value((Number) limit);
                }
                if (queryRequest.getConsistentRead() != null) {
                    Boolean consistentRead = queryRequest.getConsistentRead();
                    jsonWriter.name("ConsistentRead");
                    jsonWriter.value(consistentRead.booleanValue());
                }
                if (queryRequest.getKeyConditions() != null) {
                    Map<String, Condition> keyConditions = queryRequest.getKeyConditions();
                    jsonWriter.name("KeyConditions");
                    jsonWriter.beginObject();
                    for (Map.Entry next2 : keyConditions.entrySet()) {
                        Condition condition = (Condition) next2.getValue();
                        if (condition != null) {
                            jsonWriter.name((String) next2.getKey());
                            ConditionJsonMarshaller.getInstance().marshall(condition, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (queryRequest.getQueryFilter() != null) {
                    Map<String, Condition> queryFilter = queryRequest.getQueryFilter();
                    jsonWriter.name("QueryFilter");
                    jsonWriter.beginObject();
                    for (Map.Entry next3 : queryFilter.entrySet()) {
                        Condition condition2 = (Condition) next3.getValue();
                        if (condition2 != null) {
                            jsonWriter.name((String) next3.getKey());
                            ConditionJsonMarshaller.getInstance().marshall(condition2, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (queryRequest.getConditionalOperator() != null) {
                    String conditionalOperator = queryRequest.getConditionalOperator();
                    jsonWriter.name("ConditionalOperator");
                    jsonWriter.value(conditionalOperator);
                }
                if (queryRequest.getScanIndexForward() != null) {
                    Boolean scanIndexForward = queryRequest.getScanIndexForward();
                    jsonWriter.name("ScanIndexForward");
                    jsonWriter.value(scanIndexForward.booleanValue());
                }
                if (queryRequest.getExclusiveStartKey() != null) {
                    Map<String, AttributeValue> exclusiveStartKey = queryRequest.getExclusiveStartKey();
                    jsonWriter.name("ExclusiveStartKey");
                    jsonWriter.beginObject();
                    for (Map.Entry next4 : exclusiveStartKey.entrySet()) {
                        AttributeValue attributeValue = (AttributeValue) next4.getValue();
                        if (attributeValue != null) {
                            jsonWriter.name((String) next4.getKey());
                            AttributeValueJsonMarshaller.getInstance().marshall(attributeValue, jsonWriter);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (queryRequest.getReturnConsumedCapacity() != null) {
                    String returnConsumedCapacity = queryRequest.getReturnConsumedCapacity();
                    jsonWriter.name("ReturnConsumedCapacity");
                    jsonWriter.value(returnConsumedCapacity);
                }
                if (queryRequest.getProjectionExpression() != null) {
                    String projectionExpression = queryRequest.getProjectionExpression();
                    jsonWriter.name("ProjectionExpression");
                    jsonWriter.value(projectionExpression);
                }
                if (queryRequest.getFilterExpression() != null) {
                    String filterExpression = queryRequest.getFilterExpression();
                    jsonWriter.name("FilterExpression");
                    jsonWriter.value(filterExpression);
                }
                if (queryRequest.getKeyConditionExpression() != null) {
                    String keyConditionExpression = queryRequest.getKeyConditionExpression();
                    jsonWriter.name("KeyConditionExpression");
                    jsonWriter.value(keyConditionExpression);
                }
                if (queryRequest.getExpressionAttributeNames() != null) {
                    Map<String, String> expressionAttributeNames = queryRequest.getExpressionAttributeNames();
                    jsonWriter.name("ExpressionAttributeNames");
                    jsonWriter.beginObject();
                    for (Map.Entry next5 : expressionAttributeNames.entrySet()) {
                        String str = (String) next5.getValue();
                        if (str != null) {
                            jsonWriter.name((String) next5.getKey());
                            jsonWriter.value(str);
                        }
                    }
                    jsonWriter.endObject();
                }
                if (queryRequest.getExpressionAttributeValues() != null) {
                    Map<String, AttributeValue> expressionAttributeValues = queryRequest.getExpressionAttributeValues();
                    jsonWriter.name("ExpressionAttributeValues");
                    jsonWriter.beginObject();
                    for (Map.Entry next6 : expressionAttributeValues.entrySet()) {
                        AttributeValue attributeValue2 = (AttributeValue) next6.getValue();
                        if (attributeValue2 != null) {
                            jsonWriter.name((String) next6.getKey());
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
            throw new AmazonClientException("Invalid argument passed to marshall(QueryRequest)");
        }
    }
}
