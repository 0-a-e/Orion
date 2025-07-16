package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$ClockText$1$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableState<Offset> $center$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockText$1$1(MutableState<Offset> mutableState) {
        super(1);
        this.$center$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        TimePickerKt.ClockText$lambda$29(this.$center$delegate, LayoutCoordinatesKt.boundsInParent(layoutCoordinates).m3592getCenterF1C5BW0());
    }
}
