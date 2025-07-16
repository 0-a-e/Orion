package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class AttributeValueUpdate implements Serializable {
    private String action;
    private AttributeValue value;

    public AttributeValueUpdate() {
    }

    public AttributeValueUpdate(AttributeValue attributeValue, String str) {
        setValue(attributeValue);
        setAction(str);
    }

    public AttributeValueUpdate(AttributeValue attributeValue, AttributeAction attributeAction) {
        setValue(attributeValue);
        setAction(attributeAction.toString());
    }

    public AttributeValue getValue() {
        return this.value;
    }

    public void setValue(AttributeValue attributeValue) {
        this.value = attributeValue;
    }

    public AttributeValueUpdate withValue(AttributeValue attributeValue) {
        this.value = attributeValue;
        return this;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public AttributeValueUpdate withAction(String str) {
        this.action = str;
        return this;
    }

    public void setAction(AttributeAction attributeAction) {
        this.action = attributeAction.toString();
    }

    public AttributeValueUpdate withAction(AttributeAction attributeAction) {
        this.action = attributeAction.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getValue() != null) {
            sb.append("Value: " + getValue() + ",");
        }
        if (getAction() != null) {
            sb.append("Action: " + getAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getValue() == null ? 0 : getValue().hashCode()) + 31) * 31;
        if (getAction() != null) {
            i = getAction().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AttributeValueUpdate)) {
            return false;
        }
        AttributeValueUpdate attributeValueUpdate = (AttributeValueUpdate) obj;
        if ((attributeValueUpdate.getValue() == null) ^ (getValue() == null)) {
            return false;
        }
        if (attributeValueUpdate.getValue() != null && !attributeValueUpdate.getValue().equals(getValue())) {
            return false;
        }
        if ((attributeValueUpdate.getAction() == null) ^ (getAction() == null)) {
            return false;
        }
        return attributeValueUpdate.getAction() == null || attributeValueUpdate.getAction().equals(getAction());
    }
}
