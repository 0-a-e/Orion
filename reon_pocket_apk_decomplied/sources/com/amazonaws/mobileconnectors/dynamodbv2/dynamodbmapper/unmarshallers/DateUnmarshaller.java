package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.lang.reflect.Method;

public final class DateUnmarshaller extends SUnmarshaller {
    private static final DateUnmarshaller INSTANCE = new DateUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static DateUnmarshaller instance() {
        return INSTANCE;
    }

    private DateUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        return DateUtils.parseISO8601Date(attributeValue.getS());
    }
}
