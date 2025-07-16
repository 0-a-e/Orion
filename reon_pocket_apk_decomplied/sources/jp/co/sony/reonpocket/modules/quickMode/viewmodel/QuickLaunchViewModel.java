package jp.co.sony.reonpocket.modules.quickMode.viewmodel;

import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.nio.ByteOrder;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.NotifyAlertCode;
import jp.co.sony.reonpocket.constant.QuickLaunchDeviceModeActionCode;
import jp.co.sony.reonpocket.constant.QuickLaunchOperationCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.QuickLaunchEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.modules.base.view.BaseActivityKt;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import jp.co.sony.reonpocket.util.NotificationUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010 \u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\fH\u0002J\u000e\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u000eR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006("}, d2 = {"Ljp/co/sony/reonpocket/modules/quickMode/viewmodel/QuickLaunchViewModel;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "aContext", "Landroid/content/Context;", "aBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractor;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/data/interactor/BleInteractor;)V", "_onFail", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_onSuccessUpdateSetting", "", "_quickLaunchEnable", "", "onFail", "Lkotlinx/coroutines/flow/StateFlow;", "getOnFail", "()Lkotlinx/coroutines/flow/StateFlow;", "onSuccessUpdateSetting", "getOnSuccessUpdateSetting", "quickLaunchEnable", "getQuickLaunchEnable", "handleAlert", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "handleQuickLaunch", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onCreateView", "onDataReceived", "onDestroy", "onPause", "onResume", "onStart", "onStop", "registerActionCallbackListener", "updateSettings", "isQuickLaunchEnable", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: QuickLaunchViewModel.kt */
public final class QuickLaunchViewModel implements DefaultLifecycleObserver, BaseViewOutput {
    public static final int $stable = 8;
    private final MutableStateFlow<String> _onFail;
    private final MutableStateFlow<Unit> _onSuccessUpdateSetting;
    private final MutableStateFlow<Boolean> _quickLaunchEnable;
    private BleInteractor aBleInteractor;
    private final Context aContext;
    private final StateFlow<String> onFail;
    private final StateFlow<Unit> onSuccessUpdateSetting;
    private final StateFlow<Boolean> quickLaunchEnable;

    public void onCreate() {
    }

    public void onCreateView() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
    }

    public void onResume() {
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
    }

    public void onStart() {
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
    }

    public void onStop() {
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
    }

    public QuickLaunchViewModel(Context context, BleInteractor bleInteractor) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(bleInteractor, "aBleInteractor");
        this.aContext = context;
        this.aBleInteractor = bleInteractor;
        MutableStateFlow<Unit> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._onSuccessUpdateSetting = MutableStateFlow;
        this.onSuccessUpdateSetting = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._quickLaunchEnable = MutableStateFlow2;
        this.quickLaunchEnable = MutableStateFlow2;
        MutableStateFlow<String> MutableStateFlow3 = StateFlowKt.MutableStateFlow("");
        this._onFail = MutableStateFlow3;
        this.onFail = MutableStateFlow3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickLaunchViewModel(Context context, BleInteractor bleInteractor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new BleInteractor() : bleInteractor);
    }

    public final StateFlow<Unit> getOnSuccessUpdateSetting() {
        return this.onSuccessUpdateSetting;
    }

    public final StateFlow<Boolean> getQuickLaunchEnable() {
        return this.quickLaunchEnable;
    }

    public final StateFlow<String> getOnFail() {
        return this.onFail;
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
        this.aBleInteractor.onCreate(this.aContext);
        registerActionCallbackListener();
        BleInteractorInput.DefaultImpls.read$default(this.aBleInteractor, GattProfileConstant.CHARACTERISTIC_QUICK_LAUNCH, (String) null, 2, (Object) null);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
        this.aBleInteractor.onDestroy(this.aContext);
    }

    private final void registerActionCallbackListener() {
        this.aBleInteractor.setMDataReceivedCallbackListener(new QuickLaunchViewModel$registerActionCallbackListener$1(this));
    }

    public final void onDataReceived(BleDataEntity bleDataEntity) {
        String value;
        Unit value2;
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            if (Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_QUICK_LAUNCH)) {
                if (bleDataEntity.getAction() == BleActionCode.READ) {
                    handleQuickLaunch(bleDataEntity);
                    return;
                }
                MutableStateFlow<Unit> mutableStateFlow = this._onSuccessUpdateSetting;
                do {
                    value2 = mutableStateFlow.getValue();
                    Unit unit = value2;
                } while (!mutableStateFlow.compareAndSet(value2, Unit.INSTANCE));
            } else if (Intrinsics.areEqual((Object) characteristicUuid, (Object) GattProfileConstant.CHARACTERISTIC_ALERT)) {
                handleAlert(bleDataEntity);
            }
        } else if (Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) GattProfileConstant.CHARACTERISTIC_DEVICE_MODE)) {
            MutableStateFlow<String> mutableStateFlow2 = this._onFail;
            do {
                value = mutableStateFlow2.getValue();
                String str = value;
            } while (!mutableStateFlow2.compareAndSet(value, "setting failed"));
        }
    }

    public final void updateSettings(boolean z) {
        QuickLaunchEntity quickLaunchEntity;
        if (z) {
            quickLaunchEntity = new QuickLaunchEntity(QuickLaunchOperationCode.CTRL_REGIST, QuickLaunchDeviceModeActionCode.LAST_MODE, (Integer) null, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4092, (DefaultConstructorMarker) null);
        } else {
            quickLaunchEntity = new QuickLaunchEntity(QuickLaunchOperationCode.CTRL_CLEAR, (QuickLaunchDeviceModeActionCode) null, (Integer) null, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4094, (DefaultConstructorMarker) null);
        }
        byte[] bArr = quickLaunchEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.aBleInteractor, GattProfileConstant.CHARACTERISTIC_QUICK_LAUNCH, (String) null, bArr, 2, (Object) null);
        }
    }

    public final void handleQuickLaunch(BleDataEntity bleDataEntity) {
        Boolean value;
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        QuickLaunchEntity object = QuickLaunchEntity.Companion.getObject(bleDataEntity);
        if (object != null) {
            MutableStateFlow<Boolean> mutableStateFlow = this._quickLaunchEnable;
            do {
                value = mutableStateFlow.getValue();
                value.booleanValue();
            } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(object.getOperationCode().getCode() == QuickLaunchOperationCode.CTRL_REGIST.getCode())));
        }
    }

    public final void handleAlert(BleDataEntity bleDataEntity) {
        Integer intValue$default;
        String value;
        String value2;
        String value3;
        String value4;
        String value5;
        String value6;
        String value7;
        String value8;
        String value9;
        String value10;
        String value11;
        Intrinsics.checkNotNullParameter(bleDataEntity, "aBleDataEntity");
        if (bleDataEntity.getData() != null && (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null)) != null) {
            int intValue = intValue$default.intValue();
            if (intValue == NotifyAlertCode.CHARGING_LOW_BATTERY.getCode()) {
                MutableStateFlow<String> mutableStateFlow = this._onFail;
                do {
                    value11 = mutableStateFlow.getValue();
                    String str = value11;
                } while (!mutableStateFlow.compareAndSet(value11, BaseActivityKt.ERROR_OPERATE_WHEN_NO_ENOUGH_BATTERY));
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_LOW_TEMP.getCode()) {
                MutableStateFlow<String> mutableStateFlow2 = this._onFail;
                do {
                    value10 = mutableStateFlow2.getValue();
                    String str2 = value10;
                } while (!mutableStateFlow2.compareAndSet(value10, BaseActivityKt.ERROR_DEVICE_LOWTEMP));
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_HIGH_TEMP.getCode()) {
                MutableStateFlow<String> mutableStateFlow3 = this._onFail;
                do {
                    value9 = mutableStateFlow3.getValue();
                    String str3 = value9;
                } while (!mutableStateFlow3.compareAndSet(value9, BaseActivityKt.ERROR_DEVICE_OVERHEAT));
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_UNKNOWN.getCode()) {
                MutableStateFlow<String> mutableStateFlow4 = this._onFail;
                do {
                    value8 = mutableStateFlow4.getValue();
                    String str4 = value8;
                } while (!mutableStateFlow4.compareAndSet(value8, BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE_UNKNOWN));
            } else if (intValue == NotifyAlertCode.SHUTDOWN_BY_LOW_BATTERY.getCode()) {
                MutableStateFlow<String> mutableStateFlow5 = this._onFail;
                do {
                    value7 = mutableStateFlow5.getValue();
                    String str5 = value7;
                } while (!mutableStateFlow5.compareAndSet(value7, MainPresenterKt.BUNDLE_SHUTDOWN_BY_LOW_BATTERY));
            } else if (intValue == NotifyAlertCode.STOP_BY_OVER_CURRENT.getCode()) {
                MutableStateFlow<String> mutableStateFlow6 = this._onFail;
                do {
                    value6 = mutableStateFlow6.getValue();
                    String str6 = value6;
                } while (!mutableStateFlow6.compareAndSet(value6, BaseActivityKt.ERROR_DEVICE_STOP));
            } else if (intValue == NotifyAlertCode.INVALID_BATTERY_TEMP.getCode()) {
                MutableStateFlow<String> mutableStateFlow7 = this._onFail;
                do {
                    value5 = mutableStateFlow7.getValue();
                    String str7 = value5;
                } while (!mutableStateFlow7.compareAndSet(value5, BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE));
            } else if (intValue == NotifyAlertCode.STOP_BY_INVALID_FAN_RATE.getCode()) {
                MutableStateFlow<String> mutableStateFlow8 = this._onFail;
                do {
                    value4 = mutableStateFlow8.getValue();
                    String str8 = value4;
                } while (!mutableStateFlow8.compareAndSet(value4, BaseActivityKt.ERROR_DEVICE_FAN_INVALID));
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_TEMP.getCode()) {
                MutableStateFlow<String> mutableStateFlow9 = this._onFail;
                do {
                    value3 = mutableStateFlow9.getValue();
                    String str9 = value3;
                } while (!mutableStateFlow9.compareAndSet(value3, BaseActivityKt.ERROR_DEVICE_LOWTEMP));
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_FAN_TEMP.getCode()) {
                MutableStateFlow<String> mutableStateFlow10 = this._onFail;
                do {
                    value2 = mutableStateFlow10.getValue();
                    String str10 = value2;
                } while (!mutableStateFlow10.compareAndSet(value2, BaseActivityKt.ERROR_DEVICE_OVERHEAT));
            } else if (intValue == NotifyAlertCode.HEAT_STOP_BY_INVALID_TEMP.getCode()) {
                MutableStateFlow<String> mutableStateFlow11 = this._onFail;
                do {
                    value = mutableStateFlow11.getValue();
                    String str11 = value;
                } while (!mutableStateFlow11.compareAndSet(value, BaseActivityKt.ERROR_TEMP));
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
}
