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
/* compiled from: Label.kt */
final class LabelKt$Label$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isPersistent;
    final /* synthetic */ Function3<CaretScope, Composer, Integer, Unit> $label;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LabelKt$Label$3(Function3<? super CaretScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$label = function3;
        this.$modifier = modifier;
        this.$interactionSource = mutableInteractionSource;
        this.$isPersistent = z;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LabelKt.Label(this.$label, this.$modifier, this.$interactionSource, this.$isPersistent, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
