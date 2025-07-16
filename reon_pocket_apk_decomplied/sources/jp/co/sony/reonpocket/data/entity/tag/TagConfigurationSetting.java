package jp.co.sony.reonpocket.data.entity.tag;

import jp.co.sony.reonpocket.constant.TagAdvertiseConnection;
import jp.co.sony.reonpocket.constant.TagAdvertiseData;
import jp.co.sony.reonpocket.constant.TagMeasurementInterval;
import jp.co.sony.reonpocket.data.entity.BaseEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagConfigurationSetting;", "Ljp/co/sony/reonpocket/data/entity/BaseEntity;", "measurementInterval", "", "advertiseConnection", "Ljp/co/sony/reonpocket/constant/TagAdvertiseConnection;", "advertiseData", "Ljp/co/sony/reonpocket/constant/TagAdvertiseData;", "(ILjp/co/sony/reonpocket/constant/TagAdvertiseConnection;Ljp/co/sony/reonpocket/constant/TagAdvertiseData;)V", "getAdvertiseConnection", "()Ljp/co/sony/reonpocket/constant/TagAdvertiseConnection;", "getAdvertiseData", "()Ljp/co/sony/reonpocket/constant/TagAdvertiseData;", "getMeasurementInterval", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toByte", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagSetTagControlEntity.kt */
public final class TagConfigurationSetting implements BaseEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "SetConfiguration";
    private final TagAdvertiseConnection advertiseConnection;
    private final TagAdvertiseData advertiseData;
    private final int measurementInterval;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagSetTagControlEntity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reonpocket.constant.TagMeasurementInterval[] r0 = jp.co.sony.reonpocket.constant.TagMeasurementInterval.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.TagMeasurementInterval r1 = jp.co.sony.reonpocket.constant.TagMeasurementInterval.NO_SETTING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.TagMeasurementInterval r1 = jp.co.sony.reonpocket.constant.TagMeasurementInterval.VARIABLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.tag.TagConfigurationSetting.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ TagConfigurationSetting copy$default(TagConfigurationSetting tagConfigurationSetting, int i, TagAdvertiseConnection tagAdvertiseConnection, TagAdvertiseData tagAdvertiseData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tagConfigurationSetting.measurementInterval;
        }
        if ((i2 & 2) != 0) {
            tagAdvertiseConnection = tagConfigurationSetting.advertiseConnection;
        }
        if ((i2 & 4) != 0) {
            tagAdvertiseData = tagConfigurationSetting.advertiseData;
        }
        return tagConfigurationSetting.copy(i, tagAdvertiseConnection, tagAdvertiseData);
    }

    public final int component1() {
        return this.measurementInterval;
    }

    public final TagAdvertiseConnection component2() {
        return this.advertiseConnection;
    }

    public final TagAdvertiseData component3() {
        return this.advertiseData;
    }

    public final TagConfigurationSetting copy(int i, TagAdvertiseConnection tagAdvertiseConnection, TagAdvertiseData tagAdvertiseData) {
        Intrinsics.checkNotNullParameter(tagAdvertiseConnection, "advertiseConnection");
        Intrinsics.checkNotNullParameter(tagAdvertiseData, "advertiseData");
        return new TagConfigurationSetting(i, tagAdvertiseConnection, tagAdvertiseData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TagConfigurationSetting)) {
            return false;
        }
        TagConfigurationSetting tagConfigurationSetting = (TagConfigurationSetting) obj;
        return this.measurementInterval == tagConfigurationSetting.measurementInterval && this.advertiseConnection == tagConfigurationSetting.advertiseConnection && this.advertiseData == tagConfigurationSetting.advertiseData;
    }

    public int hashCode() {
        return (((this.measurementInterval * 31) + this.advertiseConnection.hashCode()) * 31) + this.advertiseData.hashCode();
    }

    public String toString() {
        int i = this.measurementInterval;
        TagAdvertiseConnection tagAdvertiseConnection = this.advertiseConnection;
        TagAdvertiseData tagAdvertiseData = this.advertiseData;
        return "TagConfigurationSetting(measurementInterval=" + i + ", advertiseConnection=" + tagAdvertiseConnection + ", advertiseData=" + tagAdvertiseData + ")";
    }

    public TagConfigurationSetting(int i, TagAdvertiseConnection tagAdvertiseConnection, TagAdvertiseData tagAdvertiseData) {
        Intrinsics.checkNotNullParameter(tagAdvertiseConnection, "advertiseConnection");
        Intrinsics.checkNotNullParameter(tagAdvertiseData, "advertiseData");
        this.measurementInterval = i;
        this.advertiseConnection = tagAdvertiseConnection;
        this.advertiseData = tagAdvertiseData;
    }

    public final int getMeasurementInterval() {
        return this.measurementInterval;
    }

    public final TagAdvertiseConnection getAdvertiseConnection() {
        return this.advertiseConnection;
    }

    public final TagAdvertiseData getAdvertiseData() {
        return this.advertiseData;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/tag/TagConfigurationSetting$Companion;", "", "()V", "LOG_TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagSetTagControlEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public byte[] toByte() {
        TagMeasurementInterval tagMeasurementInterval;
        int i = this.measurementInterval;
        TagMeasurementInterval[] values = TagMeasurementInterval.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                tagMeasurementInterval = null;
                break;
            }
            tagMeasurementInterval = values[i2];
            if (tagMeasurementInterval.getCode() == i) {
                break;
            }
            i2++;
        }
        TagMeasurementInterval tagMeasurementInterval2 = tagMeasurementInterval;
        int i3 = tagMeasurementInterval2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[tagMeasurementInterval2.ordinal()];
        if (i3 == 1) {
            DebugLogUtil.INSTANCE.d(LOG_TAG, "set no_setting");
        } else if (i3 != 2) {
            DebugLogUtil.INSTANCE.d(LOG_TAG, "set interval " + this.measurementInterval);
        } else {
            DebugLogUtil.INSTANCE.d(LOG_TAG, "set variable");
        }
        int i4 = this.measurementInterval;
        return ArraysKt.plus(ArraysKt.reversedArray(new byte[]{(byte) ((i4 >> 8) & 255), (byte) (i4 & 255)}), new byte[]{(byte) this.advertiseConnection.getCode(), (byte) this.advertiseData.getCode()});
    }
}
