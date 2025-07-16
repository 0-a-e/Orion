package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class GlobalTableGlobalSecondaryIndexSettingsUpdate implements Serializable {
    private String indexName;
    private AutoScalingSettingsUpdate provisionedWriteCapacityAutoScalingSettingsUpdate;
    private Long provisionedWriteCapacityUnits;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public GlobalTableGlobalSecondaryIndexSettingsUpdate withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public Long getProvisionedWriteCapacityUnits() {
        return this.provisionedWriteCapacityUnits;
    }

    public void setProvisionedWriteCapacityUnits(Long l) {
        this.provisionedWriteCapacityUnits = l;
    }

    public GlobalTableGlobalSecondaryIndexSettingsUpdate withProvisionedWriteCapacityUnits(Long l) {
        this.provisionedWriteCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsUpdate getProvisionedWriteCapacityAutoScalingSettingsUpdate() {
        return this.provisionedWriteCapacityAutoScalingSettingsUpdate;
    }

    public void setProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.provisionedWriteCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
    }

    public GlobalTableGlobalSecondaryIndexSettingsUpdate withProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.provisionedWriteCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + ",");
        }
        if (getProvisionedWriteCapacityUnits() != null) {
            sb.append("ProvisionedWriteCapacityUnits: " + getProvisionedWriteCapacityUnits() + ",");
        }
        if (getProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) {
            sb.append("ProvisionedWriteCapacityAutoScalingSettingsUpdate: " + getProvisionedWriteCapacityAutoScalingSettingsUpdate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31;
        if (getProvisionedWriteCapacityUnits() == null) {
            i = 0;
        } else {
            i = getProvisionedWriteCapacityUnits().hashCode();
        }
        int i3 = (hashCode + i) * 31;
        if (getProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) {
            i2 = getProvisionedWriteCapacityAutoScalingSettingsUpdate().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GlobalTableGlobalSecondaryIndexSettingsUpdate)) {
            return false;
        }
        GlobalTableGlobalSecondaryIndexSettingsUpdate globalTableGlobalSecondaryIndexSettingsUpdate = (GlobalTableGlobalSecondaryIndexSettingsUpdate) obj;
        if ((globalTableGlobalSecondaryIndexSettingsUpdate.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (globalTableGlobalSecondaryIndexSettingsUpdate.getIndexName() != null && !globalTableGlobalSecondaryIndexSettingsUpdate.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityUnits() == null) ^ (getProvisionedWriteCapacityUnits() == null)) {
            return false;
        }
        if (globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityUnits() != null && !globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityUnits().equals(getProvisionedWriteCapacityUnits())) {
            return false;
        }
        if ((globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityAutoScalingSettingsUpdate() == null) ^ (getProvisionedWriteCapacityAutoScalingSettingsUpdate() == null)) {
            return false;
        }
        return globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityAutoScalingSettingsUpdate() == null || globalTableGlobalSecondaryIndexSettingsUpdate.getProvisionedWriteCapacityAutoScalingSettingsUpdate().equals(getProvisionedWriteCapacityAutoScalingSettingsUpdate());
    }
}
