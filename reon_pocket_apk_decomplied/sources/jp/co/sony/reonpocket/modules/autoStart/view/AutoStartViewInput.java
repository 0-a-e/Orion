package jp.co.sony.reonpocket.modules.autoStart.view;

import jp.co.sony.reonpocket.data.entity.AutoStartEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/autoStart/view/AutoStartViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "onFail", "", "aErrorMessage", "", "onSuccess", "updateAutoStart", "aAutoStartEntity", "Ljp/co/sony/reonpocket/data/entity/AutoStartEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AutoStartViewInput.kt */
public interface AutoStartViewInput extends BaseViewInput {
    void onFail(String str);

    void onSuccess();

    void updateAutoStart(AutoStartEntity autoStartEntity);
}
