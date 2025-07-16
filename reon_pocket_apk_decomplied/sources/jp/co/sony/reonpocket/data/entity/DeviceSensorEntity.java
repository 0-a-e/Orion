package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.ReadSensorResponseCode;
import jp.co.sony.reonpocket.constant.TagDataStatus;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B«\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b$\u0010\u0019R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b%\u0010\u0016R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b&\u0010\u0016R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b'\u0010\u0019R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b(\u0010\u0019¨\u0006*"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceSensorEntity;", "", "readResponse", "Ljp/co/sony/reonpocket/constant/ReadSensorResponseCode;", "surfaceTemp", "", "tecTemp", "finTemp", "innerTempA", "innerTempB", "innerHumiB", "tagFormatVersion", "", "tagDataStatus", "Ljp/co/sony/reonpocket/constant/TagDataStatus;", "tagTemp", "tagHumi", "tagIllu", "tagProx", "batteryLevel", "(Ljp/co/sony/reonpocket/constant/ReadSensorResponseCode;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TagDataStatus;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBatteryLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFinTemp", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getInnerHumiB", "getInnerTempA", "getInnerTempB", "getReadResponse", "()Ljp/co/sony/reonpocket/constant/ReadSensorResponseCode;", "getSurfaceTemp", "getTagDataStatus", "()Ljp/co/sony/reonpocket/constant/TagDataStatus;", "getTagFormatVersion", "getTagHumi", "getTagIllu", "getTagProx", "getTagTemp", "getTecTemp", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceSensorEntity.kt */
public final class DeviceSensorEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float DIVIDE_100F = 100.0f;
    public static final int MAX_RANGE = 32767;
    public static final int MIN_RANGE = -32767;
    public static final int OFFSET_0 = 0;
    public static final int OFFSET_1 = 1;
    public static final int OFFSET_11 = 11;
    public static final int OFFSET_3 = 3;
    public static final int OFFSET_5 = 5;
    public static final int OFFSET_7 = 7;
    public static final int OFFSET_9 = 9;
    private final Integer batteryLevel;
    private final Float finTemp;
    private final Float innerHumiB;
    private final Float innerTempA;
    private final Float innerTempB;
    private final ReadSensorResponseCode readResponse;
    private final Float surfaceTemp;
    private final TagDataStatus tagDataStatus;
    private final Integer tagFormatVersion;
    private final Float tagHumi;
    private final Integer tagIllu;
    private final Integer tagProx;
    private final Float tagTemp;
    private final Float tecTemp;

    public DeviceSensorEntity(ReadSensorResponseCode readSensorResponseCode, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Integer num, TagDataStatus tagDataStatus2, Float f7, Float f8, Integer num2, Integer num3, Integer num4) {
        this.readResponse = readSensorResponseCode;
        this.surfaceTemp = f;
        this.tecTemp = f2;
        this.finTemp = f3;
        this.innerTempA = f4;
        this.innerTempB = f5;
        this.innerHumiB = f6;
        this.tagFormatVersion = num;
        this.tagDataStatus = tagDataStatus2;
        this.tagTemp = f7;
        this.tagHumi = f8;
        this.tagIllu = num2;
        this.tagProx = num3;
        this.batteryLevel = num4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeviceSensorEntity(jp.co.sony.reonpocket.constant.ReadSensorResponseCode r15, java.lang.Float r16, java.lang.Float r17, java.lang.Float r18, java.lang.Float r19, java.lang.Float r20, java.lang.Float r21, java.lang.Integer r22, jp.co.sony.reonpocket.constant.TagDataStatus r23, java.lang.Float r24, java.lang.Float r25, java.lang.Integer r26, java.lang.Integer r27, java.lang.Integer r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r14 = this;
            r0 = r29
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r16
        L_0x000b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r17
        L_0x0013:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r18
        L_0x001b:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r19
        L_0x0023:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r20
        L_0x002b:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r21
        L_0x0033:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r22
        L_0x003b:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r23
        L_0x0043:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r24
        L_0x004b:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r25
        L_0x0053:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r26
        L_0x005b:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r27
        L_0x0063:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r2 = r28
        L_0x006a:
            r16 = r14
            r17 = r15
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r2
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.DeviceSensorEntity.<init>(jp.co.sony.reonpocket.constant.ReadSensorResponseCode, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Integer, jp.co.sony.reonpocket.constant.TagDataStatus, java.lang.Float, java.lang.Float, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ReadSensorResponseCode getReadResponse() {
        return this.readResponse;
    }

    public final Float getSurfaceTemp() {
        return this.surfaceTemp;
    }

    public final Float getTecTemp() {
        return this.tecTemp;
    }

    public final Float getFinTemp() {
        return this.finTemp;
    }

    public final Float getInnerTempA() {
        return this.innerTempA;
    }

    public final Float getInnerTempB() {
        return this.innerTempB;
    }

    public final Float getInnerHumiB() {
        return this.innerHumiB;
    }

    public final Integer getTagFormatVersion() {
        return this.tagFormatVersion;
    }

    public final TagDataStatus getTagDataStatus() {
        return this.tagDataStatus;
    }

    public final Float getTagTemp() {
        return this.tagTemp;
    }

    public final Float getTagHumi() {
        return this.tagHumi;
    }

    public final Integer getTagIllu() {
        return this.tagIllu;
    }

    public final Integer getTagProx() {
        return this.tagProx;
    }

    public final Integer getBatteryLevel() {
        return this.batteryLevel;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/DeviceSensorEntity$Companion;", "", "()V", "DIVIDE_100F", "", "MAX_RANGE", "", "MIN_RANGE", "OFFSET_0", "OFFSET_1", "OFFSET_11", "OFFSET_3", "OFFSET_5", "OFFSET_7", "OFFSET_9", "toObject", "Ljp/co/sony/reonpocket/data/entity/DeviceSensorEntity;", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceSensorEntity.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: DeviceSensorEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    jp.co.sony.reonpocket.constant.ReadSensorResponseCode[] r0 = jp.co.sony.reonpocket.constant.ReadSensorResponseCode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.constant.ReadSensorResponseCode r1 = jp.co.sony.reonpocket.constant.ReadSensorResponseCode.DEVICE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    jp.co.sony.reonpocket.constant.ReadSensorResponseCode r1 = jp.co.sony.reonpocket.constant.ReadSensorResponseCode.TAG     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.DeviceSensorEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSensorEntity toObject(BleDataEntity bleDataEntity) {
            ReadSensorResponseCode readSensorResponseCode;
            int i;
            ReadSensorResponseCode readSensorResponseCode2;
            Unit unit;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Float f = null;
            if (bleDataEntity.getData() != null) {
                ReadSensorResponseCode[] values = ReadSensorResponseCode.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        readSensorResponseCode2 = null;
                        break;
                    }
                    readSensorResponseCode2 = values[i2];
                    int code = readSensorResponseCode2.getCode();
                    Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
                    if (intValue$default != null && code == intValue$default.intValue()) {
                        break;
                    }
                    i2++;
                }
                if (readSensorResponseCode2 != null) {
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                    readSensorResponseCode2 = null;
                }
                if (unit == null) {
                    return null;
                }
                readSensorResponseCode = readSensorResponseCode2;
            } else {
                readSensorResponseCode = null;
            }
            if (readSensorResponseCode == null) {
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$0[readSensorResponseCode.ordinal()];
            }
            if (i != 1) {
                return null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 1, (ByteOrder) null, 4, (Object) null);
            IntRange intRange = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default2 == null || !intRange.contains(intValue$default2.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid surfaceTemp");
                return null;
            }
            Float valueOf = intValue$default2 != null ? Float.valueOf(((float) intValue$default2.intValue()) / 100.0f) : null;
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 3, (ByteOrder) null, 4, (Object) null);
            IntRange intRange2 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default3 == null || !intRange2.contains(intValue$default3.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid tecTemp");
                return null;
            }
            Float valueOf2 = intValue$default3 != null ? Float.valueOf(((float) intValue$default3.intValue()) / 100.0f) : null;
            Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 5, (ByteOrder) null, 4, (Object) null);
            IntRange intRange3 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default4 == null || !intRange3.contains(intValue$default4.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid finTemp");
                return null;
            }
            Float valueOf3 = intValue$default4 != null ? Float.valueOf(((float) intValue$default4.intValue()) / 100.0f) : null;
            Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 7, (ByteOrder) null, 4, (Object) null);
            IntRange intRange4 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default5 == null || !intRange4.contains(intValue$default5.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid innerTempA");
                return null;
            }
            Float valueOf4 = intValue$default5 != null ? Float.valueOf(((float) intValue$default5.intValue()) / 100.0f) : null;
            Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 9, (ByteOrder) null, 4, (Object) null);
            IntRange intRange5 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default6 == null || !intRange5.contains(intValue$default6.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid innerTempB");
                return null;
            }
            Float valueOf5 = intValue$default6 != null ? Float.valueOf(((float) intValue$default6.intValue()) / 100.0f) : null;
            Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity, 34, 11, (ByteOrder) null, 4, (Object) null);
            IntRange intRange6 = new IntRange(DeviceSensorEntity.MIN_RANGE, 32767);
            if (intValue$default7 == null || !intRange6.contains(intValue$default7.intValue())) {
                DebugLogUtil.INSTANCE.e("invalid innerHumiB");
                return null;
            }
            if (intValue$default7 != null) {
                f = Float.valueOf(((float) intValue$default7.intValue()) / 100.0f);
            }
            return new DeviceSensorEntity(readSensorResponseCode, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, f, (Integer) null, (TagDataStatus) null, (Float) null, (Float) null, (Integer) null, (Integer) null, (Integer) null, 16256, (DefaultConstructorMarker) null);
        }
    }
}
