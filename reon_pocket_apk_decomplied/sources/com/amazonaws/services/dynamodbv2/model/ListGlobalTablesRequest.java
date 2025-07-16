package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListGlobalTablesRequest extends AmazonWebServiceRequest implements Serializable {
    private String exclusiveStartGlobalTableName;
    private Integer limit;
    private String regionName;

    public String getExclusiveStartGlobalTableName() {
        return this.exclusiveStartGlobalTableName;
    }

    public void setExclusiveStartGlobalTableName(String str) {
        this.exclusiveStartGlobalTableName = str;
    }

    public ListGlobalTablesRequest withExclusiveStartGlobalTableName(String str) {
        this.exclusiveStartGlobalTableName = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListGlobalTablesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public ListGlobalTablesRequest withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getExclusiveStartGlobalTableName() != null) {
            sb.append("ExclusiveStartGlobalTableName: " + getExclusiveStartGlobalTableName() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getRegionName() != null) {
            sb.append("RegionName: " + getRegionName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (getExclusiveStartGlobalTableName() == null) {
            i = 0;
        } else {
            i = getExclusiveStartGlobalTableName().hashCode();
        }
        int hashCode = (((i + 31) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31;
        if (getRegionName() != null) {
            i2 = getRegionName().hashCode();
        }
        return hashCode + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListGlobalTablesRequest)) {
            return false;
        }
        ListGlobalTablesRequest listGlobalTablesRequest = (ListGlobalTablesRequest) obj;
        if ((listGlobalTablesRequest.getExclusiveStartGlobalTableName() == null) ^ (getExclusiveStartGlobalTableName() == null)) {
            return false;
        }
        if (listGlobalTablesRequest.getExclusiveStartGlobalTableName() != null && !listGlobalTablesRequest.getExclusiveStartGlobalTableName().equals(getExclusiveStartGlobalTableName())) {
            return false;
        }
        if ((listGlobalTablesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listGlobalTablesRequest.getLimit() != null && !listGlobalTablesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listGlobalTablesRequest.getRegionName() == null) ^ (getRegionName() == null)) {
            return false;
        }
        return listGlobalTablesRequest.getRegionName() == null || listGlobalTablesRequest.getRegionName().equals(getRegionName());
    }
}
