package jp.co.sony.reonpocket.modules.settings.presenter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SettingPresenter$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ String f$0;

    public /* synthetic */ SettingPresenter$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final void onComplete(Task task) {
        SettingPresenter.doDeviceUnregister$lambda$19(this.f$0, task);
    }
}
