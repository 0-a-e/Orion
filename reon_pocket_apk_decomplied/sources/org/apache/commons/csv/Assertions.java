package org.apache.commons.csv;

final class Assertions {
    private Assertions() {
    }

    static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("Parameter '" + str + "' must not be null!");
        }
    }
}
