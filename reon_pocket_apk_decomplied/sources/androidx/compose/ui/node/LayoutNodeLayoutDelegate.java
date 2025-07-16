package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001:\u0002^_B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010I\u001a\u00020DH\u0000¢\u0006\u0002\bJJ\u0006\u0010K\u001a\u00020DJ\u0006\u0010L\u001a\u00020DJ\r\u0010M\u001a\u00020DH\u0000¢\u0006\u0002\bNJ\r\u0010O\u001a\u00020DH\u0000¢\u0006\u0002\bPJ\r\u0010Q\u001a\u00020DH\u0000¢\u0006\u0002\bRJ\r\u0010S\u001a\u00020DH\u0000¢\u0006\u0002\bTJ\u0006\u0010U\u001a\u00020DJ\u001a\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\u001a\u0010Z\u001a\u00020D2\u0006\u0010W\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b[\u0010YJ\u0006\u0010\\\u001a\u00020DJ\u0006\u0010]\u001a\u00020DR\u0014\u0010\u0005\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u0004\u0018\u00010\u001f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b#\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0013R\u000e\u0010&\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020'@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0013R\u000e\u0010/\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0013R*\u00103\u001a\b\u0018\u000102R\u00020\u00002\f\u0010\u0019\u001a\b\u0018\u000102R\u00020\u0000@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0018\u00106\u001a\u000607R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001e\u0010:\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0013R\u000e\u0010<\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010>\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\u00020\u001fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010FR\u0014\u0010G\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006`"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui_release", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "value", "", "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "()I", "setChildrenAccessingCoordinatesDuringPlacement", "(I)V", "", "coordinatesAccessedDuringModifierPlacement", "getCoordinatesAccessedDuringModifierPlacement", "()Z", "setCoordinatesAccessedDuringModifierPlacement", "(Z)V", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "setCoordinatesAccessedDuringPlacement", "<set-?>", "detachedFromParentLookaheadPass", "getDetachedFromParentLookaheadPass$ui_release", "height", "getHeight$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui_release", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPendingForAlignment", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "nextChildLookaheadPlaceOrder", "nextChildPlaceOrder", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "performMeasureBlock", "Lkotlin/Function0;", "", "performMeasureConstraints", "J", "width", "getWidth$ui_release", "ensureLookaheadDelegateCreated", "ensureLookaheadDelegateCreated$ui_release", "invalidateParentData", "markChildrenDirty", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "onCoordinatesUsed", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0", "(J)V", "performMeasure", "performMeasure-BRTryo0", "resetAlignmentLines", "updateParentData", "LookaheadPassDelegate", "MeasurePassDelegate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
public final class LayoutNodeLayoutDelegate {
    public static final int $stable = 8;
    private int childrenAccessingCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringModifierPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    /* access modifiers changed from: private */
    public boolean detachedFromParentLookaheadPass;
    /* access modifiers changed from: private */
    public final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public boolean layoutPending;
    /* access modifiers changed from: private */
    public boolean layoutPendingForAlignment;
    /* access modifiers changed from: private */
    public LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Idle;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPending;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    private LookaheadPassDelegate lookaheadPassDelegate;
    private final MeasurePassDelegate measurePassDelegate = new MeasurePassDelegate();
    private boolean measurePending;
    /* access modifiers changed from: private */
    public int nextChildLookaheadPlaceOrder;
    /* access modifiers changed from: private */
    public int nextChildPlaceOrder;
    private final Function0<Unit> performMeasureBlock = new LayoutNodeLayoutDelegate$performMeasureBlock$1(this);
    /* access modifiers changed from: private */
    public long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode2) {
        this.layoutNode = layoutNode2;
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes$ui_release().getOuterCoordinator$ui_release();
    }

    /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m5554getLastConstraintsDWUhwKw() {
        return this.measurePassDelegate.m5562getLastConstraintsDWUhwKw();
    }

    /* renamed from: getLastLookaheadConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m5555getLastLookaheadConstraintsDWUhwKw() {
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            return lookaheadPassDelegate2.m5556getLastConstraintsDWUhwKw();
        }
        return null;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    public final boolean getDetachedFromParentLookaheadPass$ui_release() {
        return this.detachedFromParentLookaheadPass;
    }

    public final LayoutNode.LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.lookaheadMeasurePending;
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.lookaheadLayoutPending;
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return this.measurePassDelegate;
    }

    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean z) {
        if (this.coordinatesAccessedDuringPlacement != z) {
            this.coordinatesAccessedDuringPlacement = z;
            if (z && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else if (!z && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final boolean getCoordinatesAccessedDuringModifierPlacement() {
        return this.coordinatesAccessedDuringModifierPlacement;
    }

    public final void setCoordinatesAccessedDuringModifierPlacement(boolean z) {
        if (this.coordinatesAccessedDuringModifierPlacement != z) {
            this.coordinatesAccessedDuringModifierPlacement = z;
            if (z && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else if (!z && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int i) {
        int i2 = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = i;
        boolean z = false;
        boolean z2 = i2 == 0;
        if (i == 0) {
            z = true;
        }
        if (z2 != z) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate layoutDelegate$ui_release = parent$ui_release != null ? parent$ui_release.getLayoutDelegate$ui_release() : null;
            if (layoutDelegate$ui_release == null) {
                return;
            }
            if (i == 0) {
                layoutDelegate$ui_release.setChildrenAccessingCoordinatesDuringPlacement(layoutDelegate$ui_release.childrenAccessingCoordinatesDuringPlacement - 1);
            } else {
                layoutDelegate$ui_release.setChildrenAccessingCoordinatesDuringPlacement(layoutDelegate$ui_release.childrenAccessingCoordinatesDuringPlacement + 1);
            }
        }
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.measurePassDelegate;
    }

    public final LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final void onCoordinatesUsed() {
        LayoutNode.LayoutState layoutState$ui_release = this.layoutNode.getLayoutState$ui_release();
        if (layoutState$ui_release == LayoutNode.LayoutState.LayingOut || layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
            if (this.measurePassDelegate.getLayingOutChildren()) {
                setCoordinatesAccessedDuringPlacement(true);
            } else {
                setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }
        if (layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
            LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
            if (lookaheadPassDelegate2 == null || !lookaheadPassDelegate2.getLayingOutChildren()) {
                setCoordinatesAccessedDuringModifierPlacement(true);
            } else {
                setCoordinatesAccessedDuringPlacement(true);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010W\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020;0XH\u0016J\b\u0010Z\u001a\u00020)H\u0002J\b\u0010[\u001a\u00020)H\u0002J\u001c\u0010\\\u001a\u00020)2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0'H\u0016J!\u0010^\u001a\u00020)2\u0016\u0010]\u001a\u0012\u0012\b\u0012\u00060\u0000R\u00020\u0007\u0012\u0004\u0012\u00020)0'H\bJ\u0011\u0010_\u001a\u00020;2\u0006\u0010`\u001a\u00020YH\u0002J\u000e\u0010a\u001a\u00020)2\u0006\u0010b\u001a\u00020\u0011J\u0006\u0010c\u001a\u00020)J\b\u0010d\u001a\u00020)H\u0016J\r\u0010e\u001a\u00020)H\u0000¢\u0006\u0002\bfJ\b\u0010g\u001a\u00020)H\u0002J\b\u0010h\u001a\u00020)H\u0002J\u0010\u0010i\u001a\u00020;2\u0006\u0010j\u001a\u00020;H\u0016J\u0010\u0010k\u001a\u00020;2\u0006\u0010l\u001a\u00020;H\u0016J\u001a\u0010m\u001a\u00020\u00022\u0006\u0010n\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ\u0006\u0010q\u001a\u00020)J\u0010\u0010r\u001a\u00020;2\u0006\u0010j\u001a\u00020;H\u0016J\u0010\u0010s\u001a\u00020;2\u0006\u0010l\u001a\u00020;H\u0016J\u0006\u0010t\u001a\u00020)J\b\u0010u\u001a\u00020)H\u0002J\b\u0010v\u001a\u00020)H\u0002J\u0006\u0010w\u001a\u00020)J\r\u0010x\u001a\u00020)H\u0000¢\u0006\u0002\byJ=\u0010z\u001a\u00020)2\u0006\u0010{\u001a\u00020,2\u0006\u0010T\u001a\u00020/2\u0019\u0010|\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'¢\u0006\u0002\b*H\u0014ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\u0006\u0010\u001a\u00020)J?\u0010\u0001\u001a\u00020)2\u0006\u0010{\u001a\u00020,2\u0006\u0010T\u001a\u00020/2\u0019\u0010|\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'¢\u0006\u0002\b*H\u0002ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010~J\u001b\u0010\u0001\u001a\u00020\u00112\u0006\u0010n\u001a\u00020#ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020)J\t\u0010\u0001\u001a\u00020)H\u0016J\t\u0010\u0001\u001a\u00020)H\u0016J\u0013\u0010\u0001\u001a\u00020)2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020\u0011R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011@PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R$\u0010 \u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u0019\u0010\"\u001a\u0004\u0018\u00010#8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b$\u0010%R!\u0010&\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'¢\u0006\u0002\b*X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\u00020,X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0013R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020)03X\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020;8VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020;8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010=R\u000e\u0010A\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\"\u0010F\u001a\u0004\u0018\u00010E2\b\u0010\u001d\u001a\u0004\u0018\u00010E@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010J\u001a\u00020;2\u0006\u0010\u001d\u001a\u00020;@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u0010=R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020)03X\u0004¢\u0006\u0002\n\u0000R!\u0010M\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'¢\u0006\u0002\b*X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\u00020,X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010O\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Q\u001a\u00020;2\u0006\u0010\u001d\u001a\u00020;@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bR\u0010=R\u000e\u0010S\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010T\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020/@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010V\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "<set-?>", "isPlaced", "setPlaced$ui_release", "isPlacedByParent", "setPlacedByParent$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "layingOutChildren", "getLayingOutChildren", "layoutChildrenBlock", "Lkotlin/Function0;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "onNodePlacedCalled", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placeOrder", "getPlaceOrder$ui_release", "placeOuterCoordinatorBlock", "placeOuterCoordinatorLayerBlock", "placeOuterCoordinatorPosition", "placeOuterCoordinatorZIndex", "placedOnce", "previousPlaceOrder", "getPreviousPlaceOrder$ui_release", "relayoutWithoutParentInProgress", "zIndex", "getZIndex$ui_release", "()F", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markDetachedFromParentLookaheadPass", "markDetachedFromParentLookaheadPass$ui_release", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measureBasedOnLookahead", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "placeAt", "position", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeBasedOnLookahead", "placeOuterCoordinator", "placeOuterCoordinator-f8xVGno", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackMeasurementByParent", "node", "Landroidx/compose/ui/node/LayoutNode;", "updateParentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNodeLayoutDelegate.kt */
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private final MutableVector<MeasurePassDelegate> _childDelegates = new MutableVector<>(new MeasurePassDelegate[16], 0);
        private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
        private boolean childDelegatesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private boolean isPlacedByParent;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition = IntOffset.Companion.m6758getZeronOccac();
        private float lastZIndex;
        private boolean layingOutChildren;
        private final Function0<Unit> layoutChildrenBlock = new LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1(this);
        private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
        private boolean measuredOnce;
        private boolean onNodePlacedCalled;
        private Object parentData;
        private boolean parentDataDirty = true;
        private int placeOrder = Integer.MAX_VALUE;
        private final Function0<Unit> placeOuterCoordinatorBlock;
        /* access modifiers changed from: private */
        public Function1<? super GraphicsLayerScope, Unit> placeOuterCoordinatorLayerBlock;
        /* access modifiers changed from: private */
        public long placeOuterCoordinatorPosition = IntOffset.Companion.m6758getZeronOccac();
        /* access modifiers changed from: private */
        public float placeOuterCoordinatorZIndex;
        private boolean placedOnce;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private boolean relayoutWithoutParentInProgress;
        private float zIndex;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LayoutNodeLayoutDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
            static {
                /*
                    androidx.compose.ui.node.LayoutNode$LayoutState[] r0 = androidx.compose.ui.node.LayoutNode.LayoutState.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    r1 = 1
                    androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    r2 = 2
                    androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    androidx.compose.ui.node.LayoutNode$UsageByParent[] r0 = androidx.compose.ui.node.LayoutNode.UsageByParent.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.compose.ui.node.LayoutNode$UsageByParent r3 = androidx.compose.ui.node.LayoutNode.UsageByParent.InMeasureBlock     // Catch:{ NoSuchFieldError -> 0x002a }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                    r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
                L_0x002a:
                    androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.InLayoutBlock     // Catch:{ NoSuchFieldError -> 0x0032 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
                L_0x0032:
                    $EnumSwitchMapping$1 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate.WhenMappings.<clinit>():void");
            }
        }

        public MeasurePassDelegate() {
            this.placeOuterCoordinatorBlock = new LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1(LayoutNodeLayoutDelegate.this, this);
        }

        public final int getPreviousPlaceOrder$ui_release() {
            return this.previousPlaceOrder;
        }

        public final int getPlaceOrder$ui_release() {
            return this.placeOrder;
        }

        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m5562getLastConstraintsDWUhwKw() {
            if (this.measuredOnce) {
                return Constraints.m6514boximpl(m5405getMeasurementConstraintsmsEJaDk());
            }
            return null;
        }

        public final LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
            return this.measuredByParent;
        }

        public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
            this.measuredByParent = usageByParent;
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        public Object getParentData() {
            return this.parentData;
        }

        public boolean isPlaced() {
            return this.isPlaced;
        }

        public void setPlaced$ui_release(boolean z) {
            this.isPlaced = z;
        }

        public final boolean isPlacedByParent() {
            return this.isPlacedByParent;
        }

        public final void setPlacedByParent$ui_release(boolean z) {
            this.isPlacedByParent = z;
        }

        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final boolean getChildDelegatesDirty$ui_release() {
            return this.childDelegatesDirty;
        }

        public final void setChildDelegatesDirty$ui_release(boolean z) {
            this.childDelegatesDirty = z;
        }

        public final List<MeasurePassDelegate> getChildDelegates$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.updateChildrenIfDirty$ui_release();
            if (!this.childDelegatesDirty) {
                return this._childDelegates.asMutableList();
            }
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector<MeasurePassDelegate> mutableVector = this._childDelegates;
            MutableVector<LayoutNode> mutableVector2 = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector2.getSize();
            if (size > 0) {
                Object[] content = mutableVector2.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (mutableVector.getSize() <= i) {
                        mutableVector.add(layoutNode.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                    } else {
                        mutableVector.set(i, layoutNode.getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release());
                    }
                    i++;
                } while (i < size);
            }
            mutableVector.removeRange(access$getLayoutNode$p.getChildren$ui_release().size(), mutableVector.getSize());
            this.childDelegatesDirty = false;
            return this._childDelegates.asMutableList();
        }

        public final void markDetachedFromParentLookaheadPass$ui_release() {
            LayoutNodeLayoutDelegate.this.detachedFromParentLookaheadPass = true;
        }

        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        public void layoutChildren() {
            this.layingOutChildren = true;
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            if (LayoutNodeLayoutDelegate.this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release())) {
                LayoutNodeLayoutDelegate.this.layoutPending = false;
                LayoutNode.LayoutState layoutState$ui_release = LayoutNodeLayoutDelegate.this.getLayoutState$ui_release();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                LayoutNodeKt.requireOwner(access$getLayoutNode$p).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(access$getLayoutNode$p, false, this.layoutChildrenBlock);
                LayoutNodeLayoutDelegate.this.layoutState = layoutState$ui_release;
                if (getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.layoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
            this.layingOutChildren = false;
        }

        /* access modifiers changed from: private */
        public final void checkChildrenPlaceOrderForUpdates() {
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector<LayoutNode> mutableVector = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (layoutNode.getMeasurePassDelegate$ui_release().previousPlaceOrder != layoutNode.getPlaceOrder$ui_release()) {
                        access$getLayoutNode$p.onZSortedChildrenInvalidated$ui_release();
                        access$getLayoutNode$p.invalidateLayer$ui_release();
                        if (layoutNode.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                            layoutNode.getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                        }
                    }
                    i++;
                } while (i < size);
            }
        }

        private final void markSubtreeAsNotPlaced() {
            if (isPlaced()) {
                int i = 0;
                setPlaced$ui_release(false);
                MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    do {
                        ((LayoutNode) content[i]).getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                        i++;
                    } while (i < size);
                }
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            boolean isPlaced2 = isPlaced();
            setPlaced$ui_release(true);
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            int i = 0;
            if (!isPlaced2) {
                if (access$getLayoutNode$p.getMeasurePending$ui_release()) {
                    LayoutNode.requestRemeasure$ui_release$default(access$getLayoutNode$p, true, false, 2, (Object) null);
                } else if (access$getLayoutNode$p.getLookaheadMeasurePending$ui_release()) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(access$getLayoutNode$p, true, false, 2, (Object) null);
                }
            }
            NodeCoordinator outerCoordinator$ui_release = access$getLayoutNode$p.getOuterCoordinator$ui_release();
            NodeCoordinator wrapped$ui_release = access$getLayoutNode$p.getInnerCoordinator$ui_release().getWrapped$ui_release();
            while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
                if (outerCoordinator$ui_release.getLastLayerDrawingWasSkipped$ui_release()) {
                    outerCoordinator$ui_release.invalidateLayer();
                }
                outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
            }
            MutableVector<LayoutNode> mutableVector = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (layoutNode.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                        layoutNode.getMeasurePassDelegate$ui_release().markNodeAndSubtreeAsPlaced();
                        access$getLayoutNode$p.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                    }
                    i++;
                } while (i < size);
            }
        }

        public final float getZIndex$ui_release() {
            return this.zIndex;
        }

        public final void onNodePlaced$ui_release() {
            this.onNodePlacedCalled = true;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            float zIndex2 = getInnerCoordinator().getZIndex();
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            NodeCoordinator outerCoordinator$ui_release = access$getLayoutNode$p.getOuterCoordinator$ui_release();
            NodeCoordinator innerCoordinator$ui_release = access$getLayoutNode$p.getInnerCoordinator$ui_release();
            while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
                Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
                zIndex2 += layoutModifierNodeCoordinator.getZIndex();
                outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
            }
            if (zIndex2 != this.zIndex) {
                this.zIndex = zIndex2;
                if (parent$ui_release != null) {
                    parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                }
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
            }
            if (!isPlaced()) {
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
                markNodeAndSubtreeAsPlaced();
                if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                    LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, (Object) null);
                }
            }
            if (parent$ui_release == null) {
                this.placeOrder = 0;
            } else if (!this.relayoutWithoutParentInProgress && parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                if (this.placeOrder == Integer.MAX_VALUE) {
                    this.placeOrder = parent$ui_release.getLayoutDelegate$ui_release().nextChildPlaceOrder;
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release();
                    layoutDelegate$ui_release.nextChildPlaceOrder = layoutDelegate$ui_release.nextChildPlaceOrder + 1;
                } else {
                    throw new IllegalStateException("Place was called on a node which was placed already".toString());
                }
            }
            layoutChildren();
        }

        /* access modifiers changed from: private */
        public final void clearPlaceOrder() {
            LayoutNodeLayoutDelegate.this.nextChildPlaceOrder = 0;
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    MeasurePassDelegate measurePassDelegate$ui_release = ((LayoutNode) content[i]).getMeasurePassDelegate$ui_release();
                    measurePassDelegate$ui_release.previousPlaceOrder = measurePassDelegate$ui_release.placeOrder;
                    measurePassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
                    measurePassDelegate$ui_release.isPlacedByParent = false;
                    if (measurePassDelegate$ui_release.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                        measurePassDelegate$ui_release.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                    }
                    i++;
                } while (i < size);
            }
        }

        private final void forEachChildDelegate(Function1<? super MeasurePassDelegate, Unit> function1) {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    function1.invoke(((LayoutNode) content[i]).getMeasurePassDelegate$ui_release());
                    i++;
                } while (i < size);
            }
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m5563measureBRTryo0(long j) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.this.layoutNode)) {
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                lookaheadPassDelegate$ui_release.m5558measureBRTryo0(j);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            m5565remeasureBRTryo0(j);
            return this;
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m5565remeasureBRTryo0(long j) {
            boolean z = true;
            if (!LayoutNodeLayoutDelegate.this.layoutNode.isDeactivated()) {
                Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
                LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()));
                if (LayoutNodeLayoutDelegate.this.layoutNode.getMeasurePending$ui_release() || !Constraints.m6519equalsimpl0(m5405getMeasurementConstraintsmsEJaDk(), j)) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
                    forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2.INSTANCE);
                    this.measuredOnce = true;
                    long r2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().m5621getSizeYbymL2g();
                    m5408setMeasurementConstraintsBRTryo0(j);
                    LayoutNodeLayoutDelegate.this.m5553performMeasureBRTryo0(j);
                    if (IntSize.m6788equalsimpl0(LayoutNodeLayoutDelegate.this.getOuterCoordinator().m5621getSizeYbymL2g(), r2) && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth() == getWidth() && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight() == getHeight()) {
                        z = false;
                    }
                    m5407setMeasuredSizeozmzZPI(IntSizeKt.IntSize(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight()));
                    return z;
                }
                Owner.CC.forceMeasureTheSubtree$default(requireOwner, LayoutNodeLayoutDelegate.this.layoutNode, false, 2, (Object) null);
                LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                return false;
            }
            throw new IllegalArgumentException("measure is called on a deactivated node".toString());
        }

        private final void trackMeasurementByParent(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release == null) {
                this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            } else if (this.measuredByParent == LayoutNode.UsageByParent.NotUsed || layoutNode.getCanMultiMeasure$ui_release()) {
                int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                if (i == 1) {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                } else if (i == 2) {
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                } else {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                }
                this.measuredByParent = usageByParent;
            } else {
                throw new IllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()".toString());
            }
        }

        public int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        public int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        public int get(AlignmentLine alignmentLine) {
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState = null;
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            int i = LayoutNodeLayoutDelegate.this.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i;
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m5564placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Placeable.PlacementScope placementScope;
            this.isPlacedByParent = true;
            if (!IntOffset.m6747equalsimpl0(j, this.lastPosition)) {
                if (LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringModifierPlacement() || LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    LayoutNodeLayoutDelegate.this.layoutPending = true;
                }
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            boolean z = false;
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.this.layoutNode)) {
                NodeCoordinator wrappedBy$ui_release = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWrappedBy$ui_release();
                if (wrappedBy$ui_release == null || (placementScope = wrappedBy$ui_release.getPlacementScope()) == null) {
                    placementScope = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode).getPlacementScope();
                }
                Placeable.PlacementScope placementScope2 = placementScope;
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNodeLayoutDelegate.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                LayoutNode parent$ui_release = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.getLayoutDelegate$ui_release().nextChildLookaheadPlaceOrder = 0;
                }
                lookaheadPassDelegate$ui_release.setPlaceOrder$ui_release(Integer.MAX_VALUE);
                Placeable.PlacementScope.place$default(placementScope2, lookaheadPassDelegate$ui_release, IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(j), 0.0f, 4, (Object) null);
            }
            LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release2 != null && !lookaheadPassDelegate$ui_release2.getPlacedOnce$ui_release()) {
                z = true;
            }
            if (true ^ z) {
                m5561placeOuterCoordinatorf8xVGno(j, f, function1);
                return;
            }
            throw new IllegalArgumentException("Error: Placement happened before lookahead.".toString());
        }

        /* renamed from: placeOuterCoordinator-f8xVGno  reason: not valid java name */
        private final void m5561placeOuterCoordinatorf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (!LayoutNodeLayoutDelegate.this.layoutNode.isDeactivated()) {
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                this.lastPosition = j;
                this.lastZIndex = f;
                this.lastLayerBlock = function1;
                this.placedOnce = true;
                this.onNodePlacedCalled = false;
                Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
                if (LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release() || !isPlaced()) {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(false);
                    LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringModifierPlacement(false);
                    this.placeOuterCoordinatorLayerBlock = function1;
                    this.placeOuterCoordinatorPosition = j;
                    this.placeOuterCoordinatorZIndex = f;
                    requireOwner.getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(LayoutNodeLayoutDelegate.this.layoutNode, false, this.placeOuterCoordinatorBlock);
                    this.placeOuterCoordinatorLayerBlock = null;
                } else {
                    LayoutNodeLayoutDelegate.this.getOuterCoordinator().m5631placeSelfApparentToRealOffsetf8xVGno(j, f, function1);
                    onNodePlaced$ui_release();
                }
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
                return;
            }
            throw new IllegalArgumentException("place is called on a deactivated node".toString());
        }

        /* JADX INFO: finally extract failed */
        public final void replace() {
            LayoutNode parent$ui_release;
            try {
                this.relayoutWithoutParentInProgress = true;
                if (this.placedOnce) {
                    boolean isPlaced2 = isPlaced();
                    m5561placeOuterCoordinatorf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
                    if (isPlaced2 && !this.onNodePlacedCalled && (parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release()) != null) {
                        LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, (Object) null);
                    }
                    this.relayoutWithoutParentInProgress = false;
                    return;
                }
                throw new IllegalStateException("replace called on unplaced item".toString());
            } catch (Throwable th) {
                this.relayoutWithoutParentInProgress = false;
                throw th;
            }
        }

        public int minIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(i);
        }

        public int maxIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(i);
        }

        public int minIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(i);
        }

        public int maxIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(i);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null && LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                if (i == 1) {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                } else if (i != 2) {
                    usageByParent = parent$ui_release.getIntrinsicsUsageByParent$ui_release();
                } else {
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        public final boolean updateParentData() {
            if ((getParentData() == null && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData() == null) || !this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            this.parentData = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData();
            return true;
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        LayoutNodeLayoutDelegate.this.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(true);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getAlignmentLinesOwner$ui_release();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> function1) {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    function1.invoke(((LayoutNode) content[i]).getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
                    i++;
                } while (i < size);
            }
        }

        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            MutableVector<LayoutNode> mutableVector;
            int size;
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0 && (size = mutableVector.getSize()) > 0) {
                Object[] content = (mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release()).getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                    if ((layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement() || layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, (Object) null);
                    }
                    layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                    i++;
                } while (i < size);
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector<LayoutNode> mutableVector = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (layoutNode.getMeasurePending$ui_release() && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m5506remeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null)) {
                        LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, false, 3, (Object) null);
                    }
                    i++;
                } while (i < size);
            }
        }

        public final void invalidateIntrinsicsParent(boolean z) {
            LayoutNode parent$ui_release;
            LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release2 != null && intrinsicsUsageByParent$ui_release != LayoutNode.UsageByParent.NotUsed) {
                while (parent$ui_release2.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                    parent$ui_release2 = parent$ui_release;
                }
                int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
                if (i == 1) {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, z, false, 2, (Object) null);
                } else if (i == 2) {
                    parent$ui_release2.requestRelayout$ui_release(z);
                } else {
                    throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }

        public final void onNodeDetached() {
            this.placeOrder = Integer.MAX_VALUE;
            this.previousPlaceOrder = Integer.MAX_VALUE;
            setPlaced$ui_release(false);
        }

        public final void measureBasedOnLookahead() {
            LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null) {
                throw new IllegalStateException("layoutNode parent is not set".toString());
            } else if (lookaheadPassDelegate$ui_release == null) {
                throw new IllegalStateException("invalid lookaheadDelegate".toString());
            } else if (lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                Constraints r0 = lookaheadPassDelegate$ui_release.m5556getLastConstraintsDWUhwKw();
                Intrinsics.checkNotNull(r0);
                m5563measureBRTryo0(r0.m6532unboximpl());
            } else if (lookaheadPassDelegate$ui_release.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock && parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                Constraints r02 = lookaheadPassDelegate$ui_release.m5556getLastConstraintsDWUhwKw();
                Intrinsics.checkNotNull(r02);
                m5563measureBRTryo0(r02.m6532unboximpl());
            }
        }

        public final void placeBasedOnLookahead() {
            LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                m5564placeAtf8xVGno(lookaheadPassDelegate$ui_release.m5557getLastPositionnOccac$ui_release(), lookaheadPassDelegate$ui_release.getLastZIndex$ui_release(), lookaheadPassDelegate$ui_release.getLastLayerBlock$ui_release());
                return;
            }
            throw new IllegalStateException("invalid lookaheadDelegate".toString());
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020B0[H\u0016J\b\u0010]\u001a\u00020&H\u0002J\b\u0010^\u001a\u00020&H\u0002J\u001c\u0010_\u001a\u00020&2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&0$H\u0016J!\u0010a\u001a\u00020&2\u0016\u0010`\u001a\u0012\u0012\b\u0012\u00060\u0000R\u00020\u0007\u0012\u0004\u0012\u00020&0$H\bJ\u0011\u0010b\u001a\u00020B2\u0006\u0010c\u001a\u00020\\H\u0002J\u000e\u0010d\u001a\u00020&2\u0006\u0010e\u001a\u00020\u0011J\u0006\u0010f\u001a\u00020&J\b\u0010g\u001a\u00020&H\u0016J\b\u0010h\u001a\u00020&H\u0002J\b\u0010i\u001a\u00020&H\u0002J\u0010\u0010j\u001a\u00020B2\u0006\u0010k\u001a\u00020BH\u0016J\u0010\u0010l\u001a\u00020B2\u0006\u0010m\u001a\u00020BH\u0016J\u001a\u0010n\u001a\u00020\u00012\u0006\u0010o\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u0010\u0010r\u001a\u00020B2\u0006\u0010k\u001a\u00020BH\u0016J\u0010\u0010s\u001a\u00020B2\u0006\u0010m\u001a\u00020BH\u0016J\u0006\u0010t\u001a\u00020&J\b\u0010u\u001a\u00020&H\u0002J\b\u0010v\u001a\u00020&H\u0002J\u0006\u0010w\u001a\u00020&J\r\u0010x\u001a\u00020&H\u0000¢\u0006\u0002\byJ=\u0010z\u001a\u00020&2\u0006\u0010{\u001a\u00020+2\u0006\u0010|\u001a\u0002002\u0019\u0010}\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$¢\u0006\u0002\b'H\u0014ø\u0001\u0000¢\u0006\u0004\b~\u0010J\u001b\u0010\u0001\u001a\u00020\u00112\u0006\u0010o\u001a\u00020 ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020&J\t\u0010\u0001\u001a\u00020&H\u0016J\t\u0010\u0001\u001a\u00020&H\u0016J\u0013\u0010\u0001\u001a\u00020&2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010\u0001\u001a\u00020\u0011R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00070\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u0019\u0010\u001f\u001a\u0004\u0018\u00010 8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b!\u0010\"RD\u0010(\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$¢\u0006\u0002\b'2\u0019\u0010#\u001a\u0015\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0018\u00010$¢\u0006\u0002\b'@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R&\u0010,\u001a\u00020+2\u0006\u0010#\u001a\u00020+@BX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u001e\u00101\u001a\u0002002\u0006\u0010#\u001a\u000200@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001e\u00104\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0013R\u0016\u00106\u001a\u0004\u0018\u00010 X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0018\u00107\u001a\u000608R\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020B8VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\u00020B8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010DR\u000e\u0010H\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\"\u0010M\u001a\u0004\u0018\u00010L2\b\u0010#\u001a\u0004\u0018\u00010L@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010D\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0013\"\u0004\bW\u0010\u0015R\u0018\u0010X\u001a\u00020B2\u0006\u0010#\u001a\u00020B@BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childDelegates", "", "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegatesDirty", "", "getChildDelegatesDirty$ui_release", "()Z", "setChildDelegatesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "setPlaced", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "<set-?>", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastLayerBlock", "getLastLayerBlock$ui_release", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/unit/IntOffset;", "lastPosition", "getLastPosition-nOcc-ac$ui_release", "()J", "J", "", "lastZIndex", "getLastZIndex$ui_release", "()F", "layingOutChildren", "getLayingOutChildren", "lookaheadConstraints", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "onNodePlacedCalled", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placeOrder", "getPlaceOrder$ui_release", "setPlaceOrder$ui_release", "(I)V", "placedOnce", "getPlacedOnce$ui_release", "setPlacedOnce$ui_release", "previousPlaceOrder", "relayoutWithoutParentInProgress", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "checkChildrenPlaceOrderForUpdates", "clearPlaceOrder", "forEachChildAlignmentLinesOwner", "block", "forEachChildDelegate", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onNodeDetached", "onNodePlaced", "onNodePlaced$ui_release", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "trackLookaheadMeasurementByParent", "node", "Landroidx/compose/ui/node/LayoutNode;", "updateParentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNodeLayoutDelegate.kt */
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private final MutableVector<LookaheadPassDelegate> _childDelegates = new MutableVector<>(new LookaheadPassDelegate[16], 0);
        private final AlignmentLines alignmentLines = new LookaheadAlignmentLines(this);
        private boolean childDelegatesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition = IntOffset.Companion.m6758getZeronOccac();
        private float lastZIndex;
        private boolean layingOutChildren;
        private Constraints lookaheadConstraints;
        private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
        private boolean measuredOnce;
        private boolean onNodePlacedCalled;
        private Object parentData = getMeasurePassDelegate$ui_release().getParentData();
        private boolean parentDataDirty = true;
        private int placeOrder = Integer.MAX_VALUE;
        private boolean placedOnce;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private boolean relayoutWithoutParentInProgress;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LayoutNodeLayoutDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|5|6|7|8|9|10|11|13|14|15|16|17|19) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003c */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
            static {
                /*
                    androidx.compose.ui.node.LayoutNode$LayoutState[] r0 = androidx.compose.ui.node.LayoutNode.LayoutState.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    r1 = 1
                    androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    r2 = 2
                    androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r4 = 3
                    r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r4 = 4
                    r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    $EnumSwitchMapping$0 = r0
                    androidx.compose.ui.node.LayoutNode$UsageByParent[] r0 = androidx.compose.ui.node.LayoutNode.UsageByParent.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.compose.ui.node.LayoutNode$UsageByParent r3 = androidx.compose.ui.node.LayoutNode.UsageByParent.InMeasureBlock     // Catch:{ NoSuchFieldError -> 0x003c }
                    int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                    r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
                L_0x003c:
                    androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.InLayoutBlock     // Catch:{ NoSuchFieldError -> 0x0044 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
                L_0x0044:
                    $EnumSwitchMapping$1 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate.WhenMappings.<clinit>():void");
            }
        }

        public LookaheadPassDelegate() {
        }

        public final int getPlaceOrder$ui_release() {
            return this.placeOrder;
        }

        public final void setPlaceOrder$ui_release(int i) {
            this.placeOrder = i;
        }

        public final LayoutNode.UsageByParent getMeasuredByParent$ui_release() {
            return this.measuredByParent;
        }

        public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
            this.measuredByParent = usageByParent;
        }

        public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
            return LayoutNodeLayoutDelegate.this.getMeasurePassDelegate$ui_release();
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        public final boolean getPlacedOnce$ui_release() {
            return this.placedOnce;
        }

        public final void setPlacedOnce$ui_release(boolean z) {
            this.placedOnce = z;
        }

        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m5556getLastConstraintsDWUhwKw() {
            return this.lookaheadConstraints;
        }

        /* renamed from: getLastPosition-nOcc-ac$ui_release  reason: not valid java name */
        public final long m5557getLastPositionnOccac$ui_release() {
            return this.lastPosition;
        }

        public final float getLastZIndex$ui_release() {
            return this.lastZIndex;
        }

        public final Function1<GraphicsLayerScope, Unit> getLastLayerBlock$ui_release() {
            return this.lastLayerBlock;
        }

        public boolean isPlaced() {
            return this.isPlaced;
        }

        public void setPlaced(boolean z) {
            this.isPlaced = z;
        }

        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final boolean getChildDelegatesDirty$ui_release() {
            return this.childDelegatesDirty;
        }

        public final void setChildDelegatesDirty$ui_release(boolean z) {
            this.childDelegatesDirty = z;
        }

        public final List<LookaheadPassDelegate> getChildDelegates$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
            if (!this.childDelegatesDirty) {
                return this._childDelegates.asMutableList();
            }
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector<LookaheadPassDelegate> mutableVector = this._childDelegates;
            MutableVector<LayoutNode> mutableVector2 = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector2.getSize();
            if (size > 0) {
                Object[] content = mutableVector2.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (mutableVector.getSize() <= i) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        mutableVector.add(lookaheadPassDelegate$ui_release);
                    } else {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release2);
                        mutableVector.set(i, lookaheadPassDelegate$ui_release2);
                    }
                    i++;
                } while (i < size);
            }
            mutableVector.removeRange(access$getLayoutNode$p.getChildren$ui_release().size(), mutableVector.getSize());
            this.childDelegatesDirty = false;
            return this._childDelegates.asMutableList();
        }

        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        private final void forEachChildDelegate(Function1<? super LookaheadPassDelegate, Unit> function1) {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    function1.invoke(lookaheadPassDelegate$ui_release);
                    i++;
                } while (i < size);
            }
        }

        public void layoutChildren() {
            this.layingOutChildren = true;
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (LayoutNodeLayoutDelegate.this.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending$ui_release())) {
                LayoutNodeLayoutDelegate.this.lookaheadLayoutPending = false;
                LayoutNode.LayoutState layoutState$ui_release = LayoutNodeLayoutDelegate.this.getLayoutState$ui_release();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(requireOwner.getSnapshotObserver(), LayoutNodeLayoutDelegate.this.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(this, lookaheadDelegate, LayoutNodeLayoutDelegate.this), 2, (Object) null);
                LayoutNodeLayoutDelegate.this.layoutState = layoutState$ui_release;
                if (LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement() && lookaheadDelegate.isPlacingForAlignment$ui_release()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.lookaheadLayoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
            this.layingOutChildren = false;
        }

        private final void markSubtreeAsNotPlaced() {
            if (isPlaced()) {
                int i = 0;
                setPlaced(false);
                MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    do {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        lookaheadPassDelegate$ui_release.markSubtreeAsNotPlaced();
                        i++;
                    } while (i < size);
                }
            }
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        LayoutNodeLayoutDelegate.this.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate != null) {
                lookaheadDelegate.setPlacingForAlignment$ui_release(true);
            }
            layoutChildren();
            LookaheadDelegate lookaheadDelegate2 = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                lookaheadDelegate2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getLookaheadAlignmentLinesOwner$ui_release();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> function1) {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = ((LayoutNode) content[i]).getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
                    Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                    function1.invoke(lookaheadAlignmentLinesOwner$ui_release);
                    i++;
                } while (i < size);
            }
        }

        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            MutableVector<LayoutNode> mutableVector;
            int size;
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0 && (size = mutableVector.getSize()) > 0) {
                Object[] content = (mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release()).getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                    if ((layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement() || layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, (Object) null);
                    }
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutDelegate$ui_release.getLookaheadPassDelegate$ui_release();
                    if (lookaheadPassDelegate$ui_release != null) {
                        lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                    i++;
                } while (i < size);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
            if (r1 == androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut) goto L_0x002b;
         */
        /* renamed from: measure-BRTryo0  reason: not valid java name */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.compose.ui.layout.Placeable m5558measureBRTryo0(long r4) {
            /*
                r3 = this;
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = r0.layoutNode
                androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
                r1 = 0
                if (r0 == 0) goto L_0x0012
                androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.getLayoutState$ui_release()
                goto L_0x0013
            L_0x0012:
                r0 = r1
            L_0x0013:
                androidx.compose.ui.node.LayoutNode$LayoutState r2 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
                if (r0 == r2) goto L_0x002b
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = r0.layoutNode
                androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
                if (r0 == 0) goto L_0x0027
                androidx.compose.ui.node.LayoutNode$LayoutState r1 = r0.getLayoutState$ui_release()
            L_0x0027:
                androidx.compose.ui.node.LayoutNode$LayoutState r0 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
                if (r1 != r0) goto L_0x0031
            L_0x002b:
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                r1 = 0
                r0.detachedFromParentLookaheadPass = r1
            L_0x0031:
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = r0.layoutNode
                r3.trackLookaheadMeasurementByParent(r0)
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = r0.layoutNode
                androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.getIntrinsicsUsageByParent$ui_release()
                androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.NotUsed
                if (r0 != r1) goto L_0x0051
                androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
                androidx.compose.ui.node.LayoutNode r0 = r0.layoutNode
                r0.clearSubtreeIntrinsicsUsage$ui_release()
            L_0x0051:
                r3.m5560remeasureBRTryo0(r4)
                r4 = r3
                androidx.compose.ui.layout.Placeable r4 = (androidx.compose.ui.layout.Placeable) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate.m5558measureBRTryo0(long):androidx.compose.ui.layout.Placeable");
        }

        private final void trackLookaheadMeasurementByParent(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release == null) {
                this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            } else if (this.measuredByParent == LayoutNode.UsageByParent.NotUsed || layoutNode.getCanMultiMeasure$ui_release()) {
                int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                if (i == 1 || i == 2) {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                } else if (i == 3 || i == 4) {
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                } else {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                }
                this.measuredByParent = usageByParent;
            } else {
                throw new IllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()".toString());
            }
        }

        public Object getParentData() {
            return this.parentData;
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m5560remeasureBRTryo0(long j) {
            long j2;
            if (!LayoutNodeLayoutDelegate.this.layoutNode.isDeactivated()) {
                LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()));
                if (!LayoutNodeLayoutDelegate.this.layoutNode.getLookaheadMeasurePending$ui_release()) {
                    Constraints constraints = this.lookaheadConstraints;
                    if (constraints == null ? false : Constraints.m6519equalsimpl0(constraints.m6532unboximpl(), j)) {
                        Owner owner$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getOwner$ui_release();
                        if (owner$ui_release != null) {
                            owner$ui_release.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.layoutNode, true);
                        }
                        LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                        return false;
                    }
                }
                this.lookaheadConstraints = Constraints.m6514boximpl(j);
                m5408setMeasurementConstraintsBRTryo0(j);
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
                forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2.INSTANCE);
                if (this.measuredOnce) {
                    j2 = m5404getMeasuredSizeYbymL2g();
                } else {
                    j2 = IntSizeKt.IntSize(Integer.MIN_VALUE, Integer.MIN_VALUE);
                }
                this.measuredOnce = true;
                LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                if (lookaheadDelegate != null) {
                    LayoutNodeLayoutDelegate.this.m5552performLookaheadMeasureBRTryo0(j);
                    m5407setMeasuredSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight()));
                    if (IntSize.m6790getWidthimpl(j2) == lookaheadDelegate.getWidth() && IntSize.m6789getHeightimpl(j2) == lookaheadDelegate.getHeight()) {
                        return false;
                    }
                    return true;
                }
                throw new IllegalStateException("Lookahead result from lookaheadRemeasure cannot be null".toString());
            }
            throw new IllegalArgumentException("measure is called on a deactivated node".toString());
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m5559placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (!LayoutNodeLayoutDelegate.this.layoutNode.isDeactivated()) {
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                this.placedOnce = true;
                this.onNodePlacedCalled = false;
                if (!IntOffset.m6747equalsimpl0(j, this.lastPosition)) {
                    if (LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringModifierPlacement() || LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNodeLayoutDelegate.this.lookaheadLayoutPending = true;
                    }
                    notifyChildrenUsingCoordinatesWhilePlacing();
                }
                Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
                if (LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending$ui_release() || !isPlaced()) {
                    LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringModifierPlacement(false);
                    getAlignmentLines().setUsedByModifierLayout$ui_release(false);
                    OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(requireOwner.getSnapshotObserver(), LayoutNodeLayoutDelegate.this.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$2(LayoutNodeLayoutDelegate.this, requireOwner, j), 2, (Object) null);
                } else {
                    LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                    Intrinsics.checkNotNull(lookaheadDelegate);
                    lookaheadDelegate.m5585placeSelfApparentToRealOffsetgyyYBs$ui_release(j);
                    onNodePlaced$ui_release();
                }
                this.lastPosition = j;
                this.lastZIndex = f;
                this.lastLayerBlock = function1;
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
                return;
            }
            throw new IllegalArgumentException("place is called on a deactivated node".toString());
        }

        public int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredWidth();
        }

        public int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredHeight();
        }

        public int get(AlignmentLine alignmentLine) {
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState = null;
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            int i = lookaheadDelegate.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i;
        }

        public int minIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicWidth(i);
        }

        public int maxIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicWidth(i);
        }

        public int minIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicHeight(i);
        }

        public int maxIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicHeight(i);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, 3, (Object) null);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null && LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
                if (i == 2) {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                } else if (i != 3) {
                    usageByParent = parent$ui_release.getIntrinsicsUsageByParent$ui_release();
                } else {
                    usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final void invalidateIntrinsicsParent(boolean z) {
            LayoutNode parent$ui_release;
            LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release2 != null && intrinsicsUsageByParent$ui_release != LayoutNode.UsageByParent.NotUsed) {
                while (parent$ui_release2.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                    parent$ui_release2 = parent$ui_release;
                }
                int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                    } else if (parent$ui_release2.getLookaheadRoot$ui_release() != null) {
                        parent$ui_release2.requestLookaheadRelayout$ui_release(z);
                    } else {
                        parent$ui_release2.requestRelayout$ui_release(z);
                    }
                } else if (parent$ui_release2.getLookaheadRoot$ui_release() != null) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release2, z, false, 2, (Object) null);
                } else {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, z, false, 2, (Object) null);
                }
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        public final boolean updateParentData() {
            if (getParentData() == null) {
                LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate);
                if (lookaheadDelegate.getParentData() == null) {
                    return false;
                }
            }
            if (!this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            LookaheadDelegate lookaheadDelegate2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            this.parentData = lookaheadDelegate2.getParentData();
            return true;
        }

        public final void onNodePlaced$ui_release() {
            this.onNodePlacedCalled = true;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (!isPlaced()) {
                markNodeAndSubtreeAsPlaced();
                if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, (Object) null);
                }
            }
            if (parent$ui_release == null) {
                this.placeOrder = 0;
            } else if (!this.relayoutWithoutParentInProgress && (parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut || parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut)) {
                if (this.placeOrder == Integer.MAX_VALUE) {
                    this.placeOrder = parent$ui_release.getLayoutDelegate$ui_release().nextChildLookaheadPlaceOrder;
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release();
                    layoutDelegate$ui_release.nextChildLookaheadPlaceOrder = layoutDelegate$ui_release.nextChildLookaheadPlaceOrder + 1;
                } else {
                    throw new IllegalStateException("Place was called on a node which was placed already".toString());
                }
            }
            layoutChildren();
        }

        /* access modifiers changed from: private */
        public final void clearPlaceOrder() {
            int i = 0;
            LayoutNodeLayoutDelegate.this.nextChildLookaheadPlaceOrder = 0;
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.previousPlaceOrder = lookaheadPassDelegate$ui_release.placeOrder;
                    lookaheadPassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
                    if (lookaheadPassDelegate$ui_release.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                        lookaheadPassDelegate$ui_release.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                    }
                    i++;
                } while (i < size);
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            boolean isPlaced2 = isPlaced();
            setPlaced(true);
            int i = 0;
            if (!isPlaced2 && LayoutNodeLayoutDelegate.this.getLookaheadMeasurePending$ui_release()) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, true, false, 2, (Object) null);
            }
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (layoutNode.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        lookaheadPassDelegate$ui_release.markNodeAndSubtreeAsPlaced();
                        layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                    }
                    i++;
                } while (i < size);
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector<LayoutNode> mutableVector = access$getLayoutNode$p.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i];
                    if (layoutNode.getLookaheadMeasurePending$ui_release() && layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        Constraints r5 = layoutNode.getLayoutDelegate$ui_release().m5555getLastLookaheadConstraintsDWUhwKw();
                        Intrinsics.checkNotNull(r5);
                        if (lookaheadPassDelegate$ui_release.m5560remeasureBRTryo0(r5.m6532unboximpl())) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, false, 3, (Object) null);
                        }
                    }
                    i++;
                } while (i < size);
            }
        }

        /* JADX INFO: finally extract failed */
        public final void replace() {
            LayoutNode parent$ui_release;
            try {
                this.relayoutWithoutParentInProgress = true;
                if (this.placedOnce) {
                    this.onNodePlacedCalled = false;
                    boolean isPlaced2 = isPlaced();
                    m5559placeAtf8xVGno(this.lastPosition, 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
                    if (isPlaced2 && !this.onNodePlacedCalled && (parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release()) != null) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, (Object) null);
                    }
                    this.relayoutWithoutParentInProgress = false;
                    return;
                }
                throw new IllegalStateException("replace() called on item that was not placed".toString());
            } catch (Throwable th) {
                this.relayoutWithoutParentInProgress = false;
                throw th;
            }
        }

        public final void onNodeDetached() {
            this.placeOrder = Integer.MAX_VALUE;
            this.previousPlaceOrder = Integer.MAX_VALUE;
            setPlaced(false);
        }

        /* access modifiers changed from: private */
        public final void checkChildrenPlaceOrderForUpdates() {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    int i2 = lookaheadPassDelegate$ui_release.previousPlaceOrder;
                    int i3 = lookaheadPassDelegate$ui_release.placeOrder;
                    if (i2 != i3 && i3 == Integer.MAX_VALUE) {
                        lookaheadPassDelegate$ui_release.markSubtreeAsNotPlaced();
                    }
                    i++;
                } while (i < size);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: performMeasure-BRTryo0  reason: not valid java name */
    public final void m5553performMeasureBRTryo0(long j) {
        if (this.layoutState == LayoutNode.LayoutState.Idle) {
            this.layoutState = LayoutNode.LayoutState.Measuring;
            this.measurePending = false;
            this.performMeasureConstraints = j;
            LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, false, this.performMeasureBlock);
            if (this.layoutState == LayoutNode.LayoutState.Measuring) {
                markLayoutPending$ui_release();
                this.layoutState = LayoutNode.LayoutState.Idle;
                return;
            }
            return;
        }
        throw new IllegalStateException("layout state is not idle before measure starts".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: performLookaheadMeasure-BRTryo0  reason: not valid java name */
    public final void m5552performLookaheadMeasureBRTryo0(long j) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, new LayoutNodeLayoutDelegate$performLookaheadMeasure$1(this, j), 2, (Object) null);
        markLookaheadLayoutPending$ui_release();
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    public final void ensureLookaheadDelegateCreated$ui_release() {
        if (this.lookaheadPassDelegate == null) {
            this.lookaheadPassDelegate = new LookaheadPassDelegate();
        }
    }

    public final void updateParentData() {
        LayoutNode parent$ui_release;
        if (this.measurePassDelegate.updateParentData() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
            LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, 3, (Object) null);
        }
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && lookaheadPassDelegate2.updateParentData()) {
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.layoutNode)) {
                LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, false, false, 3, (Object) null);
                    return;
                }
                return;
            }
            LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release3 != null) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release3, false, false, 3, (Object) null);
            }
        }
    }

    public final void invalidateParentData() {
        this.measurePassDelegate.invalidateParentData();
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            lookaheadPassDelegate2.invalidateParentData();
        }
    }

    public final void resetAlignmentLines() {
        AlignmentLines alignmentLines;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && (alignmentLines = lookaheadPassDelegate2.getAlignmentLines()) != null) {
            alignmentLines.reset$ui_release();
        }
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildDelegatesDirty$ui_release(true);
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            lookaheadPassDelegate2.setChildDelegatesDirty$ui_release(true);
        }
    }
}
