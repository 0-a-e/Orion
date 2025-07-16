package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(I)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridAnimateScrollScope.kt */
final class LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1 extends Lambda implements Function1<Integer, Integer> {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ List<LazyGridItemInfo> $visibleItems;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1(boolean z, List<? extends LazyGridItemInfo> list) {
        super(1);
        this.$isVertical = z;
        this.$visibleItems = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final Integer invoke(int i) {
        return Integer.valueOf(this.$isVertical ? this.$visibleItems.get(i).getRow() : this.$visibleItems.get(i).getColumn());
    }
}
