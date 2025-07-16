package jp.co.sony.reonpocket.data.entity;

import jp.co.sony.reonpocket.constant.BatteryChargeStatus;
import jp.co.sony.reonpocket.constant.PowerSupplyStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/BatteryEntity;", "", "level", "", "batteryChargeStatus", "Ljp/co/sony/reonpocket/constant/BatteryChargeStatus;", "powerSupplyStatus", "Ljp/co/sony/reonpocket/constant/PowerSupplyStatus;", "remainTime", "(ILjp/co/sony/reonpocket/constant/BatteryChargeStatus;Ljp/co/sony/reonpocket/constant/PowerSupplyStatus;I)V", "getBatteryChargeStatus", "()Ljp/co/sony/reonpocket/constant/BatteryChargeStatus;", "getLevel", "()I", "getPowerSupplyStatus", "()Ljp/co/sony/reonpocket/constant/PowerSupplyStatus;", "getRemainTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BatteryEntity.kt */
public final class BatteryEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int UNKNOWN = 65535;
    private final BatteryChargeStatus batteryChargeStatus;
    private final int level;
    private final PowerSupplyStatus powerSupplyStatus;
    private final int remainTime;

    public static /* synthetic */ BatteryEntity copy$default(BatteryEntity batteryEntity, int i, BatteryChargeStatus batteryChargeStatus2, PowerSupplyStatus powerSupplyStatus2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = batteryEntity.level;
        }
        if ((i3 & 2) != 0) {
            batteryChargeStatus2 = batteryEntity.batteryChargeStatus;
        }
        if ((i3 & 4) != 0) {
            powerSupplyStatus2 = batteryEntity.powerSupplyStatus;
        }
        if ((i3 & 8) != 0) {
            i2 = batteryEntity.remainTime;
        }
        return batteryEntity.copy(i, batteryChargeStatus2, powerSupplyStatus2, i2);
    }

    public final int component1() {
        return this.level;
    }

    public final BatteryChargeStatus component2() {
        return this.batteryChargeStatus;
    }

    public final PowerSupplyStatus component3() {
        return this.powerSupplyStatus;
    }

    public final int component4() {
        return this.remainTime;
    }

    public final BatteryEntity copy(int i, BatteryChargeStatus batteryChargeStatus2, PowerSupplyStatus powerSupplyStatus2, int i2) {
        Intrinsics.checkNotNullParameter(batteryChargeStatus2, "batteryChargeStatus");
        Intrinsics.checkNotNullParameter(powerSupplyStatus2, "powerSupplyStatus");
        return new BatteryEntity(i, batteryChargeStatus2, powerSupplyStatus2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BatteryEntity)) {
            return false;
        }
        BatteryEntity batteryEntity = (BatteryEntity) obj;
        return this.level == batteryEntity.level && this.batteryChargeStatus == batteryEntity.batteryChargeStatus && this.powerSupplyStatus == batteryEntity.powerSupplyStatus && this.remainTime == batteryEntity.remainTime;
    }

    public int hashCode() {
        return (((((this.level * 31) + this.batteryChargeStatus.hashCode()) * 31) + this.powerSupplyStatus.hashCode()) * 31) + this.remainTime;
    }

    public String toString() {
        int i = this.level;
        BatteryChargeStatus batteryChargeStatus2 = this.batteryChargeStatus;
        PowerSupplyStatus powerSupplyStatus2 = this.powerSupplyStatus;
        int i2 = this.remainTime;
        return "BatteryEntity(level=" + i + ", batteryChargeStatus=" + batteryChargeStatus2 + ", powerSupplyStatus=" + powerSupplyStatus2 + ", remainTime=" + i2 + ")";
    }

    public BatteryEntity(int i, BatteryChargeStatus batteryChargeStatus2, PowerSupplyStatus powerSupplyStatus2, int i2) {
        Intrinsics.checkNotNullParameter(batteryChargeStatus2, "batteryChargeStatus");
        Intrinsics.checkNotNullParameter(powerSupplyStatus2, "powerSupplyStatus");
        this.level = i;
        this.batteryChargeStatus = batteryChargeStatus2;
        this.powerSupplyStatus = powerSupplyStatus2;
        this.remainTime = i2;
    }

    public final int getLevel() {
        return this.level;
    }

    public final BatteryChargeStatus getBatteryChargeStatus() {
        return this.batteryChargeStatus;
    }

    public final PowerSupplyStatus getPowerSupplyStatus() {
        return this.powerSupplyStatus;
    }

    public final int getRemainTime() {
        return this.remainTime;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/BatteryEntity$Companion;", "", "()V", "UNKNOWN", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BatteryEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
