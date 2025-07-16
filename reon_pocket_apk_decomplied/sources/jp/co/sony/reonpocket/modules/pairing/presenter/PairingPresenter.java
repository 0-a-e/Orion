package jp.co.sony.reonpocket.modules.pairing.presenter;

import android.content.Context;
import android.os.Bundle;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import jp.co.sony.reon.android.ble.BleManager;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor;
import jp.co.sony.reonpocket.constant.BatteryChargeStatus;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.constant.OwnerStatus;
import jp.co.sony.reonpocket.constant.PowerSupplyStatus;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagStatus;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.AuthenticationEntity;
import jp.co.sony.reonpocket.data.entity.AuthenticationTagEntity;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.SensorDataEntity;
import jp.co.sony.reonpocket.data.entity.SetOwnerEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.FirebaseMessageInteractor;
import jp.co.sony.reonpocket.data.interactor.SettingInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.SettingInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractor;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractorOutput;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.base.view.BaseActivityKt;
import jp.co.sony.reonpocket.modules.pairing.router.PairingRouter;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivity;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivityKt;
import jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.NoticeUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.util.UuidHelperUtil;
import jp.co.sony.reonpocket.view.adapter.SettingItemAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0017\b\u0007\u0018\u0000 ¯\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\f¯\u0001°\u0001±\u0001²\u0001³\u0001´\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u000209H\u0016J\b\u0010<\u001a\u000209H\u0016J\b\u0010=\u001a\u00020\rH\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010D\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020#H\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010I\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010J\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010K\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010P\u001a\u000209H\u0016J\b\u0010Q\u001a\u00020\rH\u0002J\b\u0010R\u001a\u00020\rH\u0016J,\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020U2\u001a\u0010V\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010Wj\n\u0012\u0004\u0012\u00020#\u0018\u0001`XH\u0002J\b\u0010Y\u001a\u000209H\u0016J\u0010\u0010Z\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010[\u001a\u000209H\u0016J\b\u0010\\\u001a\u000209H\u0016J\b\u0010]\u001a\u000209H\u0016J\b\u0010^\u001a\u000209H\u0016J\b\u0010_\u001a\u000209H\u0016J\u0010\u0010`\u001a\u0002092\u0006\u0010F\u001a\u00020#H\u0016J\b\u0010a\u001a\u000209H\u0016J\u0010\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020dH\u0016J\b\u0010e\u001a\u000209H\u0002J\u0010\u0010f\u001a\u0002092\u0006\u0010g\u001a\u00020?H\u0002J\b\u0010h\u001a\u000209H\u0016J\b\u0010i\u001a\u000209H\u0016J\b\u0010j\u001a\u000209H\u0002J\b\u0010k\u001a\u000209H\u0002J\b\u0010l\u001a\u000209H\u0002J\b\u0010m\u001a\u000209H\u0002J\u0006\u0010n\u001a\u000209J\b\u0010o\u001a\u000209H\u0002J\b\u0010p\u001a\u000209H\u0002J\b\u0010q\u001a\u000209H\u0002J\b\u0010r\u001a\u000209H\u0002J\b\u0010s\u001a\u000209H\u0002J\b\u0010t\u001a\u000209H\u0002J\b\u0010u\u001a\u000209H\u0002J\b\u0010v\u001a\u000209H\u0002J\b\u0010w\u001a\u000209H\u0002J\b\u0010x\u001a\u000209H\u0002J\u0018\u0010y\u001a\u0002092\u0006\u0010z\u001a\u00020#2\u0006\u0010{\u001a\u00020?H\u0016J!\u0010|\u001a\u0002092\u0006\u0010}\u001a\u00020~2\u0006\u0010z\u001a\u00020#2\u0007\u0010\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u0002092\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020\r2\u0006\u0010A\u001a\u00020BH\u0002J\u0012\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020\rH\u0016J\t\u0010\u0001\u001a\u000209H\u0002J\u0012\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020\u001cH\u0016J\u0011\u0010\u0001\u001a\u00020\r2\u0006\u0010A\u001a\u00020BH\u0002J\u0011\u0010\u0001\u001a\u00020\r2\u0006\u0010A\u001a\u00020BH\u0002J\u0012\u0010\u0001\u001a\u0002092\u0007\u0010\u0001\u001a\u00020-H\u0016J\u0013\u0010\u0001\u001a\u0002092\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\t\u0010\u0001\u001a\u000209H\u0016J\u001a\u0010\u0001\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020#H\u0002J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0002J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0002J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0016J\t\u0010\u0001\u001a\u000209H\u0002J1\u0010 \u0001\u001a\u0002092\u0007\u0010¡\u0001\u001a\u00020\r2\u0007\u0010¢\u0001\u001a\u00020\r2\t\u0010{\u001a\u0005\u0018\u00010£\u00012\t\u0010¤\u0001\u001a\u0004\u0018\u00010?H\u0016J\t\u0010¥\u0001\u001a\u000209H\u0002J\t\u0010¦\u0001\u001a\u000209H\u0016J\u0012\u0010§\u0001\u001a\u0002092\u0007\u0010¨\u0001\u001a\u00020\rH\u0016J\u0013\u0010©\u0001\u001a\u0002092\b\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\t\u0010¬\u0001\u001a\u000209H\u0002J\t\u0010­\u0001\u001a\u000209H\u0016J\t\u0010®\u0001\u001a\u000209H\u0002J\u0011\u0010®\u0001\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000¨\u0006µ\u0001"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity$PairingViewOutput;", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$TagDfuOutput;", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingViewInput;", "aFirebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/pairing/view/PairingViewInput;Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "isCheckTagWriteRegister", "", "isShowTagRegistDialog", "isTagScanning", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mBundleWhenTransitToMain", "Landroid/os/Bundle;", "mConnectionType", "Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$ConnectionType;", "mDefaultDfuProgressListener", "jp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$mDefaultDfuProgressListener$1", "Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$mDefaultDfuProgressListener$1;", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mDfuState", "Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$DfuState;", "mFirebaseMessageInteractor", "Ljp/co/sony/reonpocket/data/interactor/FirebaseMessageInteractor;", "mIsCheckingDfuModelName", "mIsDfuSuccess", "mIsTagUpdate", "mLocalFirmwareReversion", "", "mModelName", "mModelType", "Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$ModelType;", "mRouter", "Ljp/co/sony/reonpocket/modules/pairing/router/PairingRouter;", "mSerialNumber", "mSettingInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/SettingInfoInteractorInput;", "mSuspendReason", "Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$SuspendReason;", "mTagDfuInteractor", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "mTagScanInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor;", "mTagWriteInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorInput;", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "connect", "", "connectDFU", "disconnect", "doForceUpdate", "getOnWriteSetTagControlResult", "getTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "handleBattery", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "handleBoost", "handleCapability", "handleDataError", "aErrorMessage", "handleDeviceMode", "handleDeviceTemp", "handleDfuModelName", "handleFirmwareReversion", "handleOwner", "handleSettingMenuTapItem", "item", "Ljp/co/sony/reonpocket/view/adapter/SettingItemAdapter$SettingListItem;", "handleTagRegister", "initUserInfo", "isDeviceConnected", "isTagRegistered", "onConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreate", "onDataReceived", "onDestroy", "onPause", "onResume", "onTagDfuComplete", "onTagDfuDeviceDisconnecting", "onTagDfuFailed", "onTagDfuProcessStarting", "onTagDfuProgressChanged", "percent", "", "onTagScanNoReceivingFailure", "onTagScanNoReceivingSuccess", "aData", "onTagWriteFailed", "onTagWriteSuccess", "openAlertNotification", "openAuthentication", "openBatteryNotification", "openDeviceModeNotification", "openDeviceTempNotification", "readBattery", "readBoost", "readCapability", "readDeviceMode", "readDeviceName", "readFirmwareReversion", "readModelName", "readSerialNumber", "registerActionCallbackListener", "registerDeviceInfo", "registerTag", "bdAddress", "entity", "registerTagBDAddress", "status", "Ljp/co/sony/reonpocket/constant/TagStatus;", "deviceType", "Ljp/co/sony/reonpocket/constant/TagDeviceType;", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "setAutoInfo", "setCanReceiveTagConnectCallbackListener", "value", "setCurrentTime", "setDfuState", "aIsDfu", "setManualInfo", "setMyModeInfo", "setSuspendReason", "aReason", "setTagScanListener", "info", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "setTemperatureModeInfo", "showNotification", "startDfu", "aDeviceName", "startTagDfu", "tagAlwaysScan", "tagScan", "tagScanNoReceiving", "transitToChangeUserInfo", "transitToEula", "transitToLegal", "transitToMain", "transitToOss", "transitToPrivacy", "transitToSupport", "transitToTagInfo", "isTagInfoReceiving", "isTagNoAmbientTemp", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "tagDataEntity", "transitToUserFeedback", "unRegisterTag", "updateDialogStatus", "isShow", "writeAuthentication", "aEntity", "Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity;", "writeOwner", "writeRequestDfu", "writeTagRegister", "Companion", "ConnectionType", "DfuState", "ModelType", "NextPage", "SuspendReason", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingPresenter.kt */
public final class PairingPresenter extends BasePresenter implements PairingActivity.PairingViewOutput, TagDfuInteractor.TagDfuOutput, TagWriteInteractorOutput {
    public static final int $stable = 8;
    private static final int CAPABILITY_MIN_LENGTH = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final Context aContext;
    private final FirebaseAnalytics aFirebaseAnalytics;
    /* access modifiers changed from: private */
    public final PairingViewInput aView;
    private boolean isCheckTagWriteRegister;
    private boolean isShowTagRegistDialog;
    /* access modifiers changed from: private */
    public boolean isTagScanning;
    private BleInteractorInput mBleInteractor;
    private final Bundle mBundleWhenTransitToMain;
    private ConnectionType mConnectionType;
    private final PairingPresenter$mDefaultDfuProgressListener$1 mDefaultDfuProgressListener;
    private DeviceInfoInteractorInput mDeviceInfoInteractor;
    private DfuState mDfuState;
    private FirebaseMessageInteractor mFirebaseMessageInteractor = new FirebaseMessageInteractor();
    private boolean mIsCheckingDfuModelName;
    /* access modifiers changed from: private */
    public boolean mIsDfuSuccess;
    private boolean mIsTagUpdate;
    private String mLocalFirmwareReversion;
    private String mModelName;
    private ModelType mModelType;
    private final PairingRouter mRouter;
    private String mSerialNumber;
    private final SettingInfoInteractorInput mSettingInfoInteractor;
    /* access modifiers changed from: private */
    public SuspendReason mSuspendReason;
    private TagDfuInteractor mTagDfuInteractor;
    /* access modifiers changed from: private */
    public final TagInfoInteractorInput mTagInfoInteractor;
    private final TagScanInteractor mTagScanInteractor;
    private TagWriteInteractorInput mTagWriteInteractor;
    private UserInfoInteractorInput mUserInfoInteractor;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        /* JADX WARNING: Can't wrap try/catch for region: R(68:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|33|34|35|36|37|38|(2:39|40)|41|(2:43|44)|45|(2:47|48)|49|51|52|(2:53|54)|55|57|58|59|60|(2:61|62)|63|65|66|67|68|69|70|(2:71|72)|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|91) */
        /* JADX WARNING: Can't wrap try/catch for region: R(69:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|33|34|35|36|37|38|(2:39|40)|41|(2:43|44)|45|(2:47|48)|49|51|52|(2:53|54)|55|57|58|59|60|(2:61|62)|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|91) */
        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|33|34|35|36|37|38|(2:39|40)|41|(2:43|44)|45|(2:47|48)|49|51|52|53|54|55|57|58|59|60|(2:61|62)|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|91) */
        /* JADX WARNING: Can't wrap try/catch for region: R(72:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|33|34|35|36|37|38|(2:39|40)|41|(2:43|44)|45|47|48|49|51|52|53|54|55|57|58|59|60|(2:61|62)|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|91) */
        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|33|34|35|36|37|38|(2:39|40)|41|43|44|45|47|48|49|51|52|53|54|55|57|58|59|60|(2:61|62)|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|91) */
        /* JADX WARNING: Can't wrap try/catch for region: R(77:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|(2:23|24)|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|47|48|49|51|52|53|54|55|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|91) */
        /* JADX WARNING: Can't wrap try/catch for region: R(79:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|47|48|49|51|52|53|54|55|57|58|59|60|61|62|63|65|66|67|68|69|70|71|72|73|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|91) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00b1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00d4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00ed */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00f5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00fd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0116 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x011e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x0126 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x012e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0136 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x013e */
        static {
            /*
                jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult[] r0 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.CompareResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult r2 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.CompareResult.SAME     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult r3 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.CompareResult.ASCENDING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult r4 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.CompareResult.DESCENDING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult r5 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.CompareResult.INVALID     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$DfuState[] r0 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.DfuState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$DfuState r5 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.DfuState.DFU_FINISHED     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$DfuState r5 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.DfuState.DFU_GOING     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$DfuState r5 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.DfuState.DFU_FAILED     // Catch:{ NoSuchFieldError -> 0x004c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$DfuState r5 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.DfuState.DFU_VERIFYING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$1 = r0
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$ConnectionType[] r0 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.ConnectionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$ConnectionType r5 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.ConnectionType.NORMAL     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$ConnectionType r5 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.ConnectionType.DFU     // Catch:{ NoSuchFieldError -> 0x006d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                $EnumSwitchMapping$2 = r0
                jp.co.sony.reonpocket.constant.BleConnStatusCode[] r0 = jp.co.sony.reonpocket.constant.BleConnStatusCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.BleConnStatusCode r5 = jp.co.sony.reonpocket.constant.BleConnStatusCode.CONNECTED     // Catch:{ NoSuchFieldError -> 0x007e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r5 = jp.co.sony.reonpocket.constant.BleConnStatusCode.DFU_MODE     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r5 = jp.co.sony.reonpocket.constant.BleConnStatusCode.PERMISSION_MISS_LOCATION     // Catch:{ NoSuchFieldError -> 0x008e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r5 = jp.co.sony.reonpocket.constant.BleConnStatusCode.PERMISSION_MISS_BLUETOOTH     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                r5 = 5
                jp.co.sony.reonpocket.constant.BleConnStatusCode r6 = jp.co.sony.reonpocket.constant.BleConnStatusCode.PERMISSION_MISS_UNEXPECTED     // Catch:{ NoSuchFieldError -> 0x009f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                r6 = 6
                jp.co.sony.reonpocket.constant.BleConnStatusCode r7 = jp.co.sony.reonpocket.constant.BleConnStatusCode.SERVICE_DISCOVERED     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                r7 = 7
                jp.co.sony.reonpocket.constant.BleConnStatusCode r8 = jp.co.sony.reonpocket.constant.BleConnStatusCode.CONNECT_SUSPENDED     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r0[r8] = r7     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                jp.co.sony.reonpocket.constant.BleConnStatusCode r8 = jp.co.sony.reonpocket.constant.BleConnStatusCode.CONNECT_FAILED     // Catch:{ NoSuchFieldError -> 0x00bb }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bb }
                r9 = 8
                r0[r8] = r9     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                $EnumSwitchMapping$3 = r0
                jp.co.sony.reonpocket.constant.BleActionCode[] r0 = jp.co.sony.reonpocket.constant.BleActionCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.BleActionCode r8 = jp.co.sony.reonpocket.constant.BleActionCode.WRITE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r0[r8] = r1     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                jp.co.sony.reonpocket.constant.BleActionCode r8 = jp.co.sony.reonpocket.constant.BleActionCode.NOTIFY     // Catch:{ NoSuchFieldError -> 0x00d4 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d4 }
                r0[r8] = r2     // Catch:{ NoSuchFieldError -> 0x00d4 }
            L_0x00d4:
                jp.co.sony.reonpocket.constant.BleActionCode r8 = jp.co.sony.reonpocket.constant.BleActionCode.READ     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r0[r8] = r3     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                $EnumSwitchMapping$4 = r0
                jp.co.sony.reonpocket.constant.DeviceModeActionCode[] r0 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r8 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MANUAL     // Catch:{ NoSuchFieldError -> 0x00ed }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ed }
                r0[r8] = r1     // Catch:{ NoSuchFieldError -> 0x00ed }
            L_0x00ed:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r8 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.AUTO     // Catch:{ NoSuchFieldError -> 0x00f5 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r0[r8] = r2     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r8 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MY     // Catch:{ NoSuchFieldError -> 0x00fd }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fd }
                r0[r8] = r3     // Catch:{ NoSuchFieldError -> 0x00fd }
            L_0x00fd:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r8 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x0105 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0105 }
                r0[r8] = r4     // Catch:{ NoSuchFieldError -> 0x0105 }
            L_0x0105:
                $EnumSwitchMapping$5 = r0
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem[] r0 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r8 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.FEEDBACK     // Catch:{ NoSuchFieldError -> 0x0116 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0116 }
                r0[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0116 }
            L_0x0116:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.INFORMATION     // Catch:{ NoSuchFieldError -> 0x011e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x011e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x011e }
            L_0x011e:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.SUPPORT_PAGE     // Catch:{ NoSuchFieldError -> 0x0126 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0126 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0126 }
            L_0x0126:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.LEGAL     // Catch:{ NoSuchFieldError -> 0x012e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012e }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x012e }
            L_0x012e:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.USER_INFO     // Catch:{ NoSuchFieldError -> 0x0136 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0136 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0136 }
            L_0x0136:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_REGISTER     // Catch:{ NoSuchFieldError -> 0x013e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x013e }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x013e }
            L_0x013e:
                jp.co.sony.reonpocket.view.adapter.SettingItemAdapter$SettingItem r1 = jp.co.sony.reonpocket.view.adapter.SettingItemAdapter.SettingItem.TAG_UNREGISTER     // Catch:{ NoSuchFieldError -> 0x0146 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0146 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x0146 }
            L_0x0146:
                $EnumSwitchMapping$6 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.WhenMappings.<clinit>():void");
        }
    }

    public void tagAlwaysScan() {
    }

    public PairingPresenter(Context context, PairingViewInput pairingViewInput, FirebaseAnalytics firebaseAnalytics) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "aFirebaseAnalytics");
        this.aContext = context;
        this.aView = pairingViewInput;
        this.aFirebaseAnalytics = firebaseAnalytics;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.pairing.view.PairingActivity");
        this.mRouter = new PairingRouter((PairingActivity) context);
        this.mConnectionType = ConnectionType.NORMAL;
        this.mDefaultDfuProgressListener = new PairingPresenter$mDefaultDfuProgressListener$1(this);
        this.mBleInteractor = new BleInteractor();
        this.mDeviceInfoInteractor = new DeviceInfoInteractor();
        this.mUserInfoInteractor = new UserInfoInteractor();
        this.mTagInfoInteractor = new TagInfoInteractor();
        this.mTagDfuInteractor = new TagDfuInteractor(context, this);
        this.mDfuState = DfuState.NONE;
        this.mSuspendReason = SuspendReason.NONE;
        this.mModelType = ModelType.RNP1;
        this.mBundleWhenTransitToMain = new Bundle();
        this.mIsDfuSuccess = true;
        this.mSettingInfoInteractor = new SettingInfoInteractor();
        this.mTagScanInteractor = new TagScanInteractor(context);
        this.mTagWriteInteractor = new TagWriteInteractor(context, this);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$Companion;", "", "()V", "CAPABILITY_MIN_LENGTH", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$NextPage;", "", "(Ljava/lang/String;I)V", "NONE", "PAIRING_START", "PAIRING_COMPLETE", "DFU_START", "DFU_GOING", "DFU_COMPLETE", "MAIN", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public enum NextPage {
        NONE,
        PAIRING_START,
        PAIRING_COMPLETE,
        DFU_START,
        DFU_GOING,
        DFU_COMPLETE,
        MAIN;

        public static EnumEntries<NextPage> getEntries() {
            return $ENTRIES;
        }

        static {
            NextPage[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$ConnectionType;", "", "(Ljava/lang/String;I)V", "NORMAL", "DFU", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public enum ConnectionType {
        NORMAL,
        DFU;

        public static EnumEntries<ConnectionType> getEntries() {
            return $ENTRIES;
        }

        static {
            ConnectionType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$DfuState;", "", "(Ljava/lang/String;I)V", "NONE", "DFU_FINISHED", "DFU_FAILED", "DFU_GOING", "DFU_VERIFYING", "DFU_VERIFY_DONE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public enum DfuState {
        NONE,
        DFU_FINISHED,
        DFU_FAILED,
        DFU_GOING,
        DFU_VERIFYING,
        DFU_VERIFY_DONE;

        public static EnumEntries<DfuState> getEntries() {
            return $ENTRIES;
        }

        static {
            DfuState[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$SuspendReason;", "", "(Ljava/lang/String;I)V", "NONE", "WRITE_DFU_FAIL", "FORCE_UPDATE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public enum SuspendReason {
        NONE,
        WRITE_DFU_FAIL,
        FORCE_UPDATE;

        public static EnumEntries<SuspendReason> getEntries() {
            return $ENTRIES;
        }

        static {
            SuspendReason[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$ModelType;", "", "(Ljava/lang/String;I)V", "RNP1", "RNP1L", "RNP1A", "RNP2", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingPresenter.kt */
    public enum ModelType {
        RNP1,
        RNP1L,
        RNP1A,
        RNP2;

        public static EnumEntries<ModelType> getEntries() {
            return $ENTRIES;
        }

        static {
            ModelType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public void onCreate() {
        this.mBleInteractor.onCreate(this.aContext);
        this.mBleInteractor.registerDfuProgressListener(this.aContext);
        this.mTagScanInteractor.setListener(new PairingPresenter$onCreate$1(this));
        this.mTagScanInteractor.setNoReceivingListener(new PairingPresenter$onCreate$2(this));
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
        this.mTagScanInteractor.release();
    }

    public void onResume() {
        tagAlwaysScan();
    }

    public void onPause() {
        super.onPause();
        if (isTagRegistered()) {
            this.mTagScanInteractor.stopNoReceiving();
        }
    }

    public final void openDeviceTempNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY, (String) null, true, 2, (Object) null);
    }

    private final void openAuthentication() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTHENTICATION, (String) null, true, 2, (Object) null);
    }

    public void connect() {
        Unit unit;
        this.mBleInteractor.setConnectCallbackListener(new PairingPresenter$connect$1(this));
        this.mConnectionType = ConnectionType.NORMAL;
        String macAddress = this.mDeviceInfoInteractor.getMacAddress(this.aContext);
        if (macAddress != null) {
            if (macAddress.length() > 0) {
                BleInteractorInput.DefaultImpls.scanConnect$default(this.mBleInteractor, this.aContext, macAddress, ModelConstant.INSTANCE.getModelNames(), (String[]) null, (String) null, UuidHelperUtil.INSTANCE.getOwnerId(this.aContext), 24, (Object) null);
            } else {
                BleInteractorInput.DefaultImpls.scanConnect$default(this.mBleInteractor, this.aContext, (String) null, ModelConstant.INSTANCE.getModelNames(), (String[]) null, (String) null, UuidHelperUtil.INSTANCE.getOwnerId(this.aContext), 26, (Object) null);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            BleInteractorInput.DefaultImpls.scanConnect$default(this.mBleInteractor, this.aContext, (String) null, ModelConstant.INSTANCE.getModelNames(), (String[]) null, (String) null, UuidHelperUtil.INSTANCE.getOwnerId(this.aContext), 26, (Object) null);
        }
    }

    public void setDfuState(DfuState dfuState) {
        Intrinsics.checkNotNullParameter(dfuState, "aIsDfu");
        this.mDfuState = dfuState;
    }

    public void disconnect() {
        this.mBleInteractor.disconnect();
    }

    public void writeRequestDfu() {
        BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_REQUEST_DFU, (String) null, new byte[]{-1}, 2, (Object) null);
    }

    private final void startDfu(Context context, String str) {
        this.mBleInteractor.executeDfu(context, str, this.mDefaultDfuProgressListener);
    }

    private final void registerActionCallbackListener() {
        this.mBleInteractor.setDataReceivedCallbackListener(new PairingPresenter$registerActionCallbackListener$1(this));
    }

    private final void readDeviceName() {
        this.mIsCheckingDfuModelName = true;
        this.mBleInteractor.read(GattProfileConstant.CHARACTERISTIC_DEVICE_NAME, GattProfileConstant.SERVICE_GENERIC_ACCESS);
    }

    private final void readModelName() {
        this.mBleInteractor.read(GattProfileConstant.CHARACTERISTIC_MODEL_NUMBER, GattProfileConstant.SERVICE_DEVICE_INFORMATION);
    }

    /* access modifiers changed from: private */
    public final void handleDfuModelName(BleDataEntity bleDataEntity) {
        byte[] data = bleDataEntity.getData();
        if (data != null) {
            char[] cArr = new char[data.length];
            int length = data.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                cArr[i2] = (char) data[i];
                i++;
                i2++;
            }
            String str = new String(cArr);
            this.mModelName = str;
            if (str.length() <= 0 || !ArraysKt.contains((T[]) ModelConstant.INSTANCE.getDfuModelNames(), str)) {
                handleDataError("device model name's format error");
                return;
            }
            startDfu(this.aContext, str);
            if (Unit.INSTANCE == null) {
                handleDataError("device model name's format error");
                return;
            }
            DebugLogUtil.INSTANCE.d("device model name:" + this.mModelName);
            this.mIsCheckingDfuModelName = false;
            return;
        }
        this.mIsCheckingDfuModelName = false;
        handleDataError("device model name's format error");
    }

    private final void writeOwner() {
        byte[] bArr = new SetOwnerEntity((OwnerStatus) null, this.mUserInfoInteractor.getOwnerID(this.aContext), 1, (DefaultConstructorMarker) null).toByte();
        if (bArr == null) {
            handleDataError(BaseActivityKt.ERROR_UNEXPECTED);
        } else {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_OWNER, (String) null, bArr, 2, (Object) null);
        }
    }

    private final void writeTagRegister() {
        readFirmwareReversion();
        this.isCheckTagWriteRegister = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void writeTagRegister(jp.co.sony.reonpocket.data.entity.BleDataEntity r12) {
        /*
            r11 = this;
            java.lang.String r0 = "2.1.3"
            r11.mLocalFirmwareReversion = r0
            byte[] r12 = r12.getData()
            java.lang.String r0 = "firmware reversion format"
            r1 = 0
            if (r12 == 0) goto L_0x00df
            int r2 = r12.length
            char[] r2 = new char[r2]
            int r3 = r12.length
            r4 = 0
            r5 = r4
        L_0x0013:
            if (r4 >= r3) goto L_0x0020
            byte r6 = r12[r4]
            int r7 = r5 + 1
            char r6 = (char) r6
            r2[r5] = r6
            int r4 = r4 + 1
            r5 = r7
            goto L_0x0013
        L_0x0020:
            jp.co.sony.reonpocket.util.DebugLogUtil r12 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            java.lang.String r4 = "device firmware reversion:"
            java.lang.String r3 = r4.concat(r3)
            r12.d(r3)
            jp.co.sony.reonpocket.util.DebugLogUtil r12 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r3 = r11.mLocalFirmwareReversion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "local firmware reversion:"
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r12.d(r3)
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x0054 }
            r12.<init>(r2)     // Catch:{ Exception -> 0x0054 }
            jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput r2 = r11.mDeviceInfoInteractor     // Catch:{ Exception -> 0x0052 }
            android.content.Context r3 = r11.aContext     // Catch:{ Exception -> 0x0052 }
            r2.saveFirmRevision(r3, r12)     // Catch:{ Exception -> 0x0052 }
            goto L_0x005c
        L_0x0052:
            r2 = move-exception
            goto L_0x0056
        L_0x0054:
            r2 = move-exception
            r12 = r1
        L_0x0056:
            r2.printStackTrace()
            r11.handleDataError(r0)
        L_0x005c:
            if (r12 != 0) goto L_0x0062
            r11.readModelName()
            return
        L_0x0062:
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil r2 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.INSTANCE
            boolean r2 = r2.isValidFirm(r12)
            if (r2 != 0) goto L_0x006e
            r11.readModelName()
            return
        L_0x006e:
            java.lang.String r2 = r11.mLocalFirmwareReversion
            if (r2 == 0) goto L_0x00df
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil r1 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult r12 = r1.compareVersionIgnoreBuildVersion(r2, r12)
            int[] r1 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.WhenMappings.$EnumSwitchMapping$0
            int r12 = r12.ordinal()
            r12 = r1[r12]
            r1 = 1
            if (r12 != r1) goto L_0x00db
            jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput r12 = r11.mTagInfoInteractor
            android.content.Context r1 = r11.aContext
            java.lang.String r12 = r12.getTagBDAddress(r1)
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "error_unexpected"
            if (r1 == 0) goto L_0x00bd
            int r1 = r1.length()
            if (r1 != 0) goto L_0x009c
            goto L_0x00bd
        L_0x009c:
            jp.co.sony.reonpocket.data.entity.AuthenticationTagEntity r1 = new jp.co.sony.reonpocket.data.entity.AuthenticationTagEntity
            jp.co.sony.reonpocket.constant.TagStatus r3 = jp.co.sony.reonpocket.constant.TagStatus.REGISTER
            jp.co.sony.reonpocket.constant.TagDeviceType r4 = jp.co.sony.reonpocket.constant.TagDeviceType.REON_TAG
            r1.<init>(r3, r12, r4)
            byte[] r8 = r1.toByte()
            if (r8 != 0) goto L_0x00af
            r11.handleDataError(r2)
            return
        L_0x00af:
            jp.co.sony.reonpocket.data.interactor.BleInteractorInput r5 = r11.mBleInteractor
            r9 = 2
            r10 = 0
            java.lang.String r6 = "1506"
            r7 = 0
            jp.co.sony.reonpocket.data.interactor.BleInteractorInput.DefaultImpls.write$default(r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            r1 = r12
            goto L_0x00df
        L_0x00bd:
            jp.co.sony.reonpocket.data.entity.AuthenticationTagUnregisterEntity r12 = new jp.co.sony.reonpocket.data.entity.AuthenticationTagUnregisterEntity
            jp.co.sony.reonpocket.constant.TagStatus r0 = jp.co.sony.reonpocket.constant.TagStatus.UNREGISTER
            jp.co.sony.reonpocket.constant.TagDeviceType r1 = jp.co.sony.reonpocket.constant.TagDeviceType.REON_TAG
            r12.<init>(r0, r1)
            byte[] r6 = r12.toByte()
            if (r6 != 0) goto L_0x00d0
            r11.handleDataError(r2)
            return
        L_0x00d0:
            jp.co.sony.reonpocket.data.interactor.BleInteractorInput r3 = r11.mBleInteractor
            r7 = 2
            r8 = 0
            java.lang.String r4 = "1506"
            r5 = 0
            jp.co.sony.reonpocket.data.interactor.BleInteractorInput.DefaultImpls.write$default(r3, r4, r5, r6, r7, r8)
            return
        L_0x00db:
            r11.readModelName()
            return
        L_0x00df:
            if (r1 != 0) goto L_0x00e4
            r11.handleDataError(r0)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.writeTagRegister(jp.co.sony.reonpocket.data.entity.BleDataEntity):void");
    }

    private final void writeAuthentication(AuthenticationEntity authenticationEntity) {
        byte[] bArr = authenticationEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTHENTICATION, (String) null, bArr, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void readSerialNumber() {
        this.mBleInteractor.read(GattProfileConstant.CHARACTERISTIC_SERIAL_NUMBER, GattProfileConstant.SERVICE_DEVICE_INFORMATION);
    }

    private final void readFirmwareReversion() {
        this.mBleInteractor.read(GattProfileConstant.CHARACTERISTIC_FIRMWARE_REVISION, GattProfileConstant.SERVICE_DEVICE_INFORMATION);
    }

    private final void readCapability() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_CAPABILITY, (String) null, 2, (Object) null);
    }

    private final void setCurrentTime() {
        long time = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime().getTime() / ((long) 1000);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
        byte[] createWriteBytes = BleDataEntity.Companion.createWriteBytes((int) time, 20, byteOrder);
        BleDataEntity.Companion companion = BleDataEntity.Companion;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        Intrinsics.checkNotNullExpressionValue(byteOrder2, "LITTLE_ENDIAN");
        BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_CURRENT_TIME, (String) null, ArraysKt.plus(createWriteBytes, companion.createWriteBytes(-new Date().getTimezoneOffset(), 34, byteOrder2)), 2, (Object) null);
    }

    private final void readDeviceMode() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, 2, (Object) null);
    }

    private final void openDeviceModeNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, true, 2, (Object) null);
    }

    private final void readBattery() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_BATTERY, (String) null, 2, (Object) null);
    }

    private final void openBatteryNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_BATTERY, (String) null, true, 2, (Object) null);
    }

    private final void openAlertNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_ALERT, (String) null, true, 2, (Object) null);
    }

    private final void readBoost() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_BOOST, (String) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onConnectionStatus(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        PairingViewInput pairingViewInput;
        switch (WhenMappings.$EnumSwitchMapping$3[bleConnStatusCode.ordinal()]) {
            case 1:
                AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this.aContext, this.aFirebaseAnalytics, AnalyticsUtil.EventName.BLE_PAIRING_COMPLETE, (Bundle) null, 8, (Object) null);
                return;
            case 2:
                readDeviceName();
                return;
            case 3:
            case 4:
            case 5:
                PairingViewInput pairingViewInput2 = this.aView;
                if (pairingViewInput2 != null) {
                    pairingViewInput2.requestPermissionDialog(bleConnStatusCode);
                    return;
                }
                return;
            case 6:
                registerActionCallbackListener();
                if (BleInteractor.Companion.isDFUMode()) {
                    readDeviceName();
                    return;
                } else {
                    writeOwner();
                    return;
                }
            case 7:
                if (BleInteractor.Companion.isDFUMode()) {
                    PairingViewInput pairingViewInput3 = this.aView;
                    if (pairingViewInput3 != null) {
                        pairingViewInput3.doDfu();
                        return;
                    }
                    return;
                }
                int i = WhenMappings.$EnumSwitchMapping$1[this.mDfuState.ordinal()];
                if (i == 1) {
                    AnalyticsUtil.INSTANCE.logEventWithString(this.aContext, this.aFirebaseAnalytics, AnalyticsUtil.EventName.FIRMWARE_UPDATE_COMPLETE, AnalyticsUtil.EventParameter.FW_VERSION, UpdateVersionConstant.REON_FIRMWARE_VERSION);
                    PairingViewInput pairingViewInput4 = this.aView;
                    if (pairingViewInput4 != null) {
                        PairingViewInput.DefaultImpls.onNextPage$default(pairingViewInput4, NextPage.DFU_COMPLETE.ordinal(), (String) null, (Bundle) null, 6, (Object) null);
                    }
                    this.mDfuState = DfuState.NONE;
                    return;
                } else if (i == 2) {
                    PairingViewInput pairingViewInput5 = this.aView;
                    if (pairingViewInput5 != null) {
                        pairingViewInput5.onFail(BaseActivityKt.ERROR_DFU_FAIL);
                        return;
                    }
                    return;
                } else if (i == 3) {
                    PairingViewInput pairingViewInput6 = this.aView;
                    if (pairingViewInput6 != null) {
                        pairingViewInput6.onFail(BaseActivityKt.ERROR_DFU_FAIL);
                        return;
                    }
                    return;
                } else if (this.mSuspendReason != SuspendReason.FORCE_UPDATE && this.mSuspendReason != SuspendReason.WRITE_DFU_FAIL && (pairingViewInput = this.aView) != null) {
                    pairingViewInput.onFail(BaseActivityKt.ERROR_CONNECTION_STATE_WITHOUT_UNREGISTER);
                    return;
                } else {
                    return;
                }
            case 8:
                int i2 = WhenMappings.$EnumSwitchMapping$2[this.mConnectionType.ordinal()];
                if (i2 == 1) {
                    AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this.aContext, this.aFirebaseAnalytics, AnalyticsUtil.EventName.BLE_PAIRING_FAILURE, (Bundle) null, 8, (Object) null);
                    setDfuState(DfuState.DFU_VERIFYING);
                    PairingViewInput pairingViewInput7 = this.aView;
                    if (pairingViewInput7 != null) {
                        pairingViewInput7.tryConnectDfu();
                        return;
                    }
                    return;
                } else if (i2 == 2) {
                    PairingViewInput pairingViewInput8 = this.aView;
                    if (pairingViewInput8 != null) {
                        pairingViewInput8.onFail(BaseActivityKt.ERROR_CONNECTION_STATE_WITHOUT_UNREGISTER);
                    }
                    this.mConnectionType = ConnectionType.NORMAL;
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            int i = 0;
            switch (characteristicUuid.hashCode()) {
                case 1512230:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_CURRENT_TIME)) {
                        PairingViewInput pairingViewInput = this.aView;
                        if (pairingViewInput != null) {
                            PairingViewInput.DefaultImpls.onNextPage$default(pairingViewInput, NextPage.PAIRING_COMPLETE.ordinal(), this.mModelName, (Bundle) null, 4, (Object) null);
                        }
                        PairingRouter pairingRouter = this.mRouter;
                        String str = this.mModelName;
                        Intrinsics.checkNotNull(str);
                        pairingRouter.goToPairingComplete(str);
                        this.mBundleWhenTransitToMain.clear();
                        openAuthentication();
                        return;
                    }
                    return;
                case 1512231:
                    BleDataEntity bleDataEntity2 = bleDataEntity;
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_DEVICE_MODE)) {
                        handleDeviceMode(bleDataEntity);
                        return;
                    }
                    return;
                case 1512232:
                    characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_REQUEST_DFU);
                    return;
                case 1512234:
                    BleDataEntity bleDataEntity3 = bleDataEntity;
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_AUTHENTICATION)) {
                        int i2 = WhenMappings.$EnumSwitchMapping$4[bleDataEntity.getAction().ordinal()];
                        if (i2 == 1) {
                            handleTagRegister(bleDataEntity);
                            return;
                        } else if (i2 == 2) {
                            readDeviceMode();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 1512277:
                    BleDataEntity bleDataEntity4 = bleDataEntity;
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_OWNER)) {
                        handleOwner(bleDataEntity);
                        return;
                    }
                    return;
                case 1512476:
                    BleDataEntity bleDataEntity5 = bleDataEntity;
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_CAPABILITY)) {
                        handleCapability(bleDataEntity);
                        return;
                    }
                    return;
                case 1512477:
                    BleDataEntity bleDataEntity6 = bleDataEntity;
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY)) {
                        handleDeviceTemp(bleDataEntity);
                        return;
                    }
                    return;
                case 1512478:
                    BleDataEntity bleDataEntity7 = bleDataEntity;
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_BATTERY)) {
                        handleBattery(bleDataEntity);
                        return;
                    }
                    return;
                case 1512481:
                    BleDataEntity bleDataEntity8 = bleDataEntity;
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_BOOST)) {
                        handleBoost(bleDataEntity);
                        return;
                    }
                    return;
                case 1584303:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_DEVICE_NAME) && this.mIsCheckingDfuModelName) {
                        if (WhenMappings.$EnumSwitchMapping$1[this.mDfuState.ordinal()] == 4) {
                            this.mSettingInfoInteractor.compareFirmRevisionWithServer(new PairingPresenter$onDataReceived$1(this, bleDataEntity));
                            return;
                        }
                        BleDataEntity bleDataEntity9 = bleDataEntity;
                        PairingViewInput pairingViewInput2 = this.aView;
                        if (pairingViewInput2 != null) {
                            PairingViewInput.DefaultImpls.onNextPage$default(pairingViewInput2, NextPage.DFU_GOING.ordinal(), (String) null, (Bundle) null, 6, (Object) null);
                        }
                        handleDfuModelName(bleDataEntity);
                        return;
                    }
                    return;
                case 1584369:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_MODEL_NUMBER)) {
                        byte[] data = bleDataEntity.getData();
                        if (data != null) {
                            char[] cArr = new char[data.length];
                            int length = data.length;
                            int i3 = 0;
                            while (i < length) {
                                int i4 = i3 + 1;
                                char c = (char) data[i];
                                cArr[i3] = c;
                                if (c == 'L') {
                                    this.mModelType = ModelType.RNP1L;
                                }
                                if (c == 'A') {
                                    this.mModelType = ModelType.RNP1A;
                                }
                                if (c == '2') {
                                    this.mModelType = ModelType.RNP2;
                                }
                                i++;
                                i3 = i4;
                            }
                            String str2 = new String(cArr);
                            this.mModelName = str2;
                            DeviceInfoInteractorInput deviceInfoInteractorInput = this.mDeviceInfoInteractor;
                            Context context = this.aContext;
                            Intrinsics.checkNotNull(str2);
                            deviceInfoInteractorInput.saveDeviceName(context, str2);
                            AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
                            Context context2 = this.aContext;
                            FirebaseAnalytics firebaseAnalytics = this.aFirebaseAnalytics;
                            String str3 = this.mModelName;
                            Intrinsics.checkNotNull(str3);
                            analyticsUtil.setUserProperty(context2, firebaseAnalytics, str3, AnalyticsUtil.PropertyName.DEVICE_MODEL);
                            ModelConstant modelConstant = ModelConstant.INSTANCE;
                            String str4 = this.mModelName;
                            Intrinsics.checkNotNull(str4);
                            String topicName = modelConstant.getTopicName(str4);
                            if (topicName != null) {
                                String topic = this.mUserInfoInteractor.getTopic(this.aContext);
                                if (this.mFirebaseMessageInteractor.isNeedUpdateTopic(this.aContext, topicName)) {
                                    if (topic.length() > 0) {
                                        this.mFirebaseMessageInteractor.unsubscribeFromTopic(this.aContext, topic);
                                    }
                                    this.mFirebaseMessageInteractor.subscribeToTopic(this.aContext, topicName);
                                }
                            }
                            DebugLogUtil.INSTANCE.d("device model name:" + this.mModelName);
                            readSerialNumber();
                            return;
                        }
                        handleDataError("device model name's format error");
                        return;
                    }
                    return;
                case 1584370:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_SERIAL_NUMBER)) {
                        byte[] data2 = bleDataEntity.getData();
                        if (data2 != null) {
                            char[] cArr2 = new char[data2.length];
                            int length2 = data2.length;
                            int i5 = 0;
                            while (i < length2) {
                                cArr2[i5] = (char) data2[i];
                                i++;
                                i5++;
                            }
                            this.mSerialNumber = new String(cArr2);
                            DebugLogUtil.INSTANCE.d("device serial number:" + this.mSerialNumber);
                        } else {
                            DebugLogUtil.INSTANCE.w("device serial number is null");
                        }
                        registerDeviceInfo();
                        this.mLocalFirmwareReversion = UpdateVersionConstant.REON_FIRMWARE_VERSION;
                        readFirmwareReversion();
                        return;
                    }
                    return;
                case 1584371:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_FIRMWARE_REVISION)) {
                        if (!this.isCheckTagWriteRegister) {
                            handleFirmwareReversion(bleDataEntity);
                            return;
                        }
                        this.isCheckTagWriteRegister = false;
                        writeTagRegister(bleDataEntity);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            BleDataEntity bleDataEntity10 = bleDataEntity;
            String characteristicUuid2 = bleDataEntity.getCharacteristicUuid();
            switch (characteristicUuid2.hashCode()) {
                case 1512230:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_CURRENT_TIME)) {
                        handleDataError("set current time");
                        return;
                    }
                    return;
                case 1512231:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_DEVICE_MODE)) {
                        handleDataError("device mode");
                        return;
                    }
                    return;
                case 1512232:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_REQUEST_DFU)) {
                        if (bleDataEntity.getResponseCode() == ResponseCode.DFU_BATTERY_LEVEL_NOT_ENOUGH) {
                            this.mSuspendReason = SuspendReason.WRITE_DFU_FAIL;
                            handleDataError(BaseActivityKt.ERROR_DFU_FAIL_DUE_TO_LOW_BATTERY);
                            return;
                        }
                        handleDataError("request dfu error");
                        return;
                    }
                    return;
                case 1512277:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_OWNER)) {
                        if (bleDataEntity.getResponseCode() == ResponseCode.INVALID_STATE) {
                            handleDataError(BaseActivityKt.ERROR_INVALID_OWNER);
                            return;
                        } else {
                            handleDataError(BaseActivityKt.ERROR_UNEXPECTED);
                            return;
                        }
                    } else {
                        return;
                    }
                case 1512476:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_CAPABILITY)) {
                        handleDataError("read capability");
                        return;
                    }
                    return;
                case 1512478:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_BATTERY)) {
                        handleDataError("battery");
                        return;
                    }
                    return;
                case 1512481:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_BOOST)) {
                        handleDataError("read boost setting");
                        return;
                    }
                    return;
                case 1584303:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_DEVICE_NAME)) {
                        handleDataError("read device name");
                        return;
                    }
                    return;
                case 1584369:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_MODEL_NUMBER)) {
                        handleDataError("read device model name");
                        return;
                    }
                    return;
                case 1584370:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_SERIAL_NUMBER)) {
                        DebugLogUtil.INSTANCE.e("data error:read serial number");
                        this.mLocalFirmwareReversion = UpdateVersionConstant.REON_FIRMWARE_VERSION;
                        readFirmwareReversion();
                        return;
                    }
                    return;
                case 1584371:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_FIRMWARE_REVISION)) {
                        handleDataError("read device firmware version");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void handleDeviceTemp(BleDataEntity bleDataEntity) {
        if (bleDataEntity.getData() != null) {
            SensorDataEntity object = SensorDataEntity.Companion.getObject(bleDataEntity);
            if (object instanceof NotifyTagSensorDataEntity) {
                ThreadUtils.runOnUiThread(new PairingPresenter$$ExternalSyntheticLambda0(this, object));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void handleDeviceTemp$lambda$24(PairingPresenter pairingPresenter, SensorDataEntity sensorDataEntity) {
        Intrinsics.checkNotNullParameter(pairingPresenter, "this$0");
        PairingViewInput pairingViewInput = pairingPresenter.aView;
        if (pairingViewInput != null) {
            pairingViewInput.updateTagMiniInfoView(pairingPresenter.isTagRegistered(), (NotifyTagSensorDataEntity) sensorDataEntity);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleFirmwareReversion(jp.co.sony.reonpocket.data.entity.BleDataEntity r9) {
        /*
            r8 = this;
            java.lang.String r0 = "2.1.3"
            r8.mLocalFirmwareReversion = r0
            byte[] r9 = r9.getData()
            java.lang.String r0 = "firmware reversion format"
            r1 = 0
            if (r9 == 0) goto L_0x00c6
            int r2 = r9.length
            char[] r2 = new char[r2]
            int r3 = r9.length
            r4 = 0
            r5 = r4
        L_0x0013:
            if (r4 >= r3) goto L_0x0020
            byte r6 = r9[r4]
            int r7 = r5 + 1
            char r6 = (char) r6
            r2[r5] = r6
            int r4 = r4 + 1
            r5 = r7
            goto L_0x0013
        L_0x0020:
            jp.co.sony.reonpocket.util.DebugLogUtil r9 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            java.lang.String r4 = "device firmware reversion:"
            java.lang.String r3 = r4.concat(r3)
            r9.d(r3)
            jp.co.sony.reonpocket.util.DebugLogUtil r9 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r3 = r8.mLocalFirmwareReversion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "local firmware reversion:"
            r4.<init>(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r9.d(r3)
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x0054 }
            r9.<init>(r2)     // Catch:{ Exception -> 0x0054 }
            jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput r2 = r8.mDeviceInfoInteractor     // Catch:{ Exception -> 0x0052 }
            android.content.Context r3 = r8.aContext     // Catch:{ Exception -> 0x0052 }
            r2.saveFirmRevision(r3, r9)     // Catch:{ Exception -> 0x0052 }
            goto L_0x005c
        L_0x0052:
            r2 = move-exception
            goto L_0x0056
        L_0x0054:
            r2 = move-exception
            r9 = r1
        L_0x0056:
            r2.printStackTrace()
            r8.handleDataError(r0)
        L_0x005c:
            if (r9 != 0) goto L_0x0062
            r8.handleDataError(r0)
            return
        L_0x0062:
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil r2 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.INSTANCE
            boolean r2 = r2.isValidFirm(r9)
            if (r2 != 0) goto L_0x006e
            r8.handleDataError(r0)
            return
        L_0x006e:
            java.lang.String r2 = r8.mLocalFirmwareReversion
            if (r2 == 0) goto L_0x00c6
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil r3 = jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            jp.co.sony.reonpocket.util.SoftwareVersionCompareUtil$CompareResult r9 = r3.compareVersionIgnoreBuildVersion(r2, r9)
            int[] r2 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r2[r9]
            r2 = 1
            if (r9 == r2) goto L_0x00c1
            r2 = 2
            if (r9 == r2) goto L_0x00b0
            r2 = 3
            if (r9 == r2) goto L_0x009b
            r1 = 4
            if (r9 != r1) goto L_0x0095
            r8.handleDataError(r0)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x00c6
        L_0x0095:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L_0x009b:
            jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput r9 = r8.aView
            if (r9 == 0) goto L_0x00c6
            jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$NextPage r1 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.NextPage.DFU_START
            int r2 = r1.ordinal()
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            r1 = r9
            jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput.DefaultImpls.onNextPage$default(r1, r2, r3, r4, r5, r6)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x00c6
        L_0x00b0:
            jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter$SuspendReason r9 = jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.SuspendReason.FORCE_UPDATE
            r8.mSuspendReason = r9
            r8.disconnect()
            jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput r9 = r8.aView
            if (r9 == 0) goto L_0x00c6
            r9.requestForAppUpdate()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x00c6
        L_0x00c1:
            r8.readCapability()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x00c6:
            if (r1 != 0) goto L_0x00cb
            r8.handleDataError(r0)
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter.handleFirmwareReversion(jp.co.sony.reonpocket.data.entity.BleDataEntity):void");
    }

    private final void handleCapability(BleDataEntity bleDataEntity) {
        CapabilityEntity object = CapabilityEntity.Companion.toObject(bleDataEntity);
        if (object == null) {
            handleDataError("capability format");
            return;
        }
        this.mDeviceInfoInteractor.saveCapability(this.aContext, object);
        setCurrentTime();
    }

    private final void setTemperatureModeInfo(BleDataEntity bleDataEntity) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        Unit unit4;
        Unit unit5;
        Unit unit6;
        Integer targetTemp;
        SmartModePreference heatPreference;
        SmartModePreference coolPreference;
        CurrentCoolHeatTypeCode tempCurrentCoolHeatType;
        TemperatureCoolHeatTypeCode tempCoolHeatType;
        DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
        if (object == null) {
            DebugLogUtil.INSTANCE.e("ble data format");
            return;
        }
        DeviceModeEntity.Temperature temperatureEntity = object.getTemperatureEntity();
        Unit unit7 = null;
        if (temperatureEntity == null || (tempCoolHeatType = temperatureEntity.getTempCoolHeatType()) == null) {
            unit = null;
        } else {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_MODE_TEMPERATURE, tempCoolHeatType.getCode());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            handleDataError("device mode's cool/heat format");
            return;
        }
        DeviceModeEntity.Temperature temperatureEntity2 = object.getTemperatureEntity();
        if (temperatureEntity2 == null || (tempCurrentCoolHeatType = temperatureEntity2.getTempCurrentCoolHeatType()) == null) {
            unit2 = null;
        } else {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_MODE_ON_OFF, tempCurrentCoolHeatType.getCode());
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            handleDataError("device mode's cool/heat format");
            return;
        }
        DeviceModeEntity.Temperature temperatureEntity3 = object.getTemperatureEntity();
        if (temperatureEntity3 == null || (coolPreference = temperatureEntity3.getCoolPreference()) == null) {
            unit3 = null;
        } else {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_COOL_MODE_PREFERENCE, coolPreference.getCode());
            unit3 = Unit.INSTANCE;
        }
        if (unit3 == null) {
            handleDataError("device mode's temp format");
            return;
        }
        DeviceModeEntity.Temperature temperatureEntity4 = object.getTemperatureEntity();
        if (temperatureEntity4 == null || (heatPreference = temperatureEntity4.getHeatPreference()) == null) {
            unit4 = null;
        } else {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_HEAT_MODE_PREFERENCE, heatPreference.getCode());
            unit4 = Unit.INSTANCE;
        }
        if (unit4 == null) {
            handleDataError("device mode's heat temp format");
            return;
        }
        DeviceModeEntity.Temperature temperatureEntity5 = object.getTemperatureEntity();
        if (temperatureEntity5 == null || (targetTemp = temperatureEntity5.getTargetTemp()) == null) {
            unit5 = null;
        } else {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_TARGET_TEMPERATURE, targetTemp.intValue());
            unit5 = Unit.INSTANCE;
        }
        if (unit5 == null) {
            handleDataError("device mode's temp format");
            return;
        }
        DeviceModeEntity.Temperature temperatureEntity6 = object.getTemperatureEntity();
        if (temperatureEntity6 != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_COOL_MODE_USER_TEMPERATURE, temperatureEntity6.getTempCoolWrite());
            unit6 = Unit.INSTANCE;
        } else {
            unit6 = null;
        }
        if (unit6 == null) {
            handleDataError("device mode's temp format");
            return;
        }
        DeviceModeEntity.Temperature temperatureEntity7 = object.getTemperatureEntity();
        if (temperatureEntity7 != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_SMART_HEAT_MODE_USER_TEMPERATURE, temperatureEntity7.getTempHeatWrite());
            unit7 = Unit.INSTANCE;
        }
        if (unit7 == null) {
            handleDataError("device mode's heat temp format");
        }
    }

    private final void handleDeviceMode(BleDataEntity bleDataEntity) {
        Unit unit;
        DeviceModeActionCode mode;
        boolean z;
        int i = WhenMappings.$EnumSwitchMapping$4[bleDataEntity.getAction().ordinal()];
        if (i != 2) {
            if (i == 3) {
                DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
                if (object == null || (mode = object.getMode()) == null) {
                    unit = null;
                } else {
                    this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_MODE, mode.getCode());
                    int i2 = WhenMappings.$EnumSwitchMapping$5[mode.ordinal()];
                    if (i2 == 1) {
                        z = setManualInfo(bleDataEntity);
                    } else if (i2 != 2) {
                        if (i2 == 3) {
                            setMyModeInfo(bleDataEntity);
                        } else if (i2 == 4) {
                            setTemperatureModeInfo(bleDataEntity);
                        }
                        z = false;
                    } else {
                        z = setAutoInfo(bleDataEntity);
                    }
                    if (!z) {
                        openDeviceModeNotification();
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    handleDataError("device mode format");
                }
            }
        } else if (bleDataEntity.getData() == null) {
            readBattery();
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void handleBattery(BleDataEntity bleDataEntity) {
        Unit unit;
        BatteryChargeStatus batteryChargeStatus;
        Unit unit2;
        PowerSupplyStatus powerSupplyStatus;
        Unit unit3;
        int i = WhenMappings.$EnumSwitchMapping$4[bleDataEntity.getAction().ordinal()];
        if (i != 2) {
            if (i == 3) {
                Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
                Unit unit4 = null;
                if (intValue$default != null) {
                    int intValue = intValue$default.intValue();
                    if ((intValue < 0 || intValue >= 101) && intValue != 255) {
                        handleDataError("battery's level format");
                        return;
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    handleDataError("battery's level format");
                    return;
                }
                Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
                int i2 = 0;
                if (intValue$default2 != null) {
                    intValue$default2.intValue();
                    BatteryChargeStatus[] values = BatteryChargeStatus.values();
                    int length = values.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            batteryChargeStatus = null;
                            break;
                        }
                        batteryChargeStatus = values[i3];
                        int code = batteryChargeStatus.getCode();
                        if (intValue$default2 != null && code == intValue$default2.intValue()) {
                            break;
                        }
                        i3++;
                    }
                    if (batteryChargeStatus != null) {
                        unit3 = Unit.INSTANCE;
                    } else {
                        unit3 = null;
                        batteryChargeStatus = null;
                    }
                    if (unit3 == null) {
                        handleDataError("battery's charge status format");
                        return;
                    }
                    unit2 = Unit.INSTANCE;
                } else {
                    unit2 = null;
                    batteryChargeStatus = null;
                }
                if (unit2 == null) {
                    handleDataError("battery's charge status format");
                    return;
                }
                Integer intValue$default3 = BleDataEntity.getIntValue$default(bleDataEntity, 17, 2, (ByteOrder) null, 4, (Object) null);
                if (intValue$default3 != null) {
                    intValue$default3.intValue();
                    PowerSupplyStatus[] values2 = PowerSupplyStatus.values();
                    int length2 = values2.length;
                    while (true) {
                        if (i2 >= length2) {
                            powerSupplyStatus = null;
                            break;
                        }
                        powerSupplyStatus = values2[i2];
                        int code2 = powerSupplyStatus.getCode();
                        if (intValue$default3 != null && code2 == intValue$default3.intValue()) {
                            break;
                        }
                        i2++;
                    }
                    if (powerSupplyStatus != null) {
                        unit4 = Unit.INSTANCE;
                    } else {
                        powerSupplyStatus = null;
                    }
                    if (unit4 == null) {
                        handleDataError("battery's charge status format");
                        return;
                    }
                    unit4 = Unit.INSTANCE;
                } else {
                    powerSupplyStatus = null;
                }
                if (unit4 == null) {
                    handleDataError("battery's charge status format");
                    return;
                }
                Integer intValue$default4 = BleDataEntity.getIntValue$default(bleDataEntity, 18, 3, (ByteOrder) null, 4, (Object) null);
                if (intValue$default4 != null) {
                    intValue$default4.intValue();
                    this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_LEVEL, intValue$default.intValue());
                    Bundle bundle = this.mBundleWhenTransitToMain;
                    Intrinsics.checkNotNull(batteryChargeStatus);
                    bundle.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_CHARGE, batteryChargeStatus.getCode());
                    DeviceInfoInteractorInput deviceInfoInteractorInput = this.mDeviceInfoInteractor;
                    Context context = this.aContext;
                    Intrinsics.checkNotNull(powerSupplyStatus);
                    deviceInfoInteractorInput.saveVbusStatusCode(context, powerSupplyStatus.getCode());
                    this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_POWER_SUPPLY, powerSupplyStatus.getCode());
                    this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BATTERY_REMAIN_TIME, intValue$default4.intValue());
                    openBatteryNotification();
                    return;
                }
                handleDataError("battery's remain time format");
            }
        } else if (bleDataEntity.getData() == null) {
            readBoost();
            Unit unit5 = Unit.INSTANCE;
        }
    }

    private final void handleOwner(BleDataEntity bleDataEntity) {
        String ownerID = this.mUserInfoInteractor.getOwnerID(this.aContext);
        if (ownerID != null) {
            AnalyticsUtil.INSTANCE.setUserID(this.aContext, this.aFirebaseAnalytics, ownerID);
        }
        this.mDeviceInfoInteractor.saveMacAddress(this.aContext, String.valueOf(BleInteractor.Companion.getMMacAddress()));
        writeTagRegister();
    }

    private final void handleTagRegister(BleDataEntity bleDataEntity) {
        if (!this.isTagScanning) {
            readModelName();
        } else if (((AuthenticationTagEntity) AuthenticationEntity.Companion.getObject(bleDataEntity)) == null) {
            this.isTagScanning = false;
        } else {
            this.isTagScanning = false;
        }
    }

    private final void handleBoost(BleDataEntity bleDataEntity) {
        Unit unit;
        Unit unit2 = null;
        Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 18, 0, (ByteOrder) null, 4, (Object) null);
        if (intValue$default != null) {
            int intValue = intValue$default.intValue();
            if (intValue < 0 || intValue >= 65536) {
                handleDataError("boost totalTime's format");
                return;
            } else {
                this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BOOST_TOTAL_TIME, intValue);
                unit = Unit.INSTANCE;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            handleDataError("boost totalTime's format");
            return;
        }
        Integer intValue$default2 = BleDataEntity.getIntValue$default(bleDataEntity, 18, 2, (ByteOrder) null, 4, (Object) null);
        if (intValue$default2 != null) {
            int intValue2 = intValue$default2.intValue();
            if (intValue2 < 0 || intValue2 >= 65536) {
                handleDataError("boost remainTime's format");
                return;
            } else {
                this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BOOST_REMAIN_TIME, intValue2);
                unit2 = Unit.INSTANCE;
            }
        }
        if (unit2 == null) {
            handleDataError("boost remainTime's format");
            return;
        }
        openAlertNotification();
        PairingViewInput pairingViewInput = this.aView;
        if (pairingViewInput != null) {
            pairingViewInput.changeOkBtnState(true);
        }
    }

    public void transitToMain() {
        AnalyticsUtil.logEventWithBundle$default(AnalyticsUtil.INSTANCE, this.aContext, this.aFirebaseAnalytics, AnalyticsUtil.EventName.BLE_CONNECT_COMPLETE, (Bundle) null, 8, (Object) null);
        this.mRouter.goToMain(this.mBundleWhenTransitToMain);
    }

    private final void registerDeviceInfo() {
        CharSequence charSequence;
        CharSequence charSequence2 = this.mSerialNumber;
        if (charSequence2 != null && charSequence2.length() != 0 && (charSequence = this.mModelName) != null && charSequence.length() != 0) {
            DeviceInfoInteractorInput deviceInfoInteractorInput = this.mDeviceInfoInteractor;
            Context context = this.aContext;
            String str = this.mModelName;
            Intrinsics.checkNotNull(str);
            deviceInfoInteractorInput.save(context, str, this.mSerialNumber, true, PairingPresenter$registerDeviceInfo$1.INSTANCE);
        }
    }

    private final boolean setManualInfo(BleDataEntity bleDataEntity) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        DebugLogUtil.INSTANCE.v("setManualInfo");
        DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
        if (object == null) {
            DebugLogUtil.INSTANCE.e("ble data format");
            return false;
        }
        CoolHeatTypeCode coolHeatType = object.getCoolHeatType();
        Unit unit4 = null;
        if (coolHeatType != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_COOL_HEAT, coolHeatType.getCode());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            handleDataError("device mode's cool/heat format");
            return true;
        }
        TempStepCode temperature = object.getTemperature();
        if (temperature != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_TEMPERATURE, temperature.getCode());
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            handleDataError("device mode's temp format");
            return true;
        }
        TempBoostOption boostOption = object.getBoostOption();
        if (boostOption != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BOOST, boostOption.getCode());
            unit3 = Unit.INSTANCE;
        } else {
            unit3 = null;
        }
        if (unit3 == null) {
            handleDataError("device mode's temp option format");
            return true;
        }
        TempWaveOption waveOption = object.getWaveOption();
        if (waveOption != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_WAVE, waveOption.getCode());
            unit4 = Unit.INSTANCE;
        }
        if (unit4 != null) {
            return false;
        }
        handleDataError("device mode's temp option format");
        return true;
    }

    private final boolean setAutoInfo(BleDataEntity bleDataEntity) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        DebugLogUtil.INSTANCE.v("setAutoInfo");
        DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
        if (object == null) {
            DebugLogUtil.INSTANCE.e("ble data format");
            return false;
        }
        CoolHeatTypeCode coolHeatType = object.getCoolHeatType();
        Unit unit4 = null;
        if (coolHeatType != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_COOL_HEAT, coolHeatType.getCode());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            handleDataError("device mode's cool/heat format");
            return true;
        }
        TempStepCode temperature = object.getTemperature();
        if (temperature != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_TEMPERATURE, temperature.getCode());
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            handleDataError("device mode's temp format");
            return true;
        }
        TempBoostOption boostOption = object.getBoostOption();
        if (boostOption != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_BOOST, boostOption.getCode());
            unit3 = Unit.INSTANCE;
        } else {
            unit3 = null;
        }
        if (unit3 == null) {
            handleDataError("device mode's temp option format");
            return true;
        }
        TempWaveOption waveOption = object.getWaveOption();
        if (waveOption != null) {
            this.mBundleWhenTransitToMain.putInt(PairingActivityKt.TRANSIT_TO_MAIN_WAVE, waveOption.getCode());
            unit4 = Unit.INSTANCE;
        }
        if (unit4 != null) {
            return false;
        }
        handleDataError("device mode's temp option format");
        return true;
    }

    private final boolean setMyModeInfo(BleDataEntity bleDataEntity) {
        DebugLogUtil.INSTANCE.v("setMyModeInfo");
        if (DeviceModeEntity.Companion.getObject(bleDataEntity) == null) {
            DebugLogUtil.INSTANCE.e("ble data format");
        }
        return false;
    }

    private final void handleDataError(String str) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("data error:" + str);
        disconnect();
        PairingViewInput pairingViewInput = this.aView;
        if (pairingViewInput != null) {
            pairingViewInput.onFail(str);
        }
    }

    public void setSuspendReason(SuspendReason suspendReason) {
        Intrinsics.checkNotNullParameter(suspendReason, "aReason");
        this.mSuspendReason = suspendReason;
    }

    public void connectDFU() {
        this.mBleInteractor.setConnectCallbackListener(new PairingPresenter$connectDFU$1(this));
        this.mConnectionType = ConnectionType.DFU;
        BleInteractorInput.DefaultImpls.scanConnect$default(this.mBleInteractor, this.aContext, (String) null, (String[]) null, ModelConstant.INSTANCE.getDfuModelNames(), (String) null, UuidHelperUtil.INSTANCE.getOwnerId(this.aContext), 22, (Object) null);
    }

    public void doForceUpdate() {
        this.mRouter.goToStore();
    }

    public boolean isTagRegistered() {
        String tagBDAddress = this.mTagInfoInteractor.getTagBDAddress(this.aContext);
        return tagBDAddress != null && tagBDAddress.length() > 0;
    }

    public void handleSettingMenuTapItem(SettingItemAdapter.SettingListItem settingListItem) {
        Intrinsics.checkNotNullParameter(settingListItem, "item");
        switch (WhenMappings.$EnumSwitchMapping$6[settingListItem.getType().ordinal()]) {
            case 1:
                PairingViewInput pairingViewInput = this.aView;
                if (pairingViewInput != null) {
                    pairingViewInput.hiddenSettingMenuDialog();
                }
                transitToUserFeedback();
                return;
            case 2:
                PairingViewInput pairingViewInput2 = this.aView;
                if (pairingViewInput2 != null) {
                    pairingViewInput2.hiddenSettingMenuDialog();
                }
                PairingViewInput pairingViewInput3 = this.aView;
                if (pairingViewInput3 != null) {
                    pairingViewInput3.showNoMessageProgress();
                }
                showNotification();
                return;
            case 3:
                PairingViewInput pairingViewInput4 = this.aView;
                if (pairingViewInput4 != null) {
                    pairingViewInput4.hiddenSettingMenuDialog();
                }
                transitToSupport();
                return;
            case 4:
                PairingViewInput pairingViewInput5 = this.aView;
                if (pairingViewInput5 != null) {
                    pairingViewInput5.hiddenSettingMenuDialog();
                }
                transitToLegal();
                return;
            case 5:
                PairingViewInput pairingViewInput6 = this.aView;
                if (pairingViewInput6 != null) {
                    pairingViewInput6.hiddenSettingMenuDialog();
                }
                transitToChangeUserInfo();
                return;
            case 6:
                PairingViewInput pairingViewInput7 = this.aView;
                if (pairingViewInput7 != null) {
                    pairingViewInput7.hiddenSettingMenuDialog();
                }
                PairingViewInput pairingViewInput8 = this.aView;
                if (pairingViewInput8 != null) {
                    pairingViewInput8.showTagRegisterDialog();
                    return;
                }
                return;
            case 7:
                PairingViewInput pairingViewInput9 = this.aView;
                if (pairingViewInput9 != null) {
                    pairingViewInput9.hiddenSettingMenuDialog();
                }
                PairingViewInput pairingViewInput10 = this.aView;
                if (pairingViewInput10 != null) {
                    pairingViewInput10.showTagUnRegisterDialog();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void transitToSupport() {
        this.mRouter.transitToSupport(this.aContext);
    }

    private final void transitToLegal() {
        this.mRouter.goToLegal();
    }

    private final void transitToChangeUserInfo() {
        this.mRouter.goToChangeUserInfo();
    }

    private final void transitToUserFeedback() {
        String mFeedBackUrl = RemoteConfigUtil.INSTANCE.getMFeedBackUrl();
        if (mFeedBackUrl != null) {
            this.mRouter.jump2Url(mFeedBackUrl);
        }
    }

    public void transitToEula() {
        this.mRouter.transitToEula(this.aContext);
    }

    public void transitToPrivacy() {
        this.mRouter.transitToPrivacy(this.aContext);
    }

    public void transitToOss() {
        this.mRouter.goToOss();
    }

    public void initUserInfo() {
        UserInfoEntity userInfo = this.mUserInfoInteractor.getUserInfo(this.aContext);
        PairingViewInput pairingViewInput = this.aView;
        if (pairingViewInput != null) {
            pairingViewInput.onUserInfoInit(userInfo.getGender(), userInfo.getAge(), userInfo.getHeight(), userInfo.getWight(), userInfo.getState());
        }
    }

    public void registerUserInfo(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "aUserInfoEntity");
        this.mUserInfoInteractor.saveUserInfo(this.aContext, userInfoEntity, false, new PairingPresenter$registerUserInfo$1(this));
    }

    public void showNotification() {
        NoticeUtil.INSTANCE.getNoticeImage(this.aContext, new PairingPresenter$showNotification$1(this));
    }

    public void tagScan() {
        this.isTagScanning = true;
        this.mBleInteractor.tagScan(this.aContext, new PairingPresenter$tagScan$1(this));
    }

    public void tagScanNoReceiving() {
        this.mTagScanInteractor.startNoReceiving();
    }

    /* access modifiers changed from: private */
    public final void onTagScanNoReceivingSuccess(TagDataEntity tagDataEntity) {
        if (!isTagRegistered()) {
            DebugLogUtil.INSTANCE.d("Stop Tag Data Scan");
            this.mTagScanInteractor.stopNoReceiving();
        } else if (this.isShowTagRegistDialog || this.mIsTagUpdate) {
            this.mTagScanInteractor.stopNoReceiving();
        } else if (tagDataEntity.getFwVersionCode() >= Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE) || tagDataEntity.getFwVersionCode() == 0) {
            PairingViewInput pairingViewInput = this.aView;
            if (pairingViewInput != null) {
                pairingViewInput.updateTagMiniInfoViewNoReceiving(isTagRegistered(), tagDataEntity);
            }
        } else {
            this.mIsTagUpdate = true;
            PairingViewInput pairingViewInput2 = this.aView;
            if (pairingViewInput2 != null) {
                pairingViewInput2.showTagUpdateMessage();
            }
            this.mTagScanInteractor.stopNoReceiving();
        }
    }

    /* access modifiers changed from: private */
    public final void onTagScanNoReceivingFailure() {
        if (!isTagRegistered()) {
            DebugLogUtil.INSTANCE.d("Stop Tag Data Scan");
            this.mTagScanInteractor.stopNoReceiving();
        }
    }

    /* access modifiers changed from: private */
    public final boolean isDeviceConnected() {
        return new BleManager(UuidHelperUtil.INSTANCE.getOwnerId(this.aContext)).hasConnectedToDevice();
    }

    /* access modifiers changed from: private */
    public final void registerTagBDAddress(TagStatus tagStatus, String str, TagDeviceType tagDeviceType) {
        writeAuthentication(new AuthenticationTagEntity(tagStatus, str, tagDeviceType));
    }

    public void unRegisterTag() {
        this.mTagInfoInteractor.removeTagInfo(this.aContext);
        this.mTagInfoInteractor.removeTagBDAddress(this.aContext);
        this.mTagInfoInteractor.removeTagModel(this.aContext);
    }

    public void setTagScanListener(TagScanInteractor.TagInfo tagInfo) {
        Intrinsics.checkNotNullParameter(tagInfo, "info");
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(12, 1);
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        this.mTagScanInteractor.setNotShowPopupTime(time, tagInfo);
    }

    public void registerTag(String str, TagDataEntity tagDataEntity) {
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        Intrinsics.checkNotNullParameter(tagDataEntity, "entity");
        this.mTagInfoInteractor.saveTagBDAddress(this.aContext, str);
        this.mTagInfoInteractor.saveTagInfo(this.aContext, tagDataEntity);
        registerTagBDAddress(TagStatus.REGISTER, str, TagDeviceType.REON_TAG);
    }

    public void transitToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity, TagDataEntity tagDataEntity) {
        this.mRouter.goToTagInfo(z, z2, notifyTagSensorDataEntity, tagDataEntity);
    }

    public void startTagDfu() {
        this.mTagDfuInteractor.startDfu();
    }

    public TagDataEntity getTagInfo() {
        return this.mTagInfoInteractor.getTagInfo(this.aContext);
    }

    public void updateDialogStatus(boolean z) {
        this.isShowTagRegistDialog = z;
    }

    public void onTagDfuComplete() {
        if (this.mIsTagUpdate) {
            TagDataEntity tagInfo = this.mTagInfoInteractor.getTagInfo(this.aContext);
            if (tagInfo != null) {
                TagDataEntity tagDataEntity = r2;
                TagDataEntity tagDataEntity2 = new TagDataEntity(Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE), tagInfo.getFormatVersion(), tagInfo.getSequenceNumber(), tagInfo.getTemperature(), tagInfo.getHumidity(), tagInfo.getIllumination(), tagInfo.getProximity(), tagInfo.getTempCorrection(), tagInfo.getHumiCorrection(), tagInfo.getCarryAroundStatus(), tagInfo.getIlluminationStatus(), tagInfo.getProximityStatus(), tagInfo.getBatteryLevel(), tagInfo.getSerialNo(), tagInfo.getBdAddress(), tagInfo.getAccelerationXAxis(), tagInfo.getAccelerationYAxis(), tagInfo.getAccelerationZAxis());
                this.mTagInfoInteractor.saveTagInfo(this.aContext, tagDataEntity);
            }
            PairingViewInput pairingViewInput = this.aView;
            if (pairingViewInput != null) {
                pairingViewInput.showTagDfuComplete();
            }
            this.mIsTagUpdate = false;
            return;
        }
        PairingViewInput pairingViewInput2 = this.aView;
        if (pairingViewInput2 != null) {
            pairingViewInput2.hiddenProgress();
        }
        PairingViewInput pairingViewInput3 = this.aView;
        if (pairingViewInput3 != null) {
            pairingViewInput3.hiddenTagDfuProgress();
        }
    }

    public void onTagDfuFailed(String str) {
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        if (this.mIsTagUpdate) {
            PairingViewInput pairingViewInput = this.aView;
            if (pairingViewInput != null) {
                pairingViewInput.showTagDfuFail();
            }
            this.mIsTagUpdate = false;
        }
    }

    public void onTagDfuProgressChanged(int i) {
        PairingViewInput pairingViewInput = this.aView;
        if (pairingViewInput != null) {
            pairingViewInput.updateTagDfuProgress(i);
        }
    }

    public void onTagDfuDeviceDisconnecting() {
        PairingViewInput pairingViewInput = this.aView;
        if (pairingViewInput != null) {
            pairingViewInput.showTagDfuDisconnect();
        }
    }

    public void onTagDfuProcessStarting() {
        PairingViewInput pairingViewInput = this.aView;
        if (pairingViewInput != null) {
            pairingViewInput.showTagDfuStarting();
        }
    }

    public void onTagWriteSuccess() {
        DebugLogUtil.INSTANCE.d("onTagWriteSuccess");
    }

    public void onTagWriteFailed() {
        DebugLogUtil.INSTANCE.d("onTagWriteFailed");
        PairingViewInput pairingViewInput = this.aView;
        if (pairingViewInput != null) {
            pairingViewInput.showTagRegistrationFailedDialog();
        }
        PairingViewInput pairingViewInput2 = this.aView;
        if (pairingViewInput2 != null) {
            pairingViewInput2.unRegisterTagStatus();
        }
        setCanReceiveTagConnectCallbackListener(false);
    }

    public boolean getOnWriteSetTagControlResult() {
        return this.mTagWriteInteractor.getOnWriteSetTagControlResult();
    }

    public void setCanReceiveTagConnectCallbackListener(boolean z) {
        this.mTagWriteInteractor.setCanReceiveTagConnectCallbackListener(z);
    }
}
