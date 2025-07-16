package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotFlow.kt */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ MutableScatterSet<Object> $readSet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1(MutableScatterSet<Object> mutableScatterSet) {
        super(1);
        this.$readSet = mutableScatterSet;
    }

    public final void invoke(Object obj) {
        if (obj instanceof StateObjectImpl) {
            ReaderKind.Companion companion = ReaderKind.Companion;
            ((StateObjectImpl) obj).m3416recordReadInh_f27i8$runtime_release(ReaderKind.m3402constructorimpl(4));
        }
        this.$readSet.add(obj);
    }
}
