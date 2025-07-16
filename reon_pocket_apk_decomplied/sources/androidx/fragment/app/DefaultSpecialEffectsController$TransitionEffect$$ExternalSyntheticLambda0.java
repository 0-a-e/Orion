package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SpecialEffectsController.Operation f$0;
    public final /* synthetic */ SpecialEffectsController.Operation f$1;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f$2;

    public /* synthetic */ DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda0(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
        this.f$0 = operation;
        this.f$1 = operation2;
        this.f$2 = transitionEffect;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$12(this.f$0, this.f$1, this.f$2);
    }
}
