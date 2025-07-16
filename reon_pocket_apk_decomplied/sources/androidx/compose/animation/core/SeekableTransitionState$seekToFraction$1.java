package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "S", "it", "invoke", "(Lkotlin/Unit;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class SeekableTransitionState$seekToFraction$1 extends Lambda implements Function1<Unit, Unit> {
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$seekToFraction$1(SeekableTransitionState<S> seekableTransitionState) {
        super(1);
        this.this$0 = seekableTransitionState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Unit) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        this.this$0.seekToFraction();
    }
}
