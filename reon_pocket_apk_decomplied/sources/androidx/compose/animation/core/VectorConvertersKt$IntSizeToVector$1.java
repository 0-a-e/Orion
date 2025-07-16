package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationVector2D;", "it", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)Landroidx/compose/animation/core/AnimationVector2D;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorConverters.kt */
final class VectorConvertersKt$IntSizeToVector$1 extends Lambda implements Function1<IntSize, AnimationVector2D> {
    public static final VectorConvertersKt$IntSizeToVector$1 INSTANCE = new VectorConvertersKt$IntSizeToVector$1();

    VectorConvertersKt$IntSizeToVector$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m174invokeozmzZPI(((IntSize) obj).m6794unboximpl());
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final AnimationVector2D m174invokeozmzZPI(long j) {
        return new AnimationVector2D((float) IntSize.m6790getWidthimpl(j), (float) IntSize.m6789getHeightimpl(j));
    }
}
