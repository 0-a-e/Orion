package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import android.util.Log;
import jp.co.sony.reon.android.ble.constant.TagGattProfileConstant;
import jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractor;", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorInput;", "aContext", "Landroid/content/Context;", "aOutput", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorOutput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorOutput;)V", "canReceiveTagConnectCallbackListener", "", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mConnectionMode", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$ConnectionType;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "onWriteSuccessSetTagControl", "dataReceivedFailedProcess", "", "uuid", "", "dataReceivedSuccessProcess", "getOnWriteSetTagControlResult", "onTagConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceCharacteristic", "Ljp/co/sony/reon/android/ble/constant/TagGattProfileConstant$DeviceControlService;", "onTagDataReceived", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "setCanReceiveTagConnectCallbackListener", "value", "startWrite", "serviceCharacteristic", "unRegisterTag", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagWriteInteractor.kt */
public final class TagWriteInteractor implements TagWriteInteractorInput {
    public static final int $stable = 8;
    private final Context aContext;
    private final TagWriteInteractorOutput aOutput;
    /* access modifiers changed from: private */
    public boolean canReceiveTagConnectCallbackListener;
    /* access modifiers changed from: private */
    public BleInteractorInput mBleInteractor = new BleInteractor();
    private TagDfuInteractor.ConnectionType mConnectionMode = TagDfuInteractor.ConnectionType.NORMAL;
    private final TagInfoInteractorInput mTagInfoInteractor = new TagInfoInteractor();
    private boolean onWriteSuccessSetTagControl;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TagWriteInteractor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TagGattProfileConstant.DeviceControlService.values().length];
            try {
                iArr[TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_SET_TAG_CONTROL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BleConnStatusCode.values().length];
            try {
                iArr2[BleConnStatusCode.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public TagWriteInteractor(Context context, TagWriteInteractorOutput tagWriteInteractorOutput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(tagWriteInteractorOutput, "aOutput");
        this.aContext = context;
        this.aOutput = tagWriteInteractorOutput;
        this.mBleInteractor.onCreate(context);
        this.mBleInteractor.setTagDataReceivedCallbackListener(new Function1<BleDataEntity, Unit>(this) {
            final /* synthetic */ TagWriteInteractor this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BleDataEntity) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BleDataEntity bleDataEntity) {
                Intrinsics.checkNotNullParameter(bleDataEntity, "it");
                this.this$0.onTagDataReceived(bleDataEntity);
            }
        });
    }

    /* access modifiers changed from: private */
    public final void onTagDataReceived(BleDataEntity bleDataEntity) {
        if (bleDataEntity.getResult()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            debugLogUtil.d("tag success: " + characteristicUuid);
            this.aOutput.onTagWriteSuccess();
            dataReceivedSuccessProcess(bleDataEntity.getCharacteristicUuid());
        } else if (Intrinsics.areEqual((Object) bleDataEntity.getCharacteristicUuid(), (Object) TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_SET_TAG_CONTROL.getUuid())) {
            Log.e("SET_TAG_CONTROL", "Reaching unreachable area");
        } else {
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String characteristicUuid2 = bleDataEntity.getCharacteristicUuid();
            debugLogUtil2.e("tag data error: " + characteristicUuid2);
            dataReceivedFailedProcess(bleDataEntity.getCharacteristicUuid());
        }
    }

    private final void dataReceivedSuccessProcess(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_SET_TAG_CONTROL.getUuid())) {
            Log.e("SET_TAG_CONTROL", "Reaching unreachable area");
        }
    }

    private final void dataReceivedFailedProcess(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_SET_TAG_CONTROL.getUuid())) {
            Log.e("SET_TAG_CONTROL", "Reaching unreachable area");
        }
    }

    private final void unRegisterTag() {
        this.mTagInfoInteractor.removeTagInfo(this.aContext);
        this.mTagInfoInteractor.removeTagBDAddress(this.aContext);
        this.mTagInfoInteractor.removeTagModel(this.aContext);
    }

    /* access modifiers changed from: private */
    public final void onTagConnectionStatus(BleConnStatusCode bleConnStatusCode, TagGattProfileConstant.DeviceControlService deviceControlService) {
        if (WhenMappings.$EnumSwitchMapping$1[bleConnStatusCode.ordinal()] != 1) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.d("Status Code: " + bleConnStatusCode);
        } else if (WhenMappings.$EnumSwitchMapping$0[deviceControlService.ordinal()] == 1) {
            Log.e("SET_TAG_CONTROL", "Reaching unreachable area");
        }
    }

    public void startWrite(TagGattProfileConstant.DeviceControlService deviceControlService) {
        Intrinsics.checkNotNullParameter(deviceControlService, "serviceCharacteristic");
        if (deviceControlService != TagGattProfileConstant.DeviceControlService.CHARACTERISTIC_SET_TAG_CONTROL) {
            this.onWriteSuccessSetTagControl = false;
            this.canReceiveTagConnectCallbackListener = true;
            BleInteractor.Companion.setMTagConnectCallbackListener(new TagWriteInteractor$startWrite$1(this, deviceControlService));
            this.mConnectionMode = TagDfuInteractor.ConnectionType.NORMAL;
            BleInteractorInput.DefaultImpls.tagScanConnect$default(this.mBleInteractor, this.aContext, (String[]) null, 2, (Object) null);
        }
    }

    public boolean getOnWriteSetTagControlResult() {
        return this.onWriteSuccessSetTagControl;
    }

    public void setCanReceiveTagConnectCallbackListener(boolean z) {
        this.canReceiveTagConnectCallbackListener = z;
    }
}
