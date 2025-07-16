package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/constant/ResponseCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "INVALID_DATA", "INVALID_STATE", "NOT_SUPPORTED", "NO_OWNER", "DFU_BATTERY_LEVEL_NOT_ENOUGH", "CUSTOM_DATA_NULL_OR_EMPTY", "CUSTOM_UNKNOWN_RESPONSE_CODE", "CUSTOM_RESPONSE_BEFORE_ERROR", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum ResponseCode {
    SUCCESS(0),
    INVALID_DATA(128),
    INVALID_STATE(129),
    NOT_SUPPORTED(130),
    NO_OWNER(TarConstants.PREFIXLEN_XSTAR),
    DFU_BATTERY_LEVEL_NOT_ENOUGH(144),
    CUSTOM_DATA_NULL_OR_EMPTY(146),
    CUSTOM_UNKNOWN_RESPONSE_CODE(147),
    CUSTOM_RESPONSE_BEFORE_ERROR(65535);
    
    private final int code;

    public static EnumEntries<ResponseCode> getEntries() {
        return $ENTRIES;
    }

    private ResponseCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        ResponseCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
