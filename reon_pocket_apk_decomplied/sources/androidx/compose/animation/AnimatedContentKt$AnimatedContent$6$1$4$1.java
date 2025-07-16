package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "S", "currentState", "Landroidx/compose/animation/EnterExitState;", "targetState", "invoke", "(Landroidx/compose/animation/EnterExitState;Landroidx/compose/animation/EnterExitState;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentKt$AnimatedContent$6$1$4$1 extends Lambda implements Function2<EnterExitState, EnterExitState, Boolean> {
    final /* synthetic */ ExitTransition $exit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentKt$AnimatedContent$6$1$4$1(ExitTransition exitTransition) {
        super(2);
        this.$exit = exitTransition;
    }

    public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
        return Boolean.valueOf(enterExitState == EnterExitState.PostExit && enterExitState2 == EnterExitState.PostExit && !this.$exit.getData$animation_release().getHold());
    }
}
