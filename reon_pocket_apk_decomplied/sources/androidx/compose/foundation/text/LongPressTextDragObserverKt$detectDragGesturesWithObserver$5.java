package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LongPressTextDragObserver.kt */
final class LongPressTextDragObserverKt$detectDragGesturesWithObserver$5 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {
    final /* synthetic */ TextDragObserver $observer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LongPressTextDragObserverKt$detectDragGesturesWithObserver$5(TextDragObserver textDragObserver) {
        super(2);
        this.$observer = textDragObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m1088invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m3572unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m1088invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        this.$observer.m1120onDragk4lQ0M(j);
    }
}
