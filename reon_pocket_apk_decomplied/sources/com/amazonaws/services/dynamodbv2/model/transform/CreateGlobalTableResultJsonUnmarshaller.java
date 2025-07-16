package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.CreateGlobalTableResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class CreateGlobalTableResultJsonUnmarshaller implements Unmarshaller<CreateGlobalTableResult, JsonUnmarshallerContext> {
    private static CreateGlobalTableResultJsonUnmarshaller instance;

    public CreateGlobalTableResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateGlobalTableResult createGlobalTableResult = new CreateGlobalTableResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("GlobalTableDescription")) {
                createGlobalTableResult.setGlobalTableDescription(GlobalTableDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createGlobalTableResult;
    }

    public static CreateGlobalTableResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateGlobalTableResultJsonUnmarshaller();
        }
        return instance;
    }
}
