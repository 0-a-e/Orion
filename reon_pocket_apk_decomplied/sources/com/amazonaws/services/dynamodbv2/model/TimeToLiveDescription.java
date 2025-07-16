package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class TimeToLiveDescription implements Serializable {
    private String attributeName;
    private String timeToLiveStatus;

    public String getTimeToLiveStatus() {
        return this.timeToLiveStatus;
    }

    public void setTimeToLiveStatus(String str) {
        this.timeToLiveStatus = str;
    }

    public TimeToLiveDescription withTimeToLiveStatus(String str) {
        this.timeToLiveStatus = str;
        return this;
    }

    public void setTimeToLiveStatus(TimeToLiveStatus timeToLiveStatus2) {
        this.timeToLiveStatus = timeToLiveStatus2.toString();
    }

    public TimeToLiveDescription withTimeToLiveStatus(TimeToLiveStatus timeToLiveStatus2) {
        this.timeToLiveStatus = timeToLiveStatus2.toString();
        return this;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public TimeToLiveDescription withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTimeToLiveStatus() != null) {
            sb.append("TimeToLiveStatus: " + getTimeToLiveStatus() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTimeToLiveStatus() == null ? 0 : getTimeToLiveStatus().hashCode()) + 31) * 31;
        if (getAttributeName() != null) {
            i = getAttributeName().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TimeToLiveDescription)) {
            return false;
        }
        TimeToLiveDescription timeToLiveDescription = (TimeToLiveDescription) obj;
        if ((timeToLiveDescription.getTimeToLiveStatus() == null) ^ (getTimeToLiveStatus() == null)) {
            return false;
        }
        if (timeToLiveDescription.getTimeToLiveStatus() != null && !timeToLiveDescription.getTimeToLiveStatus().equals(getTimeToLiveStatus())) {
            return false;
        }
        if ((timeToLiveDescription.getAttributeName() == null) ^ (getAttributeName() == null)) {
            return false;
        }
        return timeToLiveDescription.getAttributeName() == null || timeToLiveDescription.getAttributeName().equals(getAttributeName());
    }
}
