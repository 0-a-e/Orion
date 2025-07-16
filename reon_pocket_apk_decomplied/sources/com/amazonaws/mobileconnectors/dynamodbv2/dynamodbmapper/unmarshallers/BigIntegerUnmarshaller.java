package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.math.BigInteger;

public final class BigIntegerUnmarshaller extends NUnmarshaller {
    private static final BigIntegerUnmarshaller INSTANCE = new BigIntegerUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static BigIntegerUnmarshaller instance() {
        return INSTANCE;
    }

    private BigIntegerUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return new BigInteger(attributeValue.getN());
    }
}
