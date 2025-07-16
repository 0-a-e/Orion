package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionGestures.kt */
final class SelectionGesturesKt$mouseSelection$shouldConsumeUp$2 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ MouseSelectionObserver $observer;
    final /* synthetic */ SelectionAdjustment $selectionAdjustment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionGesturesKt$mouseSelection$shouldConsumeUp$2(MouseSelectionObserver mouseSelectionObserver, SelectionAdjustment selectionAdjustment) {
        super(1);
        this.$observer = mouseSelectionObserver;
        this.$selectionAdjustment = selectionAdjustment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        if (this.$observer.m1212onDrag3MmeM6k(pointerInputChange.m5113getPositionF1C5BW0(), this.$selectionAdjustment)) {
            pointerInputChange.consume();
        }
    }
}
