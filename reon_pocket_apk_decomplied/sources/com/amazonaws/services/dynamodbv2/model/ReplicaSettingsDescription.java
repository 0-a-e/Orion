package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReplicaSettingsDescription implements Serializable {
    private String regionName;
    private List<ReplicaGlobalSecondaryIndexSettingsDescription> replicaGlobalSecondaryIndexSettings;
    private AutoScalingSettingsDescription replicaProvisionedReadCapacityAutoScalingSettings;
    private Long replicaProvisionedReadCapacityUnits;
    private AutoScalingSettingsDescription replicaProvisionedWriteCapacityAutoScalingSettings;
    private Long replicaProvisionedWriteCapacityUnits;
    private String replicaStatus;

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public ReplicaSettingsDescription withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public String getReplicaStatus() {
        return this.replicaStatus;
    }

    public void setReplicaStatus(String str) {
        this.replicaStatus = str;
    }

    public ReplicaSettingsDescription withReplicaStatus(String str) {
        this.replicaStatus = str;
        return this;
    }

    public void setReplicaStatus(ReplicaStatus replicaStatus2) {
        this.replicaStatus = replicaStatus2.toString();
    }

    public ReplicaSettingsDescription withReplicaStatus(ReplicaStatus replicaStatus2) {
        this.replicaStatus = replicaStatus2.toString();
        return this;
    }

    public Long getReplicaProvisionedReadCapacityUnits() {
        return this.replicaProvisionedReadCapacityUnits;
    }

    public void setReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
    }

    public ReplicaSettingsDescription withReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getReplicaProvisionedReadCapacityAutoScalingSettings() {
        return this.replicaProvisionedReadCapacityAutoScalingSettings;
    }

    public void setReplicaProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaSettingsDescription withReplicaProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public Long getReplicaProvisionedWriteCapacityUnits() {
        return this.replicaProvisionedWriteCapacityUnits;
    }

    public void setReplicaProvisionedWriteCapacityUnits(Long l) {
        this.replicaProvisionedWriteCapacityUnits = l;
    }

    public ReplicaSettingsDescription withReplicaProvisionedWriteCapacityUnits(Long l) {
        this.replicaProvisionedWriteCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getReplicaProvisionedWriteCapacityAutoScalingSettings() {
        return this.replicaProvisionedWriteCapacityAutoScalingSettings;
    }

    public void setReplicaProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaSettingsDescription withReplicaProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public List<ReplicaGlobalSecondaryIndexSettingsDescription> getReplicaGlobalSecondaryIndexSettings() {
        return this.replicaGlobalSecondaryIndexSettings;
    }

    public void setReplicaGlobalSecondaryIndexSettings(Collection<ReplicaGlobalSecondaryIndexSettingsDescription> collection) {
        if (collection == null) {
            this.replicaGlobalSecondaryIndexSettings = null;
        } else {
            this.replicaGlobalSecondaryIndexSettings = new ArrayList(collection);
        }
    }

    public ReplicaSettingsDescription withReplicaGlobalSecondaryIndexSettings(ReplicaGlobalSecondaryIndexSettingsDescription... replicaGlobalSecondaryIndexSettingsDescriptionArr) {
        if (getReplicaGlobalSecondaryIndexSettings() == null) {
            this.replicaGlobalSecondaryIndexSettings = new ArrayList(replicaGlobalSecondaryIndexSettingsDescriptionArr.length);
        }
        for (ReplicaGlobalSecondaryIndexSettingsDescription add : replicaGlobalSecondaryIndexSettingsDescriptionArr) {
            this.replicaGlobalSecondaryIndexSettings.add(add);
        }
        return this;
    }

    public ReplicaSettingsDescription withReplicaGlobalSecondaryIndexSettings(Collection<ReplicaGlobalSecondaryIndexSettingsDescription> collection) {
        setReplicaGlobalSecondaryIndexSettings(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRegionName() != null) {
            sb.append("RegionName: " + getRegionName() + ",");
        }
        if (getReplicaStatus() != null) {
            sb.append("ReplicaStatus: " + getReplicaStatus() + ",");
        }
        if (getReplicaProvisionedReadCapacityUnits() != null) {
            sb.append("ReplicaProvisionedReadCapacityUnits: " + getReplicaProvisionedReadCapacityUnits() + ",");
        }
        if (getReplicaProvisionedReadCapacityAutoScalingSettings() != null) {
            sb.append("ReplicaProvisionedReadCapacityAutoScalingSettings: " + getReplicaProvisionedReadCapacityAutoScalingSettings() + ",");
        }
        if (getReplicaProvisionedWriteCapacityUnits() != null) {
            sb.append("ReplicaProvisionedWriteCapacityUnits: " + getReplicaProvisionedWriteCapacityUnits() + ",");
        }
        if (getReplicaProvisionedWriteCapacityAutoScalingSettings() != null) {
            sb.append("ReplicaProvisionedWriteCapacityAutoScalingSettings: " + getReplicaProvisionedWriteCapacityAutoScalingSettings() + ",");
        }
        if (getReplicaGlobalSecondaryIndexSettings() != null) {
            sb.append("ReplicaGlobalSecondaryIndexSettings: " + getReplicaGlobalSecondaryIndexSettings());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int hashCode = ((((getRegionName() == null ? 0 : getRegionName().hashCode()) + 31) * 31) + (getReplicaStatus() == null ? 0 : getReplicaStatus().hashCode())) * 31;
        if (getReplicaProvisionedReadCapacityUnits() == null) {
            i = 0;
        } else {
            i = getReplicaProvisionedReadCapacityUnits().hashCode();
        }
        int i6 = (hashCode + i) * 31;
        if (getReplicaProvisionedReadCapacityAutoScalingSettings() == null) {
            i2 = 0;
        } else {
            i2 = getReplicaProvisionedReadCapacityAutoScalingSettings().hashCode();
        }
        int i7 = (i6 + i2) * 31;
        if (getReplicaProvisionedWriteCapacityUnits() == null) {
            i3 = 0;
        } else {
            i3 = getReplicaProvisionedWriteCapacityUnits().hashCode();
        }
        int i8 = (i7 + i3) * 31;
        if (getReplicaProvisionedWriteCapacityAutoScalingSettings() == null) {
            i4 = 0;
        } else {
            i4 = getReplicaProvisionedWriteCapacityAutoScalingSettings().hashCode();
        }
        int i9 = (i8 + i4) * 31;
        if (getReplicaGlobalSecondaryIndexSettings() != null) {
            i5 = getReplicaGlobalSecondaryIndexSettings().hashCode();
        }
        return i9 + i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaSettingsDescription)) {
            return false;
        }
        ReplicaSettingsDescription replicaSettingsDescription = (ReplicaSettingsDescription) obj;
        if ((replicaSettingsDescription.getRegionName() == null) ^ (getRegionName() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getRegionName() != null && !replicaSettingsDescription.getRegionName().equals(getRegionName())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaStatus() == null) ^ (getReplicaStatus() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaStatus() != null && !replicaSettingsDescription.getReplicaStatus().equals(getReplicaStatus())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits() == null) ^ (getReplicaProvisionedReadCapacityUnits() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits() != null && !replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits().equals(getReplicaProvisionedReadCapacityUnits())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings() == null) ^ (getReplicaProvisionedReadCapacityAutoScalingSettings() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings() != null && !replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings().equals(getReplicaProvisionedReadCapacityAutoScalingSettings())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits() == null) ^ (getReplicaProvisionedWriteCapacityUnits() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits() != null && !replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits().equals(getReplicaProvisionedWriteCapacityUnits())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings() == null) ^ (getReplicaProvisionedWriteCapacityAutoScalingSettings() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings() != null && !replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings().equals(getReplicaProvisionedWriteCapacityAutoScalingSettings())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings() == null) ^ (getReplicaGlobalSecondaryIndexSettings() == null)) {
            return false;
        }
        return replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings() == null || replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings().equals(getReplicaGlobalSecondaryIndexSettings());
    }
}
