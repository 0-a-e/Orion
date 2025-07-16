package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Label.kt */
final class LabelKt$HandleInteractions$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ BasicTooltipState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LabelKt$HandleInteractions$2(boolean z, BasicTooltipState basicTooltipState, MutableInteractionSource mutableInteractionSource, int i) {
        super(2);
        this.$enabled = z;
        this.$state = basicTooltipState;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LabelKt.HandleInteractions(this.$enabled, this.$state, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
