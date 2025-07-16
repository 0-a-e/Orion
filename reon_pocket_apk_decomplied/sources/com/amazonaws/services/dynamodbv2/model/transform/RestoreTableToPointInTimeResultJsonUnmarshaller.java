package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class RestoreTableToPointInTimeResultJsonUnmarshaller implements Unmarshaller<RestoreTableToPointInTimeResult, JsonUnmarshallerContext> {
    private static RestoreTableToPointInTimeResultJsonUnmarshaller instance;

    public RestoreTableToPointInTimeResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        RestoreTableToPointInTimeResult restoreTableToPointInTimeResult = new RestoreTableToPointInTimeResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("TableDescription")) {
                restoreTableToPointInTimeResult.setTableDescription(TableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return restoreTableToPointInTimeResult;
    }

    public static RestoreTableToPointInTimeResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RestoreTableToPointInTimeResultJsonUnmarshaller();
        }
        return instance;
    }
}
