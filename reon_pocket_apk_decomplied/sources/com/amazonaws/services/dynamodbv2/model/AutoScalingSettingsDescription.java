package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AutoScalingSettingsDescription implements Serializable {
    private Boolean autoScalingDisabled;
    private String autoScalingRoleArn;
    private Long maximumUnits;
    private Long minimumUnits;
    private List<AutoScalingPolicyDescription> scalingPolicies;

    public Long getMinimumUnits() {
        return this.minimumUnits;
    }

    public void setMinimumUnits(Long l) {
        this.minimumUnits = l;
    }

    public AutoScalingSettingsDescription withMinimumUnits(Long l) {
        this.minimumUnits = l;
        return this;
    }

    public Long getMaximumUnits() {
        return this.maximumUnits;
    }

    public void setMaximumUnits(Long l) {
        this.maximumUnits = l;
    }

    public AutoScalingSettingsDescription withMaximumUnits(Long l) {
        this.maximumUnits = l;
        return this;
    }

    public Boolean isAutoScalingDisabled() {
        return this.autoScalingDisabled;
    }

    public Boolean getAutoScalingDisabled() {
        return this.autoScalingDisabled;
    }

    public void setAutoScalingDisabled(Boolean bool) {
        this.autoScalingDisabled = bool;
    }

    public AutoScalingSettingsDescription withAutoScalingDisabled(Boolean bool) {
        this.autoScalingDisabled = bool;
        return this;
    }

    public String getAutoScalingRoleArn() {
        return this.autoScalingRoleArn;
    }

    public void setAutoScalingRoleArn(String str) {
        this.autoScalingRoleArn = str;
    }

    public AutoScalingSettingsDescription withAutoScalingRoleArn(String str) {
        this.autoScalingRoleArn = str;
        return this;
    }

    public List<AutoScalingPolicyDescription> getScalingPolicies() {
        return this.scalingPolicies;
    }

    public void setScalingPolicies(Collection<AutoScalingPolicyDescription> collection) {
        if (collection == null) {
            this.scalingPolicies = null;
        } else {
            this.scalingPolicies = new ArrayList(collection);
        }
    }

    public AutoScalingSettingsDescription withScalingPolicies(AutoScalingPolicyDescription... autoScalingPolicyDescriptionArr) {
        if (getScalingPolicies() == null) {
            this.scalingPolicies = new ArrayList(autoScalingPolicyDescriptionArr.length);
        }
        for (AutoScalingPolicyDescription add : autoScalingPolicyDescriptionArr) {
            this.scalingPolicies.add(add);
        }
        return this;
    }

    public AutoScalingSettingsDescription withScalingPolicies(Collection<AutoScalingPolicyDescription> collection) {
        setScalingPolicies(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getMinimumUnits() != null) {
            sb.append("MinimumUnits: " + getMinimumUnits() + ",");
        }
        if (getMaximumUnits() != null) {
            sb.append("MaximumUnits: " + getMaximumUnits() + ",");
        }
        if (getAutoScalingDisabled() != null) {
            sb.append("AutoScalingDisabled: " + getAutoScalingDisabled() + ",");
        }
        if (getAutoScalingRoleArn() != null) {
            sb.append("AutoScalingRoleArn: " + getAutoScalingRoleArn() + ",");
        }
        if (getScalingPolicies() != null) {
            sb.append("ScalingPolicies: " + getScalingPolicies());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((getMinimumUnits() == null ? 0 : getMinimumUnits().hashCode()) + 31) * 31) + (getMaximumUnits() == null ? 0 : getMaximumUnits().hashCode())) * 31) + (getAutoScalingDisabled() == null ? 0 : getAutoScalingDisabled().hashCode())) * 31) + (getAutoScalingRoleArn() == null ? 0 : getAutoScalingRoleArn().hashCode())) * 31;
        if (getScalingPolicies() != null) {
            i = getScalingPolicies().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AutoScalingSettingsDescription)) {
            return false;
        }
        AutoScalingSettingsDescription autoScalingSettingsDescription = (AutoScalingSettingsDescription) obj;
        if ((autoScalingSettingsDescription.getMinimumUnits() == null) ^ (getMinimumUnits() == null)) {
            return false;
        }
        if (autoScalingSettingsDescription.getMinimumUnits() != null && !autoScalingSettingsDescription.getMinimumUnits().equals(getMinimumUnits())) {
            return false;
        }
        if ((autoScalingSettingsDescription.getMaximumUnits() == null) ^ (getMaximumUnits() == null)) {
            return false;
        }
        if (autoScalingSettingsDescription.getMaximumUnits() != null && !autoScalingSettingsDescription.getMaximumUnits().equals(getMaximumUnits())) {
            return false;
        }
        if ((autoScalingSettingsDescription.getAutoScalingDisabled() == null) ^ (getAutoScalingDisabled() == null)) {
            return false;
        }
        if (autoScalingSettingsDescription.getAutoScalingDisabled() != null && !autoScalingSettingsDescription.getAutoScalingDisabled().equals(getAutoScalingDisabled())) {
            return false;
        }
        if ((autoScalingSettingsDescription.getAutoScalingRoleArn() == null) ^ (getAutoScalingRoleArn() == null)) {
            return false;
        }
        if (autoScalingSettingsDescription.getAutoScalingRoleArn() != null && !autoScalingSettingsDescription.getAutoScalingRoleArn().equals(getAutoScalingRoleArn())) {
            return false;
        }
        if ((autoScalingSettingsDescription.getScalingPolicies() == null) ^ (getScalingPolicies() == null)) {
            return false;
        }
        return autoScalingSettingsDescription.getScalingPolicies() == null || autoScalingSettingsDescription.getScalingPolicies().equals(getScalingPolicies());
    }
}
