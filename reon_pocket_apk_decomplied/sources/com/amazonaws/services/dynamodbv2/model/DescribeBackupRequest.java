package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeBackupRequest extends AmazonWebServiceRequest implements Serializable {
    private String backupArn;

    public String getBackupArn() {
        return this.backupArn;
    }

    public void setBackupArn(String str) {
        this.backupArn = str;
    }

    public DescribeBackupRequest withBackupArn(String str) {
        this.backupArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getBackupArn() != null) {
            sb.append("BackupArn: " + getBackupArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getBackupArn() == null ? 0 : getBackupArn().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeBackupRequest)) {
            return false;
        }
        DescribeBackupRequest describeBackupRequest = (DescribeBackupRequest) obj;
        if ((describeBackupRequest.getBackupArn() == null) ^ (getBackupArn() == null)) {
            return false;
        }
        return describeBackupRequest.getBackupArn() == null || describeBackupRequest.getBackupArn().equals(getBackupArn());
    }
}
