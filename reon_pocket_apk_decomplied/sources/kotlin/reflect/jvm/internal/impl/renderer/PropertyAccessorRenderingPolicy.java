package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntriesKt;

/* compiled from: DescriptorRenderer.kt */
public enum PropertyAccessorRenderingPolicy {
    PRETTY,
    DEBUG,
    NONE;

    static {
        PropertyAccessorRenderingPolicy[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
