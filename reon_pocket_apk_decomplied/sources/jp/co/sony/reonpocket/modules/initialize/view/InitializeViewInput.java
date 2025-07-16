package jp.co.sony.reonpocket.modules.initialize.view;

import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/initialize/view/InitializeViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "onFail", "", "aErrorMessage", "", "showEulaPpDialog", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InitializeViewInput.kt */
public interface InitializeViewInput extends BaseViewInput {
    void onFail(String str);

    void showEulaPpDialog();
}
