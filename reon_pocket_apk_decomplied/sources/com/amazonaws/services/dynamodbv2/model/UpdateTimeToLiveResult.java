package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class UpdateTimeToLiveResult implements Serializable {
    private TimeToLiveSpecification timeToLiveSpecification;

    public TimeToLiveSpecification getTimeToLiveSpecification() {
        return this.timeToLiveSpecification;
    }

    public void setTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification2) {
        this.timeToLiveSpecification = timeToLiveSpecification2;
    }

    public UpdateTimeToLiveResult withTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification2) {
        this.timeToLiveSpecification = timeToLiveSpecification2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTimeToLiveSpecification() != null) {
            sb.append("TimeToLiveSpecification: " + getTimeToLiveSpecification());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        if (getTimeToLiveSpecification() == null) {
            i = 0;
        } else {
            i = getTimeToLiveSpecification().hashCode();
        }
        return 31 + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateTimeToLiveResult)) {
            return false;
        }
        UpdateTimeToLiveResult updateTimeToLiveResult = (UpdateTimeToLiveResult) obj;
        if ((updateTimeToLiveResult.getTimeToLiveSpecification() == null) ^ (getTimeToLiveSpecification() == null)) {
            return false;
        }
        return updateTimeToLiveResult.getTimeToLiveSpecification() == null || updateTimeToLiveResult.getTimeToLiveSpecification().equals(getTimeToLiveSpecification());
    }
}
