package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class KeySchemaElement implements Serializable {
    private String attributeName;
    private String keyType;

    public KeySchemaElement() {
    }

    public KeySchemaElement(String str, String str2) {
        setAttributeName(str);
        setKeyType(str2);
    }

    public KeySchemaElement(String str, KeyType keyType2) {
        setAttributeName(str);
        setKeyType(keyType2.toString());
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public KeySchemaElement withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public String getKeyType() {
        return this.keyType;
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }

    public KeySchemaElement withKeyType(String str) {
        this.keyType = str;
        return this;
    }

    public void setKeyType(KeyType keyType2) {
        this.keyType = keyType2.toString();
    }

    public KeySchemaElement withKeyType(KeyType keyType2) {
        this.keyType = keyType2.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName() + ",");
        }
        if (getKeyType() != null) {
            sb.append("KeyType: " + getKeyType());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeName() == null ? 0 : getAttributeName().hashCode()) + 31) * 31;
        if (getKeyType() != null) {
            i = getKeyType().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeySchemaElement)) {
            return false;
        }
        KeySchemaElement keySchemaElement = (KeySchemaElement) obj;
        if ((keySchemaElement.getAttributeName() == null) ^ (getAttributeName() == null)) {
            return false;
        }
        if (keySchemaElement.getAttributeName() != null && !keySchemaElement.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        if ((keySchemaElement.getKeyType() == null) ^ (getKeyType() == null)) {
            return false;
        }
        return keySchemaElement.getKeyType() == null || keySchemaElement.getKeyType().equals(getKeyType());
    }
}
