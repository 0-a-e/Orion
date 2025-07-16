package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalTableGlobalSecondaryIndexSettingsUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller implements Unmarshaller<GlobalTableGlobalSecondaryIndexSettingsUpdate, JsonUnmarshallerContext> {
    private static GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller instance;

    GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller() {
    }

    public GlobalTableGlobalSecondaryIndexSettingsUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalTableGlobalSecondaryIndexSettingsUpdate globalTableGlobalSecondaryIndexSettingsUpdate = new GlobalTableGlobalSecondaryIndexSettingsUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                globalTableGlobalSecondaryIndexSettingsUpdate.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedWriteCapacityUnits")) {
                globalTableGlobalSecondaryIndexSettingsUpdate.setProvisionedWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedWriteCapacityAutoScalingSettingsUpdate")) {
                globalTableGlobalSecondaryIndexSettingsUpdate.setProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalTableGlobalSecondaryIndexSettingsUpdate;
    }

    public static GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
