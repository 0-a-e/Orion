package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.IntSize;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002\u001a6\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\t*\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002\u001a4\u0010 \u001a\u00020\u0001*\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001a0#j\b\u0012\u0004\u0012\u00020\u001a`$2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0001H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"getOffsetForPosition", "", "position", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetForPosition-3MmeM6k", "(JLandroidx/compose/ui/text/TextLayoutResult;)I", "getXDirection", "Landroidx/compose/foundation/text/selection/Direction;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getXDirection-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/foundation/text/selection/Direction;", "getYDirection", "getYDirection-3MmeM6k", "isSelected", "", "currentDirection", "otherDirection", "appendSelectableInfo", "", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "localPosition", "previousHandlePosition", "selectableId", "", "appendSelectableInfo-Parwq6A", "(Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;Landroidx/compose/ui/text/TextLayoutResult;JJJ)V", "getDirectionById", "anchorSelectableId", "currentSelectableId", "getPreviousAdjustedOffset", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "selectableIdOrderingComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "currentTextLength", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiWidgetSelectionDelegate.kt */
public final class MultiWidgetSelectionDelegateKt {
    /* renamed from: appendSelectableInfo-Parwq6A  reason: not valid java name */
    public static final void m1218appendSelectableInfoParwq6A(SelectionLayoutBuilder selectionLayoutBuilder, TextLayoutResult textLayoutResult, long j, long j2, long j3) {
        Direction direction;
        Direction direction2;
        Direction direction3;
        Direction direction4;
        Direction direction5;
        int i;
        int i2;
        int i3;
        Selection.AnchorInfo start;
        Selection.AnchorInfo end;
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        long j4 = j;
        long j5 = j3;
        Rect rect = new Rect(0.0f, 0.0f, (float) IntSize.m6790getWidthimpl(textLayoutResult.m6015getSizeYbymL2g()), (float) IntSize.m6789getHeightimpl(textLayoutResult.m6015getSizeYbymL2g()));
        Direction r11 = m1220getXDirection3MmeM6k(j4, rect);
        Direction r12 = m1221getYDirection3MmeM6k(j4, rect);
        if (selectionLayoutBuilder.isStartHandle()) {
            Selection previousSelection = selectionLayoutBuilder.getPreviousSelection();
            direction5 = appendSelectableInfo_Parwq6A$otherDirection(r11, r12, selectionLayoutBuilder, j3, previousSelection != null ? previousSelection.getEnd() : null);
            direction2 = direction5;
            direction = direction2;
            direction4 = r11;
            direction3 = r12;
        } else {
            Selection previousSelection2 = selectionLayoutBuilder.getPreviousSelection();
            direction5 = appendSelectableInfo_Parwq6A$otherDirection(r11, r12, selectionLayoutBuilder, j3, previousSelection2 != null ? previousSelection2.getStart() : null);
            direction4 = direction5;
            direction3 = direction4;
            direction2 = r11;
            direction = r12;
        }
        if (isSelected(SelectionLayoutKt.resolve2dDirection(r11, r12), direction5)) {
            int length = textLayoutResult.getLayoutInput().getText().length();
            if (selectionLayoutBuilder.isStartHandle()) {
                int r0 = m1219getOffsetForPosition3MmeM6k(j4, textLayoutResult);
                Selection previousSelection3 = selectionLayoutBuilder.getPreviousSelection();
                i2 = r0;
                i = (previousSelection3 == null || (end = previousSelection3.getEnd()) == null) ? r0 : getPreviousAdjustedOffset(end, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j5, length);
            } else {
                int r02 = m1219getOffsetForPosition3MmeM6k(j4, textLayoutResult);
                Selection previousSelection4 = selectionLayoutBuilder.getPreviousSelection();
                i = r02;
                i2 = (previousSelection4 == null || (start = previousSelection4.getStart()) == null) ? r02 : getPreviousAdjustedOffset(start, selectionLayoutBuilder.getSelectableIdOrderingComparator(), j5, length);
            }
            if (OffsetKt.m3583isUnspecifiedk4lQ0M(j2)) {
                i3 = -1;
            } else {
                i3 = m1219getOffsetForPosition3MmeM6k(j2, textLayoutResult);
            }
            selectionLayoutBuilder.appendInfo(j3, i2, direction4, direction3, i, direction2, direction, i3, textLayoutResult);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r4 = getDirectionById(r4, r7.getSelectableId(), r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.foundation.text.selection.Direction appendSelectableInfo_Parwq6A$otherDirection(androidx.compose.foundation.text.selection.Direction r2, androidx.compose.foundation.text.selection.Direction r3, androidx.compose.foundation.text.selection.SelectionLayoutBuilder r4, long r5, androidx.compose.foundation.text.selection.Selection.AnchorInfo r7) {
        /*
            if (r7 == 0) goto L_0x000d
            long r0 = r7.getSelectableId()
            androidx.compose.foundation.text.selection.Direction r4 = getDirectionById(r4, r0, r5)
            if (r4 == 0) goto L_0x000d
            goto L_0x0011
        L_0x000d:
            androidx.compose.foundation.text.selection.Direction r4 = androidx.compose.foundation.text.selection.SelectionLayoutKt.resolve2dDirection(r2, r3)
        L_0x0011:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegateKt.appendSelectableInfo_Parwq6A$otherDirection(androidx.compose.foundation.text.selection.Direction, androidx.compose.foundation.text.selection.Direction, androidx.compose.foundation.text.selection.SelectionLayoutBuilder, long, androidx.compose.foundation.text.selection.Selection$AnchorInfo):androidx.compose.foundation.text.selection.Direction");
    }

    private static final int getPreviousAdjustedOffset(Selection.AnchorInfo anchorInfo, Comparator<Long> comparator, long j, int i) {
        int compare = comparator.compare(Long.valueOf(anchorInfo.getSelectableId()), Long.valueOf(j));
        if (compare < 0) {
            return 0;
        }
        return compare > 0 ? i : anchorInfo.getOffset();
    }

    /* renamed from: getXDirection-3MmeM6k  reason: not valid java name */
    private static final Direction m1220getXDirection3MmeM6k(long j, Rect rect) {
        if (Offset.m3562getXimpl(j) < rect.getLeft()) {
            return Direction.BEFORE;
        }
        if (Offset.m3562getXimpl(j) > rect.getRight()) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    /* renamed from: getYDirection-3MmeM6k  reason: not valid java name */
    private static final Direction m1221getYDirection3MmeM6k(long j, Rect rect) {
        if (Offset.m3563getYimpl(j) < rect.getTop()) {
            return Direction.BEFORE;
        }
        if (Offset.m3563getYimpl(j) > rect.getBottom()) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    private static final Direction getDirectionById(SelectionLayoutBuilder selectionLayoutBuilder, long j, long j2) {
        int compare = selectionLayoutBuilder.getSelectableIdOrderingComparator().compare(Long.valueOf(j), Long.valueOf(j2));
        if (compare < 0) {
            return Direction.BEFORE;
        }
        if (compare > 0) {
            return Direction.AFTER;
        }
        return Direction.ON;
    }

    private static final boolean isSelected(Direction direction, Direction direction2) {
        return direction == Direction.ON || direction != direction2;
    }

    /* renamed from: getOffsetForPosition-3MmeM6k  reason: not valid java name */
    private static final int m1219getOffsetForPosition3MmeM6k(long j, TextLayoutResult textLayoutResult) {
        if (Offset.m3563getYimpl(j) <= 0.0f) {
            return 0;
        }
        if (Offset.m3563getYimpl(j) >= textLayoutResult.getMultiParagraph().getHeight()) {
            return textLayoutResult.getLayoutInput().getText().length();
        }
        return textLayoutResult.m6014getOffsetForPositionk4lQ0M(j);
    }
}
