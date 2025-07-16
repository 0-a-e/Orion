package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.CreateReplicaAction;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class CreateReplicaActionJsonUnmarshaller implements Unmarshaller<CreateReplicaAction, JsonUnmarshallerContext> {
    private static CreateReplicaActionJsonUnmarshaller instance;

    CreateReplicaActionJsonUnmarshaller() {
    }

    public CreateReplicaAction unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        CreateReplicaAction createReplicaAction = new CreateReplicaAction();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RegionName")) {
                createReplicaAction.setRegionName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createReplicaAction;
    }

    public static CreateReplicaActionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateReplicaActionJsonUnmarshaller();
        }
        return instance;
    }
}
