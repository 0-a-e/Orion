package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ContinuousBackupsDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ContinuousBackupsDescriptionJsonUnmarshaller implements Unmarshaller<ContinuousBackupsDescription, JsonUnmarshallerContext> {
    private static ContinuousBackupsDescriptionJsonUnmarshaller instance;

    ContinuousBackupsDescriptionJsonUnmarshaller() {
    }

    public ContinuousBackupsDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ContinuousBackupsDescription continuousBackupsDescription = new ContinuousBackupsDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("ContinuousBackupsStatus")) {
                continuousBackupsDescription.setContinuousBackupsStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("PointInTimeRecoveryDescription")) {
                continuousBackupsDescription.setPointInTimeRecoveryDescription(PointInTimeRecoveryDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return continuousBackupsDescription;
    }

    public static ContinuousBackupsDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ContinuousBackupsDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
