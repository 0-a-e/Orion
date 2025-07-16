package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public final class ObjectSetToStringSetMarshaller implements ArgumentMarshaller.StringSetAttributeMarshaller {
    private static final ObjectSetToStringSetMarshaller INSTANCE = new ObjectSetToStringSetMarshaller();
    private static final Log LOG = LogFactory.getLog((Class<?>) ObjectSetToStringSetMarshaller.class);

    public static ObjectSetToStringSetMarshaller instance() {
        return INSTANCE;
    }

    private ObjectSetToStringSetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<Object> set = (Set) obj;
        LOG.warn("Marshaling a set of non-String objects to a DynamoDB StringSet. You won't be able to read these objects back out of DynamoDB unless you REALLY know what you're doing: it's probably a bug. If you DO know what you're doing feelfree to ignore this warning, but consider using a custom marshaler for this instead.");
        ArrayList arrayList = new ArrayList(set.size());
        for (Object valueOf : set) {
            arrayList.add(String.valueOf(valueOf));
        }
        return new AttributeValue().withSS((Collection<String>) arrayList);
    }
}
