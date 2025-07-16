package jp.co.sony.reonpocket.modules.main.view;

import android.graphics.Bitmap;
import java.util.ArrayList;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.DeviceCoolingCode;
import jp.co.sony.reonpocket.constant.DeviceInfoConstants;
import jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.data.entity.BatteryEntity;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.data.entity.NotifyDeviceSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.ThermoControlStatusEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J,\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\nH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\nH&J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0017\u0010$\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J\b\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&J>\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u00142\u0006\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u00010\u00142\b\u00105\u001a\u0004\u0018\u000106H&J\u0010\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\nH&J\b\u00109\u001a\u00020\u0003H&J \u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0014H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u0003H&J\u0018\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH&J\b\u0010E\u001a\u00020\u0003H&J\u0018\u0010F\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020IH&J\u0010\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020LH&J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020OH&J\u0010\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020RH&J\u0010\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\nH&J\u0010\u0010U\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\nH&J\u0010\u0010W\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\nH&J\u0010\u0010Y\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020[H&J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\nH&J\b\u0010^\u001a\u00020\u0003H&J\u0010\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020aH&J\u0010\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020bH&J\u001a\u0010c\u001a\u00020\u00032\b\u0010`\u001a\u0004\u0018\u00010d2\u0006\u0010e\u001a\u00020\nH&J\b\u0010f\u001a\u00020\u0003H&J\u001a\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\n2\b\u0010`\u001a\u0004\u0018\u00010dH&J\u001a\u0010h\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\n2\b\u0010`\u001a\u0004\u0018\u00010<H&J\u0010\u0010i\u001a\u00020\u00032\u0006\u0010`\u001a\u00020dH&¨\u0006j"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/view/MainViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "calcelCustomToast", "", "dismissModeSwitchingProgress", "getLastSelectedPage", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;", "hiddenProgress", "hiddenTagDfuProgress", "isActiveSmartMode", "", "isSmartMixTypeCool", "onBatteryStateChange", "aBatteryEntity", "Ljp/co/sony/reonpocket/data/entity/BatteryEntity;", "onConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onFail", "aErrorMessage", "requestForStoreReview", "setIsForeground", "isFg", "setIsShownSmartCoolBefore", "aIsSmartShown", "setIsShownSmartWarmBefore", "setSmartCoolPreference", "smartPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "setSmartCoolTempSwitchThreshold", "boolean", "", "setSmartMixPreference", "(Ljava/lang/Boolean;)V", "setSmartWarmPreference", "setSmartWarmTempSwitchThreshold", "showAutoStartNotification", "showAutoStopMessage", "showDfuComplete", "showDfuDisconnect", "showDfuFail", "showDfuStarting", "showModeSwitchingProgress", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showRequestBackgroundLocationDialog", "aIsRequestPermission", "showTagRegisterDialog", "bdAddress", "aTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "aTagModelName", "showTagRegistrationFailedDialog", "showTagUpdateMessage", "transitToCoolOrWarmByTypeCode", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "aDeviceModeEntity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "unRegisterTagStatus", "updateActionMode", "updateCoolingStatus", "aCoolingCode", "Ljp/co/sony/reonpocket/constant/DeviceCoolingCode;", "updateDeviceInfo", "aInfoCode", "Ljp/co/sony/reonpocket/constant/DeviceInfoConstants;", "updateDeviceTemp", "aTemp", "", "updateDfuProgress", "aProgress", "", "updateIsAlert", "aIsShowAlert", "updateIsAutoStartEnable", "aIsEnable", "updateIsOff", "aIsOff", "updateSettingTrigger", "aSettingTriggerCode", "Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;", "updateSmartModeIconDisplay", "isIconDisplay", "updateSmartWarmTagNoReceiving", "updateStatusText", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyDeviceSensorDataEntity;", "Ljp/co/sony/reonpocket/data/entity/ThermoControlStatusEntity;", "updateTagEntity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "isReceiving", "updateTagMiniInfoView", "isActive", "updateTagMiniInfoViewNoReceiving", "updateTagStatusText", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainViewInput.kt */
public interface MainViewInput extends BaseViewInput {
    void calcelCustomToast();

    void dismissModeSwitchingProgress();

    MainActivity.Companion.Page getLastSelectedPage();

    void hiddenProgress();

    void hiddenTagDfuProgress();

    boolean isActiveSmartMode();

    boolean isSmartMixTypeCool();

    void onBatteryStateChange(BatteryEntity batteryEntity);

    void onConnectionStatus(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList);

    void onFail(String str);

    void requestForStoreReview();

    void setIsForeground(boolean z);

    void setIsShownSmartCoolBefore(boolean z);

    void setIsShownSmartWarmBefore(boolean z);

    void setSmartCoolPreference(SmartModePreference smartModePreference);

    void setSmartCoolTempSwitchThreshold(double d);

    void setSmartMixPreference(Boolean bool);

    void setSmartWarmPreference(SmartModePreference smartModePreference);

    void setSmartWarmTempSwitchThreshold(double d);

    void showAutoStartNotification();

    void showAutoStopMessage();

    void showDfuComplete();

    void showDfuDisconnect();

    void showDfuFail();

    void showDfuStarting();

    void showModeSwitchingProgress();

    void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap);

    void showRequestBackgroundLocationDialog(boolean z);

    void showTagRegisterDialog();

    void showTagRegisterDialog(String str, TagDataEntity tagDataEntity, String str2);

    void showTagRegistrationFailedDialog();

    void showTagUpdateMessage();

    void transitToCoolOrWarmByTypeCode(BleDataEntity bleDataEntity, DeviceModeEntity deviceModeEntity);

    void unRegisterTagStatus();

    void updateActionMode(BleDataEntity bleDataEntity, DeviceModeEntity deviceModeEntity);

    void updateCoolingStatus(DeviceCoolingCode deviceCoolingCode);

    void updateDeviceInfo(DeviceInfoConstants deviceInfoConstants);

    void updateDeviceTemp(float f);

    void updateDfuProgress(int i);

    void updateIsAlert(boolean z);

    void updateIsAutoStartEnable(boolean z);

    void updateIsOff(boolean z);

    void updateSettingTrigger(DeviceModeSettingTriggerCode deviceModeSettingTriggerCode);

    void updateSmartModeIconDisplay(boolean z);

    void updateSmartWarmTagNoReceiving();

    void updateStatusText(NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity);

    void updateStatusText(ThermoControlStatusEntity thermoControlStatusEntity);

    void updateTagEntity(NotifyTagSensorDataEntity notifyTagSensorDataEntity, boolean z);

    void updateTagMiniInfoView();

    void updateTagMiniInfoView(boolean z, NotifyTagSensorDataEntity notifyTagSensorDataEntity);

    void updateTagMiniInfoViewNoReceiving(boolean z, TagDataEntity tagDataEntity);

    void updateTagStatusText(NotifyTagSensorDataEntity notifyTagSensorDataEntity);
}
