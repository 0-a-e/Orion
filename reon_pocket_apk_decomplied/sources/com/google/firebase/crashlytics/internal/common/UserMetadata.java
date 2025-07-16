package com.google.firebase.crashlytics.internal.common;

import java.util.Map;

public class UserMetadata {
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    static final int MAX_INTERNAL_KEY_SIZE = 8192;
    private final KeysMap customKeys = new KeysMap(64, 1024);
    private final KeysMap internalKeys = new KeysMap(64, 8192);
    private String userId = null;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = this.customKeys.sanitizeAttribute(str);
    }

    public Map<String, String> getCustomKeys() {
        return this.customKeys.getKeys();
    }

    public void setCustomKey(String str, String str2) {
        this.customKeys.setKey(str, str2);
    }

    public void setCustomKeys(Map<String, String> map) {
        this.customKeys.setKeys(map);
    }

    public Map<String, String> getInternalKeys() {
        return this.internalKeys.getKeys();
    }

    public void setInternalKey(String str, String str2) {
        this.internalKeys.setKey(str, str2);
    }
}
