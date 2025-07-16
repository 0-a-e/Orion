package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ReplicaSettingsDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ReplicaSettingsDescriptionJsonUnmarshaller implements Unmarshaller<ReplicaSettingsDescription, JsonUnmarshallerContext> {
    private static ReplicaSettingsDescriptionJsonUnmarshaller instance;

    ReplicaSettingsDescriptionJsonUnmarshaller() {
    }

    public ReplicaSettingsDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ReplicaSettingsDescription replicaSettingsDescription = new ReplicaSettingsDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("RegionName")) {
                replicaSettingsDescription.setRegionName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaStatus")) {
                replicaSettingsDescription.setReplicaStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaProvisionedReadCapacityUnits")) {
                replicaSettingsDescription.setReplicaProvisionedReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaProvisionedReadCapacityAutoScalingSettings")) {
                replicaSettingsDescription.setReplicaProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaProvisionedWriteCapacityUnits")) {
                replicaSettingsDescription.setReplicaProvisionedWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaProvisionedWriteCapacityAutoScalingSettings")) {
                replicaSettingsDescription.setReplicaProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicaGlobalSecondaryIndexSettings")) {
                replicaSettingsDescription.setReplicaGlobalSecondaryIndexSettings(new ListUnmarshaller(ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replicaSettingsDescription;
    }

    public static ReplicaSettingsDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaSettingsDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
