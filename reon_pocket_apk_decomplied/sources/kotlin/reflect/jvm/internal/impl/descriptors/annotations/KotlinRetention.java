package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.enums.EnumEntriesKt;

/* compiled from: KotlinRetention.kt */
public enum KotlinRetention {
    RUNTIME,
    BINARY,
    SOURCE;

    static {
        KotlinRetention[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
