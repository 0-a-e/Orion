package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class Replica implements Serializable {
    private String regionName;

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public Replica withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRegionName() != null) {
            sb.append("RegionName: " + getRegionName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getRegionName() == null ? 0 : getRegionName().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Replica)) {
            return false;
        }
        Replica replica = (Replica) obj;
        if ((replica.getRegionName() == null) ^ (getRegionName() == null)) {
            return false;
        }
        return replica.getRegionName() == null || replica.getRegionName().equals(getRegionName());
    }
}
