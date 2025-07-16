package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum BackupType {
    USER("USER"),
    SYSTEM("SYSTEM");
    
    private static final Map<String, BackupType> enumMap = null;
    private String value;

    static {
        BackupType backupType;
        BackupType backupType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("USER", backupType);
        hashMap.put("SYSTEM", backupType2);
    }

    private BackupType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static BackupType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, BackupType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
