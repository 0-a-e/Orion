package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Replica;
import com.amazonaws.util.json.AwsJsonWriter;

class ReplicaJsonMarshaller {
    private static ReplicaJsonMarshaller instance;

    ReplicaJsonMarshaller() {
    }

    public void marshall(Replica replica, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (replica.getRegionName() != null) {
            String regionName = replica.getRegionName();
            awsJsonWriter.name("RegionName");
            awsJsonWriter.value(regionName);
        }
        awsJsonWriter.endObject();
    }

    public static ReplicaJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaJsonMarshaller();
        }
        return instance;
    }
}
