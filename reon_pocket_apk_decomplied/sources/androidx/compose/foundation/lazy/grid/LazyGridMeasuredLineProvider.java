package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ%\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\u0007H&¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0007J\u001b\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "", "isVertical", "", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "gridItemsCount", "", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "(ZLandroidx/compose/foundation/lazy/grid/LazyGridSlots;IILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "createLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "index", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "getAndMeasure", "lineIndex", "itemConstraints", "itemIndex", "itemConstraints-OenEA2s", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredLineProvider.kt */
public abstract class LazyGridMeasuredLineProvider {
    public static final int $stable = 8;
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public abstract LazyGridMeasuredLine createLine(int i, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i2);

    public LazyGridMeasuredLineProvider(boolean z, LazyGridSlots lazyGridSlots, int i, int i2, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        this.isVertical = z;
        this.slots = lazyGridSlots;
        this.gridItemsCount = i;
        this.spaceBetweenLines = i2;
        this.measuredItemProvider = lazyGridMeasuredItemProvider;
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
    }

    /* renamed from: childConstraints-JhjzzOo$foundation_release  reason: not valid java name */
    public final long m849childConstraintsJhjzzOo$foundation_release(int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = this.slots.getSizes()[i];
        } else {
            int i4 = (i2 + i) - 1;
            i3 = (this.slots.getPositions()[i4] + this.slots.getSizes()[i4]) - this.slots.getPositions()[i];
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i3, 0);
        if (this.isVertical) {
            return Constraints.Companion.m6536fixedWidthOenEA2s(coerceAtLeast);
        }
        return Constraints.Companion.m6535fixedHeightOenEA2s(coerceAtLeast);
    }

    /* renamed from: itemConstraints-OenEA2s  reason: not valid java name */
    public final long m850itemConstraintsOenEA2s(int i) {
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = this.spanLayoutProvider;
        return m849childConstraintsJhjzzOo$foundation_release(0, lazyGridSpanLayoutProvider.spanOf(i, lazyGridSpanLayoutProvider.getSlotsPerLine()));
    }

    public final LazyGridMeasuredLine getAndMeasure(int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(i);
        int size = lineConfiguration.getSpans().size();
        int i2 = (size == 0 || lineConfiguration.getFirstItemIndex() + size == this.gridItemsCount) ? 0 : this.spaceBetweenLines;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = new LazyGridMeasuredItem[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            int r6 = GridItemSpan.m824getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i4).m827unboximpl());
            LazyGridMeasuredItem r7 = this.measuredItemProvider.m848getAndMeasure3p2s80s(lineConfiguration.getFirstItemIndex() + i4, i2, m849childConstraintsJhjzzOo$foundation_release(i3, r6));
            i3 += r6;
            Unit unit = Unit.INSTANCE;
            lazyGridMeasuredItemArr[i4] = r7;
        }
        return createLine(i, lazyGridMeasuredItemArr, lineConfiguration.getSpans(), i2);
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.measuredItemProvider.getKeyIndexMap();
    }
}
