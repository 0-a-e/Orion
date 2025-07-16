package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScanResult implements Serializable {
    private ConsumedCapacity consumedCapacity;
    private Integer count;
    private List<Map<String, AttributeValue>> items;
    private Map<String, AttributeValue> lastEvaluatedKey;
    private Integer scannedCount;

    public List<Map<String, AttributeValue>> getItems() {
        return this.items;
    }

    public void setItems(Collection<Map<String, AttributeValue>> collection) {
        if (collection == null) {
            this.items = null;
        } else {
            this.items = new ArrayList(collection);
        }
    }

    public ScanResult withItems(Map<String, AttributeValue>... mapArr) {
        if (getItems() == null) {
            this.items = new ArrayList(mapArr.length);
        }
        for (Map<String, AttributeValue> add : mapArr) {
            this.items.add(add);
        }
        return this;
    }

    public ScanResult withItems(Collection<Map<String, AttributeValue>> collection) {
        setItems(collection);
        return this;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer num) {
        this.count = num;
    }

    public ScanResult withCount(Integer num) {
        this.count = num;
        return this;
    }

    public Integer getScannedCount() {
        return this.scannedCount;
    }

    public void setScannedCount(Integer num) {
        this.scannedCount = num;
    }

    public ScanResult withScannedCount(Integer num) {
        this.scannedCount = num;
        return this;
    }

    public Map<String, AttributeValue> getLastEvaluatedKey() {
        return this.lastEvaluatedKey;
    }

    public void setLastEvaluatedKey(Map<String, AttributeValue> map) {
        this.lastEvaluatedKey = map;
    }

    public ScanResult withLastEvaluatedKey(Map<String, AttributeValue> map) {
        this.lastEvaluatedKey = map;
        return this;
    }

    public ScanResult addLastEvaluatedKeyEntry(String str, AttributeValue attributeValue) {
        if (this.lastEvaluatedKey == null) {
            this.lastEvaluatedKey = new HashMap();
        }
        if (!this.lastEvaluatedKey.containsKey(str)) {
            this.lastEvaluatedKey.put(str, attributeValue);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ScanResult clearLastEvaluatedKeyEntries() {
        this.lastEvaluatedKey = null;
        return this;
    }

    public ConsumedCapacity getConsumedCapacity() {
        return this.consumedCapacity;
    }

    public void setConsumedCapacity(ConsumedCapacity consumedCapacity2) {
        this.consumedCapacity = consumedCapacity2;
    }

    public ScanResult withConsumedCapacity(ConsumedCapacity consumedCapacity2) {
        this.consumedCapacity = consumedCapacity2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getItems() != null) {
            sb.append("Items: " + getItems() + ",");
        }
        if (getCount() != null) {
            sb.append("Count: " + getCount() + ",");
        }
        if (getScannedCount() != null) {
            sb.append("ScannedCount: " + getScannedCount() + ",");
        }
        if (getLastEvaluatedKey() != null) {
            sb.append("LastEvaluatedKey: " + getLastEvaluatedKey() + ",");
        }
        if (getConsumedCapacity() != null) {
            sb.append("ConsumedCapacity: " + getConsumedCapacity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((getItems() == null ? 0 : getItems().hashCode()) + 31) * 31) + (getCount() == null ? 0 : getCount().hashCode())) * 31) + (getScannedCount() == null ? 0 : getScannedCount().hashCode())) * 31) + (getLastEvaluatedKey() == null ? 0 : getLastEvaluatedKey().hashCode())) * 31;
        if (getConsumedCapacity() != null) {
            i = getConsumedCapacity().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScanResult)) {
            return false;
        }
        ScanResult scanResult = (ScanResult) obj;
        if ((scanResult.getItems() == null) ^ (getItems() == null)) {
            return false;
        }
        if (scanResult.getItems() != null && !scanResult.getItems().equals(getItems())) {
            return false;
        }
        if ((scanResult.getCount() == null) ^ (getCount() == null)) {
            return false;
        }
        if (scanResult.getCount() != null && !scanResult.getCount().equals(getCount())) {
            return false;
        }
        if ((scanResult.getScannedCount() == null) ^ (getScannedCount() == null)) {
            return false;
        }
        if (scanResult.getScannedCount() != null && !scanResult.getScannedCount().equals(getScannedCount())) {
            return false;
        }
        if ((scanResult.getLastEvaluatedKey() == null) ^ (getLastEvaluatedKey() == null)) {
            return false;
        }
        if (scanResult.getLastEvaluatedKey() != null && !scanResult.getLastEvaluatedKey().equals(getLastEvaluatedKey())) {
            return false;
        }
        if ((scanResult.getConsumedCapacity() == null) ^ (getConsumedCapacity() == null)) {
            return false;
        }
        return scanResult.getConsumedCapacity() == null || scanResult.getConsumedCapacity().equals(getConsumedCapacity());
    }
}
