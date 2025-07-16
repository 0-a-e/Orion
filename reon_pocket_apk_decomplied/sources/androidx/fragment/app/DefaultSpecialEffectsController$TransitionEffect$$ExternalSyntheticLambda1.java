package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.DefaultSpecialEffectsController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ FragmentTransitionImpl f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ Rect f$2;

    public /* synthetic */ DefaultSpecialEffectsController$TransitionEffect$$ExternalSyntheticLambda1(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.f$0 = fragmentTransitionImpl;
        this.f$1 = view;
        this.f$2 = rect;
    }

    public final void run() {
        DefaultSpecialEffectsController.TransitionEffect.createMergedTransition$lambda$13(this.f$0, this.f$1, this.f$2);
    }
}
