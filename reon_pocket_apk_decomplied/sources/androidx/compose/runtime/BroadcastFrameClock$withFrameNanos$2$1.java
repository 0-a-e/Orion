package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BroadcastFrameClock.kt */
final class BroadcastFrameClock$withFrameNanos$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Ref.ObjectRef<BroadcastFrameClock.FrameAwaiter<R>> $awaiter;
    final /* synthetic */ BroadcastFrameClock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BroadcastFrameClock$withFrameNanos$2$1(BroadcastFrameClock broadcastFrameClock, Ref.ObjectRef<BroadcastFrameClock.FrameAwaiter<R>> objectRef) {
        super(1);
        this.this$0 = broadcastFrameClock;
        this.$awaiter = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        BroadcastFrameClock.FrameAwaiter frameAwaiter;
        Object access$getLock$p = this.this$0.lock;
        BroadcastFrameClock broadcastFrameClock = this.this$0;
        Ref.ObjectRef<BroadcastFrameClock.FrameAwaiter<R>> objectRef = this.$awaiter;
        synchronized (access$getLock$p) {
            List access$getAwaiters$p = broadcastFrameClock.awaiters;
            if (objectRef.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("awaiter");
                frameAwaiter = null;
            } else {
                frameAwaiter = (BroadcastFrameClock.FrameAwaiter) objectRef.element;
            }
            access$getAwaiters$p.remove(frameAwaiter);
            Unit unit = Unit.INSTANCE;
        }
    }
}
