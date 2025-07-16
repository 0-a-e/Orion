package jp.co.sony.reonpocket.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.UsageEntity;
import jp.co.sony.reonpocket.util.Configuration;
import jp.co.sony.reonpocket.view.DeviceTemperatureView;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010X\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0004H\u0007J,\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u0016H\u0007J\u001e\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hJ*\u0010i\u001a\u0004\u0018\u00010j2\u0006\u0010k\u001a\u00020\u00042\u0016\u0010l\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010j\u0018\u00010\\H\u0007J\u0018\u0010m\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\u0006\u0010e\u001a\u00020fH\u0007J\u0010\u0010n\u001a\u00020b2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010o\u001a\u00020b2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010p\u001a\u00020b2\u0006\u0010e\u001a\u00020fH\u0002J\u0018\u0010q\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH\u0002J \u0010r\u001a\u0012\u0012\u0004\u0012\u00020\u00160=j\b\u0012\u0004\u0012\u00020\u0016`>2\u0006\u0010e\u001a\u00020fH\u0007J \u0010s\u001a\u0012\u0012\u0004\u0012\u00020\u00160=j\b\u0012\u0004\u0012\u00020\u0016`>2\u0006\u0010e\u001a\u00020fH\u0007J\u001e\u0010t\u001a\u00020b2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u0016J\u0012\u0010u\u001a\u00020b2\b\u0010v\u001a\u0004\u0018\u00010wH\u0007J9\u0010x\u001a\u00020y2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00042\b\u0010z\u001a\u0004\u0018\u00010\u00162\b\u0010{\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010|\u001a\u00020}¢\u0006\u0002\u0010~J0\u0010\u001a\u00020y2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00042\b\u0010z\u001a\u0004\u0018\u00010\u00162\b\u0010{\u001a\u0004\u0018\u00010\u0004¢\u0006\u0003\u0010\u0001J1\u0010\u0001\u001a\u00020y2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00042\b\u0010z\u001a\u0004\u0018\u00010\u00162\b\u0010{\u001a\u0004\u0018\u00010\u0004¢\u0006\u0003\u0010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010%@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R(\u00107\u001a\u0004\u0018\u0001062\b\u0010$\u001a\u0004\u0018\u000106@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00160=j\b\u0012\u0004\u0012\u00020\u0016`>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u00160=j\b\u0012\u0004\u0012\u00020\u0016`>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u001c\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010S\u001a\u0004\u0018\u00010R2\b\u0010$\u001a\u0004\u0018\u00010R@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006\u0001"}, d2 = {"Ljp/co/sony/reonpocket/util/RemoteConfigUtil;", "", "()V", "CONFIG_KEY_APP", "", "CONFIG_KEY_BUTTON_PREFERENCE", "CONFIG_KEY_COUNT", "CONFIG_KEY_DATE", "CONFIG_KEY_DESCRIPTION", "CONFIG_KEY_EULA", "CONFIG_KEY_EXPIRED_AT", "CONFIG_KEY_FB", "CONFIG_KEY_IMAGE_PATH", "CONFIG_KEY_LOCALE", "CONFIG_KEY_NOTIFICATION", "CONFIG_KEY_PRIVACY_POLICY", "CONFIG_KEY_RATIO", "CONFIG_KEY_SUBTITLE", "CONFIG_KEY_TITLE", "CONFIG_KEY_URL", "CONFIG_KEY_VERSION", "ENTITIES_ROW", "", "KEY_COOL_PREFERENCE", "KEY_REMOTE_CONFIG", "getKEY_REMOTE_CONFIG$annotations", "KEY_TEMPERATURE_PREFERENCE", "KEY_THERMO_DISPLAY_THRESHOLD", "KEY_USAGE_THRESHOLD_COOL", "KEY_USAGE_THRESHOLD_WARM", "KEY_USER_FEEDBACK_URL", "KEY_WARM_PREFERENCE", "MAX_TEMPERATURE", "MID_TEMPERATURE", "MIN_TEMPERATURE", "TAG", "<set-?>", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "eula", "getEula", "()Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "setEula", "(Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;)V", "localeCountry", "getLocaleCountry", "()Ljava/lang/String;", "setLocaleCountry", "(Ljava/lang/String;)V", "mFacebookUrl", "getMFacebookUrl", "setMFacebookUrl", "mFeedBackUrl", "getMFeedBackUrl", "setMFeedBackUrl", "Ljp/co/sony/reonpocket/data/entity/NotificationEntity;", "mNotificationEntity", "getMNotificationEntity", "()Ljp/co/sony/reonpocket/data/entity/NotificationEntity;", "setMNotificationEntity", "(Ljp/co/sony/reonpocket/data/entity/NotificationEntity;)V", "mSmartCoolTemperaturePreferenceEntities", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMSmartCoolTemperaturePreferenceEntities", "()Ljava/util/ArrayList;", "setMSmartCoolTemperaturePreferenceEntities", "(Ljava/util/ArrayList;)V", "mSmartWarmTemperaturePreferenceEntities", "getMSmartWarmTemperaturePreferenceEntities", "setMSmartWarmTemperaturePreferenceEntities", "mTemperatureThresholdEntity", "Ljp/co/sony/reonpocket/view/DeviceTemperatureView$TemperatureThresholdEntity;", "getMTemperatureThresholdEntity", "()Ljp/co/sony/reonpocket/view/DeviceTemperatureView$TemperatureThresholdEntity;", "setMTemperatureThresholdEntity", "(Ljp/co/sony/reonpocket/view/DeviceTemperatureView$TemperatureThresholdEntity;)V", "mUsageEntity", "Ljp/co/sony/reonpocket/data/entity/UsageEntity;", "getMUsageEntity", "()Ljp/co/sony/reonpocket/data/entity/UsageEntity;", "setMUsageEntity", "(Ljp/co/sony/reonpocket/data/entity/UsageEntity;)V", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "privacyPolicy", "getPrivacyPolicy", "()Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "setPrivacyPolicy", "(Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;)V", "compareVersion", "aVersion1", "aVersion2", "createNotificationMap", "", "aContext", "Landroid/content/Context;", "aCountry", "aVersion", "fetchAndActivate", "", "aActivity", "Landroid/app/Activity;", "aFirebaseRemoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "aOnFetchFinishListener", "Ljp/co/sony/reonpocket/util/RemoteConfigUtil$OnFetchFinishListener;", "getLocaleData", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData;", "country", "localeDataMap", "parseAndUpdateRemoteConfig", "parseAndUpdateTemperaturePref", "parseAndUpdateThermoInfo", "parseAndUpdateUsageInfo", "parseAndUpdateUserFeedbackUrl", "parseCoolTemperaturePref", "parseWarmTemperaturePref", "saveNotificationVersion", "setNotificationEntity", "aNotification", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Notification;", "shouldShowNotification", "", "aRemoteVersion", "aRemoteDate", "aCurrentDate", "Ljava/util/Date;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Date;)Z", "shouldUpdateEula", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Z", "shouldUpdatePrivacyPolicy", "JsonParser", "OnFetchFinishListener", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RemoteConfigUtil.kt */
public final class RemoteConfigUtil {
    public static final int $stable = 8;
    private static final String CONFIG_KEY_APP = "app";
    private static final String CONFIG_KEY_BUTTON_PREFERENCE = "button_preference";
    private static final String CONFIG_KEY_COUNT = "count";
    private static final String CONFIG_KEY_DATE = "date";
    private static final String CONFIG_KEY_DESCRIPTION = "description";
    private static final String CONFIG_KEY_EULA = "eula";
    private static final String CONFIG_KEY_EXPIRED_AT = "expiredAt";
    private static final String CONFIG_KEY_FB = "facebook";
    private static final String CONFIG_KEY_IMAGE_PATH = "image_path";
    private static final String CONFIG_KEY_LOCALE = "locale";
    private static final String CONFIG_KEY_NOTIFICATION = "notification";
    private static final String CONFIG_KEY_PRIVACY_POLICY = "privacy_policy";
    private static final String CONFIG_KEY_RATIO = "ratio";
    private static final String CONFIG_KEY_SUBTITLE = "subtitle";
    private static final String CONFIG_KEY_TITLE = "title";
    private static final String CONFIG_KEY_URL = "url";
    private static final String CONFIG_KEY_VERSION = "version";
    private static int ENTITIES_ROW = 5;
    public static final RemoteConfigUtil INSTANCE = new RemoteConfigUtil();
    private static final String KEY_COOL_PREFERENCE = "cool";
    public static final String KEY_REMOTE_CONFIG = "configuration";
    private static final String KEY_TEMPERATURE_PREFERENCE = "temperature_preference";
    private static final String KEY_THERMO_DISPLAY_THRESHOLD = "thermo_display_param";
    private static final String KEY_USAGE_THRESHOLD_COOL = "heavy_usage_alert_threshold_cool";
    private static final String KEY_USAGE_THRESHOLD_WARM = "heavy_usage_alert_threshold_warm";
    private static final String KEY_USER_FEEDBACK_URL = "feedback_form_url";
    private static final String KEY_WARM_PREFERENCE = "warm";
    private static final String MAX_TEMPERATURE = "max_temperature";
    private static final String MID_TEMPERATURE = "mid_temperature";
    private static final String MIN_TEMPERATURE = "min_temperature";
    private static final String TAG = "RemoteConfigUtil";
    private static Configuration.LocaleData.Eula eula;
    private static String localeCountry;
    private static String mFacebookUrl = "#";
    private static String mFeedBackUrl;
    private static NotificationEntity mNotificationEntity;
    private static ArrayList<Integer> mSmartCoolTemperaturePreferenceEntities = new ArrayList<>();
    private static ArrayList<Integer> mSmartWarmTemperaturePreferenceEntities = new ArrayList<>();
    private static DeviceTemperatureView.TemperatureThresholdEntity mTemperatureThresholdEntity;
    private static UsageEntity mUsageEntity;
    private static Configuration.LocaleData.PrivacyPolicy privacyPolicy;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Ljp/co/sony/reonpocket/util/RemoteConfigUtil$OnFetchFinishListener;", "", "onFetchFinish", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RemoteConfigUtil.kt */
    public interface OnFetchFinishListener {
        void onFetchFinish();
    }

    public static /* synthetic */ void getKEY_REMOTE_CONFIG$annotations() {
    }

    private RemoteConfigUtil() {
    }

    public final String getLocaleCountry() {
        return localeCountry;
    }

    public final void setLocaleCountry(String str) {
        localeCountry = str;
    }

    public final Configuration.LocaleData.Eula getEula() {
        return eula;
    }

    public final void setEula(Configuration.LocaleData.Eula eula2) {
        eula = eula2;
    }

    public final Configuration.LocaleData.PrivacyPolicy getPrivacyPolicy() {
        return privacyPolicy;
    }

    public final void setPrivacyPolicy(Configuration.LocaleData.PrivacyPolicy privacyPolicy2) {
        privacyPolicy = privacyPolicy2;
    }

    public final NotificationEntity getMNotificationEntity() {
        return mNotificationEntity;
    }

    public final void setMNotificationEntity(NotificationEntity notificationEntity) {
        mNotificationEntity = notificationEntity;
    }

    public final UsageEntity getMUsageEntity() {
        return mUsageEntity;
    }

    public final void setMUsageEntity(UsageEntity usageEntity) {
        mUsageEntity = usageEntity;
    }

    public final String getMFacebookUrl() {
        return mFacebookUrl;
    }

    public final void setMFacebookUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        mFacebookUrl = str;
    }

    public final String getMFeedBackUrl() {
        return mFeedBackUrl;
    }

    public final void setMFeedBackUrl(String str) {
        mFeedBackUrl = str;
    }

    public final DeviceTemperatureView.TemperatureThresholdEntity getMTemperatureThresholdEntity() {
        return mTemperatureThresholdEntity;
    }

    public final void setMTemperatureThresholdEntity(DeviceTemperatureView.TemperatureThresholdEntity temperatureThresholdEntity) {
        mTemperatureThresholdEntity = temperatureThresholdEntity;
    }

    public final ArrayList<Integer> getMSmartCoolTemperaturePreferenceEntities() {
        return mSmartCoolTemperaturePreferenceEntities;
    }

    public final void setMSmartCoolTemperaturePreferenceEntities(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        mSmartCoolTemperaturePreferenceEntities = arrayList;
    }

    public final ArrayList<Integer> getMSmartWarmTemperaturePreferenceEntities() {
        return mSmartWarmTemperaturePreferenceEntities;
    }

    public final void setMSmartWarmTemperaturePreferenceEntities(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        mSmartWarmTemperaturePreferenceEntities = arrayList;
    }

    public final void fetchAndActivate(Activity activity, FirebaseRemoteConfig firebaseRemoteConfig, OnFetchFinishListener onFetchFinishListener) {
        Intrinsics.checkNotNullParameter(activity, "aActivity");
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "aFirebaseRemoteConfig");
        Intrinsics.checkNotNullParameter(onFetchFinishListener, "aOnFetchFinishListener");
        FirebaseRemoteConfigSettings build = new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(600).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        firebaseRemoteConfig.setConfigSettingsAsync(build);
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(activity, new RemoteConfigUtil$$ExternalSyntheticLambda0(firebaseRemoteConfig, activity, onFetchFinishListener));
    }

    /* access modifiers changed from: private */
    public static final void fetchAndActivate$lambda$0(FirebaseRemoteConfig firebaseRemoteConfig, Activity activity, OnFetchFinishListener onFetchFinishListener, Task task) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "$aFirebaseRemoteConfig");
        Intrinsics.checkNotNullParameter(activity, "$aActivity");
        Intrinsics.checkNotNullParameter(onFetchFinishListener, "$aOnFetchFinishListener");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.d(TAG, "Remote Config params updated: " + ((Boolean) task.getResult()));
        } else {
            DebugLogUtil.INSTANCE.e(TAG, "Remote Config fetch failed");
        }
        RemoteConfigUtil remoteConfigUtil = INSTANCE;
        remoteConfigUtil.parseAndUpdateTemperaturePref(firebaseRemoteConfig);
        remoteConfigUtil.parseAndUpdateRemoteConfig(activity, firebaseRemoteConfig);
        remoteConfigUtil.parseAndUpdateUsageInfo(firebaseRemoteConfig);
        remoteConfigUtil.parseAndUpdateThermoInfo(firebaseRemoteConfig);
        remoteConfigUtil.parseAndUpdateUserFeedbackUrl(activity, firebaseRemoteConfig);
        onFetchFinishListener.onFetchFinish();
    }

    private final void parseAndUpdateTemperaturePref(FirebaseRemoteConfig firebaseRemoteConfig) {
        mSmartCoolTemperaturePreferenceEntities = parseCoolTemperaturePref(firebaseRemoteConfig);
        mSmartWarmTemperaturePreferenceEntities = parseWarmTemperaturePref(firebaseRemoteConfig);
    }

    public final ArrayList<Integer> parseCoolTemperaturePref(FirebaseRemoteConfig firebaseRemoteConfig) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "aFirebaseRemoteConfig");
        String string = firebaseRemoteConfig.getString(KEY_TEMPERATURE_PREFERENCE);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(string).get(KEY_COOL_PREFERENCE).toString());
            int i = ENTITIES_ROW;
            int i2 = 1;
            if (1 <= i) {
                while (true) {
                    String string2 = jSONObject.getString("step_" + i2);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    arrayList.add(Integer.valueOf((int) (Float.parseFloat(string2) * ((float) 100))));
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
        } catch (JSONException unused) {
            DebugLogUtil.INSTANCE.e("Failed to parse cool temperature pref from json");
        }
        return arrayList;
    }

    public final ArrayList<Integer> parseWarmTemperaturePref(FirebaseRemoteConfig firebaseRemoteConfig) {
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "aFirebaseRemoteConfig");
        String string = firebaseRemoteConfig.getString(KEY_TEMPERATURE_PREFERENCE);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(string).get(KEY_WARM_PREFERENCE).toString());
            int i = ENTITIES_ROW;
            int i2 = 1;
            if (1 <= i) {
                while (true) {
                    String string2 = jSONObject.getString("step_" + i2);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    arrayList.add(Integer.valueOf((int) (Float.parseFloat(string2) * ((float) 100))));
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                }
            }
        } catch (JSONException unused) {
            DebugLogUtil.INSTANCE.e("Failed to parse warm temperature pref from json");
        }
        return arrayList;
    }

    public final void parseAndUpdateRemoteConfig(Context context, FirebaseRemoteConfig firebaseRemoteConfig) {
        String str;
        Locale locale;
        Configuration.LocaleData.Facebook facebook;
        String url;
        Configuration.App app;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(firebaseRemoteConfig, "aFirebaseRemoteConfig");
        String string = firebaseRemoteConfig.getString(KEY_REMOTE_CONFIG);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        try {
            Configuration parseConfiguration = JsonParser.INSTANCE.parseConfiguration(string);
            if (parseConfiguration == null || (app = parseConfiguration.getApp()) == null || (str = app.getVersion()) == null) {
                str = "";
            }
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.d("remote app version:" + str);
            DebugLogUtil.INSTANCE.d("local app version:2.1.3");
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = context.getResources().getConfiguration().locale;
            }
            localeCountry = locale.getCountry();
            Map<String, Configuration.LocaleData> localeDataMap = parseConfiguration != null ? parseConfiguration.getLocaleDataMap() : null;
            String country = locale.getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
            Configuration.LocaleData localeData = getLocaleData(country, localeDataMap);
            if (!(localeData == null || (facebook = localeData.getFacebook()) == null || (url = facebook.getUrl()) == null)) {
                mFacebookUrl = url;
            }
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String str2 = mFacebookUrl;
            debugLogUtil2.d("facebook url:" + str2);
            String name = localeData != null ? localeData.getName() : null;
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            debugLogUtil3.d("locale name:" + name);
            setNotificationEntity(localeData != null ? localeData.getNotification() : null);
            eula = localeData != null ? localeData.getEula() : null;
            privacyPolicy = localeData != null ? localeData.getPrivacyPolicy() : null;
        } catch (Exception unused) {
            DebugLogUtil.INSTANCE.e("Remote config parse error");
            mNotificationEntity = null;
        }
    }

    public final void setNotificationEntity(Configuration.LocaleData.Notification notification) {
        Integer version;
        if (notification != null && (version = notification.getVersion()) != null) {
            version.intValue();
            if (notification.getTitle() != null && notification.getSubtitle() != null && notification.getDescription() != null) {
                int intValue = notification.getVersion().intValue();
                String date = notification.getDate();
                if (date == null) {
                    date = "";
                }
                mNotificationEntity = new NotificationEntity(intValue, date, notification.getTitle(), notification.getSubtitle(), notification.getButtonPreference(), notification.getImagePath(), notification.getUrl(), notification.getDescription(), notification.getImagePath());
            }
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006!"}, d2 = {"Ljp/co/sony/reonpocket/util/RemoteConfigUtil$JsonParser;", "", "()V", "convertDateStringSsXXX2SsZZZ", "", "ssXXX", "parseAppData", "Ljp/co/sony/reonpocket/util/Configuration$App;", "jsonObject", "Lorg/json/JSONObject;", "parseConfiguration", "Ljp/co/sony/reonpocket/util/Configuration;", "jsonString", "parseDateStringSsXXX2Date", "Ljava/util/Date;", "parseDateStringSsZZZ2Date", "ssZZZ", "parseEulaData", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Eula;", "parseFacebookData", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Facebook;", "parseIntValue", "", "key", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "parseLocaleData", "", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData;", "parseNotificationData", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$Notification;", "parsePrivacyPolicyData", "Ljp/co/sony/reonpocket/util/Configuration$LocaleData$PrivacyPolicy;", "parseSingleLocaleData", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RemoteConfigUtil.kt */
    public static final class JsonParser {
        public static final int $stable = 0;
        public static final JsonParser INSTANCE = new JsonParser();

        private JsonParser() {
        }

        public final Configuration parseConfiguration(String str) {
            Intrinsics.checkNotNullParameter(str, "jsonString");
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Configuration(parseAppData(jSONObject.optJSONObject(RemoteConfigUtil.CONFIG_KEY_APP)), parseLocaleData(jSONObject.optJSONObject(RemoteConfigUtil.CONFIG_KEY_LOCALE)));
            } catch (Exception e) {
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                String message = e.getMessage();
                debugLogUtil.e("Error parsing RemoteConfigData: " + message);
                return null;
            }
        }

        private final Configuration.App parseAppData(JSONObject jSONObject) {
            if (jSONObject != null) {
                return new Configuration.App(jSONObject.getString(RemoteConfigUtil.CONFIG_KEY_VERSION));
            }
            return null;
        }

        private final Map<String, Configuration.LocaleData> parseLocaleData(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            Map<String, Configuration.LocaleData> linkedHashMap = new LinkedHashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                Intrinsics.checkNotNull(next);
                linkedHashMap.put(next, INSTANCE.parseSingleLocaleData(optJSONObject));
            }
            return linkedHashMap;
        }

        private final Configuration.LocaleData parseSingleLocaleData(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            JsonParser jsonParser = INSTANCE;
            return new Configuration.LocaleData((String) null, jsonParser.parseFacebookData(jSONObject.optJSONObject(RemoteConfigUtil.CONFIG_KEY_FB)), jsonParser.parseNotificationData(jSONObject.optJSONObject("notification")), jsonParser.parseEulaData(jSONObject.optJSONObject(RemoteConfigUtil.CONFIG_KEY_EULA)), jsonParser.parsePrivacyPolicyData(jSONObject.optJSONObject(RemoteConfigUtil.CONFIG_KEY_PRIVACY_POLICY)), 1, (DefaultConstructorMarker) null);
        }

        private final Configuration.LocaleData.Facebook parseFacebookData(JSONObject jSONObject) {
            if (jSONObject != null) {
                return new Configuration.LocaleData.Facebook(jSONObject.getString("url"));
            }
            return null;
        }

        private final Configuration.LocaleData.Notification parseNotificationData(JSONObject jSONObject) {
            if (jSONObject != null) {
                return new Configuration.LocaleData.Notification(INSTANCE.parseIntValue(jSONObject, RemoteConfigUtil.CONFIG_KEY_VERSION), jSONObject.getString(RemoteConfigUtil.CONFIG_KEY_BUTTON_PREFERENCE), jSONObject.optString(RemoteConfigUtil.CONFIG_KEY_EXPIRED_AT), jSONObject.getString(RemoteConfigUtil.CONFIG_KEY_TITLE), jSONObject.getString(RemoteConfigUtil.CONFIG_KEY_SUBTITLE), jSONObject.getString("url"), jSONObject.getString(RemoteConfigUtil.CONFIG_KEY_DESCRIPTION), jSONObject.getString(RemoteConfigUtil.CONFIG_KEY_IMAGE_PATH));
            }
            return null;
        }

        private final Configuration.LocaleData.Eula parseEulaData(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new Configuration.LocaleData.Eula(INSTANCE.parseIntValue(jSONObject, RemoteConfigUtil.CONFIG_KEY_VERSION), jSONObject.getString(RemoteConfigUtil.CONFIG_KEY_DATE));
        }

        private final Configuration.LocaleData.PrivacyPolicy parsePrivacyPolicyData(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new Configuration.LocaleData.PrivacyPolicy(INSTANCE.parseIntValue(jSONObject, RemoteConfigUtil.CONFIG_KEY_VERSION), jSONObject.optString(RemoteConfigUtil.CONFIG_KEY_DATE));
        }

        private final Integer parseIntValue(JSONObject jSONObject, String str) {
            try {
                return Integer.valueOf(jSONObject.getInt(str));
            } catch (Exception e) {
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                String message = e.getMessage();
                debugLogUtil.e("Error parsing IntValue: " + message);
                return null;
            }
        }

        public final Date parseDateStringSsXXX2Date(String str) {
            String convertDateStringSsXXX2SsZZZ;
            if (str == null || (convertDateStringSsXXX2SsZZZ = convertDateStringSsXXX2SsZZZ(str)) == null) {
                return null;
            }
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault()).parse(convertDateStringSsXXX2SsZZZ);
            } catch (ParseException e) {
                String message = e.getMessage();
                if (message == null) {
                    return null;
                }
                DebugLogUtil.INSTANCE.e(message);
                return null;
            }
        }

        public final Date parseDateStringSsZZZ2Date(String str) {
            if (str == null) {
                return null;
            }
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", Locale.getDefault()).parse(str);
            } catch (ParseException e) {
                String message = e.getMessage();
                if (message == null) {
                    return null;
                }
                DebugLogUtil.INSTANCE.e(message);
                return null;
            }
        }

        public final String convertDateStringSsXXX2SsZZZ(String str) {
            Intrinsics.checkNotNullParameter(str, "ssXXX");
            if (str.length() != 25) {
                return null;
            }
            CharSequence charSequence = str;
            int i = -1;
            int length = charSequence.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i2 = length - 1;
                    if (charSequence.charAt(length) == ':') {
                        i = length;
                        break;
                    } else if (i2 < 0) {
                        break;
                    } else {
                        length = i2;
                    }
                }
            }
            if (i != 22) {
                return null;
            }
            try {
                StringBuilder deleteCharAt = new StringBuilder(str).deleteCharAt(i);
                Intrinsics.checkNotNullExpressionValue(deleteCharAt, "deleteCharAt(...)");
                return deleteCharAt.toString();
            } catch (ParseException e) {
                String message = e.getMessage();
                if (message == null) {
                    return null;
                }
                DebugLogUtil.INSTANCE.e(message);
                return null;
            }
        }
    }

    public final Configuration.LocaleData getLocaleData(String str, Map<String, Configuration.LocaleData> map) {
        String str2 = str;
        Map<String, Configuration.LocaleData> map2 = map;
        Intrinsics.checkNotNullParameter(str2, "country");
        if (map2 == null) {
            return null;
        }
        if (CollectionsKt.listOf("JP", "US", "GB", "HK", "SB", "MY", "TH", "VN", "KR", "TW", "SA", "BH", "OM", "QA", "KW", "FR", "DE", "IT", "ES", "CH", "AT", "IE").contains(str2)) {
            String upperCase = str2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (!map2.containsKey(upperCase)) {
                return null;
            }
            String upperCase2 = str2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            return (Configuration.LocaleData) MapsKt.getValue(map2, upperCase2);
        } else if (map2.containsKey("OTHER")) {
            return (Configuration.LocaleData) MapsKt.getValue(map2, "OTHER");
        } else {
            return null;
        }
    }

    public static /* synthetic */ boolean shouldShowNotification$default(RemoteConfigUtil remoteConfigUtil, Context context, String str, Integer num, String str2, Date date, int i, Object obj) {
        if ((i & 16) != 0) {
            date = new Date();
        }
        return remoteConfigUtil.shouldShowNotification(context, str, num, str2, date);
    }

    public final boolean shouldShowNotification(Context context, String str, Integer num, String str2, Date date) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountry");
        Intrinsics.checkNotNullParameter(date, "aCurrentDate");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("remote notification date:" + str2);
        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
        debugLogUtil2.d("remote notification version:" + num);
        if (num == null) {
            return false;
        }
        num.intValue();
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_NOTIFICATION_VERSION_MAP);
        CharSequence charSequence = stringValue;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Type type = new RemoteConfigUtil$shouldShowNotification$mapType$1().getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            Object fromJson = new Gson().fromJson(stringValue, type);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            Integer num2 = (Integer) ((Map) fromJson).get(str);
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            debugLogUtil3.d("local notification version:" + num2);
            DebugLogUtil debugLogUtil4 = DebugLogUtil.INSTANCE;
            debugLogUtil4.d("local notification date:" + date);
            if (num2 != null) {
                num2.intValue();
                Date parseDateStringSsXXX2Date = JsonParser.INSTANCE.parseDateStringSsXXX2Date(str2);
                if (num.intValue() <= num2.intValue()) {
                    return false;
                }
                if (parseDateStringSsXXX2Date == null || parseDateStringSsXXX2Date.getTime() > date.getTime()) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public final void saveNotificationVersion(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountry");
        Map<String, Integer> createNotificationMap = createNotificationMap(context, str, i);
        if (!createNotificationMap.isEmpty()) {
            SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
            String json = new Gson().toJson((Object) createNotificationMap);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            simpleStorageUtil.setStringValue(context, SimpleStorageUtil.REON_NOTIFICATION_VERSION_MAP, json);
            SimpleStorageUtil.INSTANCE.remove(context, SimpleStorageUtil.REON_NOTIFICATION_VERSION);
        }
    }

    public final Map<String, Integer> createNotificationMap(Context context, String str, int i) {
        Map<String, Integer> map;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountry");
        try {
            String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_NOTIFICATION_VERSION_MAP);
            CharSequence charSequence = stringValue;
            if (charSequence != null) {
                if (charSequence.length() != 0) {
                    Type type = new RemoteConfigUtil$createNotificationMap$mutableMap$mapType$1().getType();
                    Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    Object fromJson = new Gson().fromJson(stringValue, type);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                    map = MapsKt.toMutableMap((Map) fromJson);
                    map.put(str, Integer.valueOf(i));
                    return map;
                }
            }
            map = new LinkedHashMap<>();
            map.put(str, Integer.valueOf(i));
            return map;
        } catch (Exception e) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String message = e.getMessage();
            debugLogUtil.e("Error " + message);
            return MapsKt.emptyMap();
        }
    }

    public final boolean shouldUpdateEula(Context context, String str, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountry");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_EULA_ACCEPTED_MAP);
        CharSequence charSequence = stringValue;
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        Type type = new RemoteConfigUtil$shouldUpdateEula$mapType$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        Object fromJson = new Gson().fromJson(stringValue, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        Configuration.LocaleData.Eula eula2 = (Configuration.LocaleData.Eula) ((Map) fromJson).get(str);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("remote eula version:" + num);
        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
        debugLogUtil2.d("remote eula date:" + str2);
        DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
        String str3 = null;
        Integer version = eula2 != null ? eula2.getVersion() : null;
        debugLogUtil3.d("local eula version:" + version);
        DebugLogUtil debugLogUtil4 = DebugLogUtil.INSTANCE;
        String date = eula2 != null ? eula2.getDate() : null;
        debugLogUtil4.d("local eula date:" + date);
        if ((eula2 != null ? eula2.getVersion() : null) == null) {
            if (eula2 != null) {
                str3 = eula2.getDate();
            }
            if (str3 == null) {
                return true;
            }
            if (str2 == null) {
                return false;
            }
            Date parseDateStringSsZZZ2Date = JsonParser.INSTANCE.parseDateStringSsZZZ2Date(eula2.getDate());
            Date parseDateStringSsXXX2Date = JsonParser.INSTANCE.parseDateStringSsXXX2Date(str2);
            if (parseDateStringSsZZZ2Date == null) {
                return true;
            }
            if (parseDateStringSsXXX2Date == null) {
                return false;
            }
            if (parseDateStringSsXXX2Date.compareTo(parseDateStringSsZZZ2Date) > 0) {
                return true;
            }
            return false;
        } else if (num == null) {
            return false;
        } else {
            num.intValue();
            if (num.intValue() > eula2.getVersion().intValue()) {
                return true;
            }
            return false;
        }
    }

    public final boolean shouldUpdatePrivacyPolicy(Context context, String str, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aCountry");
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_PP_ACCEPTED_MAP);
        CharSequence charSequence = stringValue;
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        Type type = new RemoteConfigUtil$shouldUpdatePrivacyPolicy$mapType$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        Object fromJson = new Gson().fromJson(stringValue, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        Configuration.LocaleData.PrivacyPolicy privacyPolicy2 = (Configuration.LocaleData.PrivacyPolicy) ((Map) fromJson).get(str);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("remote privacy policy version:" + num);
        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
        debugLogUtil2.d("remote privacy policy date:" + str2);
        DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
        String str3 = null;
        Integer version = privacyPolicy2 != null ? privacyPolicy2.getVersion() : null;
        debugLogUtil3.d("local privacy policy version:" + version);
        DebugLogUtil debugLogUtil4 = DebugLogUtil.INSTANCE;
        String date = privacyPolicy2 != null ? privacyPolicy2.getDate() : null;
        debugLogUtil4.d("local privacy policy date:" + date);
        if ((privacyPolicy2 != null ? privacyPolicy2.getVersion() : null) == null) {
            if (privacyPolicy2 != null) {
                str3 = privacyPolicy2.getDate();
            }
            if (str3 == null) {
                return true;
            }
            if (str2 == null) {
                return false;
            }
            Date parseDateStringSsZZZ2Date = JsonParser.INSTANCE.parseDateStringSsZZZ2Date(privacyPolicy2.getDate());
            Date parseDateStringSsXXX2Date = JsonParser.INSTANCE.parseDateStringSsXXX2Date(str2);
            if (parseDateStringSsZZZ2Date == null) {
                return true;
            }
            if (parseDateStringSsXXX2Date == null) {
                return false;
            }
            if (parseDateStringSsXXX2Date.compareTo(parseDateStringSsZZZ2Date) > 0) {
                return true;
            }
            return false;
        } else if (num == null) {
            return false;
        } else {
            num.intValue();
            if (num.intValue() > privacyPolicy2.getVersion().intValue()) {
                return true;
            }
            return false;
        }
    }

    private final void parseAndUpdateUserFeedbackUrl(Activity activity, FirebaseRemoteConfig firebaseRemoteConfig) {
        String string = firebaseRemoteConfig.getString(KEY_USER_FEEDBACK_URL);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        mFeedBackUrl = string;
    }

    private final void parseAndUpdateUsageInfo(FirebaseRemoteConfig firebaseRemoteConfig) {
        String string = firebaseRemoteConfig.getString(KEY_USAGE_THRESHOLD_COOL);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = firebaseRemoteConfig.getString(KEY_USAGE_THRESHOLD_WARM);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        try {
            JSONObject jSONObject = new JSONObject(string);
            JSONObject jSONObject2 = new JSONObject(string2);
            Object obj = jSONObject.get(CONFIG_KEY_COUNT);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            float parseFloat = Float.parseFloat(jSONObject.get(CONFIG_KEY_RATIO).toString());
            Object obj2 = jSONObject2.get(CONFIG_KEY_COUNT);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            mUsageEntity = new UsageEntity(intValue, ((Integer) obj2).intValue(), parseFloat, Float.parseFloat(jSONObject2.get(CONFIG_KEY_RATIO).toString()));
        } catch (Exception unused) {
            DebugLogUtil.INSTANCE.e("Remote config parse error");
        }
    }

    public final int compareVersion(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "aVersion1");
        Intrinsics.checkNotNullParameter(str2, "aVersion2");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
        List split$default2 = StringsKt.split$default((CharSequence) str2, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
        int coerceAtMost = RangesKt.coerceAtMost(split$default.size(), split$default2.size());
        int i = 0;
        for (int i2 = 0; i2 < coerceAtMost; i2++) {
            i = ((String) split$default.get(i2)).length() - ((String) split$default2.get(i2)).length();
            if (i != 0 || (i = ((String) split$default.get(i2)).compareTo((String) split$default2.get(i2))) != 0) {
                break;
            }
        }
        return i == 0 ? split$default.size() - split$default2.size() : i;
    }

    private final void parseAndUpdateThermoInfo(FirebaseRemoteConfig firebaseRemoteConfig) {
        String string = firebaseRemoteConfig.getString(KEY_THERMO_DISPLAY_THRESHOLD);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        try {
            JSONObject jSONObject = new JSONObject(string);
            mTemperatureThresholdEntity = new DeviceTemperatureView.TemperatureThresholdEntity((float) jSONObject.getDouble(MIN_TEMPERATURE), (float) jSONObject.getDouble(MID_TEMPERATURE), (float) jSONObject.getDouble(MAX_TEMPERATURE));
        } catch (JSONException unused) {
            DebugLogUtil.INSTANCE.e("thermo json error");
        }
    }
}
