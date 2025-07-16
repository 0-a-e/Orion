package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.TagScanRegisterCallback;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"jp/co/sony/reonpocket/data/interactor/TagScanInteractor$tagScanHandler$1", "Ljp/co/sony/reon/android/ble/listener/TagScanRegisterCallback;", "failure", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "success", "deviceName", "", "aTagData", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagScanInteractor.kt */
public final class TagScanInteractor$tagScanHandler$1 implements TagScanRegisterCallback {
    final /* synthetic */ TagScanInteractor this$0;

    TagScanInteractor$tagScanHandler$1(TagScanInteractor tagScanInteractor) {
        this.this$0 = tagScanInteractor;
    }

    public void success(String str, byte[] bArr) {
        TagScanInteractorCallbackListener access$getCallback$p;
        Intrinsics.checkNotNullParameter(str, "deviceName");
        Intrinsics.checkNotNullParameter(bArr, "aTagData");
        TagDataEntity from = TagDataEntity.Companion.from(TagDataEntity.Companion.decryptionData(bArr));
        DebugLogUtil.INSTANCE.d(TagScanInteractor.LOG_TAG, "scan success");
        if (this.this$0.tagScanCheck(str, from)) {
            String bdAddress = from.getBdAddress();
            if (bdAddress != null && (access$getCallback$p = this.this$0.callback) != null) {
                access$getCallback$p.discover(bdAddress, str, from);
                return;
            }
            return;
        }
        this.this$0.execute();
    }

    public void failure(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        DebugLogUtil.INSTANCE.d(TagScanInteractor.LOG_TAG, "scan failure");
        if (reasonCodeConstant != ReasonCodeConstant.INTERRUPT_BY_BLE_SCAN) {
            this.this$0.execute();
        }
    }
}
