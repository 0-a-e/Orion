package jp.co.sony.reonpocket.modules.splash.router;

import android.content.Context;
import android.os.Bundle;
import jp.co.sony.reonpocket.constant.IntentExtraConstant;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivity;
import jp.co.sony.reonpocket.modules.splash.view.SplashActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ljp/co/sony/reonpocket/modules/splash/router/SplashRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/splash/router/SplashWireFrame;", "aActivity", "Ljp/co/sony/reonpocket/modules/splash/view/SplashActivity;", "(Ljp/co/sony/reonpocket/modules/splash/view/SplashActivity;)V", "goToConnection", "", "isDisconnecting", "", "goToInitialize", "aEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "aPrivacyPolicy", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "goToMain", "goToPairing", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SplashRouter.kt */
public final class SplashRouter extends BaseRouter implements SplashWireFrame {
    public static final int $stable = 8;
    private final SplashActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashRouter(SplashActivity splashActivity) {
        super(splashActivity);
        Intrinsics.checkNotNullParameter(splashActivity, "aActivity");
        this.aActivity = splashActivity;
    }

    public void goToInitialize(InitWelcomeFragment.Eula eula) {
        Intrinsics.checkNotNullParameter(eula, "aEula");
        transitToActivity(InitializeActivity.Companion.createIntent((Context) this.aActivity, eula));
    }

    public void goToInitialize(InitWelcomeFragment.PrivacyPolicy privacyPolicy) {
        Intrinsics.checkNotNullParameter(privacyPolicy, "aPrivacyPolicy");
        transitToActivity(InitializeActivity.Companion.createIntent((Context) this.aActivity, privacyPolicy));
    }

    public void goToInitialize(InitWelcomeFragment.Eula eula, InitWelcomeFragment.PrivacyPolicy privacyPolicy) {
        Intrinsics.checkNotNullParameter(eula, "aEula");
        Intrinsics.checkNotNullParameter(privacyPolicy, "aPrivacyPolicy");
        transitToActivity(InitializeActivity.Companion.createIntent(this.aActivity, eula, privacyPolicy));
    }

    public void goToInitialize() {
        BaseRouter.transitToActivity$default(this, InitializeActivity.class, (Bundle) null, 2, (Object) null);
        finish();
    }

    public void goToPairing() {
        BaseRouter.transitToActivity$default(this, PairingActivity.class, (Bundle) null, 2, (Object) null);
        finish();
    }

    public void goToConnection(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(IntentExtraConstant.FromSplash.IS_DISCONNECTING.getKey(), z);
        bundle.putBoolean(IntentExtraConstant.FromSplash.IS_CONNECT_WHEN_ON_CREATE.getKey(), true);
        transitToActivity(ConnectionActivity.class, bundle);
        finish();
    }

    public final void goToMain() {
        BaseRouter.transitToActivity$default(this, MainActivity.class, (Bundle) null, 2, (Object) null);
        finish();
    }
}
