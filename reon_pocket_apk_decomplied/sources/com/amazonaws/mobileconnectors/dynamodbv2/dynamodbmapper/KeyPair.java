package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

public class KeyPair {
    private Object hashKey;
    private Object rangeKey;

    public KeyPair withHashKey(Object obj) {
        this.hashKey = obj;
        return this;
    }

    public KeyPair withRangeKey(Object obj) {
        this.rangeKey = obj;
        return this;
    }

    public void setHashKey(Object obj) {
        this.hashKey = obj;
    }

    public void setRangeKey(Object obj) {
        this.rangeKey = obj;
    }

    public Object getHashKey() {
        return this.hashKey;
    }

    public Object getRangeKey() {
        return this.rangeKey;
    }
}
