package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$rangeSliderEndThumbSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ RangeSliderState $state;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$rangeSliderEndThumbSemantics$1(boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, RangeSliderState rangeSliderState) {
        super(1);
        this.$enabled = z;
        this.$valueRange = closedFloatingPointRange;
        this.$state = rangeSliderState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
        final RangeSliderState rangeSliderState = this.$state;
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, (String) null, new Function1<Float, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }

            public final Boolean invoke(float f) {
                int endSteps$material3_release;
                float coerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
                boolean z = false;
                if (rangeSliderState.getEndSteps$material3_release() > 0 && (endSteps$material3_release = rangeSliderState.getEndSteps$material3_release() + 1) >= 0) {
                    float f2 = coerceIn;
                    float f3 = f2;
                    int i = 0;
                    while (true) {
                        float lerp = MathHelpersKt.lerp(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), ((float) i) / ((float) (rangeSliderState.getEndSteps$material3_release() + 1)));
                        float f4 = lerp - coerceIn;
                        if (Math.abs(f4) <= f2) {
                            f2 = Math.abs(f4);
                            f3 = lerp;
                        }
                        if (i == endSteps$material3_release) {
                            break;
                        }
                        i++;
                    }
                    coerceIn = f3;
                }
                if (coerceIn != rangeSliderState.getActiveRangeEnd()) {
                    long SliderRange = SliderKt.SliderRange(rangeSliderState.getActiveRangeStart(), coerceIn);
                    if (!SliderRange.m2207equalsimpl0(SliderRange, SliderKt.SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd()))) {
                        if (rangeSliderState.getOnValueChange$material3_release() != null) {
                            Function1<SliderRange, Unit> onValueChange$material3_release = rangeSliderState.getOnValueChange$material3_release();
                            if (onValueChange$material3_release != null) {
                                onValueChange$material3_release.invoke(SliderRange.m2204boximpl(SliderRange));
                            }
                        } else {
                            rangeSliderState.setActiveRangeStart(SliderRange.m2209getStartimpl(SliderRange));
                            rangeSliderState.setActiveRangeEnd(SliderRange.m2208getEndInclusiveimpl(SliderRange));
                        }
                    }
                    Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
                    if (onValueChangeFinished != null) {
                        onValueChangeFinished.invoke();
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }, 1, (Object) null);
    }
}
