package jp.co.sony.reonpocket.modules.tagInfo.presenter;

import android.content.Context;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.SensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoFragmentOutput;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoFragmentViewInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/presenter/TagInfoFragmentPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragmentOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragmentViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoFragmentViewInput;)V", "TAG", "", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "mTagScanInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor;", "handleDeviceTemp", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "isTagDataFromDevice", "", "isTagRegistered", "onCreateView", "onDataReceived", "onDestroy", "onPause", "onResume", "onTagScanNoReceivingFailure", "onTagScanNoReceivingSuccess", "aData", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "registerActionCallbackListener", "tagScan", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoFragmentPresenter.kt */
public final class TagInfoFragmentPresenter extends BasePresenter implements TagInfoFragmentOutput {
    public static final int $stable = 8;
    private final String TAG = "TagInfoFragmentPresenter";
    private final Context aContext;
    private final TagInfoFragmentViewInput aView;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private final TagInfoInteractorInput mTagInfoInteractor;
    private final TagScanInteractor mTagScanInteractor;

    public TagInfoFragmentPresenter(Context context, TagInfoFragmentViewInput tagInfoFragmentViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = tagInfoFragmentViewInput;
        this.mTagScanInteractor = new TagScanInteractor(context);
        this.mTagInfoInteractor = new TagInfoInteractor();
        registerActionCallbackListener();
    }

    private final void registerActionCallbackListener() {
        this.mBleInteractor.setDataReceivedCallbackListener(new TagInfoFragmentPresenter$registerActionCallbackListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        if (bleDataEntity.getResult() && Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY)) {
            handleDeviceTemp(bleDataEntity);
        }
    }

    private final void handleDeviceTemp(BleDataEntity bleDataEntity) {
        TagInfoFragmentViewInput tagInfoFragmentViewInput;
        if (bleDataEntity.getData() != null) {
            SensorDataEntity object = SensorDataEntity.Companion.getObject(bleDataEntity);
            NotifyTagSensorDataEntity notifyTagSensorDataEntity = object instanceof NotifyTagSensorDataEntity ? (NotifyTagSensorDataEntity) object : null;
            if (notifyTagSensorDataEntity != null && (tagInfoFragmentViewInput = this.aView) != null) {
                tagInfoFragmentViewInput.updateDisplay(notifyTagSensorDataEntity);
            }
        }
    }

    private final boolean isTagDataFromDevice() {
        TagInfoFragmentViewInput tagInfoFragmentViewInput = this.aView;
        return tagInfoFragmentViewInput != null && tagInfoFragmentViewInput.isDataFromDevice();
    }

    /* access modifiers changed from: private */
    public final void onTagScanNoReceivingSuccess(TagDataEntity tagDataEntity) {
        TagInfoFragmentViewInput tagInfoFragmentViewInput = this.aView;
        if (tagInfoFragmentViewInput != null) {
            tagInfoFragmentViewInput.updateNoReceivingDisplay(tagDataEntity);
        }
        CharSequence tagBDAddress = new TagInfoInteractor().getTagBDAddress(this.aContext);
        if (tagBDAddress == null || tagBDAddress.length() == 0 || isTagDataFromDevice()) {
            DebugLogUtil.INSTANCE.d("Stop Tag Data Scan");
            this.mTagScanInteractor.stopNoReceiving();
        }
    }

    /* access modifiers changed from: private */
    public final void onTagScanNoReceivingFailure() {
        CharSequence tagBDAddress = new TagInfoInteractor().getTagBDAddress(this.aContext);
        if (tagBDAddress == null || tagBDAddress.length() == 0 || isTagDataFromDevice()) {
            DebugLogUtil.INSTANCE.d("Stop Tag Data Scan");
            this.mTagScanInteractor.stopNoReceiving();
        }
    }

    public void onCreateView() {
        super.onCreateView();
        this.mBleInteractor.onCreate(this.aContext);
        if (isTagRegistered()) {
            this.mTagScanInteractor.setNoReceivingListener(new TagInfoFragmentPresenter$onCreateView$1(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
        this.mTagScanInteractor.release();
    }

    public void onResume() {
        super.onResume();
        tagScan();
    }

    public void onPause() {
        super.onPause();
        this.mTagScanInteractor.stopNoReceiving();
    }

    public void tagScan() {
        if (!isTagRegistered()) {
            this.mTagScanInteractor.stopNoReceiving();
            DebugLogUtil.INSTANCE.d(this.TAG, "not registered tag");
        } else if (isTagDataFromDevice()) {
            this.mTagScanInteractor.stopNoReceiving();
            DebugLogUtil.INSTANCE.d(this.TAG, "tag data receive from device");
        } else {
            this.mTagScanInteractor.startNoReceiving();
        }
    }

    public boolean isTagRegistered() {
        String tagBDAddress = this.mTagInfoInteractor.getTagBDAddress(this.aContext);
        return tagBDAddress != null && tagBDAddress.length() > 0;
    }
}
