package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.util.Calendar;

public final class CalendarToStringMarshaller implements ArgumentMarshaller.StringAttributeMarshaller {
    private static final CalendarToStringMarshaller INSTANCE = new CalendarToStringMarshaller();

    public static CalendarToStringMarshaller instance() {
        return INSTANCE;
    }

    private CalendarToStringMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        return new AttributeValue().withS(DateUtils.formatISO8601Date(((Calendar) obj).getTime()));
    }
}
