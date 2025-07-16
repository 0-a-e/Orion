package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum IndexStatus {
    CREATING("CREATING"),
    UPDATING("UPDATING"),
    DELETING("DELETING"),
    ACTIVE("ACTIVE");
    
    private static final Map<String, IndexStatus> enumMap = null;
    private String value;

    static {
        IndexStatus indexStatus;
        IndexStatus indexStatus2;
        IndexStatus indexStatus3;
        IndexStatus indexStatus4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CREATING", indexStatus);
        hashMap.put("UPDATING", indexStatus2);
        hashMap.put("DELETING", indexStatus3);
        hashMap.put("ACTIVE", indexStatus4);
    }

    private IndexStatus(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static IndexStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, IndexStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
