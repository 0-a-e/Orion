package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "z", "", "p", "Landroidx/compose/ui/geometry/Offset;", "r", "invoke-d-4ec7I", "(FJF)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransformableState.kt */
final class TransformableStateKt$rememberTransformableState$1$1 extends Lambda implements Function3<Float, Offset, Float, Unit> {
    final /* synthetic */ State<Function3<Float, Offset, Float, Unit>> $lambdaState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformableStateKt$rememberTransformableState$1$1(State<? extends Function3<? super Float, ? super Offset, ? super Float, Unit>> state) {
        super(3);
        this.$lambdaState = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m490invoked4ec7I(((Number) obj).floatValue(), ((Offset) obj2).m3572unboximpl(), ((Number) obj3).floatValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final void m490invoked4ec7I(float f, long j, float f2) {
        this.$lambdaState.getValue().invoke(Float.valueOf(f), Offset.m3551boximpl(j), Float.valueOf(f2));
    }
}
