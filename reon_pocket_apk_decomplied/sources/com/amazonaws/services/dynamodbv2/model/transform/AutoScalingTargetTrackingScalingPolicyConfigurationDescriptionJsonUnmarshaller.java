package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller implements Unmarshaller<AutoScalingTargetTrackingScalingPolicyConfigurationDescription, JsonUnmarshallerContext> {
    private static AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller instance;

    AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller() {
    }

    public AutoScalingTargetTrackingScalingPolicyConfigurationDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AutoScalingTargetTrackingScalingPolicyConfigurationDescription autoScalingTargetTrackingScalingPolicyConfigurationDescription = new AutoScalingTargetTrackingScalingPolicyConfigurationDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("DisableScaleIn")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setDisableScaleIn(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ScaleInCooldown")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setScaleInCooldown(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ScaleOutCooldown")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setScaleOutCooldown(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TargetValue")) {
                autoScalingTargetTrackingScalingPolicyConfigurationDescription.setTargetValue(SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return autoScalingTargetTrackingScalingPolicyConfigurationDescription;
    }

    public static AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
