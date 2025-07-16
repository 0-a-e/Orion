package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AutoScalingPolicyUpdateJsonUnmarshaller implements Unmarshaller<AutoScalingPolicyUpdate, JsonUnmarshallerContext> {
    private static AutoScalingPolicyUpdateJsonUnmarshaller instance;

    AutoScalingPolicyUpdateJsonUnmarshaller() {
    }

    public AutoScalingPolicyUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AutoScalingPolicyUpdate autoScalingPolicyUpdate = new AutoScalingPolicyUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("PolicyName")) {
                autoScalingPolicyUpdate.setPolicyName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TargetTrackingScalingPolicyConfiguration")) {
                autoScalingPolicyUpdate.setTargetTrackingScalingPolicyConfiguration(AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return autoScalingPolicyUpdate;
    }

    public static AutoScalingPolicyUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingPolicyUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
