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
final class SliderKt$Slider$7 extends Lambda implements Function3<SliderState, Composer, Integer, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$7(SliderColors sliderColors, boolean z) {
        super(3);
        this.$colors = sliderColors;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SliderState sliderState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C258@11897L114:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i |= composer.changed((Object) sliderState) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2083675534, i, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:258)");
            }
            SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, this.$colors, this.$enabled, composer, (i & 14) | CpioConstants.C_ISBLK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
