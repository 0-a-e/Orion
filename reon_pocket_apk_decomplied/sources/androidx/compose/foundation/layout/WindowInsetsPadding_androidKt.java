package androidx.compose.foundation.layout;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001aC\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0019\b\b\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u00122\u0019\b\u0004\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0002\b\u0012H\b¨\u0006\u0016"}, d2 = {"captionBarPadding", "Landroidx/compose/ui/Modifier;", "displayCutoutPadding", "imePadding", "mandatorySystemGesturesPadding", "navigationBarsPadding", "safeContentPadding", "safeDrawingPadding", "safeGesturesPadding", "statusBarsPadding", "systemBarsPadding", "systemGesturesPadding", "waterfallPadding", "windowInsetsPadding", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "insetsCalculation", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.android.kt */
public final class WindowInsetsPadding_androidKt {
    private static final Modifier windowInsetsPadding(Modifier modifier, Function1<? super InspectorInfo, Unit> function1, Function1<? super WindowInsetsHolder, ? extends WindowInsets> function12) {
        return ComposedModifierKt.composed(modifier, function1, new WindowInsetsPadding_androidKt$windowInsetsPadding$1(function12));
    }

    public static final Modifier safeDrawingPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier safeGesturesPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier safeContentPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeContentPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeContentPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier systemBarsPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier displayCutoutPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier statusBarsPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier imePadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$imePadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$imePadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier navigationBarsPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier captionBarPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$captionBarPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$captionBarPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier waterfallPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$waterfallPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$waterfallPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier systemGesturesPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    public static final Modifier mandatorySystemGesturesPadding(Modifier modifier) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$windowInsetsPadding$1());
    }
}
