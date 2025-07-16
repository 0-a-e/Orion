package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ2\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/gestures/TransformableNode;", "Landroidx/compose/ui/node/DelegatingNode;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "", "lockRotationOnZoomPan", "enabled", "(Landroidx/compose/foundation/gestures/TransformableState;Lkotlin/jvm/functions/Function1;ZZ)V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "updatedCanPan", "update", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transformable.kt */
final class TransformableNode extends DelegatingNode {
    /* access modifiers changed from: private */
    public Function1<? super Offset, Boolean> canPan;
    /* access modifiers changed from: private */
    public final Channel<TransformEvent> channel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    /* access modifiers changed from: private */
    public boolean enabled;
    /* access modifiers changed from: private */
    public boolean lockRotationOnZoomPan;
    private final SuspendingPointerInputModifierNode pointerInputNode = ((SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TransformableNode$pointerInputNode$1(this, (Continuation<? super TransformableNode$pointerInputNode$1>) null))));
    /* access modifiers changed from: private */
    public TransformableState state;
    /* access modifiers changed from: private */
    public final Function1<Offset, Boolean> updatedCanPan = new TransformableNode$updatedCanPan$1(this);

    public TransformableNode(TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        this.state = transformableState;
        this.canPan = function1;
        this.lockRotationOnZoomPan = z;
        this.enabled = z2;
    }

    public final void update(TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        this.canPan = function1;
        if (!Intrinsics.areEqual((Object) this.state, (Object) transformableState) || this.enabled != z2 || this.lockRotationOnZoomPan != z) {
            this.state = transformableState;
            this.enabled = z2;
            this.lockRotationOnZoomPan = z;
            this.pointerInputNode.resetPointerInputHandler();
        }
    }
}
