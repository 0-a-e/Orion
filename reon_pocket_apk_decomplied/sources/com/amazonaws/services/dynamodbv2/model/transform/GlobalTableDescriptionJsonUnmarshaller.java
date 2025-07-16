package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalTableDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GlobalTableDescriptionJsonUnmarshaller implements Unmarshaller<GlobalTableDescription, JsonUnmarshallerContext> {
    private static GlobalTableDescriptionJsonUnmarshaller instance;

    GlobalTableDescriptionJsonUnmarshaller() {
    }

    public GlobalTableDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalTableDescription globalTableDescription = new GlobalTableDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("ReplicationGroup")) {
                globalTableDescription.setReplicationGroup(new ListUnmarshaller(ReplicaDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("GlobalTableArn")) {
                globalTableDescription.setGlobalTableArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("CreationDateTime")) {
                globalTableDescription.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("GlobalTableStatus")) {
                globalTableDescription.setGlobalTableStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("GlobalTableName")) {
                globalTableDescription.setGlobalTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalTableDescription;
    }

    public static GlobalTableDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalTableDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
