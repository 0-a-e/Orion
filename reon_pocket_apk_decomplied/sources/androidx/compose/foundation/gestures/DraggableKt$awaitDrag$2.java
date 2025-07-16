package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$awaitDrag$2 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ SendChannel<DragEvent> $channel;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableKt$awaitDrag$2(VelocityTracker velocityTracker, SendChannel<? super DragEvent> sendChannel, boolean z) {
        super(1);
        this.$velocityTracker = velocityTracker;
        this.$channel = sendChannel;
        this.$reverseDirection = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            long positionChange = PointerEventKt.positionChange(pointerInputChange);
            pointerInputChange.consume();
            SendChannel<DragEvent> sendChannel = this.$channel;
            if (this.$reverseDirection) {
                positionChange = Offset.m3569timestuRUvjQ(positionChange, -1.0f);
            }
            sendChannel.m8593trySendJP2dKIU(new DragEvent.DragDelta(positionChange, (DefaultConstructorMarker) null));
        }
    }
}
