package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyUpdate;
import com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsUpdate;
import com.amazonaws.util.json.AwsJsonWriter;

class AutoScalingSettingsUpdateJsonMarshaller {
    private static AutoScalingSettingsUpdateJsonMarshaller instance;

    AutoScalingSettingsUpdateJsonMarshaller() {
    }

    public void marshall(AutoScalingSettingsUpdate autoScalingSettingsUpdate, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (autoScalingSettingsUpdate.getMinimumUnits() != null) {
            Long minimumUnits = autoScalingSettingsUpdate.getMinimumUnits();
            awsJsonWriter.name("MinimumUnits");
            awsJsonWriter.value((Number) minimumUnits);
        }
        if (autoScalingSettingsUpdate.getMaximumUnits() != null) {
            Long maximumUnits = autoScalingSettingsUpdate.getMaximumUnits();
            awsJsonWriter.name("MaximumUnits");
            awsJsonWriter.value((Number) maximumUnits);
        }
        if (autoScalingSettingsUpdate.getAutoScalingDisabled() != null) {
            Boolean autoScalingDisabled = autoScalingSettingsUpdate.getAutoScalingDisabled();
            awsJsonWriter.name("AutoScalingDisabled");
            awsJsonWriter.value(autoScalingDisabled.booleanValue());
        }
        if (autoScalingSettingsUpdate.getAutoScalingRoleArn() != null) {
            String autoScalingRoleArn = autoScalingSettingsUpdate.getAutoScalingRoleArn();
            awsJsonWriter.name("AutoScalingRoleArn");
            awsJsonWriter.value(autoScalingRoleArn);
        }
        if (autoScalingSettingsUpdate.getScalingPolicyUpdate() != null) {
            AutoScalingPolicyUpdate scalingPolicyUpdate = autoScalingSettingsUpdate.getScalingPolicyUpdate();
            awsJsonWriter.name("ScalingPolicyUpdate");
            AutoScalingPolicyUpdateJsonMarshaller.getInstance().marshall(scalingPolicyUpdate, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static AutoScalingSettingsUpdateJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingSettingsUpdateJsonMarshaller();
        }
        return instance;
    }
}
