package androidx.compose.foundation.text.selection;

import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.text.selection.SelectionManager$getSelectionLayout-Wko1d7g$$inlined$compareBy$1  reason: invalid class name */
/* compiled from: Comparisons.kt */
public final class SelectionManager$getSelectionLayoutWko1d7g$$inlined$compareBy$1<T> implements Comparator {
    final /* synthetic */ Map $idToIndexMap$inlined;

    public SelectionManager$getSelectionLayoutWko1d7g$$inlined$compareBy$1(Map map) {
        this.$idToIndexMap$inlined = map;
    }

    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues((Comparable) this.$idToIndexMap$inlined.get(Long.valueOf(((Number) t).longValue())), (Comparable) this.$idToIndexMap$inlined.get(Long.valueOf(((Number) t2).longValue())));
    }
}
