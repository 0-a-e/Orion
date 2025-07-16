package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum SSEType {
    AES256("AES256"),
    KMS("KMS");
    
    private static final Map<String, SSEType> enumMap = null;
    private String value;

    static {
        SSEType sSEType;
        SSEType sSEType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AES256", sSEType);
        hashMap.put("KMS", sSEType2);
    }

    private SSEType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static SSEType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, SSEType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
