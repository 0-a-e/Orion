package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EnterExitTransitionKt$$ExternalSyntheticLambda0 implements GraphicsLayerBlockForEnterExit {
    public final /* synthetic */ Transition.DeferredAnimation f$0;
    public final /* synthetic */ Transition.DeferredAnimation f$1;
    public final /* synthetic */ Transition f$2;
    public final /* synthetic */ EnterTransition f$3;
    public final /* synthetic */ ExitTransition f$4;
    public final /* synthetic */ Transition.DeferredAnimation f$5;

    public /* synthetic */ EnterExitTransitionKt$$ExternalSyntheticLambda0(Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition transition, EnterTransition enterTransition, ExitTransition exitTransition, Transition.DeferredAnimation deferredAnimation3) {
        this.f$0 = deferredAnimation;
        this.f$1 = deferredAnimation2;
        this.f$2 = transition;
        this.f$3 = enterTransition;
        this.f$4 = exitTransition;
        this.f$5 = deferredAnimation3;
    }

    public final Function1 init() {
        return EnterExitTransitionKt.createGraphicsLayerBlock$lambda$11(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
