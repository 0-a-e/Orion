package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexInfo;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class LocalSecondaryIndexInfoJsonUnmarshaller implements Unmarshaller<LocalSecondaryIndexInfo, JsonUnmarshallerContext> {
    private static LocalSecondaryIndexInfoJsonUnmarshaller instance;

    LocalSecondaryIndexInfoJsonUnmarshaller() {
    }

    public LocalSecondaryIndexInfo unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        LocalSecondaryIndexInfo localSecondaryIndexInfo = new LocalSecondaryIndexInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                localSecondaryIndexInfo.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                localSecondaryIndexInfo.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Projection")) {
                localSecondaryIndexInfo.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return localSecondaryIndexInfo;
    }

    public static LocalSecondaryIndexInfoJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LocalSecondaryIndexInfoJsonUnmarshaller();
        }
        return instance;
    }
}
