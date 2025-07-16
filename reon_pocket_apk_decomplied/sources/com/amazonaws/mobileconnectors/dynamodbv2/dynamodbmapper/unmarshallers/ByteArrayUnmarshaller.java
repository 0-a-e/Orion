package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class ByteArrayUnmarshaller extends BUnmarshaller {
    private static final ByteArrayUnmarshaller INSTANCE = new ByteArrayUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ByteArrayUnmarshaller instance() {
        return INSTANCE;
    }

    private ByteArrayUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        ByteBuffer b = attributeValue.getB();
        if (b.hasArray()) {
            return b.array();
        }
        byte[] bArr = new byte[b.remaining()];
        b.get(bArr);
        return bArr;
    }
}
