package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class TimeToLiveSpecification implements Serializable {
    private String attributeName;
    private Boolean enabled;

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public TimeToLiveSpecification withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public TimeToLiveSpecification withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getEnabled() == null ? 0 : getEnabled().hashCode()) + 31) * 31;
        if (getAttributeName() != null) {
            i = getAttributeName().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TimeToLiveSpecification)) {
            return false;
        }
        TimeToLiveSpecification timeToLiveSpecification = (TimeToLiveSpecification) obj;
        if ((timeToLiveSpecification.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (timeToLiveSpecification.getEnabled() != null && !timeToLiveSpecification.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((timeToLiveSpecification.getAttributeName() == null) ^ (getAttributeName() == null)) {
            return false;
        }
        return timeToLiveSpecification.getAttributeName() == null || timeToLiveSpecification.getAttributeName().equals(getAttributeName());
    }
}
