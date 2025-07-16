package jp.co.sony.reonpocket.modules.connect.presenter;

import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.TagScanNoReceivingInteractorCallbackListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"jp/co/sony/reonpocket/modules/connect/presenter/ConnectionPresenter$onCreate$2", "Ljp/co/sony/reonpocket/data/interactor/TagScanNoReceivingInteractorCallbackListener;", "failure", "", "success", "aData", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionPresenter.kt */
public final class ConnectionPresenter$onCreate$2 implements TagScanNoReceivingInteractorCallbackListener {
    final /* synthetic */ ConnectionPresenter this$0;

    ConnectionPresenter$onCreate$2(ConnectionPresenter connectionPresenter) {
        this.this$0 = connectionPresenter;
    }

    public void success(TagDataEntity tagDataEntity) {
        Intrinsics.checkNotNullParameter(tagDataEntity, "aData");
        this.this$0.onTagScanNoReceivingSuccess(tagDataEntity);
    }

    public void failure() {
        this.this$0.onTagScanNoReceivingFailure();
    }
}
