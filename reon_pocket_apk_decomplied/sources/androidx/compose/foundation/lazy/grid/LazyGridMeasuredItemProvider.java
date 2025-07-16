package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H&J*\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "defaultMainAxisSpacing", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;I)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createItem", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "index", "key", "contentType", "crossAxisSize", "mainAxisSpacing", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "getAndMeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getAndMeasure-3p2s80s", "(IIJ)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredItemProvider.kt */
public abstract class LazyGridMeasuredItemProvider {
    public static final int $stable = 0;
    private final int defaultMainAxisSpacing;
    private final LazyGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    public abstract LazyGridMeasuredItem createItem(int i, Object obj, Object obj2, int i2, int i3, List<? extends Placeable> list);

    public LazyGridMeasuredItemProvider(LazyGridItemProvider lazyGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i) {
        this.itemProvider = lazyGridItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.defaultMainAxisSpacing = i;
    }

    /* renamed from: getAndMeasure-3p2s80s$default  reason: not valid java name */
    public static /* synthetic */ LazyGridMeasuredItem m847getAndMeasure3p2s80s$default(LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i, int i2, long j, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = lazyGridMeasuredItemProvider.defaultMainAxisSpacing;
            }
            return lazyGridMeasuredItemProvider.m848getAndMeasure3p2s80s(i, i2, j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-3p2s80s");
    }

    /* renamed from: getAndMeasure-3p2s80s  reason: not valid java name */
    public final LazyGridMeasuredItem m848getAndMeasure3p2s80s(int i, int i2, long j) {
        int r11;
        Object key = this.itemProvider.getKey(i);
        Object contentType = this.itemProvider.getContentType(i);
        List<Placeable> r7 = this.measureScope.m871measure0kLqBqw(i, j);
        if (Constraints.m6524getHasFixedWidthimpl(j)) {
            r11 = Constraints.m6528getMinWidthimpl(j);
        } else if (Constraints.m6523getHasFixedHeightimpl(j)) {
            r11 = Constraints.m6527getMinHeightimpl(j);
        } else {
            throw new IllegalArgumentException("does not have fixed height".toString());
        }
        return createItem(i, key, contentType, r11, i2, r7);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
