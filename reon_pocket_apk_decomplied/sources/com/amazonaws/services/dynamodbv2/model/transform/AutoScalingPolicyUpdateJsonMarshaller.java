package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyUpdate;
import com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationUpdate;
import com.amazonaws.util.json.AwsJsonWriter;

class AutoScalingPolicyUpdateJsonMarshaller {
    private static AutoScalingPolicyUpdateJsonMarshaller instance;

    AutoScalingPolicyUpdateJsonMarshaller() {
    }

    public void marshall(AutoScalingPolicyUpdate autoScalingPolicyUpdate, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (autoScalingPolicyUpdate.getPolicyName() != null) {
            String policyName = autoScalingPolicyUpdate.getPolicyName();
            awsJsonWriter.name("PolicyName");
            awsJsonWriter.value(policyName);
        }
        if (autoScalingPolicyUpdate.getTargetTrackingScalingPolicyConfiguration() != null) {
            AutoScalingTargetTrackingScalingPolicyConfigurationUpdate targetTrackingScalingPolicyConfiguration = autoScalingPolicyUpdate.getTargetTrackingScalingPolicyConfiguration();
            awsJsonWriter.name("TargetTrackingScalingPolicyConfiguration");
            AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonMarshaller.getInstance().marshall(targetTrackingScalingPolicyConfiguration, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static AutoScalingPolicyUpdateJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingPolicyUpdateJsonMarshaller();
        }
        return instance;
    }
}
