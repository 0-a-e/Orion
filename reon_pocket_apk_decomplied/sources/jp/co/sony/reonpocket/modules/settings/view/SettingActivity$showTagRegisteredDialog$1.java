package jp.co.sony.reonpocket.modules.settings.view;

import jp.co.sony.reonpocket.util.DialogSingleActionListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"jp/co/sony/reonpocket/modules/settings/view/SettingActivity$showTagRegisteredDialog$1", "Ljp/co/sony/reonpocket/util/DialogSingleActionListener;", "positiveButtonAction", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
public final class SettingActivity$showTagRegisteredDialog$1 implements DialogSingleActionListener {
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$showTagRegisteredDialog$1(SettingActivity settingActivity) {
        this.this$0 = settingActivity;
    }

    public void positiveButtonAction() {
        if (this.this$0.setConfigurationCompletionProcess == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setConfigurationCompletionProcess");
        }
        Function0 access$getSetConfigurationCompletionProcess$p = this.this$0.setConfigurationCompletionProcess;
        if (access$getSetConfigurationCompletionProcess$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setConfigurationCompletionProcess");
            access$getSetConfigurationCompletionProcess$p = null;
        }
        access$getSetConfigurationCompletionProcess$p.invoke();
        this.this$0.finish();
    }
}
