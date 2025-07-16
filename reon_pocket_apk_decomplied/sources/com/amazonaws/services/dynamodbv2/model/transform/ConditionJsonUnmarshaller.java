package com.amazonaws.services.dynamodbv2.model.transform;

import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

class ConditionJsonUnmarshaller implements Unmarshaller<Condition, JsonUnmarshallerContext> {
    private static ConditionJsonUnmarshaller instance;

    ConditionJsonUnmarshaller() {
    }

    public Condition unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        Condition condition = new Condition();
        reader.beginObject();
        while (reader.hasNext()) {
            String nextName = reader.nextName();
            if (nextName.equals("AttributeValueList")) {
                condition.setAttributeValueList(new ListUnmarshaller(AttributeValueJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (nextName.equals("ComparisonOperator")) {
                condition.setComparisonOperator(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return condition;
    }

    public static ConditionJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConditionJsonUnmarshaller();
        }
        return instance;
    }
}
