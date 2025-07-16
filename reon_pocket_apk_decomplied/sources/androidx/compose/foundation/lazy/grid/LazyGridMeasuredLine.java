package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0019\u001a\u00020\rJ)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "", "index", "", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "isVertical", "", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Landroidx/compose/foundation/lazy/grid/LazyGridSlots;Ljava/util/List;ZI)V", "getIndex", "()I", "getItems", "()[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "isEmpty", "position", "offset", "layoutWidth", "layoutHeight", "(III)[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredLine.kt */
public final class LazyGridMeasuredLine {
    public static final int $stable = 8;
    private final int index;
    private final boolean isVertical;
    private final LazyGridMeasuredItem[] items;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final LazyGridSlots slots;
    private final List<GridItemSpan> spans;

    public LazyGridMeasuredLine(int i, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, LazyGridSlots lazyGridSlots, List<GridItemSpan> list, boolean z, int i2) {
        this.index = i;
        this.items = lazyGridMeasuredItemArr;
        this.slots = lazyGridSlots;
        this.spans = list;
        this.isVertical = z;
        this.mainAxisSpacing = i2;
        int i3 = 0;
        for (LazyGridMeasuredItem mainAxisSize2 : lazyGridMeasuredItemArr) {
            i3 = Math.max(i3, mainAxisSize2.getMainAxisSize());
        }
        this.mainAxisSize = i3;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(i3 + this.mainAxisSpacing, 0);
    }

    public final int getIndex() {
        return this.index;
    }

    public final LazyGridMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final boolean isEmpty() {
        return this.items.length == 0;
    }

    public final LazyGridMeasuredItem[] position(int i, int i2, int i3) {
        int i4;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArr = this.items;
        int length = lazyGridMeasuredItemArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            LazyGridMeasuredItem lazyGridMeasuredItem = lazyGridMeasuredItemArr[i5];
            int i8 = i6 + 1;
            int r4 = GridItemSpan.m824getCurrentLineSpanimpl(this.spans.get(i6).m827unboximpl());
            int i9 = this.slots.getPositions()[i7];
            boolean z = this.isVertical;
            int i10 = z ? this.index : i7;
            if (z) {
                i4 = i7;
            } else {
                i4 = this.index;
            }
            lazyGridMeasuredItem.position(i, i9, i2, i3, i10, i4);
            Unit unit = Unit.INSTANCE;
            i7 += r4;
            i5++;
            i6 = i8;
        }
        return this.items;
    }
}
