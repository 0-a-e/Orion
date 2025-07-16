package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class DeleteItemResultJsonUnmarshaller implements Unmarshaller<DeleteItemResult, JsonUnmarshallerContext> {
    private static DeleteItemResultJsonUnmarshaller instance;

    public DeleteItemResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DeleteItemResult deleteItemResult = new DeleteItemResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Attributes")) {
                deleteItemResult.setAttributes(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ConsumedCapacity")) {
                deleteItemResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ItemCollectionMetrics")) {
                deleteItemResult.setItemCollectionMetrics(ItemCollectionMetricsJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return deleteItemResult;
    }

    public static DeleteItemResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteItemResultJsonUnmarshaller();
        }
        return instance;
    }
}
