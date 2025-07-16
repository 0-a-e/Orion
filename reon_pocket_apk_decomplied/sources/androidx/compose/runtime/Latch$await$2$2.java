package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Latch.kt */
final class Latch$await$2$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellableContinuation<Unit> $co;
    final /* synthetic */ Latch this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Latch$await$2$2(Latch latch, CancellableContinuation<? super Unit> cancellableContinuation) {
        super(1);
        this.this$0 = latch;
        this.$co = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Object access$getLock$p = this.this$0.lock;
        Latch latch = this.this$0;
        CancellableContinuation<Unit> cancellableContinuation = this.$co;
        synchronized (access$getLock$p) {
            latch.awaiters.remove(cancellableContinuation);
            Unit unit = Unit.INSTANCE;
        }
    }
}
