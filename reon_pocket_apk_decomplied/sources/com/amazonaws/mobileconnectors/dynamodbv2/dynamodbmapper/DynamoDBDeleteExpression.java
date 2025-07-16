package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBDeleteExpression {
    private String conditionExpression;
    private String conditionalOperator;
    private Map<String, ExpectedAttributeValue> expectedAttributes;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> expressionAttributeValues;

    public Map<String, ExpectedAttributeValue> getExpected() {
        return this.expectedAttributes;
    }

    public void setExpected(Map<String, ExpectedAttributeValue> map) {
        this.expectedAttributes = map;
    }

    public DynamoDBDeleteExpression withExpected(Map<String, ExpectedAttributeValue> map) {
        setExpected(map);
        return this;
    }

    public DynamoDBDeleteExpression withExpectedEntry(String str, ExpectedAttributeValue expectedAttributeValue) {
        if (this.expectedAttributes == null) {
            this.expectedAttributes = new HashMap();
        }
        this.expectedAttributes.put(str, expectedAttributeValue);
        return this;
    }

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    public void setConditionalOperator(String str) {
        this.conditionalOperator = str;
    }

    public DynamoDBDeleteExpression withConditionalOperator(String str) {
        setConditionalOperator(str);
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator2) {
        setConditionalOperator(conditionalOperator2.toString());
    }

    public DynamoDBDeleteExpression withConditionalOperator(ConditionalOperator conditionalOperator2) {
        return withConditionalOperator(conditionalOperator2.toString());
    }

    public String getConditionExpression() {
        return this.conditionExpression;
    }

    public void setConditionExpression(String str) {
        this.conditionExpression = str;
    }

    public DynamoDBDeleteExpression withConditionExpression(String str) {
        this.conditionExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public DynamoDBDeleteExpression withExpressionAttributeNames(Map<String, String> map) {
        setExpressionAttributeNames(map);
        return this;
    }

    public DynamoDBDeleteExpression addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (!this.expressionAttributeNames.containsKey(str)) {
            this.expressionAttributeNames.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DynamoDBDeleteExpression clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public Map<String, AttributeValue> getExpressionAttributeValues() {
        return this.expressionAttributeValues;
    }

    public void setExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
    }

    public DynamoDBDeleteExpression withExpressionAttributeValues(Map<String, AttributeValue> map) {
        setExpressionAttributeValues(map);
        return this;
    }

    public DynamoDBDeleteExpression addExpressionAttributeValuesEntry(String str, AttributeValue attributeValue) {
        if (this.expressionAttributeValues == null) {
            this.expressionAttributeValues = new HashMap();
        }
        if (!this.expressionAttributeValues.containsKey(str)) {
            this.expressionAttributeValues.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DynamoDBDeleteExpression clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }
}
