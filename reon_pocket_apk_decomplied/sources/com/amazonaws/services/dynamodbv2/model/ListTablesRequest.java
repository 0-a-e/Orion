package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListTablesRequest extends AmazonWebServiceRequest implements Serializable {
    private String exclusiveStartTableName;
    private Integer limit;

    public ListTablesRequest() {
    }

    public ListTablesRequest(String str) {
        setExclusiveStartTableName(str);
    }

    public ListTablesRequest(String str, Integer num) {
        setExclusiveStartTableName(str);
        setLimit(num);
    }

    public String getExclusiveStartTableName() {
        return this.exclusiveStartTableName;
    }

    public void setExclusiveStartTableName(String str) {
        this.exclusiveStartTableName = str;
    }

    public ListTablesRequest withExclusiveStartTableName(String str) {
        this.exclusiveStartTableName = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListTablesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getExclusiveStartTableName() != null) {
            sb.append("ExclusiveStartTableName: " + getExclusiveStartTableName() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (getExclusiveStartTableName() == null) {
            i = 0;
        } else {
            i = getExclusiveStartTableName().hashCode();
        }
        int i3 = (i + 31) * 31;
        if (getLimit() != null) {
            i2 = getLimit().hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTablesRequest)) {
            return false;
        }
        ListTablesRequest listTablesRequest = (ListTablesRequest) obj;
        if ((listTablesRequest.getExclusiveStartTableName() == null) ^ (getExclusiveStartTableName() == null)) {
            return false;
        }
        if (listTablesRequest.getExclusiveStartTableName() != null && !listTablesRequest.getExclusiveStartTableName().equals(getExclusiveStartTableName())) {
            return false;
        }
        if ((listTablesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        return listTablesRequest.getLimit() == null || listTablesRequest.getLimit().equals(getLimit());
    }
}
