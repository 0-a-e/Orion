package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GlobalSecondaryIndexDescriptionJsonUnmarshaller implements Unmarshaller<GlobalSecondaryIndexDescription, JsonUnmarshallerContext> {
    private static GlobalSecondaryIndexDescriptionJsonUnmarshaller instance;

    GlobalSecondaryIndexDescriptionJsonUnmarshaller() {
    }

    public GlobalSecondaryIndexDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalSecondaryIndexDescription globalSecondaryIndexDescription = new GlobalSecondaryIndexDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                globalSecondaryIndexDescription.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                globalSecondaryIndexDescription.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Projection")) {
                globalSecondaryIndexDescription.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("IndexStatus")) {
                globalSecondaryIndexDescription.setIndexStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Backfilling")) {
                globalSecondaryIndexDescription.setBackfilling(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedThroughput")) {
                globalSecondaryIndexDescription.setProvisionedThroughput(ProvisionedThroughputDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("IndexSizeBytes")) {
                globalSecondaryIndexDescription.setIndexSizeBytes(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ItemCount")) {
                globalSecondaryIndexDescription.setItemCount(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("IndexArn")) {
                globalSecondaryIndexDescription.setIndexArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalSecondaryIndexDescription;
    }

    public static GlobalSecondaryIndexDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSecondaryIndexDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
