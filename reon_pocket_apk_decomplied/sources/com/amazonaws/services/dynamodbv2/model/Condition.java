package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Condition implements Serializable {
    private List<AttributeValue> attributeValueList;
    private String comparisonOperator;

    public List<AttributeValue> getAttributeValueList() {
        return this.attributeValueList;
    }

    public void setAttributeValueList(Collection<AttributeValue> collection) {
        if (collection == null) {
            this.attributeValueList = null;
        } else {
            this.attributeValueList = new ArrayList(collection);
        }
    }

    public Condition withAttributeValueList(AttributeValue... attributeValueArr) {
        if (getAttributeValueList() == null) {
            this.attributeValueList = new ArrayList(attributeValueArr.length);
        }
        for (AttributeValue add : attributeValueArr) {
            this.attributeValueList.add(add);
        }
        return this;
    }

    public Condition withAttributeValueList(Collection<AttributeValue> collection) {
        setAttributeValueList(collection);
        return this;
    }

    public String getComparisonOperator() {
        return this.comparisonOperator;
    }

    public void setComparisonOperator(String str) {
        this.comparisonOperator = str;
    }

    public Condition withComparisonOperator(String str) {
        this.comparisonOperator = str;
        return this;
    }

    public void setComparisonOperator(ComparisonOperator comparisonOperator2) {
        this.comparisonOperator = comparisonOperator2.toString();
    }

    public Condition withComparisonOperator(ComparisonOperator comparisonOperator2) {
        this.comparisonOperator = comparisonOperator2.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributeValueList() != null) {
            sb.append("AttributeValueList: " + getAttributeValueList() + ",");
        }
        if (getComparisonOperator() != null) {
            sb.append("ComparisonOperator: " + getComparisonOperator());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeValueList() == null ? 0 : getAttributeValueList().hashCode()) + 31) * 31;
        if (getComparisonOperator() != null) {
            i = getComparisonOperator().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Condition)) {
            return false;
        }
        Condition condition = (Condition) obj;
        if ((condition.getAttributeValueList() == null) ^ (getAttributeValueList() == null)) {
            return false;
        }
        if (condition.getAttributeValueList() != null && !condition.getAttributeValueList().equals(getAttributeValueList())) {
            return false;
        }
        if ((condition.getComparisonOperator() == null) ^ (getComparisonOperator() == null)) {
            return false;
        }
        return condition.getComparisonOperator() == null || condition.getComparisonOperator().equals(getComparisonOperator());
    }
}
