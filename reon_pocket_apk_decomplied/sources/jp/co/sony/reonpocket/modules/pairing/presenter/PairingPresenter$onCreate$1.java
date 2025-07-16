package jp.co.sony.reonpocket.modules.pairing.presenter;

import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractorCallbackListener;
import jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"jp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$onCreate$1", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractorCallbackListener;", "discover", "", "bdAddress", "", "deviceName", "aData", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingPresenter.kt */
public final class PairingPresenter$onCreate$1 implements TagScanInteractorCallbackListener {
    final /* synthetic */ PairingPresenter this$0;

    PairingPresenter$onCreate$1(PairingPresenter pairingPresenter) {
        this.this$0 = pairingPresenter;
    }

    public void discover(String str, String str2, TagDataEntity tagDataEntity) {
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        Intrinsics.checkNotNullParameter(str2, "deviceName");
        Intrinsics.checkNotNullParameter(tagDataEntity, "aData");
        PairingViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showTagRegisterDialog(str, tagDataEntity, str2);
        }
    }
}
