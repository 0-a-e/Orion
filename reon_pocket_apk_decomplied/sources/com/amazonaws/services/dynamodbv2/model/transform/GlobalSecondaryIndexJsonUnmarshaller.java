package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndex;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GlobalSecondaryIndexJsonUnmarshaller implements Unmarshaller<GlobalSecondaryIndex, JsonUnmarshallerContext> {
    private static GlobalSecondaryIndexJsonUnmarshaller instance;

    GlobalSecondaryIndexJsonUnmarshaller() {
    }

    public GlobalSecondaryIndex unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalSecondaryIndex globalSecondaryIndex = new GlobalSecondaryIndex();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                globalSecondaryIndex.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                globalSecondaryIndex.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Projection")) {
                globalSecondaryIndex.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedThroughput")) {
                globalSecondaryIndex.setProvisionedThroughput(ProvisionedThroughputJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalSecondaryIndex;
    }

    public static GlobalSecondaryIndexJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSecondaryIndexJsonUnmarshaller();
        }
        return instance;
    }
}
