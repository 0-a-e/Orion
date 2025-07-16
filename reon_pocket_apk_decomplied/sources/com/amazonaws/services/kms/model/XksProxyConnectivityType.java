package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum XksProxyConnectivityType {
    PUBLIC_ENDPOINT("PUBLIC_ENDPOINT"),
    VPC_ENDPOINT_SERVICE("VPC_ENDPOINT_SERVICE");
    
    private static final Map<String, XksProxyConnectivityType> enumMap = null;
    private String value;

    static {
        XksProxyConnectivityType xksProxyConnectivityType;
        XksProxyConnectivityType xksProxyConnectivityType2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("PUBLIC_ENDPOINT", xksProxyConnectivityType);
        hashMap.put("VPC_ENDPOINT_SERVICE", xksProxyConnectivityType2);
    }

    private XksProxyConnectivityType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static XksProxyConnectivityType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, XksProxyConnectivityType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
