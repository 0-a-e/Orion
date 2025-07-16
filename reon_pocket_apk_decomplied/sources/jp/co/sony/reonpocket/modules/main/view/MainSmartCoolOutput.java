package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainSmartCoolOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "isTagRegistered", "", "onViewCreated", "onViewDestroyed", "readDeviceMode", "setSmartCoolMode", "aOn", "pref", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "temperature", "", "setSmartCoolOff", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainSmartCoolModeFragment.kt */
public interface MainSmartCoolOutput extends BaseViewOutput {
    void applyBleDataEntity(BleDataEntity bleDataEntity);

    boolean isTagRegistered();

    void onViewCreated();

    void onViewDestroyed();

    void readDeviceMode();

    void setSmartCoolMode(boolean z, SmartModePreference smartModePreference, double d);

    void setSmartCoolOff();
}
