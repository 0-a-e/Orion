package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GetItemResult implements Serializable {
    private ConsumedCapacity consumedCapacity;
    private Map<String, AttributeValue> item;

    public Map<String, AttributeValue> getItem() {
        return this.item;
    }

    public void setItem(Map<String, AttributeValue> map) {
        this.item = map;
    }

    public GetItemResult withItem(Map<String, AttributeValue> map) {
        this.item = map;
        return this;
    }

    public GetItemResult addItemEntry(String str, AttributeValue attributeValue) {
        if (this.item == null) {
            this.item = new HashMap();
        }
        if (!this.item.containsKey(str)) {
            this.item.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetItemResult clearItemEntries() {
        this.item = null;
        return this;
    }

    public ConsumedCapacity getConsumedCapacity() {
        return this.consumedCapacity;
    }

    public void setConsumedCapacity(ConsumedCapacity consumedCapacity2) {
        this.consumedCapacity = consumedCapacity2;
    }

    public GetItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity2) {
        this.consumedCapacity = consumedCapacity2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getItem() != null) {
            sb.append("Item: " + getItem() + ",");
        }
        if (getConsumedCapacity() != null) {
            sb.append("ConsumedCapacity: " + getConsumedCapacity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getItem() == null ? 0 : getItem().hashCode()) + 31) * 31;
        if (getConsumedCapacity() != null) {
            i = getConsumedCapacity().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetItemResult)) {
            return false;
        }
        GetItemResult getItemResult = (GetItemResult) obj;
        if ((getItemResult.getItem() == null) ^ (getItem() == null)) {
            return false;
        }
        if (getItemResult.getItem() != null && !getItemResult.getItem().equals(getItem())) {
            return false;
        }
        if ((getItemResult.getConsumedCapacity() == null) ^ (getConsumedCapacity() == null)) {
            return false;
        }
        return getItemResult.getConsumedCapacity() == null || getItemResult.getConsumedCapacity().equals(getConsumedCapacity());
    }
}
