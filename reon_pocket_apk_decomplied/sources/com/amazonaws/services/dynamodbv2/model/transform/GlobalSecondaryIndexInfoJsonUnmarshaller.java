package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexInfo;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class GlobalSecondaryIndexInfoJsonUnmarshaller implements Unmarshaller<GlobalSecondaryIndexInfo, JsonUnmarshallerContext> {
    private static GlobalSecondaryIndexInfoJsonUnmarshaller instance;

    GlobalSecondaryIndexInfoJsonUnmarshaller() {
    }

    public GlobalSecondaryIndexInfo unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        GlobalSecondaryIndexInfo globalSecondaryIndexInfo = new GlobalSecondaryIndexInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                globalSecondaryIndexInfo.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                globalSecondaryIndexInfo.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Projection")) {
                globalSecondaryIndexInfo.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedThroughput")) {
                globalSecondaryIndexInfo.setProvisionedThroughput(ProvisionedThroughputJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return globalSecondaryIndexInfo;
    }

    public static GlobalSecondaryIndexInfoJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSecondaryIndexInfoJsonUnmarshaller();
        }
        return instance;
    }
}
