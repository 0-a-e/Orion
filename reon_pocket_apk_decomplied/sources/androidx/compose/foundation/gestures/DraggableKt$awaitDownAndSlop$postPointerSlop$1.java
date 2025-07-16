package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$awaitDownAndSlop$postPointerSlop$1 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {
    final /* synthetic */ Ref.LongRef $initialDelta;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableKt$awaitDownAndSlop$postPointerSlop$1(VelocityTracker velocityTracker, Ref.LongRef longRef) {
        super(2);
        this.$velocityTracker = velocityTracker;
        this.$initialDelta = longRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m402invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m402invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        pointerInputChange.consume();
        this.$initialDelta.element = j;
    }
}
