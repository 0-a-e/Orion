package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.util.DateUtils;
import java.util.Date;

public final class DateToStringMarshaller implements ArgumentMarshaller.StringAttributeMarshaller {
    private static final DateToStringMarshaller INSTANCE = new DateToStringMarshaller();

    public static DateToStringMarshaller instance() {
        return INSTANCE;
    }

    private DateToStringMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        return new AttributeValue().withS(DateUtils.formatISO8601Date((Date) obj));
    }
}
