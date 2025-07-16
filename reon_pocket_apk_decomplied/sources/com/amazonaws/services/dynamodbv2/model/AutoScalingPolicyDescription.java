package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class AutoScalingPolicyDescription implements Serializable {
    private String policyName;
    private AutoScalingTargetTrackingScalingPolicyConfigurationDescription targetTrackingScalingPolicyConfiguration;

    public String getPolicyName() {
        return this.policyName;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public AutoScalingPolicyDescription withPolicyName(String str) {
        this.policyName = str;
        return this;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationDescription getTargetTrackingScalingPolicyConfiguration() {
        return this.targetTrackingScalingPolicyConfiguration;
    }

    public void setTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationDescription autoScalingTargetTrackingScalingPolicyConfigurationDescription) {
        this.targetTrackingScalingPolicyConfiguration = autoScalingTargetTrackingScalingPolicyConfigurationDescription;
    }

    public AutoScalingPolicyDescription withTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationDescription autoScalingTargetTrackingScalingPolicyConfigurationDescription) {
        this.targetTrackingScalingPolicyConfiguration = autoScalingTargetTrackingScalingPolicyConfigurationDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPolicyName() != null) {
            sb.append("PolicyName: " + getPolicyName() + ",");
        }
        if (getTargetTrackingScalingPolicyConfiguration() != null) {
            sb.append("TargetTrackingScalingPolicyConfiguration: " + getTargetTrackingScalingPolicyConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + 31) * 31;
        if (getTargetTrackingScalingPolicyConfiguration() != null) {
            i = getTargetTrackingScalingPolicyConfiguration().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AutoScalingPolicyDescription)) {
            return false;
        }
        AutoScalingPolicyDescription autoScalingPolicyDescription = (AutoScalingPolicyDescription) obj;
        if ((autoScalingPolicyDescription.getPolicyName() == null) ^ (getPolicyName() == null)) {
            return false;
        }
        if (autoScalingPolicyDescription.getPolicyName() != null && !autoScalingPolicyDescription.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if ((autoScalingPolicyDescription.getTargetTrackingScalingPolicyConfiguration() == null) ^ (getTargetTrackingScalingPolicyConfiguration() == null)) {
            return false;
        }
        return autoScalingPolicyDescription.getTargetTrackingScalingPolicyConfiguration() == null || autoScalingPolicyDescription.getTargetTrackingScalingPolicyConfiguration().equals(getTargetTrackingScalingPolicyConfiguration());
    }
}
