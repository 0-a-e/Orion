package jp.co.sony.reon.android.ble.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reon/android/ble/constant/ResultCodeConstant;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ResultCodeConstant.kt */
public enum ResultCodeConstant {
    SUCCESS,
    FAILURE;

    public static EnumEntries<ResultCodeConstant> getEntries() {
        return $ENTRIES;
    }

    static {
        ResultCodeConstant[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
