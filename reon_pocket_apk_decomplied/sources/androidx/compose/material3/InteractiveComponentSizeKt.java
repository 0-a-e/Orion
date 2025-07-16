package androidx.compose.material3;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\n\u001a\u00020\r*\u00020\rH\u0007\"\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u000e"}, d2 = {"LocalMinimumInteractiveComponentEnforcement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalMinimumInteractiveComponentEnforcement$annotations", "()V", "getLocalMinimumInteractiveComponentEnforcement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalMinimumTouchTargetEnforcement", "getLocalMinimumTouchTargetEnforcement$annotations", "getLocalMinimumTouchTargetEnforcement", "minimumInteractiveComponentSize", "Landroidx/compose/ui/unit/DpSize;", "J", "Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InteractiveComponentSize.kt */
public final class InteractiveComponentSizeKt {
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumInteractiveComponentEnforcement;
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumTouchTargetEnforcement;
    /* access modifiers changed from: private */
    public static final long minimumInteractiveComponentSize;

    public static /* synthetic */ void getLocalMinimumInteractiveComponentEnforcement$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use LocalMinimumInteractiveComponentEnforcement instead.", replaceWith = @ReplaceWith(expression = "LocalMinimumInteractiveComponentEnforcement", imports = {}))
    public static /* synthetic */ void getLocalMinimumTouchTargetEnforcement$annotations() {
    }

    public static final Modifier minimumInteractiveComponentSize(Modifier modifier) {
        return modifier.then(MinimumInteractiveModifier.INSTANCE);
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumInteractiveComponentEnforcement() {
        return LocalMinimumInteractiveComponentEnforcement;
    }

    static {
        ProvidableCompositionLocal<Boolean> staticCompositionLocalOf = CompositionLocalKt.staticCompositionLocalOf(InteractiveComponentSizeKt$LocalMinimumInteractiveComponentEnforcement$1.INSTANCE);
        LocalMinimumInteractiveComponentEnforcement = staticCompositionLocalOf;
        LocalMinimumTouchTargetEnforcement = staticCompositionLocalOf;
        float f = (float) 48;
        minimumInteractiveComponentSize = DpKt.m6636DpSizeYgX7TsA(Dp.m6614constructorimpl(f), Dp.m6614constructorimpl(f));
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumTouchTargetEnforcement() {
        return LocalMinimumTouchTargetEnforcement;
    }
}
