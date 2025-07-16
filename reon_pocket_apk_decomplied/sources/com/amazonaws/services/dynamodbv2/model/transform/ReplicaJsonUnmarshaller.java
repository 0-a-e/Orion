package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Replica;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ReplicaJsonUnmarshaller implements Unmarshaller<Replica, JsonUnmarshallerContext> {
    private static ReplicaJsonUnmarshaller instance;

    ReplicaJsonUnmarshaller() {
    }

    public Replica unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        Replica replica = new Replica();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RegionName")) {
                replica.setRegionName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replica;
    }

    public static ReplicaJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaJsonUnmarshaller();
        }
        return instance;
    }
}
