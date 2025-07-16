package jp.co.sony.reon.android.ble.util;

import com.amazonaws.cognito.clientcontext.datacollection.DataRecordKey;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¨\u0006\u000e"}, d2 = {"Ljp/co/sony/reon/android/ble/util/CrashlyticsUtil;", "", "()V", "sendGattStatus133Exception", "", "ownerId", "", "deviceName", "macAddress", "sendNeveCalledScanCallbackException", "sendReturnedNullDeviceNameException", "handleFun", "nameIsNullDeviceMacAddressSet", "", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CrashlyticsUtil.kt */
public final class CrashlyticsUtil {
    public static final CrashlyticsUtil INSTANCE = new CrashlyticsUtil();

    private CrashlyticsUtil() {
    }

    public final void sendReturnedNullDeviceNameException(String str, String str2, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "ownerId");
        Intrinsics.checkNotNullParameter(str2, "handleFun");
        Intrinsics.checkNotNullParameter(set, "nameIsNullDeviceMacAddressSet");
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        CustomKeysAndValues.Builder builder = new CustomKeysAndValues.Builder();
        builder.putString("HandleFun", str2);
        for (String putString : set) {
            builder.putString(putString, "The name of the device with this MacAddress was Null.");
        }
        instance.setCustomKeys(builder.build());
        instance.setUserId(str);
        instance.recordException(new CrashlyticsUtil$sendReturnedNullDeviceNameException$ReturnedNullDeviceNameException());
    }

    public final void sendNeveCalledScanCallbackException(String str) {
        Intrinsics.checkNotNullParameter(str, "ownerId");
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        instance.setUserId(str);
        instance.recordException(new CrashlyticsUtil$sendNeveCalledScanCallbackException$NeveCalledScanCallbackException());
    }

    public final void sendGattStatus133Exception(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "ownerId");
        Intrinsics.checkNotNullParameter(str2, "deviceName");
        Intrinsics.checkNotNullParameter(str3, "macAddress");
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        CustomKeysAndValues build = new CustomKeysAndValues.Builder().putString(DataRecordKey.MODEL, str2).putString("MacAddress", str3).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        instance.setCustomKeys(build);
        instance.setUserId(str);
        instance.recordException(new CrashlyticsUtil$sendGattStatus133Exception$GattStatus133Exception());
    }
}
