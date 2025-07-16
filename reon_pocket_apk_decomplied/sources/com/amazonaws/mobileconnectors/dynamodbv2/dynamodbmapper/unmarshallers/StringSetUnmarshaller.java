package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class StringSetUnmarshaller extends SSUnmarshaller {
    private static final StringSetUnmarshaller INSTANCE = new StringSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static StringSetUnmarshaller instance() {
        return INSTANCE;
    }

    private StringSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return new HashSet(attributeValue.getSS());
    }
}
