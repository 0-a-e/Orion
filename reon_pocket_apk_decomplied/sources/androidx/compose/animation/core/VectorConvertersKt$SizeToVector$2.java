package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Size;", "it", "Landroidx/compose/animation/core/AnimationVector2D;", "invoke-7Ah8Wj8", "(Landroidx/compose/animation/core/AnimationVector2D;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorConverters.kt */
final class VectorConvertersKt$SizeToVector$2 extends Lambda implements Function1<AnimationVector2D, Size> {
    public static final VectorConvertersKt$SizeToVector$2 INSTANCE = new VectorConvertersKt$SizeToVector$2();

    VectorConvertersKt$SizeToVector$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Size.m3619boximpl(m179invoke7Ah8Wj8((AnimationVector2D) obj));
    }

    /* renamed from: invoke-7Ah8Wj8  reason: not valid java name */
    public final long m179invoke7Ah8Wj8(AnimationVector2D animationVector2D) {
        return SizeKt.Size(animationVector2D.getV1(), animationVector2D.getV2());
    }
}
