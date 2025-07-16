package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.DeleteRequest;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Map;

class DeleteRequestJsonMarshaller {
    private static DeleteRequestJsonMarshaller instance;

    DeleteRequestJsonMarshaller() {
    }

    public void marshall(DeleteRequest deleteRequest, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (deleteRequest.getKey() != null) {
            Map<String, AttributeValue> key = deleteRequest.getKey();
            awsJsonWriter.name("Key");
            awsJsonWriter.beginObject();
            for (Map.Entry next : key.entrySet()) {
                AttributeValue attributeValue = (AttributeValue) next.getValue();
                if (attributeValue != null) {
                    awsJsonWriter.name((String) next.getKey());
                    AttributeValueJsonMarshaller.getInstance().marshall(attributeValue, awsJsonWriter);
                }
            }
            awsJsonWriter.endObject();
        }
        awsJsonWriter.endObject();
    }

    public static DeleteRequestJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteRequestJsonMarshaller();
        }
        return instance;
    }
}
