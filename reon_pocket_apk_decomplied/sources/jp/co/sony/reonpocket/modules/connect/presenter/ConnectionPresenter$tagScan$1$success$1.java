package jp.co.sony.reonpocket.modules.connect.presenter;

import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagStatus;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionPresenter.kt */
final class ConnectionPresenter$tagScan$1$success$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceName;
    final /* synthetic */ TagDataEntity $tagDataEntity;
    final /* synthetic */ ConnectionPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionPresenter$tagScan$1$success$1(ConnectionPresenter connectionPresenter, TagDataEntity tagDataEntity, String str) {
        super(0);
        this.this$0 = connectionPresenter;
        this.$tagDataEntity = tagDataEntity;
        this.$deviceName = str;
    }

    public final void invoke() {
        this.this$0.mTagInfoInteractor.saveTagInfo(this.this$0.aContext, this.$tagDataEntity);
        String bdAddress = this.$tagDataEntity.getBdAddress();
        if (bdAddress != null) {
            ConnectionPresenter connectionPresenter = this.this$0;
            connectionPresenter.mTagInfoInteractor.saveTagBDAddress(connectionPresenter.aContext, bdAddress);
        }
        this.this$0.mTagInfoInteractor.saveTagModel(this.this$0.aContext, this.$deviceName);
        if (this.this$0.isDeviceConnected()) {
            String bdAddress2 = this.$tagDataEntity.getBdAddress();
            if (bdAddress2 != null) {
                this.this$0.registerTagBDAddress(TagStatus.REGISTER, bdAddress2, TagDeviceType.REON_TAG);
                return;
            }
            return;
        }
        this.this$0.isTagScanning = false;
    }
}
