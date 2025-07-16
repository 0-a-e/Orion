package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class ByteUnmarshaller extends NUnmarshaller {
    private static final ByteUnmarshaller INSTANCE = new ByteUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ByteUnmarshaller instance() {
        return INSTANCE;
    }

    private ByteUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return Byte.valueOf(attributeValue.getN());
    }
}
