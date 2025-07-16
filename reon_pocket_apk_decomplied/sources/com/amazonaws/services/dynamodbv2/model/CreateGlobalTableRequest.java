package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateGlobalTableRequest extends AmazonWebServiceRequest implements Serializable {
    private String globalTableName;
    private List<Replica> replicationGroup;

    public String getGlobalTableName() {
        return this.globalTableName;
    }

    public void setGlobalTableName(String str) {
        this.globalTableName = str;
    }

    public CreateGlobalTableRequest withGlobalTableName(String str) {
        this.globalTableName = str;
        return this;
    }

    public List<Replica> getReplicationGroup() {
        return this.replicationGroup;
    }

    public void setReplicationGroup(Collection<Replica> collection) {
        if (collection == null) {
            this.replicationGroup = null;
        } else {
            this.replicationGroup = new ArrayList(collection);
        }
    }

    public CreateGlobalTableRequest withReplicationGroup(Replica... replicaArr) {
        if (getReplicationGroup() == null) {
            this.replicationGroup = new ArrayList(replicaArr.length);
        }
        for (Replica add : replicaArr) {
            this.replicationGroup.add(add);
        }
        return this;
    }

    public CreateGlobalTableRequest withReplicationGroup(Collection<Replica> collection) {
        setReplicationGroup(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTableName() != null) {
            sb.append("GlobalTableName: " + getGlobalTableName() + ",");
        }
        if (getReplicationGroup() != null) {
            sb.append("ReplicationGroup: " + getReplicationGroup());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode()) + 31) * 31;
        if (getReplicationGroup() != null) {
            i = getReplicationGroup().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateGlobalTableRequest)) {
            return false;
        }
        CreateGlobalTableRequest createGlobalTableRequest = (CreateGlobalTableRequest) obj;
        if ((createGlobalTableRequest.getGlobalTableName() == null) ^ (getGlobalTableName() == null)) {
            return false;
        }
        if (createGlobalTableRequest.getGlobalTableName() != null && !createGlobalTableRequest.getGlobalTableName().equals(getGlobalTableName())) {
            return false;
        }
        if ((createGlobalTableRequest.getReplicationGroup() == null) ^ (getReplicationGroup() == null)) {
            return false;
        }
        return createGlobalTableRequest.getReplicationGroup() == null || createGlobalTableRequest.getReplicationGroup().equals(getReplicationGroup());
    }
}
