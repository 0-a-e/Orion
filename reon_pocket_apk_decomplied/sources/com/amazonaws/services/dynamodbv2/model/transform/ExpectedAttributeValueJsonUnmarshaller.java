package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ExpectedAttributeValueJsonUnmarshaller implements Unmarshaller<ExpectedAttributeValue, JsonUnmarshallerContext> {
    private static ExpectedAttributeValueJsonUnmarshaller instance;

    ExpectedAttributeValueJsonUnmarshaller() {
    }

    public ExpectedAttributeValue unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ExpectedAttributeValue expectedAttributeValue = new ExpectedAttributeValue();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("Value")) {
                expectedAttributeValue.setValue(AttributeValueJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("Exists")) {
                expectedAttributeValue.setExists(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ComparisonOperator")) {
                expectedAttributeValue.setComparisonOperator(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("AttributeValueList")) {
                expectedAttributeValue.setAttributeValueList(new ListUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return expectedAttributeValue;
    }

    public static ExpectedAttributeValueJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ExpectedAttributeValueJsonUnmarshaller();
        }
        return instance;
    }
}
