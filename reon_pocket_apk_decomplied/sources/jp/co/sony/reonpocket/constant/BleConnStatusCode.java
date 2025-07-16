package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "", "(Ljava/lang/String;I)V", "CONNECTED", "PERMISSION_MISS_LOCATION", "PERMISSION_MISS_BLUETOOTH", "PERMISSION_MISS_UNEXPECTED", "CONNECT_FAILED", "CONNECT_SUSPENDED", "SERVICE_DISCOVERED", "DFU_MODE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum BleConnStatusCode {
    CONNECTED,
    PERMISSION_MISS_LOCATION,
    PERMISSION_MISS_BLUETOOTH,
    PERMISSION_MISS_UNEXPECTED,
    CONNECT_FAILED,
    CONNECT_SUSPENDED,
    SERVICE_DISCOVERED,
    DFU_MODE;

    public static EnumEntries<BleConnStatusCode> getEntries() {
        return $ENTRIES;
    }

    static {
        BleConnStatusCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
