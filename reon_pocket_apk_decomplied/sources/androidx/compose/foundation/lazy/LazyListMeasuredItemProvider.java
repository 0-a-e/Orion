package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "(JZLandroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "childConstraints", "getChildConstraints-msEJaDk", "()J", "J", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "index", "", "key", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "getAndMeasure", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasuredItemProvider.kt */
public abstract class LazyListMeasuredItemProvider {
    public static final int $stable = 0;
    private final long childConstraints;
    private final LazyListItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    public /* synthetic */ LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, lazyListItemProvider, lazyLayoutMeasureScope);
    }

    public abstract LazyListMeasuredItem createItem(int i, Object obj, Object obj2, List<? extends Placeable> list);

    private LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope) {
        this.itemProvider = lazyListItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.childConstraints = ConstraintsKt.Constraints$default(0, z ? Constraints.m6526getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, !z ? Constraints.m6525getMaxHeightimpl(j) : Integer.MAX_VALUE, 5, (Object) null);
    }

    /* renamed from: getChildConstraints-msEJaDk  reason: not valid java name */
    public final long m815getChildConstraintsmsEJaDk() {
        return this.childConstraints;
    }

    public final LazyListMeasuredItem getAndMeasure(int i) {
        return createItem(i, this.itemProvider.getKey(i), this.itemProvider.getContentType(i), this.measureScope.m871measure0kLqBqw(i, this.childConstraints));
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
