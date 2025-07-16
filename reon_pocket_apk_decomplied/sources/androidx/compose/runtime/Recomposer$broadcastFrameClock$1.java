package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.ExceptionsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$broadcastFrameClock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$broadcastFrameClock$1(Recomposer recomposer) {
        super(0);
        this.this$0 = recomposer;
    }

    public final void invoke() {
        CancellableContinuation access$deriveStateLocked;
        Object access$getStateLock$p = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        synchronized (access$getStateLock$p) {
            access$deriveStateLocked = recomposer.deriveStateLocked();
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
            }
        }
        if (access$deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            access$deriveStateLocked.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
        }
    }
}
