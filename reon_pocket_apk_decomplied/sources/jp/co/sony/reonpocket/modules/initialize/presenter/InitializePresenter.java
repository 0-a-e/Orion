package jp.co.sony.reonpocket.modules.initialize.presenter;

import android.content.Context;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.data.interactor.AlreadyShownInteractor;
import jp.co.sony.reonpocket.data.interactor.AlreadyShownInteractorInput;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.initialize.router.InitializeRouter;
import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity;
import jp.co.sony.reonpocket.modules.initialize.view.InitializeViewInput;
import jp.co.sony.reonpocket.util.Configuration;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J$\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u001a2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0015H\u0007J$\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0018H\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u001c\u0010\u001e\u001a\u00020\u00142\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u001d2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u001a\u0010+\u001a\u00020\u001d2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/presenter/InitializePresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/initialize/view/InitializeActivity$InitializeViewOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/initialize/view/InitializeViewInput;", "aRouter", "Ljp/co/sony/reonpocket/modules/initialize/router/InitializeRouter;", "aEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "aPrivacyPolicy", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/initialize/view/InitializeViewInput;Ljp/co/sony/reonpocket/modules/initialize/router/InitializeRouter;Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;)V", "mAlreadyShownInteractor", "Ljp/co/sony/reonpocket/data/interactor/AlreadyShownInteractorInput;", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "convertCountryEula", "Lkotlin/Pair;", "", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "aCountry", "convertCountryPrivacyPolicy", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "createEulaAcceptMap", "", "createPrivacyPolicyAcceptMap", "finishInitialize", "", "getCurrentDateString", "date", "Ljava/util/Date;", "locale", "Ljava/util/Locale;", "isFromMain", "", "navigateToNextScreen", "onCreate", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "saveEulaVersion", "savePrivacyPolicyVersion", "tapNextStep", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InitializePresenter.kt */
public final class InitializePresenter extends BasePresenter implements InitializeActivity.InitializeViewOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final InitWelcomeFragment.Eula aEula;
    private final InitWelcomeFragment.PrivacyPolicy aPrivacyPolicy;
    /* access modifiers changed from: private */
    public final InitializeRouter aRouter;
    private final InitializeViewInput aView;
    private AlreadyShownInteractorInput mAlreadyShownInteractor = new AlreadyShownInteractor();
    private UserInfoInteractorInput mUserInfoInteractor = new UserInfoInteractor();

    public InitializePresenter(Context context, InitializeViewInput initializeViewInput, InitializeRouter initializeRouter, InitWelcomeFragment.Eula eula, InitWelcomeFragment.PrivacyPolicy privacyPolicy) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(initializeViewInput, "aView");
        Intrinsics.checkNotNullParameter(initializeRouter, "aRouter");
        this.aContext = context;
        this.aView = initializeViewInput;
        this.aRouter = initializeRouter;
        this.aEula = eula;
        this.aPrivacyPolicy = privacyPolicy;
    }

    public void onCreate() {
        super.onCreate();
        if (isFromMain()) {
            this.aView.showEulaPpDialog();
        }
    }

    public void registerUserInfo(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "aUserInfoEntity");
        this.mUserInfoInteractor.saveUserInfo(this.aContext, userInfoEntity, true, new InitializePresenter$registerUserInfo$1(this));
    }

    public void tapNextStep() {
        InitWelcomeFragment.Eula eula = this.aEula;
        String localeCountry = RemoteConfigUtil.INSTANCE.getLocaleCountry();
        if (localeCountry == null) {
            localeCountry = Locale.getDefault().getCountry();
        }
        Intrinsics.checkNotNull(localeCountry);
        saveEulaVersion(eula, localeCountry);
        InitWelcomeFragment.PrivacyPolicy privacyPolicy = this.aPrivacyPolicy;
        String localeCountry2 = RemoteConfigUtil.INSTANCE.getLocaleCountry();
        if (localeCountry2 == null) {
            localeCountry2 = Locale.getDefault().getCountry();
        }
        Intrinsics.checkNotNull(localeCountry2);
        savePrivacyPolicyVersion(privacyPolicy, localeCountry2);
        navigateToNextScreen();
    }

    private final boolean isFromMain() {
        CharSequence macAddress = new DeviceInfoInteractor().getMacAddress(this.aContext);
        return !(macAddress == null || macAddress.length() == 0);
    }

    private final void saveEulaVersion(InitWelcomeFragment.Eula eula, String str) {
        Pair<String, Configuration.LocaleData.Eula> convertCountryEula = convertCountryEula(eula, str);
        Map<String, Configuration.LocaleData.Eula> createEulaAcceptMap = createEulaAcceptMap(convertCountryEula.component1(), convertCountryEula.component2());
        SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
        Context context = this.aContext;
        String json = new Gson().toJson((Object) createEulaAcceptMap);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        simpleStorageUtil.setStringValue(context, SimpleStorageUtil.REON_EULA_ACCEPTED_MAP, json);
        SimpleStorageUtil.INSTANCE.remove(this.aContext, SimpleStorageUtil.REON_EULA_VERSION);
    }

    public final Pair<String, Configuration.LocaleData.Eula> convertCountryEula(InitWelcomeFragment.Eula eula, String str) {
        Intrinsics.checkNotNullParameter(str, "aCountry");
        if (eula == null) {
            return new Pair<>(str, new Configuration.LocaleData.Eula((Integer) null, getCurrentDateString$default(this, (Date) null, (Locale) null, 3, (Object) null)));
        }
        return new Pair<>(eula.getCountry(), new Configuration.LocaleData.Eula(Integer.valueOf(eula.getVersion()), RemoteConfigUtil.JsonParser.INSTANCE.convertDateStringSsXXX2SsZZZ(eula.getDate())));
    }

    public final Map<String, Configuration.LocaleData.Eula> createEulaAcceptMap(String str, Configuration.LocaleData.Eula eula) {
        Map<String, Configuration.LocaleData.Eula> map;
        Intrinsics.checkNotNullParameter(str, "aCountry");
        Intrinsics.checkNotNullParameter(eula, "aEula");
        try {
            String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(this.aContext, SimpleStorageUtil.REON_EULA_ACCEPTED_MAP);
            CharSequence charSequence = stringValue;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    Type type = new InitializePresenter$createEulaAcceptMap$mutableMap$mapType$1().getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    Object fromJson = new Gson().fromJson(stringValue, type);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                    map = MapsKt.toMutableMap((Map) fromJson);
                    map.put(str, eula);
                    return map;
                }
            }
            map = new LinkedHashMap<>();
            map.put(str, eula);
            return map;
        } catch (Exception e) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String message = e.getMessage();
            debugLogUtil.e("Error " + message);
            return MapsKt.emptyMap();
        }
    }

    private final void savePrivacyPolicyVersion(InitWelcomeFragment.PrivacyPolicy privacyPolicy, String str) {
        Pair<String, Configuration.LocaleData.PrivacyPolicy> convertCountryPrivacyPolicy = convertCountryPrivacyPolicy(privacyPolicy, str);
        Map<String, Configuration.LocaleData.PrivacyPolicy> createPrivacyPolicyAcceptMap = createPrivacyPolicyAcceptMap(convertCountryPrivacyPolicy.component1(), convertCountryPrivacyPolicy.component2());
        SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
        Context context = this.aContext;
        String json = new Gson().toJson((Object) createPrivacyPolicyAcceptMap);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        simpleStorageUtil.setStringValue(context, SimpleStorageUtil.REON_PP_ACCEPTED_MAP, json);
    }

    public final Pair<String, Configuration.LocaleData.PrivacyPolicy> convertCountryPrivacyPolicy(InitWelcomeFragment.PrivacyPolicy privacyPolicy, String str) {
        Intrinsics.checkNotNullParameter(str, "aCountry");
        if (privacyPolicy == null) {
            return new Pair<>(str, new Configuration.LocaleData.PrivacyPolicy((Integer) null, getCurrentDateString$default(this, (Date) null, (Locale) null, 3, (Object) null)));
        }
        return new Pair<>(privacyPolicy.getCountry(), new Configuration.LocaleData.PrivacyPolicy(Integer.valueOf(privacyPolicy.getVersion()), RemoteConfigUtil.JsonParser.INSTANCE.convertDateStringSsXXX2SsZZZ(privacyPolicy.getDate())));
    }

    public final Map<String, Configuration.LocaleData.PrivacyPolicy> createPrivacyPolicyAcceptMap(String str, Configuration.LocaleData.PrivacyPolicy privacyPolicy) {
        Map<String, Configuration.LocaleData.PrivacyPolicy> map;
        Intrinsics.checkNotNullParameter(str, "aCountry");
        Intrinsics.checkNotNullParameter(privacyPolicy, "aPrivacyPolicy");
        try {
            String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(this.aContext, SimpleStorageUtil.REON_PP_ACCEPTED_MAP);
            CharSequence charSequence = stringValue;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    Type type = new InitializePresenter$createPrivacyPolicyAcceptMap$mutableMap$mapType$1().getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    Object fromJson = new Gson().fromJson(stringValue, type);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                    map = MapsKt.toMutableMap((Map) fromJson);
                    map.put(str, privacyPolicy);
                    return map;
                }
            }
            map = new LinkedHashMap<>();
            map.put(str, privacyPolicy);
            return map;
        } catch (Exception e) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String message = e.getMessage();
            debugLogUtil.e("Error " + message);
            return MapsKt.emptyMap();
        }
    }

    private final void navigateToNextScreen() {
        if (isFromMain()) {
            this.aRouter.finish();
        } else if (MyContentUtil.INSTANCE.isValidUserInfo(this.aContext)) {
            this.aRouter.goToUserInfo();
        } else {
            this.aRouter.goToPairing();
            this.mAlreadyShownInteractor.saveIsAlreadyShownWelcomeView(this.aContext, true);
        }
    }

    /* access modifiers changed from: private */
    public final void finishInitialize() {
        this.mUserInfoInteractor.saveReonInitializeFlag(this.aContext, true);
        this.mAlreadyShownInteractor.saveIsAlreadyShownWelcomeView(this.aContext, true);
    }

    public static /* synthetic */ String getCurrentDateString$default(InitializePresenter initializePresenter, Date date, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            date = new Date();
        }
        if ((i & 2) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        }
        return initializePresenter.getCurrentDateString(date, locale);
    }

    public final String getCurrentDateString(Date date, Locale locale) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", locale).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
