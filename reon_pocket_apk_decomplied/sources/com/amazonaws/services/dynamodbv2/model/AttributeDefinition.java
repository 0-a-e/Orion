package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class AttributeDefinition implements Serializable {
    private String attributeName;
    private String attributeType;

    public AttributeDefinition() {
    }

    public AttributeDefinition(String str, String str2) {
        setAttributeName(str);
        setAttributeType(str2);
    }

    public AttributeDefinition(String str, ScalarAttributeType scalarAttributeType) {
        setAttributeName(str);
        setAttributeType(scalarAttributeType.toString());
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public AttributeDefinition withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public String getAttributeType() {
        return this.attributeType;
    }

    public void setAttributeType(String str) {
        this.attributeType = str;
    }

    public AttributeDefinition withAttributeType(String str) {
        this.attributeType = str;
        return this;
    }

    public void setAttributeType(ScalarAttributeType scalarAttributeType) {
        this.attributeType = scalarAttributeType.toString();
    }

    public AttributeDefinition withAttributeType(ScalarAttributeType scalarAttributeType) {
        this.attributeType = scalarAttributeType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName() + ",");
        }
        if (getAttributeType() != null) {
            sb.append("AttributeType: " + getAttributeType());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeName() == null ? 0 : getAttributeName().hashCode()) + 31) * 31;
        if (getAttributeType() != null) {
            i = getAttributeType().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AttributeDefinition)) {
            return false;
        }
        AttributeDefinition attributeDefinition = (AttributeDefinition) obj;
        if ((attributeDefinition.getAttributeName() == null) ^ (getAttributeName() == null)) {
            return false;
        }
        if (attributeDefinition.getAttributeName() != null && !attributeDefinition.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        if ((attributeDefinition.getAttributeType() == null) ^ (getAttributeType() == null)) {
            return false;
        }
        return attributeDefinition.getAttributeType() == null || attributeDefinition.getAttributeType().equals(getAttributeType());
    }
}
