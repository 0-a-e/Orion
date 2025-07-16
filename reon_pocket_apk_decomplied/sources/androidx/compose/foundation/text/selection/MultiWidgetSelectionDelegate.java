package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u001d\u0010&\u001a\u00020'2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\n\u0010*\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010+\u001a\u00020,H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u000b*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_previousLastVisibleOffset", "", "_previousTextLayoutResult", "getSelectableId", "()J", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getCenterYForOffset", "", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "getLineLeft", "getLineRight", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiWidgetSelectionDelegate.kt */
public final class MultiWidgetSelectionDelegate implements Selectable {
    public static final int $stable = 8;
    private int _previousLastVisibleOffset = -1;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    public MultiWidgetSelectionDelegate(long j, Function0<? extends LayoutCoordinates> function0, Function0<TextLayoutResult> function02) {
        this.selectableId = j;
        this.coordinatesCallback = function0;
        this.layoutResultCallback = function02;
    }

    public long getSelectableId() {
        return this.selectableId;
    }

    private final synchronized int getLastVisibleOffset(TextLayoutResult textLayoutResult) {
        int i;
        if (this._previousTextLayoutResult != textLayoutResult) {
            if (textLayoutResult.getDidOverflowHeight()) {
                if (!textLayoutResult.getMultiParagraph().getDidExceedMaxLines()) {
                    int coerceAtMost = RangesKt.coerceAtMost(textLayoutResult.getLineForVerticalPosition((float) IntSize.m6789getHeightimpl(textLayoutResult.m6015getSizeYbymL2g())), textLayoutResult.getLineCount() - 1);
                    while (coerceAtMost >= 0 && textLayoutResult.getLineTop(coerceAtMost) >= ((float) IntSize.m6789getHeightimpl(textLayoutResult.m6015getSizeYbymL2g()))) {
                        coerceAtMost--;
                    }
                    i = RangesKt.coerceAtLeast(coerceAtMost, 0);
                    this._previousLastVisibleOffset = textLayoutResult.getLineEnd(i, true);
                    this._previousTextLayoutResult = textLayoutResult;
                }
            }
            i = textLayoutResult.getLineCount() - 1;
            this._previousLastVisibleOffset = textLayoutResult.getLineEnd(i, true);
            this._previousTextLayoutResult = textLayoutResult;
        }
        return this._previousLastVisibleOffset;
    }

    public void appendSelectableInfoToBuilder(SelectionLayoutBuilder selectionLayoutBuilder) {
        TextLayoutResult invoke;
        long j;
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates != null && (invoke = this.layoutResultCallback.invoke()) != null) {
            long r0 = selectionLayoutBuilder.getContainerCoordinates().m5319localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m3578getZeroF1C5BW0());
            long r4 = Offset.m3566minusMKHz9U(selectionLayoutBuilder.m1238getCurrentPositionF1C5BW0(), r0);
            if (OffsetKt.m3583isUnspecifiedk4lQ0M(selectionLayoutBuilder.m1239getPreviousHandlePositionF1C5BW0())) {
                j = Offset.Companion.m3577getUnspecifiedF1C5BW0();
            } else {
                j = Offset.m3566minusMKHz9U(selectionLayoutBuilder.m1239getPreviousHandlePositionF1C5BW0(), r0);
            }
            MultiWidgetSelectionDelegateKt.m1218appendSelectableInfoParwq6A(selectionLayoutBuilder, invoke, r4, j, getSelectableId());
        }
    }

    public Selection getSelectAllSelection() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return null;
        }
        int length = invoke.getLayoutInput().getText().length();
        return new Selection(new Selection.AnchorInfo(invoke.getBidiRunDirection(0), 0, getSelectableId()), new Selection.AnchorInfo(invoke.getBidiRunDirection(Math.max(length - 1, 0)), length, getSelectableId()), false);
    }

    /* renamed from: getHandlePosition-dBAh8RU  reason: not valid java name */
    public long m1216getHandlePositiondBAh8RU(Selection selection, boolean z) {
        if ((z && selection.getStart().getSelectableId() != getSelectableId()) || (!z && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        if (getLayoutCoordinates() == null) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return Offset.Companion.m3577getUnspecifiedF1C5BW0();
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(invoke, RangesKt.coerceIn((z ? selection.getStart() : selection.getEnd()).getOffset(), 0, getLastVisibleOffset(invoke)), z, selection.getHandlesCrossed());
    }

    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates invoke = this.coordinatesCallback.invoke();
        if (invoke == null || !invoke.isAttached()) {
            return null;
        }
        return invoke;
    }

    public AnnotatedString getText() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null);
        }
        return invoke.getLayoutInput().getText();
    }

    public Rect getBoundingBox(int i) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return Rect.Companion.getZero();
        }
        int length = invoke.getLayoutInput().getText().length();
        if (length < 1) {
            return Rect.Companion.getZero();
        }
        return invoke.getBoundingBox(RangesKt.coerceIn(i, 0, length - 1));
    }

    public float getLineLeft(int i) {
        int lineForOffset;
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke != null && (lineForOffset = invoke.getLineForOffset(i)) < invoke.getLineCount()) {
            return invoke.getLineLeft(lineForOffset);
        }
        return -1.0f;
    }

    public float getLineRight(int i) {
        int lineForOffset;
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke != null && (lineForOffset = invoke.getLineForOffset(i)) < invoke.getLineCount()) {
            return invoke.getLineRight(lineForOffset);
        }
        return -1.0f;
    }

    public float getCenterYForOffset(int i) {
        int lineForOffset;
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null || (lineForOffset = invoke.getLineForOffset(i)) >= invoke.getLineCount()) {
            return -1.0f;
        }
        float lineTop = invoke.getLineTop(lineForOffset);
        return ((invoke.getLineBottom(lineForOffset) - lineTop) / ((float) 2)) + lineTop;
    }

    /* renamed from: getRangeOfLineContaining--jx7JFs  reason: not valid java name */
    public long m1217getRangeOfLineContainingjx7JFs(int i) {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return TextRange.Companion.m6047getZerod9O1mEE();
        }
        int lastVisibleOffset = getLastVisibleOffset(invoke);
        if (lastVisibleOffset < 1) {
            return TextRange.Companion.m6047getZerod9O1mEE();
        }
        int lineForOffset = invoke.getLineForOffset(RangesKt.coerceIn(i, 0, lastVisibleOffset - 1));
        return TextRangeKt.TextRange(invoke.getLineStart(lineForOffset), invoke.getLineEnd(lineForOffset, true));
    }

    public int getLastVisibleOffset() {
        TextLayoutResult invoke = this.layoutResultCallback.invoke();
        if (invoke == null) {
            return 0;
        }
        return getLastVisibleOffset(invoke);
    }
}
