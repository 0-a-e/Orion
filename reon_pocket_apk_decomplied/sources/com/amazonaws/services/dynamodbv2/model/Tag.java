package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class Tag implements Serializable {
    private String key;
    private String value;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public Tag withKey(String str) {
        this.key = str;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public Tag withValue(String str) {
        this.value = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKey() != null) {
            sb.append("Key: " + getKey() + ",");
        }
        if (getValue() != null) {
            sb.append("Value: " + getValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKey() == null ? 0 : getKey().hashCode()) + 31) * 31;
        if (getValue() != null) {
            i = getValue().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if ((tag.getKey() == null) ^ (getKey() == null)) {
            return false;
        }
        if (tag.getKey() != null && !tag.getKey().equals(getKey())) {
            return false;
        }
        if ((tag.getValue() == null) ^ (getValue() == null)) {
            return false;
        }
        return tag.getValue() == null || tag.getValue().equals(getValue());
    }
}
