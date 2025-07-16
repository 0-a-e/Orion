package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003J\u001d\u0010!\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u000e\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200J\u001e\u00101\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003J+\u00104\u001a\u00020\t*\u00020\t2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000306H\bø\u0001\u0000¢\u0006\u0004\b7\u00108R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010%R\u0018\u0010&\u001a\u00020\u0003*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/foundation/pager/MeasuredPage;", "Landroidx/compose/foundation/pager/PageInfo;", "index", "", "size", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "", "(IILjava/util/List;JLjava/lang/Object;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "isVertical", "getKey", "()Ljava/lang/Object;", "mainAxisLayoutSize", "<set-?>", "offset", "getOffset", "placeableOffsets", "", "getSize", "J", "mainAxisSize", "getMainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "applyScrollDelta", "", "delta", "getOffset-Bjo55l4", "(I)J", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "layoutWidth", "layoutHeight", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MeasuredPage.kt */
public final class MeasuredPage implements PageInfo {
    public static final int $stable = 8;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private int mainAxisLayoutSize;
    private int offset;
    private final int[] placeableOffsets;
    private final List<Placeable> placeables;
    private final boolean reverseLayout;
    private final int size;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ MeasuredPage(int i, int i2, List list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, list, j, obj, orientation, horizontal, vertical, layoutDirection2, z);
    }

    private MeasuredPage(int i, int i2, List<? extends Placeable> list, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z) {
        this.index = i;
        this.size = i2;
        this.placeables = list;
        this.visualOffset = j;
        this.key = obj;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection2;
        this.reverseLayout = z;
        this.isVertical = orientation == Orientation.Vertical;
        int size2 = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable placeable = (Placeable) list.get(i4);
            i3 = Math.max(i3, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.crossAxisSize = i3;
        this.placeableOffsets = new int[(this.placeables.size() * 2)];
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
    }

    public int getIndex() {
        return this.index;
    }

    public final int getSize() {
        return this.size;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public int getOffset() {
        return this.offset;
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
                    throw new IllegalArgumentException("null horizontalAlignment".toString());
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
                    throw new IllegalArgumentException("null verticalAlignment".toString());
                }
            }
            i += i4;
        }
    }

    public final void place(Placeable.PlacementScope placementScope) {
        int i;
        int i2;
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            int size2 = this.placeables.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Placeable placeable = this.placeables.get(i3);
                long r2 = m970getOffsetBjo55l4(i3);
                if (this.reverseLayout) {
                    if (this.isVertical) {
                        i = IntOffset.m6748getXimpl(r2);
                    } else {
                        i = (this.mainAxisLayoutSize - IntOffset.m6748getXimpl(r2)) - getMainAxisSize(placeable);
                    }
                    if (this.isVertical) {
                        i2 = (this.mainAxisLayoutSize - IntOffset.m6749getYimpl(r2)) - getMainAxisSize(placeable);
                    } else {
                        i2 = IntOffset.m6749getYimpl(r2);
                    }
                    r2 = IntOffsetKt.IntOffset(i, i2);
                }
                long j = this.visualOffset;
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r2) + IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(r2) + IntOffset.m6749getYimpl(j));
                if (this.isVertical) {
                    Placeable.PlacementScope.m5412placeWithLayeraW9wM$default(placementScope, placeable, IntOffset, 0.0f, (Function1) null, 6, (Object) null);
                } else {
                    Placeable.PlacementScope.m5411placeRelativeWithLayeraW9wM$default(placementScope, placeable, IntOffset, 0.0f, (Function1) null, 6, (Object) null);
                }
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
    }

    public final void applyScrollDelta(int i) {
        this.offset = getOffset() + i;
        int length = this.placeableOffsets.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolean z = this.isVertical;
            if ((z && i2 % 2 == 1) || (!z && i2 % 2 == 0)) {
                int[] iArr = this.placeableOffsets;
                iArr[i2] = iArr[i2] + i;
            }
        }
    }

    /* renamed from: getOffset-Bjo55l4  reason: not valid java name */
    private final long m970getOffsetBjo55l4(int i) {
        int[] iArr = this.placeableOffsets;
        int i2 = i * 2;
        return IntOffsetKt.IntOffset(iArr[i2], iArr[i2 + 1]);
    }

    private final int getMainAxisSize(Placeable placeable) {
        return this.isVertical ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: copy-4Tuh3kE  reason: not valid java name */
    private final long m969copy4Tuh3kE(long j, Function1<? super Integer, Integer> function1) {
        int r0 = this.isVertical ? IntOffset.m6748getXimpl(j) : function1.invoke(Integer.valueOf(IntOffset.m6748getXimpl(j))).intValue();
        boolean z = this.isVertical;
        int r3 = IntOffset.m6749getYimpl(j);
        if (z) {
            r3 = function1.invoke(Integer.valueOf(r3)).intValue();
        }
        return IntOffsetKt.IntOffset(r0, r3);
    }
}
