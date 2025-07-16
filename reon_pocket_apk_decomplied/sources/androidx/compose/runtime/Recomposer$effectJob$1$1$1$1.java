package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "runnerJobCause", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class Recomposer$effectJob$1$1$1$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Throwable $throwable;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$effectJob$1$1$1$1(Recomposer recomposer, Throwable th) {
        super(1);
        this.this$0 = recomposer;
        this.$throwable = th;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Object access$getStateLock$p = this.this$0.stateLock;
        Recomposer recomposer = this.this$0;
        Throwable th2 = this.$throwable;
        synchronized (access$getStateLock$p) {
            if (th2 == null) {
                th2 = null;
            } else if (th != null) {
                if (!(!(th instanceof CancellationException))) {
                    th = null;
                }
                if (th != null) {
                    ExceptionsKt.addSuppressed(th2, th);
                }
            }
            recomposer.closeCause = th2;
            recomposer._state.setValue(Recomposer.State.ShutDown);
            Unit unit = Unit.INSTANCE;
        }
    }
}
