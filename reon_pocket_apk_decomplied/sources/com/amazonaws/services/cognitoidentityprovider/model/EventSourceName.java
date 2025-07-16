package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum EventSourceName {
    UserNotification("userNotification");
    
    private static final Map<String, EventSourceName> enumMap = null;
    private String value;

    static {
        EventSourceName eventSourceName;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("userNotification", eventSourceName);
    }

    private EventSourceName(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static EventSourceName fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, EventSourceName> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
