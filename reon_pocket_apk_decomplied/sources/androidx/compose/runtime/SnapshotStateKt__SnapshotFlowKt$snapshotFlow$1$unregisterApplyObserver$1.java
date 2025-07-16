package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "changed", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotFlow.kt */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ Channel<Set<Object>> $appliedChanges;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1(Channel<Set<Object>> channel) {
        super(2);
        this.$appliedChanges = channel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) (Set) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Set<? extends Object> set, Snapshot snapshot) {
        Iterable iterable = set;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (Object next : iterable) {
                if (next instanceof StateObjectImpl) {
                    ReaderKind.Companion companion = ReaderKind.Companion;
                    if (((StateObjectImpl) next).m3415isReadInh_f27i8$runtime_release(ReaderKind.m3402constructorimpl(4))) {
                    }
                }
                this.$appliedChanges.m8593trySendJP2dKIU(set);
                return;
            }
        }
    }
}
