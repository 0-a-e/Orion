package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$9 extends Lambda implements Function3<RangeSliderState, Composer, Integer, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$9(SliderColors sliderColors, boolean z) {
        super(3);
        this.$colors = sliderColors;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RangeSliderState rangeSliderState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C535@23844L124:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i |= composer.changed((Object) rangeSliderState) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-429193201, i, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:535)");
            }
            SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, this.$colors, this.$enabled, composer, (i & 14) | CpioConstants.C_ISBLK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
