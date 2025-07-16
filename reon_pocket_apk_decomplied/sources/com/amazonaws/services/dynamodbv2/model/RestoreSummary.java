package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.Date;

public class RestoreSummary implements Serializable {
    private Date restoreDateTime;
    private Boolean restoreInProgress;
    private String sourceBackupArn;
    private String sourceTableArn;

    public String getSourceBackupArn() {
        return this.sourceBackupArn;
    }

    public void setSourceBackupArn(String str) {
        this.sourceBackupArn = str;
    }

    public RestoreSummary withSourceBackupArn(String str) {
        this.sourceBackupArn = str;
        return this;
    }

    public String getSourceTableArn() {
        return this.sourceTableArn;
    }

    public void setSourceTableArn(String str) {
        this.sourceTableArn = str;
    }

    public RestoreSummary withSourceTableArn(String str) {
        this.sourceTableArn = str;
        return this;
    }

    public Date getRestoreDateTime() {
        return this.restoreDateTime;
    }

    public void setRestoreDateTime(Date date) {
        this.restoreDateTime = date;
    }

    public RestoreSummary withRestoreDateTime(Date date) {
        this.restoreDateTime = date;
        return this;
    }

    public Boolean isRestoreInProgress() {
        return this.restoreInProgress;
    }

    public Boolean getRestoreInProgress() {
        return this.restoreInProgress;
    }

    public void setRestoreInProgress(Boolean bool) {
        this.restoreInProgress = bool;
    }

    public RestoreSummary withRestoreInProgress(Boolean bool) {
        this.restoreInProgress = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getSourceBackupArn() != null) {
            sb.append("SourceBackupArn: " + getSourceBackupArn() + ",");
        }
        if (getSourceTableArn() != null) {
            sb.append("SourceTableArn: " + getSourceTableArn() + ",");
        }
        if (getRestoreDateTime() != null) {
            sb.append("RestoreDateTime: " + getRestoreDateTime() + ",");
        }
        if (getRestoreInProgress() != null) {
            sb.append("RestoreInProgress: " + getRestoreInProgress());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((getSourceBackupArn() == null ? 0 : getSourceBackupArn().hashCode()) + 31) * 31) + (getSourceTableArn() == null ? 0 : getSourceTableArn().hashCode())) * 31) + (getRestoreDateTime() == null ? 0 : getRestoreDateTime().hashCode())) * 31;
        if (getRestoreInProgress() != null) {
            i = getRestoreInProgress().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RestoreSummary)) {
            return false;
        }
        RestoreSummary restoreSummary = (RestoreSummary) obj;
        if ((restoreSummary.getSourceBackupArn() == null) ^ (getSourceBackupArn() == null)) {
            return false;
        }
        if (restoreSummary.getSourceBackupArn() != null && !restoreSummary.getSourceBackupArn().equals(getSourceBackupArn())) {
            return false;
        }
        if ((restoreSummary.getSourceTableArn() == null) ^ (getSourceTableArn() == null)) {
            return false;
        }
        if (restoreSummary.getSourceTableArn() != null && !restoreSummary.getSourceTableArn().equals(getSourceTableArn())) {
            return false;
        }
        if ((restoreSummary.getRestoreDateTime() == null) ^ (getRestoreDateTime() == null)) {
            return false;
        }
        if (restoreSummary.getRestoreDateTime() != null && !restoreSummary.getRestoreDateTime().equals(getRestoreDateTime())) {
            return false;
        }
        if ((restoreSummary.getRestoreInProgress() == null) ^ (getRestoreInProgress() == null)) {
            return false;
        }
        return restoreSummary.getRestoreInProgress() == null || restoreSummary.getRestoreInProgress().equals(getRestoreInProgress());
    }
}
