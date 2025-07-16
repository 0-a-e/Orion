package jp.co.sony.reonpocket.modules.tagInfo.view;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragment$startAnimation$1", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoFragment.kt */
public final class TagInfoFragment$startAnimation$1 extends Animatable2.AnimationCallback {
    final /* synthetic */ AnimatedVectorDrawable $tempAnime;

    TagInfoFragment$startAnimation$1(AnimatedVectorDrawable animatedVectorDrawable) {
        this.$tempAnime = animatedVectorDrawable;
    }

    public void onAnimationEnd(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.$tempAnime.start();
    }
}
