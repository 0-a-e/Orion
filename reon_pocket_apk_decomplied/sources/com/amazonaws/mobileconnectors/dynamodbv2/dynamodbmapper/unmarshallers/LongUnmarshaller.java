package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class LongUnmarshaller extends NUnmarshaller {
    private static final LongUnmarshaller INSTANCE = new LongUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static LongUnmarshaller instance() {
        return INSTANCE;
    }

    private LongUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return Long.valueOf(attributeValue.getN());
    }
}
