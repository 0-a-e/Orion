package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import java.util.HashMap;
import java.util.Map;

public interface ConversionSchema {
    ItemConverter getConverter(Dependencies dependencies);

    public static class Dependencies {
        private final Map<Class<?>, Object> values = new HashMap();

        public <T> T get(Class<T> cls) {
            return this.values.get(cls);
        }

        public <T> Dependencies with(Class<T> cls, T t) {
            this.values.put(cls, t);
            return this;
        }

        public String toString() {
            return this.values.toString();
        }
    }
}
