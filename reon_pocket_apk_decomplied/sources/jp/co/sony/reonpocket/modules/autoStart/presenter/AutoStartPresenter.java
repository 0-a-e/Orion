package jp.co.sony.reonpocket.modules.autoStart.presenter;

import android.content.Context;
import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.AutoStartDeviceModeActionCode;
import jp.co.sony.reonpocket.constant.AutoStartOperationCode;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.NotifyAlertCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.data.entity.AutoStartEntity;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput;
import jp.co.sony.reonpocket.modules.autoStart.router.AutoStartRouter;
import jp.co.sony.reonpocket.modules.autoStart.view.AutoStartActivity;
import jp.co.sony.reonpocket.modules.autoStart.view.AutoStartViewInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.base.view.BaseActivityKt;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import jp.co.sony.reonpocket.util.NotificationUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/presenter/AutoStartPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartActivity$AutoStartViewOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartViewInput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractor;", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mRouter", "Ljp/co/sony/reonpocket/modules/autoStart/router/AutoStartRouter;", "getMRouter", "()Ljp/co/sony/reonpocket/modules/autoStart/router/AutoStartRouter;", "finish", "", "handleAlert", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "handleAutoStart", "onCreate", "onDataReceived", "onDestroy", "readAutoStart", "registerActionCallbackListener", "writeAutoStart", "aEntity", "Ljp/co/sony/reonpocket/data/entity/AutoStartEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AutoStartPresenter.kt */
public final class AutoStartPresenter extends BasePresenter implements AutoStartActivity.AutoStartViewOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final AutoStartViewInput aView;
    private BleInteractor mBleInteractor = new BleInteractor();
    private DeviceInfoInteractorInput mDeviceInfoInteractor = new DeviceInfoInteractor();
    private final AutoStartRouter mRouter;

    public AutoStartPresenter(Context context, AutoStartViewInput autoStartViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = autoStartViewInput;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.autoStart.view.AutoStartActivity");
        this.mRouter = new AutoStartRouter((AutoStartActivity) context);
    }

    public final AutoStartRouter getMRouter() {
        return this.mRouter;
    }

    public void onCreate() {
        this.mBleInteractor.onCreate(this.aContext);
        registerActionCallbackListener();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    private final void registerActionCallbackListener() {
        this.mBleInteractor.setMDataReceivedCallbackListener(new AutoStartPresenter$registerActionCallbackListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        AutoStartViewInput autoStartViewInput;
        Unit unit;
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            if (Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_AUTO_START)) {
                if (bleDataEntity.getAction() == BleActionCode.READ) {
                    handleAutoStart(bleDataEntity);
                    return;
                }
                AutoStartEntity object = AutoStartEntity.Companion.getObject(bleDataEntity);
                if (object != null) {
                    this.mDeviceInfoInteractor.saveAutoStartEnable(this.aContext, object.getOperationCode() == AutoStartOperationCode.CTRL_REGIST);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    this.mDeviceInfoInteractor.saveAutoStartEnable(this.aContext, false);
                }
                AutoStartViewInput autoStartViewInput2 = this.aView;
                if (autoStartViewInput2 != null) {
                    autoStartViewInput2.onSuccess();
                }
            } else if (Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_ALERT)) {
                handleAlert(bleDataEntity);
            }
        } else if (Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) GattProfileConstant.CHARACTERISTIC_AUTO_START) && (autoStartViewInput = this.aView) != null) {
            autoStartViewInput.onFail("setting failed");
        }
    }

    private final void handleAutoStart(BleDataEntity bleDataEntity) {
        AutoStartViewInput autoStartViewInput;
        AutoStartEntity object = AutoStartEntity.Companion.getObject(bleDataEntity);
        if (object != null && (autoStartViewInput = this.aView) != null) {
            autoStartViewInput.updateAutoStart(object);
        }
    }

    public final void handleAlert(BleDataEntity bleDataEntity) {
        Integer intValue$default;
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        if (bleDataEntity.getData() != null && (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null)) != null) {
            int intValue = intValue$default.intValue();
            if (intValue == NotifyAlertCode.CHARGING_LOW_BATTERY.getCode()) {
                AutoStartViewInput autoStartViewInput = this.aView;
                if (autoStartViewInput != null) {
                    autoStartViewInput.onFail(BaseActivityKt.ERROR_OPERATE_WHEN_NO_ENOUGH_BATTERY);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_LOW_TEMP.getCode()) {
                AutoStartViewInput autoStartViewInput2 = this.aView;
                if (autoStartViewInput2 != null) {
                    autoStartViewInput2.onFail(BaseActivityKt.ERROR_DEVICE_LOWTEMP);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_HIGH_TEMP.getCode()) {
                AutoStartViewInput autoStartViewInput3 = this.aView;
                if (autoStartViewInput3 != null) {
                    autoStartViewInput3.onFail(BaseActivityKt.ERROR_DEVICE_OVERHEAT);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_UNKNOWN.getCode()) {
                AutoStartViewInput autoStartViewInput4 = this.aView;
                if (autoStartViewInput4 != null) {
                    autoStartViewInput4.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE_UNKNOWN);
                }
            } else if (intValue == NotifyAlertCode.SHUTDOWN_BY_LOW_BATTERY.getCode()) {
                AutoStartViewInput autoStartViewInput5 = this.aView;
                if (autoStartViewInput5 != null) {
                    autoStartViewInput5.onFail(MainPresenterKt.BUNDLE_SHUTDOWN_BY_LOW_BATTERY);
                }
            } else if (intValue == NotifyAlertCode.STOP_BY_OVER_CURRENT.getCode()) {
                AutoStartViewInput autoStartViewInput6 = this.aView;
                if (autoStartViewInput6 != null) {
                    autoStartViewInput6.onFail(BaseActivityKt.ERROR_DEVICE_STOP);
                }
            } else if (intValue == NotifyAlertCode.INVALID_BATTERY_TEMP.getCode()) {
                AutoStartViewInput autoStartViewInput7 = this.aView;
                if (autoStartViewInput7 != null) {
                    autoStartViewInput7.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE);
                }
            } else if (intValue == NotifyAlertCode.STOP_BY_INVALID_FAN_RATE.getCode()) {
                AutoStartViewInput autoStartViewInput8 = this.aView;
                if (autoStartViewInput8 != null) {
                    autoStartViewInput8.onFail(BaseActivityKt.ERROR_DEVICE_FAN_INVALID);
                }
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_TEMP.getCode()) {
                AutoStartViewInput autoStartViewInput9 = this.aView;
                if (autoStartViewInput9 != null) {
                    autoStartViewInput9.onFail(BaseActivityKt.ERROR_DEVICE_LOWTEMP);
                }
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_FAN_TEMP.getCode()) {
                AutoStartViewInput autoStartViewInput10 = this.aView;
                if (autoStartViewInput10 != null) {
                    autoStartViewInput10.onFail(BaseActivityKt.ERROR_DEVICE_OVERHEAT);
                }
            } else if (intValue == NotifyAlertCode.HEAT_STOP_BY_INVALID_TEMP.getCode()) {
                AutoStartViewInput autoStartViewInput11 = this.aView;
                if (autoStartViewInput11 != null) {
                    autoStartViewInput11.onFail(BaseActivityKt.ERROR_TEMP);
                }
            } else if (intValue == NotifyAlertCode.VBUS_VOLTAGE_ABNORMALITY_DETECTED.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            } else if (intValue == NotifyAlertCode.USB_WATER_WET_DETECTION.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            } else if (intValue == NotifyAlertCode.USB_AROUND_WATER_WET_DETECTION.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            } else if (intValue == NotifyAlertCode.USB_AROUND_OVER_HEAT.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            }
        }
    }

    public void readAutoStart() {
        AutoStartEntity autoStartEntity;
        if (this.mDeviceInfoInteractor.getAutoStartEnable(this.aContext)) {
            autoStartEntity = new AutoStartEntity(AutoStartOperationCode.CTRL_REGIST, AutoStartDeviceModeActionCode.LAST_MODE, (Integer) null, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4092, (DefaultConstructorMarker) null);
        } else {
            autoStartEntity = new AutoStartEntity(AutoStartOperationCode.CTRL_CLEAR, (AutoStartDeviceModeActionCode) null, (Integer) null, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4094, (DefaultConstructorMarker) null);
        }
        AutoStartViewInput autoStartViewInput = this.aView;
        if (autoStartViewInput != null) {
            autoStartViewInput.updateAutoStart(autoStartEntity);
        }
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTO_START, (String) null, 2, (Object) null);
    }

    public void writeAutoStart(AutoStartEntity autoStartEntity) {
        Intrinsics.checkNotNullParameter(autoStartEntity, "aEntity");
        byte[] bArr = autoStartEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTO_START, (String) null, bArr, 2, (Object) null);
        }
    }

    public void finish() {
        this.mRouter.finish();
    }
}
