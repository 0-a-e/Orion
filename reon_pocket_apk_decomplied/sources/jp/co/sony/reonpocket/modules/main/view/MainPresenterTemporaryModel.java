package jp.co.sony.reonpocket.modules.main.view;

import android.content.Context;
import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import jp.co.sony.reonpocket.modules.main.router.MainRouter;
import jp.co.sony.reonpocket.util.Configuration;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainPresenterTemporaryModel;", "", "()V", "checkEulaVersion", "", "aContext", "Landroid/content/Context;", "aRouter", "Ljp/co/sony/reonpocket/modules/main/router/MainRouter;", "aBuildTYpe", "", "checkPrivacyPolicyVersion", "createInitWelcomeFragmentEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "createInitWelcomeFragmentPP", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainPresenterTemporaryModel.kt */
public final class MainPresenterTemporaryModel {
    public static final int $stable = 0;
    public static final MainPresenterTemporaryModel INSTANCE = new MainPresenterTemporaryModel();

    private MainPresenterTemporaryModel() {
    }

    public static /* synthetic */ boolean checkEulaVersion$default(MainPresenterTemporaryModel mainPresenterTemporaryModel, Context context, MainRouter mainRouter, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "release";
        }
        return mainPresenterTemporaryModel.checkEulaVersion(context, mainRouter, str);
    }

    public final boolean checkEulaVersion(Context context, MainRouter mainRouter, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(mainRouter, "aRouter");
        Intrinsics.checkNotNullParameter(str, "aBuildTYpe");
        if (Intrinsics.areEqual((Object) str, (Object) "exhibition")) {
            return false;
        }
        Configuration.LocaleData.Eula eula = RemoteConfigUtil.INSTANCE.getEula();
        if (eula == null) {
            DebugLogUtil.INSTANCE.w("RemoteConfigUtil.eula is null.");
            return false;
        }
        String localeCountry = RemoteConfigUtil.INSTANCE.getLocaleCountry();
        if (localeCountry == null) {
            DebugLogUtil.INSTANCE.w("RemoteConfigUtil.localeCountry is null.");
            return false;
        } else if (!RemoteConfigUtil.INSTANCE.shouldUpdateEula(context, localeCountry, eula.getVersion(), eula.getDate())) {
            return false;
        } else {
            InitWelcomeFragment.PrivacyPolicy createInitWelcomeFragmentPP = createInitWelcomeFragmentPP();
            InitWelcomeFragment.Eula createInitWelcomeFragmentEula = createInitWelcomeFragmentEula();
            if (createInitWelcomeFragmentEula == null) {
                return false;
            }
            if (createInitWelcomeFragmentPP == null) {
                mainRouter.goToInitialize(createInitWelcomeFragmentEula);
                return true;
            }
            mainRouter.goToInitialize(createInitWelcomeFragmentEula, createInitWelcomeFragmentPP);
            return true;
        }
    }

    public static /* synthetic */ boolean checkPrivacyPolicyVersion$default(MainPresenterTemporaryModel mainPresenterTemporaryModel, Context context, MainRouter mainRouter, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "release";
        }
        return mainPresenterTemporaryModel.checkPrivacyPolicyVersion(context, mainRouter, str);
    }

    public final boolean checkPrivacyPolicyVersion(Context context, MainRouter mainRouter, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(mainRouter, "aRouter");
        Intrinsics.checkNotNullParameter(str, "aBuildTYpe");
        if (Intrinsics.areEqual((Object) str, (Object) "exhibition")) {
            return false;
        }
        Configuration.LocaleData.PrivacyPolicy privacyPolicy = RemoteConfigUtil.INSTANCE.getPrivacyPolicy();
        if (privacyPolicy == null) {
            DebugLogUtil.INSTANCE.w("RemoteConfigUtil.privacyPolicy is null.");
            return false;
        }
        String localeCountry = RemoteConfigUtil.INSTANCE.getLocaleCountry();
        if (localeCountry == null) {
            DebugLogUtil.INSTANCE.w("RemoteConfigUtil.localeCountry is null.");
            return false;
        } else if (!RemoteConfigUtil.INSTANCE.shouldUpdatePrivacyPolicy(context, localeCountry, privacyPolicy.getVersion(), privacyPolicy.getDate())) {
            return false;
        } else {
            InitWelcomeFragment.Eula createInitWelcomeFragmentEula = createInitWelcomeFragmentEula();
            InitWelcomeFragment.PrivacyPolicy createInitWelcomeFragmentPP = createInitWelcomeFragmentPP();
            if (createInitWelcomeFragmentPP == null) {
                return false;
            }
            if (createInitWelcomeFragmentEula == null) {
                mainRouter.goToInitialize(createInitWelcomeFragmentPP);
                return true;
            }
            mainRouter.goToInitialize(createInitWelcomeFragmentEula, createInitWelcomeFragmentPP);
            return true;
        }
    }

    private final InitWelcomeFragment.Eula createInitWelcomeFragmentEula() {
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

    private final InitWelcomeFragment.PrivacyPolicy createInitWelcomeFragmentPP() {
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
}
