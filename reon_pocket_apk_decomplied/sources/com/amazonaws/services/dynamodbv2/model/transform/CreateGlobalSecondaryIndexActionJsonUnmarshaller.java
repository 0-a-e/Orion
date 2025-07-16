package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.CreateGlobalSecondaryIndexAction;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class CreateGlobalSecondaryIndexActionJsonUnmarshaller implements Unmarshaller<CreateGlobalSecondaryIndexAction, JsonUnmarshallerContext> {
    private static CreateGlobalSecondaryIndexActionJsonUnmarshaller instance;

    CreateGlobalSecondaryIndexActionJsonUnmarshaller() {
    }

    public CreateGlobalSecondaryIndexAction unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        CreateGlobalSecondaryIndexAction createGlobalSecondaryIndexAction = new CreateGlobalSecondaryIndexAction();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                createGlobalSecondaryIndexAction.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                createGlobalSecondaryIndexAction.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Projection")) {
                createGlobalSecondaryIndexAction.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedThroughput")) {
                createGlobalSecondaryIndexAction.setProvisionedThroughput(ProvisionedThroughputJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createGlobalSecondaryIndexAction;
    }

    public static CreateGlobalSecondaryIndexActionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateGlobalSecondaryIndexActionJsonUnmarshaller();
        }
        return instance;
    }
}
