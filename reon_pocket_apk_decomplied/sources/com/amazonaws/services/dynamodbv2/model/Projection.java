package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Projection implements Serializable {
    private List<String> nonKeyAttributes;
    private String projectionType;

    public String getProjectionType() {
        return this.projectionType;
    }

    public void setProjectionType(String str) {
        this.projectionType = str;
    }

    public Projection withProjectionType(String str) {
        this.projectionType = str;
        return this;
    }

    public void setProjectionType(ProjectionType projectionType2) {
        this.projectionType = projectionType2.toString();
    }

    public Projection withProjectionType(ProjectionType projectionType2) {
        this.projectionType = projectionType2.toString();
        return this;
    }

    public List<String> getNonKeyAttributes() {
        return this.nonKeyAttributes;
    }

    public void setNonKeyAttributes(Collection<String> collection) {
        if (collection == null) {
            this.nonKeyAttributes = null;
        } else {
            this.nonKeyAttributes = new ArrayList(collection);
        }
    }

    public Projection withNonKeyAttributes(String... strArr) {
        if (getNonKeyAttributes() == null) {
            this.nonKeyAttributes = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.nonKeyAttributes.add(add);
        }
        return this;
    }

    public Projection withNonKeyAttributes(Collection<String> collection) {
        setNonKeyAttributes(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getProjectionType() != null) {
            sb.append("ProjectionType: " + getProjectionType() + ",");
        }
        if (getNonKeyAttributes() != null) {
            sb.append("NonKeyAttributes: " + getNonKeyAttributes());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getProjectionType() == null ? 0 : getProjectionType().hashCode()) + 31) * 31;
        if (getNonKeyAttributes() != null) {
            i = getNonKeyAttributes().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Projection)) {
            return false;
        }
        Projection projection = (Projection) obj;
        if ((projection.getProjectionType() == null) ^ (getProjectionType() == null)) {
            return false;
        }
        if (projection.getProjectionType() != null && !projection.getProjectionType().equals(getProjectionType())) {
            return false;
        }
        if ((projection.getNonKeyAttributes() == null) ^ (getNonKeyAttributes() == null)) {
            return false;
        }
        return projection.getNonKeyAttributes() == null || projection.getNonKeyAttributes().equals(getNonKeyAttributes());
    }
}
