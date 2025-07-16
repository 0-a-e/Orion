package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.SourceTableDetails;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class SourceTableDetailsJsonUnmarshaller implements Unmarshaller<SourceTableDetails, JsonUnmarshallerContext> {
    private static SourceTableDetailsJsonUnmarshaller instance;

    SourceTableDetailsJsonUnmarshaller() {
    }

    public SourceTableDetails unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        SourceTableDetails sourceTableDetails = new SourceTableDetails();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("TableName")) {
                sourceTableDetails.setTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableId")) {
                sourceTableDetails.setTableId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableArn")) {
                sourceTableDetails.setTableArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableSizeBytes")) {
                sourceTableDetails.setTableSizeBytes(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                sourceTableDetails.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableCreationDateTime")) {
                sourceTableDetails.setTableCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedThroughput")) {
                sourceTableDetails.setProvisionedThroughput(ProvisionedThroughputJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ItemCount")) {
                sourceTableDetails.setItemCount(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return sourceTableDetails;
    }

    public static SourceTableDetailsJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SourceTableDetailsJsonUnmarshaller();
        }
        return instance;
    }
}
