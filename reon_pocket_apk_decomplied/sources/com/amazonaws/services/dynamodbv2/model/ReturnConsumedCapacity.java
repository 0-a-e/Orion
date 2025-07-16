package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum ReturnConsumedCapacity {
    INDEXES("INDEXES"),
    TOTAL("TOTAL"),
    NONE("NONE");
    
    private static final Map<String, ReturnConsumedCapacity> enumMap = null;
    private String value;

    static {
        ReturnConsumedCapacity returnConsumedCapacity;
        ReturnConsumedCapacity returnConsumedCapacity2;
        ReturnConsumedCapacity returnConsumedCapacity3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("INDEXES", returnConsumedCapacity);
        hashMap.put("TOTAL", returnConsumedCapacity2);
        hashMap.put("NONE", returnConsumedCapacity3);
    }

    private ReturnConsumedCapacity(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ReturnConsumedCapacity fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ReturnConsumedCapacity> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
