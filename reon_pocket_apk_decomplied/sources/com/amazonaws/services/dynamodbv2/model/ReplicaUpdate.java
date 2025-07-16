package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class ReplicaUpdate implements Serializable {
    private CreateReplicaAction create;
    private DeleteReplicaAction delete;

    public CreateReplicaAction getCreate() {
        return this.create;
    }

    public void setCreate(CreateReplicaAction createReplicaAction) {
        this.create = createReplicaAction;
    }

    public ReplicaUpdate withCreate(CreateReplicaAction createReplicaAction) {
        this.create = createReplicaAction;
        return this;
    }

    public DeleteReplicaAction getDelete() {
        return this.delete;
    }

    public void setDelete(DeleteReplicaAction deleteReplicaAction) {
        this.delete = deleteReplicaAction;
    }

    public ReplicaUpdate withDelete(DeleteReplicaAction deleteReplicaAction) {
        this.delete = deleteReplicaAction;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCreate() != null) {
            sb.append("Create: " + getCreate() + ",");
        }
        if (getDelete() != null) {
            sb.append("Delete: " + getDelete());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCreate() == null ? 0 : getCreate().hashCode()) + 31) * 31;
        if (getDelete() != null) {
            i = getDelete().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaUpdate)) {
            return false;
        }
        ReplicaUpdate replicaUpdate = (ReplicaUpdate) obj;
        if ((replicaUpdate.getCreate() == null) ^ (getCreate() == null)) {
            return false;
        }
        if (replicaUpdate.getCreate() != null && !replicaUpdate.getCreate().equals(getCreate())) {
            return false;
        }
        if ((replicaUpdate.getDelete() == null) ^ (getDelete() == null)) {
            return false;
        }
        return replicaUpdate.getDelete() == null || replicaUpdate.getDelete().equals(getDelete());
    }
}
