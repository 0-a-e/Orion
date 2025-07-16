package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.CreateGlobalSecondaryIndexAction;
import com.amazonaws.services.dynamodbv2.model.DeleteGlobalSecondaryIndexAction;
import com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazonaws.services.dynamodbv2.model.UpdateGlobalSecondaryIndexAction;
import com.amazonaws.util.json.AwsJsonWriter;

class GlobalSecondaryIndexUpdateJsonMarshaller {
    private static GlobalSecondaryIndexUpdateJsonMarshaller instance;

    GlobalSecondaryIndexUpdateJsonMarshaller() {
    }

    public void marshall(GlobalSecondaryIndexUpdate globalSecondaryIndexUpdate, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (globalSecondaryIndexUpdate.getUpdate() != null) {
            UpdateGlobalSecondaryIndexAction update = globalSecondaryIndexUpdate.getUpdate();
            awsJsonWriter.name("Update");
            UpdateGlobalSecondaryIndexActionJsonMarshaller.getInstance().marshall(update, awsJsonWriter);
        }
        if (globalSecondaryIndexUpdate.getCreate() != null) {
            CreateGlobalSecondaryIndexAction create = globalSecondaryIndexUpdate.getCreate();
            awsJsonWriter.name("Create");
            CreateGlobalSecondaryIndexActionJsonMarshaller.getInstance().marshall(create, awsJsonWriter);
        }
        if (globalSecondaryIndexUpdate.getDelete() != null) {
            DeleteGlobalSecondaryIndexAction delete = globalSecondaryIndexUpdate.getDelete();
            awsJsonWriter.name("Delete");
            DeleteGlobalSecondaryIndexActionJsonMarshaller.getInstance().marshall(delete, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static GlobalSecondaryIndexUpdateJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSecondaryIndexUpdateJsonMarshaller();
        }
        return instance;
    }
}
