package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class IntegerUnmarshaller extends NUnmarshaller {
    private static final IntegerUnmarshaller INSTANCE = new IntegerUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static IntegerUnmarshaller instance() {
        return INSTANCE;
    }

    private IntegerUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return Integer.valueOf(attributeValue.getN());
    }
}
