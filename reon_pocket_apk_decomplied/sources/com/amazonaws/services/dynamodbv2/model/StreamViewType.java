package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum StreamViewType {
    NEW_IMAGE("NEW_IMAGE"),
    OLD_IMAGE("OLD_IMAGE"),
    NEW_AND_OLD_IMAGES("NEW_AND_OLD_IMAGES"),
    KEYS_ONLY("KEYS_ONLY");
    
    private static final Map<String, StreamViewType> enumMap = null;
    private String value;

    static {
        StreamViewType streamViewType;
        StreamViewType streamViewType2;
        StreamViewType streamViewType3;
        StreamViewType streamViewType4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("NEW_IMAGE", streamViewType);
        hashMap.put("OLD_IMAGE", streamViewType2);
        hashMap.put("NEW_AND_OLD_IMAGES", streamViewType3);
        hashMap.put("KEYS_ONLY", streamViewType4);
    }

    private StreamViewType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static StreamViewType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, StreamViewType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
