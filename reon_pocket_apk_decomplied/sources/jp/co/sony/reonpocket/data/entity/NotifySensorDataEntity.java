package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.SensorNotifyType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/NotifySensorDataEntity;", "Ljp/co/sony/reonpocket/data/entity/SensorDataEntity;", "type", "Ljp/co/sony/reonpocket/constant/SensorNotifyType;", "(Ljp/co/sony/reonpocket/constant/SensorNotifyType;)V", "getType", "()Ljp/co/sony/reonpocket/constant/SensorNotifyType;", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorDataEntity.kt */
public abstract class NotifySensorDataEntity extends SensorDataEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SensorNotifyType type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/NotifySensorDataEntity$Companion;", "Ljp/co/sony/reonpocket/data/entity/SensorEntity;", "Ljp/co/sony/reonpocket/data/entity/NotifySensorDataEntity;", "()V", "getObject", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SensorDataEntity.kt */
    public static final class Companion implements SensorEntity<NotifySensorDataEntity> {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: SensorDataEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    jp.co.sony.reonpocket.constant.SensorNotifyType[] r0 = jp.co.sony.reonpocket.constant.SensorNotifyType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.constant.SensorNotifyType r1 = jp.co.sony.reonpocket.constant.SensorNotifyType.DEVICE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    jp.co.sony.reonpocket.constant.SensorNotifyType r1 = jp.co.sony.reonpocket.constant.SensorNotifyType.TAG     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.NotifySensorDataEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public NotifySensorDataEntity getObject(BleDataEntity bleDataEntity) {
            SensorNotifyType sensorNotifyType;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            int i = 0;
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
            SensorNotifyType[] values = SensorNotifyType.values();
            int length = values.length;
            while (true) {
                if (i >= length) {
                    sensorNotifyType = null;
                    break;
                }
                sensorNotifyType = values[i];
                int code = sensorNotifyType.getCode();
                if (intValue$default != null && code == intValue$default.intValue()) {
                    break;
                }
                i++;
            }
            if (sensorNotifyType == null) {
                return null;
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[sensorNotifyType.ordinal()];
            if (i2 == 1) {
                return NotifyDeviceSensorDataEntity.Companion.getObject(bleDataEntity);
            }
            if (i2 == 2) {
                return NotifyTagSensorDataEntity.Companion.getObject(bleDataEntity);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public NotifySensorDataEntity(SensorNotifyType sensorNotifyType) {
        Intrinsics.checkNotNullParameter(sensorNotifyType, TransferTable.COLUMN_TYPE);
        this.type = sensorNotifyType;
    }

    public final SensorNotifyType getType() {
        return this.type;
    }
}
