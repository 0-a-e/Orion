package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

public class ListTablesResultJsonUnmarshaller implements Unmarshaller<ListTablesResult, JsonUnmarshallerContext> {
    private static ListTablesResultJsonUnmarshaller instance;

    public ListTablesResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListTablesResult listTablesResult = new ListTablesResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("TableNames")) {
                listTablesResult.setTableNames(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LastEvaluatedTableName")) {
                listTablesResult.setLastEvaluatedTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listTablesResult;
    }

    public static ListTablesResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListTablesResultJsonUnmarshaller();
        }
        return instance;
    }
}
