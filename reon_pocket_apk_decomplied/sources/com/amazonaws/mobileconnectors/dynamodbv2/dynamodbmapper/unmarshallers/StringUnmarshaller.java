package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class StringUnmarshaller extends SUnmarshaller {
    private static final StringUnmarshaller INSTANCE = new StringUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static StringUnmarshaller instance() {
        return INSTANCE;
    }

    private StringUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return attributeValue.getS();
    }
}
