package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class ByteBufferUnmarshaller extends BUnmarshaller {
    private static final ByteBufferUnmarshaller INSTANCE = new ByteBufferUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ByteBufferUnmarshaller instance() {
        return INSTANCE;
    }

    private ByteBufferUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return attributeValue.getB();
    }
}
