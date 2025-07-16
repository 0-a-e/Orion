package androidx.compose.foundation.layout;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a/\u0010\n\u001a\u00020\u0006*\u00020\u00062!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fH\u0007\u001a\u0014\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"ModifierLocalConsumedWindowInsets", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/layout/WindowInsets;", "getModifierLocalConsumedWindowInsets", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "consumeWindowInsets", "Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "insets", "onConsumedWindowInsetsChanged", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "consumedWindowInsets", "", "windowInsetsPadding", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.kt */
public final class WindowInsetsPaddingKt {
    private static final ProvidableModifierLocal<WindowInsets> ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf(WindowInsetsPaddingKt$ModifierLocalConsumedWindowInsets$1.INSTANCE);

    public static final ProvidableModifierLocal<WindowInsets> getModifierLocalConsumedWindowInsets() {
        return ModifierLocalConsumedWindowInsets;
    }

    public static final Modifier windowInsetsPadding(Modifier modifier, WindowInsets windowInsets) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPaddingKt$windowInsetsPadding$2(windowInsets));
    }

    public static final Modifier consumeWindowInsets(Modifier modifier, WindowInsets windowInsets) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPaddingKt$consumeWindowInsets$2(windowInsets));
    }

    public static final Modifier consumeWindowInsets(Modifier modifier, PaddingValues paddingValues) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumeWindowInsets$$inlined$debugInspectorInfo$2(paddingValues) : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPaddingKt$consumeWindowInsets$4(paddingValues));
    }

    public static final Modifier onConsumedWindowInsetsChanged(Modifier modifier, Function1<? super WindowInsets, Unit> function1) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPaddingKt$onConsumedWindowInsetsChanged$2(function1));
    }
}
