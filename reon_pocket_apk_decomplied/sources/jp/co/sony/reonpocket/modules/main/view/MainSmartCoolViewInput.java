package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\rH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\nH&¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "onFail", "", "aReason", "", "updateCurrentState", "isNoAmbientTemp", "", "temperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "updateTecRate", "aRate", "", "updateTecTemp", "aTecTemp", "updateTempSetting", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "settingTemp", "", "targetTemp", "updateViewVisibility", "aTemperature", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartCoolModeFragment.kt */
public interface MainSmartCoolViewInput extends BaseViewInput {
    void onFail(String str);

    void updateCurrentState(boolean z, DeviceModeEntity.Temperature temperature);

    void updateTecRate(float f);

    void updateTecTemp(float f);

    void updateTempSetting(SmartModePreference smartModePreference, double d, double d2);

    void updateViewVisibility(DeviceModeEntity.Temperature temperature);
}
