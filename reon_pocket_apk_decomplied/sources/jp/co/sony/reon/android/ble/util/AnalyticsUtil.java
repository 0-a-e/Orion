package jp.co.sony.reon.android.ble.util;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"Ljp/co/sony/reon/android/ble/util/AnalyticsUtil;", "", "()V", "logEventWithBundle", "", "aFirebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "aEventName", "Ljp/co/sony/reon/android/ble/util/AnalyticsUtil$EventName;", "aParam", "Landroid/os/Bundle;", "EventName", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AnalyticsUtil.kt */
public final class AnalyticsUtil {
    public static final AnalyticsUtil INSTANCE = new AnalyticsUtil();

    private AnalyticsUtil() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Ljp/co/sony/reon/android/ble/util/AnalyticsUtil$EventName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BLE_CONNECT_TIMEOUT_FAILURE", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AnalyticsUtil.kt */
    public enum EventName {
        BLE_CONNECT_TIMEOUT_FAILURE("ble_connect_timeout_failure");
        
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

    public static /* synthetic */ void logEventWithBundle$default(AnalyticsUtil analyticsUtil, FirebaseAnalytics firebaseAnalytics, EventName eventName, Bundle bundle, int i, Object obj) {
        if ((i & 4) != 0) {
            bundle = null;
        }
        analyticsUtil.logEventWithBundle(firebaseAnalytics, eventName, bundle);
    }

    public final void logEventWithBundle(FirebaseAnalytics firebaseAnalytics, EventName eventName, Bundle bundle) {
        Unit unit;
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "aFirebaseAnalytics");
        Intrinsics.checkNotNullParameter(eventName, "aEventName");
        if (LocaleUtil.INSTANCE.isSupportLog()) {
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
}
