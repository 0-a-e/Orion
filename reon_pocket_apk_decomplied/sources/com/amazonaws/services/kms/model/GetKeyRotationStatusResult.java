package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.Date;

public class GetKeyRotationStatusResult implements Serializable {
    private String keyId;
    private Boolean keyRotationEnabled;
    private Date nextRotationDate;
    private Date onDemandRotationStartDate;
    private Integer rotationPeriodInDays;

    public Boolean isKeyRotationEnabled() {
        return this.keyRotationEnabled;
    }

    public Boolean getKeyRotationEnabled() {
        return this.keyRotationEnabled;
    }

    public void setKeyRotationEnabled(Boolean bool) {
        this.keyRotationEnabled = bool;
    }

    public GetKeyRotationStatusResult withKeyRotationEnabled(Boolean bool) {
        this.keyRotationEnabled = bool;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GetKeyRotationStatusResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Integer getRotationPeriodInDays() {
        return this.rotationPeriodInDays;
    }

    public void setRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
    }

    public GetKeyRotationStatusResult withRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
        return this;
    }

    public Date getNextRotationDate() {
        return this.nextRotationDate;
    }

    public void setNextRotationDate(Date date) {
        this.nextRotationDate = date;
    }

    public GetKeyRotationStatusResult withNextRotationDate(Date date) {
        this.nextRotationDate = date;
        return this;
    }

    public Date getOnDemandRotationStartDate() {
        return this.onDemandRotationStartDate;
    }

    public void setOnDemandRotationStartDate(Date date) {
        this.onDemandRotationStartDate = date;
    }

    public GetKeyRotationStatusResult withOnDemandRotationStartDate(Date date) {
        this.onDemandRotationStartDate = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyRotationEnabled() != null) {
            sb.append("KeyRotationEnabled: " + getKeyRotationEnabled() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getRotationPeriodInDays() != null) {
            sb.append("RotationPeriodInDays: " + getRotationPeriodInDays() + ",");
        }
        if (getNextRotationDate() != null) {
            sb.append("NextRotationDate: " + getNextRotationDate() + ",");
        }
        if (getOnDemandRotationStartDate() != null) {
            sb.append("OnDemandRotationStartDate: " + getOnDemandRotationStartDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((getKeyRotationEnabled() == null ? 0 : getKeyRotationEnabled().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getRotationPeriodInDays() == null ? 0 : getRotationPeriodInDays().hashCode())) * 31) + (getNextRotationDate() == null ? 0 : getNextRotationDate().hashCode())) * 31;
        if (getOnDemandRotationStartDate() != null) {
            i = getOnDemandRotationStartDate().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyRotationStatusResult)) {
            return false;
        }
        GetKeyRotationStatusResult getKeyRotationStatusResult = (GetKeyRotationStatusResult) obj;
        if ((getKeyRotationStatusResult.getKeyRotationEnabled() == null) ^ (getKeyRotationEnabled() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getKeyRotationEnabled() != null && !getKeyRotationStatusResult.getKeyRotationEnabled().equals(getKeyRotationEnabled())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getKeyId() != null && !getKeyRotationStatusResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getRotationPeriodInDays() == null) ^ (getRotationPeriodInDays() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getRotationPeriodInDays() != null && !getKeyRotationStatusResult.getRotationPeriodInDays().equals(getRotationPeriodInDays())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getNextRotationDate() == null) ^ (getNextRotationDate() == null)) {
            return false;
        }
        if (getKeyRotationStatusResult.getNextRotationDate() != null && !getKeyRotationStatusResult.getNextRotationDate().equals(getNextRotationDate())) {
            return false;
        }
        if ((getKeyRotationStatusResult.getOnDemandRotationStartDate() == null) ^ (getOnDemandRotationStartDate() == null)) {
            return false;
        }
        return getKeyRotationStatusResult.getOnDemandRotationStartDate() == null || getKeyRotationStatusResult.getOnDemandRotationStartDate().equals(getOnDemandRotationStartDate());
    }
}
