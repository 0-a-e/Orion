package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.CreateGlobalSecondaryIndexAction;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.Projection;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class CreateGlobalSecondaryIndexActionJsonMarshaller {
    private static CreateGlobalSecondaryIndexActionJsonMarshaller instance;

    CreateGlobalSecondaryIndexActionJsonMarshaller() {
    }

    public void marshall(CreateGlobalSecondaryIndexAction createGlobalSecondaryIndexAction, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (createGlobalSecondaryIndexAction.getIndexName() != null) {
            String indexName = createGlobalSecondaryIndexAction.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (createGlobalSecondaryIndexAction.getKeySchema() != null) {
            List<KeySchemaElement> keySchema = createGlobalSecondaryIndexAction.getKeySchema();
            awsJsonWriter.name("KeySchema");
            awsJsonWriter.beginArray();
            for (KeySchemaElement next : keySchema) {
                if (next != null) {
                    KeySchemaElementJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        if (createGlobalSecondaryIndexAction.getProjection() != null) {
            Projection projection = createGlobalSecondaryIndexAction.getProjection();
            awsJsonWriter.name("Projection");
            ProjectionJsonMarshaller.getInstance().marshall(projection, awsJsonWriter);
        }
        if (createGlobalSecondaryIndexAction.getProvisionedThroughput() != null) {
            ProvisionedThroughput provisionedThroughput = createGlobalSecondaryIndexAction.getProvisionedThroughput();
            awsJsonWriter.name("ProvisionedThroughput");
            ProvisionedThroughputJsonMarshaller.getInstance().marshall(provisionedThroughput, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static CreateGlobalSecondaryIndexActionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CreateGlobalSecondaryIndexActionJsonMarshaller();
        }
        return instance;
    }
}
