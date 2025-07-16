package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ReplicaDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ReplicaDescriptionJsonUnmarshaller implements Unmarshaller<ReplicaDescription, JsonUnmarshallerContext> {
    private static ReplicaDescriptionJsonUnmarshaller instance;

    ReplicaDescriptionJsonUnmarshaller() {
    }

    public ReplicaDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ReplicaDescription replicaDescription = new ReplicaDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RegionName")) {
                replicaDescription.setRegionName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return replicaDescription;
    }

    public static ReplicaDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReplicaDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
