package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum EventType {
    SignIn("SignIn"),
    SignUp("SignUp"),
    ForgotPassword("ForgotPassword"),
    PasswordChange("PasswordChange"),
    ResendCode("ResendCode");
    
    private static final Map<String, EventType> enumMap = null;
    private String value;

    static {
        EventType eventType;
        EventType eventType2;
        EventType eventType3;
        EventType eventType4;
        EventType eventType5;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SignIn", eventType);
        hashMap.put("SignUp", eventType2);
        hashMap.put("ForgotPassword", eventType3);
        hashMap.put("PasswordChange", eventType4);
        hashMap.put("ResendCode", eventType5);
    }

    private EventType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static EventType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, EventType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
