package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ItemConverter;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class ObjectToMapMarshaller implements ArgumentMarshaller.MapAttributeMarshaller {
    private static final ObjectToMapMarshaller INSTANCE = new ObjectToMapMarshaller();
    private final ItemConverter converter;

    public static ObjectToMapMarshaller instance() {
        return INSTANCE;
    }

    private ObjectToMapMarshaller() {
        this.converter = null;
    }

    public ObjectToMapMarshaller(ItemConverter itemConverter) {
        if (itemConverter != null) {
            this.converter = itemConverter;
            return;
        }
        throw new NullPointerException("converter");
    }

    public AttributeValue marshall(Object obj) {
        return new AttributeValue().withM(this.converter.convert(obj));
    }
}
