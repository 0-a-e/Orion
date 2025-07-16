package androidx.compose.material3;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Track$5$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $activeTickColor;
    final /* synthetic */ long $activeTrackColor;
    final /* synthetic */ long $inactiveTickColor;
    final /* synthetic */ long $inactiveTrackColor;
    final /* synthetic */ RangeSliderState $rangeSliderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Track$5$1(RangeSliderState rangeSliderState, long j, long j2, long j3, long j4) {
        super(1);
        this.$rangeSliderState = rangeSliderState;
        this.$inactiveTrackColor = j;
        this.$activeTrackColor = j2;
        this.$inactiveTickColor = j3;
        this.$activeTickColor = j4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        SliderDefaults.INSTANCE.m2190drawTrackLUBghH0(drawScope, this.$rangeSliderState.getTickFractions$material3_release(), this.$rangeSliderState.getCoercedActiveRangeStartAsFraction$material3_release(), this.$rangeSliderState.getCoercedActiveRangeEndAsFraction$material3_release(), this.$inactiveTrackColor, this.$activeTrackColor, this.$inactiveTickColor, this.$activeTickColor);
    }
}
