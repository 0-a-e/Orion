package org.apache.commons.csv;

final class Token {
    private static final int INITIAL_TOKEN_LENGTH = 50;
    final StringBuilder content = new StringBuilder(50);
    boolean isReady;
    Type type = Type.INVALID;

    enum Type {
        INVALID,
        TOKEN,
        EOF,
        EORECORD,
        COMMENT
    }

    Token() {
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.content.setLength(0);
        this.type = Type.INVALID;
        this.isReady = false;
    }

    public String toString() {
        return this.type.name() + " [" + this.content.toString() + "]";
    }
}
