package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.enums.EnumEntriesKt;

/* compiled from: JavaTypeFlexibility.kt */
public enum JavaTypeFlexibility {
    INFLEXIBLE,
    FLEXIBLE_UPPER_BOUND,
    FLEXIBLE_LOWER_BOUND;

    static {
        JavaTypeFlexibility[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
