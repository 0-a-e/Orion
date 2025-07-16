package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBQueryExpression<T> {
    private String conditionalOperator;
    private boolean consistentRead = true;
    private Map<String, AttributeValue> exclusiveStartKey;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> expressionAttributeValues;
    private String filterExpression;
    private T hashKeyValues;
    private String indexName;
    private String keyConditionExpression;
    private Integer limit;
    private Map<String, Condition> queryFilter;
    private Map<String, Condition> rangeKeyConditions;
    private boolean scanIndexForward = true;

    public boolean isConsistentRead() {
        return this.consistentRead;
    }

    public void setConsistentRead(boolean z) {
        this.consistentRead = z;
    }

    public DynamoDBQueryExpression<T> withConsistentRead(boolean z) {
        this.consistentRead = z;
        return this;
    }

    public boolean isScanIndexForward() {
        return this.scanIndexForward;
    }

    public void setScanIndexForward(boolean z) {
        this.scanIndexForward = z;
    }

    public DynamoDBQueryExpression<T> withScanIndexForward(boolean z) {
        this.scanIndexForward = z;
        return this;
    }

    public Map<String, AttributeValue> getExclusiveStartKey() {
        return this.exclusiveStartKey;
    }

    public void setExclusiveStartKey(Map<String, AttributeValue> map) {
        this.exclusiveStartKey = map;
    }

    public DynamoDBQueryExpression<T> withExclusiveStartKey(Map<String, AttributeValue> map) {
        this.exclusiveStartKey = map;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public DynamoDBQueryExpression<T> withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public T getHashKeyValues() {
        return this.hashKeyValues;
    }

    public void setHashKeyValues(T t) {
        this.hashKeyValues = t;
    }

    public DynamoDBQueryExpression<T> withHashKeyValues(T t) {
        setHashKeyValues(t);
        return this;
    }

    public Map<String, Condition> getRangeKeyConditions() {
        return this.rangeKeyConditions;
    }

    public void setRangeKeyConditions(Map<String, Condition> map) {
        this.rangeKeyConditions = map;
    }

    public DynamoDBQueryExpression<T> withRangeKeyConditions(Map<String, Condition> map) {
        setRangeKeyConditions(map);
        return this;
    }

    public DynamoDBQueryExpression<T> withRangeKeyCondition(String str, Condition condition) {
        if (this.rangeKeyConditions == null) {
            this.rangeKeyConditions = new HashMap();
        }
        this.rangeKeyConditions.put(str, condition);
        return this;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public DynamoDBQueryExpression<T> withIndexName(String str) {
        setIndexName(str);
        return this;
    }

    public String getKeyConditionExpression() {
        return this.keyConditionExpression;
    }

    public void setKeyConditionExpression(String str) {
        this.keyConditionExpression = str;
    }

    public DynamoDBQueryExpression<T> withKeyConditionExpression(String str) {
        setKeyConditionExpression(str);
        return this;
    }

    public Map<String, Condition> getQueryFilter() {
        return this.queryFilter;
    }

    public void setQueryFilter(Map<String, Condition> map) {
        this.queryFilter = map;
    }

    public DynamoDBQueryExpression<T> withQueryFilter(Map<String, Condition> map) {
        setQueryFilter(map);
        return this;
    }

    public DynamoDBQueryExpression<T> withQueryFilterEntry(String str, Condition condition) {
        if (this.queryFilter == null) {
            this.queryFilter = new HashMap();
        }
        this.queryFilter.put(str, condition);
        return this;
    }

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    public void setConditionalOperator(String str) {
        this.conditionalOperator = str;
    }

    public DynamoDBQueryExpression<T> withConditionalOperator(String str) {
        setConditionalOperator(str);
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2.toString();
    }

    public DynamoDBQueryExpression<T> withConditionalOperator(ConditionalOperator conditionalOperator2) {
        setConditionalOperator(conditionalOperator2);
        return this;
    }

    public String getFilterExpression() {
        return this.filterExpression;
    }

    public void setFilterExpression(String str) {
        this.filterExpression = str;
    }

    public DynamoDBQueryExpression<T> withFilterExpression(String str) {
        this.filterExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public DynamoDBQueryExpression<T> withExpressionAttributeNames(Map<String, String> map) {
        setExpressionAttributeNames(map);
        return this;
    }

    public DynamoDBQueryExpression<T> addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (!this.expressionAttributeNames.containsKey(str)) {
            this.expressionAttributeNames.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DynamoDBQueryExpression<T> clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public Map<String, AttributeValue> getExpressionAttributeValues() {
        return this.expressionAttributeValues;
    }

    public void setExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
    }

    public DynamoDBQueryExpression<T> withExpressionAttributeValues(Map<String, AttributeValue> map) {
        setExpressionAttributeValues(map);
        return this;
    }

    public DynamoDBQueryExpression<T> addExpressionAttributeValuesEntry(String str, AttributeValue attributeValue) {
        if (this.expressionAttributeValues == null) {
            this.expressionAttributeValues = new HashMap();
        }
        if (!this.expressionAttributeValues.containsKey(str)) {
            this.expressionAttributeValues.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DynamoDBQueryExpression<T> clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }
}
