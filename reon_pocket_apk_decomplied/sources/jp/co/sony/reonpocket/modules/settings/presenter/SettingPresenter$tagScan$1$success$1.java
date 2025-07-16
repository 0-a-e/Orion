package jp.co.sony.reonpocket.modules.settings.presenter;

import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagStatus;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingPresenter.kt */
final class SettingPresenter$tagScan$1$success$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceName;
    final /* synthetic */ TagDataEntity $tagDataEntity;
    final /* synthetic */ SettingPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingPresenter$tagScan$1$success$1(SettingPresenter settingPresenter, TagDataEntity tagDataEntity, String str) {
        super(0);
        this.this$0 = settingPresenter;
        this.$tagDataEntity = tagDataEntity;
        this.$deviceName = str;
    }

    public final void invoke() {
        String bdAddress;
        this.this$0.mTagInfoInteractor.saveTagInfo(this.this$0.aContext, this.$tagDataEntity);
        String bdAddress2 = this.$tagDataEntity.getBdAddress();
        if (bdAddress2 != null) {
            SettingPresenter settingPresenter = this.this$0;
            settingPresenter.mTagInfoInteractor.saveTagBDAddress(settingPresenter.aContext, bdAddress2);
        }
        this.this$0.mTagInfoInteractor.saveTagModel(this.this$0.aContext, this.$deviceName);
        if (this.this$0.isDeviceConnected() && (bdAddress = this.$tagDataEntity.getBdAddress()) != null) {
            this.this$0.registerTag(TagStatus.REGISTER, bdAddress, TagDeviceType.REON_TAG);
        }
    }
}
