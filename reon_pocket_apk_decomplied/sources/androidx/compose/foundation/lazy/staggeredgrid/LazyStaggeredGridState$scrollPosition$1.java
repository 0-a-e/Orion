package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridState.kt */
/* synthetic */ class LazyStaggeredGridState$scrollPosition$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, int[]> {
    LazyStaggeredGridState$scrollPosition$1(Object obj) {
        super(2, obj, LazyStaggeredGridState.class, "fillNearestIndices", "fillNearestIndices(II)[I", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
    }

    public final int[] invoke(int i, int i2) {
        return ((LazyStaggeredGridState) this.receiver).fillNearestIndices(i, i2);
    }
}
