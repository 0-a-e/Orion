package jp.co.sony.reon.android.ble.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reon/android/ble/util/BluetoothUtil;", "", "()V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "aContext", "Landroid/content/Context;", "convertBondStateToString", "", "aBondState", "", "convertConnectStateToString", "aConnectState", "convertResultStateToString", "aResultState", "getRemoteDevice", "Landroid/bluetooth/BluetoothDevice;", "aMacAddress", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BluetoothUtil.kt */
public final class BluetoothUtil {
    public static final BluetoothUtil INSTANCE = new BluetoothUtil();

    private BluetoothUtil() {
    }

    public final BluetoothAdapter bluetoothAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Object systemService = context.getSystemService("bluetooth");
        BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
        if (bluetoothManager != null) {
            return bluetoothManager.getAdapter();
        }
        return null;
    }

    public final BluetoothDevice getRemoteDevice(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aMacAddress");
        BluetoothAdapter bluetoothAdapter = bluetoothAdapter(context);
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.getRemoteDevice(str);
        }
        return null;
    }

    public final String convertResultStateToString(int i) {
        if (i == 0) {
            return FirebaseAnalytics.Param.SUCCESS;
        }
        if (i != 257) {
            return String.valueOf(i);
        }
        return "failure";
    }

    public final String convertConnectStateToString(int i) {
        if (i == 1) {
            return "connecting";
        }
        if (i == 2) {
            return "connected";
        }
        if (i != 3) {
            return "disconnected";
        }
        return "disconnecting";
    }

    public final String convertBondStateToString(int i) {
        switch (i) {
            case 10:
                return "bond_none";
            case 11:
                return "bond_bonding";
            case 12:
                return "bond_bonded";
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}
