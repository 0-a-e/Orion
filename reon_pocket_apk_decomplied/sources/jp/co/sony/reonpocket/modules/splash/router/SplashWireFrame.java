package jp.co.sony.reonpocket.modules.splash.router;

import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/modules/splash/router/SplashWireFrame;", "", "goToConnection", "", "isDisconnecting", "", "goToInitialize", "aEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "aPrivacyPolicy", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "goToPairing", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SplashRouter.kt */
public interface SplashWireFrame {
    void goToConnection(boolean z);

    void goToInitialize();

    void goToInitialize(InitWelcomeFragment.Eula eula);

    void goToInitialize(InitWelcomeFragment.Eula eula, InitWelcomeFragment.PrivacyPolicy privacyPolicy);

    void goToInitialize(InitWelcomeFragment.PrivacyPolicy privacyPolicy);

    void goToPairing();
}
