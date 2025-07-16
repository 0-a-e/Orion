package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.enums.EnumEntriesKt;

/* compiled from: DeserializedContainerSource.kt */
public enum DeserializedContainerAbiStability {
    STABLE,
    FIR_UNSTABLE,
    IR_UNSTABLE;

    static {
        DeserializedContainerAbiStability[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
