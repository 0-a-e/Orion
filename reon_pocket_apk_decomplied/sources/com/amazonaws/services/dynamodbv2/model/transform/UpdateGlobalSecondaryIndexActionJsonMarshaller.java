package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalSecondaryIndexAction;
import com.amazonaws.util.json.AwsJsonWriter;

class UpdateGlobalSecondaryIndexActionJsonMarshaller {
    private static UpdateGlobalSecondaryIndexActionJsonMarshaller instance;

    UpdateGlobalSecondaryIndexActionJsonMarshaller() {
    }

    public void marshall(UpdateGlobalSecondaryIndexAction updateGlobalSecondaryIndexAction, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (updateGlobalSecondaryIndexAction.getIndexName() != null) {
            String indexName = updateGlobalSecondaryIndexAction.getIndexName();
            awsJsonWriter.name("IndexName");
            awsJsonWriter.value(indexName);
        }
        if (updateGlobalSecondaryIndexAction.getProvisionedThroughput() != null) {
            ProvisionedThroughput provisionedThroughput = updateGlobalSecondaryIndexAction.getProvisionedThroughput();
            awsJsonWriter.name("ProvisionedThroughput");
            ProvisionedThroughputJsonMarshaller.getInstance().marshall(provisionedThroughput, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static UpdateGlobalSecondaryIndexActionJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateGlobalSecondaryIndexActionJsonMarshaller();
        }
        return instance;
    }
}
