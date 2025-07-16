package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class ContinuousBackupsDescription implements Serializable {
    private String continuousBackupsStatus;
    private PointInTimeRecoveryDescription pointInTimeRecoveryDescription;

    public String getContinuousBackupsStatus() {
        return this.continuousBackupsStatus;
    }

    public void setContinuousBackupsStatus(String str) {
        this.continuousBackupsStatus = str;
    }

    public ContinuousBackupsDescription withContinuousBackupsStatus(String str) {
        this.continuousBackupsStatus = str;
        return this;
    }

    public void setContinuousBackupsStatus(ContinuousBackupsStatus continuousBackupsStatus2) {
        this.continuousBackupsStatus = continuousBackupsStatus2.toString();
    }

    public ContinuousBackupsDescription withContinuousBackupsStatus(ContinuousBackupsStatus continuousBackupsStatus2) {
        this.continuousBackupsStatus = continuousBackupsStatus2.toString();
        return this;
    }

    public PointInTimeRecoveryDescription getPointInTimeRecoveryDescription() {
        return this.pointInTimeRecoveryDescription;
    }

    public void setPointInTimeRecoveryDescription(PointInTimeRecoveryDescription pointInTimeRecoveryDescription2) {
        this.pointInTimeRecoveryDescription = pointInTimeRecoveryDescription2;
    }

    public ContinuousBackupsDescription withPointInTimeRecoveryDescription(PointInTimeRecoveryDescription pointInTimeRecoveryDescription2) {
        this.pointInTimeRecoveryDescription = pointInTimeRecoveryDescription2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getContinuousBackupsStatus() != null) {
            sb.append("ContinuousBackupsStatus: " + getContinuousBackupsStatus() + ",");
        }
        if (getPointInTimeRecoveryDescription() != null) {
            sb.append("PointInTimeRecoveryDescription: " + getPointInTimeRecoveryDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (getContinuousBackupsStatus() == null) {
            i = 0;
        } else {
            i = getContinuousBackupsStatus().hashCode();
        }
        int i3 = (i + 31) * 31;
        if (getPointInTimeRecoveryDescription() != null) {
            i2 = getPointInTimeRecoveryDescription().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContinuousBackupsDescription)) {
            return false;
        }
        ContinuousBackupsDescription continuousBackupsDescription = (ContinuousBackupsDescription) obj;
        if ((continuousBackupsDescription.getContinuousBackupsStatus() == null) ^ (getContinuousBackupsStatus() == null)) {
            return false;
        }
        if (continuousBackupsDescription.getContinuousBackupsStatus() != null && !continuousBackupsDescription.getContinuousBackupsStatus().equals(getContinuousBackupsStatus())) {
            return false;
        }
        if ((continuousBackupsDescription.getPointInTimeRecoveryDescription() == null) ^ (getPointInTimeRecoveryDescription() == null)) {
            return false;
        }
        return continuousBackupsDescription.getPointInTimeRecoveryDescription() == null || continuousBackupsDescription.getPointInTimeRecoveryDescription().equals(getPointInTimeRecoveryDescription());
    }
}
