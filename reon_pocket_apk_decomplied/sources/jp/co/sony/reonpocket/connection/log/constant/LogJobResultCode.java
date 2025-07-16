package jp.co.sony.reonpocket.connection.log.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/constant/LogJobResultCode;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "RESULT_SUCCESS", "RESULT_FAIL_RETRY", "RESULT_FAIL_NORETRY", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogConstant.kt */
public enum LogJobResultCode {
    RESULT_SUCCESS(0),
    RESULT_FAIL_RETRY(1),
    RESULT_FAIL_NORETRY(2);
    
    private final int code;

    public static EnumEntries<LogJobResultCode> getEntries() {
        return $ENTRIES;
    }

    private LogJobResultCode(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        LogJobResultCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
