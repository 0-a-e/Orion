package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class DescribeKeyResult implements Serializable {
    private KeyMetadata keyMetadata;

    public KeyMetadata getKeyMetadata() {
        return this.keyMetadata;
    }

    public void setKeyMetadata(KeyMetadata keyMetadata2) {
        this.keyMetadata = keyMetadata2;
    }

    public DescribeKeyResult withKeyMetadata(KeyMetadata keyMetadata2) {
        this.keyMetadata = keyMetadata2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyMetadata() != null) {
            sb.append("KeyMetadata: " + getKeyMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getKeyMetadata() == null ? 0 : getKeyMetadata().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeKeyResult)) {
            return false;
        }
        DescribeKeyResult describeKeyResult = (DescribeKeyResult) obj;
        if ((describeKeyResult.getKeyMetadata() == null) ^ (getKeyMetadata() == null)) {
            return false;
        }
        return describeKeyResult.getKeyMetadata() == null || describeKeyResult.getKeyMetadata().equals(getKeyMetadata());
    }
}
