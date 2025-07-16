package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public final class StringSetToStringSetMarshaller implements ArgumentMarshaller.StringSetAttributeMarshaller {
    private static final StringSetToStringSetMarshaller INSTANCE = new StringSetToStringSetMarshaller();

    public static StringSetToStringSetMarshaller instance() {
        return INSTANCE;
    }

    private StringSetToStringSetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<String> set = (Set) obj;
        ArrayList arrayList = new ArrayList(set.size());
        for (String add : set) {
            arrayList.add(add);
        }
        return new AttributeValue().withSS((Collection<String>) arrayList);
    }
}
