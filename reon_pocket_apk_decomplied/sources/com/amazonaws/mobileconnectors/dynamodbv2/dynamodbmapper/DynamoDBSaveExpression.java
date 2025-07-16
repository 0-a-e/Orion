package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBSaveExpression {
    private String conditionalOperator;
    private Map<String, ExpectedAttributeValue> expectedAttributes;

    public Map<String, ExpectedAttributeValue> getExpected() {
        return this.expectedAttributes;
    }

    public void setExpected(Map<String, ExpectedAttributeValue> map) {
        this.expectedAttributes = map;
    }

    public DynamoDBSaveExpression withExpected(Map<String, ExpectedAttributeValue> map) {
        setExpected(map);
        return this;
    }

    public DynamoDBSaveExpression withExpectedEntry(String str, ExpectedAttributeValue expectedAttributeValue) {
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

    public DynamoDBSaveExpression withConditionalOperator(String str) {
        setConditionalOperator(str);
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator2) {
        setConditionalOperator(conditionalOperator2.toString());
    }

    public DynamoDBSaveExpression withConditionalOperator(ConditionalOperator conditionalOperator2) {
        return withConditionalOperator(conditionalOperator2.toString());
    }
}
