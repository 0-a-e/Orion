package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeysMap {
    private final Map<String, String> keys = new HashMap();
    private int maxEntries;
    private int maxEntryLength;

    public KeysMap(int i, int i2) {
        this.maxEntries = i;
        this.maxEntryLength = i2;
    }

    public Map<String, String> getKeys() {
        return Collections.unmodifiableMap(this.keys);
    }

    public void setKey(String str, String str2) {
        setSyncKeys(new HashMap<String, String>(str, str2) {
            final /* synthetic */ String val$key;
            final /* synthetic */ String val$value;

            {
                this.val$key = r2;
                this.val$value = r3;
                put(KeysMap.this.sanitizeKey(r2), KeysMap.this.sanitizeAttribute(r3));
            }
        });
    }

    public void setKeys(Map<String, String> map) {
        setSyncKeys(map);
    }

    private synchronized void setSyncKeys(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String sanitizeKey = sanitizeKey((String) next.getKey());
            String sanitizeAttribute = next.getValue() == null ? "" : sanitizeAttribute((String) next.getValue());
            if (this.keys.containsKey(sanitizeKey)) {
                hashMap.put(sanitizeKey, sanitizeAttribute);
            } else {
                hashMap2.put(sanitizeKey, sanitizeAttribute);
            }
        }
        this.keys.putAll(hashMap);
        int size = this.keys.size() + hashMap2.size();
        int i = this.maxEntries;
        if (size > i) {
            int size2 = i - this.keys.size();
            Logger logger = Logger.getLogger();
            logger.v("Exceeded maximum number of custom attributes (" + this.maxEntries + ").");
            hashMap2.keySet().retainAll(new ArrayList(hashMap2.keySet()).subList(0, size2));
        }
        this.keys.putAll(hashMap2);
    }

    /* access modifiers changed from: private */
    public String sanitizeKey(String str) {
        if (str != null) {
            return sanitizeAttribute(str);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        int length = trim.length();
        int i = this.maxEntryLength;
        return length > i ? trim.substring(0, i) : trim;
    }
}
