package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalTable;
import com.amazonaws.services.dynamodbv2.model.Replica;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class GlobalTableJsonMarshaller {
    private static GlobalTableJsonMarshaller instance;

    GlobalTableJsonMarshaller() {
    }

    public void marshall(GlobalTable globalTable, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (globalTable.getGlobalTableName() != null) {
            String globalTableName = globalTable.getGlobalTableName();
            awsJsonWriter.name("GlobalTableName");
            awsJsonWriter.value(globalTableName);
        }
        if (globalTable.getReplicationGroup() != null) {
            List<Replica> replicationGroup = globalTable.getReplicationGroup();
            awsJsonWriter.name("ReplicationGroup");
            awsJsonWriter.beginArray();
            for (Replica next : replicationGroup) {
                if (next != null) {
                    ReplicaJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static GlobalTableJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalTableJsonMarshaller();
        }
        return instance;
    }
}
