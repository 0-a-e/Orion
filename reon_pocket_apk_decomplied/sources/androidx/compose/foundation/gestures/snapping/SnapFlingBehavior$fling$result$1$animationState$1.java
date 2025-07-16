package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "delta", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehavior$fling$result$1$animationState$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ Function1<Float, Unit> $onRemainingScrollOffsetUpdate;
    final /* synthetic */ Ref.FloatRef $remainingScrollOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$fling$result$1$animationState$1(Ref.FloatRef floatRef, Function1<? super Float, Unit> function1) {
        super(1);
        this.$remainingScrollOffset = floatRef;
        this.$onRemainingScrollOffsetUpdate = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f) {
        this.$remainingScrollOffset.element -= f;
        this.$onRemainingScrollOffsetUpdate.invoke(Float.valueOf(this.$remainingScrollOffset.element));
    }
}
