package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.enums.EnumEntriesKt;

/* compiled from: DeprecationInfo.kt */
public enum DeprecationLevelValue {
    WARNING,
    ERROR,
    HIDDEN;

    static {
        DeprecationLevelValue[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
