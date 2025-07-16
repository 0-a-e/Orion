package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$13 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SliderState $state;
    final /* synthetic */ Function3<SliderState, Composer, Integer, Unit> $thumb;
    final /* synthetic */ Function3<SliderState, Composer, Integer, Unit> $track;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$13(SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, int i, int i2) {
        super(2);
        this.$state = sliderState;
        this.$modifier = modifier;
        this.$enabled = z;
        this.$colors = sliderColors;
        this.$interactionSource = mutableInteractionSource;
        this.$thumb = function3;
        this.$track = function32;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SliderKt.Slider(this.$state, this.$modifier, this.$enabled, this.$colors, this.$interactionSource, this.$thumb, this.$track, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
