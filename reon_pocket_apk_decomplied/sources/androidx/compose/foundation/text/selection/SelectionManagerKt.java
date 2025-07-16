package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00012\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0001\u001a\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0000\u001a\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H 0\u0011\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0\u0011H\u0002\u001a\f\u0010!\u001a\u00020\u0001*\u00020\u0016H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"invertedInfiniteRect", "Landroidx/compose/ui/geometry/Rect;", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getMagnifierCenter", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getMagnifierCenter-JVtK1S4", "(Landroidx/compose/foundation/text/selection/SelectionManager;JLandroidx/compose/foundation/text/selection/Selection$AnchorInfo;)J", "getSelectedRegionRect", "selectableSubSelectionPairs", "", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/selection/Selectable;", "Landroidx/compose/foundation/text/selection/Selection;", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "merge", "lhs", "rhs", "containsInclusive", "", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "firstAndLast", "T", "visibleBounds", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManagerKt {
    /* access modifiers changed from: private */
    public static final Rect invertedInfiniteRect = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text.Handle[] r0 = androidx.compose.foundation.text.Handle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionStart     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionEnd     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.Cursor     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManagerKt.WhenMappings.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.merge(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text.selection.Selection merge(androidx.compose.foundation.text.selection.Selection r0, androidx.compose.foundation.text.selection.Selection r1) {
        /*
            if (r0 == 0) goto L_0x000a
            androidx.compose.foundation.text.selection.Selection r0 = r0.merge(r1)
            if (r0 != 0) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            r1 = r0
        L_0x000a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManagerKt.merge(androidx.compose.foundation.text.selection.Selection, androidx.compose.foundation.text.selection.Selection):androidx.compose.foundation.text.selection.Selection");
    }

    /* access modifiers changed from: private */
    public static final <T> List<T> firstAndLast(List<? extends T> list) {
        int size = list.size();
        if (size == 0 || size == 1) {
            return list;
        }
        return CollectionsKt.listOf(CollectionsKt.first(list), CollectionsKt.last(list));
    }

    public static final Rect getSelectedRegionRect(List<? extends Pair<? extends Selectable, Selection>> list, LayoutCoordinates layoutCoordinates) {
        int i;
        LayoutCoordinates layoutCoordinates2;
        int[] iArr;
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates;
        if (list.isEmpty()) {
            return invertedInfiniteRect;
        }
        Rect rect = invertedInfiniteRect;
        float component1 = rect.component1();
        float component2 = rect.component2();
        float component3 = rect.component3();
        float component4 = rect.component4();
        int size = list.size();
        char c = 0;
        int i2 = 0;
        while (i2 < size) {
            Pair pair = (Pair) list.get(i2);
            Selectable selectable = (Selectable) pair.component1();
            Selection selection = (Selection) pair.component2();
            int offset = selection.getStart().getOffset();
            int offset2 = selection.getEnd().getOffset();
            if (offset == offset2 || (layoutCoordinates2 = selectable.getLayoutCoordinates()) == null) {
                i = size;
            } else {
                int min = Math.min(offset, offset2);
                int max = Math.max(offset, offset2) - 1;
                if (min == max) {
                    iArr = new int[1];
                    iArr[c] = min;
                } else {
                    int[] iArr2 = new int[2];
                    iArr2[c] = min;
                    iArr2[1] = max;
                    iArr = iArr2;
                }
                Rect rect2 = invertedInfiniteRect;
                float component12 = rect2.component1();
                float component22 = rect2.component2();
                float component32 = rect2.component3();
                float component42 = rect2.component4();
                int length = iArr.length;
                i = size;
                int i3 = 0;
                while (i3 < length) {
                    int i4 = length;
                    Rect boundingBox = selectable.getBoundingBox(iArr[i3]);
                    component12 = Math.min(component12, boundingBox.getLeft());
                    component22 = Math.min(component22, boundingBox.getTop());
                    component32 = Math.max(component32, boundingBox.getRight());
                    component42 = Math.max(component42, boundingBox.getBottom());
                    i3++;
                    List<? extends Pair<? extends Selectable, Selection>> list2 = list;
                    length = i4;
                }
                long Offset = OffsetKt.Offset(component12, component22);
                long Offset2 = OffsetKt.Offset(component32, component42);
                long r5 = layoutCoordinates3.m5319localPositionOfR5De75A(layoutCoordinates2, Offset);
                long r8 = layoutCoordinates3.m5319localPositionOfR5De75A(layoutCoordinates2, Offset2);
                component1 = Math.min(component1, Offset.m3562getXimpl(r5));
                component2 = Math.min(component2, Offset.m3563getYimpl(r5));
                component3 = Math.max(component3, Offset.m3562getXimpl(r8));
                component4 = Math.max(component4, Offset.m3563getYimpl(r8));
            }
            i2++;
            size = i;
            c = 0;
        }
        return new Rect(component1, component2, component3, component4);
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c  reason: not valid java name */
    public static final long m1276calculateSelectionMagnifierCenterAndroidO0kMr_c(SelectionManager selectionManager, long j) {
        Selection selection = selectionManager.getSelection();
        if (selection == null) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = selectionManager.getDraggingHandle();
        int i = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i == -1) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        if (i == 1) {
            return m1278getMagnifierCenterJVtK1S4(selectionManager, j, selection.getStart());
        }
        if (i == 2) {
            return m1278getMagnifierCenterJVtK1S4(selectionManager, j, selection.getEnd());
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
    }

    /* renamed from: getMagnifierCenter-JVtK1S4  reason: not valid java name */
    private static final long m1278getMagnifierCenterJVtK1S4(SelectionManager selectionManager, long j, Selection.AnchorInfo anchorInfo) {
        float f;
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release == null) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates containerLayoutCoordinates = selectionManager.getContainerLayoutCoordinates();
        if (containerLayoutCoordinates == null) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        int offset = anchorInfo.getOffset();
        if (offset > anchorSelectable$foundation_release.getLastVisibleOffset()) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        Offset r6 = selectionManager.m1262getCurrentDragPosition_m7T9E();
        Intrinsics.checkNotNull(r6);
        float r62 = Offset.m3562getXimpl(layoutCoordinates.m5319localPositionOfR5De75A(containerLayoutCoordinates, r6.m3572unboximpl()));
        long r3 = anchorSelectable$foundation_release.m1224getRangeOfLineContainingjx7JFs(offset);
        if (TextRange.m6036getCollapsedimpl(r3)) {
            f = anchorSelectable$foundation_release.getLineLeft(offset);
        } else {
            float lineLeft = anchorSelectable$foundation_release.getLineLeft(TextRange.m6042getStartimpl(r3));
            float lineRight = anchorSelectable$foundation_release.getLineRight(TextRange.m6037getEndimpl(r3) - 1);
            f = RangesKt.coerceIn(r62, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
        }
        if (f == -1.0f) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        if (Math.abs(r62 - f) > ((float) (IntSize.m6790getWidthimpl(j) / 2))) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        float centerYForOffset = anchorSelectable$foundation_release.getCenterYForOffset(offset);
        if (centerYForOffset == -1.0f) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        return containerLayoutCoordinates.m5319localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(f, centerYForOffset));
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m3600Rect0a9Yr6o(layoutCoordinates.m5323windowToLocalMKHz9U(boundsInWindow.m3597getTopLeftF1C5BW0()), layoutCoordinates.m5323windowToLocalMKHz9U(boundsInWindow.m3591getBottomRightF1C5BW0()));
    }

    /* renamed from: containsInclusive-Uv8p0NA  reason: not valid java name */
    public static final boolean m1277containsInclusiveUv8p0NA(Rect rect, long j) {
        float left = rect.getLeft();
        float right = rect.getRight();
        float r2 = Offset.m3562getXimpl(j);
        if (left <= r2 && r2 <= right) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float r4 = Offset.m3563getYimpl(j);
            return top <= r4 && r4 <= bottom;
        }
    }
}
