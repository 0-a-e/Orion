package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public final class StringToStringMarshaller implements ArgumentMarshaller.StringAttributeMarshaller {
    private static final StringToStringMarshaller INSTANCE = new StringToStringMarshaller();

    public static StringToStringMarshaller instance() {
        return INSTANCE;
    }

    private StringToStringMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        return new AttributeValue().withS(str);
    }
}
