package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class TableDescriptionJsonUnmarshaller implements Unmarshaller<TableDescription, JsonUnmarshallerContext> {
    private static TableDescriptionJsonUnmarshaller instance;

    TableDescriptionJsonUnmarshaller() {
    }

    public TableDescription unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        TableDescription tableDescription = new TableDescription();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("AttributeDefinitions")) {
                tableDescription.setAttributeDefinitions(new ListUnmarshaller(AttributeDefinitionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableName")) {
                tableDescription.setTableName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("KeySchema")) {
                tableDescription.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableStatus")) {
                tableDescription.setTableStatus(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("CreationDateTime")) {
                tableDescription.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ProvisionedThroughput")) {
                tableDescription.setProvisionedThroughput(ProvisionedThroughputDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableSizeBytes")) {
                tableDescription.setTableSizeBytes(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ItemCount")) {
                tableDescription.setItemCount(SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableArn")) {
                tableDescription.setTableArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("TableId")) {
                tableDescription.setTableId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LocalSecondaryIndexes")) {
                tableDescription.setLocalSecondaryIndexes(new ListUnmarshaller(LocalSecondaryIndexDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("GlobalSecondaryIndexes")) {
                tableDescription.setGlobalSecondaryIndexes(new ListUnmarshaller(GlobalSecondaryIndexDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("StreamSpecification")) {
                tableDescription.setStreamSpecification(StreamSpecificationJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LatestStreamLabel")) {
                tableDescription.setLatestStreamLabel(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("LatestStreamArn")) {
                tableDescription.setLatestStreamArn(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("RestoreSummary")) {
                tableDescription.setRestoreSummary(RestoreSummaryJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("SSEDescription")) {
                tableDescription.setSSEDescription(SSEDescriptionJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return tableDescription;
    }

    public static TableDescriptionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TableDescriptionJsonUnmarshaller();
        }
        return instance;
    }
}
