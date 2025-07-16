package jp.co.sony.reonpocket.data.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b'\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/SensorDataEntity;", "", "()V", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorDataEntity.kt */
public abstract class SensorDataEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/SensorDataEntity$Companion;", "Ljp/co/sony/reonpocket/data/entity/SensorEntity;", "Ljp/co/sony/reonpocket/data/entity/SensorDataEntity;", "()V", "getObject", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SensorDataEntity.kt */
    public static final class Companion implements SensorEntity<SensorDataEntity> {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: SensorDataEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            static {
                /*
                    jp.co.sony.reonpocket.constant.BleActionCode[] r0 = jp.co.sony.reonpocket.constant.BleActionCode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.constant.BleActionCode r1 = jp.co.sony.reonpocket.constant.BleActionCode.READ     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    jp.co.sony.reonpocket.constant.BleActionCode r1 = jp.co.sony.reonpocket.constant.BleActionCode.NOTIFY     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.SensorDataEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public SensorDataEntity getObject(BleDataEntity bleDataEntity) {
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            int i = WhenMappings.$EnumSwitchMapping$0[bleDataEntity.getAction().ordinal()];
            if (i == 1 || i == 2) {
                return NotifySensorDataEntity.Companion.getObject(bleDataEntity);
            }
            return null;
        }
    }
}
