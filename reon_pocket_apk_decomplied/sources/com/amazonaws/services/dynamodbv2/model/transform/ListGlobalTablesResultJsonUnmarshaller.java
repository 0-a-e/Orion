package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListGlobalTablesResultJsonUnmarshaller implements Unmarshaller<ListGlobalTablesResult, JsonUnmarshallerContext> {
    private static ListGlobalTablesResultJsonUnmarshaller instance;

    public ListGlobalTablesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListGlobalTablesResult listGlobalTablesResult = new ListGlobalTablesResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("GlobalTables")) {
                listGlobalTablesResult.setGlobalTables(new ListUnmarshaller(GlobalTableJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LastEvaluatedGlobalTableName")) {
                listGlobalTablesResult.setLastEvaluatedGlobalTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listGlobalTablesResult;
    }

    public static ListGlobalTablesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListGlobalTablesResultJsonUnmarshaller();
        }
        return instance;
    }
}
