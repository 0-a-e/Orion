package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/constant/TagDataStatus;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "NOT_RECEIVED", "RECEIVING", "NOT_SUPPORT", "NOT_REGISTER", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateCodeConstant.kt */
public enum TagDataStatus {
    NOT_RECEIVED(0),
    RECEIVING(1),
    NOT_SUPPORT(2),
    NOT_REGISTER(255);
    
    private final int code;

    public static EnumEntries<TagDataStatus> getEntries() {
        return $ENTRIES;
    }

    private TagDataStatus(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    static {
        TagDataStatus[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
