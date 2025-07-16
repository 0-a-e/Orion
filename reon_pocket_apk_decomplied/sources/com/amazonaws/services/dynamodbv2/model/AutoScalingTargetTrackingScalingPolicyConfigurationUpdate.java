package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class AutoScalingTargetTrackingScalingPolicyConfigurationUpdate implements Serializable {
    private Boolean disableScaleIn;
    private Integer scaleInCooldown;
    private Integer scaleOutCooldown;
    private Double targetValue;

    public Boolean isDisableScaleIn() {
        return this.disableScaleIn;
    }

    public Boolean getDisableScaleIn() {
        return this.disableScaleIn;
    }

    public void setDisableScaleIn(Boolean bool) {
        this.disableScaleIn = bool;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withDisableScaleIn(Boolean bool) {
        this.disableScaleIn = bool;
        return this;
    }

    public Integer getScaleInCooldown() {
        return this.scaleInCooldown;
    }

    public void setScaleInCooldown(Integer num) {
        this.scaleInCooldown = num;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withScaleInCooldown(Integer num) {
        this.scaleInCooldown = num;
        return this;
    }

    public Integer getScaleOutCooldown() {
        return this.scaleOutCooldown;
    }

    public void setScaleOutCooldown(Integer num) {
        this.scaleOutCooldown = num;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withScaleOutCooldown(Integer num) {
        this.scaleOutCooldown = num;
        return this;
    }

    public Double getTargetValue() {
        return this.targetValue;
    }

    public void setTargetValue(Double d) {
        this.targetValue = d;
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate withTargetValue(Double d) {
        this.targetValue = d;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getDisableScaleIn() != null) {
            sb.append("DisableScaleIn: " + getDisableScaleIn() + ",");
        }
        if (getScaleInCooldown() != null) {
            sb.append("ScaleInCooldown: " + getScaleInCooldown() + ",");
        }
        if (getScaleOutCooldown() != null) {
            sb.append("ScaleOutCooldown: " + getScaleOutCooldown() + ",");
        }
        if (getTargetValue() != null) {
            sb.append("TargetValue: " + getTargetValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((getDisableScaleIn() == null ? 0 : getDisableScaleIn().hashCode()) + 31) * 31) + (getScaleInCooldown() == null ? 0 : getScaleInCooldown().hashCode())) * 31) + (getScaleOutCooldown() == null ? 0 : getScaleOutCooldown().hashCode())) * 31;
        if (getTargetValue() != null) {
            i = getTargetValue().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AutoScalingTargetTrackingScalingPolicyConfigurationUpdate)) {
            return false;
        }
        AutoScalingTargetTrackingScalingPolicyConfigurationUpdate autoScalingTargetTrackingScalingPolicyConfigurationUpdate = (AutoScalingTargetTrackingScalingPolicyConfigurationUpdate) obj;
        if ((autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getDisableScaleIn() == null) ^ (getDisableScaleIn() == null)) {
            return false;
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getDisableScaleIn() != null && !autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getDisableScaleIn().equals(getDisableScaleIn())) {
            return false;
        }
        if ((autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleInCooldown() == null) ^ (getScaleInCooldown() == null)) {
            return false;
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleInCooldown() != null && !autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleInCooldown().equals(getScaleInCooldown())) {
            return false;
        }
        if ((autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleOutCooldown() == null) ^ (getScaleOutCooldown() == null)) {
            return false;
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleOutCooldown() != null && !autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleOutCooldown().equals(getScaleOutCooldown())) {
            return false;
        }
        if ((autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getTargetValue() == null) ^ (getTargetValue() == null)) {
            return false;
        }
        return autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getTargetValue() == null || autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getTargetValue().equals(getTargetValue());
    }
}
