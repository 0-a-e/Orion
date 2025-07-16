package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationUpdate;
import com.amazonaws.util.json.AwsJsonWriter;

class AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonMarshaller {
    private static AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonMarshaller instance;

    AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonMarshaller() {
    }

    public void marshall(AutoScalingTargetTrackingScalingPolicyConfigurationUpdate autoScalingTargetTrackingScalingPolicyConfigurationUpdate, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getDisableScaleIn() != null) {
            Boolean disableScaleIn = autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getDisableScaleIn();
            awsJsonWriter.name("DisableScaleIn");
            awsJsonWriter.value(disableScaleIn.booleanValue());
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleInCooldown() != null) {
            Integer scaleInCooldown = autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleInCooldown();
            awsJsonWriter.name("ScaleInCooldown");
            awsJsonWriter.value((Number) scaleInCooldown);
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleOutCooldown() != null) {
            Integer scaleOutCooldown = autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getScaleOutCooldown();
            awsJsonWriter.name("ScaleOutCooldown");
            awsJsonWriter.value((Number) scaleOutCooldown);
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getTargetValue() != null) {
            Double targetValue = autoScalingTargetTrackingScalingPolicyConfigurationUpdate.getTargetValue();
            awsJsonWriter.name("TargetValue");
            awsJsonWriter.value((Number) targetValue);
        }
        awsJsonWriter.endObject();
    }

    public static AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonMarshaller();
        }
        return instance;
    }
}
