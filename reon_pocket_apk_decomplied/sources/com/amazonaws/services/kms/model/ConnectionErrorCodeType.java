package com.amazonaws.services.kms.model;

import java.util.HashMap;
import java.util.Map;

public enum ConnectionErrorCodeType {
    INVALID_CREDENTIALS("INVALID_CREDENTIALS"),
    CLUSTER_NOT_FOUND("CLUSTER_NOT_FOUND"),
    NETWORK_ERRORS("NETWORK_ERRORS"),
    INTERNAL_ERROR("INTERNAL_ERROR"),
    INSUFFICIENT_CLOUDHSM_HSMS("INSUFFICIENT_CLOUDHSM_HSMS"),
    USER_LOCKED_OUT("USER_LOCKED_OUT"),
    USER_NOT_FOUND("USER_NOT_FOUND"),
    USER_LOGGED_IN("USER_LOGGED_IN"),
    SUBNET_NOT_FOUND("SUBNET_NOT_FOUND"),
    INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET("INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET"),
    XKS_PROXY_ACCESS_DENIED("XKS_PROXY_ACCESS_DENIED"),
    XKS_PROXY_NOT_REACHABLE("XKS_PROXY_NOT_REACHABLE"),
    XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND("XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND"),
    XKS_PROXY_INVALID_RESPONSE("XKS_PROXY_INVALID_RESPONSE"),
    XKS_PROXY_INVALID_CONFIGURATION("XKS_PROXY_INVALID_CONFIGURATION"),
    XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION("XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION"),
    XKS_PROXY_TIMED_OUT("XKS_PROXY_TIMED_OUT"),
    XKS_PROXY_INVALID_TLS_CONFIGURATION("XKS_PROXY_INVALID_TLS_CONFIGURATION");
    
    private static final Map<String, ConnectionErrorCodeType> enumMap = null;
    private String value;

    static {
        ConnectionErrorCodeType connectionErrorCodeType;
        ConnectionErrorCodeType connectionErrorCodeType2;
        ConnectionErrorCodeType connectionErrorCodeType3;
        ConnectionErrorCodeType connectionErrorCodeType4;
        ConnectionErrorCodeType connectionErrorCodeType5;
        ConnectionErrorCodeType connectionErrorCodeType6;
        ConnectionErrorCodeType connectionErrorCodeType7;
        ConnectionErrorCodeType connectionErrorCodeType8;
        ConnectionErrorCodeType connectionErrorCodeType9;
        ConnectionErrorCodeType connectionErrorCodeType10;
        ConnectionErrorCodeType connectionErrorCodeType11;
        ConnectionErrorCodeType connectionErrorCodeType12;
        ConnectionErrorCodeType connectionErrorCodeType13;
        ConnectionErrorCodeType connectionErrorCodeType14;
        ConnectionErrorCodeType connectionErrorCodeType15;
        ConnectionErrorCodeType connectionErrorCodeType16;
        ConnectionErrorCodeType connectionErrorCodeType17;
        ConnectionErrorCodeType connectionErrorCodeType18;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("INVALID_CREDENTIALS", connectionErrorCodeType);
        hashMap.put("CLUSTER_NOT_FOUND", connectionErrorCodeType2);
        hashMap.put("NETWORK_ERRORS", connectionErrorCodeType3);
        hashMap.put("INTERNAL_ERROR", connectionErrorCodeType4);
        hashMap.put("INSUFFICIENT_CLOUDHSM_HSMS", connectionErrorCodeType5);
        hashMap.put("USER_LOCKED_OUT", connectionErrorCodeType6);
        hashMap.put("USER_NOT_FOUND", connectionErrorCodeType7);
        hashMap.put("USER_LOGGED_IN", connectionErrorCodeType8);
        hashMap.put("SUBNET_NOT_FOUND", connectionErrorCodeType9);
        hashMap.put("INSUFFICIENT_FREE_ADDRESSES_IN_SUBNET", connectionErrorCodeType10);
        hashMap.put("XKS_PROXY_ACCESS_DENIED", connectionErrorCodeType11);
        hashMap.put("XKS_PROXY_NOT_REACHABLE", connectionErrorCodeType12);
        hashMap.put("XKS_VPC_ENDPOINT_SERVICE_NOT_FOUND", connectionErrorCodeType13);
        hashMap.put("XKS_PROXY_INVALID_RESPONSE", connectionErrorCodeType14);
        hashMap.put("XKS_PROXY_INVALID_CONFIGURATION", connectionErrorCodeType15);
        hashMap.put("XKS_VPC_ENDPOINT_SERVICE_INVALID_CONFIGURATION", connectionErrorCodeType16);
        hashMap.put("XKS_PROXY_TIMED_OUT", connectionErrorCodeType18);
        hashMap.put("XKS_PROXY_INVALID_TLS_CONFIGURATION", connectionErrorCodeType17);
    }

    private ConnectionErrorCodeType(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ConnectionErrorCodeType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ConnectionErrorCodeType> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
