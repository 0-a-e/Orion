package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentKt$AnimatedContent$9 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function4<AnimatedContentScope, S, Composer, Integer, Unit> $content;
    final /* synthetic */ Alignment $contentAlignment;
    final /* synthetic */ Function1<S, Object> $contentKey;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ Function1<AnimatedContentTransitionScope<S>, ContentTransform> $transitionSpec;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentKt$AnimatedContent$9(Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentTransitionScope<S>, ContentTransform> function1, Alignment alignment, Function1<? super S, ? extends Object> function12, Function4<? super AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> function4, int i, int i2) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$modifier = modifier;
        this.$transitionSpec = function1;
        this.$contentAlignment = alignment;
        this.$contentKey = function12;
        this.$content = function4;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AnimatedContentKt.AnimatedContent(this.$this_AnimatedContent, this.$modifier, this.$transitionSpec, this.$contentAlignment, this.$contentKey, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
