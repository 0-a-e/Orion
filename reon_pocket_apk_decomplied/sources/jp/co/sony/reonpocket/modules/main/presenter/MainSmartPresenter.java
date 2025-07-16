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
import jp.co.sony.reonpocket.modules.main.view.MainSmartOutput;
import jp.co.sony.reonpocket.modules.main.view.MainSmartViewInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J@\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u000fH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\b\u0010(\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020\u000fH\u0016J@\u0010*\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J \u0010*\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\u0010\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020 H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/presenter/MainSmartPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/main/view/MainSmartViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/main/view/MainSmartViewInput;)V", "TAG", "", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "createTemperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "aOn", "", "coolPref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "warmPref", "coolTemp", "", "warmTemp", "coolTempSwitchThreshold", "warmTempSwitchThreshold", "handleDeviceMode", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "handleDeviceTemp", "handleThermoStatus", "isTagRegistered", "onCreate", "onDataReceived", "onDestroy", "onViewCreated", "onViewDestroyed", "readDeviceMode", "setSmartMode", "coolTemperature", "", "warmTemperature", "setSmartOff", "writeDeviceMode", "aEntity", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartPresenter.kt */
public final class MainSmartPresenter extends BasePresenter implements MainSmartOutput {
    public static final int $stable = 8;
    private final String TAG = "MainSmartPresenter";
    private final Context aContext;
    private final MainSmartViewInput aView;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private final TagInfoInteractorInput mTagInfoInteractor = new TagInfoInteractor();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainSmartPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode[] r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.COOL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.WEAKCOOL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.HEAT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r1 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.WEAKHEAT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.presenter.MainSmartPresenter.WhenMappings.<clinit>():void");
        }
    }

    public MainSmartPresenter(Context context, MainSmartViewInput mainSmartViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = mainSmartViewInput;
    }

    public void onCreate() {
        super.onCreate();
        this.mBleInteractor.onCreate(this.aContext);
    }

    public void onViewCreated() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainSmartPresenter$onViewCreated$1(this));
    }

    public void onViewDestroyed() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainSmartPresenter$onViewDestroyed$1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    private final void handleThermoStatus(BleDataEntity bleDataEntity) {
        MainSmartViewInput mainSmartViewInput;
        ThermoControlStatusEntity object = ThermoControlStatusEntity.Companion.toObject(bleDataEntity);
        if (object != null && (mainSmartViewInput = this.aView) != null) {
            mainSmartViewInput.updateSmartTecRate(((float) object.getTec1CurrentPower()) / ((float) object.getTec1MaxPower()));
        }
    }

    private final void handleDeviceTemp(BleDataEntity bleDataEntity) {
        MainSmartViewInput mainSmartViewInput;
        if (bleDataEntity.getData() != null) {
            SensorDataEntity object = SensorDataEntity.Companion.getObject(bleDataEntity);
            NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity = object instanceof NotifyDeviceSensorDataEntity ? (NotifyDeviceSensorDataEntity) object : null;
            if (notifyDeviceSensorDataEntity != null && (mainSmartViewInput = this.aView) != null) {
                mainSmartViewInput.updateSmartTecTemp(notifyDeviceSensorDataEntity.getTec1Temp());
            }
        }
    }

    private final void writeDeviceMode(DeviceModeEntity deviceModeEntity) {
        byte[] bArr = deviceModeEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, bArr, 2, (Object) null);
            return;
        }
        MainSmartViewInput mainSmartViewInput = this.aView;
        if (mainSmartViewInput != null) {
            mainSmartViewInput.onFail("bytes error");
        }
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        DeviceModeEntity object;
        if (!bleDataEntity.getResult()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String name = bleDataEntity.getAction().name();
            int code = bleDataEntity.getResponseCode().getCode();
            debugLogUtil.e("ignore device mode data error. action: " + name + ", response: " + code);
            return;
        }
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
                DebugLogUtil.INSTANCE.d("not TEMPERATURE mode");
                return;
            }
            DeviceModeEntity.Temperature temperatureEntity = object.getTemperatureEntity();
            if ((temperatureEntity != null ? temperatureEntity.getTempCoolHeatType() : null) != TemperatureCoolHeatTypeCode.COOL_HEAT_MIX) {
                DebugLogUtil.INSTANCE.d(this.TAG, "onDataReceived() not COOL_HEAT_MIX mode return");
            } else {
                handleDeviceMode(object);
            }
        }
    }

    private final void handleDeviceMode(DeviceModeEntity deviceModeEntity) {
        Integer targetTemp;
        DeviceModeEntity.Temperature temperatureEntity = deviceModeEntity.getTemperatureEntity();
        if (temperatureEntity != null && (targetTemp = temperatureEntity.getTargetTemp()) != null) {
            int intValue = targetTemp.intValue();
            Integer tempCoolSwitchThreshold = temperatureEntity.getTempCoolSwitchThreshold();
            if (tempCoolSwitchThreshold != null) {
                int intValue2 = tempCoolSwitchThreshold.intValue();
                Integer tempWarmSwitchThreshold = temperatureEntity.getTempWarmSwitchThreshold();
                if (tempWarmSwitchThreshold != null) {
                    double d = ((double) intValue2) / 2.0d;
                    double intValue3 = ((double) tempWarmSwitchThreshold.intValue()) / 2.0d;
                    MainSmartViewInput mainSmartViewInput = this.aView;
                    if (mainSmartViewInput != null) {
                        mainSmartViewInput.updateStates(temperatureEntity.getTempOffOnCode() == TemperatureOnOffCode.ON, temperatureEntity.getTempCurrentCoolHeatType(), d, intValue3, temperatureEntity.getCoolPreference(), temperatureEntity.getHeatPreference());
                    }
                    MainSmartViewInput mainSmartViewInput2 = this.aView;
                    if (mainSmartViewInput2 != null) {
                        mainSmartViewInput2.updateViewVisibility(temperatureEntity);
                    }
                    MainSmartViewInput mainSmartViewInput3 = this.aView;
                    if (mainSmartViewInput3 != null) {
                        mainSmartViewInput3.showCoolHeatState(temperatureEntity, false, false);
                    }
                    int i = WhenMappings.$EnumSwitchMapping$0[temperatureEntity.getTempCurrentCoolHeatType().ordinal()];
                    if (i == 1 || i == 2) {
                        if (temperatureEntity.getCoolPreference() != SmartModePreference.OFF) {
                            double d2 = ((double) intValue) / 100.0d;
                            MainSmartViewInput mainSmartViewInput4 = this.aView;
                            if (mainSmartViewInput4 != null) {
                                mainSmartViewInput4.updateTargetTemperatureView(true, temperatureEntity.getCoolPreference(), Double.valueOf(d2));
                            }
                        }
                    } else if ((i == 3 || i == 4) && temperatureEntity.getHeatPreference() != SmartModePreference.OFF) {
                        double d3 = ((double) intValue) / 100.0d;
                        MainSmartViewInput mainSmartViewInput5 = this.aView;
                        if (mainSmartViewInput5 != null) {
                            mainSmartViewInput5.updateTargetTemperatureView(false, temperatureEntity.getHeatPreference(), Double.valueOf(d3));
                        }
                    }
                }
            }
        }
    }

    private final DeviceModeEntity.Temperature createTemperatureEntity(boolean z, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, int i, int i2, int i3, int i4) {
        TemperatureOnOffCode temperatureOnOffCode;
        if (z) {
            temperatureOnOffCode = TemperatureOnOffCode.ON;
        } else {
            temperatureOnOffCode = TemperatureOnOffCode.OFF;
        }
        return new DeviceModeEntity.Temperature(temperatureOnOffCode, TemperatureCoolHeatTypeCode.COOL_HEAT_MIX, smartModePreference, smartModePreference2, i, i2, i3, i4);
    }

    public void setSmartMode(boolean z, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, double d, double d2, int i, int i2) {
        double d3 = d;
        double d4 = d2;
        Intrinsics.checkNotNullParameter(smartModePreference, "coolPref");
        Intrinsics.checkNotNullParameter(smartModePreference2, "warmPref");
        writeDeviceMode(new DeviceModeEntity(DeviceModeActionCode.TEMPERATURE, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, createTemperatureEntity(z, smartModePreference, smartModePreference2, ((int) d3) == -32768 ? -32768 : (int) (d3 * ((double) 100)), ((int) d4) == -32768 ? -32768 : (int) (((double) 100) * d4), i, i2), (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -68, 63, (DefaultConstructorMarker) null));
    }

    public void setSmartMode(boolean z, int i, int i2) {
        setSmartMode(z, SmartModePreference.OFF, SmartModePreference.OFF, -32768.0d, -32768.0d, i, i2);
    }

    public void setSmartOff() {
        setSmartMode(false, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD, DeviceModeEntityKt.SMART_MODE_INVALID_SWITCH_THRESHOLD);
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
