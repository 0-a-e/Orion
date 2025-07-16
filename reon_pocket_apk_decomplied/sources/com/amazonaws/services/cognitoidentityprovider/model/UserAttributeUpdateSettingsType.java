package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserAttributeUpdateSettingsType implements Serializable {
    private List<String> attributesRequireVerificationBeforeUpdate;

    public List<String> getAttributesRequireVerificationBeforeUpdate() {
        return this.attributesRequireVerificationBeforeUpdate;
    }

    public void setAttributesRequireVerificationBeforeUpdate(Collection<String> collection) {
        if (collection == null) {
            this.attributesRequireVerificationBeforeUpdate = null;
        } else {
            this.attributesRequireVerificationBeforeUpdate = new ArrayList(collection);
        }
    }

    public UserAttributeUpdateSettingsType withAttributesRequireVerificationBeforeUpdate(String... strArr) {
        if (getAttributesRequireVerificationBeforeUpdate() == null) {
            this.attributesRequireVerificationBeforeUpdate = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.attributesRequireVerificationBeforeUpdate.add(add);
        }
        return this;
    }

    public UserAttributeUpdateSettingsType withAttributesRequireVerificationBeforeUpdate(Collection<String> collection) {
        setAttributesRequireVerificationBeforeUpdate(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAttributesRequireVerificationBeforeUpdate() != null) {
            sb.append("AttributesRequireVerificationBeforeUpdate: " + getAttributesRequireVerificationBeforeUpdate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        if (getAttributesRequireVerificationBeforeUpdate() == null) {
            i = 0;
        } else {
            i = getAttributesRequireVerificationBeforeUpdate().hashCode();
        }
        return 31 + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserAttributeUpdateSettingsType)) {
            return false;
        }
        UserAttributeUpdateSettingsType userAttributeUpdateSettingsType = (UserAttributeUpdateSettingsType) obj;
        if ((userAttributeUpdateSettingsType.getAttributesRequireVerificationBeforeUpdate() == null) ^ (getAttributesRequireVerificationBeforeUpdate() == null)) {
            return false;
        }
        return userAttributeUpdateSettingsType.getAttributesRequireVerificationBeforeUpdate() == null || userAttributeUpdateSettingsType.getAttributesRequireVerificationBeforeUpdate().equals(getAttributesRequireVerificationBeforeUpdate());
    }
}
