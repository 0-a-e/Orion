package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConsumedCapacity implements Serializable {
    private Double capacityUnits;
    private Map<String, Capacity> globalSecondaryIndexes;
    private Map<String, Capacity> localSecondaryIndexes;
    private Capacity table;
    private String tableName;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public ConsumedCapacity withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public Double getCapacityUnits() {
        return this.capacityUnits;
    }

    public void setCapacityUnits(Double d) {
        this.capacityUnits = d;
    }

    public ConsumedCapacity withCapacityUnits(Double d) {
        this.capacityUnits = d;
        return this;
    }

    public Capacity getTable() {
        return this.table;
    }

    public void setTable(Capacity capacity) {
        this.table = capacity;
    }

    public ConsumedCapacity withTable(Capacity capacity) {
        this.table = capacity;
        return this;
    }

    public Map<String, Capacity> getLocalSecondaryIndexes() {
        return this.localSecondaryIndexes;
    }

    public void setLocalSecondaryIndexes(Map<String, Capacity> map) {
        this.localSecondaryIndexes = map;
    }

    public ConsumedCapacity withLocalSecondaryIndexes(Map<String, Capacity> map) {
        this.localSecondaryIndexes = map;
        return this;
    }

    public ConsumedCapacity addLocalSecondaryIndexesEntry(String str, Capacity capacity) {
        if (this.localSecondaryIndexes == null) {
            this.localSecondaryIndexes = new HashMap();
        }
        if (!this.localSecondaryIndexes.containsKey(str)) {
            this.localSecondaryIndexes.put(str, capacity);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ConsumedCapacity clearLocalSecondaryIndexesEntries() {
        this.localSecondaryIndexes = null;
        return this;
    }

    public Map<String, Capacity> getGlobalSecondaryIndexes() {
        return this.globalSecondaryIndexes;
    }

    public void setGlobalSecondaryIndexes(Map<String, Capacity> map) {
        this.globalSecondaryIndexes = map;
    }

    public ConsumedCapacity withGlobalSecondaryIndexes(Map<String, Capacity> map) {
        this.globalSecondaryIndexes = map;
        return this;
    }

    public ConsumedCapacity addGlobalSecondaryIndexesEntry(String str, Capacity capacity) {
        if (this.globalSecondaryIndexes == null) {
            this.globalSecondaryIndexes = new HashMap();
        }
        if (!this.globalSecondaryIndexes.containsKey(str)) {
            this.globalSecondaryIndexes.put(str, capacity);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ConsumedCapacity clearGlobalSecondaryIndexesEntries() {
        this.globalSecondaryIndexes = null;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getCapacityUnits() != null) {
            sb.append("CapacityUnits: " + getCapacityUnits() + ",");
        }
        if (getTable() != null) {
            sb.append("Table: " + getTable() + ",");
        }
        if (getLocalSecondaryIndexes() != null) {
            sb.append("LocalSecondaryIndexes: " + getLocalSecondaryIndexes() + ",");
        }
        if (getGlobalSecondaryIndexes() != null) {
            sb.append("GlobalSecondaryIndexes: " + getGlobalSecondaryIndexes());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getCapacityUnits() == null ? 0 : getCapacityUnits().hashCode())) * 31) + (getTable() == null ? 0 : getTable().hashCode())) * 31) + (getLocalSecondaryIndexes() == null ? 0 : getLocalSecondaryIndexes().hashCode())) * 31;
        if (getGlobalSecondaryIndexes() != null) {
            i = getGlobalSecondaryIndexes().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConsumedCapacity)) {
            return false;
        }
        ConsumedCapacity consumedCapacity = (ConsumedCapacity) obj;
        if ((consumedCapacity.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (consumedCapacity.getTableName() != null && !consumedCapacity.getTableName().equals(getTableName())) {
            return false;
        }
        if ((consumedCapacity.getCapacityUnits() == null) ^ (getCapacityUnits() == null)) {
            return false;
        }
        if (consumedCapacity.getCapacityUnits() != null && !consumedCapacity.getCapacityUnits().equals(getCapacityUnits())) {
            return false;
        }
        if ((consumedCapacity.getTable() == null) ^ (getTable() == null)) {
            return false;
        }
        if (consumedCapacity.getTable() != null && !consumedCapacity.getTable().equals(getTable())) {
            return false;
        }
        if ((consumedCapacity.getLocalSecondaryIndexes() == null) ^ (getLocalSecondaryIndexes() == null)) {
            return false;
        }
        if (consumedCapacity.getLocalSecondaryIndexes() != null && !consumedCapacity.getLocalSecondaryIndexes().equals(getLocalSecondaryIndexes())) {
            return false;
        }
        if ((consumedCapacity.getGlobalSecondaryIndexes() == null) ^ (getGlobalSecondaryIndexes() == null)) {
            return false;
        }
        return consumedCapacity.getGlobalSecondaryIndexes() == null || consumedCapacity.getGlobalSecondaryIndexes().equals(getGlobalSecondaryIndexes());
    }
}
