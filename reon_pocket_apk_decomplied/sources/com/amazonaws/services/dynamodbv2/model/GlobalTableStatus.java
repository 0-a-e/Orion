package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum GlobalTableStatus {
    CREATING("CREATING"),
    ACTIVE("ACTIVE"),
    DELETING("DELETING"),
    UPDATING("UPDATING");
    
    private static final Map<String, GlobalTableStatus> enumMap = null;
    private String value;

    static {
        GlobalTableStatus globalTableStatus;
        GlobalTableStatus globalTableStatus2;
        GlobalTableStatus globalTableStatus3;
        GlobalTableStatus globalTableStatus4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CREATING", globalTableStatus);
        hashMap.put("ACTIVE", globalTableStatus2);
        hashMap.put("DELETING", globalTableStatus3);
        hashMap.put("UPDATING", globalTableStatus4);
    }

    private GlobalTableStatus(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static GlobalTableStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, GlobalTableStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
