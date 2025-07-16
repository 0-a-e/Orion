package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ReplicaSettingsUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ReplicaSettingsUpdateJsonUnmarshaller implements Unmarshaller<ReplicaSettingsUpdate, JsonUnmarshallerContext> {
    private static ReplicaSettingsUpdateJsonUnmarshaller instance;

    ReplicaSettingsUpdateJsonUnmarshaller() {
    }

    public ReplicaSettingsUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ReplicaSettingsUpdate replicaSettingsUpdate = new ReplicaSettingsUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("RegionName")) {
                replicaSettingsUpdate.setRegionName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaProvisionedReadCapacityUnits")) {
                replicaSettingsUpdate.setReplicaProvisionedReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate")) {
                replicaSettingsUpdate.setReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaGlobalSecondaryIndexSettingsUpdate")) {
                replicaSettingsUpdate.setReplicaGlobalSecondaryIndexSettingsUpdate(new ListUnmarshaller(ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replicaSettingsUpdate;
    }

    public static ReplicaSettingsUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaSettingsUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
