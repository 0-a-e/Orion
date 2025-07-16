package jp.co.sony.reonpocket.connection.log;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/RequestLogAction;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "STOP", "START", "NONE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BGLogManager.kt */
enum RequestLogAction {
    STOP(0),
    START(1),
    NONE(2);
    
    private final int code;

    public static EnumEntries<RequestLogAction> getEntries() {
        return $ENTRIES;
    }

    private RequestLogAction(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        RequestLogAction[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
