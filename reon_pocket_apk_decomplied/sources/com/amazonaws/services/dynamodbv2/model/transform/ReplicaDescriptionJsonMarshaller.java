package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ReplicaDescription;
import com.amazonaws.util.json.AwsJsonWriter;

class ReplicaDescriptionJsonMarshaller {
    private static ReplicaDescriptionJsonMarshaller instance;

    ReplicaDescriptionJsonMarshaller() {
    }

    public void marshall(ReplicaDescription replicaDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (replicaDescription.getRegionName() != null) {
            String regionName = replicaDescription.getRegionName();
            awsJsonWriter.name("RegionName");
            awsJsonWriter.value(regionName);
        }
        awsJsonWriter.endObject();
    }

    public static ReplicaDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaDescriptionJsonMarshaller();
        }
        return instance;
    }
}
