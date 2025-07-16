package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/SwipeToDismissAnchorsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "(Landroidx/compose/material3/SwipeToDismissBoxState;ZZ)V", "didLookahead", "getEnableDismissFromEndToStart", "()Z", "setEnableDismissFromEndToStart", "(Z)V", "getEnableDismissFromStartToEnd", "setEnableDismissFromStartToEnd", "getState", "()Landroidx/compose/material3/SwipeToDismissBoxState;", "setState", "(Landroidx/compose/material3/SwipeToDismissBoxState;)V", "onDetach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeToDismissBox.kt */
final class SwipeToDismissAnchorsNode extends Modifier.Node implements LayoutModifierNode {
    private boolean didLookahead;
    private boolean enableDismissFromEndToStart;
    private boolean enableDismissFromStartToEnd;
    private SwipeToDismissBoxState state;

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

    public final SwipeToDismissBoxState getState() {
        return this.state;
    }

    public final void setState(SwipeToDismissBoxState swipeToDismissBoxState) {
        this.state = swipeToDismissBoxState;
    }

    public final boolean getEnableDismissFromStartToEnd() {
        return this.enableDismissFromStartToEnd;
    }

    public final void setEnableDismissFromStartToEnd(boolean z) {
        this.enableDismissFromStartToEnd = z;
    }

    public final boolean getEnableDismissFromEndToStart() {
        return this.enableDismissFromEndToStart;
    }

    public final void setEnableDismissFromEndToStart(boolean z) {
        this.enableDismissFromEndToStart = z;
    }

    public SwipeToDismissAnchorsNode(SwipeToDismissBoxState swipeToDismissBoxState, boolean z, boolean z2) {
        this.state = swipeToDismissBoxState;
        this.enableDismissFromStartToEnd = z;
        this.enableDismissFromEndToStart = z2;
    }

    public void onDetach() {
        this.didLookahead = false;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m2312measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable r9 = measurable.m5368measureBRTryo0(j);
        if (measureScope.isLookingAhead() || !this.didLookahead) {
            AnchoredDraggableState.updateAnchors$default(this.state.getAnchoredDraggableState$material3_release(), AnchoredDraggableKt.DraggableAnchors(new SwipeToDismissAnchorsNode$measure$newAnchors$1(this, (float) r9.getWidth())), (Object) null, 2, (Object) null);
        }
        this.didLookahead = measureScope.isLookingAhead() || this.didLookahead;
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new SwipeToDismissAnchorsNode$measure$1(measureScope, this, r9), 4, (Object) null);
    }
}
