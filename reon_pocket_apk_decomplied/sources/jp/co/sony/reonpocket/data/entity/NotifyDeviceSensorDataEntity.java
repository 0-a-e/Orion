package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.SensorNotifyType;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JY\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006'"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/NotifyDeviceSensorDataEntity;", "Ljp/co/sony/reonpocket/data/entity/NotifySensorDataEntity;", "surfaceTemp", "", "tec1Temp", "finTemp", "innerTempA", "innerTempB", "innerHumiB", "tec2Temp", "skinContactStatus", "(FFFFFFFF)V", "getFinTemp", "()F", "getInnerHumiB", "getInnerTempA", "getInnerTempB", "getSkinContactStatus", "getSurfaceTemp", "getTec1Temp", "getTec2Temp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorDataEntity.kt */
public final class NotifyDeviceSensorDataEntity extends NotifySensorDataEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float UNKNOWN_VALUE = -0.01f;
    private final float finTemp;
    private final float innerHumiB;
    private final float innerTempA;
    private final float innerTempB;
    private final float skinContactStatus;
    private final float surfaceTemp;
    private final float tec1Temp;
    private final float tec2Temp;

    public static /* synthetic */ NotifyDeviceSensorDataEntity copy$default(NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i, Object obj) {
        NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity2 = notifyDeviceSensorDataEntity;
        int i2 = i;
        return notifyDeviceSensorDataEntity.copy((i2 & 1) != 0 ? notifyDeviceSensorDataEntity2.surfaceTemp : f, (i2 & 2) != 0 ? notifyDeviceSensorDataEntity2.tec1Temp : f2, (i2 & 4) != 0 ? notifyDeviceSensorDataEntity2.finTemp : f3, (i2 & 8) != 0 ? notifyDeviceSensorDataEntity2.innerTempA : f4, (i2 & 16) != 0 ? notifyDeviceSensorDataEntity2.innerTempB : f5, (i2 & 32) != 0 ? notifyDeviceSensorDataEntity2.innerHumiB : f6, (i2 & 64) != 0 ? notifyDeviceSensorDataEntity2.tec2Temp : f7, (i2 & 128) != 0 ? notifyDeviceSensorDataEntity2.skinContactStatus : f8);
    }

    public final float component1() {
        return this.surfaceTemp;
    }

    public final float component2() {
        return this.tec1Temp;
    }

    public final float component3() {
        return this.finTemp;
    }

    public final float component4() {
        return this.innerTempA;
    }

    public final float component5() {
        return this.innerTempB;
    }

    public final float component6() {
        return this.innerHumiB;
    }

    public final float component7() {
        return this.tec2Temp;
    }

    public final float component8() {
        return this.skinContactStatus;
    }

    public final NotifyDeviceSensorDataEntity copy(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return new NotifyDeviceSensorDataEntity(f, f2, f3, f4, f5, f6, f7, f8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotifyDeviceSensorDataEntity)) {
            return false;
        }
        NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity = (NotifyDeviceSensorDataEntity) obj;
        return Float.compare(this.surfaceTemp, notifyDeviceSensorDataEntity.surfaceTemp) == 0 && Float.compare(this.tec1Temp, notifyDeviceSensorDataEntity.tec1Temp) == 0 && Float.compare(this.finTemp, notifyDeviceSensorDataEntity.finTemp) == 0 && Float.compare(this.innerTempA, notifyDeviceSensorDataEntity.innerTempA) == 0 && Float.compare(this.innerTempB, notifyDeviceSensorDataEntity.innerTempB) == 0 && Float.compare(this.innerHumiB, notifyDeviceSensorDataEntity.innerHumiB) == 0 && Float.compare(this.tec2Temp, notifyDeviceSensorDataEntity.tec2Temp) == 0 && Float.compare(this.skinContactStatus, notifyDeviceSensorDataEntity.skinContactStatus) == 0;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.surfaceTemp) * 31) + Float.floatToIntBits(this.tec1Temp)) * 31) + Float.floatToIntBits(this.finTemp)) * 31) + Float.floatToIntBits(this.innerTempA)) * 31) + Float.floatToIntBits(this.innerTempB)) * 31) + Float.floatToIntBits(this.innerHumiB)) * 31) + Float.floatToIntBits(this.tec2Temp)) * 31) + Float.floatToIntBits(this.skinContactStatus);
    }

    public String toString() {
        float f = this.surfaceTemp;
        float f2 = this.tec1Temp;
        float f3 = this.finTemp;
        float f4 = this.innerTempA;
        float f5 = this.innerTempB;
        float f6 = this.innerHumiB;
        float f7 = this.tec2Temp;
        float f8 = this.skinContactStatus;
        return "NotifyDeviceSensorDataEntity(surfaceTemp=" + f + ", tec1Temp=" + f2 + ", finTemp=" + f3 + ", innerTempA=" + f4 + ", innerTempB=" + f5 + ", innerHumiB=" + f6 + ", tec2Temp=" + f7 + ", skinContactStatus=" + f8 + ")";
    }

    public final float getSurfaceTemp() {
        return this.surfaceTemp;
    }

    public final float getTec1Temp() {
        return this.tec1Temp;
    }

    public final float getFinTemp() {
        return this.finTemp;
    }

    public final float getInnerTempA() {
        return this.innerTempA;
    }

    public final float getInnerTempB() {
        return this.innerTempB;
    }

    public final float getInnerHumiB() {
        return this.innerHumiB;
    }

    public final float getTec2Temp() {
        return this.tec2Temp;
    }

    public final float getSkinContactStatus() {
        return this.skinContactStatus;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/NotifyDeviceSensorDataEntity$Companion;", "Ljp/co/sony/reonpocket/data/entity/SensorEntity;", "Ljp/co/sony/reonpocket/data/entity/NotifyDeviceSensorDataEntity;", "()V", "UNKNOWN_VALUE", "", "getObject", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SensorDataEntity.kt */
    public static final class Companion implements SensorEntity<NotifyDeviceSensorDataEntity> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public NotifyDeviceSensorDataEntity getObject(BleDataEntity bleDataEntity) {
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 34, 1, (ByteOrder) null, 4, (Object) null);
            IntRange intRange = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid surfaceTemp");
                return null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 3, (ByteOrder) null, 4, (Object) null);
            IntRange intRange2 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default2 == null || !intRange2.contains(intValue$default2.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid tec1Temp");
                return null;
            }
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 5, (ByteOrder) null, 4, (Object) null);
            IntRange intRange3 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default3 == null || !intRange3.contains(intValue$default3.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid finTemp");
                return null;
            }
            Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 7, (ByteOrder) null, 4, (Object) null);
            IntRange intRange4 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default4 == null || !intRange4.contains(intValue$default4.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid innerTempA");
                return null;
            }
            Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 9, (ByteOrder) null, 4, (Object) null);
            IntRange intRange5 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default5 == null || !intRange5.contains(intValue$default5.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid innerTempB");
                return null;
            }
            Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 11, (ByteOrder) null, 4, (Object) null);
            IntRange intRange6 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default6 == null || !intRange6.contains(intValue$default6.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid innerHumiB");
                return null;
            }
            Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 13, (ByteOrder) null, 4, (Object) null);
            IntRange intRange7 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default7 == null || !intRange7.contains(intValue$default7.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid tec2Temp");
                return null;
            }
            Integer intValue$default8 = BleDataEntity.getIntValue$default(bleDataEntity, 33, 14, (ByteOrder) null, 4, (Object) null);
            Intrinsics.checkNotNull(intValue$default);
            float intValue = ((float) intValue$default.intValue()) / 100.0f;
            Intrinsics.checkNotNull(intValue$default2);
            float intValue2 = ((float) intValue$default2.intValue()) / 100.0f;
            Intrinsics.checkNotNull(intValue$default3);
            float intValue3 = ((float) intValue$default3.intValue()) / 100.0f;
            Intrinsics.checkNotNull(intValue$default4);
            float intValue4 = ((float) intValue$default4.intValue()) / 100.0f;
            Intrinsics.checkNotNull(intValue$default5);
            float intValue5 = ((float) intValue$default5.intValue()) / 100.0f;
            Intrinsics.checkNotNull(intValue$default6);
            float intValue6 = ((float) intValue$default6.intValue()) / 100.0f;
            Intrinsics.checkNotNull(intValue$default7);
            return new NotifyDeviceSensorDataEntity(intValue, intValue2, intValue3, intValue4, intValue5, intValue6, ((float) intValue$default7.intValue()) / 100.0f, intValue$default8 != null ? (float) intValue$default8.intValue() : -0.01f);
        }
    }

    public NotifyDeviceSensorDataEntity(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        super(SensorNotifyType.DEVICE);
        this.surfaceTemp = f;
        this.tec1Temp = f2;
        this.finTemp = f3;
        this.innerTempA = f4;
        this.innerTempB = f5;
        this.innerHumiB = f6;
        this.tec2Temp = f7;
        this.skinContactStatus = f8;
    }
}
