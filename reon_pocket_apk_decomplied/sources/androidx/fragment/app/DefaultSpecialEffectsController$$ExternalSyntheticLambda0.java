package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSpecialEffectsController$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DefaultSpecialEffectsController f$0;
    public final /* synthetic */ SpecialEffectsController.Operation f$1;

    public /* synthetic */ DefaultSpecialEffectsController$$ExternalSyntheticLambda0(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation) {
        this.f$0 = defaultSpecialEffectsController;
        this.f$1 = operation;
    }

    public final void run() {
        DefaultSpecialEffectsController.collectEffects$lambda$2(this.f$0, this.f$1);
    }
}
