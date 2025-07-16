package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0017\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "changeLevel4Text", "", "aText", "", "changeLevel5Text", "onFail", "aReason", "showWaveGuide", "updateActionMode", "aDeviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "updateBoost", "aTempBoostOption", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "updateCoolTimer", "aRemainTime", "", "(Ljava/lang/Integer;)V", "updateCoolWave", "aTempWaveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "updateOff", "updateTemp", "aTemp", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainCoolFragment.kt */
public interface MainCoolViewInput extends BaseViewInput {
    void changeLevel4Text(String str);

    void changeLevel5Text(String str);

    void onFail(String str);

    void showWaveGuide();

    void updateActionMode(DeviceModeActionCode deviceModeActionCode);

    void updateBoost(TempBoostOption tempBoostOption);

    void updateCoolTimer(Integer num);

    void updateCoolWave(TempWaveOption tempWaveOption);

    void updateOff();

    void updateTemp(TempStepCode tempStepCode);
}
