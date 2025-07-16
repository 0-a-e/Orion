package jp.co.sony.reonpocket.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import jp.co.sony.reon.android.ble.util.BluetoothUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/util/PermissionUtil;", "", "()V", "isBackgroundLocationGranted", "", "context", "Landroid/content/Context;", "isBleEnabled", "appContext", "isBluetoothPermissionsGranted", "isLocationEnabled", "isLocationPermissionsGranted", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionUtil.kt */
public final class PermissionUtil {
    public static final int $stable = 0;
    public static final PermissionUtil INSTANCE = new PermissionUtil();

    private PermissionUtil() {
    }

    public final boolean isBleEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        BluetoothAdapter bluetoothAdapter = BluetoothUtil.INSTANCE.bluetoothAdapter(context);
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    public final boolean isLocationPermissionsGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        for (String checkSelfPermission : BuildVersionCode.Companion.getNowBuildVersionCodeType().getRequestLocationPermissionList()) {
            if (ActivityCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isBluetoothPermissionsGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String[] requestBluetoothPermissionList = BuildVersionCode.Companion.getNowBuildVersionCodeType().getRequestBluetoothPermissionList();
        if (requestBluetoothPermissionList.length == 0) {
            return true;
        }
        for (String checkSelfPermission : requestBluetoothPermissionList) {
            if (ActivityCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean isBackgroundLocationGranted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
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
