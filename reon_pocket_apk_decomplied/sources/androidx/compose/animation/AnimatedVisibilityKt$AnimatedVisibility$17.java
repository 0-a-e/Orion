package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedVisibilityKt$AnimatedVisibility$17 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;
    final /* synthetic */ boolean $initiallyVisible;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ boolean $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedVisibility$17(boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$visible = z;
        this.$modifier = modifier;
        this.$enter = enterTransition;
        this.$exit = exitTransition;
        this.$initiallyVisible = z2;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AnimatedVisibilityKt.AnimatedVisibility(this.$visible, this.$modifier, this.$enter, this.$exit, this.$initiallyVisible, (Function2<? super Composer, ? super Integer, Unit>) this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
