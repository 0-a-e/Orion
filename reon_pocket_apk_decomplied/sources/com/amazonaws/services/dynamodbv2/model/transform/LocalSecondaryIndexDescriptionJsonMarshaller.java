package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexDescription;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class LocalSecondaryIndexDescriptionJsonMarshaller {
    private static LocalSecondaryIndexDescriptionJsonMarshaller instance;

    LocalSecondaryIndexDescriptionJsonMarshaller() {
    }

    public void marshall(LocalSecondaryIndexDescription localSecondaryIndexDescription, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (localSecondaryIndexDescription.getIndexName() != null) {
            String indexName = localSecondaryIndexDescription.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (localSecondaryIndexDescription.getKeySchema() != null) {
            List<KeySchemaElement> keySchema = localSecondaryIndexDescription.getKeySchema();
            awsJsonWriter.name("KeySchema");
            awsJsonWriter.beginArray();
            for (KeySchemaElement next : keySchema) {
                if (next != null) {
                    KeySchemaElementJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (localSecondaryIndexDescription.getProjection() != null) {
            Projection projection = localSecondaryIndexDescription.getProjection();
            awsJsonWriter.name("Projection");
            ProjectionJsonMarshaller.getInstance().marshall(projection, awsJsonWriter);
        }
        if (localSecondaryIndexDescription.getIndexSizeBytes() != null) {
            Long indexSizeBytes = localSecondaryIndexDescription.getIndexSizeBytes();
            awsJsonWriter.name("IndexSizeBytes");
            awsJsonWriter.value((Number) indexSizeBytes);
        }
        if (localSecondaryIndexDescription.getItemCount() != null) {
            Long itemCount = localSecondaryIndexDescription.getItemCount();
            awsJsonWriter.name("ItemCount");
            awsJsonWriter.value((Number) itemCount);
        }
        if (localSecondaryIndexDescription.getIndexArn() != null) {
            String indexArn = localSecondaryIndexDescription.getIndexArn();
            awsJsonWriter.name("IndexArn");
            awsJsonWriter.value(indexArn);
        }
        awsJsonWriter.endObject();
    }

    public static LocalSecondaryIndexDescriptionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new LocalSecondaryIndexDescriptionJsonMarshaller();
        }
        return instance;
    }
}
