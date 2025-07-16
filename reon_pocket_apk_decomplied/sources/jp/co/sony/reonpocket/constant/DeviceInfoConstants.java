package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/constant/DeviceInfoConstants;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "NORMAL_MOVEMENT_COOL", "NORMAL_MOVEMENT_WARM", "NORMAL_MOVEMENT_AUTO_STOP", "NORMAL_MOVEMENT_HIGH_TEMP", "NORMAL_MOVEMENT_LOW_BATTERY", "EXCEPTION_INTERNAL_HIGH_TEMP", "EXCEPTION_INTERNAL_LOW_TEMP", "EXCEPTION_FAN_STOP", "EXCEPTION_CANNOT_CHARGING", "EXCEPTION_CANNOT_CHARGING_CAUSE_HIGH_TEMP", "EXCEPTION_CANNOT_CHARGING_UNKNOWN", "EXCEPTION_DEVICE_STOP", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum DeviceInfoConstants {
    NORMAL_MOVEMENT_COOL(1),
    NORMAL_MOVEMENT_WARM(2),
    NORMAL_MOVEMENT_AUTO_STOP(3),
    NORMAL_MOVEMENT_HIGH_TEMP(4),
    NORMAL_MOVEMENT_LOW_BATTERY(5),
    EXCEPTION_INTERNAL_HIGH_TEMP(6),
    EXCEPTION_INTERNAL_LOW_TEMP(7),
    EXCEPTION_FAN_STOP(8),
    EXCEPTION_CANNOT_CHARGING(9),
    EXCEPTION_CANNOT_CHARGING_CAUSE_HIGH_TEMP(10),
    EXCEPTION_CANNOT_CHARGING_UNKNOWN(11),
    EXCEPTION_DEVICE_STOP(12);
    
    private final int code;

    public static EnumEntries<DeviceInfoConstants> getEntries() {
        return $ENTRIES;
    }

    private DeviceInfoConstants(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        DeviceInfoConstants[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
