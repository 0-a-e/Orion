package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "it", "", "invoke-_-orMbw", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridIntervalContent.kt */
final class LazyGridIntervalContent$Companion$DefaultSpan$1 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
    public static final LazyGridIntervalContent$Companion$DefaultSpan$1 INSTANCE = new LazyGridIntervalContent$Companion$DefaultSpan$1();

    LazyGridIntervalContent$Companion$DefaultSpan$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return GridItemSpan.m820boximpl(m835invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
    }

    /* renamed from: invoke-_-orMbw  reason: not valid java name */
    public final long m835invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
        return LazyGridSpanKt.GridItemSpan(1);
    }
}
