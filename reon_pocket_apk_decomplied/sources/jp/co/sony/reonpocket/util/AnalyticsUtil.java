package jp.co.sony.reonpocket.util;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ;\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J6\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0013J&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a¨\u0006\u001f"}, d2 = {"Ljp/co/sony/reonpocket/util/AnalyticsUtil;", "", "()V", "logEventWithBundle", "", "aContext", "Landroid/content/Context;", "aFirebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "aEventName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventName;", "aParam", "Landroid/os/Bundle;", "logEventWithInt", "aParamName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventParameter;", "", "(Landroid/content/Context;Lcom/google/firebase/analytics/FirebaseAnalytics;Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventName;Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventParameter;Ljava/lang/Integer;)V", "logEventWithString", "", "setFBAnalyticsCollectionSetting", "setUserID", "aUserID", "setUserProperty", "aValue", "aName", "Ljp/co/sony/reonpocket/util/AnalyticsUtil$PropertyName;", "EventName", "EventParameter", "ParameterConstants", "PropertyName", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AnalyticsUtil.kt */
public final class AnalyticsUtil {
    public static final int $stable = 0;
    public static final AnalyticsUtil INSTANCE = new AnalyticsUtil();

    private AnalyticsUtil() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/util/AnalyticsUtil$PropertyName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEVICE_MODEL", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AnalyticsUtil.kt */
    public enum PropertyName {
        DEVICE_MODEL("device_model");
        
        private final String value;

        public static EnumEntries<PropertyName> getEntries() {
            return $ENTRIES;
        }

        private PropertyName(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            PropertyName[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BLE_RECONNECT_START", "BLE_PAIRING_START", "BLE_PAIRING_FAILURE", "BLE_PAIRING_COMPLETE", "BLE_RECONNECT_FAILURE", "BLE_RECONNECT_COMPLETE", "BLE_CONNECT_COMPLETE", "MANUAL_COOL_WARM_CHANGE", "MODE_CHANGE", "FIRMWARE_UPDATE_START", "FIRMWARE_UPDATE_COMPLETE", "SHOW_SUPPORT_ERROR", "SHOW_REGISTERED_DEVICE_ERROR", "SHOW_INFORMATION", "INFORMATION_LINK_TAP", "DEVICE_UNREGISTER", "DEVICE_INITIALIZE", "SHOW_APP_UPDATE", "SETUP_QUICK_LAUNCH", "TWITTER_LINK_TAP", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AnalyticsUtil.kt */
    public enum EventName {
        BLE_RECONNECT_START("ble_reconnect_start"),
        BLE_PAIRING_START("ble_pairing_start"),
        BLE_PAIRING_FAILURE("ble_pairing_failure"),
        BLE_PAIRING_COMPLETE("ble_pairing_complete"),
        BLE_RECONNECT_FAILURE("ble_reconnect_failure"),
        BLE_RECONNECT_COMPLETE("ble_reconnect_complete"),
        BLE_CONNECT_COMPLETE("ble_connect_complete"),
        MANUAL_COOL_WARM_CHANGE("manual_cool_warm_change"),
        MODE_CHANGE("mode_change"),
        FIRMWARE_UPDATE_START("firmware_update_start"),
        FIRMWARE_UPDATE_COMPLETE("firmware_update_complete"),
        SHOW_SUPPORT_ERROR("show_support_error"),
        SHOW_REGISTERED_DEVICE_ERROR("show_registered_device_error"),
        SHOW_INFORMATION("show_information"),
        INFORMATION_LINK_TAP("information_link_tap"),
        DEVICE_UNREGISTER("device_unregister"),
        DEVICE_INITIALIZE("device_initialize"),
        SHOW_APP_UPDATE("show_app_update"),
        SETUP_QUICK_LAUNCH("setup_quick_launch"),
        TWITTER_LINK_TAP("twitter_link_tap");
        
        private final String value;

        public static EnumEntries<EventName> getEntries() {
            return $ENTRIES;
        }

        private EventName(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            EventName[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/util/AnalyticsUtil$EventParameter;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COOL_WARM", "TEMP", "MODE", "FW_VERSION", "NOTIFICATION_ID", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AnalyticsUtil.kt */
    public enum EventParameter {
        COOL_WARM("cool_warm"),
        TEMP("temp"),
        MODE(PairingActivityKt.TRANSIT_TO_MAIN_MODE),
        FW_VERSION("fw_version"),
        NOTIFICATION_ID("notification_id");
        
        private final String value;

        public static EnumEntries<EventParameter> getEntries() {
            return $ENTRIES;
        }

        private EventParameter(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            EventParameter[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/util/AnalyticsUtil$ParameterConstants;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "LEVEl_OFF", "LEVEl_1", "LEVEl_2", "LEVEl_3", "BOOST", "STEP_1", "STEP_2", "STEP_3", "AUTO", "MANUAL", "COOL", "WARM", "NO_ID", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AnalyticsUtil.kt */
    public enum ParameterConstants {
        NONE("none"),
        LEVEl_OFF("0"),
        LEVEl_1("1"),
        LEVEl_2("2"),
        LEVEl_3("3"),
        BOOST(PairingActivityKt.TRANSIT_TO_MAIN_BOOST),
        STEP_1("1"),
        STEP_2("2"),
        STEP_3("3"),
        AUTO(DebugKt.DEBUG_PROPERTY_VALUE_AUTO),
        MANUAL("manual"),
        COOL("cool"),
        WARM("warm"),
        NO_ID("no id");
        
        private final String value;

        public static EnumEntries<ParameterConstants> getEntries() {
            return $ENTRIES;
        }

        private ParameterConstants(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            ParameterConstants[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final void setUserID(Context context, FirebaseAnalytics firebaseAnalytics, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "aFirebaseAnalytics");
        Intrinsics.checkNotNullParameter(str, "aUserID");
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null)) {
            firebaseAnalytics.setUserId(str);
        }
    }

    public final void setUserProperty(Context context, FirebaseAnalytics firebaseAnalytics, String str, PropertyName propertyName) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "aFirebaseAnalytics");
        Intrinsics.checkNotNullParameter(str, "aValue");
        Intrinsics.checkNotNullParameter(propertyName, "aName");
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null)) {
            firebaseAnalytics.setUserProperty(propertyName.getValue(), str);
        }
    }

    public static /* synthetic */ void logEventWithString$default(AnalyticsUtil analyticsUtil, Context context, FirebaseAnalytics firebaseAnalytics, EventName eventName, EventParameter eventParameter, String str, int i, Object obj) {
        analyticsUtil.logEventWithString(context, firebaseAnalytics, eventName, (i & 8) != 0 ? null : eventParameter, (i & 16) != 0 ? null : str);
    }

    public final void logEventWithString(Context context, FirebaseAnalytics firebaseAnalytics, EventName eventName, EventParameter eventParameter, String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "aFirebaseAnalytics");
        Intrinsics.checkNotNullParameter(eventName, "aEventName");
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null)) {
            if (eventParameter == null || str == null) {
                unit = null;
            } else {
                Bundle bundle = new Bundle();
                bundle.putString(eventParameter.getValue(), str);
                firebaseAnalytics.logEvent(eventName.getValue(), bundle);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                firebaseAnalytics.logEvent(eventName.getValue(), (Bundle) null);
            }
        }
    }

    public static /* synthetic */ void logEventWithInt$default(AnalyticsUtil analyticsUtil, Context context, FirebaseAnalytics firebaseAnalytics, EventName eventName, EventParameter eventParameter, Integer num, int i, Object obj) {
        analyticsUtil.logEventWithInt(context, firebaseAnalytics, eventName, (i & 8) != 0 ? null : eventParameter, (i & 16) != 0 ? null : num);
    }

    public final void logEventWithInt(Context context, FirebaseAnalytics firebaseAnalytics, EventName eventName, EventParameter eventParameter, Integer num) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "aFirebaseAnalytics");
        Intrinsics.checkNotNullParameter(eventName, "aEventName");
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null)) {
            if (eventParameter == null || num == null) {
                unit = null;
            } else {
                int intValue = num.intValue();
                Bundle bundle = new Bundle();
                bundle.putInt(eventParameter.getValue(), intValue);
                firebaseAnalytics.logEvent(eventName.getValue(), bundle);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                firebaseAnalytics.logEvent(eventName.getValue(), (Bundle) null);
            }
        }
    }

    public static /* synthetic */ void logEventWithBundle$default(AnalyticsUtil analyticsUtil, Context context, FirebaseAnalytics firebaseAnalytics, EventName eventName, Bundle bundle, int i, Object obj) {
        if ((i & 8) != 0) {
            bundle = null;
        }
        analyticsUtil.logEventWithBundle(context, firebaseAnalytics, eventName, bundle);
    }

    public final void logEventWithBundle(Context context, FirebaseAnalytics firebaseAnalytics, EventName eventName, Bundle bundle) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "aFirebaseAnalytics");
        Intrinsics.checkNotNullParameter(eventName, "aEventName");
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null)) {
            if (bundle != null) {
                firebaseAnalytics.logEvent(eventName.getValue(), bundle);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                firebaseAnalytics.logEvent(eventName.getValue(), (Bundle) null);
            }
        }
    }

    public final void setFBAnalyticsCollectionSetting(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        FirebaseAnalytics.getInstance(context).setAnalyticsCollectionEnabled(MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null));
    }
}
