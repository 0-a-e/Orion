package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndex;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class LocalSecondaryIndexJsonMarshaller {
    private static LocalSecondaryIndexJsonMarshaller instance;

    LocalSecondaryIndexJsonMarshaller() {
    }

    public void marshall(LocalSecondaryIndex localSecondaryIndex, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (localSecondaryIndex.getIndexName() != null) {
            String indexName = localSecondaryIndex.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (localSecondaryIndex.getKeySchema() != null) {
            List<KeySchemaElement> keySchema = localSecondaryIndex.getKeySchema();
            awsJsonWriter.name("KeySchema");
            awsJsonWriter.beginArray();
            for (KeySchemaElement next : keySchema) {
                if (next != null) {
                    KeySchemaElementJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (localSecondaryIndex.getProjection() != null) {
            Projection projection = localSecondaryIndex.getProjection();
            awsJsonWriter.name("Projection");
            ProjectionJsonMarshaller.getInstance().marshall(projection, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static LocalSecondaryIndexJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new LocalSecondaryIndexJsonMarshaller();
        }
        return instance;
    }
}
