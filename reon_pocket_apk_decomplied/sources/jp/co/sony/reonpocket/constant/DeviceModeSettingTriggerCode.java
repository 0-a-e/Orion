package jp.co.sony.reonpocket.constant;

import jp.co.sony.reonpocket.util.EnumWithCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;", "", "Ljp/co/sony/reonpocket/util/EnumWithCode;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SET_DEVICE_MODE", "QUICK_LAUNCH", "INTERNAL_CHANGED", "RUNTIME_EXPIRED_MANUAL_AUTO", "FAN_ALERT", "TEC_ALERT", "THERMO_CONTROL_ALERT", "THERMO_ALERT_COOL_LOW_TEMP", "THERMO_ALERT_COOL_HIGH_TEMP", "THERMO_ALERT_HEAT_HIGH_TEMP", "LOW_BATTERY_ALERT", "KEY_LONG_PUSH", "SHELL_COMMAND", "AUTO_START", "START_STOP_KEY_PUSH", "KEY_PUSH_PLUS", "KEY_PUSH_MINUS", "SMART_KEY_PUSH", "MODE_PUSH", "AUTO_START_UNKNOWN", "AUTO_START_THERMO_TEMP_RISE", "AUTO_START_THERMO_OVER_THRESHOLD", "AUTO_STOP_UNKNOWN", "AUTO_STOP_THERMO_TEMP_CHANGE", "AUTO_STOP_DEVICE_LEFT_ON_SURFACE", "AUTO_STOP_DEVICE_NO_ACTION", "AUTO_STOP_DEVICE_NOT_WEAR", "SHUTDOWN", "STANDBY", "INITIALIZE", "DFU", "RESET", "UNKNOWN", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum DeviceModeSettingTriggerCode implements EnumWithCode {
    SET_DEVICE_MODE(0),
    QUICK_LAUNCH(1),
    INTERNAL_CHANGED(2),
    RUNTIME_EXPIRED_MANUAL_AUTO(3),
    FAN_ALERT(4),
    TEC_ALERT(5),
    THERMO_CONTROL_ALERT(6),
    THERMO_ALERT_COOL_LOW_TEMP(7),
    THERMO_ALERT_COOL_HIGH_TEMP(8),
    THERMO_ALERT_HEAT_HIGH_TEMP(9),
    LOW_BATTERY_ALERT(10),
    KEY_LONG_PUSH(11),
    SHELL_COMMAND(12),
    AUTO_START(13),
    START_STOP_KEY_PUSH(16),
    KEY_PUSH_PLUS(17),
    KEY_PUSH_MINUS(18),
    SMART_KEY_PUSH(19),
    MODE_PUSH(20),
    AUTO_START_UNKNOWN(64),
    AUTO_START_THERMO_TEMP_RISE(65),
    AUTO_START_THERMO_OVER_THRESHOLD(66),
    AUTO_STOP_UNKNOWN(80),
    AUTO_STOP_THERMO_TEMP_CHANGE(81),
    AUTO_STOP_DEVICE_LEFT_ON_SURFACE(82),
    AUTO_STOP_DEVICE_NO_ACTION(83),
    AUTO_STOP_DEVICE_NOT_WEAR(84),
    SHUTDOWN(128),
    STANDBY(128),
    INITIALIZE(128),
    DFU(128),
    RESET(254),
    UNKNOWN(255);
    
    private final int code;

    public static EnumEntries<DeviceModeSettingTriggerCode> getEntries() {
        return $ENTRIES;
    }

    private DeviceModeSettingTriggerCode(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    static {
        DeviceModeSettingTriggerCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
