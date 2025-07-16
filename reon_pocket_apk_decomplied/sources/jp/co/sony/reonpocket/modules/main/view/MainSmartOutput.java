package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J@\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "isTagRegistered", "", "onViewCreated", "onViewDestroyed", "readDeviceMode", "setSmartMode", "aOn", "coolPref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "warmPref", "coolTemperature", "", "warmTemperature", "coolTempSwitchThreshold", "", "warmTempSwitchThreshold", "setSmartOff", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartModeFragment.kt */
public interface MainSmartOutput extends BaseViewOutput {
    void applyBleDataEntity(BleDataEntity bleDataEntity);

    boolean isTagRegistered();

    void onViewCreated();

    void onViewDestroyed();

    void readDeviceMode();

    void setSmartMode(boolean z, int i, int i2);

    void setSmartMode(boolean z, SmartModePreference smartModePreference, SmartModePreference smartModePreference2, double d, double d2, int i, int i2);

    void setSmartOff();
}
