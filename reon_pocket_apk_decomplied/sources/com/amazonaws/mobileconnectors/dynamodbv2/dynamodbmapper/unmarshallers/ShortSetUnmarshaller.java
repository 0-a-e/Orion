package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class ShortSetUnmarshaller extends NSUnmarshaller {
    private static final ShortSetUnmarshaller INSTANCE = new ShortSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ShortSetUnmarshaller instance() {
        return INSTANCE;
    }

    private ShortSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String valueOf : attributeValue.getNS()) {
            hashSet.add(Short.valueOf(valueOf));
        }
        return hashSet;
    }
}
