package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ Ref.BooleanRef $draggingStart;
    final /* synthetic */ RangeSliderState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1(RangeSliderState rangeSliderState, Ref.BooleanRef booleanRef) {
        super(1);
        this.$state = rangeSliderState;
        this.$draggingStart = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        float r4 = Offset.m3562getXimpl(PointerEventKt.positionChange(pointerInputChange));
        RangeSliderState rangeSliderState = this.$state;
        boolean z = this.$draggingStart.element;
        if (this.$state.isRtl$material3_release()) {
            r4 = -r4;
        }
        rangeSliderState.onDrag$material3_release(z, r4);
    }
}
