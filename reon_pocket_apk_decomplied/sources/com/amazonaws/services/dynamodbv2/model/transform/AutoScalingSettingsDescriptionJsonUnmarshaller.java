package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class AutoScalingSettingsDescriptionJsonUnmarshaller implements Unmarshaller<AutoScalingSettingsDescription, JsonUnmarshallerContext> {
    private static AutoScalingSettingsDescriptionJsonUnmarshaller instance;

    AutoScalingSettingsDescriptionJsonUnmarshaller() {
    }

    public AutoScalingSettingsDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AutoScalingSettingsDescription autoScalingSettingsDescription = new AutoScalingSettingsDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("MinimumUnits")) {
                autoScalingSettingsDescription.setMinimumUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("MaximumUnits")) {
                autoScalingSettingsDescription.setMaximumUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AutoScalingDisabled")) {
                autoScalingSettingsDescription.setAutoScalingDisabled(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AutoScalingRoleArn")) {
                autoScalingSettingsDescription.setAutoScalingRoleArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ScalingPolicies")) {
                autoScalingSettingsDescription.setScalingPolicies(new ListUnmarshaller(AutoScalingPolicyDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return autoScalingSettingsDescription;
    }

    public static AutoScalingSettingsDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AutoScalingSettingsDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
