package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.UpdateTableResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class UpdateTableResultJsonUnmarshaller implements Unmarshaller<UpdateTableResult, JsonUnmarshallerContext> {
    private static UpdateTableResultJsonUnmarshaller instance;

    public UpdateTableResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateTableResult updateTableResult = new UpdateTableResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("TableDescription")) {
                updateTableResult.setTableDescription(TableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateTableResult;
    }

    public static UpdateTableResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateTableResultJsonUnmarshaller();
        }
        return instance;
    }
}
