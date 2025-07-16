package com.amazonaws.services.cognitoidentityprovider.model;

import java.util.HashMap;
import java.util.Map;

public enum DeletionProtectionType {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");
    
    private static final Map<String, DeletionProtectionType> enumMap = null;
    private String value;

    static {
        DeletionProtectionType deletionProtectionType;
        DeletionProtectionType deletionProtectionType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("ACTIVE", deletionProtectionType);
        hashMap.put("INACTIVE", deletionProtectionType2);
    }

    private DeletionProtectionType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static DeletionProtectionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, DeletionProtectionType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
