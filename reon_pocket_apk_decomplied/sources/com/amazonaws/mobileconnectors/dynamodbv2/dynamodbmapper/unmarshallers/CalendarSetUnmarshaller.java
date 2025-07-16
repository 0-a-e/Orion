package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashSet;

public final class CalendarSetUnmarshaller extends SSUnmarshaller {
    private static final CalendarSetUnmarshaller INSTANCE = new CalendarSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static CalendarSetUnmarshaller instance() {
        return INSTANCE;
    }

    private CalendarSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String parseISO8601Date : attributeValue.getSS()) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(DateUtils.parseISO8601Date(parseISO8601Date));
            hashSet.add(instance);
        }
        return hashSet;
    }
}
