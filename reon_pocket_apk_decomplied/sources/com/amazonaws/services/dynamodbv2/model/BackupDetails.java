package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.Date;

public class BackupDetails implements Serializable {
    private String backupArn;
    private Date backupCreationDateTime;
    private Date backupExpiryDateTime;
    private String backupName;
    private Long backupSizeBytes;
    private String backupStatus;
    private String backupType;

    public String getBackupArn() {
        return this.backupArn;
    }

    public void setBackupArn(String str) {
        this.backupArn = str;
    }

    public BackupDetails withBackupArn(String str) {
        this.backupArn = str;
        return this;
    }

    public String getBackupName() {
        return this.backupName;
    }

    public void setBackupName(String str) {
        this.backupName = str;
    }

    public BackupDetails withBackupName(String str) {
        this.backupName = str;
        return this;
    }

    public Long getBackupSizeBytes() {
        return this.backupSizeBytes;
    }

    public void setBackupSizeBytes(Long l) {
        this.backupSizeBytes = l;
    }

    public BackupDetails withBackupSizeBytes(Long l) {
        this.backupSizeBytes = l;
        return this;
    }

    public String getBackupStatus() {
        return this.backupStatus;
    }

    public void setBackupStatus(String str) {
        this.backupStatus = str;
    }

    public BackupDetails withBackupStatus(String str) {
        this.backupStatus = str;
        return this;
    }

    public void setBackupStatus(BackupStatus backupStatus2) {
        this.backupStatus = backupStatus2.toString();
    }

    public BackupDetails withBackupStatus(BackupStatus backupStatus2) {
        this.backupStatus = backupStatus2.toString();
        return this;
    }

    public String getBackupType() {
        return this.backupType;
    }

    public void setBackupType(String str) {
        this.backupType = str;
    }

    public BackupDetails withBackupType(String str) {
        this.backupType = str;
        return this;
    }

    public void setBackupType(BackupType backupType2) {
        this.backupType = backupType2.toString();
    }

    public BackupDetails withBackupType(BackupType backupType2) {
        this.backupType = backupType2.toString();
        return this;
    }

    public Date getBackupCreationDateTime() {
        return this.backupCreationDateTime;
    }

    public void setBackupCreationDateTime(Date date) {
        this.backupCreationDateTime = date;
    }

    public BackupDetails withBackupCreationDateTime(Date date) {
        this.backupCreationDateTime = date;
        return this;
    }

    public Date getBackupExpiryDateTime() {
        return this.backupExpiryDateTime;
    }

    public void setBackupExpiryDateTime(Date date) {
        this.backupExpiryDateTime = date;
    }

    public BackupDetails withBackupExpiryDateTime(Date date) {
        this.backupExpiryDateTime = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getBackupArn() != null) {
            sb.append("BackupArn: " + getBackupArn() + ",");
        }
        if (getBackupName() != null) {
            sb.append("BackupName: " + getBackupName() + ",");
        }
        if (getBackupSizeBytes() != null) {
            sb.append("BackupSizeBytes: " + getBackupSizeBytes() + ",");
        }
        if (getBackupStatus() != null) {
            sb.append("BackupStatus: " + getBackupStatus() + ",");
        }
        if (getBackupType() != null) {
            sb.append("BackupType: " + getBackupType() + ",");
        }
        if (getBackupCreationDateTime() != null) {
            sb.append("BackupCreationDateTime: " + getBackupCreationDateTime() + ",");
        }
        if (getBackupExpiryDateTime() != null) {
            sb.append("BackupExpiryDateTime: " + getBackupExpiryDateTime());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((((((((getBackupArn() == null ? 0 : getBackupArn().hashCode()) + 31) * 31) + (getBackupName() == null ? 0 : getBackupName().hashCode())) * 31) + (getBackupSizeBytes() == null ? 0 : getBackupSizeBytes().hashCode())) * 31) + (getBackupStatus() == null ? 0 : getBackupStatus().hashCode())) * 31) + (getBackupType() == null ? 0 : getBackupType().hashCode())) * 31;
        if (getBackupCreationDateTime() == null) {
            i = 0;
        } else {
            i = getBackupCreationDateTime().hashCode();
        }
        int i3 = (hashCode + i) * 31;
        if (getBackupExpiryDateTime() != null) {
            i2 = getBackupExpiryDateTime().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BackupDetails)) {
            return false;
        }
        BackupDetails backupDetails = (BackupDetails) obj;
        if ((backupDetails.getBackupArn() == null) ^ (getBackupArn() == null)) {
            return false;
        }
        if (backupDetails.getBackupArn() != null && !backupDetails.getBackupArn().equals(getBackupArn())) {
            return false;
        }
        if ((backupDetails.getBackupName() == null) ^ (getBackupName() == null)) {
            return false;
        }
        if (backupDetails.getBackupName() != null && !backupDetails.getBackupName().equals(getBackupName())) {
            return false;
        }
        if ((backupDetails.getBackupSizeBytes() == null) ^ (getBackupSizeBytes() == null)) {
            return false;
        }
        if (backupDetails.getBackupSizeBytes() != null && !backupDetails.getBackupSizeBytes().equals(getBackupSizeBytes())) {
            return false;
        }
        if ((backupDetails.getBackupStatus() == null) ^ (getBackupStatus() == null)) {
            return false;
        }
        if (backupDetails.getBackupStatus() != null && !backupDetails.getBackupStatus().equals(getBackupStatus())) {
            return false;
        }
        if ((backupDetails.getBackupType() == null) ^ (getBackupType() == null)) {
            return false;
        }
        if (backupDetails.getBackupType() != null && !backupDetails.getBackupType().equals(getBackupType())) {
            return false;
        }
        if ((backupDetails.getBackupCreationDateTime() == null) ^ (getBackupCreationDateTime() == null)) {
            return false;
        }
        if (backupDetails.getBackupCreationDateTime() != null && !backupDetails.getBackupCreationDateTime().equals(getBackupCreationDateTime())) {
            return false;
        }
        if ((backupDetails.getBackupExpiryDateTime() == null) ^ (getBackupExpiryDateTime() == null)) {
            return false;
        }
        return backupDetails.getBackupExpiryDateTime() == null || backupDetails.getBackupExpiryDateTime().equals(getBackupExpiryDateTime());
    }
}
