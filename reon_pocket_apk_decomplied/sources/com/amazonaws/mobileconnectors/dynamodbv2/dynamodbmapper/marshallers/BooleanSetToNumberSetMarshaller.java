package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public final class BooleanSetToNumberSetMarshaller implements ArgumentMarshaller.NumberSetAttributeMarshaller {
    private static final BooleanSetToNumberSetMarshaller INSTANCE = new BooleanSetToNumberSetMarshaller();

    public static BooleanSetToNumberSetMarshaller instance() {
        return INSTANCE;
    }

    private BooleanSetToNumberSetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<Boolean> set = (Set) obj;
        ArrayList arrayList = new ArrayList(set.size());
        for (Boolean booleanValue : set) {
            if (!booleanValue.booleanValue()) {
                arrayList.add("0");
            } else {
                arrayList.add("1");
            }
        }
        return new AttributeValue().withNS((Collection<String>) arrayList);
    }
}
