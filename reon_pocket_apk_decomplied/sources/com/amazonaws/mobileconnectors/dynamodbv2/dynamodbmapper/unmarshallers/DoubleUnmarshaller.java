package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class DoubleUnmarshaller extends NUnmarshaller {
    private static final DoubleUnmarshaller INSTANCE = new DoubleUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static DoubleUnmarshaller instance() {
        return INSTANCE;
    }

    private DoubleUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return Double.valueOf(attributeValue.getN());
    }
}
