package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public final class ByteArraySetToBinarySetMarshaller implements ArgumentMarshaller.BinarySetAttributeMarshaller {
    private static final ByteArraySetToBinarySetMarshaller INSTANCE = new ByteArraySetToBinarySetMarshaller();

    public static ByteArraySetToBinarySetMarshaller instance() {
        return INSTANCE;
    }

    private ByteArraySetToBinarySetMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        Set<byte[]> set = (Set) obj;
        ArrayList arrayList = new ArrayList(set.size());
        for (byte[] wrap : set) {
            arrayList.add(ByteBuffer.wrap(wrap));
        }
        return new AttributeValue().withBS((Collection<ByteBuffer>) arrayList);
    }
}
