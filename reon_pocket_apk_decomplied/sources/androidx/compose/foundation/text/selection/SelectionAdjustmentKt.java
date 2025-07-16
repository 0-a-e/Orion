package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u001c\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rH\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\n*\u00020\b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a4\u0010\u0015\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002¨\u0006\u001b²\u0006\n\u0010\u001c\u001a\u00020\rX\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0007X\u0002"}, d2 = {"adjustToBoundaries", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "boundaryFunction", "Landroidx/compose/foundation/text/selection/BoundaryFunction;", "anchorOnBoundary", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "crossed", "", "isStart", "slot", "", "changeOffset", "info", "newOffset", "ensureAtLeastOneChar", "expandOneChar", "isExpanding", "currentRawOffset", "snapToWordBoundary", "currentLine", "currentOffset", "otherOffset", "updateSelectionBoundary", "previousSelectionAnchor", "foundation_release", "currentRawLine", "anchorSnappedToWordBoundary"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
public final class SelectionAdjustmentKt {
    /* access modifiers changed from: private */
    public static final Selection.AnchorInfo updateSelectionBoundary(SelectionLayout selectionLayout, SelectableInfo selectableInfo, Selection.AnchorInfo anchorInfo) {
        int i;
        int i2;
        if (selectionLayout.isStartHandle()) {
            i = selectableInfo.getRawStartHandleOffset();
        } else {
            i = selectableInfo.getRawEndHandleOffset();
        }
        if ((selectionLayout.isStartHandle() ? selectionLayout.getStartSlot() : selectionLayout.getEndSlot()) != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(i);
        }
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SelectionAdjustmentKt$updateSelectionBoundary$currentRawLine$2(selectableInfo, i));
        if (selectionLayout.isStartHandle()) {
            i2 = selectableInfo.getRawEndHandleOffset();
        } else {
            i2 = selectableInfo.getRawStartHandleOffset();
        }
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SelectionAdjustmentKt$updateSelectionBoundary$anchorSnappedToWordBoundary$2(selectableInfo, i, i2, selectionLayout, lazy));
        if (selectableInfo.getSelectableId() != anchorInfo.getSelectableId()) {
            return updateSelectionBoundary$lambda$1(lazy2);
        }
        int rawPreviousHandleOffset = selectableInfo.getRawPreviousHandleOffset();
        if (i == rawPreviousHandleOffset) {
            return anchorInfo;
        }
        if (updateSelectionBoundary$lambda$0(lazy) != selectableInfo.getTextLayoutResult().getLineForOffset(rawPreviousHandleOffset)) {
            return updateSelectionBoundary$lambda$1(lazy2);
        }
        int offset = anchorInfo.getOffset();
        long r2 = selectableInfo.getTextLayoutResult().m6016getWordBoundaryjx7JFs(offset);
        if (!isExpanding(selectableInfo, i, selectionLayout.isStartHandle())) {
            return selectableInfo.anchorForOffset(i);
        }
        if (offset == TextRange.m6042getStartimpl(r2) || offset == TextRange.m6037getEndimpl(r2)) {
            return updateSelectionBoundary$lambda$1(lazy2);
        }
        return selectableInfo.anchorForOffset(i);
    }

    /* access modifiers changed from: private */
    public static final int updateSelectionBoundary$lambda$0(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    private static final Selection.AnchorInfo updateSelectionBoundary$lambda$1(Lazy<Selection.AnchorInfo> lazy) {
        return lazy.getValue();
    }

    private static final boolean isExpanding(SelectableInfo selectableInfo, int i, boolean z) {
        if (selectableInfo.getRawPreviousHandleOffset() == -1) {
            return true;
        }
        if (i == selectableInfo.getRawPreviousHandleOffset()) {
            return false;
        }
        if (z ^ (selectableInfo.getRawCrossStatus() == CrossStatus.CROSSED)) {
            if (i < selectableInfo.getRawPreviousHandleOffset()) {
                return true;
            }
        } else if (i > selectableInfo.getRawPreviousHandleOffset()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Selection.AnchorInfo snapToWordBoundary(SelectableInfo selectableInfo, int i, int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5;
        long r0 = selectableInfo.getTextLayoutResult().m6016getWordBoundaryjx7JFs(i2);
        if (selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.m6042getStartimpl(r0)) == i) {
            i4 = TextRange.m6042getStartimpl(r0);
        } else if (i >= selectableInfo.getTextLayoutResult().getLineCount()) {
            i4 = selectableInfo.getTextLayoutResult().getLineStart(selectableInfo.getTextLayoutResult().getLineCount() - 1);
        } else {
            i4 = selectableInfo.getTextLayoutResult().getLineStart(i);
        }
        if (selectableInfo.getTextLayoutResult().getLineForOffset(TextRange.m6037getEndimpl(r0)) == i) {
            i5 = TextRange.m6037getEndimpl(r0);
        } else if (i >= selectableInfo.getTextLayoutResult().getLineCount()) {
            i5 = TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), selectableInfo.getTextLayoutResult().getLineCount() - 1, false, 2, (Object) null);
        } else {
            i5 = TextLayoutResult.getLineEnd$default(selectableInfo.getTextLayoutResult(), i, false, 2, (Object) null);
        }
        if (i4 == i3) {
            return selectableInfo.anchorForOffset(i5);
        }
        if (i5 == i3) {
            return selectableInfo.anchorForOffset(i4);
        }
        if (!(z ^ z2) ? i2 >= i4 : i2 > i5) {
            i4 = i5;
        }
        return selectableInfo.anchorForOffset(i4);
    }

    /* access modifiers changed from: private */
    public static final Selection adjustToBoundaries(SelectionLayout selectionLayout, BoundaryFunction boundaryFunction) {
        boolean z = selectionLayout.getCrossStatus() == CrossStatus.CROSSED;
        return new Selection(anchorOnBoundary(selectionLayout.getStartInfo(), z, true, selectionLayout.getStartSlot(), boundaryFunction), anchorOnBoundary(selectionLayout.getEndInfo(), z, false, selectionLayout.getEndSlot(), boundaryFunction), z);
    }

    private static final Selection.AnchorInfo anchorOnBoundary(SelectableInfo selectableInfo, boolean z, boolean z2, int i, BoundaryFunction boundaryFunction) {
        int rawStartHandleOffset = z2 ? selectableInfo.getRawStartHandleOffset() : selectableInfo.getRawEndHandleOffset();
        if (i != selectableInfo.getSlot()) {
            return selectableInfo.anchorForOffset(rawStartHandleOffset);
        }
        long r5 = boundaryFunction.m1210getBoundaryfzxv0v0(selectableInfo, rawStartHandleOffset);
        return selectableInfo.anchorForOffset(z ^ z2 ? TextRange.m6042getStartimpl(r5) : TextRange.m6037getEndimpl(r5));
    }

    public static final Selection ensureAtLeastOneChar(Selection selection, SelectionLayout selectionLayout) {
        if (!SelectionLayoutKt.isCollapsed(selection, selectionLayout)) {
            return selection;
        }
        return (selectionLayout.getSize() > 1 || selectionLayout.getPreviousSelection() == null || selectionLayout.getCurrentInfo().getInputText().length() == 0) ? selection : expandOneChar(selection, selectionLayout);
    }

    private static final Selection expandOneChar(Selection selection, SelectionLayout selectionLayout) {
        int i;
        SelectableInfo currentInfo = selectionLayout.getCurrentInfo();
        String inputText = currentInfo.getInputText();
        int rawStartHandleOffset = currentInfo.getRawStartHandleOffset();
        int length = inputText.length();
        if (rawStartHandleOffset == 0) {
            int findFollowingBreak = StringHelpers_androidKt.findFollowingBreak(inputText, 0);
            if (selectionLayout.isStartHandle()) {
                return Selection.copy$default(selection, changeOffset(selection.getStart(), currentInfo, findFollowingBreak), (Selection.AnchorInfo) null, true, 2, (Object) null);
            }
            return Selection.copy$default(selection, (Selection.AnchorInfo) null, changeOffset(selection.getEnd(), currentInfo, findFollowingBreak), false, 1, (Object) null);
        } else if (rawStartHandleOffset == length) {
            int findPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(inputText, length);
            if (selectionLayout.isStartHandle()) {
                return Selection.copy$default(selection, changeOffset(selection.getStart(), currentInfo, findPrecedingBreak), (Selection.AnchorInfo) null, false, 2, (Object) null);
            }
            return Selection.copy$default(selection, (Selection.AnchorInfo) null, changeOffset(selection.getEnd(), currentInfo, findPrecedingBreak), true, 1, (Object) null);
        } else {
            Selection previousSelection = selectionLayout.getPreviousSelection();
            boolean z = previousSelection != null && previousSelection.getHandlesCrossed();
            if (selectionLayout.isStartHandle() ^ z) {
                i = StringHelpers_androidKt.findPrecedingBreak(inputText, rawStartHandleOffset);
            } else {
                i = StringHelpers_androidKt.findFollowingBreak(inputText, rawStartHandleOffset);
            }
            if (selectionLayout.isStartHandle()) {
                return Selection.copy$default(selection, changeOffset(selection.getStart(), currentInfo, i), (Selection.AnchorInfo) null, z, 2, (Object) null);
            }
            return Selection.copy$default(selection, (Selection.AnchorInfo) null, changeOffset(selection.getEnd(), currentInfo, i), z, 1, (Object) null);
        }
    }

    private static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo anchorInfo, SelectableInfo selectableInfo, int i) {
        return Selection.AnchorInfo.copy$default(anchorInfo, selectableInfo.getTextLayoutResult().getBidiRunDirection(i), i, 0, 4, (Object) null);
    }
}
