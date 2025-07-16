package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndex;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class LocalSecondaryIndexJsonUnmarshaller implements Unmarshaller<LocalSecondaryIndex, JsonUnmarshallerContext> {
    private static LocalSecondaryIndexJsonUnmarshaller instance;

    LocalSecondaryIndexJsonUnmarshaller() {
    }

    public LocalSecondaryIndex unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        LocalSecondaryIndex localSecondaryIndex = new LocalSecondaryIndex();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                localSecondaryIndex.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                localSecondaryIndex.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Projection")) {
                localSecondaryIndex.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return localSecondaryIndex;
    }

    public static LocalSecondaryIndexJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LocalSecondaryIndexJsonUnmarshaller();
        }
        return instance;
    }
}
