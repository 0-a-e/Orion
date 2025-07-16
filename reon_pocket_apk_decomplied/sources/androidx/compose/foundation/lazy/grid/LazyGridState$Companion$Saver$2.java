package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "it", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridState.kt */
final class LazyGridState$Companion$Saver$2 extends Lambda implements Function1<List<? extends Integer>, LazyGridState> {
    public static final LazyGridState$Companion$Saver$2 INSTANCE = new LazyGridState$Companion$Saver$2();

    LazyGridState$Companion$Saver$2() {
        super(1);
    }

    public final LazyGridState invoke(List<Integer> list) {
        return new LazyGridState(list.get(0).intValue(), list.get(1).intValue());
    }
}
