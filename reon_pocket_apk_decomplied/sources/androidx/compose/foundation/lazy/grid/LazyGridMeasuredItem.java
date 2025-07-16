package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010B\u001a\u00020?2\u0006\u0010C\u001a\u00020DJ:\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003J+\u0010I\u001a\u00020\u0013*\u00020\u00132\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030KH\bø\u0001\u0000¢\u0006\u0004\bL\u0010MR\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\"R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u000e\u0010)\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010.R&\u0010/\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013@RX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u00103\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b4\u0010\u001bR\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001bR\u001c\u00107\u001a\u000208X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\b9\u00101R\u0016\u0010\u0012\u001a\u00020\u0013X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00102R\u0018\u0010:\u001a\u00020\u0003*\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0018\u0010%\u001a\u00020\u0003*\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010=\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "index", "", "key", "", "isVertical", "", "crossAxisSize", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "contentType", "animator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "column", "getColumn", "()I", "getContentType", "()Ljava/lang/Object;", "crossAxisOffset", "getCrossAxisOffset", "getCrossAxisSize", "getIndex", "()Z", "getKey", "mainAxisLayoutSize", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "offset", "getOffset-nOcc-ac", "()J", "J", "placeablesCount", "getPlaceablesCount", "row", "getRow", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "mainAxisOffset", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredItem.kt */
public final class LazyGridMeasuredItem implements LazyGridItemInfo {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyGridItemPlacementAnimator animator;
    private final int beforeContentPadding;
    private int column;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private int row;
    private final long size;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection2, int i4, int i5, List list, long j, Object obj2, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, z, i2, i3, z2, layoutDirection2, i4, i5, list, j, obj2, lazyGridItemPlacementAnimator);
    }

    private LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection2, int i4, int i5, List<? extends Placeable> list, long j, Object obj2, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        long j2;
        this.index = i;
        this.key = obj;
        this.isVertical = z;
        this.crossAxisSize = i2;
        this.reverseLayout = z2;
        this.layoutDirection = layoutDirection2;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.placeables = list;
        this.visualOffset = j;
        this.contentType = obj2;
        this.animator = lazyGridItemPlacementAnimator;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size2 = list.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size2; i7++) {
            Placeable placeable = (Placeable) list.get(i7);
            i6 = Math.max(i6, this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.mainAxisSize = i6;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(i3 + i6, 0);
        if (this.isVertical) {
            j2 = IntSizeKt.IntSize(this.crossAxisSize, i6);
        } else {
            j2 = IntSizeKt.IntSize(i6, this.crossAxisSize);
        }
        this.size = j2;
        this.offset = IntOffset.Companion.m6758getZeronOccac();
        this.row = -1;
        this.column = -1;
    }

    public int getIndex() {
        return this.index;
    }

    public Object getKey() {
        return this.key;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public Object getContentType() {
        return this.contentType;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m846getSizeYbymL2g() {
        return this.size;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m845getOffsetnOccac() {
        return this.offset;
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m6748getXimpl(m845getOffsetnOccac()) : IntOffset.m6749getYimpl(m845getOffsetnOccac());
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public final boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    public final void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    public static /* synthetic */ void position$default(LazyGridMeasuredItem lazyGridMeasuredItem, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        lazyGridMeasuredItem.position(i, i2, i3, i4, (i7 & 16) != 0 ? -1 : i5, (i7 & 32) != 0 ? -1 : i6);
    }

    public final void position(int i, int i2, int i3, int i4, int i5, int i6) {
        long j;
        boolean z = this.isVertical;
        this.mainAxisLayoutSize = z ? i4 : i3;
        if (!z) {
            i3 = i4;
        }
        if (z && this.layoutDirection == LayoutDirection.Rtl) {
            i2 = (i3 - i2) - this.crossAxisSize;
        }
        if (this.isVertical) {
            j = IntOffsetKt.IntOffset(i2, i);
        } else {
            j = IntOffsetKt.IntOffset(i, i2);
        }
        this.offset = j;
        this.row = i5;
        this.column = i6;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    public final void applyScrollDelta(int i) {
        if (!this.nonScrollableItem) {
            long r0 = m845getOffsetnOccac();
            int r2 = this.isVertical ? IntOffset.m6748getXimpl(r0) : IntOffset.m6748getXimpl(r0) + i;
            boolean z = this.isVertical;
            int r02 = IntOffset.m6749getYimpl(r0);
            if (z) {
                r02 += i;
            }
            this.offset = IntOffsetKt.IntOffset(r2, r02);
            int placeablesCount = getPlaceablesCount();
            for (int i2 = 0; i2 < placeablesCount; i2++) {
                LazyLayoutAnimation animation = this.animator.getAnimation(getKey(), i2);
                if (animation != null) {
                    long r3 = animation.m858getRawOffsetnOccac();
                    int r5 = this.isVertical ? IntOffset.m6748getXimpl(r3) : Integer.valueOf(IntOffset.m6748getXimpl(r3) + i).intValue();
                    boolean z2 = this.isVertical;
                    int r32 = IntOffset.m6749getYimpl(r3);
                    if (z2) {
                        r32 += i;
                    }
                    animation.m860setRawOffsetgyyYBs(IntOffsetKt.IntOffset(r5, r32));
                }
            }
        }
    }

    public final void place(Placeable.PlacementScope placementScope) {
        int i;
        int i2;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int placeablesCount = getPlaceablesCount();
            for (int i3 = 0; i3 < placeablesCount; i3++) {
                Placeable placeable = this.placeables.get(i3);
                int mainAxisSize2 = this.minMainAxisOffset - getMainAxisSize(placeable);
                int i4 = this.maxMainAxisOffset;
                long r5 = m845getOffsetnOccac();
                LazyLayoutAnimation animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                    long r8 = animation.m857getPlacementDeltanOccac();
                    long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r5) + IntOffset.m6748getXimpl(r8), IntOffset.m6749getYimpl(r5) + IntOffset.m6749getYimpl(r8));
                    if ((m844getMainAxisgyyYBs(r5) <= mainAxisSize2 && m844getMainAxisgyyYBs(IntOffset) <= mainAxisSize2) || (m844getMainAxisgyyYBs(r5) >= i4 && m844getMainAxisgyyYBs(IntOffset) >= i4)) {
                        animation.cancelPlacementAnimation();
                    }
                    r5 = IntOffset;
                }
                if (this.reverseLayout) {
                    if (this.isVertical) {
                        i = IntOffset.m6748getXimpl(r5);
                    } else {
                        i = (this.mainAxisLayoutSize - IntOffset.m6748getXimpl(r5)) - getMainAxisSize(placeable);
                    }
                    if (this.isVertical) {
                        i2 = (this.mainAxisLayoutSize - IntOffset.m6749getYimpl(r5)) - getMainAxisSize(placeable);
                    } else {
                        i2 = IntOffset.m6749getYimpl(r5);
                    }
                    r5 = IntOffsetKt.IntOffset(i, i2);
                }
                long j = this.visualOffset;
                long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r5) + IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(r5) + IntOffset.m6749getYimpl(j));
                if (this.isVertical) {
                    Placeable.PlacementScope.m5412placeWithLayeraW9wM$default(placementScope, placeable, IntOffset2, 0.0f, (Function1) null, 6, (Object) null);
                } else {
                    Placeable.PlacementScope.m5411placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffset2, 0.0f, (Function1) null, 6, (Object) null);
                }
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m844getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m6749getYimpl(j) : IntOffset.m6748getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m843copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int r0 = this.isVertical ? IntOffset.m6748getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m6748getXimpl(j))).intValue();
        boolean z = this.isVertical;
        int r3 = IntOffset.m6749getYimpl(j);
        if (z) {
            r3 = function1.invoke(Integer.valueOf(r3)).intValue();
        }
        return IntOffsetKt.IntOffset(r0, r3);
    }
}
