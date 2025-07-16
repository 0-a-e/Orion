package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotLongState.kt */
final class SnapshotMutableLongStateImpl$component2$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ SnapshotMutableLongStateImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotMutableLongStateImpl$component2$1(SnapshotMutableLongStateImpl snapshotMutableLongStateImpl) {
        super(1);
        this.this$0 = snapshotMutableLongStateImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        this.this$0.setLongValue(j);
    }
}
