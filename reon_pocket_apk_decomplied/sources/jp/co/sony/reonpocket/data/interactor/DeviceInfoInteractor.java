package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import com.google.gson.Gson;
import jp.co.sony.reonpocket.connection.aws.AWSManager;
import jp.co.sony.reonpocket.connection.aws.DeviceInfoEntity;
import jp.co.sony.reonpocket.constant.AutoModeStatus;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.constant.PowerSupplyStatus;
import jp.co.sony.reonpocket.constant.ReonProductType;
import jp.co.sony.reonpocket.constant.TempOptionCode;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivityKt;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016JO\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\n2#\u0010#\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u0004\u0018\u00010$H\u0016J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\nH\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\fH\u0016J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u000eH\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0012H\u0016J\u0018\u00102\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0012H\u0016J\u0018\u00104\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0012H\u0016J\u0018\u00106\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0015H\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0017H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u001cH\u0016J\u0018\u0010<\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0017H\u0016¨\u0006>"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractor;", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "()V", "deleteDeviceMacAddress", "", "aContext", "Landroid/content/Context;", "getAutoModeStatus", "Ljp/co/sony/reonpocket/constant/AutoModeStatus;", "getAutoStartEnable", "", "getBoostSetting", "Ljp/co/sony/reonpocket/constant/TempOptionCode;", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getCoolHeatType", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "getFirmRevision", "", "getMacAddress", "getMode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "getPagePosition", "", "getPeripheralName", "getReonProductType", "Ljp/co/sony/reonpocket/constant/ReonProductType;", "getTemperatureStep", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "getVbusStatusCode", "Ljp/co/sony/reonpocket/constant/PowerSupplyStatus;", "save", "aDeviceModelName", "aBoardId", "aIsCreate", "aCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "aResult", "saveAutoStartEnable", "aEnable", "saveBoostSetting", "boostSetting", "saveCapability", "capabilityEntity", "saveCoolHeatType", "coolHeatType", "saveDeviceName", "deviceName", "saveFirmRevision", "firmRevision", "saveMacAddress", "macAddress", "saveMode", "mode", "savePagePosition", "aPosition", "saveTemperatureStep", "temperature", "saveVbusStatusCode", "aCode", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceInfoInteractor.kt */
public final class DeviceInfoInteractor implements DeviceInfoInteractorInput {
    public static final int $stable = 0;

    public int getPagePosition(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_PAGE_INDEX);
        if (intValue != null) {
            return intValue.intValue();
        }
        return -1;
    }

    public void savePagePosition(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_PAGE_INDEX, i);
    }

    public void saveDeviceName(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "deviceName");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_DEVICE_NAME, str);
    }

    public void saveMacAddress(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "macAddress");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_MAC_ADDRESS, str);
    }

    public void saveFirmRevision(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "firmRevision");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_FIRM_REVISION, str);
    }

    public void save(Context context, String str, String str2, boolean z, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aDeviceModelName");
        AWSManager.INSTANCE.registerDeviceInfo(context, new DeviceInfoEntity(str, str2), true, function1);
    }

    public void saveCapability(Context context, CapabilityEntity capabilityEntity) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(capabilityEntity, "capabilityEntity");
        SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
        String json = new Gson().toJson((Object) capabilityEntity);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        simpleStorageUtil.setStringValue(context, SimpleStorageUtil.REON_CAPABILITY, json);
    }

    public void saveCoolHeatType(Context context, CoolHeatTypeCode coolHeatTypeCode) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(coolHeatTypeCode, "coolHeatType");
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_COOL_HEAT, coolHeatTypeCode.getCode());
    }

    public void saveMode(Context context, DeviceModeActionCode deviceModeActionCode) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(deviceModeActionCode, PairingActivityKt.TRANSIT_TO_MAIN_MODE);
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_DEVICE_MODE, deviceModeActionCode.getCode());
    }

    public void saveTemperatureStep(Context context, TempStepCode tempStepCode) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(tempStepCode, PairingActivityKt.TRANSIT_TO_MAIN_TEMPERATURE);
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_TEMPERATURE, tempStepCode.getCode());
    }

    public void saveBoostSetting(Context context, TempOptionCode tempOptionCode) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(tempOptionCode, "boostSetting");
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_BOOST_SETTING, tempOptionCode.getCode());
    }

    public String getPeripheralName(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_DEVICE_NAME);
    }

    public String getMacAddress(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_MAC_ADDRESS);
    }

    public CapabilityEntity getCapability(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Object fromJson = new Gson().fromJson(SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_CAPABILITY), new DeviceInfoInteractor$getCapability$1().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (CapabilityEntity) fromJson;
    }

    public AutoModeStatus getAutoModeStatus(Context context) {
        AutoModeStatus autoModeStatus;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_AUTO_MODE);
        AutoModeStatus[] values = AutoModeStatus.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                autoModeStatus = null;
                break;
            }
            autoModeStatus = values[i];
            int code = autoModeStatus.getCode();
            if (intValue != null && code == intValue.intValue()) {
                break;
            }
            i++;
        }
        return autoModeStatus == null ? AutoModeStatus.OFF : autoModeStatus;
    }

    public CoolHeatTypeCode getCoolHeatType(Context context) {
        CoolHeatTypeCode coolHeatTypeCode;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_COOL_HEAT);
        if (intValue != null) {
            intValue.intValue();
            CoolHeatTypeCode[] values = CoolHeatTypeCode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    coolHeatTypeCode = null;
                    break;
                }
                coolHeatTypeCode = values[i];
                int code = coolHeatTypeCode.getCode();
                if (intValue != null && code == intValue.intValue()) {
                    break;
                }
                i++;
            }
            if (coolHeatTypeCode != null) {
                return coolHeatTypeCode;
            }
        }
        return null;
    }

    public TempStepCode getTemperatureStep(Context context) {
        TempStepCode tempStepCode;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_TEMPERATURE);
        if (intValue != null) {
            intValue.intValue();
            TempStepCode[] values = TempStepCode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    tempStepCode = null;
                    break;
                }
                tempStepCode = values[i];
                int code = tempStepCode.getCode();
                if (intValue != null && code == intValue.intValue()) {
                    break;
                }
                i++;
            }
            if (tempStepCode != null) {
                return tempStepCode;
            }
        }
        return null;
    }

    public DeviceModeActionCode getMode(Context context) {
        DeviceModeActionCode deviceModeActionCode;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_DEVICE_MODE);
        if (intValue != null) {
            intValue.intValue();
            DeviceModeActionCode[] values = DeviceModeActionCode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    deviceModeActionCode = null;
                    break;
                }
                deviceModeActionCode = values[i];
                int code = deviceModeActionCode.getCode();
                if (intValue != null && code == intValue.intValue()) {
                    break;
                }
                i++;
            }
            if (deviceModeActionCode != null) {
                return deviceModeActionCode;
            }
        }
        return null;
    }

    public TempOptionCode getBoostSetting(Context context) {
        TempOptionCode tempOptionCode;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_BOOST_SETTING);
        if (intValue != null) {
            intValue.intValue();
            TempOptionCode[] values = TempOptionCode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    tempOptionCode = null;
                    break;
                }
                tempOptionCode = values[i];
                int code = tempOptionCode.getCode();
                if (intValue != null && code == intValue.intValue()) {
                    break;
                }
                i++;
            }
            if (tempOptionCode != null) {
                return tempOptionCode;
            }
        }
        return null;
    }

    public String getFirmRevision(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getStringValue(context, SimpleStorageUtil.REON_FIRM_REVISION);
    }

    public void deleteDeviceMacAddress(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setStringValue(context, SimpleStorageUtil.REON_MAC_ADDRESS, "");
    }

    public boolean getAutoStartEnable(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return SimpleStorageUtil.INSTANCE.getBooleanValue(context, SimpleStorageUtil.REON_AUTO_START_ENABLE_FLAG, false);
    }

    public void saveAutoStartEnable(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setBooleanValue(context, SimpleStorageUtil.REON_AUTO_START_ENABLE_FLAG, z);
    }

    public PowerSupplyStatus getVbusStatusCode(Context context) {
        PowerSupplyStatus powerSupplyStatus;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_VBUS_STATUS_CODE);
        PowerSupplyStatus[] values = PowerSupplyStatus.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                powerSupplyStatus = null;
                break;
            }
            powerSupplyStatus = values[i];
            int code = powerSupplyStatus.getCode();
            if (intValue != null && code == intValue.intValue()) {
                break;
            }
            i++;
        }
        if (powerSupplyStatus != null) {
            return powerSupplyStatus;
        }
        return null;
    }

    public void saveVbusStatusCode(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_VBUS_STATUS_CODE, i);
    }

    public ReonProductType getReonProductType(Context context) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(context, "aContext");
        String peripheralName = getPeripheralName(context);
        if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_P1.getModel())) {
            return ReonProductType.PRO;
        }
        boolean z6 = true;
        if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1.getModel())) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1A.getModel());
        }
        if (z) {
            z2 = true;
        } else {
            z2 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1L.getModel());
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_2.getModel());
        }
        if (z3) {
            z4 = true;
        } else {
            z4 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_3.getModel());
        }
        if (z4) {
            z5 = true;
        } else {
            z5 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_4.getModel());
        }
        if (!z5) {
            z6 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_5.getModel());
        }
        if (z6) {
            return ReonProductType.ORIGINAL;
        }
        DebugLogUtil.INSTANCE.e("unknown type");
        return ReonProductType.ORIGINAL;
    }
}
