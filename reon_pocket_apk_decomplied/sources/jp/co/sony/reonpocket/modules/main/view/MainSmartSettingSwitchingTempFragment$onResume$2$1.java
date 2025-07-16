package jp.co.sony.reonpocket.modules.main.view;

import android.view.animation.Animation;
import android.widget.ImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"jp/co/sony/reonpocket/modules/main/view/MainSmartSettingSwitchingTempFragment$onResume$2$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartSettingSwitchingTempFragment.kt */
public final class MainSmartSettingSwitchingTempFragment$onResume$2$1 implements Animation.AnimationListener {
    final /* synthetic */ int $endPosition;
    final /* synthetic */ ImageView $it;

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    MainSmartSettingSwitchingTempFragment$onResume$2$1(ImageView imageView, int i) {
        this.$it = imageView;
        this.$endPosition = i;
    }

    public void onAnimationEnd(Animation animation) {
        ImageView imageView = this.$it;
        imageView.layout((int) imageView.getX(), this.$endPosition + (this.$it.getHeight() / 2), ((int) this.$it.getX()) + this.$it.getWidth(), this.$endPosition + (this.$it.getHeight() / 2) + this.$it.getHeight());
        this.$it.setAnimation((Animation) null);
    }
}
