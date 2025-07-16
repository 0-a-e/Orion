package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RestoreTableFromBackupRequest extends AmazonWebServiceRequest implements Serializable {
    private String backupArn;
    private String targetTableName;

    public String getTargetTableName() {
        return this.targetTableName;
    }

    public void setTargetTableName(String str) {
        this.targetTableName = str;
    }

    public RestoreTableFromBackupRequest withTargetTableName(String str) {
        this.targetTableName = str;
        return this;
    }

    public String getBackupArn() {
        return this.backupArn;
    }

    public void setBackupArn(String str) {
        this.backupArn = str;
    }

    public RestoreTableFromBackupRequest withBackupArn(String str) {
        this.backupArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTargetTableName() != null) {
            sb.append("TargetTableName: " + getTargetTableName() + ",");
        }
        if (getBackupArn() != null) {
            sb.append("BackupArn: " + getBackupArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTargetTableName() == null ? 0 : getTargetTableName().hashCode()) + 31) * 31;
        if (getBackupArn() != null) {
            i = getBackupArn().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RestoreTableFromBackupRequest)) {
            return false;
        }
        RestoreTableFromBackupRequest restoreTableFromBackupRequest = (RestoreTableFromBackupRequest) obj;
        if ((restoreTableFromBackupRequest.getTargetTableName() == null) ^ (getTargetTableName() == null)) {
            return false;
        }
        if (restoreTableFromBackupRequest.getTargetTableName() != null && !restoreTableFromBackupRequest.getTargetTableName().equals(getTargetTableName())) {
            return false;
        }
        if ((restoreTableFromBackupRequest.getBackupArn() == null) ^ (getBackupArn() == null)) {
            return false;
        }
        return restoreTableFromBackupRequest.getBackupArn() == null || restoreTableFromBackupRequest.getBackupArn().equals(getBackupArn());
    }
}
