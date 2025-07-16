package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/unit/Constraints;", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridState.kt */
final class LazyGridState$prefetchInfoRetriever$2 extends Lambda implements Function1<Integer, List<? extends Pair<? extends Integer, ? extends Constraints>>> {
    public static final LazyGridState$prefetchInfoRetriever$2 INSTANCE = new LazyGridState$prefetchInfoRetriever$2();

    LazyGridState$prefetchInfoRetriever$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final List<Pair<Integer, Constraints>> invoke(int i) {
        return CollectionsKt.emptyList();
    }
}
