package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum SSEStatus {
    ENABLING("ENABLING"),
    ENABLED("ENABLED"),
    DISABLING("DISABLING"),
    DISABLED("DISABLED"),
    UPDATING("UPDATING");
    
    private static final Map<String, SSEStatus> enumMap = null;
    private String value;

    static {
        SSEStatus sSEStatus;
        SSEStatus sSEStatus2;
        SSEStatus sSEStatus3;
        SSEStatus sSEStatus4;
        SSEStatus sSEStatus5;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("ENABLING", sSEStatus);
        hashMap.put("ENABLED", sSEStatus2);
        hashMap.put("DISABLING", sSEStatus3);
        hashMap.put("DISABLED", sSEStatus4);
        hashMap.put("UPDATING", sSEStatus5);
    }

    private SSEStatus(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static SSEStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, SSEStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
