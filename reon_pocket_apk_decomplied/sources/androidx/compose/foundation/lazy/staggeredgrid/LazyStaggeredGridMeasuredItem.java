package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u000e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010B\u001a\u00020?2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\u001e\u0010G\u001a\u00020?2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003J\b\u0010I\u001a\u00020JH\u0016J+\u0010K\u001a\u00020-*\u00020-2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030MH\bø\u0001\u0000¢\u0006\u0004\bN\u0010OR\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001c\"\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0014\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\u0018R\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u000e\u0010'\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001fR&\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020-@RX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b3\u0010\u0018R\u001c\u00104\u001a\u000205X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00101\u001a\u0004\b6\u00100R\u0011\u00107\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0018R\u0018\u0010:\u001a\u00020\u0003*\u00020-8BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0019\u0010%\u001a\u00020\u0003*\u00020\b8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010=\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisOffset", "getCrossAxisOffset", "()I", "crossAxisSize", "getCrossAxisSize", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "getLane", "mainAxisLayoutSize", "mainAxisOffset", "getMainAxisOffset", "mainAxisSize", "getMainAxisSize", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "<set-?>", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "()J", "J", "placeablesCount", "getPlaceablesCount", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "sizeWithSpacings", "getSizeWithSpacings", "getSpan", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "context", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "crossAxis", "toString", "", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyStaggeredGridItemPlacementAnimator animator;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible = true;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int sizeWithSpacings;
    private final int span;

    public LazyStaggeredGridMeasuredItem(int i, Object obj, List<? extends Placeable> list, boolean z, int i2, int i3, int i4, int i5, int i6, Object obj2, LazyStaggeredGridItemPlacementAnimator lazyStaggeredGridItemPlacementAnimator) {
        Comparable comparable;
        long j;
        int i7;
        this.index = i;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z;
        this.lane = i3;
        this.span = i4;
        this.beforeContentPadding = i5;
        this.afterContentPadding = i6;
        this.contentType = obj2;
        this.animator = lazyStaggeredGridItemPlacementAnimator;
        int i8 = 1;
        Comparable comparable2 = null;
        int i9 = 0;
        if (list.isEmpty()) {
            comparable = null;
        } else {
            Placeable placeable = (Placeable) list.get(0);
            if (z) {
                i7 = placeable.getHeight();
            } else {
                i7 = placeable.getWidth();
            }
            comparable = Integer.valueOf(i7);
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i10 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i10);
                    Comparable valueOf = Integer.valueOf(this.isVertical ? placeable2.getHeight() : placeable2.getWidth());
                    comparable = valueOf.compareTo(comparable) > 0 ? valueOf : comparable;
                    if (i10 == lastIndex) {
                        break;
                    }
                    i10++;
                }
            }
        }
        Integer num = (Integer) comparable;
        int intValue = num != null ? num.intValue() : 0;
        this.mainAxisSize = intValue;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(intValue + i2, 0);
        List<Placeable> list2 = this.placeables;
        if (!list2.isEmpty()) {
            Placeable placeable3 = list2.get(0);
            Comparable valueOf2 = Integer.valueOf(this.isVertical ? placeable3.getWidth() : placeable3.getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable placeable4 = list2.get(i8);
                    Comparable valueOf3 = Integer.valueOf(this.isVertical ? placeable4.getWidth() : placeable4.getHeight());
                    valueOf2 = valueOf3.compareTo(valueOf2) > 0 ? valueOf3 : valueOf2;
                    if (i8 == lastIndex2) {
                        break;
                    }
                    i8++;
                }
            }
            comparable2 = valueOf2;
        }
        Integer num2 = (Integer) comparable2;
        i9 = num2 != null ? num2.intValue() : i9;
        this.crossAxisSize = i9;
        this.mainAxisLayoutSize = -1;
        if (this.isVertical) {
            j = IntSizeKt.IntSize(i9, this.mainAxisSize);
        } else {
            j = IntSizeKt.IntSize(this.mainAxisSize, i9);
        }
        this.size = j;
        this.offset = IntOffset.Companion.m6758getZeronOccac();
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

    public int getLane() {
        return this.lane;
    }

    public final int getSpan() {
        return this.span;
    }

    public Object getContentType() {
        return this.contentType;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    public final void setNonScrollableItem(boolean z) {
        this.nonScrollableItem = z;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m947getSizeYbymL2g() {
        return this.size;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public long m946getOffsetnOccac() {
        return this.offset;
    }

    public final void position(int i, int i2, int i3) {
        long j;
        this.mainAxisLayoutSize = i3;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = i3 + this.afterContentPadding;
        if (this.isVertical) {
            j = IntOffsetKt.IntOffset(i2, i);
        } else {
            j = IntOffsetKt.IntOffset(i, i2);
        }
        this.offset = j;
    }

    public final int getMainAxisOffset() {
        return !this.isVertical ? IntOffset.m6748getXimpl(m946getOffsetnOccac()) : IntOffset.m6749getYimpl(m946getOffsetnOccac());
    }

    public final int getCrossAxisOffset() {
        return this.isVertical ? IntOffset.m6748getXimpl(m946getOffsetnOccac()) : IntOffset.m6749getYimpl(m946getOffsetnOccac());
    }

    public final void place(Placeable.PlacementScope placementScope, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int i;
        int i2;
        if (this.mainAxisLayoutSize != -1) {
            List<Placeable> list = this.placeables;
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Placeable placeable = list.get(i3);
                int height = this.minMainAxisOffset - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                int i4 = this.maxMainAxisOffset;
                long r6 = m946getOffsetnOccac();
                LazyLayoutAnimation animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                    long r9 = animation.m857getPlacementDeltanOccac();
                    long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r6) + IntOffset.m6748getXimpl(r9), IntOffset.m6749getYimpl(r6) + IntOffset.m6749getYimpl(r9));
                    if ((m945getMainAxisgyyYBs(r6) <= height && m945getMainAxisgyyYBs(IntOffset) <= height) || (m945getMainAxisgyyYBs(r6) >= i4 && m945getMainAxisgyyYBs(IntOffset) >= i4)) {
                        animation.cancelPlacementAnimation();
                    }
                    r6 = IntOffset;
                }
                if (lazyStaggeredGridMeasureContext.getReverseLayout()) {
                    if (this.isVertical) {
                        i = IntOffset.m6748getXimpl(r6);
                    } else {
                        i = (this.mainAxisLayoutSize - IntOffset.m6748getXimpl(r6)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                    }
                    if (this.isVertical) {
                        i2 = (this.mainAxisLayoutSize - IntOffset.m6749getYimpl(r6)) - (this.isVertical ? placeable.getHeight() : placeable.getWidth());
                    } else {
                        i2 = IntOffset.m6749getYimpl(r6);
                    }
                    r6 = IntOffsetKt.IntOffset(i, i2);
                }
                long r3 = lazyStaggeredGridMeasureContext.m932getContentOffsetnOccac();
                Placeable.PlacementScope.m5411placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r6) + IntOffset.m6748getXimpl(r3), IntOffset.m6749getYimpl(r6) + IntOffset.m6749getYimpl(r3)), 0.0f, (Function1) null, 6, (Object) null);
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    public final void applyScrollDelta(int i) {
        if (!this.nonScrollableItem) {
            long r0 = m946getOffsetnOccac();
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

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m945getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m6749getYimpl(j) : IntOffset.m6748getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m944copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int r0 = this.isVertical ? IntOffset.m6748getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m6748getXimpl(j))).intValue();
        boolean z = this.isVertical;
        int r3 = IntOffset.m6749getYimpl(j);
        if (z) {
            r3 = function1.invoke(Integer.valueOf(r3)).intValue();
        }
        return IntOffsetKt.IntOffset(r0, r3);
    }

    public String toString() {
        return super.toString();
    }
}
