package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/graphics/TransformOrigin;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$1 extends Lambda implements Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<TransformOrigin>> {
    public static final EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$1 INSTANCE = new EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$1();

    EnterExitTransitionKt$createGraphicsLayerBlock$1$transformOrigin$1() {
        super(1);
    }

    public final FiniteAnimationSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment) {
        return AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
    }
}
