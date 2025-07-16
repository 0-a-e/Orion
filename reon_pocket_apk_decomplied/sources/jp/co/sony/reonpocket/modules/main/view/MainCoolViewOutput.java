package jp.co.sony.reonpocket.modules.main.view;

import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewOutput;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainCoolViewOutput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewOutput;", "applyBleDataEntity", "", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "onViewCreated", "onViewDestroyed", "readDeviceMode", "setCoolAuto", "aIsAuto", "", "setCoolBoost", "setCoolOff", "setCoolWave", "aLevel", "", "aTempWaveOption", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "updateCoolLevel", "Ljp/co/sony/reonpocket/constant/TempStepCode;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainCoolFragment.kt */
public interface MainCoolViewOutput extends BaseViewOutput {
    void applyBleDataEntity(BleDataEntity bleDataEntity);

    CapabilityEntity getCapability();

    void onViewCreated();

    void onViewDestroyed();

    void readDeviceMode();

    void setCoolAuto(boolean z);

    void setCoolBoost();

    void setCoolOff();

    void setCoolWave(int i, TempWaveOption tempWaveOption);

    void updateCoolLevel(TempStepCode tempStepCode);
}
