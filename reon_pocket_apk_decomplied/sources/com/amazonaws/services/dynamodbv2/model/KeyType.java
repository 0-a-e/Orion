package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum KeyType {
    HASH("HASH"),
    RANGE("RANGE");
    
    private static final Map<String, KeyType> enumMap = null;
    private String value;

    static {
        KeyType keyType;
        KeyType keyType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("HASH", keyType);
        hashMap.put("RANGE", keyType2);
    }

    private KeyType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static KeyType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
