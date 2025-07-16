package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DeleteItemRequest extends AmazonWebServiceRequest implements Serializable {
    private String conditionExpression;
    private String conditionalOperator;
    private Map<String, ExpectedAttributeValue> expected;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> expressionAttributeValues;
    private Map<String, AttributeValue> key;
    private String returnConsumedCapacity;
    private String returnItemCollectionMetrics;
    private String returnValues;
    private String tableName;

    public DeleteItemRequest() {
    }

    public DeleteItemRequest(String str, Map<String, AttributeValue> map) {
        setTableName(str);
        setKey(map);
    }

    public DeleteItemRequest(String str, Map<String, AttributeValue> map, String str2) {
        setTableName(str);
        setKey(map);
        setReturnValues(str2);
    }

    public DeleteItemRequest(String str, Map<String, AttributeValue> map, ReturnValue returnValue) {
        setTableName(str);
        setKey(map);
        setReturnValues(returnValue.toString());
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public DeleteItemRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public Map<String, AttributeValue> getKey() {
        return this.key;
    }

    public void setKey(Map<String, AttributeValue> map) {
        this.key = map;
    }

    public DeleteItemRequest withKey(Map<String, AttributeValue> map) {
        this.key = map;
        return this;
    }

    public DeleteItemRequest addKeyEntry(String str, AttributeValue attributeValue) {
        if (this.key == null) {
            this.key = new HashMap();
        }
        if (!this.key.containsKey(str)) {
            this.key.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DeleteItemRequest clearKeyEntries() {
        this.key = null;
        return this;
    }

    public Map<String, ExpectedAttributeValue> getExpected() {
        return this.expected;
    }

    public void setExpected(Map<String, ExpectedAttributeValue> map) {
        this.expected = map;
    }

    public DeleteItemRequest withExpected(Map<String, ExpectedAttributeValue> map) {
        this.expected = map;
        return this;
    }

    public DeleteItemRequest addExpectedEntry(String str, ExpectedAttributeValue expectedAttributeValue) {
        if (this.expected == null) {
            this.expected = new HashMap();
        }
        if (!this.expected.containsKey(str)) {
            this.expected.put(str, expectedAttributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DeleteItemRequest clearExpectedEntries() {
        this.expected = null;
        return this;
    }

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    public void setConditionalOperator(String str) {
        this.conditionalOperator = str;
    }

    public DeleteItemRequest withConditionalOperator(String str) {
        this.conditionalOperator = str;
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2.toString();
    }

    public DeleteItemRequest withConditionalOperator(ConditionalOperator conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2.toString();
        return this;
    }

    public String getReturnValues() {
        return this.returnValues;
    }

    public void setReturnValues(String str) {
        this.returnValues = str;
    }

    public DeleteItemRequest withReturnValues(String str) {
        this.returnValues = str;
        return this;
    }

    public void setReturnValues(ReturnValue returnValue) {
        this.returnValues = returnValue.toString();
    }

    public DeleteItemRequest withReturnValues(ReturnValue returnValue) {
        this.returnValues = returnValue.toString();
        return this;
    }

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    public void setReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
    }

    public DeleteItemRequest withReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
        return this;
    }

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
    }

    public DeleteItemRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
        return this;
    }

    public String getReturnItemCollectionMetrics() {
        return this.returnItemCollectionMetrics;
    }

    public void setReturnItemCollectionMetrics(String str) {
        this.returnItemCollectionMetrics = str;
    }

    public DeleteItemRequest withReturnItemCollectionMetrics(String str) {
        this.returnItemCollectionMetrics = str;
        return this;
    }

    public void setReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics2) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics2.toString();
    }

    public DeleteItemRequest withReturnItemCollectionMetrics(ReturnItemCollectionMetrics returnItemCollectionMetrics2) {
        this.returnItemCollectionMetrics = returnItemCollectionMetrics2.toString();
        return this;
    }

    public String getConditionExpression() {
        return this.conditionExpression;
    }

    public void setConditionExpression(String str) {
        this.conditionExpression = str;
    }

    public DeleteItemRequest withConditionExpression(String str) {
        this.conditionExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public DeleteItemRequest withExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
        return this;
    }

    public DeleteItemRequest addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (!this.expressionAttributeNames.containsKey(str)) {
            this.expressionAttributeNames.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DeleteItemRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public Map<String, AttributeValue> getExpressionAttributeValues() {
        return this.expressionAttributeValues;
    }

    public void setExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
    }

    public DeleteItemRequest withExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
        return this;
    }

    public DeleteItemRequest addExpressionAttributeValuesEntry(String str, AttributeValue attributeValue) {
        if (this.expressionAttributeValues == null) {
            this.expressionAttributeValues = new HashMap();
        }
        if (!this.expressionAttributeValues.containsKey(str)) {
            this.expressionAttributeValues.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public DeleteItemRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getKey() != null) {
            sb.append("Key: " + getKey() + ",");
        }
        if (getExpected() != null) {
            sb.append("Expected: " + getExpected() + ",");
        }
        if (getConditionalOperator() != null) {
            sb.append("ConditionalOperator: " + getConditionalOperator() + ",");
        }
        if (getReturnValues() != null) {
            sb.append("ReturnValues: " + getReturnValues() + ",");
        }
        if (getReturnConsumedCapacity() != null) {
            sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity() + ",");
        }
        if (getReturnItemCollectionMetrics() != null) {
            sb.append("ReturnItemCollectionMetrics: " + getReturnItemCollectionMetrics() + ",");
        }
        if (getConditionExpression() != null) {
            sb.append("ConditionExpression: " + getConditionExpression() + ",");
        }
        if (getExpressionAttributeNames() != null) {
            sb.append("ExpressionAttributeNames: " + getExpressionAttributeNames() + ",");
        }
        if (getExpressionAttributeValues() != null) {
            sb.append("ExpressionAttributeValues: " + getExpressionAttributeValues());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int hashCode = ((((((((((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getKey() == null ? 0 : getKey().hashCode())) * 31) + (getExpected() == null ? 0 : getExpected().hashCode())) * 31) + (getConditionalOperator() == null ? 0 : getConditionalOperator().hashCode())) * 31) + (getReturnValues() == null ? 0 : getReturnValues().hashCode())) * 31;
        if (getReturnConsumedCapacity() == null) {
            i = 0;
        } else {
            i = getReturnConsumedCapacity().hashCode();
        }
        int i5 = (hashCode + i) * 31;
        if (getReturnItemCollectionMetrics() == null) {
            i2 = 0;
        } else {
            i2 = getReturnItemCollectionMetrics().hashCode();
        }
        int hashCode2 = (((i5 + i2) * 31) + (getConditionExpression() == null ? 0 : getConditionExpression().hashCode())) * 31;
        if (getExpressionAttributeNames() == null) {
            i3 = 0;
        } else {
            i3 = getExpressionAttributeNames().hashCode();
        }
        int i6 = (hashCode2 + i3) * 31;
        if (getExpressionAttributeValues() != null) {
            i4 = getExpressionAttributeValues().hashCode();
        }
        return i6 + i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteItemRequest)) {
            return false;
        }
        DeleteItemRequest deleteItemRequest = (DeleteItemRequest) obj;
        if ((deleteItemRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (deleteItemRequest.getTableName() != null && !deleteItemRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((deleteItemRequest.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (deleteItemRequest.getKey() != null && !deleteItemRequest.getKey().equals(getKey())) {
            return false;
        }
        if ((deleteItemRequest.getExpected() == null) ^ (getExpected() == null)) {
            return false;
        }
        if (deleteItemRequest.getExpected() != null && !deleteItemRequest.getExpected().equals(getExpected())) {
            return false;
        }
        if ((deleteItemRequest.getConditionalOperator() == null) ^ (getConditionalOperator() == null)) {
            return false;
        }
        if (deleteItemRequest.getConditionalOperator() != null && !deleteItemRequest.getConditionalOperator().equals(getConditionalOperator())) {
            return false;
        }
        if ((deleteItemRequest.getReturnValues() == null) ^ (getReturnValues() == null)) {
            return false;
        }
        if (deleteItemRequest.getReturnValues() != null && !deleteItemRequest.getReturnValues().equals(getReturnValues())) {
            return false;
        }
        if ((deleteItemRequest.getReturnConsumedCapacity() == null) ^ (getReturnConsumedCapacity() == null)) {
            return false;
        }
        if (deleteItemRequest.getReturnConsumedCapacity() != null && !deleteItemRequest.getReturnConsumedCapacity().equals(getReturnConsumedCapacity())) {
            return false;
        }
        if ((deleteItemRequest.getReturnItemCollectionMetrics() == null) ^ (getReturnItemCollectionMetrics() == null)) {
            return false;
        }
        if (deleteItemRequest.getReturnItemCollectionMetrics() != null && !deleteItemRequest.getReturnItemCollectionMetrics().equals(getReturnItemCollectionMetrics())) {
            return false;
        }
        if ((deleteItemRequest.getConditionExpression() == null) ^ (getConditionExpression() == null)) {
            return false;
        }
        if (deleteItemRequest.getConditionExpression() != null && !deleteItemRequest.getConditionExpression().equals(getConditionExpression())) {
            return false;
        }
        if ((deleteItemRequest.getExpressionAttributeNames() == null) ^ (getExpressionAttributeNames() == null)) {
            return false;
        }
        if (deleteItemRequest.getExpressionAttributeNames() != null && !deleteItemRequest.getExpressionAttributeNames().equals(getExpressionAttributeNames())) {
            return false;
        }
        if ((deleteItemRequest.getExpressionAttributeValues() == null) ^ (getExpressionAttributeValues() == null)) {
            return false;
        }
        return deleteItemRequest.getExpressionAttributeValues() == null || deleteItemRequest.getExpressionAttributeValues().equals(getExpressionAttributeValues());
    }
}
