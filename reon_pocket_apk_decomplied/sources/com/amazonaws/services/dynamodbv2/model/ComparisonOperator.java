package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

public enum ComparisonOperator {
    EQ("EQ"),
    NE("NE"),
    IN("IN"),
    LE("LE"),
    LT("LT"),
    GE("GE"),
    GT("GT"),
    BETWEEN("BETWEEN"),
    NOT_NULL("NOT_NULL"),
    NULL("NULL"),
    CONTAINS("CONTAINS"),
    NOT_CONTAINS("NOT_CONTAINS"),
    BEGINS_WITH("BEGINS_WITH");
    
    private static final Map<String, ComparisonOperator> enumMap = null;
    private String value;

    static {
        ComparisonOperator comparisonOperator;
        ComparisonOperator comparisonOperator2;
        ComparisonOperator comparisonOperator3;
        ComparisonOperator comparisonOperator4;
        ComparisonOperator comparisonOperator5;
        ComparisonOperator comparisonOperator6;
        ComparisonOperator comparisonOperator7;
        ComparisonOperator comparisonOperator8;
        ComparisonOperator comparisonOperator9;
        ComparisonOperator comparisonOperator10;
        ComparisonOperator comparisonOperator11;
        ComparisonOperator comparisonOperator12;
        ComparisonOperator comparisonOperator13;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("EQ", comparisonOperator);
        hashMap.put("NE", comparisonOperator2);
        hashMap.put("IN", comparisonOperator3);
        hashMap.put("LE", comparisonOperator4);
        hashMap.put("LT", comparisonOperator5);
        hashMap.put("GE", comparisonOperator6);
        hashMap.put("GT", comparisonOperator7);
        hashMap.put("BETWEEN", comparisonOperator8);
        hashMap.put("NOT_NULL", comparisonOperator9);
        hashMap.put("NULL", comparisonOperator10);
        hashMap.put("CONTAINS", comparisonOperator11);
        hashMap.put("NOT_CONTAINS", comparisonOperator12);
        hashMap.put("BEGINS_WITH", comparisonOperator13);
    }

    private ComparisonOperator(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    public static ComparisonOperator fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        Map<String, ComparisonOperator> map = enumMap;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
