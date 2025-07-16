package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum CustomKeyStoreType {
    AWS_CLOUDHSM("AWS_CLOUDHSM"),
    EXTERNAL_KEY_STORE("EXTERNAL_KEY_STORE");
    
    private static final Map<String, CustomKeyStoreType> enumMap = null;
    private String value;

    static {
        CustomKeyStoreType customKeyStoreType;
        CustomKeyStoreType customKeyStoreType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AWS_CLOUDHSM", customKeyStoreType);
        hashMap.put("EXTERNAL_KEY_STORE", customKeyStoreType2);
    }

    private CustomKeyStoreType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static CustomKeyStoreType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, CustomKeyStoreType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
