package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class UpdateGlobalTableResult implements Serializable {
    private GlobalTableDescription globalTableDescription;

    public GlobalTableDescription getGlobalTableDescription() {
        return this.globalTableDescription;
    }

    public void setGlobalTableDescription(GlobalTableDescription globalTableDescription2) {
        this.globalTableDescription = globalTableDescription2;
    }

    public UpdateGlobalTableResult withGlobalTableDescription(GlobalTableDescription globalTableDescription2) {
        this.globalTableDescription = globalTableDescription2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTableDescription() != null) {
            sb.append("GlobalTableDescription: " + getGlobalTableDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        if (getGlobalTableDescription() == null) {
            i = 0;
        } else {
            i = getGlobalTableDescription().hashCode();
        }
        return 31 + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGlobalTableResult)) {
            return false;
        }
        UpdateGlobalTableResult updateGlobalTableResult = (UpdateGlobalTableResult) obj;
        if ((updateGlobalTableResult.getGlobalTableDescription() == null) ^ (getGlobalTableDescription() == null)) {
            return false;
        }
        return updateGlobalTableResult.getGlobalTableDescription() == null || updateGlobalTableResult.getGlobalTableDescription().equals(getGlobalTableDescription());
    }
}
