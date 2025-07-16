package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/constant/TagStatus;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "UNREGISTERED", "REGISTER", "UNREGISTER", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum TagStatus {
    UNREGISTERED(0),
    REGISTER(1),
    UNREGISTER(2);
    
    private final int code;

    public static EnumEntries<TagStatus> getEntries() {
        return $ENTRIES;
    }

    private TagStatus(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        TagStatus[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
