package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexInfo;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class LocalSecondaryIndexInfoJsonMarshaller {
    private static LocalSecondaryIndexInfoJsonMarshaller instance;

    LocalSecondaryIndexInfoJsonMarshaller() {
    }

    public void marshall(LocalSecondaryIndexInfo localSecondaryIndexInfo, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (localSecondaryIndexInfo.getIndexName() != null) {
            String indexName = localSecondaryIndexInfo.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (localSecondaryIndexInfo.getKeySchema() != null) {
            List<KeySchemaElement> keySchema = localSecondaryIndexInfo.getKeySchema();
            awsJsonWriter.name("KeySchema");
            awsJsonWriter.beginArray();
            for (KeySchemaElement next : keySchema) {
                if (next != null) {
                    KeySchemaElementJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (localSecondaryIndexInfo.getProjection() != null) {
            Projection projection = localSecondaryIndexInfo.getProjection();
            awsJsonWriter.name("Projection");
            ProjectionJsonMarshaller.getInstance().marshall(projection, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static LocalSecondaryIndexInfoJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new LocalSecondaryIndexInfoJsonMarshaller();
        }
        return instance;
    }
}
