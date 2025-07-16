package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Set;

public final class CalendarSetToStringSetMarshaller implements ArgumentMarshaller.StringSetAttributeMarshaller {
    private static final CalendarSetToStringSetMarshaller INSTANCE = new CalendarSetToStringSetMarshaller();

    public static CalendarSetToStringSetMarshaller instance() {
        return INSTANCE;
    }

    private CalendarSetToStringSetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<Calendar> set = (Set) obj;
        ArrayList arrayList = new ArrayList(set.size());
        for (Calendar time : set) {
            arrayList.add(DateUtils.formatISO8601Date(time.getTime()));
        }
        return new AttributeValue().withSS((Collection<String>) arrayList);
    }
}
