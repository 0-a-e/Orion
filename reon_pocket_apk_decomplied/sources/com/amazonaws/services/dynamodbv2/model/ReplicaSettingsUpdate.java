package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReplicaSettingsUpdate implements Serializable {
    private String regionName;
    private List<ReplicaGlobalSecondaryIndexSettingsUpdate> replicaGlobalSecondaryIndexSettingsUpdate;
    private AutoScalingSettingsUpdate replicaProvisionedReadCapacityAutoScalingSettingsUpdate;
    private Long replicaProvisionedReadCapacityUnits;

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public ReplicaSettingsUpdate withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public Long getReplicaProvisionedReadCapacityUnits() {
        return this.replicaProvisionedReadCapacityUnits;
    }

    public void setReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
    }

    public ReplicaSettingsUpdate withReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsUpdate getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() {
        return this.replicaProvisionedReadCapacityAutoScalingSettingsUpdate;
    }

    public void setReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.replicaProvisionedReadCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
    }

    public ReplicaSettingsUpdate withReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.replicaProvisionedReadCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
        return this;
    }

    public List<ReplicaGlobalSecondaryIndexSettingsUpdate> getReplicaGlobalSecondaryIndexSettingsUpdate() {
        return this.replicaGlobalSecondaryIndexSettingsUpdate;
    }

    public void setReplicaGlobalSecondaryIndexSettingsUpdate(Collection<ReplicaGlobalSecondaryIndexSettingsUpdate> collection) {
        if (collection == null) {
            this.replicaGlobalSecondaryIndexSettingsUpdate = null;
        } else {
            this.replicaGlobalSecondaryIndexSettingsUpdate = new ArrayList(collection);
        }
    }

    public ReplicaSettingsUpdate withReplicaGlobalSecondaryIndexSettingsUpdate(ReplicaGlobalSecondaryIndexSettingsUpdate... replicaGlobalSecondaryIndexSettingsUpdateArr) {
        if (getReplicaGlobalSecondaryIndexSettingsUpdate() == null) {
            this.replicaGlobalSecondaryIndexSettingsUpdate = new ArrayList(replicaGlobalSecondaryIndexSettingsUpdateArr.length);
        }
        for (ReplicaGlobalSecondaryIndexSettingsUpdate add : replicaGlobalSecondaryIndexSettingsUpdateArr) {
            this.replicaGlobalSecondaryIndexSettingsUpdate.add(add);
        }
        return this;
    }

    public ReplicaSettingsUpdate withReplicaGlobalSecondaryIndexSettingsUpdate(Collection<ReplicaGlobalSecondaryIndexSettingsUpdate> collection) {
        setReplicaGlobalSecondaryIndexSettingsUpdate(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRegionName() != null) {
            sb.append("RegionName: " + getRegionName() + ",");
        }
        if (getReplicaProvisionedReadCapacityUnits() != null) {
            sb.append("ReplicaProvisionedReadCapacityUnits: " + getReplicaProvisionedReadCapacityUnits() + ",");
        }
        if (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() != null) {
            sb.append("ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate: " + getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() + ",");
        }
        if (getReplicaGlobalSecondaryIndexSettingsUpdate() != null) {
            sb.append("ReplicaGlobalSecondaryIndexSettingsUpdate: " + getReplicaGlobalSecondaryIndexSettingsUpdate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        int hashCode = ((getRegionName() == null ? 0 : getRegionName().hashCode()) + 31) * 31;
        if (getReplicaProvisionedReadCapacityUnits() == null) {
            i = 0;
        } else {
            i = getReplicaProvisionedReadCapacityUnits().hashCode();
        }
        int i4 = (hashCode + i) * 31;
        if (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null) {
            i2 = 0;
        } else {
            i2 = getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate().hashCode();
        }
        int i5 = (i4 + i2) * 31;
        if (getReplicaGlobalSecondaryIndexSettingsUpdate() != null) {
            i3 = getReplicaGlobalSecondaryIndexSettingsUpdate().hashCode();
        }
        return i5 + i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaSettingsUpdate)) {
            return false;
        }
        ReplicaSettingsUpdate replicaSettingsUpdate = (ReplicaSettingsUpdate) obj;
        if ((replicaSettingsUpdate.getRegionName() == null) ^ (getRegionName() == null)) {
            return false;
        }
        if (replicaSettingsUpdate.getRegionName() != null && !replicaSettingsUpdate.getRegionName().equals(getRegionName())) {
            return false;
        }
        if ((replicaSettingsUpdate.getReplicaProvisionedReadCapacityUnits() == null) ^ (getReplicaProvisionedReadCapacityUnits() == null)) {
            return false;
        }
        if (replicaSettingsUpdate.getReplicaProvisionedReadCapacityUnits() != null && !replicaSettingsUpdate.getReplicaProvisionedReadCapacityUnits().equals(getReplicaProvisionedReadCapacityUnits())) {
            return false;
        }
        if ((replicaSettingsUpdate.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null) ^ (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null)) {
            return false;
        }
        if (replicaSettingsUpdate.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() != null && !replicaSettingsUpdate.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate().equals(getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate())) {
            return false;
        }
        if ((replicaSettingsUpdate.getReplicaGlobalSecondaryIndexSettingsUpdate() == null) ^ (getReplicaGlobalSecondaryIndexSettingsUpdate() == null)) {
            return false;
        }
        return replicaSettingsUpdate.getReplicaGlobalSecondaryIndexSettingsUpdate() == null || replicaSettingsUpdate.getReplicaGlobalSecondaryIndexSettingsUpdate().equals(getReplicaGlobalSecondaryIndexSettingsUpdate());
    }
}
