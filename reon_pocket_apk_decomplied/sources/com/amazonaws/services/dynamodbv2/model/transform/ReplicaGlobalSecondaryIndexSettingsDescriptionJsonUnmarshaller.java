package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller implements Unmarshaller<ReplicaGlobalSecondaryIndexSettingsDescription, JsonUnmarshallerContext> {
    private static ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller instance;

    ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller() {
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ReplicaGlobalSecondaryIndexSettingsDescription replicaGlobalSecondaryIndexSettingsDescription = new ReplicaGlobalSecondaryIndexSettingsDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                replicaGlobalSecondaryIndexSettingsDescription.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("IndexStatus")) {
                replicaGlobalSecondaryIndexSettingsDescription.setIndexStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedReadCapacityUnits")) {
                replicaGlobalSecondaryIndexSettingsDescription.setProvisionedReadCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedReadCapacityAutoScalingSettings")) {
                replicaGlobalSecondaryIndexSettingsDescription.setProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedWriteCapacityUnits")) {
                replicaGlobalSecondaryIndexSettingsDescription.setProvisionedWriteCapacityUnits(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedWriteCapacityAutoScalingSettings")) {
                replicaGlobalSecondaryIndexSettingsDescription.setProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replicaGlobalSecondaryIndexSettingsDescription;
    }

    public static ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
