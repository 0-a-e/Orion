package jp.co.sony.reonpocket.modules.settings.view;

import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.util.DialogDoubleActionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"jp/co/sony/reonpocket/modules/settings/view/SettingActivity$showTagFoundDialog$1", "Ljp/co/sony/reonpocket/util/DialogDoubleActionListener;", "negativeButtonAction", "", "positiveButtonAction", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
public final class SettingActivity$showTagFoundDialog$1 implements DialogDoubleActionListener {
    final /* synthetic */ TagDataEntity $aTagInfo;
    final /* synthetic */ String $aTagModelName;
    final /* synthetic */ Function0<Unit> $positiveCompletion;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$showTagFoundDialog$1(SettingActivity settingActivity, TagDataEntity tagDataEntity, String str, Function0<Unit> function0) {
        this.this$0 = settingActivity;
        this.$aTagInfo = tagDataEntity;
        this.$aTagModelName = str;
        this.$positiveCompletion = function0;
    }

    public void positiveButtonAction() {
        this.this$0.isFoundDialogDisplay = false;
        if (this.$aTagInfo.getFwVersionCode() >= Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE)) {
            this.this$0.isSettingConfiguration = true;
            this.this$0.scanTagInfo = this.$aTagInfo;
            this.this$0.scanTagModelName = this.$aTagModelName;
            this.this$0.setConfigurationCompletionProcess = this.$positiveCompletion;
            return;
        }
        this.this$0.setConfigurationCompletionProcess = this.$positiveCompletion;
        this.this$0.showTagRegisteredDialog(this.$aTagInfo, this.$aTagModelName);
    }

    public void negativeButtonAction() {
        this.this$0.isFoundDialogDisplay = false;
    }
}
