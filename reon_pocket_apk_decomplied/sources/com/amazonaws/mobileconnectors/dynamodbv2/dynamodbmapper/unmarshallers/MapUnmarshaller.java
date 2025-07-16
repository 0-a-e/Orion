package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.unmarshallers;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.ArgumentUnmarshaller;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class MapUnmarshaller extends MUnmarshaller {
    private static final MapUnmarshaller INSTANCE = new MapUnmarshaller();
    private final ArgumentUnmarshaller memberUnmarshaller;

    public /* bridge */ /* synthetic */ void typeCheck(AttributeValue attributeValue, Method method) {
        super.typeCheck(attributeValue, method);
    }

    public static MapUnmarshaller instance() {
        return INSTANCE;
    }

    private MapUnmarshaller() {
        this.memberUnmarshaller = null;
    }

    public MapUnmarshaller(ArgumentUnmarshaller argumentUnmarshaller) {
        if (argumentUnmarshaller != null) {
            this.memberUnmarshaller = argumentUnmarshaller;
            return;
        }
        throw new NullPointerException("memberUnmarshaller");
    }

    public Object unmarshall(AttributeValue attributeValue) throws ParseException {
        Map<String, AttributeValue> m = attributeValue.getM();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : m.entrySet()) {
            this.memberUnmarshaller.typeCheck((AttributeValue) next.getValue(), (Method) null);
            hashMap.put(next.getKey(), this.memberUnmarshaller.unmarshall((AttributeValue) next.getValue()));
        }
        return hashMap;
    }
}
