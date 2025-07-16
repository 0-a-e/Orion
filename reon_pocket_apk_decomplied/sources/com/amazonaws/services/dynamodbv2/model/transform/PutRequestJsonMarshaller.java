package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutRequest;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.Map;

class PutRequestJsonMarshaller {
    private static PutRequestJsonMarshaller instance;

    PutRequestJsonMarshaller() {
    }

    public void marshall(PutRequest putRequest, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (putRequest.getItem() != null) {
            Map<String, AttributeValue> item = putRequest.getItem();
            awsJsonWriter.name("Item");
            awsJsonWriter.beginObject();
            for (Map.Entry next : item.entrySet()) {
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

    public static PutRequestJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new PutRequestJsonMarshaller();
        }
        return instance;
    }
}
