package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class CreateTableResultJsonUnmarshaller implements Unmarshaller<CreateTableResult, JsonUnmarshallerContext> {
    private static CreateTableResultJsonUnmarshaller instance;

    public CreateTableResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateTableResult createTableResult = new CreateTableResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("TableDescription")) {
                createTableResult.setTableDescription(TableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createTableResult;
    }

    public static CreateTableResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateTableResultJsonUnmarshaller();
        }
        return instance;
    }
}
