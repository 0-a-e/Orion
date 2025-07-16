package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
final class SnapshotKt$mergedWriteObserver$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Object, Unit> $parentObserver;
    final /* synthetic */ Function1<Object, Unit> $writeObserver;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotKt$mergedWriteObserver$1(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(1);
        this.$writeObserver = function1;
        this.$parentObserver = function12;
    }

    public final void invoke(Object obj) {
        this.$writeObserver.invoke(obj);
        this.$parentObserver.invoke(obj);
    }
}
