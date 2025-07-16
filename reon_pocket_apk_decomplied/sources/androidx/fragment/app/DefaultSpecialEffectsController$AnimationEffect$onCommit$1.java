package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"androidx/fragment/app/DefaultSpecialEffectsController$AnimationEffect$onCommit$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultSpecialEffectsController.kt */
public final class DefaultSpecialEffectsController$AnimationEffect$onCommit$1 implements Animation.AnimationListener {
    final /* synthetic */ ViewGroup $container;
    final /* synthetic */ SpecialEffectsController.Operation $operation;
    final /* synthetic */ View $viewToAnimate;
    final /* synthetic */ DefaultSpecialEffectsController.AnimationEffect this$0;

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    DefaultSpecialEffectsController$AnimationEffect$onCommit$1(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, DefaultSpecialEffectsController.AnimationEffect animationEffect) {
        this.$operation = operation;
        this.$container = viewGroup;
        this.$viewToAnimate = view;
        this.this$0 = animationEffect;
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has reached onAnimationStart.");
        }
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ViewGroup viewGroup = this.$container;
        viewGroup.post(new DefaultSpecialEffectsController$AnimationEffect$onCommit$1$$ExternalSyntheticLambda0(viewGroup, this.$viewToAnimate, this.this$0));
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animation from operation " + this.$operation + " has ended.");
        }
    }

    /* access modifiers changed from: private */
    public static final void onAnimationEnd$lambda$0(ViewGroup viewGroup, View view, DefaultSpecialEffectsController.AnimationEffect animationEffect) {
        Intrinsics.checkNotNullParameter(viewGroup, "$container");
        Intrinsics.checkNotNullParameter(animationEffect, "this$0");
        viewGroup.endViewTransition(view);
        animationEffect.getAnimationInfo().getOperation().completeEffect(animationEffect);
    }
}
