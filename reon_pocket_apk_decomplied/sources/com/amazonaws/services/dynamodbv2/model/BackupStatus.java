package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum BackupStatus {
    CREATING("CREATING"),
    DELETED("DELETED"),
    AVAILABLE("AVAILABLE");
    
    private static final Map<String, BackupStatus> enumMap = null;
    private String value;

    static {
        BackupStatus backupStatus;
        BackupStatus backupStatus2;
        BackupStatus backupStatus3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CREATING", backupStatus);
        hashMap.put("DELETED", backupStatus2);
        hashMap.put("AVAILABLE", backupStatus3);
    }

    private BackupStatus(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static BackupStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, BackupStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
