package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller implements Unmarshaller<ReplicaGlobalSecondaryIndexSettingsUpdate, JsonUnmarshallerContext> {
    private static ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller instance;

    ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller() {
    }

    public ReplicaGlobalSecondaryIndexSettingsUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ReplicaGlobalSecondaryIndexSettingsUpdate replicaGlobalSecondaryIndexSettingsUpdate = new ReplicaGlobalSecondaryIndexSettingsUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                replicaGlobalSecondaryIndexSettingsUpdate.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedReadCapacityUnits")) {
                replicaGlobalSecondaryIndexSettingsUpdate.setProvisionedReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedReadCapacityAutoScalingSettingsUpdate")) {
                replicaGlobalSecondaryIndexSettingsUpdate.setProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replicaGlobalSecondaryIndexSettingsUpdate;
    }

    public static ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
