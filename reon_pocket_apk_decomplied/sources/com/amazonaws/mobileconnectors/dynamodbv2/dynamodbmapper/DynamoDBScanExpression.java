package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBScanExpression {
    private String conditionalOperator;
    private Map<String, AttributeValue> exclusiveStartKey;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> expressionAttributeValues;
    private String filterExpression;
    private Integer limit;
    private Map<String, Condition> scanFilter;
    private Integer segment;
    private Integer totalSegments;

    public Map<String, Condition> getScanFilter() {
        return this.scanFilter;
    }

    public void setScanFilter(Map<String, Condition> map) {
        this.scanFilter = map;
    }

    public DynamoDBScanExpression withScanFilter(Map<String, Condition> map) {
        setScanFilter(map);
        return this;
    }

    public void addFilterCondition(String str, Condition condition) {
        if (this.scanFilter == null) {
            this.scanFilter = new HashMap();
        }
        this.scanFilter.put(str, condition);
    }

    public DynamoDBScanExpression withFilterConditionEntry(String str, Condition condition) {
        if (this.scanFilter == null) {
            this.scanFilter = new HashMap();
        }
        this.scanFilter.put(str, condition);
        return this;
    }

    public Map<String, AttributeValue> getExclusiveStartKey() {
        return this.exclusiveStartKey;
    }

    public void setExclusiveStartKey(Map<String, AttributeValue> map) {
        this.exclusiveStartKey = map;
    }

    public DynamoDBScanExpression withExclusiveStartKey(Map<String, AttributeValue> map) {
        this.exclusiveStartKey = map;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public DynamoDBScanExpression withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public Integer getTotalSegments() {
        return this.totalSegments;
    }

    public void setTotalSegments(Integer num) {
        this.totalSegments = num;
    }

    public DynamoDBScanExpression withTotalSegments(Integer num) {
        setTotalSegments(num);
        return this;
    }

    public Integer getSegment() {
        return this.segment;
    }

    public void setSegment(Integer num) {
        this.segment = num;
    }

    public DynamoDBScanExpression withSegment(Integer num) {
        setSegment(num);
        return this;
    }

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    public void setConditionalOperator(String str) {
        this.conditionalOperator = str;
    }

    public DynamoDBScanExpression withConditionalOperator(String str) {
        setConditionalOperator(str);
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator2) {
        setConditionalOperator(conditionalOperator2.toString());
    }

    public DynamoDBScanExpression withConditionalOperator(ConditionalOperator conditionalOperator2) {
        return withConditionalOperator(conditionalOperator2.toString());
    }

    public String getFilterExpression() {
        return this.filterExpression;
    }

    public void setFilterExpression(String str) {
        this.filterExpression = str;
    }

    public DynamoDBScanExpression withFilterExpression(String str) {
        this.filterExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public DynamoDBScanExpression withExpressionAttributeNames(Map<String, String> map) {
        setExpressionAttributeNames(map);
        return this;
    }

    public DynamoDBScanExpression addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (!this.expressionAttributeNames.containsKey(str)) {
            this.expressionAttributeNames.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DynamoDBScanExpression clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public Map<String, AttributeValue> getExpressionAttributeValues() {
        return this.expressionAttributeValues;
    }

    public void setExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
    }

    public DynamoDBScanExpression withExpressionAttributeValues(Map<String, AttributeValue> map) {
        setExpressionAttributeValues(map);
        return this;
    }

    public DynamoDBScanExpression addExpressionAttributeValuesEntry(String str, AttributeValue attributeValue) {
        if (this.expressionAttributeValues == null) {
            this.expressionAttributeValues = new HashMap();
        }
        if (!this.expressionAttributeValues.containsKey(str)) {
            this.expressionAttributeValues.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DynamoDBScanExpression clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }
}
