package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 >2\u00020\u0001:\u0002>?B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J:\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u000202H\u0016J=\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0019\u00108\u001a\u0015\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u0017\u0018\u000109¢\u0006\u0002\b;H\u0014ø\u0001\u0000¢\u0006\u0004\b<\u0010=R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "<set-?>", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "tail", "Landroidx/compose/ui/node/TailModifierNode;", "getTail$annotations", "()V", "getTail", "()Landroidx/compose/ui/node/TailModifierNode;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "", "hitTestChild", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "hitTestChild-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "Companion", "LookaheadDelegateImpl", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InnerNodeCoordinator.kt */
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Paint innerBoundsPaint;
    private LookaheadDelegate lookaheadDelegate;
    private final TailModifierNode tail = new TailModifierNode();

    public static /* synthetic */ void getTail$annotations() {
    }

    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        getTail().updateCoordinator$ui_release(this);
        this.lookaheadDelegate = layoutNode.getLookaheadRoot$ui_release() != null ? new LookaheadDelegateImpl() : null;
    }

    public TailModifierNode getTail() {
        return this.tail;
    }

    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    /* access modifiers changed from: protected */
    public void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate2) {
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0014\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/InnerNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InnerNodeCoordinator.kt */
    private final class LookaheadDelegateImpl extends LookaheadDelegate {
        public LookaheadDelegateImpl() {
            super(InnerNodeCoordinator.this);
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m5492measureBRTryo0(long j) {
            LookaheadDelegate lookaheadDelegate = this;
            lookaheadDelegate.m5408setMeasurementConstraintsBRTryo0(j);
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i]).getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                    i++;
                } while (i < size);
            }
            lookaheadDelegate.set_measureResult(getLayoutNode().getMeasurePolicy().m5369measure3p2s80s(this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), j));
            return lookaheadDelegate;
        }

        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            int intValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(intValue));
            return intValue;
        }

        /* access modifiers changed from: protected */
        public void placeChildren() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.onNodePlaced$ui_release();
        }

        public int minIntrinsicWidth(int i) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicWidth(i);
        }

        public int minIntrinsicHeight(int i) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicHeight(i);
        }

        public int maxIntrinsicWidth(int i) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicWidth(i);
        }

        public int maxIntrinsicHeight(int i) {
            return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicHeight(i);
        }
    }

    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateImpl());
        }
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m5490measureBRTryo0(long j) {
        m5408setMeasurementConstraintsBRTryo0(j);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                ((LayoutNode) content[i]).getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i++;
            } while (i < size);
        }
        setMeasureResult$ui_release(getLayoutNode().getMeasurePolicy().m5369measure3p2s80s(this, getLayoutNode().getChildMeasurables$ui_release(), j));
        onMeasured();
        return this;
    }

    public int minIntrinsicWidth(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicWidth(i);
    }

    public int maxIntrinsicHeight(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicHeight(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void m5491placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        super.m5630placeAtf8xVGno(j, f, function1);
        if (!isShallowPlacing$ui_release()) {
            onPlaced();
            getLayoutNode().getMeasurePassDelegate$ui_release().onNodePlaced$ui_release();
        }
    }

    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate2 = getLookaheadDelegate();
        if (lookaheadDelegate2 != null) {
            return lookaheadDelegate2.calculateAlignmentLine(alignmentLine);
        }
        Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public void performDraw(Canvas canvas) {
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            Object[] content = zSortedChildren.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                if (layoutNode.isPlaced()) {
                    layoutNode.draw$ui_release(canvas);
                }
                i++;
            } while (i < size);
        }
        if (requireOwner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m5489hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator.HitTestSource r17, long r18, androidx.compose.ui.node.HitTestResult r20, boolean r21, boolean r22) {
        /*
            r16 = this;
            r0 = r16
            r8 = r18
            androidx.compose.ui.node.LayoutNode r1 = r16.getLayoutNode()
            r10 = r17
            boolean r1 = r10.shouldHitTestChildren(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0034
            boolean r1 = r0.m5637withinLayerBoundsk4lQ0M(r8)
            if (r1 == 0) goto L_0x001c
            r11 = r22
        L_0x001a:
            r3 = r2
            goto L_0x0036
        L_0x001c:
            if (r21 == 0) goto L_0x0034
            long r4 = r16.m5619getMinimumTouchTargetSizeNHjbRc()
            float r1 = r0.m5616distanceInMinimumTouchTargettz77jQw(r8, r4)
            boolean r4 = java.lang.Float.isInfinite(r1)
            if (r4 != 0) goto L_0x0034
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0034
            r11 = r3
            goto L_0x001a
        L_0x0034:
            r11 = r22
        L_0x0036:
            if (r3 == 0) goto L_0x0085
            int r12 = r20.hitDepth
            androidx.compose.ui.node.LayoutNode r1 = r16.getLayoutNode()
            androidx.compose.runtime.collection.MutableVector r1 = r1.getZSortedChildren()
            int r3 = r1.getSize()
            if (r3 <= 0) goto L_0x0080
            int r3 = r3 - r2
            java.lang.Object[] r13 = r1.getContent()
            r14 = r3
        L_0x0050:
            r1 = r13[r14]
            r15 = r1
            androidx.compose.ui.node.LayoutNode r15 = (androidx.compose.ui.node.LayoutNode) r15
            boolean r1 = r15.isPlaced()
            if (r1 == 0) goto L_0x007c
            r1 = r17
            r2 = r15
            r3 = r18
            r5 = r20
            r6 = r21
            r7 = r11
            r1.m5642childHitTestYqVAtuI(r2, r3, r5, r6, r7)
            boolean r1 = r20.hasHit()
            if (r1 != 0) goto L_0x006f
            goto L_0x007c
        L_0x006f:
            androidx.compose.ui.node.NodeCoordinator r1 = r15.getOuterCoordinator$ui_release()
            boolean r1 = r1.shouldSharePointerInputWithSiblings()
            if (r1 == 0) goto L_0x0080
            r20.acceptHits()
        L_0x007c:
            int r14 = r14 + -1
            if (r14 >= 0) goto L_0x0050
        L_0x0080:
            r1 = r20
            r1.hitDepth = r12
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerNodeCoordinator.m5489hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator$HitTestSource, long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InnerNodeCoordinator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m4094setColor8_81llA(Color.Companion.m3850getRed0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m4098setStylek9PVt8s(PaintingStyle.Companion.m4107getStrokeTiuSbCo());
        innerBoundsPaint = Paint;
    }
}
