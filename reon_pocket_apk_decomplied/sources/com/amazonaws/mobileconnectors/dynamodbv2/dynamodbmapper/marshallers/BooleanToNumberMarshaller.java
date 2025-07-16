package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public final class BooleanToNumberMarshaller implements ArgumentMarshaller.NumberAttributeMarshaller {
    private static final BooleanToNumberMarshaller INSTANCE = new BooleanToNumberMarshaller();

    public static BooleanToNumberMarshaller instance() {
        return INSTANCE;
    }

    private BooleanToNumberMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            return new AttributeValue().withN("0");
        }
        return new AttributeValue().withN("1");
    }
}
