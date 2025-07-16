package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class QueryResultJsonUnmarshaller implements Unmarshaller<QueryResult, JsonUnmarshallerContext> {
    private static QueryResultJsonUnmarshaller instance;

    public QueryResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        QueryResult queryResult = new QueryResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Items")) {
                queryResult.setItems(new ListUnmarshaller(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance())).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Count")) {
                queryResult.setCount(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ScannedCount")) {
                queryResult.setScannedCount(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LastEvaluatedKey")) {
                queryResult.setLastEvaluatedKey(new MapUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ConsumedCapacity")) {
                queryResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return queryResult;
    }

    public static QueryResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new QueryResultJsonUnmarshaller();
        }
        return instance;
    }
}
