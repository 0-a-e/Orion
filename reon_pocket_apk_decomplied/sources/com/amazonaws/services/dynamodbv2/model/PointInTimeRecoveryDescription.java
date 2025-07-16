package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.Date;

public class PointInTimeRecoveryDescription implements Serializable {
    private Date earliestRestorableDateTime;
    private Date latestRestorableDateTime;
    private String pointInTimeRecoveryStatus;

    public String getPointInTimeRecoveryStatus() {
        return this.pointInTimeRecoveryStatus;
    }

    public void setPointInTimeRecoveryStatus(String str) {
        this.pointInTimeRecoveryStatus = str;
    }

    public PointInTimeRecoveryDescription withPointInTimeRecoveryStatus(String str) {
        this.pointInTimeRecoveryStatus = str;
        return this;
    }

    public void setPointInTimeRecoveryStatus(PointInTimeRecoveryStatus pointInTimeRecoveryStatus2) {
        this.pointInTimeRecoveryStatus = pointInTimeRecoveryStatus2.toString();
    }

    public PointInTimeRecoveryDescription withPointInTimeRecoveryStatus(PointInTimeRecoveryStatus pointInTimeRecoveryStatus2) {
        this.pointInTimeRecoveryStatus = pointInTimeRecoveryStatus2.toString();
        return this;
    }

    public Date getEarliestRestorableDateTime() {
        return this.earliestRestorableDateTime;
    }

    public void setEarliestRestorableDateTime(Date date) {
        this.earliestRestorableDateTime = date;
    }

    public PointInTimeRecoveryDescription withEarliestRestorableDateTime(Date date) {
        this.earliestRestorableDateTime = date;
        return this;
    }

    public Date getLatestRestorableDateTime() {
        return this.latestRestorableDateTime;
    }

    public void setLatestRestorableDateTime(Date date) {
        this.latestRestorableDateTime = date;
    }

    public PointInTimeRecoveryDescription withLatestRestorableDateTime(Date date) {
        this.latestRestorableDateTime = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPointInTimeRecoveryStatus() != null) {
            sb.append("PointInTimeRecoveryStatus: " + getPointInTimeRecoveryStatus() + ",");
        }
        if (getEarliestRestorableDateTime() != null) {
            sb.append("EarliestRestorableDateTime: " + getEarliestRestorableDateTime() + ",");
        }
        if (getLatestRestorableDateTime() != null) {
            sb.append("LatestRestorableDateTime: " + getLatestRestorableDateTime());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        if (getPointInTimeRecoveryStatus() == null) {
            i = 0;
        } else {
            i = getPointInTimeRecoveryStatus().hashCode();
        }
        int i4 = (i + 31) * 31;
        if (getEarliestRestorableDateTime() == null) {
            i2 = 0;
        } else {
            i2 = getEarliestRestorableDateTime().hashCode();
        }
        int i5 = (i4 + i2) * 31;
        if (getLatestRestorableDateTime() != null) {
            i3 = getLatestRestorableDateTime().hashCode();
        }
        return i5 + i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PointInTimeRecoveryDescription)) {
            return false;
        }
        PointInTimeRecoveryDescription pointInTimeRecoveryDescription = (PointInTimeRecoveryDescription) obj;
        if ((pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus() == null) ^ (getPointInTimeRecoveryStatus() == null)) {
            return false;
        }
        if (pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus() != null && !pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus().equals(getPointInTimeRecoveryStatus())) {
            return false;
        }
        if ((pointInTimeRecoveryDescription.getEarliestRestorableDateTime() == null) ^ (getEarliestRestorableDateTime() == null)) {
            return false;
        }
        if (pointInTimeRecoveryDescription.getEarliestRestorableDateTime() != null && !pointInTimeRecoveryDescription.getEarliestRestorableDateTime().equals(getEarliestRestorableDateTime())) {
            return false;
        }
        if ((pointInTimeRecoveryDescription.getLatestRestorableDateTime() == null) ^ (getLatestRestorableDateTime() == null)) {
            return false;
        }
        return pointInTimeRecoveryDescription.getLatestRestorableDateTime() == null || pointInTimeRecoveryDescription.getLatestRestorableDateTime().equals(getLatestRestorableDateTime());
    }
}
