package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionGestures.kt */
final class SelectionGesturesKt$touchSelection$2 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ TextDragObserver $observer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionGesturesKt$touchSelection$2(TextDragObserver textDragObserver) {
        super(1);
        this.$observer = textDragObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        this.$observer.m1120onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
    }
}
