package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public final class BigDecimalUnmarshaller extends NUnmarshaller {
    private static final BigDecimalUnmarshaller INSTANCE = new BigDecimalUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static BigDecimalUnmarshaller instance() {
        return INSTANCE;
    }

    private BigDecimalUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return new BigDecimal(attributeValue.getN());
    }
}
