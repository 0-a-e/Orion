package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class UpdateTimeToLiveResultJsonUnmarshaller implements Unmarshaller<UpdateTimeToLiveResult, JsonUnmarshallerContext> {
    private static UpdateTimeToLiveResultJsonUnmarshaller instance;

    public UpdateTimeToLiveResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateTimeToLiveResult updateTimeToLiveResult = new UpdateTimeToLiveResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("TimeToLiveSpecification")) {
                updateTimeToLiveResult.setTimeToLiveSpecification(TimeToLiveSpecificationJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateTimeToLiveResult;
    }

    public static UpdateTimeToLiveResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateTimeToLiveResultJsonUnmarshaller();
        }
        return instance;
    }
}
