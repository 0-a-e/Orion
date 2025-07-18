package androidx.compose.ui.modifier;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B=\u00126\u0010\u0002\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0002\b\rJ&\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00052\u0006\u0010\u0014\u001a\u0002H\u000fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016R \u0010\b\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/modifier/MultiLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "entries", "", "Lkotlin/Pair;", "Landroidx/compose/ui/modifier/ModifierLocal;", "", "([Lkotlin/Pair;)V", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "contains", "", "key", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "set", "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModifierLocalModifierNode.kt */
public final class MultiLocalMap extends ModifierLocalMap {
    public static final int $stable = 0;
    private final SnapshotStateMap<ModifierLocal<?>, Object> map;

    public MultiLocalMap(Pair<? extends ModifierLocal<?>, ? extends Object>... pairArr) {
        super((DefaultConstructorMarker) null);
        SnapshotStateMap<ModifierLocal<?>, Object> mutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
        this.map = mutableStateMapOf;
        mutableStateMapOf.putAll(MapsKt.toMap((Pair<? extends K, ? extends V>[]) pairArr));
    }

    public <T> void set$ui_release(ModifierLocal<T> modifierLocal, T t) {
        this.map.put(modifierLocal, t);
    }

    public <T> T get$ui_release(ModifierLocal<T> modifierLocal) {
        T t = this.map.get(modifierLocal);
        if (t == null) {
            return null;
        }
        return t;
    }

    public boolean contains$ui_release(ModifierLocal<?> modifierLocal) {
        return this.map.containsKey(modifierLocal);
    }
}
