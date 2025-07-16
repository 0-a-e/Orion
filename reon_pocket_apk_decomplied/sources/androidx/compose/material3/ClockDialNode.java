package androidx.compose.material3;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/material3/ClockDialNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "state", "Landroidx/compose/material3/TimePickerState;", "autoSwitchToMinute", "", "(Landroidx/compose/material3/TimePickerState;Z)V", "maxDist", "", "getMaxDist", "()F", "offsetX", "offsetY", "pointerInputDragNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputTapNode", "onCancelPointerInput", "", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "updateNode", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class ClockDialNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public boolean autoSwitchToMinute;
    /* access modifiers changed from: private */
    public float offsetX;
    /* access modifiers changed from: private */
    public float offsetY;
    private final SuspendingPointerInputModifierNode pointerInputDragNode = ((SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputDragNode$1(this, (Continuation<? super ClockDialNode$pointerInputDragNode$1>) null))));
    private final SuspendingPointerInputModifierNode pointerInputTapNode = ((SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClockDialNode$pointerInputTapNode$1(this, (Continuation<? super ClockDialNode$pointerInputTapNode$1>) null))));
    /* access modifiers changed from: private */
    public TimePickerState state;

    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    public /* synthetic */ void onDensityChange() {
        PointerInputModifierNode.CC.$default$onDensityChange(this);
    }

    public /* synthetic */ void onPlaced(LayoutCoordinates layoutCoordinates) {
        LayoutAwareModifierNode.CC.$default$onPlaced(this, layoutCoordinates);
    }

    public /* synthetic */ void onViewConfigurationChange() {
        PointerInputModifierNode.CC.$default$onViewConfigurationChange(this);
    }

    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    public ClockDialNode(TimePickerState timePickerState, boolean z) {
        this.state = timePickerState;
        this.autoSwitchToMinute = z;
    }

    /* access modifiers changed from: private */
    public final float getMaxDist() {
        return DelegatableNodeKt.requireDensity(this).m6550toPx0680j_4(TimePickerKt.MaxDistance);
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m1634onRemeasuredozmzZPI(long j) {
        this.state.m2509setCentergyyYBs$material3_release(IntSizeKt.m6796getCenterozmzZPI(j));
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m1633onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        this.pointerInputTapNode.m5707onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        this.pointerInputDragNode.m5707onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    public void onCancelPointerInput() {
        this.pointerInputTapNode.onCancelPointerInput();
        this.pointerInputDragNode.onCancelPointerInput();
    }

    public final void updateNode(TimePickerState timePickerState, boolean z) {
        this.state = timePickerState;
        this.autoSwitchToMinute = z;
    }
}
