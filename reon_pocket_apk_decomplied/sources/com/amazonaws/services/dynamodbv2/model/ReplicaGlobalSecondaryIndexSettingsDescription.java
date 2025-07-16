package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class ReplicaGlobalSecondaryIndexSettingsDescription implements Serializable {
    private String indexName;
    private String indexStatus;
    private AutoScalingSettingsDescription provisionedReadCapacityAutoScalingSettings;
    private Long provisionedReadCapacityUnits;
    private AutoScalingSettingsDescription provisionedWriteCapacityAutoScalingSettings;
    private Long provisionedWriteCapacityUnits;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public String getIndexStatus() {
        return this.indexStatus;
    }

    public void setIndexStatus(String str) {
        this.indexStatus = str;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withIndexStatus(String str) {
        this.indexStatus = str;
        return this;
    }

    public void setIndexStatus(IndexStatus indexStatus2) {
        this.indexStatus = indexStatus2.toString();
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withIndexStatus(IndexStatus indexStatus2) {
        this.indexStatus = indexStatus2.toString();
        return this;
    }

    public Long getProvisionedReadCapacityUnits() {
        return this.provisionedReadCapacityUnits;
    }

    public void setProvisionedReadCapacityUnits(Long l) {
        this.provisionedReadCapacityUnits = l;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedReadCapacityUnits(Long l) {
        this.provisionedReadCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getProvisionedReadCapacityAutoScalingSettings() {
        return this.provisionedReadCapacityAutoScalingSettings;
    }

    public void setProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public Long getProvisionedWriteCapacityUnits() {
        return this.provisionedWriteCapacityUnits;
    }

    public void setProvisionedWriteCapacityUnits(Long l) {
        this.provisionedWriteCapacityUnits = l;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedWriteCapacityUnits(Long l) {
        this.provisionedWriteCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getProvisionedWriteCapacityAutoScalingSettings() {
        return this.provisionedWriteCapacityAutoScalingSettings;
    }

    public void setProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + ",");
        }
        if (getIndexStatus() != null) {
            sb.append("IndexStatus: " + getIndexStatus() + ",");
        }
        if (getProvisionedReadCapacityUnits() != null) {
            sb.append("ProvisionedReadCapacityUnits: " + getProvisionedReadCapacityUnits() + ",");
        }
        if (getProvisionedReadCapacityAutoScalingSettings() != null) {
            sb.append("ProvisionedReadCapacityAutoScalingSettings: " + getProvisionedReadCapacityAutoScalingSettings() + ",");
        }
        if (getProvisionedWriteCapacityUnits() != null) {
            sb.append("ProvisionedWriteCapacityUnits: " + getProvisionedWriteCapacityUnits() + ",");
        }
        if (getProvisionedWriteCapacityAutoScalingSettings() != null) {
            sb.append("ProvisionedWriteCapacityAutoScalingSettings: " + getProvisionedWriteCapacityAutoScalingSettings());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int hashCode = ((((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31) + (getIndexStatus() == null ? 0 : getIndexStatus().hashCode())) * 31;
        if (getProvisionedReadCapacityUnits() == null) {
            i = 0;
        } else {
            i = getProvisionedReadCapacityUnits().hashCode();
        }
        int i5 = (hashCode + i) * 31;
        if (getProvisionedReadCapacityAutoScalingSettings() == null) {
            i2 = 0;
        } else {
            i2 = getProvisionedReadCapacityAutoScalingSettings().hashCode();
        }
        int i6 = (i5 + i2) * 31;
        if (getProvisionedWriteCapacityUnits() == null) {
            i3 = 0;
        } else {
            i3 = getProvisionedWriteCapacityUnits().hashCode();
        }
        int i7 = (i6 + i3) * 31;
        if (getProvisionedWriteCapacityAutoScalingSettings() != null) {
            i4 = getProvisionedWriteCapacityAutoScalingSettings().hashCode();
        }
        return i7 + i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaGlobalSecondaryIndexSettingsDescription)) {
            return false;
        }
        ReplicaGlobalSecondaryIndexSettingsDescription replicaGlobalSecondaryIndexSettingsDescription = (ReplicaGlobalSecondaryIndexSettingsDescription) obj;
        if ((replicaGlobalSecondaryIndexSettingsDescription.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getIndexName() != null && !replicaGlobalSecondaryIndexSettingsDescription.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getIndexStatus() == null) ^ (getIndexStatus() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getIndexStatus() != null && !replicaGlobalSecondaryIndexSettingsDescription.getIndexStatus().equals(getIndexStatus())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityUnits() == null) ^ (getProvisionedReadCapacityUnits() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityUnits() != null && !replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityUnits().equals(getProvisionedReadCapacityUnits())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityAutoScalingSettings() == null) ^ (getProvisionedReadCapacityAutoScalingSettings() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityAutoScalingSettings() != null && !replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityAutoScalingSettings().equals(getProvisionedReadCapacityAutoScalingSettings())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityUnits() == null) ^ (getProvisionedWriteCapacityUnits() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityUnits() != null && !replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityUnits().equals(getProvisionedWriteCapacityUnits())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityAutoScalingSettings() == null) ^ (getProvisionedWriteCapacityAutoScalingSettings() == null)) {
            return false;
        }
        return replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityAutoScalingSettings() == null || replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityAutoScalingSettings().equals(getProvisionedWriteCapacityAutoScalingSettings());
    }
}
