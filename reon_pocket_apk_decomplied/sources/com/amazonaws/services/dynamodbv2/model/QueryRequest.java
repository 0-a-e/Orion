package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> attributesToGet;
    private String conditionalOperator;
    private Boolean consistentRead;
    private Map<String, AttributeValue> exclusiveStartKey;
    private Map<String, String> expressionAttributeNames;
    private Map<String, AttributeValue> expressionAttributeValues;
    private String filterExpression;
    private String indexName;
    private String keyConditionExpression;
    private Map<String, Condition> keyConditions;
    private Integer limit;
    private String projectionExpression;
    private Map<String, Condition> queryFilter;
    private String returnConsumedCapacity;
    private Boolean scanIndexForward;
    private String select;
    private String tableName;

    public QueryRequest() {
    }

    public QueryRequest(String str) {
        setTableName(str);
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public QueryRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public QueryRequest withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public String getSelect() {
        return this.select;
    }

    public void setSelect(String str) {
        this.select = str;
    }

    public QueryRequest withSelect(String str) {
        this.select = str;
        return this;
    }

    public void setSelect(Select select2) {
        this.select = select2.toString();
    }

    public QueryRequest withSelect(Select select2) {
        this.select = select2.toString();
        return this;
    }

    public List<String> getAttributesToGet() {
        return this.attributesToGet;
    }

    public void setAttributesToGet(Collection<String> collection) {
        if (collection == null) {
            this.attributesToGet = null;
        } else {
            this.attributesToGet = new ArrayList(collection);
        }
    }

    public QueryRequest withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            this.attributesToGet = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.attributesToGet.add(add);
        }
        return this;
    }

    public QueryRequest withAttributesToGet(Collection<String> collection) {
        setAttributesToGet(collection);
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public QueryRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public Boolean isConsistentRead() {
        return this.consistentRead;
    }

    public Boolean getConsistentRead() {
        return this.consistentRead;
    }

    public void setConsistentRead(Boolean bool) {
        this.consistentRead = bool;
    }

    public QueryRequest withConsistentRead(Boolean bool) {
        this.consistentRead = bool;
        return this;
    }

    public Map<String, Condition> getKeyConditions() {
        return this.keyConditions;
    }

    public void setKeyConditions(Map<String, Condition> map) {
        this.keyConditions = map;
    }

    public QueryRequest withKeyConditions(Map<String, Condition> map) {
        this.keyConditions = map;
        return this;
    }

    public QueryRequest addKeyConditionsEntry(String str, Condition condition) {
        if (this.keyConditions == null) {
            this.keyConditions = new HashMap();
        }
        if (!this.keyConditions.containsKey(str)) {
            this.keyConditions.put(str, condition);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public QueryRequest clearKeyConditionsEntries() {
        this.keyConditions = null;
        return this;
    }

    public Map<String, Condition> getQueryFilter() {
        return this.queryFilter;
    }

    public void setQueryFilter(Map<String, Condition> map) {
        this.queryFilter = map;
    }

    public QueryRequest withQueryFilter(Map<String, Condition> map) {
        this.queryFilter = map;
        return this;
    }

    public QueryRequest addQueryFilterEntry(String str, Condition condition) {
        if (this.queryFilter == null) {
            this.queryFilter = new HashMap();
        }
        if (!this.queryFilter.containsKey(str)) {
            this.queryFilter.put(str, condition);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public QueryRequest clearQueryFilterEntries() {
        this.queryFilter = null;
        return this;
    }

    public String getConditionalOperator() {
        return this.conditionalOperator;
    }

    public void setConditionalOperator(String str) {
        this.conditionalOperator = str;
    }

    public QueryRequest withConditionalOperator(String str) {
        this.conditionalOperator = str;
        return this;
    }

    public void setConditionalOperator(ConditionalOperator conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2.toString();
    }

    public QueryRequest withConditionalOperator(ConditionalOperator conditionalOperator2) {
        this.conditionalOperator = conditionalOperator2.toString();
        return this;
    }

    public Boolean isScanIndexForward() {
        return this.scanIndexForward;
    }

    public Boolean getScanIndexForward() {
        return this.scanIndexForward;
    }

    public void setScanIndexForward(Boolean bool) {
        this.scanIndexForward = bool;
    }

    public QueryRequest withScanIndexForward(Boolean bool) {
        this.scanIndexForward = bool;
        return this;
    }

    public Map<String, AttributeValue> getExclusiveStartKey() {
        return this.exclusiveStartKey;
    }

    public void setExclusiveStartKey(Map<String, AttributeValue> map) {
        this.exclusiveStartKey = map;
    }

    public QueryRequest withExclusiveStartKey(Map<String, AttributeValue> map) {
        this.exclusiveStartKey = map;
        return this;
    }

    public QueryRequest addExclusiveStartKeyEntry(String str, AttributeValue attributeValue) {
        if (this.exclusiveStartKey == null) {
            this.exclusiveStartKey = new HashMap();
        }
        if (!this.exclusiveStartKey.containsKey(str)) {
            this.exclusiveStartKey.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public QueryRequest clearExclusiveStartKeyEntries() {
        this.exclusiveStartKey = null;
        return this;
    }

    public String getReturnConsumedCapacity() {
        return this.returnConsumedCapacity;
    }

    public void setReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
    }

    public QueryRequest withReturnConsumedCapacity(String str) {
        this.returnConsumedCapacity = str;
        return this;
    }

    public void setReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
    }

    public QueryRequest withReturnConsumedCapacity(ReturnConsumedCapacity returnConsumedCapacity2) {
        this.returnConsumedCapacity = returnConsumedCapacity2.toString();
        return this;
    }

    public String getProjectionExpression() {
        return this.projectionExpression;
    }

    public void setProjectionExpression(String str) {
        this.projectionExpression = str;
    }

    public QueryRequest withProjectionExpression(String str) {
        this.projectionExpression = str;
        return this;
    }

    public String getFilterExpression() {
        return this.filterExpression;
    }

    public void setFilterExpression(String str) {
        this.filterExpression = str;
    }

    public QueryRequest withFilterExpression(String str) {
        this.filterExpression = str;
        return this;
    }

    public String getKeyConditionExpression() {
        return this.keyConditionExpression;
    }

    public void setKeyConditionExpression(String str) {
        this.keyConditionExpression = str;
    }

    public QueryRequest withKeyConditionExpression(String str) {
        this.keyConditionExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public QueryRequest withExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
        return this;
    }

    public QueryRequest addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (!this.expressionAttributeNames.containsKey(str)) {
            this.expressionAttributeNames.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public QueryRequest clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public Map<String, AttributeValue> getExpressionAttributeValues() {
        return this.expressionAttributeValues;
    }

    public void setExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
    }

    public QueryRequest withExpressionAttributeValues(Map<String, AttributeValue> map) {
        this.expressionAttributeValues = map;
        return this;
    }

    public QueryRequest addExpressionAttributeValuesEntry(String str, AttributeValue attributeValue) {
        if (this.expressionAttributeValues == null) {
            this.expressionAttributeValues = new HashMap();
        }
        if (!this.expressionAttributeValues.containsKey(str)) {
            this.expressionAttributeValues.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public QueryRequest clearExpressionAttributeValuesEntries() {
        this.expressionAttributeValues = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + ",");
        }
        if (getSelect() != null) {
            sb.append("Select: " + getSelect() + ",");
        }
        if (getAttributesToGet() != null) {
            sb.append("AttributesToGet: " + getAttributesToGet() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getConsistentRead() != null) {
            sb.append("ConsistentRead: " + getConsistentRead() + ",");
        }
        if (getKeyConditions() != null) {
            sb.append("KeyConditions: " + getKeyConditions() + ",");
        }
        if (getQueryFilter() != null) {
            sb.append("QueryFilter: " + getQueryFilter() + ",");
        }
        if (getConditionalOperator() != null) {
            sb.append("ConditionalOperator: " + getConditionalOperator() + ",");
        }
        if (getScanIndexForward() != null) {
            sb.append("ScanIndexForward: " + getScanIndexForward() + ",");
        }
        if (getExclusiveStartKey() != null) {
            sb.append("ExclusiveStartKey: " + getExclusiveStartKey() + ",");
        }
        if (getReturnConsumedCapacity() != null) {
            sb.append("ReturnConsumedCapacity: " + getReturnConsumedCapacity() + ",");
        }
        if (getProjectionExpression() != null) {
            sb.append("ProjectionExpression: " + getProjectionExpression() + ",");
        }
        if (getFilterExpression() != null) {
            sb.append("FilterExpression: " + getFilterExpression() + ",");
        }
        if (getKeyConditionExpression() != null) {
            sb.append("KeyConditionExpression: " + getKeyConditionExpression() + ",");
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
        int hashCode = ((((((((((((((((((((((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getIndexName() == null ? 0 : getIndexName().hashCode())) * 31) + (getSelect() == null ? 0 : getSelect().hashCode())) * 31) + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode())) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getConsistentRead() == null ? 0 : getConsistentRead().hashCode())) * 31) + (getKeyConditions() == null ? 0 : getKeyConditions().hashCode())) * 31) + (getQueryFilter() == null ? 0 : getQueryFilter().hashCode())) * 31) + (getConditionalOperator() == null ? 0 : getConditionalOperator().hashCode())) * 31) + (getScanIndexForward() == null ? 0 : getScanIndexForward().hashCode())) * 31) + (getExclusiveStartKey() == null ? 0 : getExclusiveStartKey().hashCode())) * 31;
        if (getReturnConsumedCapacity() == null) {
            i = 0;
        } else {
            i = getReturnConsumedCapacity().hashCode();
        }
        int hashCode2 = (((((hashCode + i) * 31) + (getProjectionExpression() == null ? 0 : getProjectionExpression().hashCode())) * 31) + (getFilterExpression() == null ? 0 : getFilterExpression().hashCode())) * 31;
        if (getKeyConditionExpression() == null) {
            i2 = 0;
        } else {
            i2 = getKeyConditionExpression().hashCode();
        }
        int i5 = (hashCode2 + i2) * 31;
        if (getExpressionAttributeNames() == null) {
            i3 = 0;
        } else {
            i3 = getExpressionAttributeNames().hashCode();
        }
        int i6 = (i5 + i3) * 31;
        if (getExpressionAttributeValues() != null) {
            i4 = getExpressionAttributeValues().hashCode();
        }
        return i6 + i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof QueryRequest)) {
            return false;
        }
        QueryRequest queryRequest = (QueryRequest) obj;
        if ((queryRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (queryRequest.getTableName() != null && !queryRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((queryRequest.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (queryRequest.getIndexName() != null && !queryRequest.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((queryRequest.getSelect() == null) ^ (getSelect() == null)) {
            return false;
        }
        if (queryRequest.getSelect() != null && !queryRequest.getSelect().equals(getSelect())) {
            return false;
        }
        if ((queryRequest.getAttributesToGet() == null) ^ (getAttributesToGet() == null)) {
            return false;
        }
        if (queryRequest.getAttributesToGet() != null && !queryRequest.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        if ((queryRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (queryRequest.getLimit() != null && !queryRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((queryRequest.getConsistentRead() == null) ^ (getConsistentRead() == null)) {
            return false;
        }
        if (queryRequest.getConsistentRead() != null && !queryRequest.getConsistentRead().equals(getConsistentRead())) {
            return false;
        }
        if ((queryRequest.getKeyConditions() == null) ^ (getKeyConditions() == null)) {
            return false;
        }
        if (queryRequest.getKeyConditions() != null && !queryRequest.getKeyConditions().equals(getKeyConditions())) {
            return false;
        }
        if ((queryRequest.getQueryFilter() == null) ^ (getQueryFilter() == null)) {
            return false;
        }
        if (queryRequest.getQueryFilter() != null && !queryRequest.getQueryFilter().equals(getQueryFilter())) {
            return false;
        }
        if ((queryRequest.getConditionalOperator() == null) ^ (getConditionalOperator() == null)) {
            return false;
        }
        if (queryRequest.getConditionalOperator() != null && !queryRequest.getConditionalOperator().equals(getConditionalOperator())) {
            return false;
        }
        if ((queryRequest.getScanIndexForward() == null) ^ (getScanIndexForward() == null)) {
            return false;
        }
        if (queryRequest.getScanIndexForward() != null && !queryRequest.getScanIndexForward().equals(getScanIndexForward())) {
            return false;
        }
        if ((queryRequest.getExclusiveStartKey() == null) ^ (getExclusiveStartKey() == null)) {
            return false;
        }
        if (queryRequest.getExclusiveStartKey() != null && !queryRequest.getExclusiveStartKey().equals(getExclusiveStartKey())) {
            return false;
        }
        if ((queryRequest.getReturnConsumedCapacity() == null) ^ (getReturnConsumedCapacity() == null)) {
            return false;
        }
        if (queryRequest.getReturnConsumedCapacity() != null && !queryRequest.getReturnConsumedCapacity().equals(getReturnConsumedCapacity())) {
            return false;
        }
        if ((queryRequest.getProjectionExpression() == null) ^ (getProjectionExpression() == null)) {
            return false;
        }
        if (queryRequest.getProjectionExpression() != null && !queryRequest.getProjectionExpression().equals(getProjectionExpression())) {
            return false;
        }
        if ((queryRequest.getFilterExpression() == null) ^ (getFilterExpression() == null)) {
            return false;
        }
        if (queryRequest.getFilterExpression() != null && !queryRequest.getFilterExpression().equals(getFilterExpression())) {
            return false;
        }
        if ((queryRequest.getKeyConditionExpression() == null) ^ (getKeyConditionExpression() == null)) {
            return false;
        }
        if (queryRequest.getKeyConditionExpression() != null && !queryRequest.getKeyConditionExpression().equals(getKeyConditionExpression())) {
            return false;
        }
        if ((queryRequest.getExpressionAttributeNames() == null) ^ (getExpressionAttributeNames() == null)) {
            return false;
        }
        if (queryRequest.getExpressionAttributeNames() != null && !queryRequest.getExpressionAttributeNames().equals(getExpressionAttributeNames())) {
            return false;
        }
        if ((queryRequest.getExpressionAttributeValues() == null) ^ (getExpressionAttributeValues() == null)) {
            return false;
        }
        return queryRequest.getExpressionAttributeValues() == null || queryRequest.getExpressionAttributeValues().equals(getExpressionAttributeValues());
    }
}
