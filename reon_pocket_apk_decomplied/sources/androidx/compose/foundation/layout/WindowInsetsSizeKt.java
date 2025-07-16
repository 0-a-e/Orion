package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"windowInsetsBottomHeight", "Landroidx/compose/ui/Modifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsetsEndWidth", "windowInsetsStartWidth", "windowInsetsTopHeight", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsSize.kt */
public final class WindowInsetsSizeKt {
    public static final Modifier windowInsetsStartWidth(Modifier modifier, WindowInsets windowInsets) {
        return modifier.then(new DerivedWidthModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsStartWidth$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), WindowInsetsSizeKt$windowInsetsStartWidth$2.INSTANCE));
    }

    public static final Modifier windowInsetsEndWidth(Modifier modifier, WindowInsets windowInsets) {
        return modifier.then(new DerivedWidthModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsEndWidth$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), WindowInsetsSizeKt$windowInsetsEndWidth$2.INSTANCE));
    }

    public static final Modifier windowInsetsTopHeight(Modifier modifier, WindowInsets windowInsets) {
        return modifier.then(new DerivedHeightModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), WindowInsetsSizeKt$windowInsetsTopHeight$2.INSTANCE));
    }

    public static final Modifier windowInsetsBottomHeight(Modifier modifier, WindowInsets windowInsets) {
        return modifier.then(new DerivedHeightModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), WindowInsetsSizeKt$windowInsetsBottomHeight$2.INSTANCE));
    }
}
