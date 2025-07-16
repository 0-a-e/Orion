package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashSet;

public final class BigDecimalSetUnmarshaller extends NSUnmarshaller {
    private static final BigDecimalSetUnmarshaller INSTANCE = new BigDecimalSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static BigDecimalSetUnmarshaller instance() {
        return INSTANCE;
    }

    private BigDecimalSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String bigDecimal : attributeValue.getNS()) {
            hashSet.add(new BigDecimal(bigDecimal));
        }
        return hashSet;
    }
}
