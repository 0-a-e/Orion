package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.marshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentMarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;

public final class ByteBufferToBinaryMarshaller implements ArgumentMarshaller.BinaryAttributeMarshaller {
    private static final ByteBufferToBinaryMarshaller INSTANCE = new ByteBufferToBinaryMarshaller();

    public static ByteBufferToBinaryMarshaller instance() {
        return INSTANCE;
    }

    private ByteBufferToBinaryMarshaller() {
    }

    public AttributeValue marshall(Object obj) {
        return new AttributeValue().withB((ByteBuffer) obj);
    }
}
