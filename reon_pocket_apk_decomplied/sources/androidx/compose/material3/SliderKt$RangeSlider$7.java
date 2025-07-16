package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$7 extends Lambda implements Function3<RangeSliderState, Composer, Integer, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$7(MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z) {
        super(3);
        this.$startInteractionSource = mutableInteractionSource;
        this.$colors = sliderColors;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RangeSliderState rangeSliderState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C521@23391L131:Slider.kt#uh7d8r");
        if ((i & 17) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1963073082, i, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:521)");
            }
            SliderDefaults.INSTANCE.m2191Thumb9LiSoMs(this.$startInteractionSource, (Modifier) null, this.$colors, this.$enabled, 0, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
