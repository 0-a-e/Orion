package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashSet;

public final class BigIntegerSetUnmarshaller extends NSUnmarshaller {
    private static final BigIntegerSetUnmarshaller INSTANCE = new BigIntegerSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static BigIntegerSetUnmarshaller instance() {
        return INSTANCE;
    }

    private BigIntegerSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String bigInteger : attributeValue.getNS()) {
            hashSet.add(new BigInteger(bigInteger));
        }
        return hashSet;
    }
}
