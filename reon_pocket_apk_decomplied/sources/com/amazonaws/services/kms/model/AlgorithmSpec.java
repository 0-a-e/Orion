package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum AlgorithmSpec {
    RSAES_PKCS1_V1_5("RSAES_PKCS1_V1_5"),
    RSAES_OAEP_SHA_1("RSAES_OAEP_SHA_1"),
    RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256"),
    RSA_AES_KEY_WRAP_SHA_1("RSA_AES_KEY_WRAP_SHA_1"),
    RSA_AES_KEY_WRAP_SHA_256("RSA_AES_KEY_WRAP_SHA_256"),
    SM2PKE("SM2PKE");
    
    private static final Map<String, AlgorithmSpec> enumMap = null;
    private String value;

    static {
        AlgorithmSpec algorithmSpec;
        AlgorithmSpec algorithmSpec2;
        AlgorithmSpec algorithmSpec3;
        AlgorithmSpec algorithmSpec4;
        AlgorithmSpec algorithmSpec5;
        AlgorithmSpec algorithmSpec6;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSAES_PKCS1_V1_5", algorithmSpec);
        hashMap.put("RSAES_OAEP_SHA_1", algorithmSpec2);
        hashMap.put("RSAES_OAEP_SHA_256", algorithmSpec3);
        hashMap.put("RSA_AES_KEY_WRAP_SHA_1", algorithmSpec4);
        hashMap.put("RSA_AES_KEY_WRAP_SHA_256", algorithmSpec5);
        hashMap.put("SM2PKE", algorithmSpec6);
    }

    private AlgorithmSpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static AlgorithmSpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, AlgorithmSpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
