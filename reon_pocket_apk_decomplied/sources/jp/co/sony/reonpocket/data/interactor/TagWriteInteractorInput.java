package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reon.android.ble.constant.TagGattProfileConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorInput;", "", "getOnWriteSetTagControlResult", "", "setCanReceiveTagConnectCallbackListener", "", "value", "startWrite", "serviceCharacteristic", "Ljp/co/sony/reon/android/ble/constant/TagGattProfileConstant$DeviceControlService;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagWriteInteractorInput.kt */
public interface TagWriteInteractorInput {
    boolean getOnWriteSetTagControlResult();

    void setCanReceiveTagConnectCallbackListener(boolean z);

    void startWrite(TagGattProfileConstant.DeviceControlService deviceControlService);
}
