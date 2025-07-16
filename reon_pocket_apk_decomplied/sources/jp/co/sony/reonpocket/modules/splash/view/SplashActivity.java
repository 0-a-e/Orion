package jp.co.sony.reonpocket.modules.splash.view;

import android.os.Bundle;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.splash.presenter.SplashPresenter;
import jp.co.sony.reonpocket.modules.splash.router.SplashRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/modules/splash/view/SplashActivity;", "Ljp/co/sony/reonpocket/modules/base/view/BaseActivity;", "Ljp/co/sony/reonpocket/modules/splash/view/SplashViewInput;", "()V", "mOutput", "Ljp/co/sony/reonpocket/modules/splash/view/SplashActivity$SplashViewOutput;", "initPresenter", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "isToolbar", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "SplashViewOutput", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SplashActivity.kt */
public final class SplashActivity extends BaseActivity implements SplashViewInput {
    public static final int $stable = 8;
    private SplashViewOutput mOutput;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Ljp/co/sony/reonpocket/modules/splash/view/SplashActivity$SplashViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "checkAppInitInfo", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SplashActivity.kt */
    public interface SplashViewOutput extends BaseViewOutput {
        void checkAppInitInfo();
    }

    /* access modifiers changed from: protected */
    public boolean isToolbar() {
        return false;
    }

    public BaseViewOutput initPresenter() {
        SplashViewOutput splashPresenter = new SplashPresenter(this, new SplashRouter(this), this);
        this.mOutput = splashPresenter;
        Intrinsics.checkNotNull(splashPresenter, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.splash.presenter.SplashPresenter");
        return (SplashPresenter) splashPresenter;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        SplashViewOutput splashViewOutput = this.mOutput;
        if (splashViewOutput != null) {
            splashViewOutput.checkAppInitInfo();
        }
    }
}
