package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "it", "Landroidx/compose/animation/core/AnimationVector2D;", "invoke-Bjo55l4", "(Landroidx/compose/animation/core/AnimationVector2D;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorConverters.kt */
final class VectorConvertersKt$IntOffsetToVector$2 extends Lambda implements Function1<AnimationVector2D, IntOffset> {
    public static final VectorConvertersKt$IntOffsetToVector$2 INSTANCE = new VectorConvertersKt$IntOffsetToVector$2();

    VectorConvertersKt$IntOffsetToVector$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m6739boximpl(m173invokeBjo55l4((AnimationVector2D) obj));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m173invokeBjo55l4(AnimationVector2D animationVector2D) {
        return IntOffsetKt.IntOffset(MathKt.roundToInt(animationVector2D.getV1()), MathKt.roundToInt(animationVector2D.getV2()));
    }
}
