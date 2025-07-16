package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class UpdateItemResultJsonUnmarshaller implements Unmarshaller<UpdateItemResult, JsonUnmarshallerContext> {
    private static UpdateItemResultJsonUnmarshaller instance;

    public UpdateItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateItemResult updateItemResult = new UpdateItemResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Attributes")) {
                updateItemResult.setAttributes(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ConsumedCapacity")) {
                updateItemResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ItemCollectionMetrics")) {
                updateItemResult.setItemCollectionMetrics(ItemCollectionMetricsJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateItemResult;
    }

    public static UpdateItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateItemResultJsonUnmarshaller();
        }
        return instance;
    }
}
