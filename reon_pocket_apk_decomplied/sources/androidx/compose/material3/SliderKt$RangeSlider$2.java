package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/material3/RangeSliderState;", "invoke", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2 extends Lambda implements Function3<RangeSliderState, Composer, Integer, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2(MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z) {
        super(3);
        this.$endInteractionSource = mutableInteractionSource;
        this.$colors = sliderColors;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RangeSliderState rangeSliderState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C438@19048L145:Slider.kt#uh7d8r");
        if ((i & 17) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1832060001, i, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
            }
            SliderDefaults.INSTANCE.m2191Thumb9LiSoMs(this.$endInteractionSource, (Modifier) null, this.$colors, this.$enabled, 0, composer, 196614, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
