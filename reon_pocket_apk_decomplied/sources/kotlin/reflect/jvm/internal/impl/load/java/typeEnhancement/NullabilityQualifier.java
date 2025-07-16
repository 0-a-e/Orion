package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.enums.EnumEntriesKt;

/* compiled from: typeQualifiers.kt */
public enum NullabilityQualifier {
    FORCE_FLEXIBILITY,
    NULLABLE,
    NOT_NULL;

    static {
        NullabilityQualifier[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
