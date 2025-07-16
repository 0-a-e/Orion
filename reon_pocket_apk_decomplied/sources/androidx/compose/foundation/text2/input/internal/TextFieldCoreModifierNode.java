package androidx.compose.foundation.text2.input.internal;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BE\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016JF\u0010/\u001a\u00020,2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\"\u00100\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u00010\u001e2\u0006\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020'H\u0002J\f\u00104\u001a\u00020,*\u000205H\u0016J\f\u00106\u001a\u00020,*\u000207H\u0016J\f\u00108\u001a\u00020,*\u000209H\u0002J&\u0010:\u001a\u00020,*\u0002092\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0014\u0010@\u001a\u00020,*\u0002092\u0006\u0010<\u001a\u00020=H\u0002J&\u0010A\u001a\u00020B*\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ&\u0010J\u001a\u00020B*\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010IJ&\u0010L\u001a\u00020B*\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010IR\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006N"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "textLayoutState", "Landroidx/compose/foundation/text2/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(ZLandroidx/compose/foundation/text2/input/internal/TextLayoutState;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;)V", "changeObserverJob", "Lkotlinx/coroutines/Job;", "cursorAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "showCursor", "getShowCursor", "()Z", "textFieldMagnifierNode", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldMagnifierNode;", "calculateOffsetToFollow", "", "currSelection", "calculateOffsetToFollow-5zc-tL8", "(J)I", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "updateNode", "updateScrollState", "cursorRect", "containerSize", "textFieldSize", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawCursor", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawSelection", "selection", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawText", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldCoreModifier.kt */
public final class TextFieldCoreModifierNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Job changeObserverJob;
    /* access modifiers changed from: private */
    public final Animatable<Float, AnimationVector1D> cursorAlpha = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, (Object) null);
    private Brush cursorBrush;
    /* access modifiers changed from: private */
    public boolean isFocused;
    private Orientation orientation;
    private Rect previousCursorRect = new Rect(-1.0f, -1.0f, -1.0f, -1.0f);
    /* access modifiers changed from: private */
    public TextRange previousSelection;
    /* access modifiers changed from: private */
    public ScrollState scrollState;
    private final TextFieldMagnifierNode textFieldMagnifierNode = ((TextFieldMagnifierNode) delegate(AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, this.isFocused)));
    private TextFieldSelectionState textFieldSelectionState;
    /* access modifiers changed from: private */
    public TransformedTextFieldState textFieldState;
    /* access modifiers changed from: private */
    public TextLayoutState textLayoutState;
    private boolean writeable;

    public /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    public TextFieldCoreModifierNode(boolean z, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z2, ScrollState scrollState2, Orientation orientation2) {
        this.isFocused = z;
        this.textLayoutState = textLayoutState2;
        this.textFieldState = transformedTextFieldState;
        this.textFieldSelectionState = textFieldSelectionState2;
        this.cursorBrush = brush;
        this.writeable = z2;
        this.scrollState = scrollState2;
        this.orientation = orientation2;
    }

    private final boolean getShowCursor() {
        return this.writeable && this.isFocused && TextFieldCoreModifierKt.isSpecified(this.cursorBrush);
    }

    public final void updateNode(boolean z, TextLayoutState textLayoutState2, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState2, Brush brush, boolean z2, ScrollState scrollState2, Orientation orientation2) {
        boolean z3 = z;
        TextLayoutState textLayoutState3 = textLayoutState2;
        TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
        TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState2;
        ScrollState scrollState3 = scrollState2;
        boolean showCursor = getShowCursor();
        boolean z4 = this.isFocused;
        TransformedTextFieldState transformedTextFieldState3 = this.textFieldState;
        TextLayoutState textLayoutState4 = this.textLayoutState;
        TextFieldSelectionState textFieldSelectionState4 = this.textFieldSelectionState;
        ScrollState scrollState4 = this.scrollState;
        this.isFocused = z3;
        this.textLayoutState = textLayoutState3;
        this.textFieldState = transformedTextFieldState2;
        this.textFieldSelectionState = textFieldSelectionState3;
        this.cursorBrush = brush;
        this.writeable = z2;
        this.scrollState = scrollState3;
        this.orientation = orientation2;
        this.textFieldMagnifierNode.update(transformedTextFieldState2, textFieldSelectionState3, textLayoutState3, z3);
        if (!getShowCursor()) {
            Job job = this.changeObserverJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.changeObserverJob = null;
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldCoreModifierNode$updateNode$1(this, (Continuation<? super TextFieldCoreModifierNode$updateNode$1>) null), 3, (Object) null);
        } else if (!z4 || !Intrinsics.areEqual((Object) transformedTextFieldState3, (Object) transformedTextFieldState2) || !showCursor) {
            this.changeObserverJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldCoreModifierNode$updateNode$2(transformedTextFieldState2, this, (Continuation<? super TextFieldCoreModifierNode$updateNode$2>) null), 3, (Object) null);
        }
        if (!Intrinsics.areEqual((Object) transformedTextFieldState3, (Object) transformedTextFieldState2) || !Intrinsics.areEqual((Object) textLayoutState4, (Object) textLayoutState3) || !Intrinsics.areEqual((Object) textFieldSelectionState4, (Object) textFieldSelectionState3) || !Intrinsics.areEqual((Object) scrollState4, (Object) scrollState3)) {
            LayoutModifierNodeKt.invalidateMeasurement(this);
        }
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1394measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        if (this.orientation == Orientation.Vertical) {
            return m1393measureVerticalScroll3p2s80s(measureScope, measurable, j);
        }
        return m1392measureHorizontalScroll3p2s80s(measureScope, measurable, j);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        TextFieldCharSequence text = this.textFieldState.getText();
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult != null) {
            if (TextRange.m6036getCollapsedimpl(text.m1346getSelectionInCharsd9O1mEE())) {
                DrawScope drawScope = contentDrawScope;
                drawText(drawScope, layoutResult);
                drawCursor(drawScope);
            } else {
                DrawScope drawScope2 = contentDrawScope;
                m1391drawSelectionSbBc2M(drawScope2, text.m1346getSelectionInCharsd9O1mEE(), layoutResult);
                drawText(drawScope2, layoutResult);
            }
            this.textFieldMagnifierNode.draw(contentDrawScope);
        }
    }

    /* renamed from: measureVerticalScroll-3p2s80s  reason: not valid java name */
    private final MeasureResult m1393measureVerticalScroll3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r10 = measurable.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 7, (Object) null));
        int min = Math.min(r10.getHeight(), Constraints.m6525getMaxHeightimpl(j));
        return MeasureScope.CC.layout$default(measureScope, r10.getWidth(), min, (Map) null, new TextFieldCoreModifierNode$measureVerticalScroll$1(this, measureScope, r10, min), 4, (Object) null);
    }

    /* renamed from: measureHorizontalScroll-3p2s80s  reason: not valid java name */
    private final MeasureResult m1392measureHorizontalScroll3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2;
        if (measurable.maxIntrinsicWidth(Constraints.m6525getMaxHeightimpl(j)) < Constraints.m6526getMaxWidthimpl(j)) {
            j2 = j;
        } else {
            j2 = Constraints.m6517copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, (Object) null);
        }
        Placeable r12 = measurable.m5368measureBRTryo0(j2);
        int min = Math.min(r12.getWidth(), Constraints.m6526getMaxWidthimpl(j));
        return MeasureScope.CC.layout$default(measureScope, min, r12.getHeight(), (Map) null, new TextFieldCoreModifierNode$measureHorizontalScroll$1(this, measureScope, r12, min), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateOffsetToFollow-5zc-tL8  reason: not valid java name */
    public final int m1390calculateOffsetToFollow5zctL8(long j) {
        TextRange textRange = this.previousSelection;
        if (textRange == null || TextRange.m6037getEndimpl(j) != TextRange.m6037getEndimpl(textRange.m6046unboximpl())) {
            return TextRange.m6037getEndimpl(j);
        }
        TextRange textRange2 = this.previousSelection;
        if (textRange2 == null || TextRange.m6042getStartimpl(j) != TextRange.m6042getStartimpl(textRange2.m6046unboximpl())) {
            return TextRange.m6042getStartimpl(j);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final void updateScrollState(Rect rect, int i, int i2) {
        float f;
        int i3;
        this.scrollState.setMaxValue$foundation_release(i2 - i);
        if (getShowCursor() && rect != null) {
            if (rect.getLeft() != this.previousCursorRect.getLeft() || rect.getTop() != this.previousCursorRect.getTop()) {
                boolean z = this.orientation == Orientation.Vertical;
                float top = z ? rect.getTop() : rect.getLeft();
                float bottom = z ? rect.getBottom() : rect.getRight();
                int value = this.scrollState.getValue();
                float f2 = (float) (value + i);
                float f3 = (bottom <= f2 && (top >= f || bottom - top <= ((float) i))) ? (i3 >= 0 || bottom - top > ((float) i)) ? 0.0f : top - (f = (float) value) : bottom - f2;
                this.previousCursorRect = rect;
                Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldCoreModifierNode$updateScrollState$1(this, f3, (Continuation<? super TextFieldCoreModifierNode$updateScrollState$1>) null), 1, (Object) null);
            }
        }
    }

    /* renamed from: drawSelection-Sb-Bc2M  reason: not valid java name */
    private final void m1391drawSelectionSbBc2M(DrawScope drawScope, long j, TextLayoutResult textLayoutResult) {
        int r0 = TextRange.m6040getMinimpl(j);
        int r13 = TextRange.m6039getMaximpl(j);
        if (r0 != r13) {
            DrawScope drawScope2 = drawScope;
            DrawScope.CC.m4466drawPathLG529CI$default(drawScope2, textLayoutResult.getPathForRange(r0, r13), ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextSelectionColorsKt.getLocalTextSelectionColors())).m1323getBackgroundColor0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
    }

    private final void drawCursor(DrawScope drawScope) {
        if (this.cursorAlpha.getValue().floatValue() > 0.0f && getShowCursor()) {
            float coerceIn = RangesKt.coerceIn(this.cursorAlpha.getValue().floatValue(), 0.0f, 1.0f);
            if (coerceIn != 0.0f) {
                Rect cursorRect = this.textFieldSelectionState.getCursorRect();
                DrawScope.CC.m4461drawLine1RTmtNc$default(drawScope, this.cursorBrush, cursorRect.m3596getTopCenterF1C5BW0(), cursorRect.m3589getBottomCenterF1C5BW0(), cursorRect.getWidth(), 0, (PathEffect) null, coerceIn, (ColorFilter) null, 0, 432, (Object) null);
            }
        }
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        this.textLayoutState.setCoreNodeCoordinates(layoutCoordinates);
        this.textFieldMagnifierNode.onGloballyPositioned(layoutCoordinates);
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        this.textFieldMagnifierNode.applySemantics(semanticsPropertyReceiver);
    }

    private final void drawText(DrawScope drawScope, TextLayoutResult textLayoutResult) {
        TextPainter.INSTANCE.paint(drawScope.getDrawContext().getCanvas(), textLayoutResult);
    }
}
