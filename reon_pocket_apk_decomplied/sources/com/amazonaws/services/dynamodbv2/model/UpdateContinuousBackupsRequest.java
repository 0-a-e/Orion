package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateContinuousBackupsRequest extends AmazonWebServiceRequest implements Serializable {
    private PointInTimeRecoverySpecification pointInTimeRecoverySpecification;
    private String tableName;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public UpdateContinuousBackupsRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public PointInTimeRecoverySpecification getPointInTimeRecoverySpecification() {
        return this.pointInTimeRecoverySpecification;
    }

    public void setPointInTimeRecoverySpecification(PointInTimeRecoverySpecification pointInTimeRecoverySpecification2) {
        this.pointInTimeRecoverySpecification = pointInTimeRecoverySpecification2;
    }

    public UpdateContinuousBackupsRequest withPointInTimeRecoverySpecification(PointInTimeRecoverySpecification pointInTimeRecoverySpecification2) {
        this.pointInTimeRecoverySpecification = pointInTimeRecoverySpecification2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + ",");
        }
        if (getPointInTimeRecoverySpecification() != null) {
            sb.append("PointInTimeRecoverySpecification: " + getPointInTimeRecoverySpecification());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31;
        if (getPointInTimeRecoverySpecification() != null) {
            i = getPointInTimeRecoverySpecification().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateContinuousBackupsRequest)) {
            return false;
        }
        UpdateContinuousBackupsRequest updateContinuousBackupsRequest = (UpdateContinuousBackupsRequest) obj;
        if ((updateContinuousBackupsRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (updateContinuousBackupsRequest.getTableName() != null && !updateContinuousBackupsRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((updateContinuousBackupsRequest.getPointInTimeRecoverySpecification() == null) ^ (getPointInTimeRecoverySpecification() == null)) {
            return false;
        }
        return updateContinuousBackupsRequest.getPointInTimeRecoverySpecification() == null || updateContinuousBackupsRequest.getPointInTimeRecoverySpecification().equals(getPointInTimeRecoverySpecification());
    }
}
