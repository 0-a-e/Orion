package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DeleteReplicaAction;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class DeleteReplicaActionJsonUnmarshaller implements Unmarshaller<DeleteReplicaAction, JsonUnmarshallerContext> {
    private static DeleteReplicaActionJsonUnmarshaller instance;

    DeleteReplicaActionJsonUnmarshaller() {
    }

    public DeleteReplicaAction unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        DeleteReplicaAction deleteReplicaAction = new DeleteReplicaAction();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RegionName")) {
                deleteReplicaAction.setRegionName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return deleteReplicaAction;
    }

    public static DeleteReplicaActionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteReplicaActionJsonUnmarshaller();
        }
        return instance;
    }
}
