package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PutItemResult implements Serializable {
    private Map<String, AttributeValue> attributes;
    private ConsumedCapacity consumedCapacity;
    private ItemCollectionMetrics itemCollectionMetrics;

    public Map<String, AttributeValue> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<String, AttributeValue> map) {
        this.attributes = map;
    }

    public PutItemResult withAttributes(Map<String, AttributeValue> map) {
        this.attributes = map;
        return this;
    }

    public PutItemResult addAttributesEntry(String str, AttributeValue attributeValue) {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        if (!this.attributes.containsKey(str)) {
            this.attributes.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public PutItemResult clearAttributesEntries() {
        this.attributes = null;
        return this;
    }

    public ConsumedCapacity getConsumedCapacity() {
        return this.consumedCapacity;
    }

    public void setConsumedCapacity(ConsumedCapacity consumedCapacity2) {
        this.consumedCapacity = consumedCapacity2;
    }

    public PutItemResult withConsumedCapacity(ConsumedCapacity consumedCapacity2) {
        this.consumedCapacity = consumedCapacity2;
        return this;
    }

    public ItemCollectionMetrics getItemCollectionMetrics() {
        return this.itemCollectionMetrics;
    }

    public void setItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics2) {
        this.itemCollectionMetrics = itemCollectionMetrics2;
    }

    public PutItemResult withItemCollectionMetrics(ItemCollectionMetrics itemCollectionMetrics2) {
        this.itemCollectionMetrics = itemCollectionMetrics2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributes() != null) {
            sb.append("Attributes: " + getAttributes() + ",");
        }
        if (getConsumedCapacity() != null) {
            sb.append("ConsumedCapacity: " + getConsumedCapacity() + ",");
        }
        if (getItemCollectionMetrics() != null) {
            sb.append("ItemCollectionMetrics: " + getItemCollectionMetrics());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getAttributes() == null ? 0 : getAttributes().hashCode()) + 31) * 31) + (getConsumedCapacity() == null ? 0 : getConsumedCapacity().hashCode())) * 31;
        if (getItemCollectionMetrics() != null) {
            i = getItemCollectionMetrics().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PutItemResult)) {
            return false;
        }
        PutItemResult putItemResult = (PutItemResult) obj;
        if ((putItemResult.getAttributes() == null) ^ (getAttributes() == null)) {
            return false;
        }
        if (putItemResult.getAttributes() != null && !putItemResult.getAttributes().equals(getAttributes())) {
            return false;
        }
        if ((putItemResult.getConsumedCapacity() == null) ^ (getConsumedCapacity() == null)) {
            return false;
        }
        if (putItemResult.getConsumedCapacity() != null && !putItemResult.getConsumedCapacity().equals(getConsumedCapacity())) {
            return false;
        }
        if ((putItemResult.getItemCollectionMetrics() == null) ^ (getItemCollectionMetrics() == null)) {
            return false;
        }
        return putItemResult.getItemCollectionMetrics() == null || putItemResult.getItemCollectionMetrics().equals(getItemCollectionMetrics());
    }
}
