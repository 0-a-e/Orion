package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.StateObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DerivedState.kt */
final class DerivedSnapshotState$currentRecord$result$1$1$result$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ IntRef $calculationLevelRef;
    final /* synthetic */ int $nestedCalculationLevel;
    final /* synthetic */ MutableObjectIntMap<StateObject> $newDependencies;
    final /* synthetic */ DerivedSnapshotState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DerivedSnapshotState$currentRecord$result$1$1$result$1(DerivedSnapshotState<T> derivedSnapshotState, IntRef intRef, MutableObjectIntMap<StateObject> mutableObjectIntMap, int i) {
        super(1);
        this.this$0 = derivedSnapshotState;
        this.$calculationLevelRef = intRef;
        this.$newDependencies = mutableObjectIntMap;
        this.$nestedCalculationLevel = i;
    }

    public final void invoke(Object obj) {
        if (obj == this.this$0) {
            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
        } else if (obj instanceof StateObject) {
            int element = this.$calculationLevelRef.getElement();
            MutableObjectIntMap<StateObject> mutableObjectIntMap = this.$newDependencies;
            mutableObjectIntMap.set(obj, Math.min(element - this.$nestedCalculationLevel, mutableObjectIntMap.getOrDefault(obj, Integer.MAX_VALUE)));
        }
    }
}
