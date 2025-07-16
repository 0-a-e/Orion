package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.HashSet;

public final class ByteArraySetUnmarshaller extends BSUnmarshaller {
    private static final ByteArraySetUnmarshaller INSTANCE = new ByteArraySetUnmarshaller();

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static ByteArraySetUnmarshaller instance() {
        return INSTANCE;
    }

    private ByteArraySetUnmarshaller() {
    }

    public Object unmarshall(AttributeValue attributeValue) {
        HashSet hashSet = new HashSet();
        for (ByteBuffer next : attributeValue.getBS()) {
            if (next.hasArray()) {
                hashSet.add(next.array());
            } else {
                byte[] bArr = new byte[next.remaining()];
                next.get(bArr);
                hashSet.add(bArr);
            }
        }
        return hashSet;
    }
}
