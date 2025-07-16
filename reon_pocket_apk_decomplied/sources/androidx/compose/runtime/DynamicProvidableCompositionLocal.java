package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u00002\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0010¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/DynamicProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "Lkotlin/Function0;", "(Landroidx/compose/runtime/SnapshotMutationPolicy;Lkotlin/jvm/functions/Function0;)V", "updatedStateOf", "Landroidx/compose/runtime/State;", "value", "previous", "updatedStateOf$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/State;)Landroidx/compose/runtime/State;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CompositionLocal.kt */
public final class DynamicProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    public static final int $stable = 0;
    private final SnapshotMutationPolicy<T> policy;

    public DynamicProvidableCompositionLocal(SnapshotMutationPolicy<T> snapshotMutationPolicy, Function0<? extends T> function0) {
        super(function0);
        this.policy = snapshotMutationPolicy;
    }

    public State<T> updatedStateOf$runtime_release(T t, State<? extends T> state) {
        if (state == null || !(state instanceof MutableState)) {
            return SnapshotStateKt.mutableStateOf(t, this.policy);
        }
        ((MutableState) state).setValue(t);
        return state;
    }
}
