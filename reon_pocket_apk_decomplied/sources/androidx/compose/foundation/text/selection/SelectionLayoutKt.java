package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\f*\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0014\u0010\u001a\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"UNASSIGNED_SLOT", "", "getTextFieldSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "rawStartHandleOffset", "rawEndHandleOffset", "rawPreviousHandleOffset", "previousSelectionRange", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "", "isStartHandle", "getTextFieldSelectionLayout-RcvT-LA", "(Landroidx/compose/ui/text/TextLayoutResult;IIIJZZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "resolve2dDirection", "Landroidx/compose/foundation/text/selection/Direction;", "x", "y", "getTextDirectionForOffset", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "isCollapsed", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "isOffsetAnEmptyLine", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionLayout.kt */
public final class SelectionLayoutKt {
    public static final int UNASSIGNED_SLOT = -1;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionLayout.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                androidx.compose.foundation.text.selection.Direction[] r0 = androidx.compose.foundation.text.selection.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.foundation.text.selection.Direction r1 = androidx.compose.foundation.text.selection.Direction.BEFORE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.foundation.text.selection.Direction r1 = androidx.compose.foundation.text.selection.Direction.ON     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.foundation.text.selection.Direction r1 = androidx.compose.foundation.text.selection.Direction.AFTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionLayoutKt.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: getTextFieldSelectionLayout-RcvT-LA  reason: not valid java name */
    public static final SelectionLayout m1240getTextFieldSelectionLayoutRcvTLA(TextLayoutResult textLayoutResult, int i, int i2, int i3, long j, boolean z, boolean z2) {
        Selection selection;
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        if (z) {
            selection = null;
        } else {
            selection = new Selection(new Selection.AnchorInfo(getTextDirectionForOffset(textLayoutResult, TextRange.m6042getStartimpl(j)), TextRange.m6042getStartimpl(j), 1), new Selection.AnchorInfo(getTextDirectionForOffset(textLayoutResult, TextRange.m6037getEndimpl(j)), TextRange.m6037getEndimpl(j), 1), TextRange.m6041getReversedimpl(j));
        }
        return new SingleSelectionLayout(z2, 1, 1, selection, new SelectableInfo(1, 1, i, i2, i3, textLayoutResult));
    }

    public static final Direction resolve2dDirection(Direction direction, Direction direction2) {
        int i = WhenMappings.$EnumSwitchMapping$0[direction2.ordinal()];
        if (i == 1) {
            return Direction.BEFORE;
        }
        if (i == 2) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
            if (i2 == 1) {
                return Direction.BEFORE;
            }
            if (i2 == 2) {
                return Direction.ON;
            }
            if (i2 == 3) {
                return Direction.AFTER;
            }
            throw new NoWhenBranchMatchedException();
        } else if (i == 3) {
            return Direction.AFTER;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final ResolvedTextDirection getTextDirectionForOffset(TextLayoutResult textLayoutResult, int i) {
        if (isOffsetAnEmptyLine(textLayoutResult, i)) {
            return textLayoutResult.getParagraphDirection(i);
        }
        return textLayoutResult.getBidiRunDirection(i);
    }

    private static final boolean isOffsetAnEmptyLine(TextLayoutResult textLayoutResult, int i) {
        if (textLayoutResult.getLayoutInput().getText().length() == 0) {
            return true;
        }
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        if ((i == 0 || lineForOffset != textLayoutResult.getLineForOffset(i - 1)) && (i == textLayoutResult.getLayoutInput().getText().length() || lineForOffset != textLayoutResult.getLineForOffset(i + 1))) {
            return true;
        }
        return false;
    }

    public static final boolean isCollapsed(Selection selection, SelectionLayout selectionLayout) {
        if (selection == null || selectionLayout == null) {
            return true;
        }
        if (selection.getStart().getSelectableId() != selection.getEnd().getSelectableId()) {
            if ((selection.getHandlesCrossed() ? selection.getStart() : selection.getEnd()).getOffset() != 0) {
                return false;
            }
            if (selectionLayout.getFirstInfo().getTextLength() != (selection.getHandlesCrossed() ? selection.getEnd() : selection.getStart()).getOffset()) {
                return false;
            }
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            selectionLayout.forEachMiddleInfo(new SelectionLayoutKt$isCollapsed$1(booleanRef));
            return booleanRef.element;
        } else if (selection.getStart().getOffset() == selection.getEnd().getOffset()) {
            return true;
        } else {
            return false;
        }
    }
}
