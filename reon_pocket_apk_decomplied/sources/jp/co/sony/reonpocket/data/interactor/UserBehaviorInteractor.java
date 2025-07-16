package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 /2\u00020\u0001:\u0003./0B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u000e\u0010%\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\bJ\u000e\u0010(\u001a\u00020#2\u0006\u0010'\u001a\u00020\bJ\u000e\u0010)\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0006J\u001a\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014¨\u00061"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserBehaviorInteractor;", "", "aContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "FLOAT_UNDEFINED", "", "INT_UNDEFINED", "", "mCoolQueue", "Ljp/co/sony/reonpocket/data/interactor/UserBehaviorInteractor$AutoRemoveQueue;", "mCoolSizeFromConfig", "getMCoolSizeFromConfig", "()I", "setMCoolSizeFromConfig", "(I)V", "mCoolThreshold", "getMCoolThreshold", "()F", "setMCoolThreshold", "(F)V", "mWarmQueue", "mWarmSizeFromConfig", "getMWarmSizeFromConfig", "setMWarmSizeFromConfig", "mWarmThreshold", "getMWarmThreshold", "setMWarmThreshold", "getCoolHistoryFormPreference", "getWarmHistoryFormPreference", "isTempHeavyUsed", "", "aQueue", "aThreshold", "saveCoolHistory", "", "saveWarmHistory", "setCoolThreshold", "setNewCoolLevel", "aLevel", "setNewWarmLevel", "setWarmThreshold", "toQueue", "aStr", "", "aSize", "AutoRemoveQueue", "Companion", "UsageAlertType", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UserBehaviorInteractor.kt */
public final class UserBehaviorInteractor {
    public static final int $stable = 8;
    public static final int BOOST = 4;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int LEVEL_2 = 2;
    public static final int LEVEL_3 = 3;
    public static final int OFF = 0;
    private final float FLOAT_UNDEFINED = -1.0f;
    private final int INT_UNDEFINED = -1;
    private final Context aContext;
    private AutoRemoveQueue mCoolQueue;
    private int mCoolSizeFromConfig = -1;
    private float mCoolThreshold = -1.0f;
    private AutoRemoveQueue mWarmQueue;
    private int mWarmSizeFromConfig = -1;
    private float mWarmThreshold = -1.0f;

    public UserBehaviorInteractor(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserBehaviorInteractor$Companion;", "", "()V", "BOOST", "", "LEVEL_2", "LEVEL_3", "OFF", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UserBehaviorInteractor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserBehaviorInteractor$UsageAlertType;", "", "(Ljava/lang/String;I)V", "TOO_HEAVY_COOL_USAGE", "TOO_HEAVY_WARM_USAGE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UserBehaviorInteractor.kt */
    public enum UsageAlertType {
        TOO_HEAVY_COOL_USAGE,
        TOO_HEAVY_WARM_USAGE;

        public static EnumEntries<UsageAlertType> getEntries() {
            return $ENTRIES;
        }

        static {
            UsageAlertType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final int getMCoolSizeFromConfig() {
        return this.mCoolSizeFromConfig;
    }

    public final void setMCoolSizeFromConfig(int i) {
        this.mCoolSizeFromConfig = i;
    }

    public final int getMWarmSizeFromConfig() {
        return this.mWarmSizeFromConfig;
    }

    public final void setMWarmSizeFromConfig(int i) {
        this.mWarmSizeFromConfig = i;
    }

    public final float getMCoolThreshold() {
        return this.mCoolThreshold;
    }

    public final void setMCoolThreshold(float f) {
        this.mCoolThreshold = f;
    }

    public final float getMWarmThreshold() {
        return this.mWarmThreshold;
    }

    public final void setMWarmThreshold(float f) {
        this.mWarmThreshold = f;
    }

    public final void setCoolThreshold(float f) {
        this.mCoolThreshold = f;
    }

    public final void setWarmThreshold(float f) {
        this.mWarmThreshold = f;
    }

    public final void setNewCoolLevel(int i) {
        AutoRemoveQueue autoRemoveQueue;
        if (this.mCoolSizeFromConfig != this.INT_UNDEFINED) {
            AutoRemoveQueue coolHistoryFormPreference = getCoolHistoryFormPreference(this.aContext);
            this.mCoolQueue = coolHistoryFormPreference;
            if (coolHistoryFormPreference != null) {
                coolHistoryFormPreference.add(i);
            }
            AutoRemoveQueue autoRemoveQueue2 = this.mCoolQueue;
            if (autoRemoveQueue2 != null && autoRemoveQueue2.size() == this.mCoolSizeFromConfig && isTempHeavyUsed(autoRemoveQueue2, this.mCoolThreshold) && (autoRemoveQueue = this.mCoolQueue) != null) {
                autoRemoveQueue.clear();
            }
            saveCoolHistory();
        }
    }

    public final void setNewWarmLevel(int i) {
        AutoRemoveQueue autoRemoveQueue;
        if (this.mWarmSizeFromConfig != this.INT_UNDEFINED) {
            AutoRemoveQueue warmHistoryFormPreference = getWarmHistoryFormPreference(this.aContext);
            this.mWarmQueue = warmHistoryFormPreference;
            if (warmHistoryFormPreference != null) {
                warmHistoryFormPreference.add(i);
            }
            AutoRemoveQueue autoRemoveQueue2 = this.mWarmQueue;
            if (autoRemoveQueue2 != null && autoRemoveQueue2.size() == this.mWarmSizeFromConfig && isTempHeavyUsed(autoRemoveQueue2, this.mWarmThreshold) && (autoRemoveQueue = this.mWarmQueue) != null) {
                autoRemoveQueue.clear();
            }
            saveWarmHistory();
        }
    }

    private final AutoRemoveQueue getCoolHistoryFormPreference(Context context) {
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_COOL_OPERATE_HISTORY);
        if (stringValue != null) {
            return toQueue(stringValue, this.mCoolSizeFromConfig);
        }
        return null;
    }

    private final AutoRemoveQueue getWarmHistoryFormPreference(Context context) {
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_WARM_OPERATE_HISTORY);
        if (stringValue != null) {
            return toQueue(stringValue, this.mWarmSizeFromConfig);
        }
        return null;
    }

    private final void saveCoolHistory() {
        SimpleStorageUtil.INSTANCE.setStringValue(this.aContext, SimpleStorageUtil.REON_COOL_OPERATE_HISTORY, String.valueOf(this.mCoolQueue));
    }

    private final void saveWarmHistory() {
        SimpleStorageUtil.INSTANCE.setStringValue(this.aContext, SimpleStorageUtil.REON_WARM_OPERATE_HISTORY, String.valueOf(this.mWarmQueue));
    }

    private final boolean isTempHeavyUsed(AutoRemoveQueue autoRemoveQueue, float f) {
        if (f == this.FLOAT_UNDEFINED) {
            return false;
        }
        Iterator it = autoRemoveQueue.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (intValue == 3 || intValue == 4) {
                i++;
            }
        }
        if (((float) i) / ((float) autoRemoveQueue.size()) >= f) {
            return true;
        }
        return false;
    }

    private final AutoRemoveQueue toQueue(String str, int i) {
        if (i == this.INT_UNDEFINED) {
            return null;
        }
        List<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{AutoRemoveQueue.DELIMIT}, false, 0, 6, (Object) null);
        AutoRemoveQueue autoRemoveQueue = new AutoRemoveQueue(i);
        for (String str2 : split$default) {
            if (!TextUtils.isEmpty(str2)) {
                autoRemoveQueue.add(Integer.parseInt(str2));
            }
        }
        return autoRemoveQueue;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserBehaviorInteractor$AutoRemoveQueue;", "Ljava/util/LinkedList;", "", "aLimit", "(I)V", "mSize", "getMSize", "()I", "setMSize", "add", "", "element", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UserBehaviorInteractor.kt */
    public static final class AutoRemoveQueue extends LinkedList<Integer> {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String DELIMIT = "|";
        private int mSize;

        public AutoRemoveQueue(int i) {
            this.mSize = i;
        }

        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add(((Number) obj).intValue());
        }

        public /* bridge */ boolean contains(Integer num) {
            return super.contains(num);
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Integer)) {
                return false;
            }
            return contains((Integer) obj);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ int indexOf(Integer num) {
            return super.indexOf(num);
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return indexOf((Integer) obj);
        }

        public /* bridge */ int lastIndexOf(Integer num) {
            return super.lastIndexOf(num);
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return lastIndexOf((Integer) obj);
        }

        public final /* bridge */ Integer remove(int i) {
            return removeAt(i);
        }

        public /* bridge */ boolean remove(Integer num) {
            return super.remove(num);
        }

        public final /* bridge */ boolean remove(Object obj) {
            if (!(obj == null ? true : obj instanceof Integer)) {
                return false;
            }
            return remove((Integer) obj);
        }

        public /* bridge */ Integer removeAt(int i) {
            return (Integer) super.remove(i);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/UserBehaviorInteractor$AutoRemoveQueue$Companion;", "", "()V", "DELIMIT", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: UserBehaviorInteractor.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final int getMSize() {
            return this.mSize;
        }

        public final void setMSize(int i) {
            this.mSize = i;
        }

        public boolean add(int i) {
            super.add(Integer.valueOf(i));
            while (size() > this.mSize) {
                super.remove();
            }
            return true;
        }

        public String toString() {
            Iterator it = iterator();
            String str = "";
            while (it.hasNext()) {
                str = str + ((Number) it.next()).intValue() + DELIMIT;
            }
            return str;
        }
    }
}
