package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedVisibilityKt$AnimatedEnterExitImpl$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> $content;
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ OnLookaheadMeasured $onLookaheadMeasured;
    final /* synthetic */ Function2<EnterExitState, EnterExitState, Boolean> $shouldDisposeBlock;
    final /* synthetic */ Transition<T> $transition;
    final /* synthetic */ Function1<T, Boolean> $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedVisibilityKt$AnimatedEnterExitImpl$4(Transition<T> transition, Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, OnLookaheadMeasured onLookaheadMeasured, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
        super(2);
        this.$transition = transition;
        this.$visible = function1;
        this.$modifier = modifier;
        this.$enter = enterTransition;
        this.$exit = exitTransition;
        this.$shouldDisposeBlock = function2;
        this.$onLookaheadMeasured = onLookaheadMeasured;
        this.$content = function3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AnimatedVisibilityKt.AnimatedEnterExitImpl(this.$transition, this.$visible, this.$modifier, this.$enter, this.$exit, this.$shouldDisposeBlock, this.$onLookaheadMeasured, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
