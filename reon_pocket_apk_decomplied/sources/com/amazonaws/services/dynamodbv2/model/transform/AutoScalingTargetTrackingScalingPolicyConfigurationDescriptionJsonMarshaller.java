package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationDescription;
import com.amazonaws.util.json.AwsJsonWriter;

class AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonMarshaller {
    private static AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonMarshaller instance;

    AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonMarshaller() {
    }

    public void marshall(AutoScalingTargetTrackingScalingPolicyConfigurationDescription autoScalingTargetTrackingScalingPolicyConfigurationDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (autoScalingTargetTrackingScalingPolicyConfigurationDescription.getDisableScaleIn() != null) {
            Boolean disableScaleIn = autoScalingTargetTrackingScalingPolicyConfigurationDescription.getDisableScaleIn();
            awsJsonWriter.name("DisableScaleIn");
            awsJsonWriter.value(disableScaleIn.booleanValue());
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleInCooldown() != null) {
            Integer scaleInCooldown = autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleInCooldown();
            awsJsonWriter.name("ScaleInCooldown");
            awsJsonWriter.value((Number) scaleInCooldown);
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleOutCooldown() != null) {
            Integer scaleOutCooldown = autoScalingTargetTrackingScalingPolicyConfigurationDescription.getScaleOutCooldown();
            awsJsonWriter.name("ScaleOutCooldown");
            awsJsonWriter.value((Number) scaleOutCooldown);
        }
        if (autoScalingTargetTrackingScalingPolicyConfigurationDescription.getTargetValue() != null) {
            Double targetValue = autoScalingTargetTrackingScalingPolicyConfigurationDescription.getTargetValue();
            awsJsonWriter.name("TargetValue");
            awsJsonWriter.value((Number) targetValue);
        }
        awsJsonWriter.endObject();
    }

    public static AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonMarshaller();
        }
        return instance;
    }
}
