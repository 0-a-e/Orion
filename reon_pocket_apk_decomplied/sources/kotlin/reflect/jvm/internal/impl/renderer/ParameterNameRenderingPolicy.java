package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntriesKt;

/* compiled from: DescriptorRenderer.kt */
public enum ParameterNameRenderingPolicy {
    ALL,
    ONLY_NON_SYNTHESIZED,
    NONE;

    static {
        ParameterNameRenderingPolicy[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
