package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "MANUAL", "AUTO", "MY", "FAN", "TEMPERATURE", "POWER_OFF", "MY_SETTING", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum DeviceModeActionCode {
    MANUAL(0),
    AUTO(1),
    MY(2),
    FAN(3),
    TEMPERATURE(4),
    POWER_OFF(15),
    MY_SETTING(130);
    
    private final int code;

    public static EnumEntries<DeviceModeActionCode> getEntries() {
        return $ENTRIES;
    }

    private DeviceModeActionCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        DeviceModeActionCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
