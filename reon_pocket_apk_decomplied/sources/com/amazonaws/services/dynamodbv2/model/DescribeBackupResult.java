package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class DescribeBackupResult implements Serializable {
    private BackupDescription backupDescription;

    public BackupDescription getBackupDescription() {
        return this.backupDescription;
    }

    public void setBackupDescription(BackupDescription backupDescription2) {
        this.backupDescription = backupDescription2;
    }

    public DescribeBackupResult withBackupDescription(BackupDescription backupDescription2) {
        this.backupDescription = backupDescription2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getBackupDescription() != null) {
            sb.append("BackupDescription: " + getBackupDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getBackupDescription() == null ? 0 : getBackupDescription().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeBackupResult)) {
            return false;
        }
        DescribeBackupResult describeBackupResult = (DescribeBackupResult) obj;
        if ((describeBackupResult.getBackupDescription() == null) ^ (getBackupDescription() == null)) {
            return false;
        }
        return describeBackupResult.getBackupDescription() == null || describeBackupResult.getBackupDescription().equals(getBackupDescription());
    }
}
