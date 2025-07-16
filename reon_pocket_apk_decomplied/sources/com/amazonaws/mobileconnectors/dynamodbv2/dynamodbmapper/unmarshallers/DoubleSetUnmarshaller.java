package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class DoubleSetUnmarshaller extends NSUnmarshaller {
    private static final DoubleSetUnmarshaller INSTANCE = new DoubleSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static DoubleSetUnmarshaller instance() {
        return INSTANCE;
    }

    private DoubleSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String valueOf : attributeValue.getNS()) {
            hashSet.add(Double.valueOf(valueOf));
        }
        return hashSet;
    }
}
