package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.enums.EnumEntriesKt;

/* compiled from: LookupTracker.kt */
public enum ScopeKind {
    PACKAGE,
    CLASSIFIER;

    static {
        ScopeKind[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
