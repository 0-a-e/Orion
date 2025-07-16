package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public final class NumberSetToNumberSetMarshaller implements ArgumentMarshaller.NumberSetAttributeMarshaller {
    private static final NumberSetToNumberSetMarshaller INSTANCE = new NumberSetToNumberSetMarshaller();

    public static NumberSetToNumberSetMarshaller instance() {
        return INSTANCE;
    }

    private NumberSetToNumberSetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<Number> set = (Set) obj;
        ArrayList arrayList = new ArrayList(set.size());
        for (Number obj2 : set) {
            arrayList.add(obj2.toString());
        }
        return new AttributeValue().withNS((Collection<String>) arrayList);
    }
}
