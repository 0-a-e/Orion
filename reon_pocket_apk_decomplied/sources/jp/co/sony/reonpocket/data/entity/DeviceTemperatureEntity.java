package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006#"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceTemperatureEntity;", "", "surfaceTemp", "", "surfaceHumi", "environmentTemp", "environmentHumi", "tecTemp", "finTemp", "innerTemp", "(FFFFFFF)V", "getEnvironmentHumi", "()F", "getEnvironmentTemp", "getFinTemp", "getInnerTemp", "getSurfaceHumi", "getSurfaceTemp", "getTecTemp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceTemperatureEntity.kt */
public final class DeviceTemperatureEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final float environmentHumi;
    private final float environmentTemp;
    private final float finTemp;
    private final float innerTemp;
    private final float surfaceHumi;
    private final float surfaceTemp;
    private final float tecTemp;

    public static /* synthetic */ DeviceTemperatureEntity copy$default(DeviceTemperatureEntity deviceTemperatureEntity, float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f = deviceTemperatureEntity.surfaceTemp;
        }
        if ((i & 2) != 0) {
            f2 = deviceTemperatureEntity.surfaceHumi;
        }
        float f8 = f2;
        if ((i & 4) != 0) {
            f3 = deviceTemperatureEntity.environmentTemp;
        }
        float f9 = f3;
        if ((i & 8) != 0) {
            f4 = deviceTemperatureEntity.environmentHumi;
        }
        float f10 = f4;
        if ((i & 16) != 0) {
            f5 = deviceTemperatureEntity.tecTemp;
        }
        float f11 = f5;
        if ((i & 32) != 0) {
            f6 = deviceTemperatureEntity.finTemp;
        }
        float f12 = f6;
        if ((i & 64) != 0) {
            f7 = deviceTemperatureEntity.innerTemp;
        }
        return deviceTemperatureEntity.copy(f, f8, f9, f10, f11, f12, f7);
    }

    public final float component1() {
        return this.surfaceTemp;
    }

    public final float component2() {
        return this.surfaceHumi;
    }

    public final float component3() {
        return this.environmentTemp;
    }

    public final float component4() {
        return this.environmentHumi;
    }

    public final float component5() {
        return this.tecTemp;
    }

    public final float component6() {
        return this.finTemp;
    }

    public final float component7() {
        return this.innerTemp;
    }

    public final DeviceTemperatureEntity copy(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        return new DeviceTemperatureEntity(f, f2, f3, f4, f5, f6, f7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceTemperatureEntity)) {
            return false;
        }
        DeviceTemperatureEntity deviceTemperatureEntity = (DeviceTemperatureEntity) obj;
        return Float.compare(this.surfaceTemp, deviceTemperatureEntity.surfaceTemp) == 0 && Float.compare(this.surfaceHumi, deviceTemperatureEntity.surfaceHumi) == 0 && Float.compare(this.environmentTemp, deviceTemperatureEntity.environmentTemp) == 0 && Float.compare(this.environmentHumi, deviceTemperatureEntity.environmentHumi) == 0 && Float.compare(this.tecTemp, deviceTemperatureEntity.tecTemp) == 0 && Float.compare(this.finTemp, deviceTemperatureEntity.finTemp) == 0 && Float.compare(this.innerTemp, deviceTemperatureEntity.innerTemp) == 0;
    }

    public int hashCode() {
        return (((((((((((Float.floatToIntBits(this.surfaceTemp) * 31) + Float.floatToIntBits(this.surfaceHumi)) * 31) + Float.floatToIntBits(this.environmentTemp)) * 31) + Float.floatToIntBits(this.environmentHumi)) * 31) + Float.floatToIntBits(this.tecTemp)) * 31) + Float.floatToIntBits(this.finTemp)) * 31) + Float.floatToIntBits(this.innerTemp);
    }

    public String toString() {
        float f = this.surfaceTemp;
        float f2 = this.surfaceHumi;
        float f3 = this.environmentTemp;
        float f4 = this.environmentHumi;
        float f5 = this.tecTemp;
        float f6 = this.finTemp;
        float f7 = this.innerTemp;
        return "DeviceTemperatureEntity(surfaceTemp=" + f + ", surfaceHumi=" + f2 + ", environmentTemp=" + f3 + ", environmentHumi=" + f4 + ", tecTemp=" + f5 + ", finTemp=" + f6 + ", innerTemp=" + f7 + ")";
    }

    public DeviceTemperatureEntity(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.surfaceTemp = f;
        this.surfaceHumi = f2;
        this.environmentTemp = f3;
        this.environmentHumi = f4;
        this.tecTemp = f5;
        this.finTemp = f6;
        this.innerTemp = f7;
    }

    public final float getSurfaceTemp() {
        return this.surfaceTemp;
    }

    public final float getSurfaceHumi() {
        return this.surfaceHumi;
    }

    public final float getEnvironmentTemp() {
        return this.environmentTemp;
    }

    public final float getEnvironmentHumi() {
        return this.environmentHumi;
    }

    public final float getTecTemp() {
        return this.tecTemp;
    }

    public final float getFinTemp() {
        return this.finTemp;
    }

    public final float getInnerTemp() {
        return this.innerTemp;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceTemperatureEntity$Companion;", "", "()V", "toObject", "Ljp/co/sony/reonpocket/data/entity/DeviceTemperatureEntity;", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceTemperatureEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceTemperatureEntity toObject(BleDataEntity bleDataEntity) {
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 34, 0, (ByteOrder) null, 4, (Object) null);
            IntRange intRange = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid surfaceTemp");
                return null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 2, (ByteOrder) null, 4, (Object) null);
            IntRange intRange2 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange2.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid surfaceHumi");
                return null;
            }
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 4, (ByteOrder) null, 4, (Object) null);
            IntRange intRange3 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange3.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid environmentTemp");
                return null;
            }
            Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 6, (ByteOrder) null, 4, (Object) null);
            IntRange intRange4 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange4.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid environmentHumi");
                return null;
            }
            Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 8, (ByteOrder) null, 4, (Object) null);
            IntRange intRange5 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange5.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid tecTemp");
                return null;
            }
            Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 10, (ByteOrder) null, 4, (Object) null);
            IntRange intRange6 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange6.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid finTemp");
                return null;
            }
            Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 12, (ByteOrder) null, 4, (Object) null);
            IntRange intRange7 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default == null || !intRange7.contains(intValue$default.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid innerTemp");
                return null;
            }
            Intrinsics.checkNotNull(intValue$default);
            Intrinsics.checkNotNull(intValue$default2);
            Intrinsics.checkNotNull(intValue$default3);
            Intrinsics.checkNotNull(intValue$default4);
            Intrinsics.checkNotNull(intValue$default5);
            Intrinsics.checkNotNull(intValue$default6);
            Intrinsics.checkNotNull(intValue$default7);
            return new DeviceTemperatureEntity(((float) intValue$default.intValue()) / 100.0f, ((float) intValue$default2.intValue()) / 100.0f, ((float) intValue$default3.intValue()) / 100.0f, ((float) intValue$default4.intValue()) / 100.0f, ((float) intValue$default5.intValue()) / 100.0f, ((float) intValue$default6.intValue()) / 100.0f, ((float) intValue$default7.intValue()) / 100.0f);
        }
    }
}
