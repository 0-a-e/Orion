package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class FloatSetUnmarshaller extends NSUnmarshaller {
    private static final FloatSetUnmarshaller INSTANCE = new FloatSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static FloatSetUnmarshaller instance() {
        return INSTANCE;
    }

    private FloatSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String valueOf : attributeValue.getNS()) {
            hashSet.add(Float.valueOf(valueOf));
        }
        return hashSet;
    }
}
