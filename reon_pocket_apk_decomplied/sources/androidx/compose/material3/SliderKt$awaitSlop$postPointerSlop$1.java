package androidx.compose.material3;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$awaitSlop$postPointerSlop$1 extends Lambda implements Function2<PointerInputChange, Float, Unit> {
    final /* synthetic */ Ref.FloatRef $initialDelta;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$awaitSlop$postPointerSlop$1(Ref.FloatRef floatRef) {
        super(2);
        this.$initialDelta = floatRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PointerInputChange) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange, float f) {
        pointerInputChange.consume();
        this.$initialDelta.element = f;
    }
}
