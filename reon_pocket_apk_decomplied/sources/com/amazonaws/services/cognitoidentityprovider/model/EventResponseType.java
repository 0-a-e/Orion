package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum EventResponseType {
    Pass("Pass"),
    Fail("Fail"),
    InProgress("InProgress");
    
    private static final Map<String, EventResponseType> enumMap = null;
    private String value;

    static {
        EventResponseType eventResponseType;
        EventResponseType eventResponseType2;
        EventResponseType eventResponseType3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Pass", eventResponseType);
        hashMap.put("Fail", eventResponseType2);
        hashMap.put("InProgress", eventResponseType3);
    }

    private EventResponseType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static EventResponseType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, EventResponseType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
