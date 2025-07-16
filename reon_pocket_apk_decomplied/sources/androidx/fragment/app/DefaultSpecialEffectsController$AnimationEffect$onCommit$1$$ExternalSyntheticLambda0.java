package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultSpecialEffectsController$AnimationEffect$onCommit$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ViewGroup f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ DefaultSpecialEffectsController.AnimationEffect f$2;

    public /* synthetic */ DefaultSpecialEffectsController$AnimationEffect$onCommit$1$$ExternalSyntheticLambda0(ViewGroup viewGroup, View view, DefaultSpecialEffectsController.AnimationEffect animationEffect) {
        this.f$0 = viewGroup;
        this.f$1 = view;
        this.f$2 = animationEffect;
    }

    public final void run() {
        DefaultSpecialEffectsController$AnimationEffect$onCommit$1.onAnimationEnd$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}
