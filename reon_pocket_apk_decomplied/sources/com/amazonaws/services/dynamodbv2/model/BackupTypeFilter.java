package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum BackupTypeFilter {
    USER("USER"),
    SYSTEM("SYSTEM"),
    ALL("ALL");
    
    private static final Map<String, BackupTypeFilter> enumMap = null;
    private String value;

    static {
        BackupTypeFilter backupTypeFilter;
        BackupTypeFilter backupTypeFilter2;
        BackupTypeFilter backupTypeFilter3;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("USER", backupTypeFilter);
        hashMap.put("SYSTEM", backupTypeFilter2);
        hashMap.put("ALL", backupTypeFilter3);
    }

    private BackupTypeFilter(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static BackupTypeFilter fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, BackupTypeFilter> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
