package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;

public final class ByteArrayToBinaryMarshaller implements ArgumentMarshaller.BinaryAttributeMarshaller {
    private static final ByteArrayToBinaryMarshaller INSTANCE = new ByteArrayToBinaryMarshaller();

    public static ByteArrayToBinaryMarshaller instance() {
        return INSTANCE;
    }

    private ByteArrayToBinaryMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        return new AttributeValue().withB(ByteBuffer.wrap((byte[]) obj));
    }
}
