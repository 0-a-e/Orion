package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;

public final class BooleanSetUnmarshaller extends NSUnmarshaller {
    private static final BooleanSetUnmarshaller INSTANCE = new BooleanSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static BooleanSetUnmarshaller instance() {
        return INSTANCE;
    }

    private BooleanSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        List<String> ns = attributeValue.getNS();
        HashSet hashSet = new HashSet();
        for (String next : ns) {
            if ("1".equals(next)) {
                hashSet.add(Boolean.TRUE);
            } else if ("0".equals(next)) {
                hashSet.add(Boolean.FALSE);
            } else {
                throw new IllegalArgumentException("Expected '1' or '0' for boolean value, was " + next);
            }
        }
        return hashSet;
    }
}
