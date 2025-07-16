package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsDescription;
import com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsDescription;
import com.amazonaws.services.dynamodbv2.model.ReplicaSettingsDescription;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class ReplicaSettingsDescriptionJsonMarshaller {
    private static ReplicaSettingsDescriptionJsonMarshaller instance;

    ReplicaSettingsDescriptionJsonMarshaller() {
    }

    public void marshall(ReplicaSettingsDescription replicaSettingsDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (replicaSettingsDescription.getRegionName() != null) {
            String regionName = replicaSettingsDescription.getRegionName();
            awsJsonWriter.name("RegionName");
            awsJsonWriter.value(regionName);
        }
        if (replicaSettingsDescription.getReplicaStatus() != null) {
            String replicaStatus = replicaSettingsDescription.getReplicaStatus();
            awsJsonWriter.name("ReplicaStatus");
            awsJsonWriter.value(replicaStatus);
        }
        if (replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits() != null) {
            Long replicaProvisionedReadCapacityUnits = replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits();
            awsJsonWriter.name("ReplicaProvisionedReadCapacityUnits");
            awsJsonWriter.value((Number) replicaProvisionedReadCapacityUnits);
        }
        if (replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings() != null) {
            AutoScalingSettingsDescription replicaProvisionedReadCapacityAutoScalingSettings = replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings();
            awsJsonWriter.name("ReplicaProvisionedReadCapacityAutoScalingSettings");
            AutoScalingSettingsDescriptionJsonMarshaller.getInstance().marshall(replicaProvisionedReadCapacityAutoScalingSettings, awsJsonWriter);
        }
        if (replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits() != null) {
            Long replicaProvisionedWriteCapacityUnits = replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits();
            awsJsonWriter.name("ReplicaProvisionedWriteCapacityUnits");
            awsJsonWriter.value((Number) replicaProvisionedWriteCapacityUnits);
        }
        if (replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings() != null) {
            AutoScalingSettingsDescription replicaProvisionedWriteCapacityAutoScalingSettings = replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings();
            awsJsonWriter.name("ReplicaProvisionedWriteCapacityAutoScalingSettings");
            AutoScalingSettingsDescriptionJsonMarshaller.getInstance().marshall(replicaProvisionedWriteCapacityAutoScalingSettings, awsJsonWriter);
        }
        if (replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings() != null) {
            List<ReplicaGlobalSecondaryIndexSettingsDescription> replicaGlobalSecondaryIndexSettings = replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings();
            awsJsonWriter.name("ReplicaGlobalSecondaryIndexSettings");
            awsJsonWriter.beginArray();
            for (ReplicaGlobalSecondaryIndexSettingsDescription next : replicaGlobalSecondaryIndexSettings) {
                if (next != null) {
                    ReplicaGlobalSecondaryIndexSettingsDescriptionJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static ReplicaSettingsDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaSettingsDescriptionJsonMarshaller();
        }
        return instance;
    }
}
