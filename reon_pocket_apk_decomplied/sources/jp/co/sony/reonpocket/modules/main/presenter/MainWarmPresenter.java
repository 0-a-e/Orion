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
import jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.main.view.MainWarmViewInput;
import jp.co.sony.reonpocket.modules.main.view.MainWarmViewOutput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/presenter/MainWarmPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/main/view/MainWarmViewOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/main/view/MainWarmViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/main/view/MainWarmViewInput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mTempSettingValue", "", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "handleWarm", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "onCreate", "onDataReceived", "onDestroy", "onViewCreated", "onViewDestroyed", "setWarmAuto", "aIsAuto", "", "setWarmBoost", "setWarmOff", "updateWarmLevel", "aLevel", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "writeDeviceMode", "aEntity", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainWarmPresenter.kt */
public final class MainWarmPresenter extends BasePresenter implements MainWarmViewOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final MainWarmViewInput aView;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private final DeviceInfoInteractorInput mDeviceInfoInteractor = new DeviceInfoInteractor();
    private int mTempSettingValue = TempStepCode.STEP_1.getCode();

    public MainWarmPresenter(Context context, MainWarmViewInput mainWarmViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = mainWarmViewInput;
    }

    public void onCreate() {
        super.onCreate();
        this.mBleInteractor.onCreate(this.aContext);
    }

    public void onViewCreated() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainWarmPresenter$onViewCreated$1(this));
    }

    public void onViewDestroyed() {
        this.mBleInteractor.setDataReceivedCallbackListener((Function1<? super BleDataEntity, Unit>) null);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    private final void writeDeviceMode(DeviceModeEntity deviceModeEntity) {
        byte[] bArr = deviceModeEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, bArr, 2, (Object) null);
            return;
        }
        MainWarmViewInput mainWarmViewInput = this.aView;
        if (mainWarmViewInput != null) {
            mainWarmViewInput.onFail("bytes error");
        }
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        DeviceModeEntity object;
        MainWarmViewInput mainWarmViewInput;
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            if (!Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY) && Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_DEVICE_MODE) && bleDataEntity.getAction() != BleActionCode.WRITE && (object = DeviceModeEntity.Companion.getObject(bleDataEntity)) != null) {
                TempStepCode temperature = object.getTemperature();
                if (temperature == null) {
                    temperature = TempStepCode.OFF;
                }
                if ((object.getCoolHeatType() == CoolHeatTypeCode.OFF_HEAT || temperature == TempStepCode.OFF) && (mainWarmViewInput = this.aView) != null) {
                    mainWarmViewInput.updateOff();
                }
                if (object.getCoolHeatType() != CoolHeatTypeCode.HEAT) {
                    DebugLogUtil.INSTANCE.d("not warm");
                } else {
                    handleWarm(object);
                }
            }
        } else if (Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) GattProfileConstant.CHARACTERISTIC_DEVICE_MODE)) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String name = bleDataEntity.getAction().name();
            int code = bleDataEntity.getResponseCode().getCode();
            debugLogUtil.e("ignore device mode data error. action: " + name + ", response: " + code);
        }
    }

    private final void handleWarm(DeviceModeEntity deviceModeEntity) {
        MainWarmViewInput mainWarmViewInput;
        TempBoostOption boostOption;
        MainWarmViewInput mainWarmViewInput2;
        DeviceModeActionCode mode = deviceModeEntity.getMode();
        if (!(mode == null || (mainWarmViewInput2 = this.aView) == null)) {
            mainWarmViewInput2.updateActionMode(mode);
        }
        TempStepCode temperature = deviceModeEntity.getTemperature();
        if (!(temperature == null || (boostOption = deviceModeEntity.getBoostOption()) == null || boostOption != TempBoostOption.NONE)) {
            if (deviceModeEntity.getCoolHeatType() == CoolHeatTypeCode.OFF_HEAT || temperature == TempStepCode.OFF) {
                MainWarmViewInput mainWarmViewInput3 = this.aView;
                if (mainWarmViewInput3 != null) {
                    mainWarmViewInput3.updateOff();
                }
            } else {
                MainWarmViewInput mainWarmViewInput4 = this.aView;
                if (mainWarmViewInput4 != null) {
                    mainWarmViewInput4.updateTemp(temperature);
                }
            }
        }
        TempBoostOption boostOption2 = deviceModeEntity.getBoostOption();
        if (!(boostOption2 == null || (mainWarmViewInput = this.aView) == null)) {
            mainWarmViewInput.updateBoost(boostOption2);
        }
        MainWarmViewInput mainWarmViewInput5 = this.aView;
        if (mainWarmViewInput5 != null) {
            mainWarmViewInput5.updateWarmTimer(deviceModeEntity.getCurrentModeRemainTime());
        }
    }

    public void updateWarmLevel(TempStepCode tempStepCode) {
        Intrinsics.checkNotNullParameter(tempStepCode, "aLevel");
        this.mTempSettingValue = tempStepCode.getCode();
        DeviceModeEntity deviceModeEntity = r1;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, (Integer) null, 0, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null);
        writeDeviceMode(deviceModeEntity);
    }

    public void setWarmOff() {
        DeviceModeEntity deviceModeEntity = r0;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.OFF_HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.OFF, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, (Integer) null, 0, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null);
        writeDeviceMode(deviceModeEntity);
    }

    public void setWarmAuto(boolean z) {
        DeviceModeActionCode deviceModeActionCode;
        if (z) {
            deviceModeActionCode = DeviceModeActionCode.AUTO;
        } else {
            deviceModeActionCode = DeviceModeActionCode.MANUAL;
        }
        DeviceModeEntity deviceModeEntity = r0;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(deviceModeActionCode, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.STEP_1, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, 0, 0, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null);
        writeDeviceMode(deviceModeEntity);
    }

    public void setWarmBoost() {
        TempStepCode tempStepCode;
        TempStepCode[] values = TempStepCode.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                tempStepCode = null;
                break;
            }
            tempStepCode = values[i];
            if (tempStepCode.ordinal() == this.mTempSettingValue) {
                break;
            }
            i++;
        }
        TempStepCode tempStepCode2 = tempStepCode != null ? tempStepCode : null;
        if (tempStepCode2 != null) {
            writeDeviceMode(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.HEAT, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode2, TempBoostOption.BOOST, TempWaveOption.WAVE_OFF, (Integer) null, (Integer) null, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
        }
    }

    public CapabilityEntity getCapability() {
        return this.mDeviceInfoInteractor.getCapability(this.aContext);
    }

    public void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        onDataReceived(bleDataEntity);
    }
}
