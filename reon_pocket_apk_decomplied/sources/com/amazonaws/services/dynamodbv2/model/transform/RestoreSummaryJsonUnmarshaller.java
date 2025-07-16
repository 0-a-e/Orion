package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.RestoreSummary;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class RestoreSummaryJsonUnmarshaller implements Unmarshaller<RestoreSummary, JsonUnmarshallerContext> {
    private static RestoreSummaryJsonUnmarshaller instance;

    RestoreSummaryJsonUnmarshaller() {
    }

    public RestoreSummary unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        RestoreSummary restoreSummary = new RestoreSummary();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("SourceBackupArn")) {
                restoreSummary.setSourceBackupArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SourceTableArn")) {
                restoreSummary.setSourceTableArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RestoreDateTime")) {
                restoreSummary.setRestoreDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RestoreInProgress")) {
                restoreSummary.setRestoreInProgress(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return restoreSummary;
    }

    public static RestoreSummaryJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RestoreSummaryJsonUnmarshaller();
        }
        return instance;
    }
}
