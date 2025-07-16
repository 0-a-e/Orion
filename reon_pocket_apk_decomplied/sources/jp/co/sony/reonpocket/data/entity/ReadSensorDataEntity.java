package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.SensorReadResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/ReadSensorDataEntity;", "Ljp/co/sony/reonpocket/data/entity/SensorDataEntity;", "readResponse", "Ljp/co/sony/reonpocket/constant/SensorReadResponse;", "(Ljp/co/sony/reonpocket/constant/SensorReadResponse;)V", "getReadResponse", "()Ljp/co/sony/reonpocket/constant/SensorReadResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorDataEntity.kt */
public final class ReadSensorDataEntity extends SensorDataEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SensorReadResponse readResponse;

    public static /* synthetic */ ReadSensorDataEntity copy$default(ReadSensorDataEntity readSensorDataEntity, SensorReadResponse sensorReadResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            sensorReadResponse = readSensorDataEntity.readResponse;
        }
        return readSensorDataEntity.copy(sensorReadResponse);
    }

    public final SensorReadResponse component1() {
        return this.readResponse;
    }

    public final ReadSensorDataEntity copy(SensorReadResponse sensorReadResponse) {
        Intrinsics.checkNotNullParameter(sensorReadResponse, "readResponse");
        return new ReadSensorDataEntity(sensorReadResponse);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReadSensorDataEntity) && this.readResponse == ((ReadSensorDataEntity) obj).readResponse;
    }

    public int hashCode() {
        return this.readResponse.hashCode();
    }

    public String toString() {
        SensorReadResponse sensorReadResponse = this.readResponse;
        return "ReadSensorDataEntity(readResponse=" + sensorReadResponse + ")";
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/ReadSensorDataEntity$Companion;", "Ljp/co/sony/reonpocket/data/entity/SensorEntity;", "Ljp/co/sony/reonpocket/data/entity/ReadSensorDataEntity;", "()V", "getObject", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SensorDataEntity.kt */
    public static final class Companion implements SensorEntity<ReadSensorDataEntity> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public ReadSensorDataEntity getObject(BleDataEntity bleDataEntity) {
            SensorReadResponse sensorReadResponse;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
            SensorReadResponse[] values = SensorReadResponse.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    sensorReadResponse = null;
                    break;
                }
                sensorReadResponse = values[i];
                int code = sensorReadResponse.getCode();
                if (intValue$default != null && code == intValue$default.intValue()) {
                    break;
                }
                i++;
            }
            if (sensorReadResponse == null) {
                return null;
            }
            return new ReadSensorDataEntity(sensorReadResponse);
        }
    }

    public ReadSensorDataEntity(SensorReadResponse sensorReadResponse) {
        Intrinsics.checkNotNullParameter(sensorReadResponse, "readResponse");
        this.readResponse = sensorReadResponse;
    }

    public final SensorReadResponse getReadResponse() {
        return this.readResponse;
    }
}
