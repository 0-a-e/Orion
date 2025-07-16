package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndex;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class GlobalSecondaryIndexJsonMarshaller {
    private static GlobalSecondaryIndexJsonMarshaller instance;

    GlobalSecondaryIndexJsonMarshaller() {
    }

    public void marshall(GlobalSecondaryIndex globalSecondaryIndex, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (globalSecondaryIndex.getIndexName() != null) {
            String indexName = globalSecondaryIndex.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (globalSecondaryIndex.getKeySchema() != null) {
            List<KeySchemaElement> keySchema = globalSecondaryIndex.getKeySchema();
            awsJsonWriter.name("KeySchema");
            awsJsonWriter.beginArray();
            for (KeySchemaElement next : keySchema) {
                if (next != null) {
                    KeySchemaElementJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (globalSecondaryIndex.getProjection() != null) {
            Projection projection = globalSecondaryIndex.getProjection();
            awsJsonWriter.name("Projection");
            ProjectionJsonMarshaller.getInstance().marshall(projection, awsJsonWriter);
        }
        if (globalSecondaryIndex.getProvisionedThroughput() != null) {
            ProvisionedThroughput provisionedThroughput = globalSecondaryIndex.getProvisionedThroughput();
            awsJsonWriter.name("ProvisionedThroughput");
            ProvisionedThroughputJsonMarshaller.getInstance().marshall(provisionedThroughput, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static GlobalSecondaryIndexJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSecondaryIndexJsonMarshaller();
        }
        return instance;
    }
}
