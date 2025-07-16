package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.compress.archivers.tar.TarConstants;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/constant/MyModeOperationCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "CTRL_CLEAR", "CTRL_STOP", "CTRL_CLEAR_STOP", "CTRL_REGIST", "CTRL_START", "CTRL_REGIST_START", "READ_SETTING", "READ_STATUS", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum MyModeOperationCode {
    CTRL_CLEAR(1),
    CTRL_STOP(2),
    CTRL_CLEAR_STOP(3),
    CTRL_REGIST(129),
    CTRL_START(130),
    CTRL_REGIST_START(TarConstants.PREFIXLEN_XSTAR),
    READ_SETTING(241),
    READ_STATUS(242);
    
    private final int code;

    public static EnumEntries<MyModeOperationCode> getEntries() {
        return $ENTRIES;
    }

    private MyModeOperationCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        MyModeOperationCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
