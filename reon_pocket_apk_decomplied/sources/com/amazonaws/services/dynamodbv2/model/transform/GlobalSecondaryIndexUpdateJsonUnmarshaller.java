package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GlobalSecondaryIndexUpdateJsonUnmarshaller implements Unmarshaller<GlobalSecondaryIndexUpdate, JsonUnmarshallerContext> {
    private static GlobalSecondaryIndexUpdateJsonUnmarshaller instance;

    GlobalSecondaryIndexUpdateJsonUnmarshaller() {
    }

    public GlobalSecondaryIndexUpdate unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalSecondaryIndexUpdate globalSecondaryIndexUpdate = new GlobalSecondaryIndexUpdate();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Update")) {
                globalSecondaryIndexUpdate.setUpdate(UpdateGlobalSecondaryIndexActionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Create")) {
                globalSecondaryIndexUpdate.setCreate(CreateGlobalSecondaryIndexActionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Delete")) {
                globalSecondaryIndexUpdate.setDelete(DeleteGlobalSecondaryIndexActionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalSecondaryIndexUpdate;
    }

    public static GlobalSecondaryIndexUpdateJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSecondaryIndexUpdateJsonUnmarshaller();
        }
        return instance;
    }
}
