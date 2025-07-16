package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/ui/state/ToggleableState;", "invoke", "(Landroidx/compose/animation/core/Transition$Segment;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/FiniteAnimationSpec;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
final class CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 extends Lambda implements Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 INSTANCE = new CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1();

    CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<ToggleableState>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer, int i) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        composer.startReplaceableGroup(-1324481169);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1324481169, i, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
        }
        if (segment.getInitialState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap$default(0, 1, (Object) null);
        } else if (segment.getTargetState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap(100);
        } else {
            finiteAnimationSpec = AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
