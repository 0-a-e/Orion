package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum ReturnItemCollectionMetrics {
    SIZE("SIZE"),
    NONE("NONE");
    
    private static final Map<String, ReturnItemCollectionMetrics> enumMap = null;
    private String value;

    static {
        ReturnItemCollectionMetrics returnItemCollectionMetrics;
        ReturnItemCollectionMetrics returnItemCollectionMetrics2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SIZE", returnItemCollectionMetrics);
        hashMap.put("NONE", returnItemCollectionMetrics2);
    }

    private ReturnItemCollectionMetrics(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ReturnItemCollectionMetrics fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ReturnItemCollectionMetrics> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
