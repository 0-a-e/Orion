package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import jp.co.sony.reonpocket.constant.AutoModeStatus;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.PowerSupplyStatus;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.constant.TempOptionCode;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H&JS\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00112\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\t2%\b\u0002\u0010\"\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0003\u0018\u00010#H&J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\tH&J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000bH&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\rH&J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u000fH&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0011H&J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0011H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0011H&J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0014H&J\u0018\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0016H&J\u0018\u00109\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u001bH&J\u0018\u0010;\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0016H&¨\u0006="}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "Ljp/co/sony/reonpocket/data/interactor/BaseInteractorInput;", "deleteDeviceMacAddress", "", "aContext", "Landroid/content/Context;", "getAutoModeStatus", "Ljp/co/sony/reonpocket/constant/AutoModeStatus;", "getAutoStartEnable", "", "getBoostSetting", "Ljp/co/sony/reonpocket/constant/TempOptionCode;", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getCoolHeatType", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "getFirmRevision", "", "getMacAddress", "getMode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "getPagePosition", "", "getPeripheralName", "getReonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "getTemperatureStep", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "getVbusStatusCode", "Ljp/co/sony/reonpocket/constant/PowerSupplyStatus;", "save", "aDeviceModelName", "aBoardId", "aIsCreate", "aCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "aResult", "saveAutoStartEnable", "aEnable", "saveBoostSetting", "boostSetting", "saveCapability", "capabilityEntity", "saveCoolHeatType", "coolHeatType", "saveDeviceName", "deviceName", "saveFirmRevision", "firmRevision", "saveMacAddress", "macAddress", "saveMode", "mode", "savePagePosition", "aPosition", "saveTemperatureStep", "temperature", "saveVbusStatusCode", "aCode", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceInfoInteractorInput.kt */
public interface DeviceInfoInteractorInput extends BaseInteractorInput {
    void deleteDeviceMacAddress(Context context);

    AutoModeStatus getAutoModeStatus(Context context);

    boolean getAutoStartEnable(Context context);

    TempOptionCode getBoostSetting(Context context);

    CapabilityEntity getCapability(Context context);

    CoolHeatTypeCode getCoolHeatType(Context context);

    String getFirmRevision(Context context);

    String getMacAddress(Context context);

    DeviceModeActionCode getMode(Context context);

    int getPagePosition(Context context);

    String getPeripheralName(Context context);

    ReonProductType getReonProductType(Context context);

    TempStepCode getTemperatureStep(Context context);

    PowerSupplyStatus getVbusStatusCode(Context context);

    void save(Context context, String str, String str2, boolean z, Function1<? super Boolean, Unit> function1);

    void saveAutoStartEnable(Context context, boolean z);

    void saveBoostSetting(Context context, TempOptionCode tempOptionCode);

    void saveCapability(Context context, CapabilityEntity capabilityEntity);

    void saveCoolHeatType(Context context, CoolHeatTypeCode coolHeatTypeCode);

    void saveDeviceName(Context context, String str);

    void saveFirmRevision(Context context, String str);

    void saveMacAddress(Context context, String str);

    void saveMode(Context context, DeviceModeActionCode deviceModeActionCode);

    void savePagePosition(Context context, int i);

    void saveTemperatureStep(Context context, TempStepCode tempStepCode);

    void saveVbusStatusCode(Context context, int i);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceInfoInteractorInput.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void save$default(DeviceInfoInteractorInput deviceInfoInteractorInput, Context context, String str, String str2, boolean z, Function1 function1, int i, Object obj) {
            if (obj == null) {
                deviceInfoInteractorInput.save(context, str, (i & 4) != 0 ? null : str2, z, (i & 16) != 0 ? null : function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: save");
        }
    }
}
