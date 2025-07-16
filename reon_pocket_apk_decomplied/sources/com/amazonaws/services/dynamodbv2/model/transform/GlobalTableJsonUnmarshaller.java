package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalTable;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GlobalTableJsonUnmarshaller implements Unmarshaller<GlobalTable, JsonUnmarshallerContext> {
    private static GlobalTableJsonUnmarshaller instance;

    GlobalTableJsonUnmarshaller() {
    }

    public GlobalTable unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalTable globalTable = new GlobalTable();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("GlobalTableName")) {
                globalTable.setGlobalTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ReplicationGroup")) {
                globalTable.setReplicationGroup(new ListUnmarshaller(ReplicaJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalTable;
    }

    public static GlobalTableJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalTableJsonUnmarshaller();
        }
        return instance;
    }
}
