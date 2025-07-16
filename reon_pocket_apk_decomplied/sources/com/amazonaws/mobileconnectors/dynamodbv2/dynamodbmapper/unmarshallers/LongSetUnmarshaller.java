package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class LongSetUnmarshaller extends NSUnmarshaller {
    private static final LongSetUnmarshaller INSTANCE = new LongSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static LongSetUnmarshaller instance() {
        return INSTANCE;
    }

    private LongSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String valueOf : attributeValue.getNS()) {
            hashSet.add(Long.valueOf(valueOf));
        }
        return hashSet;
    }
}
