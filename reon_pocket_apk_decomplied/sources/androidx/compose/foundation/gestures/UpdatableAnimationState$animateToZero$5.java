package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UpdatableAnimationState.kt */
final class UpdatableAnimationState$animateToZero$5 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function1<Float, Unit> $beforeFrame;
    final /* synthetic */ UpdatableAnimationState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdatableAnimationState$animateToZero$5(UpdatableAnimationState updatableAnimationState, Function1<? super Float, Unit> function1) {
        super(1);
        this.this$0 = updatableAnimationState;
        this.$beforeFrame = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        float value = this.this$0.getValue();
        this.this$0.setValue(0.0f);
        this.$beforeFrame.invoke(Float.valueOf(value));
    }
}
