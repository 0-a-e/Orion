package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum RotationType {
    AUTOMATIC("AUTOMATIC"),
    ON_DEMAND("ON_DEMAND");
    
    private static final Map<String, RotationType> enumMap = null;
    private String value;

    static {
        RotationType rotationType;
        RotationType rotationType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AUTOMATIC", rotationType);
        hashMap.put("ON_DEMAND", rotationType2);
    }

    private RotationType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static RotationType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, RotationType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
