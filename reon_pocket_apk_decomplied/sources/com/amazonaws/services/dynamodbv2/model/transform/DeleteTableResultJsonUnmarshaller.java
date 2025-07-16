package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DeleteTableResultJsonUnmarshaller implements Unmarshaller<DeleteTableResult, JsonUnmarshallerContext> {
    private static DeleteTableResultJsonUnmarshaller instance;

    public DeleteTableResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeleteTableResult deleteTableResult = new DeleteTableResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("TableDescription")) {
                deleteTableResult.setTableDescription(TableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return deleteTableResult;
    }

    public static DeleteTableResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteTableResultJsonUnmarshaller();
        }
        return instance;
    }
}
