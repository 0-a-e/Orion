package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotState.kt */
final class SnapshotMutableStateImpl$component2$1 extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ SnapshotMutableStateImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotMutableStateImpl$component2$1(SnapshotMutableStateImpl<T> snapshotMutableStateImpl) {
        super(1);
        this.this$0 = snapshotMutableStateImpl;
    }

    public final void invoke(T t) {
        this.this$0.setValue(t);
    }
}
