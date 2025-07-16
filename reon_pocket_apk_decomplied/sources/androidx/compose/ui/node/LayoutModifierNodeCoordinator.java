package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020/H\u0016J=\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0019\u00105\u001a\u0015\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020!\u0018\u000106¢\u0006\u0002\b8H\u0014ø\u0001\u0000¢\u0006\u0004\b9\u0010:R$\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f@TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "<set-?>", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "Companion", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNodeCoordinator.kt */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint modifierBoundsPaint;
    private LayoutModifierNode layoutModifierNode;
    /* access modifiers changed from: private */
    public Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;

    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode2) {
        super(layoutNode);
        this.layoutModifierNode = layoutModifierNode2;
        this.lookaheadDelegate = layoutNode.getLookaheadRoot$ui_release() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final void setLayoutModifierNode$ui_release(LayoutModifierNode layoutModifierNode2) {
        this.layoutModifierNode = layoutModifierNode2;
    }

    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui_release = getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    /* access modifiers changed from: protected */
    public void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate2) {
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m5502measureBRTryo0(long j) {
            LookaheadDelegate lookaheadDelegate = this;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            lookaheadDelegate.m5408setMeasurementConstraintsBRTryo0(j);
            layoutModifierNodeCoordinator.lookaheadConstraints = Constraints.m6514boximpl(j);
            LookaheadDelegate lookaheadDelegate2 = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            lookaheadDelegate.set_measureResult(layoutModifierNodeCoordinator.getLayoutModifierNode().m5495measure3p2s80s(this, lookaheadDelegate2, j));
            return lookaheadDelegate;
        }

        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int access$calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(access$calculateAlignmentAndPlaceChildAsNeeded));
            return access$calculateAlignmentAndPlaceChildAsNeeded;
        }

        public int minIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate, i);
        }

        public int maxIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate, i);
        }

        public int minIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate, i);
        }

        public int maxIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate, i);
        }
    }

    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m5500measureBRTryo0(long j) {
        MeasureResult measureResult;
        m5408setMeasurementConstraintsBRTryo0(j);
        LayoutModifierNode layoutModifierNode2 = getLayoutModifierNode();
        if (layoutModifierNode2 instanceof IntermediateLayoutModifierNode) {
            LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            MeasureResult measureResult$ui_release = lookaheadDelegate2.getMeasureResult$ui_release();
            long IntSize = IntSizeKt.IntSize(measureResult$ui_release.getWidth(), measureResult$ui_release.getHeight());
            Constraints access$getLookaheadConstraints$p = this.lookaheadConstraints;
            Intrinsics.checkNotNull(access$getLookaheadConstraints$p);
            measureResult = ((IntermediateLayoutModifierNode) layoutModifierNode2).m5282intermediateMeasureTeuZzU(this, getWrappedNonNull(), j, IntSize, access$getLookaheadConstraints$p.m6532unboximpl());
        } else {
            measureResult = layoutModifierNode2.m5495measure3p2s80s(this, getWrappedNonNull(), j);
        }
        setMeasureResult$ui_release(measureResult);
        Placeable placeable = this;
        onMeasured();
        return placeable;
    }

    public int minIntrinsicWidth(int i) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if (intermediateLayoutModifierNode != null) {
            return intermediateLayoutModifierNode.minIntermediateIntrinsicWidth$ui_release(this, getWrappedNonNull(), i);
        }
        return layoutModifierNode2.minIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    public int maxIntrinsicWidth(int i) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if (intermediateLayoutModifierNode != null) {
            return intermediateLayoutModifierNode.maxIntermediateIntrinsicWidth$ui_release(this, getWrappedNonNull(), i);
        }
        return layoutModifierNode2.maxIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    public int minIntrinsicHeight(int i) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if (intermediateLayoutModifierNode != null) {
            return intermediateLayoutModifierNode.minIntermediateIntrinsicHeight$ui_release(this, getWrappedNonNull(), i);
        }
        return layoutModifierNode2.minIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    public int maxIntrinsicHeight(int i) {
        LayoutModifierNode layoutModifierNode2 = this.layoutModifierNode;
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = layoutModifierNode2 instanceof IntermediateLayoutModifierNode ? (IntermediateLayoutModifierNode) layoutModifierNode2 : null;
        if (intermediateLayoutModifierNode != null) {
            return intermediateLayoutModifierNode.maxIntermediateIntrinsicHeight$ui_release(this, getWrappedNonNull(), i);
        }
        return layoutModifierNode2.maxIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m5501placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        super.m5630placeAtf8xVGno(j, f, function1);
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            getMeasureResult$ui_release().placeChildren();
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            return lookaheadDelegate2.getCachedAlignmentLine$ui_release(alignmentLine);
        }
        return LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    public void performDraw(Canvas canvas) {
        getWrappedNonNull().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutModifierNodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m4094setColor8_81llA(Color.Companion.m3843getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m4098setStylek9PVt8s(PaintingStyle.Companion.m4107getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
