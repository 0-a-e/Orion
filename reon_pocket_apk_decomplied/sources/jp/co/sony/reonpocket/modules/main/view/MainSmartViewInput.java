package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH&J8\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H&J)\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006!"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "onFail", "", "aReason", "", "showCoolHeatState", "aTemperatureEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity$Temperature;", "aIsTagInfoNoReceiving", "", "aIsTagNoAmbientTemp", "updateSmartTecRate", "aRate", "", "updateSmartTecTemp", "aTecTemp", "updateStates", "isOn", "currentCoolHeatTypeCode", "Ljp/co/sony/reonpocket/constant/CurrentCoolHeatTypeCode;", "coolTempSwitchThreshold", "", "warmTempSwitchThreshold", "coolPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "heatPreference", "updateTargetTemperatureView", "isCool", "smartPreference", "targetTemp", "(ZLjp/co/sony/reonpocket/constant/SmartModePreference;Ljava/lang/Double;)V", "updateViewVisibility", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartModeFragment.kt */
public interface MainSmartViewInput extends BaseViewInput {
    void onFail(String str);

    void showCoolHeatState(DeviceModeEntity.Temperature temperature, boolean z, boolean z2);

    void updateSmartTecRate(float f);

    void updateSmartTecTemp(float f);

    void updateStates(boolean z, CurrentCoolHeatTypeCode currentCoolHeatTypeCode, double d, double d2, SmartModePreference smartModePreference, SmartModePreference smartModePreference2);

    void updateTargetTemperatureView(boolean z, SmartModePreference smartModePreference, Double d);

    void updateViewVisibility(DeviceModeEntity.Temperature temperature);
}
