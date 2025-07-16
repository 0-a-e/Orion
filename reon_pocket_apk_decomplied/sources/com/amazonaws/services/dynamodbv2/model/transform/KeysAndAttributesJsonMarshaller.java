package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;
import java.util.Map;

class KeysAndAttributesJsonMarshaller {
    private static KeysAndAttributesJsonMarshaller instance;

    KeysAndAttributesJsonMarshaller() {
    }

    public void marshall(KeysAndAttributes keysAndAttributes, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (keysAndAttributes.getKeys() != null) {
            List<Map<String, AttributeValue>> keys = keysAndAttributes.getKeys();
            awsJsonWriter.name("Keys");
            awsJsonWriter.beginArray();
            for (Map next : keys) {
                if (next != null) {
                    awsJsonWriter.beginObject();
                    for (Map.Entry entry : next.entrySet()) {
                        AttributeValue attributeValue = (AttributeValue) entry.getValue();
                        if (attributeValue != null) {
                            awsJsonWriter.name((String) entry.getKey());
                            AttributeValueJsonMarshaller.getInstance().marshall(attributeValue, awsJsonWriter);
                        }
                    }
                    awsJsonWriter.endObject();
                }
            }
            awsJsonWriter.endArray();
        }
        if (keysAndAttributes.getAttributesToGet() != null) {
            List<String> attributesToGet = keysAndAttributes.getAttributesToGet();
            awsJsonWriter.name("AttributesToGet");
            awsJsonWriter.beginArray();
            for (String next2 : attributesToGet) {
                if (next2 != null) {
                    awsJsonWriter.value(next2);
                }
            }
            awsJsonWriter.endArray();
        }
        if (keysAndAttributes.getConsistentRead() != null) {
            Boolean consistentRead = keysAndAttributes.getConsistentRead();
            awsJsonWriter.name("ConsistentRead");
            awsJsonWriter.value(consistentRead.booleanValue());
        }
        if (keysAndAttributes.getProjectionExpression() != null) {
            String projectionExpression = keysAndAttributes.getProjectionExpression();
            awsJsonWriter.name("ProjectionExpression");
            awsJsonWriter.value(projectionExpression);
        }
        if (keysAndAttributes.getExpressionAttributeNames() != null) {
            Map<String, String> expressionAttributeNames = keysAndAttributes.getExpressionAttributeNames();
            awsJsonWriter.name("ExpressionAttributeNames");
            awsJsonWriter.beginObject();
            for (Map.Entry next3 : expressionAttributeNames.entrySet()) {
                String str = (String) next3.getValue();
                if (str != null) {
                    awsJsonWriter.name((String) next3.getKey());
                    awsJsonWriter.value(str);
                }
            }
            awsJsonWriter.endObject();
        }
        awsJsonWriter.endObject();
    }

    public static KeysAndAttributesJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new KeysAndAttributesJsonMarshaller();
        }
        return instance;
    }
}
