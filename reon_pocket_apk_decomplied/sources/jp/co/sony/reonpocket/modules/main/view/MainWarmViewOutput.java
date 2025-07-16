package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainWarmViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "onViewCreated", "onViewDestroyed", "setWarmAuto", "aIsAuto", "", "setWarmBoost", "setWarmOff", "updateWarmLevel", "aLevel", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainWarmFragment.kt */
public interface MainWarmViewOutput extends BaseViewOutput {
    void applyBleDataEntity(BleDataEntity bleDataEntity);

    CapabilityEntity getCapability();

    void onViewCreated();

    void onViewDestroyed();

    void setWarmAuto(boolean z);

    void setWarmBoost();

    void setWarmOff();

    void updateWarmLevel(TempStepCode tempStepCode);
}
