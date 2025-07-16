package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public final class ShortUnmarshaller extends NUnmarshaller {
    private static final ShortUnmarshaller INSTANCE = new ShortUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ShortUnmarshaller instance() {
        return INSTANCE;
    }

    private ShortUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return Short.valueOf(attributeValue.getN());
    }
}
