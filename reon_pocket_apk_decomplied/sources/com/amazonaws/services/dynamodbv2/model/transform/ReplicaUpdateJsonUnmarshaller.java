package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ReplicaUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ReplicaUpdateJsonUnmarshaller implements Unmarshaller<ReplicaUpdate, JsonUnmarshallerContext> {
    private static ReplicaUpdateJsonUnmarshaller instance;

    ReplicaUpdateJsonUnmarshaller() {
    }

    public ReplicaUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ReplicaUpdate replicaUpdate = new ReplicaUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Create")) {
                replicaUpdate.setCreate(CreateReplicaActionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Delete")) {
                replicaUpdate.setDelete(DeleteReplicaActionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replicaUpdate;
    }

    public static ReplicaUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
