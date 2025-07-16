package jp.co.sony.reonpocket.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ\u001d\u0010D\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0002\u0010FJ\u001e\u0010D\u001a\u00020\u00072\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0007J\u001d\u0010H\u001a\u0004\u0018\u00010\u000b2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0002\u0010IJ\u001d\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0002\u0010LJ\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010N2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0004J\u0018\u0010O\u001a\u0004\u0018\u00010\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0004J\u0016\u0010P\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0004J\u001e\u0010Q\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0007J\u001e\u0010S\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u000bJ\u001e\u0010T\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010R\u001a\u00020KJ$\u0010U\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00042\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040NJ\u001e\u0010W\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0002R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u0002R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Ljp/co/sony/reonpocket/util/SimpleStorageUtil;", "", "()V", "EMPTY", "", "FILE_NAME", "FIRST_RUN", "", "INITIALIZED", "IS_ALREADY_DISPLAY_WELCOME_VIEW", "NO_DATA", "", "REON_AUTO_MODE", "REON_AUTO_START_ENABLE_FLAG", "REON_AUTO_START_GUIDE_FLAG", "REON_AUTO_STOP_TIME", "REON_BOOST_SETTING", "REON_CAPABILITY", "REON_COOL_HEAT", "REON_COOL_OPERATE_HISTORY", "REON_DEVICE_MODE", "REON_DEVICE_NAME", "REON_EULA_ACCEPTED_MAP", "REON_EULA_VERSION", "getREON_EULA_VERSION$annotations", "REON_FIRM_REVISION", "REON_INITIALIZE_FLAG", "REON_IS_SHOWN_SMART_COOL_BEFORE", "REON_IS_SHOWN_SMART_WARM_BEFORE", "REON_LOCATION_GUIDE_FLAG", "REON_LOG_UNIX_TIME", "REON_MAC_ADDRESS", "REON_NEXT_SHOW_AUTO_MESSAGE_FLAG", "REON_NOTIFICATION_TOPIC", "REON_NOTIFICATION_VERSION", "getREON_NOTIFICATION_VERSION$annotations", "REON_NOTIFICATION_VERSION_MAP", "REON_OWNER_ID", "REON_PAGE_INDEX", "REON_PP_ACCEPTED_MAP", "REON_READ_LOG_HAS_RETRY_COUNT", "REON_SMART_COACHING_ANIME_IS_DISPLAY", "REON_SMART_COOL_TEMP_SWITCH_THRESHOLD_CODE", "REON_SMART_MIX_PREFERENCE_CODE", "REON_SMART_PREFERENCE_CODE", "REON_SMART_WARM_PREFERENCE_CODE", "REON_SMART_WARM_TEMP_SWITCH_THRESHOLD_CODE", "REON_TAG_BD_ADDRESS", "REON_TAG_INFO", "REON_TAG_MODEL_NAME", "REON_TEMPERATURE", "REON_USER_CONNECTION_ERROR_TIME", "REON_USER_INFO_CONTENT", "REON_USER_INFO_KEY_AGE", "REON_USER_INFO_KEY_COUNTRY", "REON_USER_INFO_KEY_GENDER", "REON_USER_INFO_KEY_HEIGHT", "REON_USER_INFO_KEY_STATE", "REON_USER_INFO_KEY_WEIGHT", "REON_USER_STORE_REVIEW_POPUP_TIME", "REON_USER_USES_DAY_TIMES", "REON_VBUS_STATUS_CODE", "REON_WARM_OPERATE_HISTORY", "REON_WAVE_GUIDE_FLAG", "clearAllSettings", "", "aContext", "Landroid/content/Context;", "getBooleanValue", "aKey", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "aFallback", "getIntValue", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Integer;", "getLongValue", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Long;", "getStringSet", "", "getStringValue", "remove", "setBooleanValue", "aValue", "setIntValue", "setLongValue", "setStringSet", "aSet", "setStringValue", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SimpleStorageUtil.kt */
public final class SimpleStorageUtil {
    public static final int $stable = 0;
    public static final String EMPTY = "";
    private static final String FILE_NAME = "ReonData";
    public static final boolean FIRST_RUN = true;
    public static final boolean INITIALIZED = false;
    public static final SimpleStorageUtil INSTANCE = new SimpleStorageUtil();
    public static final String IS_ALREADY_DISPLAY_WELCOME_VIEW = "is_already_display_welcome_view";
    public static final int NO_DATA = -1;
    public static final String REON_AUTO_MODE = "reon_auto_mode";
    public static final String REON_AUTO_START_ENABLE_FLAG = "reon_auto_start_enable_flag";
    public static final String REON_AUTO_START_GUIDE_FLAG = "reon_auto_start_guide_flag";
    public static final String REON_AUTO_STOP_TIME = "reon_auto_stop_time";
    public static final String REON_BOOST_SETTING = "reon_boost_setting";
    public static final String REON_CAPABILITY = "reon_capability";
    public static final String REON_COOL_HEAT = "reon_cool_heat";
    public static final String REON_COOL_OPERATE_HISTORY = "reon_cool_operate_index";
    public static final String REON_DEVICE_MODE = "reon_device_mode";
    public static final String REON_DEVICE_NAME = "reon_device_name";
    public static final String REON_EULA_ACCEPTED_MAP = "reon_eula_accepted_map";
    public static final String REON_EULA_VERSION = "reon_eula_version";
    public static final String REON_FIRM_REVISION = "reon_firm_revision";
    public static final String REON_INITIALIZE_FLAG = "reon_initialize_flag";
    public static final String REON_IS_SHOWN_SMART_COOL_BEFORE = "reon_is_shown_smart_cool_before";
    public static final String REON_IS_SHOWN_SMART_WARM_BEFORE = "reon_is_shown_smart_warm_before";
    public static final String REON_LOCATION_GUIDE_FLAG = "reon_location_guide_flag";
    public static final String REON_LOG_UNIX_TIME = "reon_log_unix_time";
    public static final String REON_MAC_ADDRESS = "reon_mac_address";
    public static final String REON_NEXT_SHOW_AUTO_MESSAGE_FLAG = "reon_next_show_auto_message_flag";
    public static final String REON_NOTIFICATION_TOPIC = "reon_notification_topic";
    public static final String REON_NOTIFICATION_VERSION = "reon_notification_version";
    public static final String REON_NOTIFICATION_VERSION_MAP = "reon_notification_version_map";
    public static final String REON_OWNER_ID = "reon_owner_id";
    public static final String REON_PAGE_INDEX = "reon_page_index";
    public static final String REON_PP_ACCEPTED_MAP = "reon_pp_accepted_map";
    public static final String REON_READ_LOG_HAS_RETRY_COUNT = "reon_read_log_has_retry_count";
    public static final String REON_SMART_COACHING_ANIME_IS_DISPLAY = "reon_smart_coaching_anime_is_display";
    public static final String REON_SMART_COOL_TEMP_SWITCH_THRESHOLD_CODE = "reon_smart_cool_temp_switch_threshold_code";
    public static final String REON_SMART_MIX_PREFERENCE_CODE = "reon_smart_mix_preference_code";
    public static final String REON_SMART_PREFERENCE_CODE = "reon_smart_preference_code";
    public static final String REON_SMART_WARM_PREFERENCE_CODE = "reon_smart_warm_preference_code";
    public static final String REON_SMART_WARM_TEMP_SWITCH_THRESHOLD_CODE = "reon_smart_warm_temp_switch_threshold_code";
    public static final String REON_TAG_BD_ADDRESS = "reon_tag_bd_address";
    public static final String REON_TAG_INFO = "reon_tag_info";
    public static final String REON_TAG_MODEL_NAME = "reon_tag_model_name";
    public static final String REON_TEMPERATURE = "reon_temperature";
    public static final String REON_USER_CONNECTION_ERROR_TIME = "reon_user_connection_error_time";
    public static final String REON_USER_INFO_CONTENT = "reon_user_info_content";
    public static final String REON_USER_INFO_KEY_AGE = "reon_user_info_age";
    public static final String REON_USER_INFO_KEY_COUNTRY = "reon_user_info_country";
    public static final String REON_USER_INFO_KEY_GENDER = "reon_user_info_gender";
    public static final String REON_USER_INFO_KEY_HEIGHT = "reon_user_info_height";
    public static final String REON_USER_INFO_KEY_STATE = "reon_user_info_state";
    public static final String REON_USER_INFO_KEY_WEIGHT = "reon_user_info_weight";
    public static final String REON_USER_STORE_REVIEW_POPUP_TIME = "reon_user_store_review_popup_time";
    public static final String REON_USER_USES_DAY_TIMES = "reon_user_uses_day_times";
    public static final String REON_VBUS_STATUS_CODE = "reon_vbus_status_code";
    public static final String REON_WARM_OPERATE_HISTORY = "reon_warm_operate_history";
    public static final String REON_WAVE_GUIDE_FLAG = "reon_wave_guide_flag";

    @Deprecated(message = "REON_EULA_ACCEPTED_LIST を使ってください")
    public static /* synthetic */ void getREON_EULA_VERSION$annotations() {
    }

    @Deprecated(message = "REON_NOTIFICATION_VERSION_MAP を使ってください")
    public static /* synthetic */ void getREON_NOTIFICATION_VERSION$annotations() {
    }

    private SimpleStorageUtil() {
    }

    public final void clearAllSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    public final Integer getIntValue(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            return Integer.valueOf(sharedPreferences.getInt(str, -1));
        }
        return null;
    }

    public final void setIntValue(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    public final Set<String> getStringSet(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getStringSet(str, new LinkedHashSet());
        }
        return null;
    }

    public final void setStringSet(Context context, String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        Intrinsics.checkNotNullParameter(set, "aSet");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putStringSet(str, set);
            edit.apply();
        }
    }

    public final Long getLongValue(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences == null || !sharedPreferences.contains(str)) {
            return null;
        }
        return Long.valueOf(sharedPreferences.getLong(str, -1));
    }

    public final void setLongValue(Context context, String str, long j) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }

    public final String getStringValue(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, "");
        }
        return null;
    }

    public final void setStringValue(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        Intrinsics.checkNotNullParameter(str2, "aValue");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public final Boolean getBooleanValue(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, true));
        }
        return null;
    }

    public final boolean getBooleanValue(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, z);
    }

    public final void setBooleanValue(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }

    public final void remove(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.apply();
        }
    }
}
