package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class ByteSetUnmarshaller extends NSUnmarshaller {
    private static final ByteSetUnmarshaller INSTANCE = new ByteSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ByteSetUnmarshaller instance() {
        return INSTANCE;
    }

    private ByteSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String valueOf : attributeValue.getNS()) {
            hashSet.add(Byte.valueOf(valueOf));
        }
        return hashSet;
    }
}
