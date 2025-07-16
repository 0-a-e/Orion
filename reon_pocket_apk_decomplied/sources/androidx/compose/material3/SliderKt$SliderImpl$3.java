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
final class SliderKt$SliderImpl$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SliderState $state;
    final /* synthetic */ Function3<SliderState, Composer, Integer, Unit> $thumb;
    final /* synthetic */ Function3<SliderState, Composer, Integer, Unit> $track;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$SliderImpl$3(Modifier modifier, SliderState sliderState, boolean z, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, int i) {
        super(2);
        this.$modifier = modifier;
        this.$state = sliderState;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$thumb = function3;
        this.$track = function32;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SliderKt.SliderImpl(this.$modifier, this.$state, this.$enabled, this.$interactionSource, this.$thumb, this.$track, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
