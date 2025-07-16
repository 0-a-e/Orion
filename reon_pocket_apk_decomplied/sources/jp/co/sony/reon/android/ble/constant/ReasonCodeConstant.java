package jp.co.sony.reon.android.ble.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "", "(Ljava/lang/String;I)V", "NONE", "PERMISSION_MISS", "PERMISSION_MISS_LOCATION", "PERMISSION_MISS_BLUETOOTH", "PERMISSION_MISS_UNEXPECTED", "UNKNOWN", "PARAMETER_INVALID", "DEVICE_NOT_FOUND", "BLUETOOTH_OFF", "DFU_MODE", "DEVICE_NAME_ERROR", "MANUAL_SCAN_STOP", "SCAN_TIME_OUT", "INTERRUPT_BY_BLE_SCAN", "ERROR_IN_SERVICE", "MANUAL_DISCONNECT", "CONNECT_EXCEPTION", "DISCONNECT_FAILED", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReasonCodeConstant.kt */
public enum ReasonCodeConstant {
    NONE,
    PERMISSION_MISS,
    PERMISSION_MISS_LOCATION,
    PERMISSION_MISS_BLUETOOTH,
    PERMISSION_MISS_UNEXPECTED,
    UNKNOWN,
    PARAMETER_INVALID,
    DEVICE_NOT_FOUND,
    BLUETOOTH_OFF,
    DFU_MODE,
    DEVICE_NAME_ERROR,
    MANUAL_SCAN_STOP,
    SCAN_TIME_OUT,
    INTERRUPT_BY_BLE_SCAN,
    ERROR_IN_SERVICE,
    MANUAL_DISCONNECT,
    CONNECT_EXCEPTION,
    DISCONNECT_FAILED;

    public static EnumEntries<ReasonCodeConstant> getEntries() {
        return $ENTRIES;
    }

    static {
        ReasonCodeConstant[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
