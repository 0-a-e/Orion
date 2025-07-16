package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

public final class DateSetToStringSetMarshaller implements ArgumentMarshaller.StringSetAttributeMarshaller {
    private static final DateSetToStringSetMarshaller INSTANCE = new DateSetToStringSetMarshaller();

    public static DateSetToStringSetMarshaller instance() {
        return INSTANCE;
    }

    private DateSetToStringSetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<Date> set = (Set) obj;
        ArrayList arrayList = new ArrayList(set.size());
        for (Date formatISO8601Date : set) {
            arrayList.add(DateUtils.formatISO8601Date(formatISO8601Date));
        }
        return new AttributeValue().withSS((Collection<String>) arrayList);
    }
}
