package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class DescribeLimitsResult implements Serializable {
    private Long accountMaxReadCapacityUnits;
    private Long accountMaxWriteCapacityUnits;
    private Long tableMaxReadCapacityUnits;
    private Long tableMaxWriteCapacityUnits;

    public Long getAccountMaxReadCapacityUnits() {
        return this.accountMaxReadCapacityUnits;
    }

    public void setAccountMaxReadCapacityUnits(Long l) {
        this.accountMaxReadCapacityUnits = l;
    }

    public DescribeLimitsResult withAccountMaxReadCapacityUnits(Long l) {
        this.accountMaxReadCapacityUnits = l;
        return this;
    }

    public Long getAccountMaxWriteCapacityUnits() {
        return this.accountMaxWriteCapacityUnits;
    }

    public void setAccountMaxWriteCapacityUnits(Long l) {
        this.accountMaxWriteCapacityUnits = l;
    }

    public DescribeLimitsResult withAccountMaxWriteCapacityUnits(Long l) {
        this.accountMaxWriteCapacityUnits = l;
        return this;
    }

    public Long getTableMaxReadCapacityUnits() {
        return this.tableMaxReadCapacityUnits;
    }

    public void setTableMaxReadCapacityUnits(Long l) {
        this.tableMaxReadCapacityUnits = l;
    }

    public DescribeLimitsResult withTableMaxReadCapacityUnits(Long l) {
        this.tableMaxReadCapacityUnits = l;
        return this;
    }

    public Long getTableMaxWriteCapacityUnits() {
        return this.tableMaxWriteCapacityUnits;
    }

    public void setTableMaxWriteCapacityUnits(Long l) {
        this.tableMaxWriteCapacityUnits = l;
    }

    public DescribeLimitsResult withTableMaxWriteCapacityUnits(Long l) {
        this.tableMaxWriteCapacityUnits = l;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAccountMaxReadCapacityUnits() != null) {
            sb.append("AccountMaxReadCapacityUnits: " + getAccountMaxReadCapacityUnits() + ",");
        }
        if (getAccountMaxWriteCapacityUnits() != null) {
            sb.append("AccountMaxWriteCapacityUnits: " + getAccountMaxWriteCapacityUnits() + ",");
        }
        if (getTableMaxReadCapacityUnits() != null) {
            sb.append("TableMaxReadCapacityUnits: " + getTableMaxReadCapacityUnits() + ",");
        }
        if (getTableMaxWriteCapacityUnits() != null) {
            sb.append("TableMaxWriteCapacityUnits: " + getTableMaxWriteCapacityUnits());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (getAccountMaxReadCapacityUnits() == null) {
            i = 0;
        } else {
            i = getAccountMaxReadCapacityUnits().hashCode();
        }
        int i5 = (i + 31) * 31;
        if (getAccountMaxWriteCapacityUnits() == null) {
            i2 = 0;
        } else {
            i2 = getAccountMaxWriteCapacityUnits().hashCode();
        }
        int i6 = (i5 + i2) * 31;
        if (getTableMaxReadCapacityUnits() == null) {
            i3 = 0;
        } else {
            i3 = getTableMaxReadCapacityUnits().hashCode();
        }
        int i7 = (i6 + i3) * 31;
        if (getTableMaxWriteCapacityUnits() != null) {
            i4 = getTableMaxWriteCapacityUnits().hashCode();
        }
        return i7 + i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLimitsResult)) {
            return false;
        }
        DescribeLimitsResult describeLimitsResult = (DescribeLimitsResult) obj;
        if ((describeLimitsResult.getAccountMaxReadCapacityUnits() == null) ^ (getAccountMaxReadCapacityUnits() == null)) {
            return false;
        }
        if (describeLimitsResult.getAccountMaxReadCapacityUnits() != null && !describeLimitsResult.getAccountMaxReadCapacityUnits().equals(getAccountMaxReadCapacityUnits())) {
            return false;
        }
        if ((describeLimitsResult.getAccountMaxWriteCapacityUnits() == null) ^ (getAccountMaxWriteCapacityUnits() == null)) {
            return false;
        }
        if (describeLimitsResult.getAccountMaxWriteCapacityUnits() != null && !describeLimitsResult.getAccountMaxWriteCapacityUnits().equals(getAccountMaxWriteCapacityUnits())) {
            return false;
        }
        if ((describeLimitsResult.getTableMaxReadCapacityUnits() == null) ^ (getTableMaxReadCapacityUnits() == null)) {
            return false;
        }
        if (describeLimitsResult.getTableMaxReadCapacityUnits() != null && !describeLimitsResult.getTableMaxReadCapacityUnits().equals(getTableMaxReadCapacityUnits())) {
            return false;
        }
        if ((describeLimitsResult.getTableMaxWriteCapacityUnits() == null) ^ (getTableMaxWriteCapacityUnits() == null)) {
            return false;
        }
        return describeLimitsResult.getTableMaxWriteCapacityUnits() == null || describeLimitsResult.getTableMaxWriteCapacityUnits().equals(getTableMaxWriteCapacityUnits());
    }
}
