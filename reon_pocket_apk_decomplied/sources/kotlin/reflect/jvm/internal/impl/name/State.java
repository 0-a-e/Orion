package kotlin.reflect.jvm.internal.impl.name;

import kotlin.enums.EnumEntriesKt;

/* compiled from: FqNamesUtil.kt */
enum State {
    BEGINNING,
    MIDDLE,
    AFTER_DOT;

    static {
        State[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
