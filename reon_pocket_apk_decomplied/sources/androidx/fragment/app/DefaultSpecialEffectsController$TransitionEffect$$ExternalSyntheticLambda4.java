package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ SpecialEffectsController.Operation f$0;
    public final /* synthetic */ DefaultSpecialEffectsController.TransitionEffect f$1;

    public /* synthetic */ DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda4(SpecialEffectsController.Operation operation, DefaultSpecialEffectsController.TransitionEffect transitionEffect) {
        this.f$0 = operation;
        this.f$1 = transitionEffect;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.onStart$lambda$6$lambda$5(this.f$0, this.f$1);
    }
}
