package com.amazonaws.auth;

public enum SignatureVersion {
    V1("1"),
    V2("2");
    
    private String value;

    private SignatureVersion(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
