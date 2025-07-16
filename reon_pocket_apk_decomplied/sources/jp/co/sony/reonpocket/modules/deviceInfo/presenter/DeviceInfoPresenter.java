package jp.co.sony.reonpocket.modules.deviceInfo.presenter;

import android.content.Context;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.NotifyDeviceSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.SensorDataEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.deviceInfo.router.DeviceInfoRouter;
import jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity;
import jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoViewInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ljp/co/sony/reonpocket/modules/deviceInfo/presenter/DeviceInfoPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/deviceInfo/view/DeviceInfoActivity$DeviceInfoViewOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/deviceInfo/view/DeviceInfoViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/deviceInfo/view/DeviceInfoViewInput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mRouter", "Ljp/co/sony/reonpocket/modules/deviceInfo/router/DeviceInfoRouter;", "closeDeviceTempNotification", "", "getDeviceModelName", "", "handleDeviceTemp", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "onDataReceived", "onPause", "onResume", "openDeviceTempNotification", "registerActionCallbackListener", "transitToSupportPage", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceInfoPresenter.kt */
public final class DeviceInfoPresenter extends BasePresenter implements DeviceInfoActivity.DeviceInfoViewOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final DeviceInfoViewInput aView;
    private final BleInteractorInput mBleInteractor = new BleInteractor();
    private DeviceInfoInteractorInput mDeviceInfoInteractor;
    private final DeviceInfoRouter mRouter;

    public DeviceInfoPresenter(Context context, DeviceInfoViewInput deviceInfoViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = deviceInfoViewInput;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity");
        this.mRouter = new DeviceInfoRouter((DeviceInfoActivity) context);
        this.mDeviceInfoInteractor = new DeviceInfoInteractor();
        registerActionCallbackListener();
    }

    private final void registerActionCallbackListener() {
        this.mBleInteractor.setDataReceivedCallbackListener(new DeviceInfoPresenter$registerActionCallbackListener$1(this));
    }

    public void onResume() {
        super.onResume();
        openDeviceTempNotification();
    }

    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        if (bleDataEntity.getResult() && Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY)) {
            handleDeviceTemp(bleDataEntity);
        }
    }

    private final void handleDeviceTemp(BleDataEntity bleDataEntity) {
        DeviceInfoViewInput deviceInfoViewInput;
        if (bleDataEntity.getData() != null) {
            SensorDataEntity object = SensorDataEntity.Companion.getObject(bleDataEntity);
            if ((object instanceof NotifyDeviceSensorDataEntity) && (deviceInfoViewInput = this.aView) != null) {
                NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity = (NotifyDeviceSensorDataEntity) object;
                deviceInfoViewInput.updateDeviceTemp(notifyDeviceSensorDataEntity.getTec1Temp(), notifyDeviceSensorDataEntity.getFinTemp());
            }
        }
    }

    public String getDeviceModelName() {
        String peripheralName = this.mDeviceInfoInteractor.getPeripheralName(this.aContext);
        return peripheralName == null ? "" : peripheralName;
    }

    private final void openDeviceTempNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY, (String) null, true, 2, (Object) null);
    }

    private final void closeDeviceTempNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY, (String) null, false, 2, (Object) null);
    }

    public void transitToSupportPage() {
        this.mRouter.transitToSupport(this.aContext);
    }
}
