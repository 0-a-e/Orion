package jp.co.sony.reonpocket.constant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Ljp/co/sony/reonpocket/constant/IntentExtraConstant;", "", "()V", "FromSplash", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: IntentExtraConstant.kt */
public final class IntentExtraConstant {
    public static final int $stable = 0;
    public static final IntentExtraConstant INSTANCE = new IntentExtraConstant();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/constant/IntentExtraConstant$FromSplash;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "IS_DISCONNECTING", "IS_CONNECT_WHEN_ON_CREATE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: IntentExtraConstant.kt */
    public enum FromSplash {
        IS_DISCONNECTING("splash_is_disconnecting"),
        IS_CONNECT_WHEN_ON_CREATE("is_connect_when_on_create");
        
        private final String key;

        public static EnumEntries<FromSplash> getEntries() {
            return $ENTRIES;
        }

        private FromSplash(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        static {
            FromSplash[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    private IntentExtraConstant() {
    }
}
