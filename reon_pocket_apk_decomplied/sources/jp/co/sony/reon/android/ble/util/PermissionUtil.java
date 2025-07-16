package jp.co.sony.reon.android.ble.util;

import android.content.Context;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reon/android/ble/util/PermissionUtil;", "", "()V", "isLocationEnabled", "", "context", "Landroid/content/Context;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionUtil.kt */
public final class PermissionUtil {
    public static final PermissionUtil INSTANCE = new PermissionUtil();

    private PermissionUtil() {
    }

    public final boolean isLocationEnabled(Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        if (i != 0) {
            return true;
        }
        return false;
    }
}
