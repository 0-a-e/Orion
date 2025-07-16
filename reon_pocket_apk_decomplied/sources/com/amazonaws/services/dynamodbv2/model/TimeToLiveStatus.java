package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum TimeToLiveStatus {
    ENABLING("ENABLING"),
    DISABLING("DISABLING"),
    ENABLED("ENABLED"),
    DISABLED("DISABLED");
    
    private static final Map<String, TimeToLiveStatus> enumMap = null;
    private String value;

    static {
        TimeToLiveStatus timeToLiveStatus;
        TimeToLiveStatus timeToLiveStatus2;
        TimeToLiveStatus timeToLiveStatus3;
        TimeToLiveStatus timeToLiveStatus4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("ENABLING", timeToLiveStatus);
        hashMap.put("DISABLING", timeToLiveStatus2);
        hashMap.put("ENABLED", timeToLiveStatus3);
        hashMap.put("DISABLED", timeToLiveStatus4);
    }

    private TimeToLiveStatus(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static TimeToLiveStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, TimeToLiveStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
