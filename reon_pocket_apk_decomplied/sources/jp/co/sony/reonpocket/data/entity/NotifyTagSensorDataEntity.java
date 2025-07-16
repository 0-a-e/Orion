package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.SensorNotifyType;
import jp.co.sony.reonpocket.constant.TagCarryAroundStatus;
import jp.co.sony.reonpocket.constant.TagCorrectionStatus;
import jp.co.sony.reonpocket.constant.TagIlluminationStatus;
import jp.co.sony.reonpocket.constant.TagProximityStatus;
import jp.co.sony.reonpocket.constant.TagSensorDataReceivedStatus;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001@Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\u0003HÖ\u0001J\t\u0010>\u001a\u00020?HÖ\u0001R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001e¨\u0006A"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "Ljp/co/sony/reonpocket/data/entity/NotifySensorDataEntity;", "tagFWVersionCode", "", "tagFormatVersion", "dataReceivedStatus", "Ljp/co/sony/reonpocket/constant/TagSensorDataReceivedStatus;", "tagTemp", "", "tagHumi", "tagIllumination", "tagProximity", "tempCorrection", "Ljp/co/sony/reonpocket/constant/TagCorrectionStatus;", "humiCorrection", "carryAroundStatus", "Ljp/co/sony/reonpocket/constant/TagCarryAroundStatus;", "tagIlluminationStatus", "Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;", "tagProximityStatus", "Ljp/co/sony/reonpocket/constant/TagProximityStatus;", "batteryLevel", "(IILjp/co/sony/reonpocket/constant/TagSensorDataReceivedStatus;FFIILjp/co/sony/reonpocket/constant/TagCorrectionStatus;Ljp/co/sony/reonpocket/constant/TagCorrectionStatus;Ljp/co/sony/reonpocket/constant/TagCarryAroundStatus;Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;Ljp/co/sony/reonpocket/constant/TagProximityStatus;I)V", "getBatteryLevel", "()I", "getCarryAroundStatus", "()Ljp/co/sony/reonpocket/constant/TagCarryAroundStatus;", "getDataReceivedStatus", "()Ljp/co/sony/reonpocket/constant/TagSensorDataReceivedStatus;", "getHumiCorrection", "()Ljp/co/sony/reonpocket/constant/TagCorrectionStatus;", "getTagFWVersionCode", "getTagFormatVersion", "getTagHumi", "()F", "getTagIllumination", "getTagIlluminationStatus", "()Ljp/co/sony/reonpocket/constant/TagIlluminationStatus;", "getTagProximity", "getTagProximityStatus", "()Ljp/co/sony/reonpocket/constant/TagProximityStatus;", "getTagTemp", "getTempCorrection", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorDataEntity.kt */
public final class NotifyTagSensorDataEntity extends NotifySensorDataEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int batteryLevel;
    private final TagCarryAroundStatus carryAroundStatus;
    private final TagSensorDataReceivedStatus dataReceivedStatus;
    private final TagCorrectionStatus humiCorrection;
    private final int tagFWVersionCode;
    private final int tagFormatVersion;
    private final float tagHumi;
    private final int tagIllumination;
    private final TagIlluminationStatus tagIlluminationStatus;
    private final int tagProximity;
    private final TagProximityStatus tagProximityStatus;
    private final float tagTemp;
    private final TagCorrectionStatus tempCorrection;

    public static /* synthetic */ NotifyTagSensorDataEntity copy$default(NotifyTagSensorDataEntity notifyTagSensorDataEntity, int i, int i2, TagSensorDataReceivedStatus tagSensorDataReceivedStatus, float f, float f2, int i3, int i4, TagCorrectionStatus tagCorrectionStatus, TagCorrectionStatus tagCorrectionStatus2, TagCarryAroundStatus tagCarryAroundStatus, TagIlluminationStatus tagIlluminationStatus2, TagProximityStatus tagProximityStatus2, int i5, int i6, Object obj) {
        NotifyTagSensorDataEntity notifyTagSensorDataEntity2 = notifyTagSensorDataEntity;
        int i7 = i6;
        return notifyTagSensorDataEntity.copy((i7 & 1) != 0 ? notifyTagSensorDataEntity2.tagFWVersionCode : i, (i7 & 2) != 0 ? notifyTagSensorDataEntity2.tagFormatVersion : i2, (i7 & 4) != 0 ? notifyTagSensorDataEntity2.dataReceivedStatus : tagSensorDataReceivedStatus, (i7 & 8) != 0 ? notifyTagSensorDataEntity2.tagTemp : f, (i7 & 16) != 0 ? notifyTagSensorDataEntity2.tagHumi : f2, (i7 & 32) != 0 ? notifyTagSensorDataEntity2.tagIllumination : i3, (i7 & 64) != 0 ? notifyTagSensorDataEntity2.tagProximity : i4, (i7 & 128) != 0 ? notifyTagSensorDataEntity2.tempCorrection : tagCorrectionStatus, (i7 & 256) != 0 ? notifyTagSensorDataEntity2.humiCorrection : tagCorrectionStatus2, (i7 & 512) != 0 ? notifyTagSensorDataEntity2.carryAroundStatus : tagCarryAroundStatus, (i7 & 1024) != 0 ? notifyTagSensorDataEntity2.tagIlluminationStatus : tagIlluminationStatus2, (i7 & 2048) != 0 ? notifyTagSensorDataEntity2.tagProximityStatus : tagProximityStatus2, (i7 & 4096) != 0 ? notifyTagSensorDataEntity2.batteryLevel : i5);
    }

    public final int component1() {
        return this.tagFWVersionCode;
    }

    public final TagCarryAroundStatus component10() {
        return this.carryAroundStatus;
    }

    public final TagIlluminationStatus component11() {
        return this.tagIlluminationStatus;
    }

    public final TagProximityStatus component12() {
        return this.tagProximityStatus;
    }

    public final int component13() {
        return this.batteryLevel;
    }

    public final int component2() {
        return this.tagFormatVersion;
    }

    public final TagSensorDataReceivedStatus component3() {
        return this.dataReceivedStatus;
    }

    public final float component4() {
        return this.tagTemp;
    }

    public final float component5() {
        return this.tagHumi;
    }

    public final int component6() {
        return this.tagIllumination;
    }

    public final int component7() {
        return this.tagProximity;
    }

    public final TagCorrectionStatus component8() {
        return this.tempCorrection;
    }

    public final TagCorrectionStatus component9() {
        return this.humiCorrection;
    }

    public final NotifyTagSensorDataEntity copy(int i, int i2, TagSensorDataReceivedStatus tagSensorDataReceivedStatus, float f, float f2, int i3, int i4, TagCorrectionStatus tagCorrectionStatus, TagCorrectionStatus tagCorrectionStatus2, TagCarryAroundStatus tagCarryAroundStatus, TagIlluminationStatus tagIlluminationStatus2, TagProximityStatus tagProximityStatus2, int i5) {
        TagSensorDataReceivedStatus tagSensorDataReceivedStatus2 = tagSensorDataReceivedStatus;
        Intrinsics.checkNotNullParameter(tagSensorDataReceivedStatus2, "dataReceivedStatus");
        return new NotifyTagSensorDataEntity(i, i2, tagSensorDataReceivedStatus2, f, f2, i3, i4, tagCorrectionStatus, tagCorrectionStatus2, tagCarryAroundStatus, tagIlluminationStatus2, tagProximityStatus2, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotifyTagSensorDataEntity)) {
            return false;
        }
        NotifyTagSensorDataEntity notifyTagSensorDataEntity = (NotifyTagSensorDataEntity) obj;
        return this.tagFWVersionCode == notifyTagSensorDataEntity.tagFWVersionCode && this.tagFormatVersion == notifyTagSensorDataEntity.tagFormatVersion && this.dataReceivedStatus == notifyTagSensorDataEntity.dataReceivedStatus && Float.compare(this.tagTemp, notifyTagSensorDataEntity.tagTemp) == 0 && Float.compare(this.tagHumi, notifyTagSensorDataEntity.tagHumi) == 0 && this.tagIllumination == notifyTagSensorDataEntity.tagIllumination && this.tagProximity == notifyTagSensorDataEntity.tagProximity && this.tempCorrection == notifyTagSensorDataEntity.tempCorrection && this.humiCorrection == notifyTagSensorDataEntity.humiCorrection && this.carryAroundStatus == notifyTagSensorDataEntity.carryAroundStatus && this.tagIlluminationStatus == notifyTagSensorDataEntity.tagIlluminationStatus && this.tagProximityStatus == notifyTagSensorDataEntity.tagProximityStatus && this.batteryLevel == notifyTagSensorDataEntity.batteryLevel;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.tagFWVersionCode * 31) + this.tagFormatVersion) * 31) + this.dataReceivedStatus.hashCode()) * 31) + Float.floatToIntBits(this.tagTemp)) * 31) + Float.floatToIntBits(this.tagHumi)) * 31) + this.tagIllumination) * 31) + this.tagProximity) * 31;
        TagCorrectionStatus tagCorrectionStatus = this.tempCorrection;
        int i = 0;
        int hashCode2 = (hashCode + (tagCorrectionStatus == null ? 0 : tagCorrectionStatus.hashCode())) * 31;
        TagCorrectionStatus tagCorrectionStatus2 = this.humiCorrection;
        int hashCode3 = (hashCode2 + (tagCorrectionStatus2 == null ? 0 : tagCorrectionStatus2.hashCode())) * 31;
        TagCarryAroundStatus tagCarryAroundStatus = this.carryAroundStatus;
        int hashCode4 = (hashCode3 + (tagCarryAroundStatus == null ? 0 : tagCarryAroundStatus.hashCode())) * 31;
        TagIlluminationStatus tagIlluminationStatus2 = this.tagIlluminationStatus;
        int hashCode5 = (hashCode4 + (tagIlluminationStatus2 == null ? 0 : tagIlluminationStatus2.hashCode())) * 31;
        TagProximityStatus tagProximityStatus2 = this.tagProximityStatus;
        if (tagProximityStatus2 != null) {
            i = tagProximityStatus2.hashCode();
        }
        return ((hashCode5 + i) * 31) + this.batteryLevel;
    }

    public String toString() {
        int i = this.tagFWVersionCode;
        int i2 = this.tagFormatVersion;
        TagSensorDataReceivedStatus tagSensorDataReceivedStatus = this.dataReceivedStatus;
        float f = this.tagTemp;
        float f2 = this.tagHumi;
        int i3 = this.tagIllumination;
        int i4 = this.tagProximity;
        TagCorrectionStatus tagCorrectionStatus = this.tempCorrection;
        TagCorrectionStatus tagCorrectionStatus2 = this.humiCorrection;
        TagCarryAroundStatus tagCarryAroundStatus = this.carryAroundStatus;
        TagIlluminationStatus tagIlluminationStatus2 = this.tagIlluminationStatus;
        TagProximityStatus tagProximityStatus2 = this.tagProximityStatus;
        int i5 = this.batteryLevel;
        return "NotifyTagSensorDataEntity(tagFWVersionCode=" + i + ", tagFormatVersion=" + i2 + ", dataReceivedStatus=" + tagSensorDataReceivedStatus + ", tagTemp=" + f + ", tagHumi=" + f2 + ", tagIllumination=" + i3 + ", tagProximity=" + i4 + ", tempCorrection=" + tagCorrectionStatus + ", humiCorrection=" + tagCorrectionStatus2 + ", carryAroundStatus=" + tagCarryAroundStatus + ", tagIlluminationStatus=" + tagIlluminationStatus2 + ", tagProximityStatus=" + tagProximityStatus2 + ", batteryLevel=" + i5 + ")";
    }

    public final int getTagFWVersionCode() {
        return this.tagFWVersionCode;
    }

    public final int getTagFormatVersion() {
        return this.tagFormatVersion;
    }

    public final TagSensorDataReceivedStatus getDataReceivedStatus() {
        return this.dataReceivedStatus;
    }

    public final float getTagTemp() {
        return this.tagTemp;
    }

    public final float getTagHumi() {
        return this.tagHumi;
    }

    public final int getTagIllumination() {
        return this.tagIllumination;
    }

    public final int getTagProximity() {
        return this.tagProximity;
    }

    public final TagCorrectionStatus getTempCorrection() {
        return this.tempCorrection;
    }

    public final TagCorrectionStatus getHumiCorrection() {
        return this.humiCorrection;
    }

    public final TagCarryAroundStatus getCarryAroundStatus() {
        return this.carryAroundStatus;
    }

    public final TagIlluminationStatus getTagIlluminationStatus() {
        return this.tagIlluminationStatus;
    }

    public final TagProximityStatus getTagProximityStatus() {
        return this.tagProximityStatus;
    }

    public final int getBatteryLevel() {
        return this.batteryLevel;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity$Companion;", "Ljp/co/sony/reonpocket/data/entity/SensorEntity;", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "()V", "getObject", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SensorDataEntity.kt */
    public static final class Companion implements SensorEntity<NotifyTagSensorDataEntity> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public NotifyTagSensorDataEntity getObject(BleDataEntity bleDataEntity) {
            TagSensorDataReceivedStatus tagSensorDataReceivedStatus;
            Integer intValue$default;
            TagCorrectionStatus tagCorrectionStatus;
            TagCorrectionStatus tagCorrectionStatus2;
            Unit unit;
            TagCorrectionStatus tagCorrectionStatus3;
            TagCorrectionStatus tagCorrectionStatus4;
            Unit unit2;
            TagCarryAroundStatus tagCarryAroundStatus;
            TagCarryAroundStatus tagCarryAroundStatus2;
            Unit unit3;
            TagIlluminationStatus tagIlluminationStatus;
            TagIlluminationStatus tagIlluminationStatus2;
            Unit unit4;
            TagProximityStatus tagProximityStatus;
            TagProximityStatus tagProximityStatus2;
            Unit unit5;
            Integer intValue$default2;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
            if (intValue$default3 != null) {
                int intValue = intValue$default3.intValue();
                if (1 > intValue || intValue >= 256) {
                    DebugLogUtil.INSTANCE.e("invalid tagFWVersionCode");
                }
                Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 2, (ByteOrder) null, 4, (Object) null);
                if (intValue$default4 != null) {
                    int intValue2 = intValue$default4.intValue();
                    if (intValue2 < 0 || intValue2 >= 256) {
                        DebugLogUtil.INSTANCE.e("invalid tagFormatVersion");
                    }
                    Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                    TagSensorDataReceivedStatus[] values = TagSensorDataReceivedStatus.values();
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            tagSensorDataReceivedStatus = null;
                            break;
                        }
                        TagSensorDataReceivedStatus tagSensorDataReceivedStatus2 = values[i];
                        int code = tagSensorDataReceivedStatus2.getCode();
                        if (intValue$default5 != null && code == intValue$default5.intValue()) {
                            tagSensorDataReceivedStatus = tagSensorDataReceivedStatus2;
                            break;
                        }
                        i++;
                    }
                    if (!(tagSensorDataReceivedStatus == null || (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 34, 4, (ByteOrder) null, 4, (Object) null)) == null)) {
                        int intValue3 = intValue$default.intValue();
                        if (-32767 > intValue3 || intValue3 >= 32768) {
                            DebugLogUtil.INSTANCE.e("invalid tagTemp");
                        }
                        Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 6, (ByteOrder) null, 4, (Object) null);
                        if (intValue$default6 != null) {
                            int intValue4 = intValue$default6.intValue();
                            if (-32767 > intValue4 || intValue4 >= 32768) {
                                DebugLogUtil.INSTANCE.e("invalid tagHumi");
                            }
                            int i2 = intValue4;
                            Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity, 18, 8, (ByteOrder) null, 4, (Object) null);
                            if (intValue$default7 != null) {
                                int intValue5 = intValue$default7.intValue();
                                if (intValue5 < 0 || intValue5 >= 65535) {
                                    DebugLogUtil.INSTANCE.e("invalid tagIllumination");
                                }
                                Integer intValue$default8 = BleDataEntity.getIntValue$default(bleDataEntity, 18, 10, (ByteOrder) null, 4, (Object) null);
                                if (intValue$default8 != null) {
                                    int intValue6 = intValue$default8.intValue();
                                    if (intValue6 < 0 || intValue6 >= 65535) {
                                        DebugLogUtil.INSTANCE.e("invalid tagProximity");
                                    }
                                    int i3 = intValue6;
                                    Integer intValue$default9 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 12, (ByteOrder) null, 4, (Object) null);
                                    TagCorrectionStatus[] values2 = TagCorrectionStatus.values();
                                    int length2 = values2.length;
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= length2) {
                                            tagCorrectionStatus = null;
                                            break;
                                        }
                                        tagCorrectionStatus = values2[i4];
                                        int code2 = tagCorrectionStatus.getCode();
                                        if (intValue$default9 == null) {
                                            return null;
                                        }
                                        if (code2 == (intValue$default9.intValue() & 1)) {
                                            break;
                                        }
                                        i4++;
                                    }
                                    if (tagCorrectionStatus != null) {
                                        unit = Unit.INSTANCE;
                                        tagCorrectionStatus2 = tagCorrectionStatus;
                                    } else {
                                        unit = null;
                                        tagCorrectionStatus2 = null;
                                    }
                                    if (unit == null) {
                                        return null;
                                    }
                                    TagCorrectionStatus[] values3 = TagCorrectionStatus.values();
                                    int length3 = values3.length;
                                    int i5 = 0;
                                    while (true) {
                                        if (i5 >= length3) {
                                            tagCorrectionStatus3 = null;
                                            break;
                                        }
                                        tagCorrectionStatus3 = values3[i5];
                                        int code3 = tagCorrectionStatus3.getCode();
                                        if (intValue$default9 == null) {
                                            return null;
                                        }
                                        if (code3 == ((intValue$default9.intValue() & 2) >> 1)) {
                                            break;
                                        }
                                        i5++;
                                    }
                                    if (tagCorrectionStatus3 != null) {
                                        unit2 = Unit.INSTANCE;
                                        tagCorrectionStatus4 = tagCorrectionStatus3;
                                    } else {
                                        unit2 = null;
                                        tagCorrectionStatus4 = null;
                                    }
                                    if (unit2 == null) {
                                        return null;
                                    }
                                    TagCarryAroundStatus[] values4 = TagCarryAroundStatus.values();
                                    int length4 = values4.length;
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= length4) {
                                            tagCarryAroundStatus = null;
                                            break;
                                        }
                                        tagCarryAroundStatus = values4[i6];
                                        int code4 = tagCarryAroundStatus.getCode();
                                        if (intValue$default9 == null) {
                                            return null;
                                        }
                                        if (code4 == ((intValue$default9.intValue() & 12) >> 2)) {
                                            break;
                                        }
                                        i6++;
                                    }
                                    if (tagCarryAroundStatus != null) {
                                        unit3 = Unit.INSTANCE;
                                        tagCarryAroundStatus2 = tagCarryAroundStatus;
                                    } else {
                                        unit3 = null;
                                        tagCarryAroundStatus2 = null;
                                    }
                                    if (unit3 == null) {
                                        return null;
                                    }
                                    TagIlluminationStatus[] values5 = TagIlluminationStatus.values();
                                    int length5 = values5.length;
                                    int i7 = 0;
                                    while (true) {
                                        if (i7 >= length5) {
                                            tagIlluminationStatus = null;
                                            break;
                                        }
                                        tagIlluminationStatus = values5[i7];
                                        int code5 = tagIlluminationStatus.getCode();
                                        if (intValue$default9 == null) {
                                            return null;
                                        }
                                        if (code5 == ((intValue$default9.intValue() & 48) >> 4)) {
                                            break;
                                        }
                                        i7++;
                                    }
                                    if (tagIlluminationStatus != null) {
                                        unit4 = Unit.INSTANCE;
                                        tagIlluminationStatus2 = tagIlluminationStatus;
                                    } else {
                                        unit4 = null;
                                        tagIlluminationStatus2 = null;
                                    }
                                    if (unit4 == null) {
                                        return null;
                                    }
                                    TagProximityStatus[] values6 = TagProximityStatus.values();
                                    int length6 = values6.length;
                                    int i8 = 0;
                                    while (true) {
                                        if (i8 >= length6) {
                                            tagProximityStatus = null;
                                            break;
                                        }
                                        tagProximityStatus = values6[i8];
                                        int code6 = tagProximityStatus.getCode();
                                        if (intValue$default9 == null) {
                                            return null;
                                        }
                                        if (code6 == ((intValue$default9.intValue() & 192) >> 6)) {
                                            break;
                                        }
                                        i8++;
                                    }
                                    if (tagProximityStatus != null) {
                                        unit5 = Unit.INSTANCE;
                                        tagProximityStatus2 = tagProximityStatus;
                                    } else {
                                        unit5 = null;
                                        tagProximityStatus2 = null;
                                    }
                                    if (!(unit5 == null || (intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 13, (ByteOrder) null, 4, (Object) null)) == null)) {
                                        int intValue7 = intValue$default2.intValue();
                                        if (intValue7 < 0 || intValue7 >= 101) {
                                            DebugLogUtil.INSTANCE.e("invalid batteryLevel");
                                        }
                                        return new NotifyTagSensorDataEntity(intValue, intValue2, tagSensorDataReceivedStatus, ((float) intValue3) / 100.0f, ((float) i2) / 100.0f, intValue5, i3, tagCorrectionStatus2, tagCorrectionStatus4, tagCarryAroundStatus2, tagIlluminationStatus2, tagProximityStatus2, intValue7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotifyTagSensorDataEntity(int i, int i2, TagSensorDataReceivedStatus tagSensorDataReceivedStatus, float f, float f2, int i3, int i4, TagCorrectionStatus tagCorrectionStatus, TagCorrectionStatus tagCorrectionStatus2, TagCarryAroundStatus tagCarryAroundStatus, TagIlluminationStatus tagIlluminationStatus2, TagProximityStatus tagProximityStatus2, int i5) {
        super(SensorNotifyType.TAG);
        Intrinsics.checkNotNullParameter(tagSensorDataReceivedStatus, "dataReceivedStatus");
        this.tagFWVersionCode = i;
        this.tagFormatVersion = i2;
        this.dataReceivedStatus = tagSensorDataReceivedStatus;
        this.tagTemp = f;
        this.tagHumi = f2;
        this.tagIllumination = i3;
        this.tagProximity = i4;
        this.tempCorrection = tagCorrectionStatus;
        this.humiCorrection = tagCorrectionStatus2;
        this.carryAroundStatus = tagCarryAroundStatus;
        this.tagIlluminationStatus = tagIlluminationStatus2;
        this.tagProximityStatus = tagProximityStatus2;
        this.batteryLevel = i5;
    }
}
