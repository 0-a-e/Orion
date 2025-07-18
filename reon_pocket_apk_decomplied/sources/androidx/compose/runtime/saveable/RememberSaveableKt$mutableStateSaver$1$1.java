package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MutableState;", "", "T", "Landroidx/compose/runtime/saveable/SaverScope;", "state", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RememberSaveable.kt */
final class RememberSaveableKt$mutableStateSaver$1$1 extends Lambda implements Function2<SaverScope, MutableState<T>, MutableState<Object>> {
    final /* synthetic */ Saver<T, Object> $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RememberSaveableKt$mutableStateSaver$1$1(Saver<T, Object> saver) {
        super(2);
        this.$this_with = saver;
    }

    public final MutableState<Object> invoke(SaverScope saverScope, MutableState<T> mutableState) {
        if (mutableState instanceof SnapshotMutableState) {
            Object save = this.$this_with.save(saverScope, mutableState.getValue());
            if (save == null) {
                return null;
            }
            SnapshotMutationPolicy policy = ((SnapshotMutableState) mutableState).getPolicy();
            Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<kotlin.Any?>");
            return SnapshotStateKt.mutableStateOf(save, policy);
        }
        throw new IllegalArgumentException("If you use a custom MutableState implementation you have to write a custom Saver and pass it as a saver param to rememberSaveable()".toString());
    }
}
