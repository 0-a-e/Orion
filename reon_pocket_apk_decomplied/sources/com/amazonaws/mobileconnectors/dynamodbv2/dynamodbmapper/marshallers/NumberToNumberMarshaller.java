package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public final class NumberToNumberMarshaller implements ArgumentMarshaller.NumberAttributeMarshaller {
    private static final NumberToNumberMarshaller INSTANCE = new NumberToNumberMarshaller();

    public static NumberToNumberMarshaller instance() {
        return INSTANCE;
    }

    private NumberToNumberMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        return new AttributeValue().withN(((Number) obj).toString());
    }
}
