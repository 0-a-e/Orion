package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class FloatUnmarshaller extends NUnmarshaller {
    private static final FloatUnmarshaller INSTANCE = new FloatUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static FloatUnmarshaller instance() {
        return INSTANCE;
    }

    private FloatUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return Float.valueOf(attributeValue.getN());
    }
}
