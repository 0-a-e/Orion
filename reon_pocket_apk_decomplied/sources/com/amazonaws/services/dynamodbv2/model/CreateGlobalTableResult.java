package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class CreateGlobalTableResult implements Serializable {
    private GlobalTableDescription globalTableDescription;

    public GlobalTableDescription getGlobalTableDescription() {
        return this.globalTableDescription;
    }

    public void setGlobalTableDescription(GlobalTableDescription globalTableDescription2) {
        this.globalTableDescription = globalTableDescription2;
    }

    public CreateGlobalTableResult withGlobalTableDescription(GlobalTableDescription globalTableDescription2) {
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
        if (obj == null || !(obj instanceof CreateGlobalTableResult)) {
            return false;
        }
        CreateGlobalTableResult createGlobalTableResult = (CreateGlobalTableResult) obj;
        if ((createGlobalTableResult.getGlobalTableDescription() == null) ^ (getGlobalTableDescription() == null)) {
            return false;
        }
        return createGlobalTableResult.getGlobalTableDescription() == null || createGlobalTableResult.getGlobalTableDescription().equals(getGlobalTableDescription());
    }
}
