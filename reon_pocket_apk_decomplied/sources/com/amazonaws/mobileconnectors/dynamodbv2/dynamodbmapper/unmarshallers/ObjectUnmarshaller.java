package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ItemConverter;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.text.ParseException;

public class ObjectUnmarshaller extends MUnmarshaller {
    private static final ObjectUnmarshaller INSTANCE = new ObjectUnmarshaller();
    private final Class<?> clazz;
    private final ItemConverter converter;

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ObjectUnmarshaller instance() {
        return INSTANCE;
    }

    private ObjectUnmarshaller() {
        this.converter = null;
        this.clazz = null;
    }

    public ObjectUnmarshaller(ItemConverter itemConverter, Class<?> cls) {
        if (itemConverter == null) {
            throw new NullPointerException("converter");
        } else if (cls != null) {
            this.converter = itemConverter;
            this.clazz = cls;
        } else {
            throw new NullPointerException("clazz");
        }
    }

    public Object unmarshall(AttributeValue attributeValue) throws ParseException {
        return this.converter.unconvert(this.clazz, attributeValue.getM());
    }
}
