package jp.co.sony.reonpocket.data.interactor;

import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallback;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"jp/co/sony/reonpocket/data/interactor/TagScanInteractor$mNoReceivingScanCallback$1", "Ljp/co/sony/reon/android/ble/listener/TagScanNoReceivingCallback;", "failure", "", "success", "aTagData", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagScanInteractor.kt */
public final class TagScanInteractor$mNoReceivingScanCallback$1 implements TagScanNoReceivingCallback {
    final /* synthetic */ TagScanInteractor this$0;

    TagScanInteractor$mNoReceivingScanCallback$1(TagScanInteractor tagScanInteractor) {
        this.this$0 = tagScanInteractor;
    }

    public void success(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "aTagData");
        TagDataEntity from = TagDataEntity.Companion.from(TagDataEntity.Companion.decryptionData(bArr));
        DebugLogUtil.INSTANCE.d(TagScanInteractor.LOG_TAG, "scan success");
        TagScanNoReceivingInteractorCallbackListener access$getCallbackNoReceiving$p = this.this$0.callbackNoReceiving;
        if (access$getCallbackNoReceiving$p != null) {
            access$getCallbackNoReceiving$p.success(from);
        }
    }

    public void failure() {
        DebugLogUtil.INSTANCE.d(TagScanInteractor.LOG_TAG, "scan failure");
        TagScanNoReceivingInteractorCallbackListener access$getCallbackNoReceiving$p = this.this$0.callbackNoReceiving;
        if (access$getCallbackNoReceiving$p != null) {
            access$getCallbackNoReceiving$p.failure();
        }
    }
}
