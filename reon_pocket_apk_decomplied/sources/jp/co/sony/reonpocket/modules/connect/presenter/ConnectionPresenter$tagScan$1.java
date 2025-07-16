package jp.co.sony.reonpocket.modules.connect.presenter;

import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.TagScanRegisterCallback;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionViewInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"jp/co/sony/reonpocket/modules/connect/presenter/ConnectionPresenter$tagScan$1", "Ljp/co/sony/reon/android/ble/listener/TagScanRegisterCallback;", "failure", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "success", "deviceName", "", "aTagData", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionPresenter.kt */
public final class ConnectionPresenter$tagScan$1 implements TagScanRegisterCallback {
    final /* synthetic */ ConnectionPresenter this$0;

    ConnectionPresenter$tagScan$1(ConnectionPresenter connectionPresenter) {
        this.this$0 = connectionPresenter;
    }

    public void success(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "deviceName");
        Intrinsics.checkNotNullParameter(bArr, "aTagData");
        TagDataEntity from = TagDataEntity.Companion.from(TagDataEntity.Companion.decryptionData(bArr));
        ConnectionViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.hiddenProgress();
        }
        ConnectionViewInput access$getAView$p2 = this.this$0.aView;
        if (access$getAView$p2 != null) {
            access$getAView$p2.showTagFoundDialog(from, str, new ConnectionPresenter$tagScan$1$success$1(this.this$0, from, str));
        }
    }

    public void failure(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        if (reasonCodeConstant != ReasonCodeConstant.INTERRUPT_BY_BLE_SCAN) {
            ConnectionViewInput access$getAView$p = this.this$0.aView;
            if (access$getAView$p != null) {
                access$getAView$p.hiddenProgress();
            }
            ConnectionViewInput access$getAView$p2 = this.this$0.aView;
            if (access$getAView$p2 != null) {
                access$getAView$p2.showTagNotFoundPopup();
            }
            this.this$0.isTagScanning = false;
        }
    }
}
