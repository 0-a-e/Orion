package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateGlobalTableSettingsRequest extends AmazonWebServiceRequest implements Serializable {
    private List<GlobalTableGlobalSecondaryIndexSettingsUpdate> globalTableGlobalSecondaryIndexSettingsUpdate;
    private String globalTableName;
    private AutoScalingSettingsUpdate globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate;
    private Long globalTableProvisionedWriteCapacityUnits;
    private List<ReplicaSettingsUpdate> replicaSettingsUpdate;

    public String getGlobalTableName() {
        return this.globalTableName;
    }

    public void setGlobalTableName(String str) {
        this.globalTableName = str;
    }

    public UpdateGlobalTableSettingsRequest withGlobalTableName(String str) {
        this.globalTableName = str;
        return this;
    }

    public Long getGlobalTableProvisionedWriteCapacityUnits() {
        return this.globalTableProvisionedWriteCapacityUnits;
    }

    public void setGlobalTableProvisionedWriteCapacityUnits(Long l) {
        this.globalTableProvisionedWriteCapacityUnits = l;
    }

    public UpdateGlobalTableSettingsRequest withGlobalTableProvisionedWriteCapacityUnits(Long l) {
        this.globalTableProvisionedWriteCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsUpdate getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() {
        return this.globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate;
    }

    public void setGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
    }

    public UpdateGlobalTableSettingsRequest withGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
        return this;
    }

    public List<GlobalTableGlobalSecondaryIndexSettingsUpdate> getGlobalTableGlobalSecondaryIndexSettingsUpdate() {
        return this.globalTableGlobalSecondaryIndexSettingsUpdate;
    }

    public void setGlobalTableGlobalSecondaryIndexSettingsUpdate(Collection<GlobalTableGlobalSecondaryIndexSettingsUpdate> collection) {
        if (collection == null) {
            this.globalTableGlobalSecondaryIndexSettingsUpdate = null;
        } else {
            this.globalTableGlobalSecondaryIndexSettingsUpdate = new ArrayList(collection);
        }
    }

    public UpdateGlobalTableSettingsRequest withGlobalTableGlobalSecondaryIndexSettingsUpdate(GlobalTableGlobalSecondaryIndexSettingsUpdate... globalTableGlobalSecondaryIndexSettingsUpdateArr) {
        if (getGlobalTableGlobalSecondaryIndexSettingsUpdate() == null) {
            this.globalTableGlobalSecondaryIndexSettingsUpdate = new ArrayList(globalTableGlobalSecondaryIndexSettingsUpdateArr.length);
        }
        for (GlobalTableGlobalSecondaryIndexSettingsUpdate add : globalTableGlobalSecondaryIndexSettingsUpdateArr) {
            this.globalTableGlobalSecondaryIndexSettingsUpdate.add(add);
        }
        return this;
    }

    public UpdateGlobalTableSettingsRequest withGlobalTableGlobalSecondaryIndexSettingsUpdate(Collection<GlobalTableGlobalSecondaryIndexSettingsUpdate> collection) {
        setGlobalTableGlobalSecondaryIndexSettingsUpdate(collection);
        return this;
    }

    public List<ReplicaSettingsUpdate> getReplicaSettingsUpdate() {
        return this.replicaSettingsUpdate;
    }

    public void setReplicaSettingsUpdate(Collection<ReplicaSettingsUpdate> collection) {
        if (collection == null) {
            this.replicaSettingsUpdate = null;
        } else {
            this.replicaSettingsUpdate = new ArrayList(collection);
        }
    }

    public UpdateGlobalTableSettingsRequest withReplicaSettingsUpdate(ReplicaSettingsUpdate... replicaSettingsUpdateArr) {
        if (getReplicaSettingsUpdate() == null) {
            this.replicaSettingsUpdate = new ArrayList(replicaSettingsUpdateArr.length);
        }
        for (ReplicaSettingsUpdate add : replicaSettingsUpdateArr) {
            this.replicaSettingsUpdate.add(add);
        }
        return this;
    }

    public UpdateGlobalTableSettingsRequest withReplicaSettingsUpdate(Collection<ReplicaSettingsUpdate> collection) {
        setReplicaSettingsUpdate(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTableName() != null) {
            sb.append("GlobalTableName: " + getGlobalTableName() + ",");
        }
        if (getGlobalTableProvisionedWriteCapacityUnits() != null) {
            sb.append("GlobalTableProvisionedWriteCapacityUnits: " + getGlobalTableProvisionedWriteCapacityUnits() + ",");
        }
        if (getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() != null) {
            sb.append("GlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate: " + getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() + ",");
        }
        if (getGlobalTableGlobalSecondaryIndexSettingsUpdate() != null) {
            sb.append("GlobalTableGlobalSecondaryIndexSettingsUpdate: " + getGlobalTableGlobalSecondaryIndexSettingsUpdate() + ",");
        }
        if (getReplicaSettingsUpdate() != null) {
            sb.append("ReplicaSettingsUpdate: " + getReplicaSettingsUpdate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int hashCode = ((getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode()) + 31) * 31;
        if (getGlobalTableProvisionedWriteCapacityUnits() == null) {
            i = 0;
        } else {
            i = getGlobalTableProvisionedWriteCapacityUnits().hashCode();
        }
        int i5 = (hashCode + i) * 31;
        if (getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() == null) {
            i2 = 0;
        } else {
            i2 = getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate().hashCode();
        }
        int i6 = (i5 + i2) * 31;
        if (getGlobalTableGlobalSecondaryIndexSettingsUpdate() == null) {
            i3 = 0;
        } else {
            i3 = getGlobalTableGlobalSecondaryIndexSettingsUpdate().hashCode();
        }
        int i7 = (i6 + i3) * 31;
        if (getReplicaSettingsUpdate() != null) {
            i4 = getReplicaSettingsUpdate().hashCode();
        }
        return i7 + i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGlobalTableSettingsRequest)) {
            return false;
        }
        UpdateGlobalTableSettingsRequest updateGlobalTableSettingsRequest = (UpdateGlobalTableSettingsRequest) obj;
        if ((updateGlobalTableSettingsRequest.getGlobalTableName() == null) ^ (getGlobalTableName() == null)) {
            return false;
        }
        if (updateGlobalTableSettingsRequest.getGlobalTableName() != null && !updateGlobalTableSettingsRequest.getGlobalTableName().equals(getGlobalTableName())) {
            return false;
        }
        if ((updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityUnits() == null) ^ (getGlobalTableProvisionedWriteCapacityUnits() == null)) {
            return false;
        }
        if (updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityUnits() != null && !updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityUnits().equals(getGlobalTableProvisionedWriteCapacityUnits())) {
            return false;
        }
        if ((updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() == null) ^ (getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() == null)) {
            return false;
        }
        if (updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate() != null && !updateGlobalTableSettingsRequest.getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate().equals(getGlobalTableProvisionedWriteCapacityAutoScalingSettingsUpdate())) {
            return false;
        }
        if ((updateGlobalTableSettingsRequest.getGlobalTableGlobalSecondaryIndexSettingsUpdate() == null) ^ (getGlobalTableGlobalSecondaryIndexSettingsUpdate() == null)) {
            return false;
        }
        if (updateGlobalTableSettingsRequest.getGlobalTableGlobalSecondaryIndexSettingsUpdate() != null && !updateGlobalTableSettingsRequest.getGlobalTableGlobalSecondaryIndexSettingsUpdate().equals(getGlobalTableGlobalSecondaryIndexSettingsUpdate())) {
            return false;
        }
        if ((updateGlobalTableSettingsRequest.getReplicaSettingsUpdate() == null) ^ (getReplicaSettingsUpdate() == null)) {
            return false;
        }
        return updateGlobalTableSettingsRequest.getReplicaSettingsUpdate() == null || updateGlobalTableSettingsRequest.getReplicaSettingsUpdate().equals(getReplicaSettingsUpdate());
    }
}
