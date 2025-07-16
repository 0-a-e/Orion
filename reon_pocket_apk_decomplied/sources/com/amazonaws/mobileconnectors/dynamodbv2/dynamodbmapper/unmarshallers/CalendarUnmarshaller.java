package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.lang.reflect.Method;
import java.util.Calendar;

public final class CalendarUnmarshaller extends SUnmarshaller {
    private static final CalendarUnmarshaller INSTANCE = new CalendarUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static CalendarUnmarshaller instance() {
        return INSTANCE;
    }

    private CalendarUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(DateUtils.parseISO8601Date(attributeValue.getS()));
        return instance;
    }
}
