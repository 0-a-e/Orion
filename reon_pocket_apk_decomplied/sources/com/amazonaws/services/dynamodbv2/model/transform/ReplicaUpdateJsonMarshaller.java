package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.CreateReplicaAction;
import com.amazonaws.services.dynamodbv2.model.DeleteReplicaAction;
import com.amazonaws.services.dynamodbv2.model.ReplicaUpdate;
import com.amazonaws.util.json.AwsJsonWriter;

class ReplicaUpdateJsonMarshaller {
    private static ReplicaUpdateJsonMarshaller instance;

    ReplicaUpdateJsonMarshaller() {
    }

    public void marshall(ReplicaUpdate replicaUpdate, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (replicaUpdate.getCreate() != null) {
            CreateReplicaAction create = replicaUpdate.getCreate();
            awsJsonWriter.name("Create");
            CreateReplicaActionJsonMarshaller.getInstance().marshall(create, awsJsonWriter);
        }
        if (replicaUpdate.getDelete() != null) {
            DeleteReplicaAction delete = replicaUpdate.getDelete();
            awsJsonWriter.name("Delete");
            DeleteReplicaActionJsonMarshaller.getInstance().marshall(delete, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static ReplicaUpdateJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaUpdateJsonMarshaller();
        }
        return instance;
    }
}
