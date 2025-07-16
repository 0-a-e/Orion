package jp.co.sony.reonpocket.constant;

import jp.co.sony.reonpocket.util.EnumWithCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/constant/CoolBoost;", "", "Ljp/co/sony/reonpocket/util/EnumWithCode;", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "NONE", "BOOST", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum CoolBoost implements EnumWithCode {
    NONE(0),
    BOOST(1);
    
    private final int code;

    public static EnumEntries<CoolBoost> getEntries() {
        return $ENTRIES;
    }

    private CoolBoost(int i) {
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    static {
        CoolBoost[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
