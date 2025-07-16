package jp.co.sony.reonpocket.constant;

import jp.co.sony.reonpocket.util.EnumWithCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ljp/co/sony/reonpocket/constant/SmartModePreference;", "", "Ljp/co/sony/reonpocket/util/EnumWithCode;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "OFF", "WEAK", "LOWER_WEAK", "NORMAL", "LOWER_STRONG", "STRONG", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum SmartModePreference implements EnumWithCode {
    OFF(0),
    WEAK(1),
    LOWER_WEAK(2),
    NORMAL(3),
    LOWER_STRONG(4),
    STRONG(5);
    
    private final int code;

    public static EnumEntries<SmartModePreference> getEntries() {
        return $ENTRIES;
    }

    private SmartModePreference(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    static {
        SmartModePreference[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
