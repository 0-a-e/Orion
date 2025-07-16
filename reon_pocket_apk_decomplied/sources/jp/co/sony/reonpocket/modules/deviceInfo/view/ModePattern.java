package jp.co.sony.reonpocket.modules.deviceInfo.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/deviceInfo/view/ModePattern;", "", "(Ljava/lang/String;I)V", "COOL", "WARM", "COOLANDWARM", "OFF", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceInfoActivity.kt */
public enum ModePattern {
    COOL,
    WARM,
    COOLANDWARM,
    OFF;

    public static EnumEntries<ModePattern> getEntries() {
        return $ENTRIES;
    }

    static {
        ModePattern[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
