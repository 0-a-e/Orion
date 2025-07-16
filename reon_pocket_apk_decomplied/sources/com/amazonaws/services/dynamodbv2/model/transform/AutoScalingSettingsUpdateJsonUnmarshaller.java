package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AutoScalingSettingsUpdateJsonUnmarshaller implements Unmarshaller<AutoScalingSettingsUpdate, JsonUnmarshallerContext> {
    private static AutoScalingSettingsUpdateJsonUnmarshaller instance;

    AutoScalingSettingsUpdateJsonUnmarshaller() {
    }

    public AutoScalingSettingsUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AutoScalingSettingsUpdate autoScalingSettingsUpdate = new AutoScalingSettingsUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("MinimumUnits")) {
                autoScalingSettingsUpdate.setMinimumUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MaximumUnits")) {
                autoScalingSettingsUpdate.setMaximumUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AutoScalingDisabled")) {
                autoScalingSettingsUpdate.setAutoScalingDisabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AutoScalingRoleArn")) {
                autoScalingSettingsUpdate.setAutoScalingRoleArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ScalingPolicyUpdate")) {
                autoScalingSettingsUpdate.setScalingPolicyUpdate(AutoScalingPolicyUpdateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return autoScalingSettingsUpdate;
    }

    public static AutoScalingSettingsUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingSettingsUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
