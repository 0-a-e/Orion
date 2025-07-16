package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/TransformOrigin;", "it", "Landroidx/compose/animation/core/AnimationVector2D;", "invoke-LIALnN8", "(Landroidx/compose/animation/core/AnimationVector2D;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$TransformOriginVectorConverter$2 extends Lambda implements Function1<AnimationVector2D, TransformOrigin> {
    public static final EnterExitTransitionKt$TransformOriginVectorConverter$2 INSTANCE = new EnterExitTransitionKt$TransformOriginVectorConverter$2();

    EnterExitTransitionKt$TransformOriginVectorConverter$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return TransformOrigin.m4256boximpl(m78invokeLIALnN8((AnimationVector2D) obj));
    }

    /* renamed from: invoke-LIALnN8  reason: not valid java name */
    public final long m78invokeLIALnN8(AnimationVector2D animationVector2D) {
        return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
    }
}
