package jp.co.sony.reonpocket.constant;

import jp.co.sony.reonpocket.util.EnumWithCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/constant/TargetTempControlStatus;", "", "Ljp/co/sony/reonpocket/util/EnumWithCode;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "NORMAL", "TARGET_TEMP_DOWN", "TARGET_TEMP_UP", "RESERVE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum TargetTempControlStatus implements EnumWithCode {
    NORMAL(0),
    TARGET_TEMP_DOWN(1),
    TARGET_TEMP_UP(2),
    RESERVE(3);
    
    private final int code;

    public static EnumEntries<TargetTempControlStatus> getEntries() {
        return $ENTRIES;
    }

    private TargetTempControlStatus(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    static {
        TargetTempControlStatus[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
