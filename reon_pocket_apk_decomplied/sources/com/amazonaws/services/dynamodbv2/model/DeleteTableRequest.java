package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteTableRequest extends AmazonWebServiceRequest implements Serializable {
    private String tableName;

    public DeleteTableRequest() {
    }

    public DeleteTableRequest(String str) {
        setTableName(str);
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public DeleteTableRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getTableName() == null ? 0 : getTableName().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteTableRequest)) {
            return false;
        }
        DeleteTableRequest deleteTableRequest = (DeleteTableRequest) obj;
        if ((deleteTableRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        return deleteTableRequest.getTableName() == null || deleteTableRequest.getTableName().equals(getTableName());
    }
}
