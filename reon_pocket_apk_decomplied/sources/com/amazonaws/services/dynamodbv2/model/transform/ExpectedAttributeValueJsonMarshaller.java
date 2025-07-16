package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.util.json.AwsJsonWriter;
import java.util.List;

class ExpectedAttributeValueJsonMarshaller {
    private static ExpectedAttributeValueJsonMarshaller instance;

    ExpectedAttributeValueJsonMarshaller() {
    }

    public void marshall(ExpectedAttributeValue expectedAttributeValue, AwsJsonWriter awsJsonWriter) throws Exception {
        awsJsonWriter.beginObject();
        if (expectedAttributeValue.getValue() != null) {
            AttributeValue value = expectedAttributeValue.getValue();
            awsJsonWriter.name("Value");
            AttributeValueJsonMarshaller.getInstance().marshall(value, awsJsonWriter);
        }
        if (expectedAttributeValue.getExists() != null) {
            Boolean exists = expectedAttributeValue.getExists();
            awsJsonWriter.name("Exists");
            awsJsonWriter.value(exists.booleanValue());
        }
        if (expectedAttributeValue.getComparisonOperator() != null) {
            String comparisonOperator = expectedAttributeValue.getComparisonOperator();
            awsJsonWriter.name("ComparisonOperator");
            awsJsonWriter.value(comparisonOperator);
        }
        if (expectedAttributeValue.getAttributeValueList() != null) {
            List<AttributeValue> attributeValueList = expectedAttributeValue.getAttributeValueList();
            awsJsonWriter.name("AttributeValueList");
            awsJsonWriter.beginArray();
            for (AttributeValue next : attributeValueList) {
                if (next != null) {
                    AttributeValueJsonMarshaller.getInstance().marshall(next, awsJsonWriter);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static ExpectedAttributeValueJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new ExpectedAttributeValueJsonMarshaller();
        }
        return instance;
    }
}
