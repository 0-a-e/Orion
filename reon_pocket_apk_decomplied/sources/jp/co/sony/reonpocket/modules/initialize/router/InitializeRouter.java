package jp.co.sony.reonpocket.modules.initialize.router;

import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Slide;
import androidx.transition.TransitionSet;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.initialize.view.InitUserInfoFragment;
import jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity;
import jp.co.sony.reonpocket.modules.splash.view.SplashActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/router/InitializeRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/initialize/router/InitializeWireFrame;", "aActivity", "Ljp/co/sony/reonpocket/modules/initialize/view/InitializeActivity;", "(Ljp/co/sony/reonpocket/modules/initialize/view/InitializeActivity;)V", "goToPairing", "", "goToUserInfo", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InitializeRouter.kt */
public final class InitializeRouter extends BaseRouter implements InitializeWireFrame {
    public static final int $stable = 8;
    private final InitializeActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InitializeRouter(InitializeActivity initializeActivity) {
        super(initializeActivity);
        Intrinsics.checkNotNullParameter(initializeActivity, "aActivity");
        this.aActivity = initializeActivity;
    }

    public void goToUserInfo() {
        TransitionSet transitionSet = new TransitionSet();
        Slide slide = new Slide();
        slide.setSlideEdge(GravityCompat.END);
        transitionSet.addTransition(slide);
        FragmentManager supportFragmentManager = this.aActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.addToBackStack((String) null);
        InitUserInfoFragment newInstance = InitUserInfoFragment.Companion.newInstance();
        newInstance.setEnterTransition(transitionSet);
        beginTransaction.replace(R.id.fragment_container, newInstance);
        beginTransaction.commit();
    }

    public void goToPairing() {
        BaseRouter.transitToActivity$default(this, SplashActivity.class, (Bundle) null, 2, (Object) null);
        finish();
    }
}
