package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PutRequest implements Serializable {
    private Map<String, AttributeValue> item;

    public PutRequest() {
    }

    public PutRequest(Map<String, AttributeValue> map) {
        setItem(map);
    }

    public Map<String, AttributeValue> getItem() {
        return this.item;
    }

    public void setItem(Map<String, AttributeValue> map) {
        this.item = map;
    }

    public PutRequest withItem(Map<String, AttributeValue> map) {
        this.item = map;
        return this;
    }

    public PutRequest addItemEntry(String str, AttributeValue attributeValue) {
        if (this.item == null) {
            this.item = new HashMap();
        }
        if (!this.item.containsKey(str)) {
            this.item.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public PutRequest clearItemEntries() {
        this.item = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getItem() != null) {
            sb.append("Item: " + getItem());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getItem() == null ? 0 : getItem().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutRequest)) {
            return false;
        }
        PutRequest putRequest = (PutRequest) obj;
        if ((putRequest.getItem() == null) ^ (getItem() == null)) {
            return false;
        }
        return putRequest.getItem() == null || putRequest.getItem().equals(getItem());
    }
}
