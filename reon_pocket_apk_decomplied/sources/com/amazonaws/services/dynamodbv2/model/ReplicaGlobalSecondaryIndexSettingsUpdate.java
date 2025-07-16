package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class ReplicaGlobalSecondaryIndexSettingsUpdate implements Serializable {
    private String indexName;
    private AutoScalingSettingsUpdate provisionedReadCapacityAutoScalingSettingsUpdate;
    private Long provisionedReadCapacityUnits;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public ReplicaGlobalSecondaryIndexSettingsUpdate withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public Long getProvisionedReadCapacityUnits() {
        return this.provisionedReadCapacityUnits;
    }

    public void setProvisionedReadCapacityUnits(Long l) {
        this.provisionedReadCapacityUnits = l;
    }

    public ReplicaGlobalSecondaryIndexSettingsUpdate withProvisionedReadCapacityUnits(Long l) {
        this.provisionedReadCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsUpdate getProvisionedReadCapacityAutoScalingSettingsUpdate() {
        return this.provisionedReadCapacityAutoScalingSettingsUpdate;
    }

    public void setProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.provisionedReadCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
    }

    public ReplicaGlobalSecondaryIndexSettingsUpdate withProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.provisionedReadCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + ",");
        }
        if (getProvisionedReadCapacityUnits() != null) {
            sb.append("ProvisionedReadCapacityUnits: " + getProvisionedReadCapacityUnits() + ",");
        }
        if (getProvisionedReadCapacityAutoScalingSettingsUpdate() != null) {
            sb.append("ProvisionedReadCapacityAutoScalingSettingsUpdate: " + getProvisionedReadCapacityAutoScalingSettingsUpdate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31;
        if (getProvisionedReadCapacityUnits() == null) {
            i = 0;
        } else {
            i = getProvisionedReadCapacityUnits().hashCode();
        }
        int i3 = (hashCode + i) * 31;
        if (getProvisionedReadCapacityAutoScalingSettingsUpdate() != null) {
            i2 = getProvisionedReadCapacityAutoScalingSettingsUpdate().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaGlobalSecondaryIndexSettingsUpdate)) {
            return false;
        }
        ReplicaGlobalSecondaryIndexSettingsUpdate replicaGlobalSecondaryIndexSettingsUpdate = (ReplicaGlobalSecondaryIndexSettingsUpdate) obj;
        if ((replicaGlobalSecondaryIndexSettingsUpdate.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsUpdate.getIndexName() != null && !replicaGlobalSecondaryIndexSettingsUpdate.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityUnits() == null) ^ (getProvisionedReadCapacityUnits() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityUnits() != null && !replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityUnits().equals(getProvisionedReadCapacityUnits())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityAutoScalingSettingsUpdate() == null) ^ (getProvisionedReadCapacityAutoScalingSettingsUpdate() == null)) {
            return false;
        }
        return replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityAutoScalingSettingsUpdate() == null || replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityAutoScalingSettingsUpdate().equals(getProvisionedReadCapacityAutoScalingSettingsUpdate());
    }
}
