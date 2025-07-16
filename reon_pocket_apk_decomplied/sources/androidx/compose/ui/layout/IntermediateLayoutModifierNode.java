package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u000289BH\u0012A\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\r¢\u0006\u0002\u0010\u000eJ\b\u0010 \u001a\u00020!H\u0016J4\u0010\"\u001a\u00020\f*\u00020#2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0000¢\u0006\u0002\b-J!\u0010.\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010/\u001a\u00020)H\u0000¢\u0006\u0002\b0J&\u00101\u001a\u00020\f*\u00020#2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0000¢\u0006\u0002\b5J!\u00106\u001a\u00020)*\u00020*2\u0006\u0010\t\u001a\u00020+2\u0006\u0010/\u001a\u00020)H\u0000¢\u0006\u0002\b7R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\nX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000RU\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0002\b\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "closestLookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "intermediateMeasurable", "Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasurablePlaceable;", "intermediateMeasureScope", "Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl;", "isIntermediateChangeActive", "", "()Z", "setIntermediateChangeActive", "(Z)V", "localLookaheadScope", "Landroidx/compose/ui/layout/LookaheadScopeImpl;", "lookaheadConstraints", "getMeasureBlock$ui_release", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock$ui_release", "onAttach", "", "intermediateMeasure", "Landroidx/compose/ui/layout/MeasureScope;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "intermediateMeasure-Te-uZzU", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;JJJ)Landroidx/compose/ui/layout/MeasureResult;", "maxIntermediateIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntermediateIntrinsicHeight$ui_release", "maxIntermediateIntrinsicWidth", "height", "maxIntermediateIntrinsicWidth$ui_release", "measure", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntermediateIntrinsicHeight", "minIntermediateIntrinsicHeight$ui_release", "minIntermediateIntrinsicWidth", "minIntermediateIntrinsicWidth$ui_release", "IntermediateMeasurablePlaceable", "IntermediateMeasureScopeImpl", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifierNode.kt */
public final class IntermediateLayoutModifierNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public LookaheadScope closestLookaheadScope;
    private IntermediateMeasurablePlaceable intermediateMeasurable;
    /* access modifiers changed from: private */
    public final IntermediateMeasureScopeImpl intermediateMeasureScope = new IntermediateMeasureScopeImpl();
    private boolean isIntermediateChangeActive;
    private final LookaheadScopeImpl localLookaheadScope;
    /* access modifiers changed from: private */
    public Constraints lookaheadConstraints;
    private Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> measureBlock;

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

    public final Function3<IntermediateMeasureScope, Measurable, Constraints, MeasureResult> getMeasureBlock$ui_release() {
        return this.measureBlock;
    }

    public final void setMeasureBlock$ui_release(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        this.measureBlock = function3;
    }

    public IntermediateLayoutModifierNode(Function3<? super IntermediateMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        this.measureBlock = function3;
        LookaheadScopeImpl lookaheadScopeImpl = new LookaheadScopeImpl(new IntermediateLayoutModifierNode$localLookaheadScope$1(this));
        this.localLookaheadScope = lookaheadScopeImpl;
        this.closestLookaheadScope = lookaheadScopeImpl;
        this.isIntermediateChangeActive = true;
    }

    public final boolean isIntermediateChangeActive() {
        return this.isIntermediateChangeActive;
    }

    public final void setIntermediateChangeActive(boolean z) {
        this.isIntermediateChangeActive = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getLookaheadDelegate();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttach() {
        /*
            r12 = this;
            androidx.compose.ui.node.NodeCoordinator r0 = r12.getCoordinator$ui_release()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            androidx.compose.ui.node.LookaheadDelegate r0 = r0.getLookaheadDelegate()
            if (r0 == 0) goto L_0x0012
            androidx.compose.ui.layout.LookaheadLayoutCoordinates r0 = r0.getLookaheadLayoutCoordinates()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            if (r0 == 0) goto L_0x00f8
            r0 = r12
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            androidx.compose.ui.node.LayoutNode r2 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
            androidx.compose.ui.node.LayoutNode r2 = r2.getLookaheadRoot$ui_release()
            r3 = 1
            if (r2 == 0) goto L_0x0039
            boolean r4 = r2.isVirtualLookaheadRoot$ui_release()
            if (r4 != r3) goto L_0x0039
            androidx.compose.ui.layout.LookaheadScopeImpl r0 = new androidx.compose.ui.layout.LookaheadScopeImpl
            androidx.compose.ui.layout.IntermediateLayoutModifierNode$onAttach$2 r1 = new androidx.compose.ui.layout.IntermediateLayoutModifierNode$onAttach$2
            r1.<init>(r2)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r0.<init>(r1)
            androidx.compose.ui.layout.LookaheadScope r0 = (androidx.compose.ui.layout.LookaheadScope) r0
            goto L_0x00e8
        L_0x0039:
            r2 = 512(0x200, float:7.175E-43)
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r4 = r0.getNode()
            boolean r4 = r4.isAttached()
            if (r4 == 0) goto L_0x00eb
            androidx.compose.ui.Modifier$Node r4 = r0.getNode()
            androidx.compose.ui.Modifier$Node r4 = r4.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
            r5 = r1
        L_0x0056:
            if (r0 == 0) goto L_0x00de
            androidx.compose.ui.node.NodeChain r6 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r6 = r6.getHead$ui_release()
            int r6 = r6.getAggregateChildKindSet$ui_release()
            r6 = r6 & r2
            if (r6 == 0) goto L_0x00c9
        L_0x0067:
            if (r4 == 0) goto L_0x00c9
            int r6 = r4.getKindSet$ui_release()
            r6 = r6 & r2
            if (r6 == 0) goto L_0x00c4
            r7 = r1
            r6 = r4
        L_0x0072:
            if (r6 == 0) goto L_0x00c4
            boolean r8 = r6 instanceof androidx.compose.ui.layout.IntermediateLayoutModifierNode
            if (r8 == 0) goto L_0x007c
            androidx.compose.ui.layout.IntermediateLayoutModifierNode r6 = (androidx.compose.ui.layout.IntermediateLayoutModifierNode) r6
            r5 = r6
            goto L_0x00bf
        L_0x007c:
            int r8 = r6.getKindSet$ui_release()
            r8 = r8 & r2
            if (r8 == 0) goto L_0x00bf
            boolean r8 = r6 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x00bf
            r8 = r6
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = 0
            r10 = r9
        L_0x0090:
            if (r8 == 0) goto L_0x00bc
            int r11 = r8.getKindSet$ui_release()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x00b7
            int r10 = r10 + 1
            if (r10 != r3) goto L_0x009f
            r6 = r8
            goto L_0x00b7
        L_0x009f:
            if (r7 != 0) goto L_0x00aa
            androidx.compose.runtime.collection.MutableVector r7 = new androidx.compose.runtime.collection.MutableVector
            r11 = 16
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r11]
            r7.<init>(r11, r9)
        L_0x00aa:
            if (r6 == 0) goto L_0x00b2
            if (r7 == 0) goto L_0x00b1
            r7.add(r6)
        L_0x00b1:
            r6 = r1
        L_0x00b2:
            if (r7 == 0) goto L_0x00b7
            r7.add(r8)
        L_0x00b7:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x0090
        L_0x00bc:
            if (r10 != r3) goto L_0x00bf
            goto L_0x0072
        L_0x00bf:
            androidx.compose.ui.Modifier$Node r6 = androidx.compose.ui.node.DelegatableNodeKt.pop(r7)
            goto L_0x0072
        L_0x00c4:
            androidx.compose.ui.Modifier$Node r4 = r4.getParent$ui_release()
            goto L_0x0067
        L_0x00c9:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00db
            androidx.compose.ui.node.NodeChain r4 = r0.getNodes$ui_release()
            if (r4 == 0) goto L_0x00db
            androidx.compose.ui.Modifier$Node r4 = r4.getTail$ui_release()
            goto L_0x0056
        L_0x00db:
            r4 = r1
            goto L_0x0056
        L_0x00de:
            if (r5 == 0) goto L_0x00e4
            androidx.compose.ui.layout.LookaheadScopeImpl r0 = r5.localLookaheadScope
            if (r0 != 0) goto L_0x00e6
        L_0x00e4:
            androidx.compose.ui.layout.LookaheadScopeImpl r0 = r12.localLookaheadScope
        L_0x00e6:
            androidx.compose.ui.layout.LookaheadScope r0 = (androidx.compose.ui.layout.LookaheadScope) r0
        L_0x00e8:
            r12.closestLookaheadScope = r0
            return
        L_0x00eb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "visitAncestors called on an unattached node"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "could not fetch lookahead coordinates"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.IntermediateLayoutModifierNode.onAttach():void");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m5283measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r9 = measurable.m5368measureBRTryo0(j);
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new IntermediateLayoutModifierNode$measure$1$1(r9), 4, (Object) null);
    }

    /* renamed from: intermediateMeasure-Te-uZzU  reason: not valid java name */
    public final MeasureResult m5282intermediateMeasureTeuZzU(MeasureScope measureScope, Measurable measurable, long j, long j2, long j3) {
        this.intermediateMeasureScope.m5290setLookaheadSizeozmzZPI(j2);
        this.lookaheadConstraints = Constraints.m6514boximpl(j3);
        IntermediateMeasurablePlaceable intermediateMeasurablePlaceable = this.intermediateMeasurable;
        if (intermediateMeasurablePlaceable == null) {
            intermediateMeasurablePlaceable = new IntermediateMeasurablePlaceable(measurable);
        }
        this.intermediateMeasurable = intermediateMeasurablePlaceable;
        intermediateMeasurablePlaceable.setWrappedMeasurable(measurable);
        return (MeasureResult) this.measureBlock.invoke(this.intermediateMeasureScope, intermediateMeasurablePlaceable, Constraints.m6514boximpl(j));
    }

    public final int minIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new IntermediateLayoutModifierNode$minIntermediateIntrinsicWidth$1(this), intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final int minIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new IntermediateLayoutModifierNode$minIntermediateIntrinsicHeight$1(this), intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final int maxIntermediateIntrinsicWidth$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new IntermediateLayoutModifierNode$maxIntermediateIntrinsicWidth$1(this), intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final int maxIntermediateIntrinsicHeight$ui_release(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new IntermediateLayoutModifierNode$maxIntermediateIntrinsicHeight$1(this), intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J=\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0019\u0010'\u001a\u0015\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"\u0018\u00010(¢\u0006\u0002\b*H\u0014ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasurablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "wrappedMeasurable", "(Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;Landroidx/compose/ui/layout/Measurable;)V", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWrappedMeasurable", "()Landroidx/compose/ui/layout/Measurable;", "setWrappedMeasurable", "(Landroidx/compose/ui/layout/Measurable;)V", "wrappedPlaceable", "getWrappedPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "setWrappedPlaceable", "(Landroidx/compose/ui/layout/Placeable;)V", "get", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeAt", "", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IntermediateLayoutModifierNode.kt */
    private final class IntermediateMeasurablePlaceable extends Placeable implements Measurable {
        private Measurable wrappedMeasurable;
        private Placeable wrappedPlaceable;

        public IntermediateMeasurablePlaceable(Measurable measurable) {
            this.wrappedMeasurable = measurable;
        }

        public final Measurable getWrappedMeasurable() {
            return this.wrappedMeasurable;
        }

        public final void setWrappedMeasurable(Measurable measurable) {
            this.wrappedMeasurable = measurable;
        }

        public final Placeable getWrappedPlaceable() {
            return this.wrappedPlaceable;
        }

        public final void setWrappedPlaceable(Placeable placeable) {
            this.wrappedPlaceable = placeable;
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m5284measureBRTryo0(long j) {
            Placeable placeable;
            long j2;
            if (IntermediateLayoutModifierNode.this.isIntermediateChangeActive()) {
                placeable = this.wrappedMeasurable.m5368measureBRTryo0(j);
                m5408setMeasurementConstraintsBRTryo0(j);
                m5407setMeasuredSizeozmzZPI(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()));
            } else {
                Measurable measurable = this.wrappedMeasurable;
                Constraints access$getLookaheadConstraints$p = IntermediateLayoutModifierNode.this.lookaheadConstraints;
                Intrinsics.checkNotNull(access$getLookaheadConstraints$p);
                placeable = measurable.m5368measureBRTryo0(access$getLookaheadConstraints$p.m6532unboximpl());
                IntermediateLayoutModifierNode intermediateLayoutModifierNode = IntermediateLayoutModifierNode.this;
                Constraints access$getLookaheadConstraints$p2 = intermediateLayoutModifierNode.lookaheadConstraints;
                Intrinsics.checkNotNull(access$getLookaheadConstraints$p2);
                m5408setMeasurementConstraintsBRTryo0(access$getLookaheadConstraints$p2.m6532unboximpl());
                if (intermediateLayoutModifierNode.isIntermediateChangeActive()) {
                    j2 = IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight());
                } else {
                    j2 = intermediateLayoutModifierNode.intermediateMeasureScope.m5286getLookaheadSizeYbymL2g();
                }
                m5407setMeasuredSizeozmzZPI(j2);
            }
            this.wrappedPlaceable = placeable;
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m5285placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Unit unit;
            if (!IntermediateLayoutModifierNode.this.isIntermediateChangeActive()) {
                j = IntOffset.Companion.m6758getZeronOccac();
            }
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getNode().getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            Placeable.PlacementScope placementScope = coordinator$ui_release.getPlacementScope();
            if (function1 != null) {
                Placeable placeable = this.wrappedPlaceable;
                if (placeable != null) {
                    placementScope.m5418placeWithLayeraW9wM(placeable, j, f, function1);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            Placeable placeable2 = this.wrappedPlaceable;
            if (placeable2 != null) {
                placementScope.m5413place70tqf50(placeable2, j, f);
                Unit unit2 = Unit.INSTANCE;
            }
        }

        public Object getParentData() {
            return this.wrappedMeasurable.getParentData();
        }

        public int get(AlignmentLine alignmentLine) {
            Placeable placeable = this.wrappedPlaceable;
            Intrinsics.checkNotNull(placeable);
            return placeable.get(alignmentLine);
        }

        public int minIntrinsicWidth(int i) {
            return this.wrappedMeasurable.minIntrinsicWidth(i);
        }

        public int maxIntrinsicWidth(int i) {
            return this.wrappedMeasurable.maxIntrinsicWidth(i);
        }

        public int minIntrinsicHeight(int i) {
            return this.wrappedMeasurable.minIntrinsicHeight(i);
        }

        public int maxIntrinsicHeight(int i) {
            return this.wrappedMeasurable.maxIntrinsicHeight(i);
        }
    }

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003JE\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020$0'2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\u0016J\f\u0010-\u001a\u00020\u001d*\u00020\u001dH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u0016X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u00020\u001d*\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl;", "Landroidx/compose/ui/layout/IntermediateMeasureScope;", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/layout/IntermediateLayoutModifierNode;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "()J", "setLookaheadSize-ozmzZPI", "(J)V", "J", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IntermediateLayoutModifierNode.kt */
    private final class IntermediateMeasureScopeImpl implements IntermediateMeasureScope, CoroutineScope {
        private long lookaheadSize = IntSize.Companion.m6795getZeroYbymL2g();

        public boolean isLookingAhead() {
            return false;
        }

        /* renamed from: localLookaheadPositionOf-dBAh8RU  reason: not valid java name */
        public /* synthetic */ long m5287localLookaheadPositionOfdBAh8RU(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
            return LookaheadScope.CC.m5366$default$localLookaheadPositionOfdBAh8RU(this, layoutCoordinates, layoutCoordinates2);
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public /* synthetic */ int m5288roundToPxR2X_6o(long j) {
            return Density.CC.m6554$default$roundToPxR2X_6o(this, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public /* synthetic */ int m5289roundToPx0680j_4(float f) {
            return Density.CC.m6555$default$roundToPx0680j_4(this, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public /* synthetic */ float m5291toDpGaN1DYA(long j) {
            return FontScaling.CC.m6725$default$toDpGaN1DYA(this, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public /* synthetic */ float m5292toDpu2uoSUM(float f) {
            return Density.CC.m6556$default$toDpu2uoSUM((Density) this, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public /* synthetic */ float m5293toDpu2uoSUM(int i) {
            return Density.CC.m6557$default$toDpu2uoSUM((Density) this, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public /* synthetic */ long m5294toDpSizekrfVVM(long j) {
            return Density.CC.m6558$default$toDpSizekrfVVM(this, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public /* synthetic */ float m5295toPxR2X_6o(long j) {
            return Density.CC.m6559$default$toPxR2X_6o(this, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public /* synthetic */ float m5296toPx0680j_4(float f) {
            return Density.CC.m6560$default$toPx0680j_4(this, f);
        }

        public /* synthetic */ Rect toRect(DpRect dpRect) {
            return Density.CC.$default$toRect(this, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public /* synthetic */ long m5297toSizeXkaWNTQ(long j) {
            return Density.CC.m6561$default$toSizeXkaWNTQ(this, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public /* synthetic */ long m5298toSp0xMU5do(float f) {
            return FontScaling.CC.m6726$default$toSp0xMU5do(this, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public /* synthetic */ long m5299toSpkPz2Gy4(float f) {
            return Density.CC.m6562$default$toSpkPz2Gy4((Density) this, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public /* synthetic */ long m5300toSpkPz2Gy4(int i) {
            return Density.CC.m6563$default$toSpkPz2Gy4((Density) this, i);
        }

        public IntermediateMeasureScopeImpl() {
        }

        /* renamed from: getLookaheadSize-YbymL2g  reason: not valid java name */
        public long m5286getLookaheadSizeYbymL2g() {
            return this.lookaheadSize;
        }

        /* renamed from: setLookaheadSize-ozmzZPI  reason: not valid java name */
        public void m5290setLookaheadSizeozmzZPI(long j) {
            this.lookaheadSize = j;
        }

        public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates) {
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.toLookaheadCoordinates(layoutCoordinates);
        }

        public LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope) {
            return IntermediateLayoutModifierNode.this.closestLookaheadScope.getLookaheadScopeCoordinates(placementScope);
        }

        public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            if ((i & ViewCompat.MEASURED_STATE_MASK) == 0 && (-16777216 & i2) == 0) {
                return new IntermediateLayoutModifierNode$IntermediateMeasureScopeImpl$layout$1(i, i2, map, function1, IntermediateLayoutModifierNode.this);
            }
            throw new IllegalStateException(("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.").toString());
        }

        public LayoutDirection getLayoutDirection() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getLayoutDirection();
        }

        public float getDensity() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getDensity();
        }

        public float getFontScale() {
            NodeCoordinator coordinator$ui_release = IntermediateLayoutModifierNode.this.getCoordinator$ui_release();
            Intrinsics.checkNotNull(coordinator$ui_release);
            return coordinator$ui_release.getFontScale();
        }

        public CoroutineContext getCoroutineContext() {
            return IntermediateLayoutModifierNode.this.getCoroutineScope().getCoroutineContext();
        }
    }
}
