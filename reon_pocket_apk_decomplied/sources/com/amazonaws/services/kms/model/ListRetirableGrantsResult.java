package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListRetirableGrantsResult implements Serializable {
    private List<GrantListEntry> grants = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

    public List<GrantListEntry> getGrants() {
        return this.grants;
    }

    public void setGrants(Collection<GrantListEntry> collection) {
        if (collection == null) {
            this.grants = null;
        } else {
            this.grants = new ArrayList(collection);
        }
    }

    public ListRetirableGrantsResult withGrants(GrantListEntry... grantListEntryArr) {
        if (getGrants() == null) {
            this.grants = new ArrayList(grantListEntryArr.length);
        }
        for (GrantListEntry add : grantListEntryArr) {
            this.grants.add(add);
        }
        return this;
    }

    public ListRetirableGrantsResult withGrants(Collection<GrantListEntry> collection) {
        setGrants(collection);
        return this;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public ListRetirableGrantsResult withNextMarker(String str) {
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

    public ListRetirableGrantsResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGrants() != null) {
            sb.append("Grants: " + getGrants() + ",");
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
        int hashCode = ((((getGrants() == null ? 0 : getGrants().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
        if (getTruncated() != null) {
            i = getTruncated().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListRetirableGrantsResult)) {
            return false;
        }
        ListRetirableGrantsResult listRetirableGrantsResult = (ListRetirableGrantsResult) obj;
        if ((listRetirableGrantsResult.getGrants() == null) ^ (getGrants() == null)) {
            return false;
        }
        if (listRetirableGrantsResult.getGrants() != null && !listRetirableGrantsResult.getGrants().equals(getGrants())) {
            return false;
        }
        if ((listRetirableGrantsResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listRetirableGrantsResult.getNextMarker() != null && !listRetirableGrantsResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listRetirableGrantsResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listRetirableGrantsResult.getTruncated() == null || listRetirableGrantsResult.getTruncated().equals(getTruncated());
    }
}
