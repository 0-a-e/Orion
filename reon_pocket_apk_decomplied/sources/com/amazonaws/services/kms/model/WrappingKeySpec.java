package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum WrappingKeySpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    SM2("SM2");
    
    private static final Map<String, WrappingKeySpec> enumMap = null;
    private String value;

    static {
        WrappingKeySpec wrappingKeySpec;
        WrappingKeySpec wrappingKeySpec2;
        WrappingKeySpec wrappingKeySpec3;
        WrappingKeySpec wrappingKeySpec4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", wrappingKeySpec);
        hashMap.put("RSA_3072", wrappingKeySpec2);
        hashMap.put("RSA_4096", wrappingKeySpec3);
        hashMap.put("SM2", wrappingKeySpec4);
    }

    private WrappingKeySpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static WrappingKeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, WrappingKeySpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
