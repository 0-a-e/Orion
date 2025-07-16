package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum KeyAgreementAlgorithmSpec {
    ECDH("ECDH");
    
    private static final Map<String, KeyAgreementAlgorithmSpec> enumMap = null;
    private String value;

    static {
        KeyAgreementAlgorithmSpec keyAgreementAlgorithmSpec;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("ECDH", keyAgreementAlgorithmSpec);
    }

    private KeyAgreementAlgorithmSpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static KeyAgreementAlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeyAgreementAlgorithmSpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
