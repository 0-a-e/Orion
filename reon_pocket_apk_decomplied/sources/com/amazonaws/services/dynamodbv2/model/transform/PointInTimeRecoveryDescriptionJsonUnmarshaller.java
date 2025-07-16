package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class PointInTimeRecoveryDescriptionJsonUnmarshaller implements Unmarshaller<PointInTimeRecoveryDescription, JsonUnmarshallerContext> {
    private static PointInTimeRecoveryDescriptionJsonUnmarshaller instance;

    PointInTimeRecoveryDescriptionJsonUnmarshaller() {
    }

    public PointInTimeRecoveryDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        PointInTimeRecoveryDescription pointInTimeRecoveryDescription = new PointInTimeRecoveryDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("PointInTimeRecoveryStatus")) {
                pointInTimeRecoveryDescription.setPointInTimeRecoveryStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("EarliestRestorableDateTime")) {
                pointInTimeRecoveryDescription.setEarliestRestorableDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LatestRestorableDateTime")) {
                pointInTimeRecoveryDescription.setLatestRestorableDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return pointInTimeRecoveryDescription;
    }

    public static PointInTimeRecoveryDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PointInTimeRecoveryDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
