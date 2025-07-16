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
import jp.co.sony.reonpocket.modules.main.view.MainSmartCoolOutput;
import jp.co.sony.reonpocket.modules.main.view.MainSmartCoolViewInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J \u0010$\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\rH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/presenter/MainSmartCoolPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolViewInput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "createTemperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "aOn", "", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "temperature", "", "handleDeviceTemp", "handleSmart", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "handleThermoStatus", "isTagRegistered", "onCreate", "onDataReceived", "onDestroy", "onViewCreated", "onViewDestroyed", "readDeviceMode", "setSmartCoolMode", "", "setSmartCoolOff", "writeDeviceMode", "aEntity", "writeTemperature", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartCoolPresenter.kt */
public final class MainSmartCoolPresenter extends BasePresenter implements MainSmartCoolOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final MainSmartCoolViewInput aView;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private final TagInfoInteractorInput mTagInfoInteractor = new TagInfoInteractor();

    public MainSmartCoolPresenter(Context context, MainSmartCoolViewInput mainSmartCoolViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = mainSmartCoolViewInput;
    }

    public void onCreate() {
        super.onCreate();
        this.mBleInteractor.onCreate(this.aContext);
    }

    public void onViewCreated() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainSmartCoolPresenter$onViewCreated$1(this));
    }

    public void onViewDestroyed() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainSmartCoolPresenter$onViewDestroyed$1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    private final void handleThermoStatus(BleDataEntity bleDataEntity) {
        MainSmartCoolViewInput mainSmartCoolViewInput;
        ThermoControlStatusEntity object = ThermoControlStatusEntity.Companion.toObject(bleDataEntity);
        if (object != null && (mainSmartCoolViewInput = this.aView) != null) {
            mainSmartCoolViewInput.updateTecRate(((float) object.getTec1CurrentPower()) / ((float) object.getTec1MaxPower()));
        }
    }

    private final void handleDeviceTemp(BleDataEntity bleDataEntity) {
        MainSmartCoolViewInput mainSmartCoolViewInput;
        if (bleDataEntity.getData() != null) {
            SensorDataEntity object = SensorDataEntity.Companion.getObject(bleDataEntity);
            if ((object instanceof NotifyDeviceSensorDataEntity) && (mainSmartCoolViewInput = this.aView) != null) {
                mainSmartCoolViewInput.updateTecTemp(((NotifyDeviceSensorDataEntity) object).getTec1Temp());
            }
        }
    }

    private final void writeDeviceMode(DeviceModeEntity deviceModeEntity) {
        byte[] bArr = deviceModeEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, bArr, 2, (Object) null);
            return;
        }
        MainSmartCoolViewInput mainSmartCoolViewInput = this.aView;
        if (mainSmartCoolViewInput != null) {
            mainSmartCoolViewInput.onFail("bytes error");
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
        MainSmartCoolViewInput mainSmartCoolViewInput;
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
                if ((temperatureEntity != null ? temperatureEntity.getTempCoolHeatType() : null) != TemperatureCoolHeatTypeCode.COOL) {
                    DebugLogUtil.INSTANCE.d("not smart cool mode");
                    return;
                }
                DeviceModeEntity.Temperature temperatureEntity2 = object.getTemperatureEntity();
                if (!(temperatureEntity2 == null || (mainSmartCoolViewInput = this.aView) == null)) {
                    mainSmartCoolViewInput.updateViewVisibility(temperatureEntity2);
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
        int i;
        int i2;
        SmartModePreference smartModePreference;
        DeviceModeEntity.Temperature temperatureEntity = deviceModeEntity.getTemperatureEntity();
        if (temperatureEntity != null) {
            if (temperatureEntity.getCoolPreference() != SmartModePreference.OFF) {
                i = temperatureEntity.getTempCoolWrite();
            } else {
                i = temperatureEntity.getTempHeatWrite();
            }
            double d = ((double) i) / 100.0d;
            if (temperatureEntity.getCoolPreference() != SmartModePreference.OFF) {
                Integer targetTemp = temperatureEntity.getTargetTemp();
                if (targetTemp != null) {
                    i2 = targetTemp.intValue();
                } else {
                    return;
                }
            } else {
                Integer targetTemp2 = temperatureEntity.getTargetTemp();
                if (targetTemp2 != null) {
                    i2 = targetTemp2.intValue();
                } else {
                    return;
                }
            }
            double d2 = ((double) i2) / 100.0d;
            if (temperatureEntity.getCoolPreference() != SmartModePreference.OFF) {
                smartModePreference = temperatureEntity.getCoolPreference();
            } else {
                smartModePreference = temperatureEntity.getHeatPreference();
            }
            SmartModePreference smartModePreference2 = smartModePreference;
            MainSmartCoolViewInput mainSmartCoolViewInput = this.aView;
            if (mainSmartCoolViewInput != null) {
                mainSmartCoolViewInput.updateCurrentState(false, temperatureEntity);
            }
            MainSmartCoolViewInput mainSmartCoolViewInput2 = this.aView;
            if (mainSmartCoolViewInput2 != null) {
                mainSmartCoolViewInput2.updateTempSetting(smartModePreference2, d, d2);
            }
        }
    }

    private final DeviceModeEntity.Temperature createTemperatureEntity(boolean z, SmartModePreference smartModePreference, int i) {
        return new DeviceModeEntity.Temperature(z ? TemperatureOnOffCode.ON : TemperatureOnOffCode.OFF, TemperatureCoolHeatTypeCode.COOL, smartModePreference, SmartModePreference.OFF, i, DeviceModeEntityKt.SMART_MODE_OFF_TEMPERATURE, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD);
    }

    public void setSmartCoolMode(boolean z, SmartModePreference smartModePreference, double d) {
        Intrinsics.checkNotNullParameter(smartModePreference, "pref");
        writeTemperature(createTemperatureEntity(z, smartModePreference, (int) (d * ((double) 100))));
    }

    public void setSmartCoolOff() {
        writeTemperature(createTemperatureEntity(false, SmartModePreference.OFF, DeviceModeEntityKt.SMART_MODE_OFF_TEMPERATURE));
    }

    public void readDeviceMode() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, 2, (Object) null);
    }

    public boolean isTagRegistered() {
        return this.mTagInfoInteractor.isTagRegistered(this.aContext);
    }

    public void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        onDataReceived(bleDataEntity);
    }
}
