package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum KeySpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    ECC_NIST_P256("ECC_NIST_P256"),
    ECC_NIST_P384("ECC_NIST_P384"),
    ECC_NIST_P521("ECC_NIST_P521"),
    ECC_SECG_P256K1("ECC_SECG_P256K1"),
    SYMMETRIC_DEFAULT("SYMMETRIC_DEFAULT"),
    HMAC_224("HMAC_224"),
    HMAC_256("HMAC_256"),
    HMAC_384("HMAC_384"),
    HMAC_512("HMAC_512"),
    SM2("SM2");
    
    private static final Map<String, KeySpec> enumMap = null;
    private String value;

    static {
        KeySpec keySpec;
        KeySpec keySpec2;
        KeySpec keySpec3;
        KeySpec keySpec4;
        KeySpec keySpec5;
        KeySpec keySpec6;
        KeySpec keySpec7;
        KeySpec keySpec8;
        KeySpec keySpec9;
        KeySpec keySpec10;
        KeySpec keySpec11;
        KeySpec keySpec12;
        KeySpec keySpec13;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", keySpec);
        hashMap.put("RSA_3072", keySpec2);
        hashMap.put("RSA_4096", keySpec3);
        hashMap.put("ECC_NIST_P256", keySpec4);
        hashMap.put("ECC_NIST_P384", keySpec5);
        hashMap.put("ECC_NIST_P521", keySpec6);
        hashMap.put("ECC_SECG_P256K1", keySpec7);
        hashMap.put("SYMMETRIC_DEFAULT", keySpec8);
        hashMap.put("HMAC_224", keySpec9);
        hashMap.put("HMAC_256", keySpec10);
        hashMap.put("HMAC_384", keySpec11);
        hashMap.put("HMAC_512", keySpec12);
        hashMap.put("SM2", keySpec13);
    }

    private KeySpec(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static KeySpec fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, KeySpec> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
