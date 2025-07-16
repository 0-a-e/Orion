package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class GetItemResultJsonUnmarshaller implements Unmarshaller<GetItemResult, JsonUnmarshallerContext> {
    private static GetItemResultJsonUnmarshaller instance;

    public GetItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetItemResult getItemResult = new GetItemResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Item")) {
                getItemResult.setItem(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ConsumedCapacity")) {
                getItemResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getItemResult;
    }

    public static GetItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetItemResultJsonUnmarshaller();
        }
        return instance;
    }
}
