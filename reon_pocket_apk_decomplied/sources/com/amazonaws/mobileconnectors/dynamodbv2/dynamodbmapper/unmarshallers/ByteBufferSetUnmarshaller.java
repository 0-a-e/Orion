package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class ByteBufferSetUnmarshaller extends BSUnmarshaller {
    private static final ByteBufferSetUnmarshaller INSTANCE = new ByteBufferSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ByteBufferSetUnmarshaller instance() {
        return INSTANCE;
    }

    private ByteBufferSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return new HashSet(attributeValue.getBS());
    }
}
