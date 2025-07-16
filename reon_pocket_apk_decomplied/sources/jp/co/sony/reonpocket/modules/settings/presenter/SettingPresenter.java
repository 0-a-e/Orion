package jp.co.sony.reonpocket.modules.settings.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.File;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import jp.co.sony.reon.android.ble.BleManager;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.connection.aws.S3FileManager;
import jp.co.sony.reonpocket.connection.aws.UserInfoEntity;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.NotifyAlertCode;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagStatus;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.AuthenticationEntity;
import jp.co.sony.reonpocket.data.entity.AuthenticationTagEntity;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractor;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractorOutput;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.base.view.BaseActivityKt;
import jp.co.sony.reonpocket.modules.main.presenter.MainPresenterKt;
import jp.co.sony.reonpocket.modules.settings.router.SettingRouter;
import jp.co.sony.reonpocket.modules.settings.view.SettingActivity;
import jp.co.sony.reonpocket.modules.settings.view.SettingViewInput;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.NotificationUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import jp.co.sony.reonpocket.util.UuidHelperUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\\B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010#H\u0016J\n\u0010'\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020 H\u0002J,\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u0002032\u001a\u00104\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u000105j\n\u0012\u0004\u0012\u00020#\u0018\u0001`6H\u0002J\b\u00107\u001a\u00020\u0018H\u0016J\u0010\u00108\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0002J\b\u00109\u001a\u00020\u0018H\u0016J\b\u0010:\u001a\u00020\u0018H\u0016J\b\u0010;\u001a\u00020\u0018H\u0016J\b\u0010<\u001a\u00020\u0018H\u0002J\b\u0010=\u001a\u00020\u0018H\u0002J\b\u0010>\u001a\u00020\u0018H\u0002J\b\u0010?\u001a\u00020\u0018H\u0002J \u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020#2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\u0018H\u0002J\u0010\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020 H\u0016J\b\u0010L\u001a\u00020\u0018H\u0016J\b\u0010M\u001a\u00020\u0018H\u0016J\b\u0010N\u001a\u00020\u0018H\u0016J\b\u0010O\u001a\u00020\u0018H\u0016J\b\u0010P\u001a\u00020\u0018H\u0016J\b\u0010Q\u001a\u00020\u0018H\u0016J\b\u0010R\u001a\u00020\u0018H\u0016J\b\u0010S\u001a\u00020\u0018H\u0016J\b\u0010T\u001a\u00020\u0018H\u0016J\b\u0010U\u001a\u00020\u0018H\u0016J\b\u0010V\u001a\u00020\u0018H\u0016J\u0010\u0010W\u001a\u00020\u00182\u0006\u0010X\u001a\u00020#H\u0016J\u0010\u0010Y\u001a\u00020\u00182\u0006\u0010X\u001a\u00020#H\u0016J\b\u0010Z\u001a\u00020\u0018H\u0016J\b\u0010[\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/presenter/SettingPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/settings/view/SettingActivity$SettingViewOutput;", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/settings/view/SettingViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/settings/view/SettingViewInput;)V", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractor;", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mInitSetting", "", "mRouter", "Ljp/co/sony/reonpocket/modules/settings/router/SettingRouter;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "mTagWriteInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorInput;", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "disConnect", "", "doDeviceUnregister", "downloadImage", "aEntity", "Ljp/co/sony/reonpocket/data/entity/NotificationEntity;", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getIsTagRegistered", "", "getOnWriteSetTagControlResult", "getTagFwVersion", "", "getTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "getTagModelName", "getUserFeedbackUrl", "handleAlert", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "handleAuthentication", "handleFirmwareReversion", "handleModelName", "initData", "initUserInfo", "isDeviceConnected", "onConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreate", "onDataReceived", "onDestroy", "onTagWriteFailed", "onTagWriteSuccess", "readFirmwareReversion", "readModelName", "registerActionCallbackListener", "registerConnectCallbackListener", "registerTag", "status", "Ljp/co/sony/reonpocket/constant/TagStatus;", "bdAddress", "deviceType", "Ljp/co/sony/reonpocket/constant/TagDeviceType;", "registerUserInfo", "aUserInfoEntity", "Ljp/co/sony/reonpocket/connection/aws/UserInfoEntity;", "removeLocalTagInfo", "setCanReceiveTagConnectCallbackListener", "value", "showNotification", "tagScan", "transitToAutoStart", "transitToBatteryNotification", "transitToChangeUserInfo", "transitToEula", "transitToLegal", "transitToOss", "transitToPrivacy", "transitToQuickLaunch", "transitToSupport", "transitToTwitter", "aUrl", "transitToUserFeedback", "unregisterTag", "writeInitialize", "SuspendReason", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingPresenter.kt */
public final class SettingPresenter extends BasePresenter implements SettingActivity.SettingViewOutput, TagWriteInteractorOutput {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Context aContext;
    /* access modifiers changed from: private */
    public final SettingViewInput aView;
    private final BleInteractor mBleInteractor = new BleInteractor();
    private DeviceInfoInteractorInput mDeviceInfoInteractor = new DeviceInfoInteractor();
    private final byte[] mInitSetting;
    private final SettingRouter mRouter;
    /* access modifiers changed from: private */
    public TagInfoInteractorInput mTagInfoInteractor = new TagInfoInteractor();
    private TagWriteInteractorInput mTagWriteInteractor;
    private UserInfoInteractorInput mUserInfoInteractor = new UserInfoInteractor();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                jp.co.sony.reonpocket.constant.AuthenticationType[] r0 = jp.co.sony.reonpocket.constant.AuthenticationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.AuthenticationType r1 = jp.co.sony.reonpocket.constant.AuthenticationType.OWNER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reonpocket.constant.AuthenticationType r1 = jp.co.sony.reonpocket.constant.AuthenticationType.TAG     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reonpocket.constant.AuthenticationType r1 = jp.co.sony.reonpocket.constant.AuthenticationType.OWNER_UNREGISTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.settings.presenter.SettingPresenter.WhenMappings.<clinit>():void");
        }
    }

    public SettingPresenter(Context context, SettingViewInput settingViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = settingViewInput;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.settings.view.SettingActivity");
        this.mRouter = new SettingRouter((SettingActivity) context);
        this.mInitSetting = new byte[]{-1};
        this.mTagWriteInteractor = new TagWriteInteractor(context, this);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/presenter/SettingPresenter$SuspendReason;", "", "(Ljava/lang/String;I)V", "NONE", "UNREGISTER", "INITIALIZATION", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SettingPresenter.kt */
    public enum SuspendReason {
        NONE,
        UNREGISTER,
        INITIALIZATION;

        public static EnumEntries<SuspendReason> getEntries() {
            return $ENTRIES;
        }

        static {
            SuspendReason[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public void onCreate() {
        this.mBleInteractor.onCreate(this.aContext);
        registerActionCallbackListener();
        registerConnectCallbackListener();
    }

    private final void registerConnectCallbackListener() {
        BleInteractor.Companion.setMConnectCallbackListener(new SettingPresenter$registerConnectCallbackListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void onConnectionStatus(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        SettingViewInput settingViewInput = this.aView;
        if (settingViewInput != null) {
            settingViewInput.onConnectionStatus(bleConnStatusCode, arrayList);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    private final void registerActionCallbackListener() {
        this.mBleInteractor.setMDataReceivedCallbackListener(new SettingPresenter$registerActionCallbackListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        SettingViewInput settingViewInput;
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            switch (characteristicUuid.hashCode()) {
                case 1512234:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_AUTHENTICATION)) {
                        handleAuthentication(bleDataEntity);
                        return;
                    }
                    return;
                case 1512236:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_INITIALIZE) && (settingViewInput = this.aView) != null) {
                        settingViewInput.onSuccess();
                        return;
                    }
                    return;
                case 1512482:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_ALERT)) {
                        handleAlert(bleDataEntity);
                        return;
                    }
                    return;
                case 1584369:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_MODEL_NUMBER)) {
                        handleModelName(bleDataEntity);
                        return;
                    }
                    return;
                case 1584371:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_FIRMWARE_REVISION)) {
                        handleFirmwareReversion(bleDataEntity);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            String characteristicUuid2 = bleDataEntity.getCharacteristicUuid();
            switch (characteristicUuid2.hashCode()) {
                case 1512234:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_AUTHENTICATION)) {
                        DebugLogUtil.INSTANCE.w("set authentication failed");
                        return;
                    }
                    return;
                case 1512236:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_INITIALIZE)) {
                        if (bleDataEntity.getResponseCode() == ResponseCode.INVALID_STATE) {
                            SettingViewInput settingViewInput2 = this.aView;
                            if (settingViewInput2 != null) {
                                settingViewInput2.onFail(BaseActivityKt.ERROR_OPERATE_WHEN_CHARGE);
                                return;
                            }
                            return;
                        }
                        SettingViewInput settingViewInput3 = this.aView;
                        if (settingViewInput3 != null) {
                            settingViewInput3.onFail("setting failed");
                            return;
                        }
                        return;
                    }
                    return;
                case 1584369:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_MODEL_NUMBER)) {
                        if (bleDataEntity.getResponseCode() == ResponseCode.INVALID_STATE) {
                            SettingViewInput settingViewInput4 = this.aView;
                            if (settingViewInput4 != null) {
                                settingViewInput4.onFail(BaseActivityKt.ERROR_OPERATE_WHEN_CHARGE);
                                return;
                            }
                            return;
                        }
                        SettingViewInput settingViewInput5 = this.aView;
                        if (settingViewInput5 != null) {
                            settingViewInput5.onFail("read failed");
                            return;
                        }
                        return;
                    }
                    return;
                case 1584371:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_FIRMWARE_REVISION)) {
                        if (bleDataEntity.getResponseCode() == ResponseCode.INVALID_STATE) {
                            SettingViewInput settingViewInput6 = this.aView;
                            if (settingViewInput6 != null) {
                                settingViewInput6.onFail(BaseActivityKt.ERROR_OPERATE_WHEN_CHARGE);
                                return;
                            }
                            return;
                        }
                        SettingViewInput settingViewInput7 = this.aView;
                        if (settingViewInput7 != null) {
                            settingViewInput7.onFail("read failed");
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void handleFirmwareReversion(BleDataEntity bleDataEntity) {
        Unit unit;
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
            SettingViewInput settingViewInput = this.aView;
            if (settingViewInput != null) {
                settingViewInput.updateFirmwareReversion(new String(cArr));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        SettingViewInput settingViewInput2 = this.aView;
        if (settingViewInput2 != null) {
            settingViewInput2.onFail("firmware reversion format");
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void handleModelName(BleDataEntity bleDataEntity) {
        SettingViewInput settingViewInput;
        byte[] data = bleDataEntity.getData();
        Unit unit = null;
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
            SettingViewInput settingViewInput2 = this.aView;
            if (settingViewInput2 != null) {
                settingViewInput2.updateModelName(new String(cArr));
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null && (settingViewInput = this.aView) != null) {
            settingViewInput.onFail("device model name's format error");
        }
    }

    private final void handleAuthentication(BleDataEntity bleDataEntity) {
        AuthenticationEntity object = AuthenticationEntity.Companion.getObject(bleDataEntity);
        AuthenticationTagEntity authenticationTagEntity = object instanceof AuthenticationTagEntity ? (AuthenticationTagEntity) object : null;
        if (authenticationTagEntity == null) {
            DebugLogUtil.INSTANCE.w("authentication format error");
            return;
        }
        if (bleDataEntity.getAction() == BleActionCode.WRITE && authenticationTagEntity.getStatus() == TagStatus.UNREGISTER) {
            removeLocalTagInfo();
            SettingViewInput settingViewInput = this.aView;
            if (settingViewInput != null) {
                settingViewInput.onUnregisteredTag();
            }
        }
        if (WhenMappings.$EnumSwitchMapping$0[authenticationTagEntity.getType().ordinal()] == 3) {
            BleInteractor.Companion.setMConnectCallbackListener((Function2<? super BleConnStatusCode, ? super ArrayList<String>, Unit>) null);
        }
    }

    public void initData() {
        Unit unit;
        SettingViewInput settingViewInput;
        SettingViewInput settingViewInput2;
        String stringValue = SimpleStorageUtil.INSTANCE.getStringValue(this.aContext, SimpleStorageUtil.REON_FIRM_REVISION);
        String stringValue2 = SimpleStorageUtil.INSTANCE.getStringValue(this.aContext, SimpleStorageUtil.REON_DEVICE_NAME);
        Unit unit2 = null;
        if (stringValue == null || (settingViewInput2 = this.aView) == null) {
            unit = null;
        } else {
            settingViewInput2.updateFirmwareReversion(stringValue);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            readFirmwareReversion();
        }
        if (!(stringValue2 == null || (settingViewInput = this.aView) == null)) {
            settingViewInput.updateModelName(stringValue2);
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            readModelName();
        }
    }

    private final void readModelName() {
        this.mBleInteractor.read(GattProfileConstant.CHARACTERISTIC_MODEL_NUMBER, GattProfileConstant.SERVICE_DEVICE_INFORMATION);
    }

    private final void readFirmwareReversion() {
        this.mBleInteractor.read(GattProfileConstant.CHARACTERISTIC_FIRMWARE_REVISION, GattProfileConstant.SERVICE_DEVICE_INFORMATION);
    }

    public void writeInitialize() {
        BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_INITIALIZE, (String) null, this.mInitSetting, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void registerTag(TagStatus tagStatus, String str, TagDeviceType tagDeviceType) {
        byte[] bArr = new AuthenticationTagEntity(tagStatus, str, tagDeviceType).toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTHENTICATION, (String) null, bArr, 2, (Object) null);
        }
    }

    private final void handleAlert(BleDataEntity bleDataEntity) {
        Integer intValue$default;
        if (bleDataEntity.getData() != null && (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null)) != null) {
            int intValue = intValue$default.intValue();
            if (intValue == NotifyAlertCode.CHARGING_LOW_BATTERY.getCode()) {
                SettingViewInput settingViewInput = this.aView;
                if (settingViewInput != null) {
                    settingViewInput.onFail(BaseActivityKt.ERROR_OPERATE_WHEN_NO_ENOUGH_BATTERY);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_LOW_TEMP.getCode()) {
                SettingViewInput settingViewInput2 = this.aView;
                if (settingViewInput2 != null) {
                    settingViewInput2.onFail(BaseActivityKt.ERROR_DEVICE_LOWTEMP);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_HIGH_TEMP.getCode()) {
                SettingViewInput settingViewInput3 = this.aView;
                if (settingViewInput3 != null) {
                    settingViewInput3.onFail(BaseActivityKt.ERROR_DEVICE_OVERHEAT);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_UNKNOWN.getCode()) {
                SettingViewInput settingViewInput4 = this.aView;
                if (settingViewInput4 != null) {
                    settingViewInput4.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE_UNKNOWN);
                }
            } else if (intValue == NotifyAlertCode.SHUTDOWN_BY_LOW_BATTERY.getCode()) {
                SettingViewInput settingViewInput5 = this.aView;
                if (settingViewInput5 != null) {
                    settingViewInput5.onFail(MainPresenterKt.BUNDLE_SHUTDOWN_BY_LOW_BATTERY);
                }
            } else if (intValue == NotifyAlertCode.STOP_BY_OVER_CURRENT.getCode()) {
                SettingViewInput settingViewInput6 = this.aView;
                if (settingViewInput6 != null) {
                    settingViewInput6.onFail(BaseActivityKt.ERROR_DEVICE_STOP);
                }
            } else if (intValue == NotifyAlertCode.INVALID_BATTERY_TEMP.getCode()) {
                SettingViewInput settingViewInput7 = this.aView;
                if (settingViewInput7 != null) {
                    settingViewInput7.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE);
                }
            } else if (intValue == NotifyAlertCode.STOP_BY_INVALID_FAN_RATE.getCode()) {
                SettingViewInput settingViewInput8 = this.aView;
                if (settingViewInput8 != null) {
                    settingViewInput8.onFail(BaseActivityKt.ERROR_DEVICE_FAN_INVALID);
                }
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_TEMP.getCode()) {
                SettingViewInput settingViewInput9 = this.aView;
                if (settingViewInput9 != null) {
                    settingViewInput9.onFail(BaseActivityKt.ERROR_DEVICE_LOWTEMP);
                }
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_FAN_TEMP.getCode()) {
                SettingViewInput settingViewInput10 = this.aView;
                if (settingViewInput10 != null) {
                    settingViewInput10.onFail(BaseActivityKt.ERROR_DEVICE_OVERHEAT);
                }
            } else if (intValue == NotifyAlertCode.HEAT_STOP_BY_INVALID_TEMP.getCode()) {
                SettingViewInput settingViewInput11 = this.aView;
                if (settingViewInput11 != null) {
                    settingViewInput11.onFail(BaseActivityKt.ERROR_TEMP);
                }
            } else if (intValue == NotifyAlertCode.VBUS_VOLTAGE_ABNORMALITY_DETECTED.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            } else if (intValue == NotifyAlertCode.USB_WATER_WET_DETECTION.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            } else if (intValue == NotifyAlertCode.USB_AROUND_WATER_WET_DETECTION.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            } else if (intValue == NotifyAlertCode.USB_AROUND_OVER_HEAT.getCode()) {
                NotificationUtil.notifyNotifyAlert(this.aContext, intValue);
            }
        }
    }

    public void disConnect() {
        this.mBleInteractor.disconnect();
    }

    public void showNotification() {
        SimpleDateFormat simpleDateFormat;
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            }
            Unit unit = null;
            if (TextUtils.isEmpty(mNotificationEntity.getDate()) || simpleDateFormat.parse(mNotificationEntity.getDate()).getTime() > System.currentTimeMillis()) {
                NotificationEntity mNotificationEntity2 = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
                if (mNotificationEntity2 != null) {
                    AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
                    Context context = this.aContext;
                    FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
                    analyticsUtil.logEventWithString(context, instance, AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, String.valueOf(mNotificationEntity2.getVersion()));
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    AnalyticsUtil analyticsUtil2 = AnalyticsUtil.INSTANCE;
                    Context context2 = this.aContext;
                    FirebaseAnalytics instance2 = FirebaseAnalytics.getInstance(context2);
                    Intrinsics.checkNotNullExpressionValue(instance2, "getInstance(...)");
                    analyticsUtil2.logEventWithString(context2, instance2, AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, AnalyticsUtil.ParameterConstants.NO_ID.getValue());
                }
                downloadImage(mNotificationEntity);
                unit = Unit.INSTANCE;
            } else {
                SettingViewInput settingViewInput = this.aView;
                if (settingViewInput != null) {
                    settingViewInput.showErrorMessage(R.string.setting_no_information_title);
                    unit = Unit.INSTANCE;
                }
            }
            if (unit != null) {
                return;
            }
        }
        SettingViewInput settingViewInput2 = this.aView;
        if (settingViewInput2 != null) {
            settingViewInput2.showErrorMessage(R.string.setting_no_information_title);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void downloadImage(NotificationEntity notificationEntity) {
        String path = notificationEntity.getPath();
        if (path != null) {
            File file = new File(this.aContext.getApplicationContext().getCacheDir(), path);
            S3FileManager.INSTANCE.download(this.aContext, path, file, new SettingPresenter$downloadImage$1$1(this, notificationEntity, file));
            return;
        }
        SettingViewInput settingViewInput = this.aView;
        if (settingViewInput != null) {
            settingViewInput.showNotification(notificationEntity.getButtonPreference(), notificationEntity.getTitle(), notificationEntity.getSubtitle(), notificationEntity.getDescription(), notificationEntity.getUrl(), (Bitmap) null);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isDeviceConnected() {
        return new BleManager(UuidHelperUtil.INSTANCE.getOwnerId(this.aContext)).hasConnectedToDevice();
    }

    public void transitToOss() {
        this.mRouter.goToOss();
    }

    public void transitToLegal() {
        this.mRouter.goToLegal();
    }

    public void transitToAutoStart() {
        this.mRouter.goToAutoStart();
    }

    public void transitToQuickLaunch() {
        this.mRouter.goToQuickLaunch();
    }

    public void transitToSupport() {
        this.mRouter.transitToSupport(this.aContext);
    }

    public void transitToEula() {
        this.mRouter.transitToEula(this.aContext);
    }

    public void transitToChangeUserInfo() {
        this.mRouter.goToChangeUserInfo();
    }

    public void initUserInfo() {
        UserInfoEntity userInfo = this.mUserInfoInteractor.getUserInfo(this.aContext);
        SettingViewInput settingViewInput = this.aView;
        if (settingViewInput != null) {
            settingViewInput.onUserInfoInit(userInfo.getGender(), userInfo.getAge(), userInfo.getHeight(), userInfo.getWight(), userInfo.getState());
        }
    }

    public void registerUserInfo(UserInfoEntity userInfoEntity) {
        Intrinsics.checkNotNullParameter(userInfoEntity, "aUserInfoEntity");
        this.mUserInfoInteractor.saveUserInfo(this.aContext, userInfoEntity, false, new SettingPresenter$registerUserInfo$1(this));
    }

    public void transitToPrivacy() {
        this.mRouter.transitToPrivacy(this.aContext);
    }

    public CapabilityEntity getCapability() {
        return this.mDeviceInfoInteractor.getCapability(this.aContext);
    }

    public void transitToTwitter(String str) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        this.mRouter.goToTwitter(str);
    }

    public void transitToUserFeedback(String str) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        this.mRouter.jump2Url(str);
    }

    public String getUserFeedbackUrl() {
        return RemoteConfigUtil.INSTANCE.getMFeedBackUrl();
    }

    public void doDeviceUnregister() {
        String topic = this.mUserInfoInteractor.getTopic(this.aContext);
        if (topic.length() > 0) {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(topic).addOnCompleteListener(new SettingPresenter$$ExternalSyntheticLambda0(topic));
        }
        SimpleStorageUtil.INSTANCE.setStringValue(this.aContext, SimpleStorageUtil.REON_MAC_ADDRESS, "");
        disConnect();
        AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
        Context context = this.aContext;
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        AnalyticsUtil.logEventWithBundle$default(analyticsUtil, context, instance, AnalyticsUtil.EventName.DEVICE_UNREGISTER, (Bundle) null, 8, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void doDeviceUnregister$lambda$19(String str, Task task) {
        Intrinsics.checkNotNullParameter(str, "$localTopic");
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.e("unsubscribe topic:" + str + " failed");
        }
    }

    public void transitToBatteryNotification() {
        this.mRouter.goToBatteryNotification();
    }

    public boolean getIsTagRegistered() {
        CharSequence tagBDAddress = this.mTagInfoInteractor.getTagBDAddress(this.aContext);
        return !(tagBDAddress == null || tagBDAddress.length() == 0);
    }

    public void tagScan() {
        this.mBleInteractor.tagScan(this.aContext, new SettingPresenter$tagScan$1(this));
    }

    public String getTagModelName() {
        return this.mTagInfoInteractor.getTagModel(this.aContext);
    }

    public String getTagFwVersion() {
        return UpdateVersionConstant.TAG_FIRMWARE_VERSION;
    }

    private final void removeLocalTagInfo() {
        this.mTagInfoInteractor.removeTagInfo(this.aContext);
        this.mTagInfoInteractor.removeTagBDAddress(this.aContext);
        this.mTagInfoInteractor.removeTagModel(this.aContext);
    }

    public void unregisterTag() {
        byte[] bArr = new AuthenticationTagEntity(TagStatus.UNREGISTER, this.mTagInfoInteractor.getTagBDAddress(this.aContext), TagDeviceType.REON_TAG).toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTHENTICATION, (String) null, bArr, 2, (Object) null);
        }
    }

    public TagDataEntity getTagInfo() {
        return this.mTagInfoInteractor.getTagInfo(this.aContext);
    }

    public void onTagWriteSuccess() {
        DebugLogUtil.INSTANCE.d("onTagWriteSuccess");
        SettingViewInput settingViewInput = this.aView;
        if (settingViewInput != null) {
            settingViewInput.tagRegisteredSuccess();
        }
    }

    public void onTagWriteFailed() {
        DebugLogUtil.INSTANCE.d("onTagWriteFailed");
        SettingViewInput settingViewInput = this.aView;
        if (settingViewInput != null) {
            settingViewInput.tagRegisteredFailed();
        }
        removeLocalTagInfo();
        setCanReceiveTagConnectCallbackListener(false);
    }

    public boolean getOnWriteSetTagControlResult() {
        return this.mTagWriteInteractor.getOnWriteSetTagControlResult();
    }

    public void setCanReceiveTagConnectCallbackListener(boolean z) {
        this.mTagWriteInteractor.setCanReceiveTagConnectCallbackListener(z);
    }
}
