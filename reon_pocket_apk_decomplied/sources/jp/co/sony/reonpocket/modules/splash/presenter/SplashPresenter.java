package jp.co.sony.reonpocket.modules.splash.presenter;

import android.app.Activity;
import android.content.Context;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Random;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.data.interactor.AlreadyShownInteractor;
import jp.co.sony.reonpocket.data.interactor.AlreadyShownInteractorInput;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.FirebaseMessageInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import jp.co.sony.reonpocket.modules.splash.router.SplashRouter;
import jp.co.sony.reonpocket.modules.splash.view.SplashActivity;
import jp.co.sony.reonpocket.modules.splash.view.SplashViewInput;
import jp.co.sony.reonpocket.util.Configuration;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0007J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ljp/co/sony/reonpocket/modules/splash/presenter/SplashPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/splash/view/SplashActivity$SplashViewOutput;", "aContext", "Landroid/content/Context;", "mRouter", "Ljp/co/sony/reonpocket/modules/splash/router/SplashRouter;", "aView", "Ljp/co/sony/reonpocket/modules/splash/view/SplashViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/splash/router/SplashRouter;Ljp/co/sony/reonpocket/modules/splash/view/SplashViewInput;)V", "mAlreadyShownInteractor", "Ljp/co/sony/reonpocket/data/interactor/AlreadyShownInteractorInput;", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractor;", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mFirebaseMessageInteractor", "Ljp/co/sony/reonpocket/data/interactor/FirebaseMessageInteractor;", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "checkAlreadyConfigured", "", "checkAppInitInfo", "", "createInitWelcomeFragmentEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "createInitWelcomeFragmentPP", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "fetchFirebaseRemoteConfig", "isDisconnecting", "generateUUIDArray", "goToInitialize", "onCreate", "onDestroy", "transferToNextScreen", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SplashPresenter.kt */
public final class SplashPresenter extends BasePresenter implements SplashActivity.SplashViewOutput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final IntRange OWNER_ID_BYTE_LENGTH = RangesKt.until(0, 16);
    private final Context aContext;
    private final SplashViewInput aView;
    private AlreadyShownInteractorInput mAlreadyShownInteractor = new AlreadyShownInteractor();
    private BleInteractor mBleInteractor = new BleInteractor();
    private DeviceInfoInteractorInput mDeviceInfoInteractor = new DeviceInfoInteractor();
    private FirebaseMessageInteractor mFirebaseMessageInteractor = new FirebaseMessageInteractor();
    private final SplashRouter mRouter;
    private UserInfoInteractorInput mUserInfoInteractor = new UserInfoInteractor();

    public SplashPresenter(Context context, SplashRouter splashRouter, SplashViewInput splashViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(splashRouter, "mRouter");
        this.aContext = context;
        this.mRouter = splashRouter;
        this.aView = splashViewInput;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/splash/presenter/SplashPresenter$Companion;", "", "()V", "OWNER_ID_BYTE_LENGTH", "Lkotlin/ranges/IntRange;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SplashPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onCreate() {
        this.mBleInteractor.onCreate(this.aContext);
        this.mFirebaseMessageInteractor.subscribeToTopicAll();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    public void checkAppInitInfo() {
        boolean z;
        if (BleInteractor.Companion.getMConnectionStatus() == BleConnStatusCode.CONNECTED) {
            BleInteractor.Companion.setMConnectCallbackListener((Function2<? super BleConnStatusCode, ? super ArrayList<String>, Unit>) null);
            this.mBleInteractor.disconnect();
            z = true;
        } else {
            z = false;
        }
        CharSequence ownerID = this.mUserInfoInteractor.getOwnerID(this.aContext);
        if (ownerID == null || ownerID.length() == 0) {
            generateUUIDArray();
        }
        fetchFirebaseRemoteConfig(z);
    }

    private final boolean checkAlreadyConfigured() {
        return this.mUserInfoInteractor.getIsAlreadyUserInfoSetup(this.aContext) | this.mAlreadyShownInteractor.getIsAlreadyShownWelcomeView(this.aContext);
    }

    private final void fetchFirebaseRemoteConfig(boolean z) {
        RemoteConfigUtil remoteConfigUtil = RemoteConfigUtil.INSTANCE;
        Context context = this.aContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        remoteConfigUtil.fetchAndActivate((Activity) context, instance, new SplashPresenter$fetchFirebaseRemoteConfig$1(this, z));
    }

    /* access modifiers changed from: private */
    public final void transferToNextScreen(boolean z) {
        if (checkAlreadyConfigured()) {
            CharSequence macAddress = this.mDeviceInfoInteractor.getMacAddress(this.aContext);
            if (macAddress == null || macAddress.length() == 0) {
                this.mRouter.goToPairing();
            } else {
                this.mRouter.goToConnection(z);
            }
        } else {
            goToInitialize();
        }
    }

    public final void goToInitialize() {
        InitWelcomeFragment.Eula createInitWelcomeFragmentEula = createInitWelcomeFragmentEula();
        InitWelcomeFragment.PrivacyPolicy createInitWelcomeFragmentPP = createInitWelcomeFragmentPP();
        if (createInitWelcomeFragmentPP == null && createInitWelcomeFragmentEula == null) {
            this.mRouter.goToInitialize();
        } else if (createInitWelcomeFragmentPP != null && createInitWelcomeFragmentEula != null) {
            this.mRouter.goToInitialize(createInitWelcomeFragmentEula, createInitWelcomeFragmentPP);
        } else if (createInitWelcomeFragmentPP != null && createInitWelcomeFragmentEula == null) {
            this.mRouter.goToInitialize(createInitWelcomeFragmentPP);
        } else if (createInitWelcomeFragmentEula != null) {
            this.mRouter.goToInitialize(createInitWelcomeFragmentEula);
        }
    }

    public final InitWelcomeFragment.Eula createInitWelcomeFragmentEula() {
        Integer version;
        String date;
        String localeCountry;
        Configuration.LocaleData.Eula eula = RemoteConfigUtil.INSTANCE.getEula();
        if (eula == null || (version = eula.getVersion()) == null) {
            return null;
        }
        int intValue = version.intValue();
        Configuration.LocaleData.Eula eula2 = RemoteConfigUtil.INSTANCE.getEula();
        if (eula2 == null || (date = eula2.getDate()) == null || (localeCountry = RemoteConfigUtil.INSTANCE.getLocaleCountry()) == null) {
            return null;
        }
        return new InitWelcomeFragment.Eula(intValue, date, localeCountry);
    }

    public final InitWelcomeFragment.PrivacyPolicy createInitWelcomeFragmentPP() {
        Integer version;
        String date;
        String localeCountry;
        Configuration.LocaleData.PrivacyPolicy privacyPolicy = RemoteConfigUtil.INSTANCE.getPrivacyPolicy();
        if (privacyPolicy == null || (version = privacyPolicy.getVersion()) == null) {
            return null;
        }
        int intValue = version.intValue();
        Configuration.LocaleData.PrivacyPolicy privacyPolicy2 = RemoteConfigUtil.INSTANCE.getPrivacyPolicy();
        if (privacyPolicy2 == null || (date = privacyPolicy2.getDate()) == null || (localeCountry = RemoteConfigUtil.INSTANCE.getLocaleCountry()) == null) {
            return null;
        }
        return new InitWelcomeFragment.PrivacyPolicy(intValue, date, localeCountry);
    }

    private final void generateUUIDArray() {
        Random random = new Random(System.currentTimeMillis());
        IntRange intRange = OWNER_ID_BYTE_LENGTH;
        int first = intRange.getFirst();
        int last = intRange.getLast();
        String str = "";
        if (first <= last) {
            while (true) {
                str = str + random.nextInt(255) + " ";
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        this.mUserInfoInteractor.saveOwnerID(this.aContext, str);
    }
}
