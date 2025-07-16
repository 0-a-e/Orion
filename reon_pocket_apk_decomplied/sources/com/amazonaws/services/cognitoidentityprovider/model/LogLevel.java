package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum LogLevel {
    ERROR("ERROR");
    
    private static final Map<String, LogLevel> enumMap = null;
    private String value;

    static {
        LogLevel logLevel;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("ERROR", logLevel);
    }

    private LogLevel(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static LogLevel fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, LogLevel> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
