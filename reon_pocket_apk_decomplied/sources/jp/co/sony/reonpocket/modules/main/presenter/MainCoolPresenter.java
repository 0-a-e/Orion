package jp.co.sony.reonpocket.modules.main.presenter;

import android.content.Context;
import java.nio.ByteOrder;
import jp.co.sony.reonpocket.R;
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
import jp.co.sony.reonpocket.constant.PowerSupplyStatus;
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
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.main.view.MainCoolViewInput;
import jp.co.sony.reonpocket.modules.main.view.MainCoolViewOutput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\u0018\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010(\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Ljp/co/sony/reonpocket/modules/main/presenter/MainCoolPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/main/view/MainCoolViewOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/main/view/MainCoolViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/main/view/MainCoolViewInput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mCoolWaveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mTempSettingValue", "", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "handleBattery", "handleCool", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "onCreate", "onDataReceived", "onDestroy", "onViewCreated", "onViewDestroyed", "readDeviceMode", "setCoolAuto", "aIsAuto", "", "setCoolBoost", "setCoolOff", "setCoolWave", "aLevel", "aTempWaveOption", "updateCoolLevel", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "writeDeviceMode", "aEntity", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainCoolPresenter.kt */
public final class MainCoolPresenter extends BasePresenter implements MainCoolViewOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final MainCoolViewInput aView;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private TempWaveOption mCoolWaveOption = TempWaveOption.WAVE_OFF;
    private DeviceInfoInteractorInput mDeviceInfoInteractor = new DeviceInfoInteractor();
    private int mTempSettingValue = TempStepCode.STEP_1.getCode();
    private UserInfoInteractorInput mUserInfoInteractor = new UserInfoInteractor();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainCoolPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reonpocket.constant.PowerSupplyStatus[] r0 = jp.co.sony.reonpocket.constant.PowerSupplyStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.PowerSupplyStatus r1 = jp.co.sony.reonpocket.constant.PowerSupplyStatus.VBUS_ON     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.PowerSupplyStatus r1 = jp.co.sony.reonpocket.constant.PowerSupplyStatus.VBUS_OFF     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.presenter.MainCoolPresenter.WhenMappings.<clinit>():void");
        }
    }

    public MainCoolPresenter(Context context, MainCoolViewInput mainCoolViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = mainCoolViewInput;
    }

    public void onCreate() {
        super.onCreate();
        this.mBleInteractor.onCreate(this.aContext);
    }

    public void onViewCreated() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainCoolPresenter$onViewCreated$1(this));
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
        MainCoolViewInput mainCoolViewInput = this.aView;
        if (mainCoolViewInput != null) {
            mainCoolViewInput.onFail("bytes error");
        }
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        DeviceModeEntity object;
        MainCoolViewInput mainCoolViewInput;
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            if (Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_BATTERY)) {
                handleBattery(bleDataEntity);
            } else if (Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_DEVICE_MODE) && bleDataEntity.getAction() != BleActionCode.WRITE && (object = DeviceModeEntity.Companion.getObject(bleDataEntity)) != null) {
                TempStepCode temperature = object.getTemperature();
                if (temperature == null) {
                    temperature = TempStepCode.OFF;
                }
                if ((object.getCoolHeatType() == CoolHeatTypeCode.OFF_COOL || temperature == TempStepCode.OFF) && (mainCoolViewInput = this.aView) != null) {
                    mainCoolViewInput.updateOff();
                }
                if (object.getCoolHeatType() != CoolHeatTypeCode.COOL) {
                    DebugLogUtil.INSTANCE.d("not cool");
                } else {
                    handleCool(object);
                }
            }
        } else {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String name = bleDataEntity.getAction().name();
            int code = bleDataEntity.getResponseCode().getCode();
            debugLogUtil.e("ignore device mode data error. action: " + name + ", response: " + code);
        }
    }

    private final void handleCool(DeviceModeEntity deviceModeEntity) {
        MainCoolViewInput mainCoolViewInput;
        TempBoostOption boostOption;
        MainCoolViewInput mainCoolViewInput2;
        DeviceModeActionCode mode = deviceModeEntity.getMode();
        if (!(mode == null || (mainCoolViewInput2 = this.aView) == null)) {
            mainCoolViewInput2.updateActionMode(mode);
        }
        TempStepCode temperature = deviceModeEntity.getTemperature();
        if (!(temperature == null || (boostOption = deviceModeEntity.getBoostOption()) == null || boostOption != TempBoostOption.NONE)) {
            if (deviceModeEntity.getCoolHeatType() == CoolHeatTypeCode.OFF_COOL || temperature == TempStepCode.OFF) {
                MainCoolViewInput mainCoolViewInput3 = this.aView;
                if (mainCoolViewInput3 != null) {
                    mainCoolViewInput3.updateOff();
                }
            } else {
                MainCoolViewInput mainCoolViewInput4 = this.aView;
                if (mainCoolViewInput4 != null) {
                    mainCoolViewInput4.updateTemp(temperature);
                }
            }
        }
        TempBoostOption boostOption2 = deviceModeEntity.getBoostOption();
        if (!(boostOption2 == null || (mainCoolViewInput = this.aView) == null)) {
            mainCoolViewInput.updateBoost(boostOption2);
        }
        TempWaveOption waveOption = deviceModeEntity.getWaveOption();
        if (waveOption != null) {
            MainCoolViewInput mainCoolViewInput5 = this.aView;
            if (mainCoolViewInput5 != null) {
                mainCoolViewInput5.updateCoolWave(waveOption);
            }
            Boolean isShownWavePopup = this.mUserInfoInteractor.getIsShownWavePopup(this.aContext);
            if (isShownWavePopup != null) {
                boolean booleanValue = isShownWavePopup.booleanValue();
                if (waveOption == TempWaveOption.WAVE_ON && booleanValue) {
                    MainCoolViewInput mainCoolViewInput6 = this.aView;
                    if (mainCoolViewInput6 != null) {
                        mainCoolViewInput6.showWaveGuide();
                    }
                    this.mUserInfoInteractor.saveIsNeedWavePopup(this.aContext, false);
                }
            }
        }
        MainCoolViewInput mainCoolViewInput7 = this.aView;
        if (mainCoolViewInput7 != null) {
            mainCoolViewInput7.updateCoolTimer(deviceModeEntity.getCurrentModeRemainTime());
        }
    }

    public void updateCoolLevel(TempStepCode tempStepCode) {
        Intrinsics.checkNotNullParameter(tempStepCode, "aLevel");
        this.mTempSettingValue = tempStepCode.getCode();
        DeviceModeEntity deviceModeEntity = r1;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.COOL, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode, TempBoostOption.NONE, this.mCoolWaveOption, (Integer) null, 0, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null);
        writeDeviceMode(deviceModeEntity);
    }

    public void setCoolOff() {
        this.mCoolWaveOption = TempWaveOption.WAVE_OFF;
        writeDeviceMode(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.OFF_COOL, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.OFF, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, (Integer) null, 0, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
    }

    public void setCoolWave(int i, TempWaveOption tempWaveOption) {
        Unit unit;
        TempStepCode tempStepCode;
        TempBoostOption tempBoostOption;
        TempStepCode tempStepCode2;
        TempWaveOption tempWaveOption2 = tempWaveOption;
        Intrinsics.checkNotNullParameter(tempWaveOption2, "aTempWaveOption");
        TempBoostOption tempBoostOption2 = TempBoostOption.NONE;
        this.mCoolWaveOption = tempWaveOption2;
        TempStepCode[] values = TempStepCode.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            unit = null;
            if (i2 >= length) {
                tempStepCode = null;
                break;
            }
            tempStepCode = values[i2];
            if (tempStepCode.ordinal() == i) {
                break;
            }
            i2++;
        }
        if (tempStepCode != null) {
            unit = Unit.INSTANCE;
        } else {
            tempStepCode = null;
        }
        if (unit == null) {
            tempStepCode = TempStepCode.STEP_3;
        }
        if (tempStepCode != null) {
            boolean isSupportCoolStep4 = getCapability().getCapability3().isSupportCoolStep4();
            boolean isSupportCoolStep5 = getCapability().getCapability3().isSupportCoolStep5();
            if (tempStepCode != TempStepCode.STEP_4 || isSupportCoolStep4 || isSupportCoolStep5) {
                tempBoostOption = tempBoostOption2;
                tempStepCode2 = tempStepCode;
            } else {
                TempBoostOption tempBoostOption3 = TempBoostOption.BOOST;
                tempStepCode2 = TempStepCode.STEP_3;
                tempBoostOption = tempBoostOption3;
            }
            writeDeviceMode(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.COOL, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode2, tempBoostOption, this.mCoolWaveOption, (Integer) null, (Integer) null, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
        }
    }

    public void setCoolAuto(boolean z) {
        DeviceModeActionCode deviceModeActionCode;
        if (z) {
            deviceModeActionCode = DeviceModeActionCode.AUTO;
        } else {
            deviceModeActionCode = DeviceModeActionCode.MANUAL;
        }
        DeviceModeEntity deviceModeEntity = r0;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(deviceModeActionCode, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.COOL, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, TempStepCode.STEP_1, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, 0, 0, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null);
        writeDeviceMode(deviceModeEntity);
    }

    public void setCoolBoost() {
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
            writeDeviceMode(new DeviceModeEntity(DeviceModeActionCode.MANUAL, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, CoolHeatTypeCode.COOL, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, tempStepCode2, TempBoostOption.BOOST, this.mCoolWaveOption, (Integer) null, (Integer) null, 0, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, (MyModeOperationCode) null, (Integer) null, (MyModeTypeCode) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, -32292, 63, (DefaultConstructorMarker) null));
        }
    }

    public CapabilityEntity getCapability() {
        return this.mDeviceInfoInteractor.getCapability(this.aContext);
    }

    private final void handleBattery(BleDataEntity bleDataEntity) {
        Integer intValue$default;
        PowerSupplyStatus powerSupplyStatus;
        String str;
        String str2;
        if (bleDataEntity.getAction() != BleActionCode.NOTIFY || bleDataEntity.getData() != null) {
            boolean isSupportCoolStep4Plus = this.mDeviceInfoInteractor.getCapability(this.aContext).getCapability3().isSupportCoolStep4Plus();
            boolean isSupportCoolStep5Plus = this.mDeviceInfoInteractor.getCapability(this.aContext).getCapability3().isSupportCoolStep5Plus();
            if ((isSupportCoolStep4Plus || isSupportCoolStep5Plus || (bleDataEntity.getAction() == BleActionCode.READ && bleDataEntity.getAction() == BleActionCode.NOTIFY)) && (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 2, (ByteOrder) null, 4, (Object) null)) != null) {
                int intValue = intValue$default.intValue();
                PowerSupplyStatus[] values = PowerSupplyStatus.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        powerSupplyStatus = null;
                        break;
                    }
                    powerSupplyStatus = values[i];
                    if (powerSupplyStatus.getCode() == intValue) {
                        break;
                    }
                    i++;
                }
                if (powerSupplyStatus != null) {
                    if (isSupportCoolStep4Plus) {
                        int i2 = WhenMappings.$EnumSwitchMapping$0[powerSupplyStatus.ordinal()];
                        if (i2 == 1) {
                            str2 = this.aContext.getString(R.string.mainview_content_level_4_plus_indicator);
                        } else if (i2 == 2) {
                            str2 = this.aContext.getString(R.string.mainview_content_level_4_indicator);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        Intrinsics.checkNotNull(str2);
                        MainCoolViewInput mainCoolViewInput = this.aView;
                        if (mainCoolViewInput != null) {
                            mainCoolViewInput.changeLevel4Text(str2);
                        }
                    }
                    if (isSupportCoolStep5Plus) {
                        int i3 = WhenMappings.$EnumSwitchMapping$0[powerSupplyStatus.ordinal()];
                        if (i3 == 1) {
                            str = this.aContext.getString(R.string.mainview_content_level_5_plus_indicator);
                        } else if (i3 == 2) {
                            str = this.aContext.getString(R.string.mainview_content_level_5_indicator);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        Intrinsics.checkNotNull(str);
                        MainCoolViewInput mainCoolViewInput2 = this.aView;
                        if (mainCoolViewInput2 != null) {
                            mainCoolViewInput2.changeLevel5Text(str);
                        }
                    }
                }
            }
        }
    }

    public void readDeviceMode() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, 2, (Object) null);
    }

    public void applyBleDataEntity(BleDataEntity bleDataEntity) {
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        onDataReceived(bleDataEntity);
    }
}
