package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.Date;

public class RotationsListEntry implements Serializable {
    private String keyId;
    private Date rotationDate;
    private String rotationType;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public RotationsListEntry withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Date getRotationDate() {
        return this.rotationDate;
    }

    public void setRotationDate(Date date) {
        this.rotationDate = date;
    }

    public RotationsListEntry withRotationDate(Date date) {
        this.rotationDate = date;
        return this;
    }

    public String getRotationType() {
        return this.rotationType;
    }

    public void setRotationType(String str) {
        this.rotationType = str;
    }

    public RotationsListEntry withRotationType(String str) {
        this.rotationType = str;
        return this;
    }

    public void setRotationType(RotationType rotationType2) {
        this.rotationType = rotationType2.toString();
    }

    public RotationsListEntry withRotationType(RotationType rotationType2) {
        this.rotationType = rotationType2.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getRotationDate() != null) {
            sb.append("RotationDate: " + getRotationDate() + ",");
        }
        if (getRotationType() != null) {
            sb.append("RotationType: " + getRotationType());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getRotationDate() == null ? 0 : getRotationDate().hashCode())) * 31;
        if (getRotationType() != null) {
            i = getRotationType().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RotationsListEntry)) {
            return false;
        }
        RotationsListEntry rotationsListEntry = (RotationsListEntry) obj;
        if ((rotationsListEntry.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (rotationsListEntry.getKeyId() != null && !rotationsListEntry.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((rotationsListEntry.getRotationDate() == null) ^ (getRotationDate() == null)) {
            return false;
        }
        if (rotationsListEntry.getRotationDate() != null && !rotationsListEntry.getRotationDate().equals(getRotationDate())) {
            return false;
        }
        if ((rotationsListEntry.getRotationType() == null) ^ (getRotationType() == null)) {
            return false;
        }
        return rotationsListEntry.getRotationType() == null || rotationsListEntry.getRotationType().equals(getRotationType());
    }
}
