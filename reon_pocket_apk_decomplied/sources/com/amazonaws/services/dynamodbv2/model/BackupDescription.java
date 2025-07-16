package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class BackupDescription implements Serializable {
    private BackupDetails backupDetails;
    private SourceTableDetails sourceTableDetails;
    private SourceTableFeatureDetails sourceTableFeatureDetails;

    public BackupDetails getBackupDetails() {
        return this.backupDetails;
    }

    public void setBackupDetails(BackupDetails backupDetails2) {
        this.backupDetails = backupDetails2;
    }

    public BackupDescription withBackupDetails(BackupDetails backupDetails2) {
        this.backupDetails = backupDetails2;
        return this;
    }

    public SourceTableDetails getSourceTableDetails() {
        return this.sourceTableDetails;
    }

    public void setSourceTableDetails(SourceTableDetails sourceTableDetails2) {
        this.sourceTableDetails = sourceTableDetails2;
    }

    public BackupDescription withSourceTableDetails(SourceTableDetails sourceTableDetails2) {
        this.sourceTableDetails = sourceTableDetails2;
        return this;
    }

    public SourceTableFeatureDetails getSourceTableFeatureDetails() {
        return this.sourceTableFeatureDetails;
    }

    public void setSourceTableFeatureDetails(SourceTableFeatureDetails sourceTableFeatureDetails2) {
        this.sourceTableFeatureDetails = sourceTableFeatureDetails2;
    }

    public BackupDescription withSourceTableFeatureDetails(SourceTableFeatureDetails sourceTableFeatureDetails2) {
        this.sourceTableFeatureDetails = sourceTableFeatureDetails2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getBackupDetails() != null) {
            sb.append("BackupDetails: " + getBackupDetails() + ",");
        }
        if (getSourceTableDetails() != null) {
            sb.append("SourceTableDetails: " + getSourceTableDetails() + ",");
        }
        if (getSourceTableFeatureDetails() != null) {
            sb.append("SourceTableFeatureDetails: " + getSourceTableFeatureDetails());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getBackupDetails() == null ? 0 : getBackupDetails().hashCode()) + 31) * 31) + (getSourceTableDetails() == null ? 0 : getSourceTableDetails().hashCode())) * 31;
        if (getSourceTableFeatureDetails() != null) {
            i = getSourceTableFeatureDetails().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BackupDescription)) {
            return false;
        }
        BackupDescription backupDescription = (BackupDescription) obj;
        if ((backupDescription.getBackupDetails() == null) ^ (getBackupDetails() == null)) {
            return false;
        }
        if (backupDescription.getBackupDetails() != null && !backupDescription.getBackupDetails().equals(getBackupDetails())) {
            return false;
        }
        if ((backupDescription.getSourceTableDetails() == null) ^ (getSourceTableDetails() == null)) {
            return false;
        }
        if (backupDescription.getSourceTableDetails() != null && !backupDescription.getSourceTableDetails().equals(getSourceTableDetails())) {
            return false;
        }
        if ((backupDescription.getSourceTableFeatureDetails() == null) ^ (getSourceTableFeatureDetails() == null)) {
            return false;
        }
        return backupDescription.getSourceTableFeatureDetails() == null || backupDescription.getSourceTableFeatureDetails().equals(getSourceTableFeatureDetails());
    }
}
