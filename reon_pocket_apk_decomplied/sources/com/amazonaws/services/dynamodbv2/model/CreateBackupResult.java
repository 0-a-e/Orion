package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class CreateBackupResult implements Serializable {
    private BackupDetails backupDetails;

    public BackupDetails getBackupDetails() {
        return this.backupDetails;
    }

    public void setBackupDetails(BackupDetails backupDetails2) {
        this.backupDetails = backupDetails2;
    }

    public CreateBackupResult withBackupDetails(BackupDetails backupDetails2) {
        this.backupDetails = backupDetails2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getBackupDetails() != null) {
            sb.append("BackupDetails: " + getBackupDetails());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getBackupDetails() == null ? 0 : getBackupDetails().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateBackupResult)) {
            return false;
        }
        CreateBackupResult createBackupResult = (CreateBackupResult) obj;
        if ((createBackupResult.getBackupDetails() == null) ^ (getBackupDetails() == null)) {
            return false;
        }
        return createBackupResult.getBackupDetails() == null || createBackupResult.getBackupDetails().equals(getBackupDetails());
    }
}
