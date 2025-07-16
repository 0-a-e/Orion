package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum ReplicaStatus {
    CREATING("CREATING"),
    UPDATING("UPDATING"),
    DELETING("DELETING"),
    ACTIVE("ACTIVE");
    
    private static final Map<String, ReplicaStatus> enumMap = null;
    private String value;

    static {
        ReplicaStatus replicaStatus;
        ReplicaStatus replicaStatus2;
        ReplicaStatus replicaStatus3;
        ReplicaStatus replicaStatus4;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CREATING", replicaStatus);
        hashMap.put("UPDATING", replicaStatus2);
        hashMap.put("DELETING", replicaStatus3);
        hashMap.put("ACTIVE", replicaStatus4);
    }

    private ReplicaStatus(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ReplicaStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ReplicaStatus> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
