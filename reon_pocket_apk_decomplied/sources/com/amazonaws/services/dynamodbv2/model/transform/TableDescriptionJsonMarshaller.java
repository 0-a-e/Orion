package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexDescription;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexDescription;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazonaws.services.dynamodbv2.model.RestoreSummary;
import com.amazonaws.services.dynamodbv2.model.SSEDescription;
import com.amazonaws.services.dynamodbv2.model.StreamSpecification;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Date;
import java.util.List;

class TableDescriptionJsonMarshaller {
    private static TableDescriptionJsonMarshaller instance;

    TableDescriptionJsonMarshaller() {
    }

    public void marshall(TableDescription tableDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (tableDescription.getAttributeDefinitions() != null) {
            List<AttributeDefinition> attributeDefinitions = tableDescription.getAttributeDefinitions();
            awsJsonWriter.name("AttributeDefinitions");
            awsJsonWriter.beginArray();
            for (AttributeDefinition next : attributeDefinitions) {
                if (next != null) {
                    AttributeDefinitionJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (tableDescription.getTableName() != null) {
            String tableName = tableDescription.getTableName();
            awsJsonWriter.name("TableName");
            awsJsonWriter.value(tableName);
        }
        if (tableDescription.getKeySchema() != null) {
            List<KeySchemaElement> keySchema = tableDescription.getKeySchema();
            awsJsonWriter.name("KeySchema");
            awsJsonWriter.beginArray();
            for (KeySchemaElement next2 : keySchema) {
                if (next2 != null) {
                    KeySchemaElementJsonMarshaller.getInstance().marshall(next2, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (tableDescription.getTableStatus() != null) {
            String tableStatus = tableDescription.getTableStatus();
            awsJsonWriter.name("TableStatus");
            awsJsonWriter.value(tableStatus);
        }
        if (tableDescription.getCreationDateTime() != null) {
            Date creationDateTime = tableDescription.getCreationDateTime();
            awsJsonWriter.name("CreationDateTime");
            awsJsonWriter.value(creationDateTime);
        }
        if (tableDescription.getProvisionedThroughput() != null) {
            ProvisionedThroughputDescription provisionedThroughput = tableDescription.getProvisionedThroughput();
            awsJsonWriter.name("ProvisionedThroughput");
            ProvisionedThroughputDescriptionJsonMarshaller.getInstance().marshall(provisionedThroughput, awsJsonWriter);
        }
        if (tableDescription.getTableSizeBytes() != null) {
            Long tableSizeBytes = tableDescription.getTableSizeBytes();
            awsJsonWriter.name("TableSizeBytes");
            awsJsonWriter.value((Number) tableSizeBytes);
        }
        if (tableDescription.getItemCount() != null) {
            Long itemCount = tableDescription.getItemCount();
            awsJsonWriter.name("ItemCount");
            awsJsonWriter.value((Number) itemCount);
        }
        if (tableDescription.getTableArn() != null) {
            String tableArn = tableDescription.getTableArn();
            awsJsonWriter.name("TableArn");
            awsJsonWriter.value(tableArn);
        }
        if (tableDescription.getTableId() != null) {
            String tableId = tableDescription.getTableId();
            awsJsonWriter.name("TableId");
            awsJsonWriter.value(tableId);
        }
        if (tableDescription.getLocalSecondaryIndexes() != null) {
            List<LocalSecondaryIndexDescription> localSecondaryIndexes = tableDescription.getLocalSecondaryIndexes();
            awsJsonWriter.name("LocalSecondaryIndexes");
            awsJsonWriter.beginArray();
            for (LocalSecondaryIndexDescription next3 : localSecondaryIndexes) {
                if (next3 != null) {
                    LocalSecondaryIndexDescriptionJsonMarshaller.getInstance().marshall(next3, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (tableDescription.getGlobalSecondaryIndexes() != null) {
            List<GlobalSecondaryIndexDescription> globalSecondaryIndexes = tableDescription.getGlobalSecondaryIndexes();
            awsJsonWriter.name("GlobalSecondaryIndexes");
            awsJsonWriter.beginArray();
            for (GlobalSecondaryIndexDescription next4 : globalSecondaryIndexes) {
                if (next4 != null) {
                    GlobalSecondaryIndexDescriptionJsonMarshaller.getInstance().marshall(next4, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (tableDescription.getStreamSpecification() != null) {
            StreamSpecification streamSpecification = tableDescription.getStreamSpecification();
            awsJsonWriter.name("StreamSpecification");
            StreamSpecificationJsonMarshaller.getInstance().marshall(streamSpecification, awsJsonWriter);
        }
        if (tableDescription.getLatestStreamLabel() != null) {
            String latestStreamLabel = tableDescription.getLatestStreamLabel();
            awsJsonWriter.name("LatestStreamLabel");
            awsJsonWriter.value(latestStreamLabel);
        }
        if (tableDescription.getLatestStreamArn() != null) {
            String latestStreamArn = tableDescription.getLatestStreamArn();
            awsJsonWriter.name("LatestStreamArn");
            awsJsonWriter.value(latestStreamArn);
        }
        if (tableDescription.getRestoreSummary() != null) {
            RestoreSummary restoreSummary = tableDescription.getRestoreSummary();
            awsJsonWriter.name("RestoreSummary");
            RestoreSummaryJsonMarshaller.getInstance().marshall(restoreSummary, awsJsonWriter);
        }
        if (tableDescription.getSSEDescription() != null) {
            SSEDescription sSEDescription = tableDescription.getSSEDescription();
            awsJsonWriter.name("SSEDescription");
            SSEDescriptionJsonMarshaller.getInstance().marshall(sSEDescription, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static TableDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new TableDescriptionJsonMarshaller();
        }
        return instance;
    }
}
