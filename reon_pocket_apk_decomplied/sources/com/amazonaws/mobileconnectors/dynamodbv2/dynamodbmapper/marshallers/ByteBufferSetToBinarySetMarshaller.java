package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public final class ByteBufferSetToBinarySetMarshaller implements ArgumentMarshaller.BinarySetAttributeMarshaller {
    private static final ByteBufferSetToBinarySetMarshaller INSTANCE = new ByteBufferSetToBinarySetMarshaller();

    public static ByteBufferSetToBinarySetMarshaller instance() {
        return INSTANCE;
    }

    private ByteBufferSetToBinarySetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<ByteBuffer> set = (Set) obj;
        ArrayList arrayList = new ArrayList(set.size());
        for (ByteBuffer add : set) {
            arrayList.add(add);
        }
        return new AttributeValue().withBS((Collection<ByteBuffer>) arrayList);
    }
}
