package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.TagScanCallbackListener;
import jp.co.sony.reon.android.ble.listener.TagScanRegisterCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"jp/co/sony/reonpocket/data/interactor/BleInteractor$tagScan$1", "Ljp/co/sony/reon/android/ble/listener/TagScanCallbackListener;", "onScanFailed", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onScanSuccess", "bdAddress", "", "deviceName", "aTagData", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleInteractor.kt */
public final class BleInteractor$tagScan$1 implements TagScanCallbackListener {
    final /* synthetic */ TagScanRegisterCallback $callback;

    BleInteractor$tagScan$1(TagScanRegisterCallback tagScanRegisterCallback) {
        this.$callback = tagScanRegisterCallback;
    }

    public void onScanSuccess(String str, String str2, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        Intrinsics.checkNotNullParameter(str2, "deviceName");
        Intrinsics.checkNotNullParameter(bArr, "aTagData");
        this.$callback.success(str2, bArr);
    }

    public void onScanFailed(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        this.$callback.failure(reasonCodeConstant);
    }
}
