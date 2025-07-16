package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class AutoScalingPolicyUpdate implements Serializable {
    private String policyName;
    private AutoScalingTargetTrackingScalingPolicyConfigurationUpdate targetTrackingScalingPolicyConfiguration;

    public String getPolicyName() {
        return this.policyName;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public AutoScalingPolicyUpdate withPolicyName(String str) {
        this.policyName = str;
        return this;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate getTargetTrackingScalingPolicyConfiguration() {
        return this.targetTrackingScalingPolicyConfiguration;
    }

    public void setTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationUpdate autoScalingTargetTrackingScalingPolicyConfigurationUpdate) {
        this.targetTrackingScalingPolicyConfiguration = autoScalingTargetTrackingScalingPolicyConfigurationUpdate;
    }

    public AutoScalingPolicyUpdate withTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationUpdate autoScalingTargetTrackingScalingPolicyConfigurationUpdate) {
        this.targetTrackingScalingPolicyConfiguration = autoScalingTargetTrackingScalingPolicyConfigurationUpdate;
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
        if (obj == null || !(obj instanceof AutoScalingPolicyUpdate)) {
            return false;
        }
        AutoScalingPolicyUpdate autoScalingPolicyUpdate = (AutoScalingPolicyUpdate) obj;
        if ((autoScalingPolicyUpdate.getPolicyName() == null) ^ (getPolicyName() == null)) {
            return false;
        }
        if (autoScalingPolicyUpdate.getPolicyName() != null && !autoScalingPolicyUpdate.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if ((autoScalingPolicyUpdate.getTargetTrackingScalingPolicyConfiguration() == null) ^ (getTargetTrackingScalingPolicyConfiguration() == null)) {
            return false;
        }
        return autoScalingPolicyUpdate.getTargetTrackingScalingPolicyConfiguration() == null || autoScalingPolicyUpdate.getTargetTrackingScalingPolicyConfiguration().equals(getTargetTrackingScalingPolicyConfiguration());
    }
}
