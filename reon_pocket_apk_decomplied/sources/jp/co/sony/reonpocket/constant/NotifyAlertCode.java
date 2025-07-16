package jp.co.sony.reonpocket.constant;

import jp.co.sony.reon.android.ble.service.BleService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/constant/NotifyAlertCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SHUTDOWN_BY_LOW_BATTERY", "CHARGING_LOW_BATTERY", "CHARGING_FAIL_LOW_TEMP", "CHARGING_FAIL_HIGH_TEMP", "CHARGING_FAIL_UNKNOWN", "STOP_BY_OVER_CURRENT", "INVALID_BATTERY_TEMP", "STOP_BY_INVALID_FAN_RATE", "COOL_STOP_BY_INVALID_TEMP", "COOL_STOP_BY_INVALID_FAN_TEMP", "HEAT_STOP_BY_INVALID_TEMP", "VBUS_VOLTAGE_ABNORMALITY_DETECTED", "USB_WATER_WET_DETECTION", "USB_AROUND_WATER_WET_DETECTION", "USB_AROUND_OVER_HEAT", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum NotifyAlertCode {
    SHUTDOWN_BY_LOW_BATTERY(1),
    CHARGING_LOW_BATTERY(17),
    CHARGING_FAIL_LOW_TEMP(33),
    CHARGING_FAIL_HIGH_TEMP(34),
    CHARGING_FAIL_UNKNOWN(36),
    STOP_BY_OVER_CURRENT(130),
    INVALID_BATTERY_TEMP(TarConstants.PREFIXLEN_XSTAR),
    STOP_BY_INVALID_FAN_RATE(132),
    COOL_STOP_BY_INVALID_TEMP(BleService.GATT_ERROR),
    COOL_STOP_BY_INVALID_FAN_TEMP(134),
    HEAT_STOP_BY_INVALID_TEMP(135),
    VBUS_VOLTAGE_ABNORMALITY_DETECTED(136),
    USB_WATER_WET_DETECTION(137),
    USB_AROUND_WATER_WET_DETECTION(138),
    USB_AROUND_OVER_HEAT(139);
    
    private final int code;

    public static EnumEntries<NotifyAlertCode> getEntries() {
        return $ENTRIES;
    }

    private NotifyAlertCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        NotifyAlertCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
