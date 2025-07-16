package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class LocalSecondaryIndexDescriptionJsonUnmarshaller implements Unmarshaller<LocalSecondaryIndexDescription, JsonUnmarshallerContext> {
    private static LocalSecondaryIndexDescriptionJsonUnmarshaller instance;

    LocalSecondaryIndexDescriptionJsonUnmarshaller() {
    }

    public LocalSecondaryIndexDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        LocalSecondaryIndexDescription localSecondaryIndexDescription = new LocalSecondaryIndexDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                localSecondaryIndexDescription.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                localSecondaryIndexDescription.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Projection")) {
                localSecondaryIndexDescription.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("IndexSizeBytes")) {
                localSecondaryIndexDescription.setIndexSizeBytes(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ItemCount")) {
                localSecondaryIndexDescription.setItemCount(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("IndexArn")) {
                localSecondaryIndexDescription.setIndexArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return localSecondaryIndexDescription;
    }

    public static LocalSecondaryIndexDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LocalSecondaryIndexDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
