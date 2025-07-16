package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "sliderState", "Landroidx/compose/material3/SliderState;", "invoke", "(Landroidx/compose/material3/SliderState;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$3 extends Lambda implements Function3<SliderState, Composer, Integer, Unit> {
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3(SliderColors sliderColors, boolean z) {
        super(3);
        this.$colors = sliderColors;
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SliderState sliderState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C175@8021L130:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i |= composer.changed((Object) sliderState) ? 4 : 2;
        }
        if ((i & 19) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1843234110, i, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
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
