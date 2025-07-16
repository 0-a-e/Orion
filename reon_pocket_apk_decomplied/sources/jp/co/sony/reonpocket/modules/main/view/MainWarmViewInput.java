package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0017\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "onFail", "", "aReason", "", "updateActionMode", "aDeviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "updateBoost", "aTempBoostOption", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "updateOff", "updateTemp", "aTemp", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "updateWarmTimer", "aRemainTime", "", "(Ljava/lang/Integer;)V", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainWarmFragment.kt */
public interface MainWarmViewInput extends BaseViewInput {
    void onFail(String str);

    void updateActionMode(DeviceModeActionCode deviceModeActionCode);

    void updateBoost(TempBoostOption tempBoostOption);

    void updateOff();

    void updateTemp(TempStepCode tempStepCode);

    void updateWarmTimer(Integer num);
}
