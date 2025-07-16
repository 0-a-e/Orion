package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum MacAlgorithmSpec {
    HMAC_SHA_224("HMAC_SHA_224"),
    HMAC_SHA_256("HMAC_SHA_256"),
    HMAC_SHA_384("HMAC_SHA_384"),
    HMAC_SHA_512("HMAC_SHA_512");
    
    private static final Map<String, MacAlgorithmSpec> enumMap = null;
    private String value;

    static {
        MacAlgorithmSpec macAlgorithmSpec;
        MacAlgorithmSpec macAlgorithmSpec2;
        MacAlgorithmSpec macAlgorithmSpec3;
        MacAlgorithmSpec macAlgorithmSpec4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("HMAC_SHA_224", macAlgorithmSpec);
        hashMap.put("HMAC_SHA_256", macAlgorithmSpec2);
        hashMap.put("HMAC_SHA_384", macAlgorithmSpec3);
        hashMap.put("HMAC_SHA_512", macAlgorithmSpec4);
    }

    private MacAlgorithmSpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static MacAlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, MacAlgorithmSpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
