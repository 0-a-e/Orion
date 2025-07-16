package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.Date;

public class RestoreTableToPointInTimeRequest extends AmazonWebServiceRequest implements Serializable {
    private Date restoreDateTime;
    private String sourceTableName;
    private String targetTableName;
    private Boolean useLatestRestorableTime;

    public String getSourceTableName() {
        return this.sourceTableName;
    }

    public void setSourceTableName(String str) {
        this.sourceTableName = str;
    }

    public RestoreTableToPointInTimeRequest withSourceTableName(String str) {
        this.sourceTableName = str;
        return this;
    }

    public String getTargetTableName() {
        return this.targetTableName;
    }

    public void setTargetTableName(String str) {
        this.targetTableName = str;
    }

    public RestoreTableToPointInTimeRequest withTargetTableName(String str) {
        this.targetTableName = str;
        return this;
    }

    public Boolean isUseLatestRestorableTime() {
        return this.useLatestRestorableTime;
    }

    public Boolean getUseLatestRestorableTime() {
        return this.useLatestRestorableTime;
    }

    public void setUseLatestRestorableTime(Boolean bool) {
        this.useLatestRestorableTime = bool;
    }

    public RestoreTableToPointInTimeRequest withUseLatestRestorableTime(Boolean bool) {
        this.useLatestRestorableTime = bool;
        return this;
    }

    public Date getRestoreDateTime() {
        return this.restoreDateTime;
    }

    public void setRestoreDateTime(Date date) {
        this.restoreDateTime = date;
    }

    public RestoreTableToPointInTimeRequest withRestoreDateTime(Date date) {
        this.restoreDateTime = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getSourceTableName() != null) {
            sb.append("SourceTableName: " + getSourceTableName() + ",");
        }
        if (getTargetTableName() != null) {
            sb.append("TargetTableName: " + getTargetTableName() + ",");
        }
        if (getUseLatestRestorableTime() != null) {
            sb.append("UseLatestRestorableTime: " + getUseLatestRestorableTime() + ",");
        }
        if (getRestoreDateTime() != null) {
            sb.append("RestoreDateTime: " + getRestoreDateTime());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((getSourceTableName() == null ? 0 : getSourceTableName().hashCode()) + 31) * 31) + (getTargetTableName() == null ? 0 : getTargetTableName().hashCode())) * 31;
        if (getUseLatestRestorableTime() == null) {
            i = 0;
        } else {
            i = getUseLatestRestorableTime().hashCode();
        }
        int i3 = (hashCode + i) * 31;
        if (getRestoreDateTime() != null) {
            i2 = getRestoreDateTime().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RestoreTableToPointInTimeRequest)) {
            return false;
        }
        RestoreTableToPointInTimeRequest restoreTableToPointInTimeRequest = (RestoreTableToPointInTimeRequest) obj;
        if ((restoreTableToPointInTimeRequest.getSourceTableName() == null) ^ (getSourceTableName() == null)) {
            return false;
        }
        if (restoreTableToPointInTimeRequest.getSourceTableName() != null && !restoreTableToPointInTimeRequest.getSourceTableName().equals(getSourceTableName())) {
            return false;
        }
        if ((restoreTableToPointInTimeRequest.getTargetTableName() == null) ^ (getTargetTableName() == null)) {
            return false;
        }
        if (restoreTableToPointInTimeRequest.getTargetTableName() != null && !restoreTableToPointInTimeRequest.getTargetTableName().equals(getTargetTableName())) {
            return false;
        }
        if ((restoreTableToPointInTimeRequest.getUseLatestRestorableTime() == null) ^ (getUseLatestRestorableTime() == null)) {
            return false;
        }
        if (restoreTableToPointInTimeRequest.getUseLatestRestorableTime() != null && !restoreTableToPointInTimeRequest.getUseLatestRestorableTime().equals(getUseLatestRestorableTime())) {
            return false;
        }
        if ((restoreTableToPointInTimeRequest.getRestoreDateTime() == null) ^ (getRestoreDateTime() == null)) {
            return false;
        }
        return restoreTableToPointInTimeRequest.getRestoreDateTime() == null || restoreTableToPointInTimeRequest.getRestoreDateTime().equals(getRestoreDateTime());
    }
}
