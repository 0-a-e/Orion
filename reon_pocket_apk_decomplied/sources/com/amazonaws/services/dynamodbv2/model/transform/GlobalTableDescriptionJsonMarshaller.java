package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalTableDescription;
import com.amazonaws.services.dynamodbv2.model.ReplicaDescription;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;
import java.util.List;

class GlobalTableDescriptionJsonMarshaller {
    private static GlobalTableDescriptionJsonMarshaller instance;

    GlobalTableDescriptionJsonMarshaller() {
    }

    public void marshall(GlobalTableDescription globalTableDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (globalTableDescription.getReplicationGroup() != null) {
            List<ReplicaDescription> replicationGroup = globalTableDescription.getReplicationGroup();
            awsJsonWriter.name("ReplicationGroup");
            awsJsonWriter.beginArray();
            for (ReplicaDescription next : replicationGroup) {
                if (next != null) {
                    ReplicaDescriptionJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (globalTableDescription.getGlobalTableArn() != null) {
            String globalTableArn = globalTableDescription.getGlobalTableArn();
            awsJsonWriter.name("GlobalTableArn");
            awsJsonWriter.value(globalTableArn);
        }
        if (globalTableDescription.getCreationDateTime() != null) {
            Date creationDateTime = globalTableDescription.getCreationDateTime();
            awsJsonWriter.name("CreationDateTime");
            awsJsonWriter.value(creationDateTime);
        }
        if (globalTableDescription.getGlobalTableStatus() != null) {
            String globalTableStatus = globalTableDescription.getGlobalTableStatus();
            awsJsonWriter.name("GlobalTableStatus");
            awsJsonWriter.value(globalTableStatus);
        }
        if (globalTableDescription.getGlobalTableName() != null) {
            String globalTableName = globalTableDescription.getGlobalTableName();
            awsJsonWriter.name("GlobalTableName");
            awsJsonWriter.value(globalTableName);
        }
        awsJsonWriter.endObject();
    }

    public static GlobalTableDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalTableDescriptionJsonMarshaller();
        }
        return instance;
    }
}
