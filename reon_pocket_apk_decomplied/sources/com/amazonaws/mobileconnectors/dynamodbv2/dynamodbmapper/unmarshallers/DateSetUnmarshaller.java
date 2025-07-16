package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.lang.reflect.Method;
import java.util.HashSet;

public final class DateSetUnmarshaller extends SSUnmarshaller {
    private static final DateSetUnmarshaller INSTANCE = new DateSetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static DateSetUnmarshaller instance() {
        return INSTANCE;
    }

    private DateSetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (String parseISO8601Date : attributeValue.getSS()) {
            hashSet.add(DateUtils.parseISO8601Date(parseISO8601Date));
        }
        return hashSet;
    }
}
