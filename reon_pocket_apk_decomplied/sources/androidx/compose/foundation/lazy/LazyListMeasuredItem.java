package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0016\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\bJ\u001b\u0010,\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010C\u001a\u00020=2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\bJ\u001e\u0010G\u001a\u00020=2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003J+\u0010J\u001a\u00020\u0014*\u00020\u00142\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030LH\bø\u0001\u0000¢\u0006\u0004\bM\u0010NR\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010!R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010!\"\u0004\b(\u0010)R\u001e\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u001fR\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u00103\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u000e\u0010\u0012\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u0014X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105R\u0018\u00106\u001a\u00020\u0003*\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u00109\u001a\u00020\u0003*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006O"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "contentType", "animator", "Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIIJLjava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/LazyListItemAnimator;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentType", "()Ljava/lang/Object;", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "mainAxisLayoutSize", "maxMainAxisOffset", "minMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "placeablesCount", "getPlaceablesCount", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", "mainAxis", "getMainAxis--gyyYBs", "(J)I", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "updateAnimations", "getOffset-Bjo55l4", "(I)J", "getParentData", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "isLookingAhead", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasuredItem.kt */
public final class LazyListMeasuredItem implements LazyListItemInfo {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyListItemAnimator animator;
    private final int beforeContentPadding;
    private final Object contentType;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyListMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyListItemAnimator lazyListItemAnimator, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection2, z2, i2, i3, i4, j, obj, obj2, lazyListItemAnimator);
    }

    private LazyListMeasuredItem(int i, List<? extends Placeable> list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, int i4, long j, Object obj, Object obj2, LazyListItemAnimator lazyListItemAnimator) {
        this.index = i;
        this.placeables = list;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection2;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        this.contentType = obj2;
        this.animator = lazyListItemAnimator;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size2 = list.size();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size2; i7++) {
            Placeable placeable = (Placeable) list.get(i7);
            i5 += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            i6 = Math.max(i6, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = i5;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(getSize() + this.spacing, 0);
        this.crossAxisSize = i6;
        this.placeableOffsets = new int[(this.placeables.size() * 2)];
    }

    public int getIndex() {
        return this.index;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getContentType() {
        return this.contentType;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
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

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final Object getParentData(int i) {
        return this.placeables.get(i).getParentData();
    }

    public final void position(int i, int i2, int i3) {
        int i4;
        this.offset = i;
        this.mainAxisLayoutSize = this.isVertical ? i3 : i2;
        List<Placeable> list = this.placeables;
        int size2 = list.size();
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeable = list.get(i5);
            int i6 = i5 * 2;
            if (this.isVertical) {
                int[] iArr = this.placeableOffsets;
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal != null) {
                    iArr[i6] = horizontal.align(placeable.getWidth(), i2, this.layoutDirection);
                    this.placeableOffsets[i6 + 1] = i;
                    i4 = placeable.getHeight();
                } else {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true".toString());
                }
            } else {
                int[] iArr2 = this.placeableOffsets;
                iArr2[i6] = i;
                int i7 = i6 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical != null) {
                    iArr2[i7] = vertical.align(placeable.getHeight(), i3);
                    i4 = placeable.getWidth();
                } else {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false".toString());
                }
            }
            i += i4;
        }
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = this.mainAxisLayoutSize + this.afterContentPadding;
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    public final long m814getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    public final void applyScrollDelta(int i, boolean z) {
        if (!this.nonScrollableItem) {
            this.offset = getOffset() + i;
            int length = this.placeableOffsets.length;
            for (int i2 = 0; i2 < length; i2++) {
                boolean z2 = this.isVertical;
                if ((z2 && i2 % 2 == 1) || (!z2 && i2 % 2 == 0)) {
                    int[] iArr = this.placeableOffsets;
                    iArr[i2] = iArr[i2] + i;
                }
            }
            if (z) {
                int placeablesCount = getPlaceablesCount();
                for (int i3 = 0; i3 < placeablesCount; i3++) {
                    LazyLayoutAnimation animation = this.animator.getAnimation(getKey(), i3);
                    if (animation != null) {
                        long r2 = animation.m858getRawOffsetnOccac();
                        int r4 = this.isVertical ? IntOffset.m6748getXimpl(r2) : Integer.valueOf(IntOffset.m6748getXimpl(r2) + i).intValue();
                        boolean z3 = this.isVertical;
                        int r22 = IntOffset.m6749getYimpl(r2);
                        if (z3) {
                            r22 += i;
                        }
                        animation.m860setRawOffsetgyyYBs(IntOffsetKt.IntOffset(r4, r22));
                    }
                }
            }
        }
    }

    public final void place(Placeable.PlacementScope placementScope, boolean z) {
        Function1<GraphicsLayerScope, Unit> function1;
        int i;
        int i2;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int placeablesCount = getPlaceablesCount();
            for (int i3 = 0; i3 < placeablesCount; i3++) {
                Placeable placeable = this.placeables.get(i3);
                int mainAxisSize = this.minMainAxisOffset - getMainAxisSize(placeable);
                int i4 = this.maxMainAxisOffset;
                long r5 = m814getOffsetBjo55l4(i3);
                LazyLayoutAnimation animation = this.animator.getAnimation(getKey(), i3);
                if (animation != null) {
                    if (z) {
                        animation.m859setLookaheadOffsetgyyYBs(r5);
                    } else {
                        if (!IntOffset.m6747equalsimpl0(animation.m856getLookaheadOffsetnOccac(), LazyLayoutAnimation.Companion.m861getNotInitializednOccac())) {
                            r5 = animation.m856getLookaheadOffsetnOccac();
                        }
                        long r8 = animation.m857getPlacementDeltanOccac();
                        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r5) + IntOffset.m6748getXimpl(r8), IntOffset.m6749getYimpl(r5) + IntOffset.m6749getYimpl(r8));
                        if ((m813getMainAxisgyyYBs(r5) <= mainAxisSize && m813getMainAxisgyyYBs(IntOffset) <= mainAxisSize) || (m813getMainAxisgyyYBs(r5) >= i4 && m813getMainAxisgyyYBs(IntOffset) >= i4)) {
                            animation.cancelPlacementAnimation();
                        }
                        r5 = IntOffset;
                    }
                    function1 = animation.getLayerBlock();
                } else {
                    function1 = LazyLayoutAnimationKt.getDefaultLayerBlock();
                }
                Function1<GraphicsLayerScope, Unit> function12 = function1;
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
                    Placeable.PlacementScope.m5412placeWithLayeraW9wM$default(placementScope, placeable, IntOffset2, 0.0f, function12, 2, (Object) null);
                } else {
                    Placeable.PlacementScope.m5411placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffset2, 0.0f, function12, 2, (Object) null);
                }
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m813getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m6749getYimpl(j) : IntOffset.m6748getXimpl(j);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m812copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int r0 = this.isVertical ? IntOffset.m6748getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m6748getXimpl(j))).intValue();
        boolean z = this.isVertical;
        int r3 = IntOffset.m6749getYimpl(j);
        if (z) {
            r3 = function1.invoke(Integer.valueOf(r3)).intValue();
        }
        return IntOffsetKt.IntOffset(r0, r3);
    }
}
