package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderDefaults$Thumb$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $thumbSize;
    final /* synthetic */ SliderDefaults $tmp2_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderDefaults$Thumb$2(SliderDefaults sliderDefaults, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, int i, int i2) {
        super(2);
        this.$tmp2_rcvr = sliderDefaults;
        this.$interactionSource = mutableInteractionSource;
        this.$modifier = modifier;
        this.$colors = sliderColors;
        this.$enabled = z;
        this.$thumbSize = j;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp2_rcvr.m2191Thumb9LiSoMs(this.$interactionSource, this.$modifier, this.$colors, this.$enabled, this.$thumbSize, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
