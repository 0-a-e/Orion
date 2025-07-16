package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.Date;

public class ProvisionedThroughputDescription implements Serializable {
    private Date lastDecreaseDateTime;
    private Date lastIncreaseDateTime;
    private Long numberOfDecreasesToday;
    private Long readCapacityUnits;
    private Long writeCapacityUnits;

    public Date getLastIncreaseDateTime() {
        return this.lastIncreaseDateTime;
    }

    public void setLastIncreaseDateTime(Date date) {
        this.lastIncreaseDateTime = date;
    }

    public ProvisionedThroughputDescription withLastIncreaseDateTime(Date date) {
        this.lastIncreaseDateTime = date;
        return this;
    }

    public Date getLastDecreaseDateTime() {
        return this.lastDecreaseDateTime;
    }

    public void setLastDecreaseDateTime(Date date) {
        this.lastDecreaseDateTime = date;
    }

    public ProvisionedThroughputDescription withLastDecreaseDateTime(Date date) {
        this.lastDecreaseDateTime = date;
        return this;
    }

    public Long getNumberOfDecreasesToday() {
        return this.numberOfDecreasesToday;
    }

    public void setNumberOfDecreasesToday(Long l) {
        this.numberOfDecreasesToday = l;
    }

    public ProvisionedThroughputDescription withNumberOfDecreasesToday(Long l) {
        this.numberOfDecreasesToday = l;
        return this;
    }

    public Long getReadCapacityUnits() {
        return this.readCapacityUnits;
    }

    public void setReadCapacityUnits(Long l) {
        this.readCapacityUnits = l;
    }

    public ProvisionedThroughputDescription withReadCapacityUnits(Long l) {
        this.readCapacityUnits = l;
        return this;
    }

    public Long getWriteCapacityUnits() {
        return this.writeCapacityUnits;
    }

    public void setWriteCapacityUnits(Long l) {
        this.writeCapacityUnits = l;
    }

    public ProvisionedThroughputDescription withWriteCapacityUnits(Long l) {
        this.writeCapacityUnits = l;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getLastIncreaseDateTime() != null) {
            sb.append("LastIncreaseDateTime: " + getLastIncreaseDateTime() + ",");
        }
        if (getLastDecreaseDateTime() != null) {
            sb.append("LastDecreaseDateTime: " + getLastDecreaseDateTime() + ",");
        }
        if (getNumberOfDecreasesToday() != null) {
            sb.append("NumberOfDecreasesToday: " + getNumberOfDecreasesToday() + ",");
        }
        if (getReadCapacityUnits() != null) {
            sb.append("ReadCapacityUnits: " + getReadCapacityUnits() + ",");
        }
        if (getWriteCapacityUnits() != null) {
            sb.append("WriteCapacityUnits: " + getWriteCapacityUnits());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((getLastIncreaseDateTime() == null ? 0 : getLastIncreaseDateTime().hashCode()) + 31) * 31) + (getLastDecreaseDateTime() == null ? 0 : getLastDecreaseDateTime().hashCode())) * 31;
        if (getNumberOfDecreasesToday() == null) {
            i = 0;
        } else {
            i = getNumberOfDecreasesToday().hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + (getReadCapacityUnits() == null ? 0 : getReadCapacityUnits().hashCode())) * 31;
        if (getWriteCapacityUnits() != null) {
            i2 = getWriteCapacityUnits().hashCode();
        }
        return hashCode2 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProvisionedThroughputDescription)) {
            return false;
        }
        ProvisionedThroughputDescription provisionedThroughputDescription = (ProvisionedThroughputDescription) obj;
        if ((provisionedThroughputDescription.getLastIncreaseDateTime() == null) ^ (getLastIncreaseDateTime() == null)) {
            return false;
        }
        if (provisionedThroughputDescription.getLastIncreaseDateTime() != null && !provisionedThroughputDescription.getLastIncreaseDateTime().equals(getLastIncreaseDateTime())) {
            return false;
        }
        if ((provisionedThroughputDescription.getLastDecreaseDateTime() == null) ^ (getLastDecreaseDateTime() == null)) {
            return false;
        }
        if (provisionedThroughputDescription.getLastDecreaseDateTime() != null && !provisionedThroughputDescription.getLastDecreaseDateTime().equals(getLastDecreaseDateTime())) {
            return false;
        }
        if ((provisionedThroughputDescription.getNumberOfDecreasesToday() == null) ^ (getNumberOfDecreasesToday() == null)) {
            return false;
        }
        if (provisionedThroughputDescription.getNumberOfDecreasesToday() != null && !provisionedThroughputDescription.getNumberOfDecreasesToday().equals(getNumberOfDecreasesToday())) {
            return false;
        }
        if ((provisionedThroughputDescription.getReadCapacityUnits() == null) ^ (getReadCapacityUnits() == null)) {
            return false;
        }
        if (provisionedThroughputDescription.getReadCapacityUnits() != null && !provisionedThroughputDescription.getReadCapacityUnits().equals(getReadCapacityUnits())) {
            return false;
        }
        if ((provisionedThroughputDescription.getWriteCapacityUnits() == null) ^ (getWriteCapacityUnits() == null)) {
            return false;
        }
        return provisionedThroughputDescription.getWriteCapacityUnits() == null || provisionedThroughputDescription.getWriteCapacityUnits().equals(getWriteCapacityUnits());
    }
}
