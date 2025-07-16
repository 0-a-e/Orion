package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsUpdate;
import com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsUpdate;
import com.amazonaws.util.json.AwsJsonWriter;

class ReplicaGlobalSecondaryIndexSettingsUpdateJsonMarshaller {
    private static ReplicaGlobalSecondaryIndexSettingsUpdateJsonMarshaller instance;

    ReplicaGlobalSecondaryIndexSettingsUpdateJsonMarshaller() {
    }

    public void marshall(ReplicaGlobalSecondaryIndexSettingsUpdate replicaGlobalSecondaryIndexSettingsUpdate, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (replicaGlobalSecondaryIndexSettingsUpdate.getIndexName() != null) {
            String indexName = replicaGlobalSecondaryIndexSettingsUpdate.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityUnits() != null) {
            Long provisionedReadCapacityUnits = replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityUnits();
            awsJsonWriter.name("ProvisionedReadCapacityUnits");
            awsJsonWriter.value((Number) provisionedReadCapacityUnits);
        }
        if (replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityAutoScalingSettingsUpdate() != null) {
            AutoScalingSettingsUpdate provisionedReadCapacityAutoScalingSettingsUpdate = replicaGlobalSecondaryIndexSettingsUpdate.getProvisionedReadCapacityAutoScalingSettingsUpdate();
            awsJsonWriter.name("ProvisionedReadCapacityAutoScalingSettingsUpdate");
            AutoScalingSettingsUpdateJsonMarshaller.getInstance().marshall(provisionedReadCapacityAutoScalingSettingsUpdate, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static ReplicaGlobalSecondaryIndexSettingsUpdateJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaGlobalSecondaryIndexSettingsUpdateJsonMarshaller();
        }
        return instance;
    }
}
