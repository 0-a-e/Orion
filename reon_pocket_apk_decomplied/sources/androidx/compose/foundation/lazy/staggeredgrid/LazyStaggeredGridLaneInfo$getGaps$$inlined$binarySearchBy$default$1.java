package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "K", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Integer;", "kotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Collections.kt */
public final class LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1 extends Lambda implements Function1<LazyStaggeredGridLaneInfo.SpannedItem, Integer> {
    final /* synthetic */ Comparable $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1(Comparable comparable) {
        super(1);
        this.$key = comparable;
    }

    public final Integer invoke(LazyStaggeredGridLaneInfo.SpannedItem spannedItem) {
        return Integer.valueOf(ComparisonsKt.compareValues(Integer.valueOf(spannedItem.getIndex()), this.$key));
    }
}
