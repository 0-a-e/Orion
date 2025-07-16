package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallback;
import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallbackListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"jp/co/sony/reonpocket/data/interactor/BleInteractor$tagScanNoReceiving$1", "Ljp/co/sony/reon/android/ble/listener/TagScanNoReceivingCallbackListener;", "onScanFailed", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onScanSuccess", "aTagData", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleInteractor.kt */
public final class BleInteractor$tagScanNoReceiving$1 implements TagScanNoReceivingCallbackListener {
    final /* synthetic */ TagScanNoReceivingCallback $callback;

    BleInteractor$tagScanNoReceiving$1(TagScanNoReceivingCallback tagScanNoReceivingCallback) {
        this.$callback = tagScanNoReceivingCallback;
    }

    public void onScanSuccess(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "aTagData");
        this.$callback.success(bArr);
    }

    public void onScanFailed(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        this.$callback.failure();
    }
}
