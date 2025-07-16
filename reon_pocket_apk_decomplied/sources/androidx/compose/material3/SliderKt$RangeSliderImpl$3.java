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
final class SliderKt$RangeSliderImpl$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Function3<RangeSliderState, Composer, Integer, Unit> $endThumb;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ Function3<RangeSliderState, Composer, Integer, Unit> $startThumb;
    final /* synthetic */ RangeSliderState $state;
    final /* synthetic */ Function3<RangeSliderState, Composer, Integer, Unit> $track;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSliderImpl$3(Modifier modifier, RangeSliderState rangeSliderState, boolean z, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, int i) {
        super(2);
        this.$modifier = modifier;
        this.$state = rangeSliderState;
        this.$enabled = z;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$startThumb = function3;
        this.$endThumb = function32;
        this.$track = function33;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SliderKt.RangeSliderImpl(this.$modifier, this.$state, this.$enabled, this.$startInteractionSource, this.$endInteractionSource, this.$startThumb, this.$endThumb, this.$track, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
