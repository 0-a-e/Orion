package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntriesKt;

/* compiled from: TypeSystemContext.kt */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");
    
    private final String presentation;

    private TypeVariance(String str) {
        this.presentation = str;
    }

    static {
        TypeVariance[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }

    public String toString() {
        return this.presentation;
    }
}
