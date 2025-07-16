package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListKeyRotationsResult implements Serializable {
    private String nextMarker;
    private List<RotationsListEntry> rotations = new ArrayList();
    private Boolean truncated;

    public List<RotationsListEntry> getRotations() {
        return this.rotations;
    }

    public void setRotations(Collection<RotationsListEntry> collection) {
        if (collection == null) {
            this.rotations = null;
        } else {
            this.rotations = new ArrayList(collection);
        }
    }

    public ListKeyRotationsResult withRotations(RotationsListEntry... rotationsListEntryArr) {
        if (getRotations() == null) {
            this.rotations = new ArrayList(rotationsListEntryArr.length);
        }
        for (RotationsListEntry add : rotationsListEntryArr) {
            this.rotations.add(add);
        }
        return this;
    }

    public ListKeyRotationsResult withRotations(Collection<RotationsListEntry> collection) {
        setRotations(collection);
        return this;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public ListKeyRotationsResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public ListKeyRotationsResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRotations() != null) {
            sb.append("Rotations: " + getRotations() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getRotations() == null ? 0 : getRotations().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
        if (getTruncated() != null) {
            i = getTruncated().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeyRotationsResult)) {
            return false;
        }
        ListKeyRotationsResult listKeyRotationsResult = (ListKeyRotationsResult) obj;
        if ((listKeyRotationsResult.getRotations() == null) ^ (getRotations() == null)) {
            return false;
        }
        if (listKeyRotationsResult.getRotations() != null && !listKeyRotationsResult.getRotations().equals(getRotations())) {
            return false;
        }
        if ((listKeyRotationsResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listKeyRotationsResult.getNextMarker() != null && !listKeyRotationsResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listKeyRotationsResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listKeyRotationsResult.getTruncated() == null || listKeyRotationsResult.getTruncated().equals(getTruncated());
    }
}
