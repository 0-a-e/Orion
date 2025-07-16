package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "Landroidx/compose/animation/core/Transition$Segment;", "", "invoke", "(Landroidx/compose/animation/core/Transition$Segment;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/FiniteAnimationSpec;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$animateTooltip$2$alpha$2 extends Lambda implements Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TooltipKt$animateTooltip$2$alpha$2 INSTANCE = new TooltipKt$animateTooltip$2$alpha$2();

    TooltipKt$animateTooltip$2$alpha$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<Boolean>) (Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Boolean> segment, Composer composer, int i) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        composer.startReplaceableGroup(-281714272);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-281714272, i, -1, "androidx.compose.material3.animateTooltip.<anonymous>.<anonymous> (Tooltip.kt:676)");
        }
        if (segment.isTransitioningTo(false, true)) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        } else {
            finiteAnimationSpec = AnimationSpecKt.tween$default(75, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
