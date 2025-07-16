package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntriesKt;

/* compiled from: TypeSystemContext.kt */
public enum CaptureStatus {
    FOR_SUBTYPING,
    FOR_INCORPORATION,
    FROM_EXPRESSION;

    static {
        CaptureStatus[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
