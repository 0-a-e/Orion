package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntriesKt;

/* compiled from: DescriptorRenderer.kt */
public enum OverrideRenderingPolicy {
    RENDER_OVERRIDE,
    RENDER_OPEN,
    RENDER_OPEN_OVERRIDE;

    static {
        OverrideRenderingPolicy[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
