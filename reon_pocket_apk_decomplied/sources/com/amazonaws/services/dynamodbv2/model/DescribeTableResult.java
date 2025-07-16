package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class DescribeTableResult implements Serializable {
    private TableDescription table;

    public TableDescription getTable() {
        return this.table;
    }

    public void setTable(TableDescription tableDescription) {
        this.table = tableDescription;
    }

    public DescribeTableResult withTable(TableDescription tableDescription) {
        this.table = tableDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTable() != null) {
            sb.append("Table: " + getTable());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getTable() == null ? 0 : getTable().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTableResult)) {
            return false;
        }
        DescribeTableResult describeTableResult = (DescribeTableResult) obj;
        if ((describeTableResult.getTable() == null) ^ (getTable() == null)) {
            return false;
        }
        return describeTableResult.getTable() == null || describeTableResult.getTable().equals(getTable());
    }
}
