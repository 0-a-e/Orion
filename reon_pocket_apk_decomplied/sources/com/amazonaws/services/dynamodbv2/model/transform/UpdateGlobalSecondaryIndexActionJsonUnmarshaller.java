package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.UpdateGlobalSecondaryIndexAction;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class UpdateGlobalSecondaryIndexActionJsonUnmarshaller implements Unmarshaller<UpdateGlobalSecondaryIndexAction, JsonUnmarshallerContext> {
    private static UpdateGlobalSecondaryIndexActionJsonUnmarshaller instance;

    UpdateGlobalSecondaryIndexActionJsonUnmarshaller() {
    }

    public UpdateGlobalSecondaryIndexAction unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        UpdateGlobalSecondaryIndexAction updateGlobalSecondaryIndexAction = new UpdateGlobalSecondaryIndexAction();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("IndexName")) {
                updateGlobalSecondaryIndexAction.setIndexName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedThroughput")) {
                updateGlobalSecondaryIndexAction.setProvisionedThroughput(ProvisionedThroughputJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateGlobalSecondaryIndexAction;
    }

    public static UpdateGlobalSecondaryIndexActionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateGlobalSecondaryIndexActionJsonUnmarshaller();
        }
        return instance;
    }
}
