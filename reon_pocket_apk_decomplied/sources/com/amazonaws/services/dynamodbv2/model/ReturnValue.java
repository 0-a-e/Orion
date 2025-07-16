package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum ReturnValue {
    NONE("NONE"),
    ALL_OLD("ALL_OLD"),
    UPDATED_OLD("UPDATED_OLD"),
    ALL_NEW("ALL_NEW"),
    UPDATED_NEW("UPDATED_NEW");
    
    private static final Map<String, ReturnValue> enumMap = null;
    private String value;

    static {
        ReturnValue returnValue;
        ReturnValue returnValue2;
        ReturnValue returnValue3;
        ReturnValue returnValue4;
        ReturnValue returnValue5;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("NONE", returnValue);
        hashMap.put("ALL_OLD", returnValue2);
        hashMap.put("UPDATED_OLD", returnValue3);
        hashMap.put("ALL_NEW", returnValue4);
        hashMap.put("UPDATED_NEW", returnValue5);
    }

    private ReturnValue(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ReturnValue fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ReturnValue> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
