package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeysAndAttributes implements Serializable {
    private List<String> attributesToGet;
    private Boolean consistentRead;
    private Map<String, String> expressionAttributeNames;
    private List<Map<String, AttributeValue>> keys;
    private String projectionExpression;

    public List<Map<String, AttributeValue>> getKeys() {
        return this.keys;
    }

    public void setKeys(Collection<Map<String, AttributeValue>> collection) {
        if (collection == null) {
            this.keys = null;
        } else {
            this.keys = new ArrayList(collection);
        }
    }

    public KeysAndAttributes withKeys(Map<String, AttributeValue>... mapArr) {
        if (getKeys() == null) {
            this.keys = new ArrayList(mapArr.length);
        }
        for (Map<String, AttributeValue> add : mapArr) {
            this.keys.add(add);
        }
        return this;
    }

    public KeysAndAttributes withKeys(Collection<Map<String, AttributeValue>> collection) {
        setKeys(collection);
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

    public KeysAndAttributes withAttributesToGet(String... strArr) {
        if (getAttributesToGet() == null) {
            this.attributesToGet = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.attributesToGet.add(add);
        }
        return this;
    }

    public KeysAndAttributes withAttributesToGet(Collection<String> collection) {
        setAttributesToGet(collection);
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

    public KeysAndAttributes withConsistentRead(Boolean bool) {
        this.consistentRead = bool;
        return this;
    }

    public String getProjectionExpression() {
        return this.projectionExpression;
    }

    public void setProjectionExpression(String str) {
        this.projectionExpression = str;
    }

    public KeysAndAttributes withProjectionExpression(String str) {
        this.projectionExpression = str;
        return this;
    }

    public Map<String, String> getExpressionAttributeNames() {
        return this.expressionAttributeNames;
    }

    public void setExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
    }

    public KeysAndAttributes withExpressionAttributeNames(Map<String, String> map) {
        this.expressionAttributeNames = map;
        return this;
    }

    public KeysAndAttributes addExpressionAttributeNamesEntry(String str, String str2) {
        if (this.expressionAttributeNames == null) {
            this.expressionAttributeNames = new HashMap();
        }
        if (!this.expressionAttributeNames.containsKey(str)) {
            this.expressionAttributeNames.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public KeysAndAttributes clearExpressionAttributeNamesEntries() {
        this.expressionAttributeNames = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeys() != null) {
            sb.append("Keys: " + getKeys() + ",");
        }
        if (getAttributesToGet() != null) {
            sb.append("AttributesToGet: " + getAttributesToGet() + ",");
        }
        if (getConsistentRead() != null) {
            sb.append("ConsistentRead: " + getConsistentRead() + ",");
        }
        if (getProjectionExpression() != null) {
            sb.append("ProjectionExpression: " + getProjectionExpression() + ",");
        }
        if (getExpressionAttributeNames() != null) {
            sb.append("ExpressionAttributeNames: " + getExpressionAttributeNames());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((getKeys() == null ? 0 : getKeys().hashCode()) + 31) * 31) + (getAttributesToGet() == null ? 0 : getAttributesToGet().hashCode())) * 31) + (getConsistentRead() == null ? 0 : getConsistentRead().hashCode())) * 31) + (getProjectionExpression() == null ? 0 : getProjectionExpression().hashCode())) * 31;
        if (getExpressionAttributeNames() != null) {
            i = getExpressionAttributeNames().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeysAndAttributes)) {
            return false;
        }
        KeysAndAttributes keysAndAttributes = (KeysAndAttributes) obj;
        if ((keysAndAttributes.getKeys() == null) ^ (getKeys() == null)) {
            return false;
        }
        if (keysAndAttributes.getKeys() != null && !keysAndAttributes.getKeys().equals(getKeys())) {
            return false;
        }
        if ((keysAndAttributes.getAttributesToGet() == null) ^ (getAttributesToGet() == null)) {
            return false;
        }
        if (keysAndAttributes.getAttributesToGet() != null && !keysAndAttributes.getAttributesToGet().equals(getAttributesToGet())) {
            return false;
        }
        if ((keysAndAttributes.getConsistentRead() == null) ^ (getConsistentRead() == null)) {
            return false;
        }
        if (keysAndAttributes.getConsistentRead() != null && !keysAndAttributes.getConsistentRead().equals(getConsistentRead())) {
            return false;
        }
        if ((keysAndAttributes.getProjectionExpression() == null) ^ (getProjectionExpression() == null)) {
            return false;
        }
        if (keysAndAttributes.getProjectionExpression() != null && !keysAndAttributes.getProjectionExpression().equals(getProjectionExpression())) {
            return false;
        }
        if ((keysAndAttributes.getExpressionAttributeNames() == null) ^ (getExpressionAttributeNames() == null)) {
            return false;
        }
        return keysAndAttributes.getExpressionAttributeNames() == null || keysAndAttributes.getExpressionAttributeNames().equals(getExpressionAttributeNames());
    }
}
