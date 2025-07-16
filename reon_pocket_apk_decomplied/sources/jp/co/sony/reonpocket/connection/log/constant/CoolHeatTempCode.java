package jp.co.sony.reonpocket.connection.log.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/constant/CoolHeatTempCode;", "", "code", "", "summary", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getSummary", "()Ljava/lang/String;", "STEP_1", "STEP_2", "STEP_3", "UNKNOWN", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogConstant.kt */
public enum CoolHeatTempCode {
    STEP_1(0, "1"),
    STEP_2(1, "2"),
    STEP_3(2, "3"),
    UNKNOWN(15, "Unknown");
    
    private final int code;
    private final String summary;

    public static EnumEntries<CoolHeatTempCode> getEntries() {
        return $ENTRIES;
    }

    private CoolHeatTempCode(int i, String str) {
        this.code = i;
        this.summary = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getSummary() {
        return this.summary;
    }

    static {
        CoolHeatTempCode[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
