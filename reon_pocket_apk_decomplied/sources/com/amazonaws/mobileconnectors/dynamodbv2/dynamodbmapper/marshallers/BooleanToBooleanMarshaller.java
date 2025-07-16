package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public final class BooleanToBooleanMarshaller implements ArgumentMarshaller.BooleanAttributeMarshaller {
    private static final BooleanToBooleanMarshaller INSTANCE = new BooleanToBooleanMarshaller();

    public static BooleanToBooleanMarshaller instance() {
        return INSTANCE;
    }

    private BooleanToBooleanMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        return new AttributeValue().withBOOL((Boolean) obj);
    }
}
