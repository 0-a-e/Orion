package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexDescription;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class GlobalSecondaryIndexDescriptionJsonMarshaller {
    private static GlobalSecondaryIndexDescriptionJsonMarshaller instance;

    GlobalSecondaryIndexDescriptionJsonMarshaller() {
    }

    public void marshall(GlobalSecondaryIndexDescription globalSecondaryIndexDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (globalSecondaryIndexDescription.getIndexName() != null) {
            String indexName = globalSecondaryIndexDescription.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (globalSecondaryIndexDescription.getKeySchema() != null) {
            List<KeySchemaElement> keySchema = globalSecondaryIndexDescription.getKeySchema();
            awsJsonWriter.name("KeySchema");
            awsJsonWriter.beginArray();
            for (KeySchemaElement next : keySchema) {
                if (next != null) {
                    KeySchemaElementJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (globalSecondaryIndexDescription.getProjection() != null) {
            Projection projection = globalSecondaryIndexDescription.getProjection();
            awsJsonWriter.name("Projection");
            ProjectionJsonMarshaller.getInstance().marshall(projection, awsJsonWriter);
        }
        if (globalSecondaryIndexDescription.getIndexStatus() != null) {
            String indexStatus = globalSecondaryIndexDescription.getIndexStatus();
            awsJsonWriter.name("IndexStatus");
            awsJsonWriter.value(indexStatus);
        }
        if (globalSecondaryIndexDescription.getBackfilling() != null) {
            Boolean backfilling = globalSecondaryIndexDescription.getBackfilling();
            awsJsonWriter.name("Backfilling");
            awsJsonWriter.value(backfilling.booleanValue());
        }
        if (globalSecondaryIndexDescription.getProvisionedThroughput() != null) {
            ProvisionedThroughputDescription provisionedThroughput = globalSecondaryIndexDescription.getProvisionedThroughput();
            awsJsonWriter.name("ProvisionedThroughput");
            ProvisionedThroughputDescriptionJsonMarshaller.getInstance().marshall(provisionedThroughput, awsJsonWriter);
        }
        if (globalSecondaryIndexDescription.getIndexSizeBytes() != null) {
            Long indexSizeBytes = globalSecondaryIndexDescription.getIndexSizeBytes();
            awsJsonWriter.name("IndexSizeBytes");
            awsJsonWriter.value((Number) indexSizeBytes);
        }
        if (globalSecondaryIndexDescription.getItemCount() != null) {
            Long itemCount = globalSecondaryIndexDescription.getItemCount();
            awsJsonWriter.name("ItemCount");
            awsJsonWriter.value((Number) itemCount);
        }
        if (globalSecondaryIndexDescription.getIndexArn() != null) {
            String indexArn = globalSecondaryIndexDescription.getIndexArn();
            awsJsonWriter.name("IndexArn");
            awsJsonWriter.value(indexArn);
        }
        awsJsonWriter.endObject();
    }

    public static GlobalSecondaryIndexDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSecondaryIndexDescriptionJsonMarshaller();
        }
        return instance;
    }
}
