package jp.co.sony.reonpocket.data.entity;

import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode;
import jp.co.sony.reonpocket.constant.QuickLaunchOperationCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0001BB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010.\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00105\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\"J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\b\u0010>\u001a\u0004\u0018\u00010?J\t\u0010@\u001a\u00020AHÖ\u0001R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010#\u001a\u0004\b'\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006C"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/QuickLaunchEntity;", "", "operationCode", "Ljp/co/sony/reonpocket/constant/QuickLaunchOperationCode;", "deviceActionCode", "Ljp/co/sony/reonpocket/constant/QuickLaunchDeviceModeActionCode;", "settingNo", "", "coolHeatType", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "tempCoolHeatType", "Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;", "tempValue", "coolPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "warmPreference", "tempCoolValue", "tempWarmValue", "boostOption", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "waveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "(Ljp/co/sony/reonpocket/constant/QuickLaunchOperationCode;Ljp/co/sony/reonpocket/constant/QuickLaunchDeviceModeActionCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;)V", "getBoostOption", "()Ljp/co/sony/reonpocket/constant/TempBoostOption;", "getCoolHeatType", "()Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "getCoolPreference", "()Ljp/co/sony/reonpocket/constant/SmartModePreference;", "getDeviceActionCode", "()Ljp/co/sony/reonpocket/constant/QuickLaunchDeviceModeActionCode;", "getOperationCode", "()Ljp/co/sony/reonpocket/constant/QuickLaunchOperationCode;", "getSettingNo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTempCoolHeatType", "()Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;", "getTempCoolValue", "getTempValue", "getTempWarmValue", "getWarmPreference", "getWaveOption", "()Ljp/co/sony/reonpocket/constant/TempWaveOption;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljp/co/sony/reonpocket/constant/QuickLaunchOperationCode;Ljp/co/sony/reonpocket/constant/QuickLaunchDeviceModeActionCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;Ljp/co/sony/reonpocket/constant/TemperatureCoolHeatTypeCode;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljp/co/sony/reonpocket/constant/SmartModePreference;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/co/sony/reonpocket/constant/TempBoostOption;Ljp/co/sony/reonpocket/constant/TempWaveOption;)Ljp/co/sony/reonpocket/data/entity/QuickLaunchEntity;", "equals", "", "other", "hashCode", "toByte", "", "toString", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: QuickLaunchEntity.kt */
public final class QuickLaunchEntity {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TempBoostOption boostOption;
    private final CoolHeatTypeCode coolHeatType;
    private final SmartModePreference coolPreference;
    private final QuickLaunchDeviceModeActionCode deviceActionCode;
    private final QuickLaunchOperationCode operationCode;
    private final Integer settingNo;
    private final TemperatureCoolHeatTypeCode tempCoolHeatType;
    private final Integer tempCoolValue;
    private final Integer tempValue;
    private final Integer tempWarmValue;
    private final SmartModePreference warmPreference;
    private final TempWaveOption waveOption;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: QuickLaunchEntity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|5|6|(2:7|8)|9|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        static {
            /*
                jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode[] r0 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r2 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.MY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r3 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.LAST_MODE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r3 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.constant.QuickLaunchOperationCode[] r0 = jp.co.sony.reonpocket.constant.QuickLaunchOperationCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.QuickLaunchOperationCode r3 = jp.co.sony.reonpocket.constant.QuickLaunchOperationCode.CTRL_REGIST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                jp.co.sony.reonpocket.constant.QuickLaunchOperationCode r1 = jp.co.sony.reonpocket.constant.QuickLaunchOperationCode.CTRL_CLEAR     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.QuickLaunchEntity.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ QuickLaunchEntity copy$default(QuickLaunchEntity quickLaunchEntity, QuickLaunchOperationCode quickLaunchOperationCode, QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode, Integer num, CoolHeatTypeCode coolHeatTypeCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, Integer num2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, Integer num3, Integer num4, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption, int i, Object obj) {
        QuickLaunchEntity quickLaunchEntity2 = quickLaunchEntity;
        int i2 = i;
        return quickLaunchEntity.copy((i2 & 1) != 0 ? quickLaunchEntity2.operationCode : quickLaunchOperationCode, (i2 & 2) != 0 ? quickLaunchEntity2.deviceActionCode : quickLaunchDeviceModeActionCode, (i2 & 4) != 0 ? quickLaunchEntity2.settingNo : num, (i2 & 8) != 0 ? quickLaunchEntity2.coolHeatType : coolHeatTypeCode, (i2 & 16) != 0 ? quickLaunchEntity2.tempCoolHeatType : temperatureCoolHeatTypeCode, (i2 & 32) != 0 ? quickLaunchEntity2.tempValue : num2, (i2 & 64) != 0 ? quickLaunchEntity2.coolPreference : smartModePreference, (i2 & 128) != 0 ? quickLaunchEntity2.warmPreference : smartModePreference2, (i2 & 256) != 0 ? quickLaunchEntity2.tempCoolValue : num3, (i2 & 512) != 0 ? quickLaunchEntity2.tempWarmValue : num4, (i2 & 1024) != 0 ? quickLaunchEntity2.boostOption : tempBoostOption, (i2 & 2048) != 0 ? quickLaunchEntity2.waveOption : tempWaveOption);
    }

    public final QuickLaunchOperationCode component1() {
        return this.operationCode;
    }

    public final Integer component10() {
        return this.tempWarmValue;
    }

    public final TempBoostOption component11() {
        return this.boostOption;
    }

    public final TempWaveOption component12() {
        return this.waveOption;
    }

    public final QuickLaunchDeviceModeActionCode component2() {
        return this.deviceActionCode;
    }

    public final Integer component3() {
        return this.settingNo;
    }

    public final CoolHeatTypeCode component4() {
        return this.coolHeatType;
    }

    public final TemperatureCoolHeatTypeCode component5() {
        return this.tempCoolHeatType;
    }

    public final Integer component6() {
        return this.tempValue;
    }

    public final SmartModePreference component7() {
        return this.coolPreference;
    }

    public final SmartModePreference component8() {
        return this.warmPreference;
    }

    public final Integer component9() {
        return this.tempCoolValue;
    }

    public final QuickLaunchEntity copy(QuickLaunchOperationCode quickLaunchOperationCode, QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode, Integer num, CoolHeatTypeCode coolHeatTypeCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, Integer num2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, Integer num3, Integer num4, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption) {
        Intrinsics.checkNotNullParameter(quickLaunchOperationCode, "operationCode");
        return new QuickLaunchEntity(quickLaunchOperationCode, quickLaunchDeviceModeActionCode, num, coolHeatTypeCode, temperatureCoolHeatTypeCode, num2, smartModePreference, smartModePreference2, num3, num4, tempBoostOption, tempWaveOption);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickLaunchEntity)) {
            return false;
        }
        QuickLaunchEntity quickLaunchEntity = (QuickLaunchEntity) obj;
        return this.operationCode == quickLaunchEntity.operationCode && this.deviceActionCode == quickLaunchEntity.deviceActionCode && Intrinsics.areEqual((Object) this.settingNo, (Object) quickLaunchEntity.settingNo) && this.coolHeatType == quickLaunchEntity.coolHeatType && this.tempCoolHeatType == quickLaunchEntity.tempCoolHeatType && Intrinsics.areEqual((Object) this.tempValue, (Object) quickLaunchEntity.tempValue) && this.coolPreference == quickLaunchEntity.coolPreference && this.warmPreference == quickLaunchEntity.warmPreference && Intrinsics.areEqual((Object) this.tempCoolValue, (Object) quickLaunchEntity.tempCoolValue) && Intrinsics.areEqual((Object) this.tempWarmValue, (Object) quickLaunchEntity.tempWarmValue) && this.boostOption == quickLaunchEntity.boostOption && this.waveOption == quickLaunchEntity.waveOption;
    }

    public int hashCode() {
        int hashCode = this.operationCode.hashCode() * 31;
        QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode = this.deviceActionCode;
        int i = 0;
        int hashCode2 = (hashCode + (quickLaunchDeviceModeActionCode == null ? 0 : quickLaunchDeviceModeActionCode.hashCode())) * 31;
        Integer num = this.settingNo;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        CoolHeatTypeCode coolHeatTypeCode = this.coolHeatType;
        int hashCode4 = (hashCode3 + (coolHeatTypeCode == null ? 0 : coolHeatTypeCode.hashCode())) * 31;
        TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode = this.tempCoolHeatType;
        int hashCode5 = (hashCode4 + (temperatureCoolHeatTypeCode == null ? 0 : temperatureCoolHeatTypeCode.hashCode())) * 31;
        Integer num2 = this.tempValue;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        SmartModePreference smartModePreference = this.coolPreference;
        int hashCode7 = (hashCode6 + (smartModePreference == null ? 0 : smartModePreference.hashCode())) * 31;
        SmartModePreference smartModePreference2 = this.warmPreference;
        int hashCode8 = (hashCode7 + (smartModePreference2 == null ? 0 : smartModePreference2.hashCode())) * 31;
        Integer num3 = this.tempCoolValue;
        int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.tempWarmValue;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        TempBoostOption tempBoostOption = this.boostOption;
        int hashCode11 = (hashCode10 + (tempBoostOption == null ? 0 : tempBoostOption.hashCode())) * 31;
        TempWaveOption tempWaveOption = this.waveOption;
        if (tempWaveOption != null) {
            i = tempWaveOption.hashCode();
        }
        return hashCode11 + i;
    }

    public String toString() {
        QuickLaunchOperationCode quickLaunchOperationCode = this.operationCode;
        QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode = this.deviceActionCode;
        Integer num = this.settingNo;
        CoolHeatTypeCode coolHeatTypeCode = this.coolHeatType;
        TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode = this.tempCoolHeatType;
        Integer num2 = this.tempValue;
        SmartModePreference smartModePreference = this.coolPreference;
        SmartModePreference smartModePreference2 = this.warmPreference;
        Integer num3 = this.tempCoolValue;
        Integer num4 = this.tempWarmValue;
        TempBoostOption tempBoostOption = this.boostOption;
        TempWaveOption tempWaveOption = this.waveOption;
        return "QuickLaunchEntity(operationCode=" + quickLaunchOperationCode + ", deviceActionCode=" + quickLaunchDeviceModeActionCode + ", settingNo=" + num + ", coolHeatType=" + coolHeatTypeCode + ", tempCoolHeatType=" + temperatureCoolHeatTypeCode + ", tempValue=" + num2 + ", coolPreference=" + smartModePreference + ", warmPreference=" + smartModePreference2 + ", tempCoolValue=" + num3 + ", tempWarmValue=" + num4 + ", boostOption=" + tempBoostOption + ", waveOption=" + tempWaveOption + ")";
    }

    public QuickLaunchEntity(QuickLaunchOperationCode quickLaunchOperationCode, QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode, Integer num, CoolHeatTypeCode coolHeatTypeCode, TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode, Integer num2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, Integer num3, Integer num4, TempBoostOption tempBoostOption, TempWaveOption tempWaveOption) {
        Intrinsics.checkNotNullParameter(quickLaunchOperationCode, "operationCode");
        this.operationCode = quickLaunchOperationCode;
        this.deviceActionCode = quickLaunchDeviceModeActionCode;
        this.settingNo = num;
        this.coolHeatType = coolHeatTypeCode;
        this.tempCoolHeatType = temperatureCoolHeatTypeCode;
        this.tempValue = num2;
        this.coolPreference = smartModePreference;
        this.warmPreference = smartModePreference2;
        this.tempCoolValue = num3;
        this.tempWarmValue = num4;
        this.boostOption = tempBoostOption;
        this.waveOption = tempWaveOption;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QuickLaunchEntity(jp.co.sony.reonpocket.constant.QuickLaunchOperationCode r13, jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r14, java.lang.Integer r15, jp.co.sony.reonpocket.constant.CoolHeatTypeCode r16, jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r17, java.lang.Integer r18, jp.co.sony.reonpocket.constant.SmartModePreference r19, jp.co.sony.reonpocket.constant.SmartModePreference r20, java.lang.Integer r21, java.lang.Integer r22, jp.co.sony.reonpocket.constant.TempBoostOption r23, jp.co.sony.reonpocket.constant.TempWaveOption r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r12 = this;
            r0 = r25
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r2 = r24
        L_0x0058:
            r14 = r12
            r15 = r13
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.QuickLaunchEntity.<init>(jp.co.sony.reonpocket.constant.QuickLaunchOperationCode, jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode, java.lang.Integer, jp.co.sony.reonpocket.constant.CoolHeatTypeCode, jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode, java.lang.Integer, jp.co.sony.reonpocket.constant.SmartModePreference, jp.co.sony.reonpocket.constant.SmartModePreference, java.lang.Integer, java.lang.Integer, jp.co.sony.reonpocket.constant.TempBoostOption, jp.co.sony.reonpocket.constant.TempWaveOption, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final QuickLaunchOperationCode getOperationCode() {
        return this.operationCode;
    }

    public final QuickLaunchDeviceModeActionCode getDeviceActionCode() {
        return this.deviceActionCode;
    }

    public final Integer getSettingNo() {
        return this.settingNo;
    }

    public final CoolHeatTypeCode getCoolHeatType() {
        return this.coolHeatType;
    }

    public final TemperatureCoolHeatTypeCode getTempCoolHeatType() {
        return this.tempCoolHeatType;
    }

    public final Integer getTempValue() {
        return this.tempValue;
    }

    public final SmartModePreference getCoolPreference() {
        return this.coolPreference;
    }

    public final SmartModePreference getWarmPreference() {
        return this.warmPreference;
    }

    public final Integer getTempCoolValue() {
        return this.tempCoolValue;
    }

    public final Integer getTempWarmValue() {
        return this.tempWarmValue;
    }

    public final TempBoostOption getBoostOption() {
        return this.boostOption;
    }

    public final TempWaveOption getWaveOption() {
        return this.waveOption;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/data/entity/QuickLaunchEntity$Companion;", "", "()V", "getObject", "Ljp/co/sony/reonpocket/data/entity/QuickLaunchEntity;", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: QuickLaunchEntity.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: QuickLaunchEntity.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode[] r0 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.MANUAL     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.AUTO     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.MY     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.LAST_MODE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode r1 = jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.entity.QuickLaunchEntity.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final QuickLaunchEntity getObject(BleDataEntity bleDataEntity) {
            QuickLaunchOperationCode quickLaunchOperationCode;
            QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode;
            int i;
            CoolHeatTypeCode coolHeatTypeCode;
            TempBoostOption tempBoostOption;
            TempWaveOption tempWaveOption;
            TempWaveOption tempWaveOption2;
            Unit unit;
            TempBoostOption tempBoostOption2;
            Unit unit2;
            CoolHeatTypeCode coolHeatTypeCode2;
            TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode;
            SmartModePreference smartModePreference;
            SmartModePreference smartModePreference2;
            TemperatureCoolHeatTypeCode temperatureCoolHeatTypeCode2;
            QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode2;
            QuickLaunchOperationCode quickLaunchOperationCode2;
            Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
            int i2 = 0;
            SmartModePreference smartModePreference3 = null;
            if (intValue$default != null) {
                intValue$default.intValue();
                QuickLaunchOperationCode[] values = QuickLaunchOperationCode.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        quickLaunchOperationCode2 = null;
                        break;
                    }
                    quickLaunchOperationCode2 = values[i3];
                    int code = quickLaunchOperationCode2.getCode();
                    if (intValue$default != null && code == intValue$default.intValue()) {
                        break;
                    }
                    i3++;
                }
                quickLaunchOperationCode = quickLaunchOperationCode2;
            } else {
                quickLaunchOperationCode = null;
            }
            Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
            if (intValue$default2 != null) {
                intValue$default2.intValue();
                QuickLaunchDeviceModeActionCode[] values2 = QuickLaunchDeviceModeActionCode.values();
                int length2 = values2.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        quickLaunchDeviceModeActionCode2 = null;
                        break;
                    }
                    quickLaunchDeviceModeActionCode2 = values2[i4];
                    int code2 = quickLaunchDeviceModeActionCode2.getCode();
                    if (intValue$default2 != null && code2 == intValue$default2.intValue()) {
                        break;
                    }
                    i4++;
                }
                quickLaunchDeviceModeActionCode = quickLaunchDeviceModeActionCode2;
            } else {
                quickLaunchDeviceModeActionCode = null;
            }
            if (quickLaunchDeviceModeActionCode == null) {
                return null;
            }
            if (quickLaunchDeviceModeActionCode == null) {
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$0[quickLaunchDeviceModeActionCode.ordinal()];
            }
            if (i == 1 || i == 2) {
                Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 2, (ByteOrder) null, 4, (Object) null);
                if (intValue$default3 != null) {
                    intValue$default3.intValue();
                    CoolHeatTypeCode[] values3 = CoolHeatTypeCode.values();
                    int length3 = values3.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length3) {
                            coolHeatTypeCode2 = null;
                            break;
                        }
                        coolHeatTypeCode2 = values3[i5];
                        int code3 = coolHeatTypeCode2.getCode();
                        if (intValue$default3 != null && code3 == intValue$default3.intValue()) {
                            break;
                        }
                        i5++;
                    }
                    coolHeatTypeCode = coolHeatTypeCode2;
                } else {
                    coolHeatTypeCode = null;
                }
                BleDataEntity bleDataEntity2 = bleDataEntity;
                Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity2, 17, 3, (ByteOrder) null, 4, (Object) null);
                Integer intValue$default5 = BleDataEntity.getIntValue$default(bleDataEntity2, 17, 4, (ByteOrder) null, 4, (Object) null);
                if (intValue$default5 == null) {
                    return null;
                }
                intValue$default5.intValue();
                if (bleDataEntity.getData() != null) {
                    TempBoostOption[] values4 = TempBoostOption.values();
                    int length4 = values4.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length4) {
                            tempBoostOption2 = null;
                            break;
                        }
                        tempBoostOption2 = values4[i6];
                        if (tempBoostOption2.getCode() == (intValue$default5.intValue() & 3)) {
                            break;
                        }
                        i6++;
                    }
                    if (tempBoostOption2 != null) {
                        unit2 = Unit.INSTANCE;
                    } else {
                        unit2 = null;
                        tempBoostOption2 = null;
                    }
                    if (unit2 == null) {
                        return null;
                    }
                    tempBoostOption = tempBoostOption2;
                } else {
                    tempBoostOption = null;
                }
                if (bleDataEntity.getData() != null) {
                    TempWaveOption[] values5 = TempWaveOption.values();
                    int length5 = values5.length;
                    while (true) {
                        if (i2 >= length5) {
                            tempWaveOption2 = null;
                            break;
                        }
                        tempWaveOption2 = values5[i2];
                        if (tempWaveOption2.getCode() == ((intValue$default5.intValue() & 4) >> 2)) {
                            break;
                        }
                        i2++;
                    }
                    if (tempWaveOption2 != null) {
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                        tempWaveOption2 = null;
                    }
                    if (unit == null) {
                        return null;
                    }
                    tempWaveOption = tempWaveOption2;
                } else {
                    tempWaveOption = null;
                }
                Intrinsics.checkNotNull(quickLaunchOperationCode);
                return new QuickLaunchEntity(quickLaunchOperationCode, quickLaunchDeviceModeActionCode, (Integer) null, coolHeatTypeCode, (TemperatureCoolHeatTypeCode) null, intValue$default4, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, tempBoostOption, tempWaveOption, 980, (DefaultConstructorMarker) null);
            } else if (i == 3) {
                Intrinsics.checkNotNull(quickLaunchOperationCode);
                return new QuickLaunchEntity(quickLaunchOperationCode, quickLaunchDeviceModeActionCode, 1, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4088, (DefaultConstructorMarker) null);
            } else if (i == 4) {
                Intrinsics.checkNotNull(quickLaunchOperationCode);
                return new QuickLaunchEntity(quickLaunchOperationCode, quickLaunchDeviceModeActionCode, (Integer) null, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4092, (DefaultConstructorMarker) null);
            } else if (i != 5) {
                return null;
            } else {
                Integer intValue$default6 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 2, (ByteOrder) null, 4, (Object) null);
                if (intValue$default6 != null) {
                    intValue$default6.intValue();
                    TemperatureCoolHeatTypeCode[] values6 = TemperatureCoolHeatTypeCode.values();
                    int length6 = values6.length;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length6) {
                            temperatureCoolHeatTypeCode2 = null;
                            break;
                        }
                        temperatureCoolHeatTypeCode2 = values6[i7];
                        int code4 = temperatureCoolHeatTypeCode2.getCode();
                        if (intValue$default6 != null && code4 == intValue$default6.intValue()) {
                            break;
                        }
                        i7++;
                    }
                    temperatureCoolHeatTypeCode = temperatureCoolHeatTypeCode2;
                } else {
                    temperatureCoolHeatTypeCode = null;
                }
                Integer intValue$default7 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 3, (ByteOrder) null, 4, (Object) null);
                if (intValue$default7 != null) {
                    intValue$default7.intValue();
                    SmartModePreference[] values7 = SmartModePreference.values();
                    int length7 = values7.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length7) {
                            smartModePreference2 = null;
                            break;
                        }
                        smartModePreference2 = values7[i8];
                        int code5 = smartModePreference2.getCode();
                        if (intValue$default7 != null && code5 == intValue$default7.intValue()) {
                            break;
                        }
                        i8++;
                    }
                    smartModePreference = smartModePreference2;
                } else {
                    smartModePreference = null;
                }
                Integer intValue$default8 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 6, (ByteOrder) null, 4, (Object) null);
                if (intValue$default8 != null) {
                    intValue$default8.intValue();
                    SmartModePreference[] values8 = SmartModePreference.values();
                    int length8 = values8.length;
                    while (true) {
                        if (i2 >= length8) {
                            break;
                        }
                        SmartModePreference smartModePreference4 = values8[i2];
                        int code6 = smartModePreference4.getCode();
                        if (intValue$default8 != null && code6 == intValue$default8.intValue()) {
                            smartModePreference3 = smartModePreference4;
                            break;
                        }
                        i2++;
                    }
                }
                BleDataEntity bleDataEntity3 = bleDataEntity;
                Integer intValue$default9 = BleDataEntity.getIntValue$default(bleDataEntity3, 34, 4, (ByteOrder) null, 4, (Object) null);
                Integer intValue$default10 = BleDataEntity.getIntValue$default(bleDataEntity3, 34, 7, (ByteOrder) null, 4, (Object) null);
                Intrinsics.checkNotNull(quickLaunchOperationCode);
                return new QuickLaunchEntity(quickLaunchOperationCode, quickLaunchDeviceModeActionCode, (Integer) null, (CoolHeatTypeCode) null, temperatureCoolHeatTypeCode, (Integer) null, smartModePreference, smartModePreference3, intValue$default9, intValue$default10, (TempBoostOption) null, (TempWaveOption) null, 3116, (DefaultConstructorMarker) null);
            }
        }
    }

    public final byte[] toByte() {
        Integer num;
        Integer num2;
        int i = WhenMappings.$EnumSwitchMapping$1[this.operationCode.ordinal()];
        if (i == 1) {
            QuickLaunchDeviceModeActionCode quickLaunchDeviceModeActionCode = this.deviceActionCode;
            if (quickLaunchDeviceModeActionCode != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[quickLaunchDeviceModeActionCode.ordinal()];
                if (i2 == 1) {
                    return new byte[]{(byte) this.operationCode.getCode(), (byte) this.deviceActionCode.getCode(), 1};
                } else if (i2 == 2) {
                    return new byte[]{(byte) this.operationCode.getCode(), (byte) this.deviceActionCode.getCode()};
                } else if (i2 == 3) {
                    if (!(this.tempCoolHeatType == null || (num = this.tempCoolValue) == null)) {
                        num.intValue();
                        Integer num3 = this.tempWarmValue;
                        if (num3 != null) {
                            num3.intValue();
                            if (this.coolPreference == null || this.warmPreference == null) {
                                return null;
                            }
                            BleDataEntity.Companion companion = BleDataEntity.Companion;
                            int intValue = this.tempCoolValue.intValue();
                            ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                            Intrinsics.checkNotNullExpressionValue(byteOrder, "BIG_ENDIAN");
                            byte[] createWriteBytes = companion.createWriteBytes(intValue, 34, byteOrder);
                            BleDataEntity.Companion companion2 = BleDataEntity.Companion;
                            int intValue2 = this.tempWarmValue.intValue();
                            ByteOrder byteOrder2 = ByteOrder.BIG_ENDIAN;
                            Intrinsics.checkNotNullExpressionValue(byteOrder2, "BIG_ENDIAN");
                            byte[] createWriteBytes2 = companion2.createWriteBytes(intValue2, 34, byteOrder2);
                            return new byte[]{(byte) this.operationCode.getCode(), (byte) this.deviceActionCode.getCode(), (byte) this.tempCoolHeatType.getCode(), (byte) this.coolPreference.getCode(), createWriteBytes[0], createWriteBytes[1], (byte) this.warmPreference.getCode(), createWriteBytes2[0], createWriteBytes2[1]};
                        }
                    }
                    return null;
                } else if (this.coolHeatType == null || (num2 = this.tempValue) == null) {
                    return null;
                } else {
                    num2.intValue();
                    TempBoostOption tempBoostOption = this.boostOption;
                    Intrinsics.checkNotNull(tempBoostOption);
                    int code = tempBoostOption.getCode();
                    TempWaveOption tempWaveOption = this.waveOption;
                    Intrinsics.checkNotNull(tempWaveOption);
                    return new byte[]{(byte) this.operationCode.getCode(), (byte) this.deviceActionCode.getCode(), (byte) this.coolHeatType.getCode(), (byte) this.tempValue.intValue(), (byte) ((tempWaveOption.getCode() << 2) | code)};
                }
            } else {
                return new byte[]{0};
            }
        } else if (i == 2) {
            return new byte[]{0};
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
