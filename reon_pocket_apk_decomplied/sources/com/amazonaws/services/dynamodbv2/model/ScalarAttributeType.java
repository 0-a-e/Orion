package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum ScalarAttributeType {
    S("S"),
    N("N"),
    B("B");
    
    private static final Map<String, ScalarAttributeType> enumMap = null;
    private String value;

    static {
        ScalarAttributeType scalarAttributeType;
        ScalarAttributeType scalarAttributeType2;
        ScalarAttributeType scalarAttributeType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("S", scalarAttributeType);
        hashMap.put("N", scalarAttributeType2);
        hashMap.put("B", scalarAttributeType3);
    }

    private ScalarAttributeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ScalarAttributeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ScalarAttributeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
