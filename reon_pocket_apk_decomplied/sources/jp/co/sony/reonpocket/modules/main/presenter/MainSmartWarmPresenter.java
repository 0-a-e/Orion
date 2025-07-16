package jp.co.sony.reonpocket.modules.main.presenter;

import android.content.Context;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.ContinuousOperationStatus;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceCoolingCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode;
import jp.co.sony.reonpocket.constant.FanStepCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.ModeCommonSettingOperation;
import jp.co.sony.reonpocket.constant.MyModeActionType;
import jp.co.sony.reonpocket.constant.MyModeOperationCode;
import jp.co.sony.reonpocket.constant.MyModeSpecialSubMode;
import jp.co.sony.reonpocket.constant.MyModeTypeCode;
import jp.co.sony.reonpocket.constant.MyTempStepCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.TemperatureOnOffCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntityKt;
import jp.co.sony.reonpocket.data.entity.NotifyDeviceSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.SensorDataEntity;
import jp.co.sony.reonpocket.data.entity.ThermoControlStatusEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.main.view.MainSmartWarmOutput;
import jp.co.sony.reonpocket.modules.main.view.MainSmartWarmViewInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J \u0010$\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001cH\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/presenter/MainSmartWarmPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/main/view/MainSmartWarmViewInput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "createTemperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "aOn", "", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "temperature", "", "getIsRegisterTag", "handleDeviceTemp", "handleSmart", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "handleThermoStatus", "onCreate", "onDataReceived", "onDestroy", "onViewCreated", "onViewDestroyed", "readDeviceMode", "setSmartWarmMode", "", "setSmartWarmOff", "writeDeviceMode", "aEntity", "writeTemperature", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartWarmPresenter.kt */
public final class MainSmartWarmPresenter extends BasePresenter implements MainSmartWarmOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final MainSmartWarmViewInput aView;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private final TagInfoInteractorInput mTagInfoInteractor = new TagInfoInteractor();

    public MainSmartWarmPresenter(Context context, MainSmartWarmViewInput mainSmartWarmViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = mainSmartWarmViewInput;
    }

    public void onCreate() {
        super.onCreate();
        this.mBleInteractor.onCreate(this.aContext);
    }

    public void onViewCreated() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainSmartWarmPresenter$onViewCreated$1(this));
    }

    public void onViewDestroyed() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainSmartWarmPresenter$onViewDestroyed$1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    private final void handleThermoStatus(BleDataEntity bleDataEntity) {
        MainSmartWarmViewInput mainSmartWarmViewInput;
        ThermoControlStatusEntity object = ThermoControlStatusEntity.Companion.toObject(bleDataEntity);
        if (object != null && (mainSmartWarmViewInput = this.aView) != null) {
            mainSmartWarmViewInput.updateTecRate(((float) object.getTec1CurrentPower()) / ((float) object.getTec1MaxPower()));
        }
    }

    private final void handleDeviceTemp(BleDataEntity bleDataEntity) {
        MainSmartWarmViewInput mainSmartWarmViewInput;
        if (bleDataEntity.getData() != null) {
            SensorDataEntity object = SensorDataEntity.Companion.getObject(bleDataEntity);
            if ((object instanceof NotifyDeviceSensorDataEntity) && (mainSmartWarmViewInput = this.aView) != null) {
                mainSmartWarmViewInput.updateTecTemp(((NotifyDeviceSensorDataEntity) object).getTec1Temp());
            }
        }
    }

    private final void writeDeviceMode(DeviceModeEntity deviceModeEntity) {
        byte[] bArr = deviceModeEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, bArr, 2, (Object) null);
            return;
        }
        MainSmartWarmViewInput mainSmartWarmViewInput = this.aView;
        if (mainSmartWarmViewInput != null) {
            mainSmartWarmViewInput.onFail("bytes error");
        }
    }

    private final void writeTemperature(DeviceModeEntity.Temperature temperature) {
        DeviceModeEntity deviceModeEntity = r0;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.TEMPERATURE, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, temperature, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -68, 63, (DefaultConstructorMarker) null);
        writeDeviceMode(deviceModeEntity);
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        DeviceModeEntity object;
        MainSmartWarmViewInput mainSmartWarmViewInput;
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            int hashCode = characteristicUuid.hashCode();
            if (hashCode != 1512231) {
                if (hashCode != 1512477) {
                    if (hashCode == 1512480 && characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_READ_THERMO_CONTROL_STATUS)) {
                        handleThermoStatus(bleDataEntity);
                    }
                } else if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY)) {
                    handleDeviceTemp(bleDataEntity);
                }
            } else if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_DEVICE_MODE) && bleDataEntity.getAction() != BleActionCode.WRITE && (object = DeviceModeEntity.Companion.getObject(bleDataEntity)) != null) {
                if (object.getMode() != DeviceModeActionCode.TEMPERATURE) {
                    DebugLogUtil.INSTANCE.d("not smart mode");
                    return;
                }
                DeviceModeEntity.Temperature temperatureEntity = object.getTemperatureEntity();
                if ((temperatureEntity != null ? temperatureEntity.getTempCoolHeatType() : null) != TemperatureCoolHeatTypeCode.HEAT) {
                    DebugLogUtil.INSTANCE.d("not smart warm mode");
                    return;
                }
                DeviceModeEntity.Temperature temperatureEntity2 = object.getTemperatureEntity();
                if (!(temperatureEntity2 == null || (mainSmartWarmViewInput = this.aView) == null)) {
                    mainSmartWarmViewInput.updateViewVisibility(temperatureEntity2);
                }
                handleSmart(object);
            }
        } else {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String name = bleDataEntity.getAction().name();
            int code = bleDataEntity.getResponseCode().getCode();
            debugLogUtil.e("ignore device mode data error. action: " + name + ", response: " + code);
        }
    }

    private final void handleSmart(DeviceModeEntity deviceModeEntity) {
        Integer targetTemp;
        int i;
        SmartModePreference smartModePreference;
        DeviceModeEntity.Temperature temperatureEntity = deviceModeEntity.getTemperatureEntity();
        if (temperatureEntity != null && (targetTemp = temperatureEntity.getTargetTemp()) != null) {
            int intValue = targetTemp.intValue();
            if (temperatureEntity.getHeatPreference() != SmartModePreference.OFF) {
                i = temperatureEntity.getTempHeatWrite();
            } else {
                i = temperatureEntity.getTempCoolWrite();
            }
            double d = ((double) i) / 100.0d;
            double d2 = ((double) intValue) / 100.0d;
            if (temperatureEntity.getHeatPreference() != SmartModePreference.OFF) {
                smartModePreference = temperatureEntity.getHeatPreference();
            } else {
                smartModePreference = temperatureEntity.getCoolPreference();
            }
            SmartModePreference smartModePreference2 = smartModePreference;
            MainSmartWarmViewInput mainSmartWarmViewInput = this.aView;
            if (mainSmartWarmViewInput != null) {
                mainSmartWarmViewInput.updateCurrentState(temperatureEntity.getTempCurrentCoolHeatType(), false, false);
            }
            MainSmartWarmViewInput mainSmartWarmViewInput2 = this.aView;
            if (mainSmartWarmViewInput2 != null) {
                mainSmartWarmViewInput2.updateTempSetting(smartModePreference2, d, d2);
            }
        }
    }

    private final DeviceModeEntity.Temperature createTemperatureEntity(boolean z, SmartModePreference smartModePreference, int i) {
        return new DeviceModeEntity.Temperature(z ? TemperatureOnOffCode.ON : TemperatureOnOffCode.OFF, TemperatureCoolHeatTypeCode.HEAT, SmartModePreference.OFF, smartModePreference, DeviceModeEntityKt.SMART_MODE_OFF_TEMPERATURE, i, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD);
    }

    public void setSmartWarmMode(boolean z, SmartModePreference smartModePreference, double d) {
        Intrinsics.checkNotNullParameter(smartModePreference, "pref");
        writeTemperature(createTemperatureEntity(z, smartModePreference, (int) (d * ((double) 100))));
    }

    public void setSmartWarmOff() {
        writeTemperature(createTemperatureEntity(false, SmartModePreference.OFF, DeviceModeEntityKt.SMART_MODE_OFF_TEMPERATURE));
    }

    public void readDeviceMode() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, 2, (Object) null);
    }

    public boolean getIsRegisterTag() {
        return this.mTagInfoInteractor.isTagRegistered(this.aContext);
    }

    public void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        onDataReceived(bleDataEntity);
    }
}
