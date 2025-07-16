package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import java.util.Iterator;
import jp.co.sony.reonpocket.constant.AirFlowStateCode;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempSpecialOption;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.ThermoControlPhaseCode;
import jp.co.sony.reonpocket.constant.ThermoModeCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 P2\u00020\u0001:\u0001PB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0002\u0010\u001cJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0013HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0007HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000bHÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\t\u0010F\u001a\u00020\rHÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0010HÆ\u0003J½\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0005HÖ\u0001J\t\u0010N\u001a\u00020OHÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 ¨\u0006Q"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/ThermoControlStatusEntity;", "", "coolHeatType", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "tempSetting", "", "option1", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "option2", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "option3", "Ljp/co/sony/reonpocket/constant/TempSpecialOption;", "tec1ThermoControlPhase", "Ljp/co/sony/reonpocket/constant/ThermoControlPhaseCode;", "tec2ThermoControlPhase", "tec1ThermoModeCode", "Ljp/co/sony/reonpocket/constant/ThermoModeCode;", "tec2ThermoModeCode", "airflowOnOff", "Ljp/co/sony/reonpocket/constant/AirFlowStateCode;", "airflowStep", "fanRate", "tec1MaxPower", "tec1CurrentPower", "tec2MaxPower", "tec2CurrentPower", "fanMaxPower", "fanCurrentPower", "(Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;ILjp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;Ljp/co/sony/reonpocket/constant/TempSpecialOption;Ljp/co/sony/reonpocket/constant/ThermoControlPhaseCode;Ljp/co/sony/reonpocket/constant/ThermoControlPhaseCode;Ljp/co/sony/reonpocket/constant/ThermoModeCode;Ljp/co/sony/reonpocket/constant/ThermoModeCode;Ljp/co/sony/reonpocket/constant/AirFlowStateCode;IIIIIIII)V", "getAirflowOnOff", "()Ljp/co/sony/reonpocket/constant/AirFlowStateCode;", "getAirflowStep", "()I", "getCoolHeatType", "()Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "getFanCurrentPower", "getFanMaxPower", "getFanRate", "getOption1", "()Ljp/co/sony/reonpocket/constant/TempBoostOption;", "getOption2", "()Ljp/co/sony/reonpocket/constant/TempWaveOption;", "getOption3", "()Ljp/co/sony/reonpocket/constant/TempSpecialOption;", "getTec1CurrentPower", "getTec1MaxPower", "getTec1ThermoControlPhase", "()Ljp/co/sony/reonpocket/constant/ThermoControlPhaseCode;", "getTec1ThermoModeCode", "()Ljp/co/sony/reonpocket/constant/ThermoModeCode;", "getTec2CurrentPower", "getTec2MaxPower", "getTec2ThermoControlPhase", "getTec2ThermoModeCode", "getTempSetting", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ThermoControlStatusEntity.kt */
public final class ThermoControlStatusEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AirFlowStateCode airflowOnOff;
    private final int airflowStep;
    private final CoolHeatTypeCode coolHeatType;
    private final int fanCurrentPower;
    private final int fanMaxPower;
    private final int fanRate;
    private final TempBoostOption option1;
    private final TempWaveOption option2;
    private final TempSpecialOption option3;
    private final int tec1CurrentPower;
    private final int tec1MaxPower;
    private final ThermoControlPhaseCode tec1ThermoControlPhase;
    private final ThermoModeCode tec1ThermoModeCode;
    private final int tec2CurrentPower;
    private final int tec2MaxPower;
    private final ThermoControlPhaseCode tec2ThermoControlPhase;
    private final ThermoModeCode tec2ThermoModeCode;
    private final int tempSetting;

    public static /* synthetic */ ThermoControlStatusEntity copy$default(ThermoControlStatusEntity thermoControlStatusEntity, CoolHeatTypeCode coolHeatTypeCode, int i, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption, TempSpecialOption tempSpecialOption, ThermoControlPhaseCode thermoControlPhaseCode, ThermoControlPhaseCode thermoControlPhaseCode2, ThermoModeCode thermoModeCode, ThermoModeCode thermoModeCode2, AirFlowStateCode airFlowStateCode, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Object obj) {
        ThermoControlStatusEntity thermoControlStatusEntity2 = thermoControlStatusEntity;
        int i11 = i10;
        return thermoControlStatusEntity.copy((i11 & 1) != 0 ? thermoControlStatusEntity2.coolHeatType : coolHeatTypeCode, (i11 & 2) != 0 ? thermoControlStatusEntity2.tempSetting : i, (i11 & 4) != 0 ? thermoControlStatusEntity2.option1 : tempBoostOption, (i11 & 8) != 0 ? thermoControlStatusEntity2.option2 : tempWaveOption, (i11 & 16) != 0 ? thermoControlStatusEntity2.option3 : tempSpecialOption, (i11 & 32) != 0 ? thermoControlStatusEntity2.tec1ThermoControlPhase : thermoControlPhaseCode, (i11 & 64) != 0 ? thermoControlStatusEntity2.tec2ThermoControlPhase : thermoControlPhaseCode2, (i11 & 128) != 0 ? thermoControlStatusEntity2.tec1ThermoModeCode : thermoModeCode, (i11 & 256) != 0 ? thermoControlStatusEntity2.tec2ThermoModeCode : thermoModeCode2, (i11 & 512) != 0 ? thermoControlStatusEntity2.airflowOnOff : airFlowStateCode, (i11 & 1024) != 0 ? thermoControlStatusEntity2.airflowStep : i2, (i11 & 2048) != 0 ? thermoControlStatusEntity2.fanRate : i3, (i11 & 4096) != 0 ? thermoControlStatusEntity2.tec1MaxPower : i4, (i11 & 8192) != 0 ? thermoControlStatusEntity2.tec1CurrentPower : i5, (i11 & 16384) != 0 ? thermoControlStatusEntity2.tec2MaxPower : i6, (i11 & 32768) != 0 ? thermoControlStatusEntity2.tec2CurrentPower : i7, (i11 & 65536) != 0 ? thermoControlStatusEntity2.fanMaxPower : i8, (i11 & 131072) != 0 ? thermoControlStatusEntity2.fanCurrentPower : i9);
    }

    @JvmStatic
    public static final ThermoControlStatusEntity toObject(BleDataEntity bleDataEntity) {
        return Companion.toObject(bleDataEntity);
    }

    public final CoolHeatTypeCode component1() {
        return this.coolHeatType;
    }

    public final AirFlowStateCode component10() {
        return this.airflowOnOff;
    }

    public final int component11() {
        return this.airflowStep;
    }

    public final int component12() {
        return this.fanRate;
    }

    public final int component13() {
        return this.tec1MaxPower;
    }

    public final int component14() {
        return this.tec1CurrentPower;
    }

    public final int component15() {
        return this.tec2MaxPower;
    }

    public final int component16() {
        return this.tec2CurrentPower;
    }

    public final int component17() {
        return this.fanMaxPower;
    }

    public final int component18() {
        return this.fanCurrentPower;
    }

    public final int component2() {
        return this.tempSetting;
    }

    public final TempBoostOption component3() {
        return this.option1;
    }

    public final TempWaveOption component4() {
        return this.option2;
    }

    public final TempSpecialOption component5() {
        return this.option3;
    }

    public final ThermoControlPhaseCode component6() {
        return this.tec1ThermoControlPhase;
    }

    public final ThermoControlPhaseCode component7() {
        return this.tec2ThermoControlPhase;
    }

    public final ThermoModeCode component8() {
        return this.tec1ThermoModeCode;
    }

    public final ThermoModeCode component9() {
        return this.tec2ThermoModeCode;
    }

    public final ThermoControlStatusEntity copy(CoolHeatTypeCode coolHeatTypeCode, int i, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption, TempSpecialOption tempSpecialOption, ThermoControlPhaseCode thermoControlPhaseCode, ThermoControlPhaseCode thermoControlPhaseCode2, ThermoModeCode thermoModeCode, ThermoModeCode thermoModeCode2, AirFlowStateCode airFlowStateCode, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        CoolHeatTypeCode coolHeatTypeCode2 = coolHeatTypeCode;
        Intrinsics.checkNotNullParameter(coolHeatTypeCode2, "coolHeatType");
        Intrinsics.checkNotNullParameter(tempBoostOption, "option1");
        Intrinsics.checkNotNullParameter(tempWaveOption, "option2");
        Intrinsics.checkNotNullParameter(tempSpecialOption, "option3");
        Intrinsics.checkNotNullParameter(thermoControlPhaseCode, "tec1ThermoControlPhase");
        Intrinsics.checkNotNullParameter(thermoControlPhaseCode2, "tec2ThermoControlPhase");
        Intrinsics.checkNotNullParameter(thermoModeCode, "tec1ThermoModeCode");
        Intrinsics.checkNotNullParameter(thermoModeCode2, "tec2ThermoModeCode");
        Intrinsics.checkNotNullParameter(airFlowStateCode, "airflowOnOff");
        return new ThermoControlStatusEntity(coolHeatTypeCode2, i, tempBoostOption, tempWaveOption, tempSpecialOption, thermoControlPhaseCode, thermoControlPhaseCode2, thermoModeCode, thermoModeCode2, airFlowStateCode, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThermoControlStatusEntity)) {
            return false;
        }
        ThermoControlStatusEntity thermoControlStatusEntity = (ThermoControlStatusEntity) obj;
        return this.coolHeatType == thermoControlStatusEntity.coolHeatType && this.tempSetting == thermoControlStatusEntity.tempSetting && this.option1 == thermoControlStatusEntity.option1 && this.option2 == thermoControlStatusEntity.option2 && this.option3 == thermoControlStatusEntity.option3 && this.tec1ThermoControlPhase == thermoControlStatusEntity.tec1ThermoControlPhase && this.tec2ThermoControlPhase == thermoControlStatusEntity.tec2ThermoControlPhase && this.tec1ThermoModeCode == thermoControlStatusEntity.tec1ThermoModeCode && this.tec2ThermoModeCode == thermoControlStatusEntity.tec2ThermoModeCode && this.airflowOnOff == thermoControlStatusEntity.airflowOnOff && this.airflowStep == thermoControlStatusEntity.airflowStep && this.fanRate == thermoControlStatusEntity.fanRate && this.tec1MaxPower == thermoControlStatusEntity.tec1MaxPower && this.tec1CurrentPower == thermoControlStatusEntity.tec1CurrentPower && this.tec2MaxPower == thermoControlStatusEntity.tec2MaxPower && this.tec2CurrentPower == thermoControlStatusEntity.tec2CurrentPower && this.fanMaxPower == thermoControlStatusEntity.fanMaxPower && this.fanCurrentPower == thermoControlStatusEntity.fanCurrentPower;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.coolHeatType.hashCode() * 31) + this.tempSetting) * 31) + this.option1.hashCode()) * 31) + this.option2.hashCode()) * 31) + this.option3.hashCode()) * 31) + this.tec1ThermoControlPhase.hashCode()) * 31) + this.tec2ThermoControlPhase.hashCode()) * 31) + this.tec1ThermoModeCode.hashCode()) * 31) + this.tec2ThermoModeCode.hashCode()) * 31) + this.airflowOnOff.hashCode()) * 31) + this.airflowStep) * 31) + this.fanRate) * 31) + this.tec1MaxPower) * 31) + this.tec1CurrentPower) * 31) + this.tec2MaxPower) * 31) + this.tec2CurrentPower) * 31) + this.fanMaxPower) * 31) + this.fanCurrentPower;
    }

    public String toString() {
        CoolHeatTypeCode coolHeatTypeCode = this.coolHeatType;
        int i = this.tempSetting;
        TempBoostOption tempBoostOption = this.option1;
        TempWaveOption tempWaveOption = this.option2;
        TempSpecialOption tempSpecialOption = this.option3;
        ThermoControlPhaseCode thermoControlPhaseCode = this.tec1ThermoControlPhase;
        ThermoControlPhaseCode thermoControlPhaseCode2 = this.tec2ThermoControlPhase;
        ThermoModeCode thermoModeCode = this.tec1ThermoModeCode;
        ThermoModeCode thermoModeCode2 = this.tec2ThermoModeCode;
        AirFlowStateCode airFlowStateCode = this.airflowOnOff;
        int i2 = this.airflowStep;
        int i3 = this.fanRate;
        int i4 = this.tec1MaxPower;
        int i5 = this.tec1CurrentPower;
        int i6 = this.tec2MaxPower;
        int i7 = this.tec2CurrentPower;
        int i8 = this.fanMaxPower;
        return "ThermoControlStatusEntity(coolHeatType=" + coolHeatTypeCode + ", tempSetting=" + i + ", option1=" + tempBoostOption + ", option2=" + tempWaveOption + ", option3=" + tempSpecialOption + ", tec1ThermoControlPhase=" + thermoControlPhaseCode + ", tec2ThermoControlPhase=" + thermoControlPhaseCode2 + ", tec1ThermoModeCode=" + thermoModeCode + ", tec2ThermoModeCode=" + thermoModeCode2 + ", airflowOnOff=" + airFlowStateCode + ", airflowStep=" + i2 + ", fanRate=" + i3 + ", tec1MaxPower=" + i4 + ", tec1CurrentPower=" + i5 + ", tec2MaxPower=" + i6 + ", tec2CurrentPower=" + i7 + ", fanMaxPower=" + i8 + ", fanCurrentPower=" + this.fanCurrentPower + ")";
    }

    public ThermoControlStatusEntity(CoolHeatTypeCode coolHeatTypeCode, int i, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption, TempSpecialOption tempSpecialOption, ThermoControlPhaseCode thermoControlPhaseCode, ThermoControlPhaseCode thermoControlPhaseCode2, ThermoModeCode thermoModeCode, ThermoModeCode thermoModeCode2, AirFlowStateCode airFlowStateCode, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        TempSpecialOption tempSpecialOption2 = tempSpecialOption;
        ThermoControlPhaseCode thermoControlPhaseCode3 = thermoControlPhaseCode;
        ThermoControlPhaseCode thermoControlPhaseCode4 = thermoControlPhaseCode2;
        ThermoModeCode thermoModeCode3 = thermoModeCode;
        ThermoModeCode thermoModeCode4 = thermoModeCode2;
        AirFlowStateCode airFlowStateCode2 = airFlowStateCode;
        Intrinsics.checkNotNullParameter(coolHeatTypeCode, "coolHeatType");
        Intrinsics.checkNotNullParameter(tempBoostOption, "option1");
        Intrinsics.checkNotNullParameter(tempWaveOption, "option2");
        Intrinsics.checkNotNullParameter(tempSpecialOption2, "option3");
        Intrinsics.checkNotNullParameter(thermoControlPhaseCode3, "tec1ThermoControlPhase");
        Intrinsics.checkNotNullParameter(thermoControlPhaseCode4, "tec2ThermoControlPhase");
        Intrinsics.checkNotNullParameter(thermoModeCode3, "tec1ThermoModeCode");
        Intrinsics.checkNotNullParameter(thermoModeCode4, "tec2ThermoModeCode");
        Intrinsics.checkNotNullParameter(airFlowStateCode2, "airflowOnOff");
        this.coolHeatType = coolHeatTypeCode;
        this.tempSetting = i;
        this.option1 = tempBoostOption;
        this.option2 = tempWaveOption;
        this.option3 = tempSpecialOption2;
        this.tec1ThermoControlPhase = thermoControlPhaseCode3;
        this.tec2ThermoControlPhase = thermoControlPhaseCode4;
        this.tec1ThermoModeCode = thermoModeCode3;
        this.tec2ThermoModeCode = thermoModeCode4;
        this.airflowOnOff = airFlowStateCode2;
        this.airflowStep = i2;
        this.fanRate = i3;
        this.tec1MaxPower = i4;
        this.tec1CurrentPower = i5;
        this.tec2MaxPower = i6;
        this.tec2CurrentPower = i7;
        this.fanMaxPower = i8;
        this.fanCurrentPower = i9;
    }

    public final CoolHeatTypeCode getCoolHeatType() {
        return this.coolHeatType;
    }

    public final int getTempSetting() {
        return this.tempSetting;
    }

    public final TempBoostOption getOption1() {
        return this.option1;
    }

    public final TempWaveOption getOption2() {
        return this.option2;
    }

    public final TempSpecialOption getOption3() {
        return this.option3;
    }

    public final ThermoControlPhaseCode getTec1ThermoControlPhase() {
        return this.tec1ThermoControlPhase;
    }

    public final ThermoControlPhaseCode getTec2ThermoControlPhase() {
        return this.tec2ThermoControlPhase;
    }

    public final ThermoModeCode getTec1ThermoModeCode() {
        return this.tec1ThermoModeCode;
    }

    public final ThermoModeCode getTec2ThermoModeCode() {
        return this.tec2ThermoModeCode;
    }

    public final AirFlowStateCode getAirflowOnOff() {
        return this.airflowOnOff;
    }

    public final int getAirflowStep() {
        return this.airflowStep;
    }

    public final int getFanRate() {
        return this.fanRate;
    }

    public final int getTec1MaxPower() {
        return this.tec1MaxPower;
    }

    public final int getTec1CurrentPower() {
        return this.tec1CurrentPower;
    }

    public final int getTec2MaxPower() {
        return this.tec2MaxPower;
    }

    public final int getTec2CurrentPower() {
        return this.tec2CurrentPower;
    }

    public final int getFanMaxPower() {
        return this.fanMaxPower;
    }

    public final int getFanCurrentPower() {
        return this.fanCurrentPower;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/ThermoControlStatusEntity$Companion;", "", "()V", "toObject", "Ljp/co/sony/reonpocket/data/entity/ThermoControlStatusEntity;", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ThermoControlStatusEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ThermoControlStatusEntity toObject(BleDataEntity bleDataEntity) {
            CoolHeatTypeCode coolHeatTypeCode;
            CoolHeatTypeCode coolHeatTypeCode2;
            Unit unit;
            TempBoostOption tempBoostOption;
            TempBoostOption tempBoostOption2;
            Unit unit2;
            TempWaveOption tempWaveOption;
            TempWaveOption tempWaveOption2;
            Unit unit3;
            TempSpecialOption tempSpecialOption;
            TempSpecialOption tempSpecialOption2;
            Unit unit4;
            Integer intValue$default;
            Object obj;
            ThermoControlPhaseCode thermoControlPhaseCode;
            Unit unit5;
            Object obj2;
            ThermoControlPhaseCode thermoControlPhaseCode2;
            Unit unit6;
            Integer intValue$default2;
            Object obj3;
            ThermoModeCode thermoModeCode;
            Unit unit7;
            Object obj4;
            ThermoModeCode thermoModeCode2;
            Unit unit8;
            AirFlowStateCode airFlowStateCode;
            AirFlowStateCode airFlowStateCode2;
            Unit unit9;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            if (bleDataEntity.getData() == null) {
                return null;
            }
            Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
            CoolHeatTypeCode[] values = CoolHeatTypeCode.values();
            int length = values.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    coolHeatTypeCode = null;
                    break;
                }
                coolHeatTypeCode = values[i2];
                int code = coolHeatTypeCode.getCode();
                if (intValue$default3 != null && code == intValue$default3.intValue()) {
                    break;
                }
                i2++;
            }
            if (coolHeatTypeCode != null) {
                unit = Unit.INSTANCE;
                coolHeatTypeCode2 = coolHeatTypeCode;
            } else {
                unit = null;
                coolHeatTypeCode2 = null;
            }
            if (unit == null) {
                return null;
            }
            BleDataEntity bleDataEntity2 = bleDataEntity;
            Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity2, 17, 1, (ByteOrder) null, 4, (Object) null);
            Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity2, 17, 2, (ByteOrder) null, 4, (Object) null);
            if (intValue$default5 != null) {
                intValue$default5.intValue();
                TempBoostOption[] values2 = TempBoostOption.values();
                int length2 = values2.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        tempBoostOption = null;
                        break;
                    }
                    tempBoostOption = values2[i3];
                    if (tempBoostOption.getCode() == (intValue$default5.intValue() & 3)) {
                        break;
                    }
                    i3++;
                }
                if (tempBoostOption != null) {
                    unit2 = Unit.INSTANCE;
                    tempBoostOption2 = tempBoostOption;
                } else {
                    unit2 = null;
                    tempBoostOption2 = null;
                }
                if (unit2 == null) {
                    return null;
                }
                TempWaveOption[] values3 = TempWaveOption.values();
                int length3 = values3.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length3) {
                        tempWaveOption = null;
                        break;
                    }
                    tempWaveOption = values3[i4];
                    if (tempWaveOption.getCode() == ((intValue$default5.intValue() & 4) >> 2)) {
                        break;
                    }
                    i4++;
                }
                if (tempWaveOption != null) {
                    unit3 = Unit.INSTANCE;
                    tempWaveOption2 = tempWaveOption;
                } else {
                    unit3 = null;
                    tempWaveOption2 = null;
                }
                if (unit3 == null) {
                    return null;
                }
                TempSpecialOption[] values4 = TempSpecialOption.values();
                int length4 = values4.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length4) {
                        tempSpecialOption = null;
                        break;
                    }
                    tempSpecialOption = values4[i5];
                    if (tempSpecialOption.getCode() == ((intValue$default5.intValue() & 8) >> 3)) {
                        break;
                    }
                    i5++;
                }
                if (tempSpecialOption != null) {
                    unit4 = Unit.INSTANCE;
                    tempSpecialOption2 = tempSpecialOption;
                } else {
                    unit4 = null;
                    tempSpecialOption2 = null;
                }
                if (!(unit4 == null || (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null)) == null)) {
                    intValue$default.intValue();
                    Iterator it = ThermoControlPhaseCode.getEntries().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((ThermoControlPhaseCode) obj).getCode() == (intValue$default.intValue() & 7)) {
                            break;
                        }
                    }
                    ThermoControlPhaseCode thermoControlPhaseCode3 = (ThermoControlPhaseCode) obj;
                    if (thermoControlPhaseCode3 != null) {
                        unit5 = Unit.INSTANCE;
                        thermoControlPhaseCode = thermoControlPhaseCode3;
                    } else {
                        unit5 = null;
                        thermoControlPhaseCode = null;
                    }
                    if (unit5 == null) {
                        return null;
                    }
                    Iterator it2 = ThermoControlPhaseCode.getEntries().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        if (((ThermoControlPhaseCode) obj2).getCode() == ((intValue$default.intValue() & 240) >> 4)) {
                            break;
                        }
                    }
                    ThermoControlPhaseCode thermoControlPhaseCode4 = (ThermoControlPhaseCode) obj2;
                    if (thermoControlPhaseCode4 != null) {
                        unit6 = Unit.INSTANCE;
                        thermoControlPhaseCode2 = thermoControlPhaseCode4;
                    } else {
                        unit6 = null;
                        thermoControlPhaseCode2 = null;
                    }
                    if (!(unit6 == null || (intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 4, (ByteOrder) null, 4, (Object) null)) == null)) {
                        intValue$default2.intValue();
                        Iterator it3 = ThermoModeCode.getEntries().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj3 = null;
                                break;
                            }
                            obj3 = it3.next();
                            if (((ThermoModeCode) obj3).getCode() == (intValue$default2.intValue() & 7)) {
                                break;
                            }
                        }
                        ThermoModeCode thermoModeCode3 = (ThermoModeCode) obj3;
                        if (thermoModeCode3 != null) {
                            unit7 = Unit.INSTANCE;
                            thermoModeCode = thermoModeCode3;
                        } else {
                            unit7 = null;
                            thermoModeCode = null;
                        }
                        if (unit7 == null) {
                            return null;
                        }
                        Iterator it4 = ThermoModeCode.getEntries().iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                obj4 = null;
                                break;
                            }
                            obj4 = it4.next();
                            if (((ThermoModeCode) obj4).getCode() == ((intValue$default2.intValue() & 240) >> 4)) {
                                break;
                            }
                        }
                        ThermoModeCode thermoModeCode4 = (ThermoModeCode) obj4;
                        if (thermoModeCode4 != null) {
                            unit8 = Unit.INSTANCE;
                            thermoModeCode2 = thermoModeCode4;
                        } else {
                            unit8 = null;
                            thermoModeCode2 = null;
                        }
                        if (unit8 == null) {
                            return null;
                        }
                        Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 5, (ByteOrder) null, 4, (Object) null);
                        AirFlowStateCode[] values5 = AirFlowStateCode.values();
                        int length5 = values5.length;
                        while (true) {
                            if (i >= length5) {
                                airFlowStateCode = null;
                                break;
                            }
                            airFlowStateCode = values5[i];
                            int code2 = airFlowStateCode.getCode();
                            if (intValue$default6 != null && code2 == intValue$default6.intValue()) {
                                break;
                            }
                            i++;
                        }
                        if (airFlowStateCode != null) {
                            unit9 = Unit.INSTANCE;
                            airFlowStateCode2 = airFlowStateCode;
                        } else {
                            unit9 = null;
                            airFlowStateCode2 = null;
                        }
                        if (unit9 == null) {
                            return null;
                        }
                        BleDataEntity bleDataEntity3 = bleDataEntity;
                        Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity3, 17, 6, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default8 = BleDataEntity.getIntValue$default(bleDataEntity3, 18, 7, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default9 = BleDataEntity.getIntValue$default(bleDataEntity3, 18, 9, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default10 = BleDataEntity.getIntValue$default(bleDataEntity3, 18, 11, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default11 = BleDataEntity.getIntValue$default(bleDataEntity3, 18, 13, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default12 = BleDataEntity.getIntValue$default(bleDataEntity3, 18, 15, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default13 = BleDataEntity.getIntValue$default(bleDataEntity3, 17, 17, (ByteOrder) null, 4, (Object) null);
                        Integer intValue$default14 = BleDataEntity.getIntValue$default(bleDataEntity3, 17, 18, (ByteOrder) null, 4, (Object) null);
                        Intrinsics.checkNotNull(coolHeatTypeCode2);
                        Intrinsics.checkNotNull(intValue$default4);
                        int intValue = intValue$default4.intValue();
                        Intrinsics.checkNotNull(tempBoostOption2);
                        Intrinsics.checkNotNull(tempWaveOption2);
                        Intrinsics.checkNotNull(tempSpecialOption2);
                        Intrinsics.checkNotNull(thermoControlPhaseCode);
                        Intrinsics.checkNotNull(thermoControlPhaseCode2);
                        Intrinsics.checkNotNull(thermoModeCode);
                        Intrinsics.checkNotNull(thermoModeCode2);
                        Intrinsics.checkNotNull(airFlowStateCode2);
                        Intrinsics.checkNotNull(intValue$default7);
                        int intValue2 = intValue$default7.intValue();
                        Intrinsics.checkNotNull(intValue$default8);
                        int intValue3 = intValue$default8.intValue();
                        Intrinsics.checkNotNull(intValue$default9);
                        int intValue4 = intValue$default9.intValue();
                        Intrinsics.checkNotNull(intValue$default10);
                        int intValue5 = intValue$default10.intValue();
                        Intrinsics.checkNotNull(intValue$default11);
                        int intValue6 = intValue$default11.intValue();
                        Intrinsics.checkNotNull(intValue$default12);
                        int intValue7 = intValue$default12.intValue();
                        Intrinsics.checkNotNull(intValue$default13);
                        int intValue8 = intValue$default13.intValue();
                        Intrinsics.checkNotNull(intValue$default14);
                        return new ThermoControlStatusEntity(coolHeatTypeCode2, intValue, tempBoostOption2, tempWaveOption2, tempSpecialOption2, thermoControlPhaseCode, thermoControlPhaseCode2, thermoModeCode, thermoModeCode2, airFlowStateCode2, intValue2, intValue3, intValue4, intValue5, intValue6, intValue7, intValue8, intValue$default14.intValue());
                    }
                }
            }
            return null;
        }
    }
}
