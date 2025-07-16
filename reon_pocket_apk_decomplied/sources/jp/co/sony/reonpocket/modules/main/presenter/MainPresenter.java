package jp.co.sony.reonpocket.modules.main.presenter;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jp.co.sony.reonpocket.connection.aws.S3FileManager;
import jp.co.sony.reonpocket.connection.ble.dfu.TagDfuInteractor;
import jp.co.sony.reonpocket.constant.AutoModeStatus;
import jp.co.sony.reonpocket.constant.AutoStartDeviceModeActionCode;
import jp.co.sony.reonpocket.constant.AutoStartOperationCode;
import jp.co.sony.reonpocket.constant.BatteryChargeStatus;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.ContinuousOperationStatus;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceCoolingCode;
import jp.co.sony.reonpocket.constant.DeviceInfoConstants;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.DeviceModeSettingTriggerCode;
import jp.co.sony.reonpocket.constant.FanStepCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.ModeCommonSettingOperation;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.constant.MyModeActionType;
import jp.co.sony.reonpocket.constant.MyModeOperationCode;
import jp.co.sony.reonpocket.constant.MyModeSpecialSubMode;
import jp.co.sony.reonpocket.constant.MyModeTypeCode;
import jp.co.sony.reonpocket.constant.MyTempStepCode;
import jp.co.sony.reonpocket.constant.NotifyAlertCode;
import jp.co.sony.reonpocket.constant.PowerSupplyStatus;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.constant.SmartModePreference;
import jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus;
import jp.co.sony.reonpocket.constant.TagDeviceType;
import jp.co.sony.reonpocket.constant.TagSensorDataReceivedStatus;
import jp.co.sony.reonpocket.constant.TagStatus;
import jp.co.sony.reonpocket.constant.TempBoostOption;
import jp.co.sony.reonpocket.constant.TempStepCode;
import jp.co.sony.reonpocket.constant.TempWaveOption;
import jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.TemperatureOnOffCode;
import jp.co.sony.reonpocket.constant.UpdateVersionConstant;
import jp.co.sony.reonpocket.data.entity.AuthenticationEntity;
import jp.co.sony.reonpocket.data.entity.AuthenticationTagEntity;
import jp.co.sony.reonpocket.data.entity.AuthenticationTagUnregisterEntity;
import jp.co.sony.reonpocket.data.entity.AutoStartEntity;
import jp.co.sony.reonpocket.data.entity.BatteryEntity;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.CapabilityEntity;
import jp.co.sony.reonpocket.data.entity.DeviceModeEntity;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.data.entity.NotifyDeviceSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.SensorDataEntity;
import jp.co.sony.reonpocket.data.entity.ThermoControlStatusEntity;
import jp.co.sony.reonpocket.data.entity.UsageEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.data.interactor.BleInteractor;
import jp.co.sony.reonpocket.data.interactor.BleInteractorInput;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.DeviceInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.TagInfoInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractor;
import jp.co.sony.reonpocket.data.interactor.TagScanInteractorCallbackListener;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractor;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractorInput;
import jp.co.sony.reonpocket.data.interactor.TagWriteInteractorOutput;
import jp.co.sony.reonpocket.data.interactor.UserBehaviorInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.base.view.BaseActivityKt;
import jp.co.sony.reonpocket.modules.main.router.MainRouter;
import jp.co.sony.reonpocket.modules.main.router.MainWireFrame;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.modules.main.view.MainPresenterTemporaryModel;
import jp.co.sony.reonpocket.modules.main.view.MainViewInput;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.CancelTimeActionNotificationReceiverModel;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.NotificationUtil;
import jp.co.sony.reonpocket.util.PermissionUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import jp.co.sony.reonpocket.util.RequestBLEPermissions;
import jp.co.sony.reonpocket.util.service.LaunchApplicationNotificationService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

@Metadata(d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Ä\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u00108\u001a\u00020\u000fH\u0002J\b\u00109\u001a\u00020:H\u0016J\u0006\u0010;\u001a\u00020:J\u0010\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020:H\u0016J \u0010@\u001a\u00020:2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020\u000fH\u0016J\b\u0010H\u001a\u00020IH\u0017J\b\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020\u000fH\u0016J\b\u0010M\u001a\u00020\u000fH\u0016J\b\u0010N\u001a\u00020\u000fH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016J\u0012\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020BH\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010R\u001a\u00020BH\u0002J\b\u0010U\u001a\u00020\rH\u0016J\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020\u000fH\u0016J\b\u0010[\u001a\u00020WH\u0016J\b\u0010\\\u001a\u00020YH\u0016J\u0010\u0010]\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010a\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010b\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010c\u001a\u00020:2\u0006\u0010d\u001a\u00020BH\u0002J\u0010\u0010e\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010f\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010g\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\b\u0010h\u001a\u00020\u000fH\u0016J\b\u0010i\u001a\u00020\u000fH\u0002J\b\u0010j\u001a\u00020\u000fH\u0016J\b\u0010k\u001a\u00020:H\u0016J\u0010\u0010l\u001a\u00020:2\u0006\u0010m\u001a\u00020\u000fH\u0016J \u0010n\u001a\u00020:2\u0006\u0010o\u001a\u00020p2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010rH\u0002J\b\u0010s\u001a\u00020:H\u0016J\u0010\u0010t\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\b\u0010u\u001a\u00020:H\u0016J\b\u0010v\u001a\u00020:H\u0016J\b\u0010w\u001a\u00020:H\u0016J\b\u0010x\u001a\u00020:H\u0016J\b\u0010y\u001a\u00020:H\u0016J\u0010\u0010z\u001a\u00020:2\u0006\u0010d\u001a\u00020BH\u0016J\b\u0010{\u001a\u00020:H\u0016J\u0010\u0010|\u001a\u00020:2\u0006\u0010}\u001a\u00020\rH\u0016J\b\u0010~\u001a\u00020:H\u0016J\b\u0010\u001a\u00020:H\u0016J\u0007\u0010\u0001\u001a\u00020:J\t\u0010\u0001\u001a\u00020:H\u0002J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\t\u0010\u0001\u001a\u00020:H\u0016J\u0007\u0010\u0001\u001a\u00020:J\t\u0010\u0001\u001a\u00020:H\u0002J\t\u0010\u0001\u001a\u00020:H\u0002J$\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020B2\u0007\u0010=\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020BH\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0011\u0010\u0001\u001a\u00020:2\u0006\u0010R\u001a\u00020IH\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\t\u0010\u0001\u001a\u00020:H\u0002J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0011\u0010\u0001\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020_H\u0002J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020WH\u0016J\u0012\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020YH\u0016J\u0012\u0010 \u0001\u001a\u00020:2\u0007\u0010¡\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010¢\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020WH\u0016J\u0012\u0010£\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020YH\u0016J\u0013\u0010¤\u0001\u001a\u00020:2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0016J\u0011\u0010§\u0001\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020_H\u0002J\u0011\u0010¨\u0001\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0002J\t\u0010©\u0001\u001a\u00020:H\u0016J\u001b\u0010ª\u0001\u001a\u00020:2\b\u0010«\u0001\u001a\u00030¬\u00012\u0006\u0010=\u001a\u00020>H\u0002J\t\u0010­\u0001\u001a\u00020\u000fH\u0002J\t\u0010®\u0001\u001a\u00020:H\u0016J\u0015\u0010¯\u0001\u001a\u00020:2\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\u001a\u0010²\u0001\u001a\u00020:2\t\u0010³\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0003\u0010´\u0001J\t\u0010µ\u0001\u001a\u00020:H\u0016J\t\u0010¶\u0001\u001a\u00020:H\u0016J\t\u0010·\u0001\u001a\u00020:H\u0016J&\u0010¸\u0001\u001a\u00020:2\u0007\u0010¹\u0001\u001a\u00020\u000f2\u0007\u0010º\u0001\u001a\u00020\u000f2\t\u0010=\u001a\u0005\u0018\u00010»\u0001H\u0016J\t\u0010¼\u0001\u001a\u00020:H\u0016J\u0012\u0010½\u0001\u001a\u00020:2\u0007\u0010¾\u0001\u001a\u00020\u000fH\u0016J\u0013\u0010¿\u0001\u001a\u00020:2\b\u0010À\u0001\u001a\u00030Á\u0001H\u0002J\u0012\u0010Â\u0001\u001a\u00020:2\u0007\u0010À\u0001\u001a\u00020>H\u0016J\t\u0010Ã\u0001\u001a\u00020:H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0018\u00010\u0017R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0001"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/presenter/MainPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$MainViewOutput;", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor$TagDfuOutput;", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/main/view/MainViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/main/view/MainViewInput;)V", "DAY_RANGE", "Lkotlin/ranges/LongRange;", "NO_SETTING_TEMPERATURE", "", "isShowTagRegistDialog", "", "mAutoStopArray", "", "Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;", "[Ljp/co/sony/reonpocket/constant/DeviceModeSettingTriggerCode;", "mBleInteractor", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "mCountDown", "Ljp/co/sony/reonpocket/modules/main/presenter/MainPresenter$CustomCountDown;", "mCurrentCoolHeatTypeCode", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "mCurrentFinTemperature", "", "mCurrentTemperature", "mDayFormat", "Ljava/text/SimpleDateFormat;", "mDefaultDuration", "mDefaultTempLevel", "mDefaultTimer", "mDeviceInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/DeviceInfoInteractorInput;", "mDeviceModeActionCode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "mIsCool", "mIsPermissionShown", "mIsTagUpdate", "mPaused", "mRouter", "Ljp/co/sony/reonpocket/modules/main/router/MainRouter;", "mTagDfuInteractor", "Ljp/co/sony/reonpocket/connection/ble/dfu/TagDfuInteractor;", "mTagInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagInfoInteractorInput;", "mTagScanInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor;", "mTagWriteInteractor", "Ljp/co/sony/reonpocket/data/interactor/TagWriteInteractorInput;", "mUserBehaviorInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserBehaviorInteractor;", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "checkNotification", "checkRemoteConfig", "", "closeDeviceTempNotification", "coolHeatTypeStatusChange", "entity", "Ljp/co/sony/reonpocket/data/entity/DeviceModeEntity;", "disconnect", "downloadImage", "aCountry", "", "aNotificationEntity", "Ljp/co/sony/reonpocket/data/entity/NotificationEntity;", "getAutoModeStatus", "Ljp/co/sony/reonpocket/constant/AutoModeStatus;", "getAutoStartState", "getAutoStopTime", "", "getCapability", "Ljp/co/sony/reonpocket/data/entity/CapabilityEntity;", "getIsRegisterTag", "getIsShownSmartCoolBefore", "getIsShownSmartWarmBefore", "getOnWriteSetTagControlResult", "getOption1ByValue", "Ljp/co/sony/reonpocket/constant/TempBoostOption;", "aValue", "getOption2ByValue", "Ljp/co/sony/reonpocket/constant/TempWaveOption;", "getPagePosition", "getSmartCoolPreference", "Ljp/co/sony/reonpocket/constant/SmartModePreference;", "getSmartCoolTempSwitchThreshold", "", "getSmartMixPreference", "getSmartWarmPreference", "getSmartWarmTempSwitchThreshold", "handleAlert", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "handleAuthentication", "handleAutoStart", "handleBattery", "handleDataError", "aErrorMessage", "handleDeviceMode", "handleDeviceTemp", "handleThermoStatus", "isConnected", "isShowReview", "isTagRegistered", "markAutoStartPopupShown", "markLocationPopup", "aIsShow", "onConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "onCreate", "onDataReceived", "onDestroy", "onPause", "onResume", "onTagDfuComplete", "onTagDfuDeviceDisconnecting", "onTagDfuFailed", "onTagDfuProcessStarting", "onTagDfuProgressChanged", "percent", "onTagWriteFailed", "onTagWriteSuccess", "openDeviceTempNotification", "openThermoStatusNotification", "readAutoStart", "readBattery", "readBoost", "readDeviceMode", "readDeviceTempNotification", "registerActionCallbackListener", "registerConnectCallbackListener", "registerTag", "bdAddress", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "deviceName", "saveAutoStartState", "aIsEnable", "saveAutoStopTime", "saveIsShownSmartCoolBefore", "aIsSmartShown", "saveIsShownSmartWarmBefore", "saveOperateTime", "savePagePosition", "aPos", "setAutoStart", "aIsOn", "setCanReceiveTagConnectCallbackListener", "value", "setDeviceMode", "setNextToastShow", "isNextShow", "setSmartCoolPreference", "aSmartPreference", "setSmartCoolTempSwitchThreshold", "setSmartMixPreference", "aIsCoolMode", "setSmartWarmPreference", "setSmartWarmTempSwitchThreshold", "setTagScanListener", "info", "Ljp/co/sony/reonpocket/data/interactor/TagScanInteractor$TagInfo;", "setTemperatureMode", "setUsageInfo", "startDfu", "startStopDurationNotification", "cause", "Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel$StopCauseMode;", "stopTimeCheck", "tagScan", "transitToConnection", "aBundle", "Landroid/os/Bundle;", "transitToDeviceInfo", "aErrorCode", "(Ljava/lang/Integer;)V", "transitToSetting", "transitToSplash", "transitToSupport", "transitToTagInfo", "isTagInfoReceiving", "isTagNoAmbientTemp", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "unregisterTag", "updateDialogStatus", "isShow", "writeAuthentication", "aEntity", "Ljp/co/sony/reonpocket/data/entity/AuthenticationEntity;", "writeDeviceMode", "writeDeviceModeOff", "CustomCountDown", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainPresenter.kt */
public final class MainPresenter extends BasePresenter implements MainActivity.MainViewOutput, TagDfuInteractor.TagDfuOutput, TagWriteInteractorOutput {
    public static final int $stable = 8;
    private final LongRange DAY_RANGE;
    private final int NO_SETTING_TEMPERATURE;
    private final Context aContext;
    /* access modifiers changed from: private */
    public final MainViewInput aView;
    private boolean isShowTagRegistDialog;
    private final DeviceModeSettingTriggerCode[] mAutoStopArray;
    private BleInteractorInput mBleInteractor = new BleInteractor();
    private CustomCountDown mCountDown;
    private CoolHeatTypeCode mCurrentCoolHeatTypeCode;
    private float mCurrentFinTemperature;
    private float mCurrentTemperature;
    private final SimpleDateFormat mDayFormat;
    private final int mDefaultDuration;
    private final int mDefaultTempLevel;
    private final int mDefaultTimer;
    private DeviceInfoInteractorInput mDeviceInfoInteractor;
    private DeviceModeActionCode mDeviceModeActionCode;
    private boolean mIsCool;
    private boolean mIsPermissionShown;
    private boolean mIsTagUpdate;
    /* access modifiers changed from: private */
    public boolean mPaused;
    private MainRouter mRouter;
    private TagDfuInteractor mTagDfuInteractor;
    private final TagInfoInteractorInput mTagInfoInteractor;
    private final TagScanInteractor mTagScanInteractor;
    private TagWriteInteractorInput mTagWriteInteractor;
    private UserBehaviorInteractor mUserBehaviorInteractor;
    private UserInfoInteractorInput mUserInfoInteractor;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainPresenter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;

        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|(2:15|16)|17|19|20|(2:21|22)|23|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|(2:39|40)|41|43|44|45|46|(2:47|48)|49|51|52|(2:53|54)|55|57|58|59|60|61|62|(2:63|64)|65|67|68|(2:69|70)|71|73) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|51|52|(2:53|54)|55|57|58|59|60|61|62|63|64|65|67|68|69|70|71|73) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|51|52|53|54|55|57|58|59|60|61|62|63|64|65|67|68|69|70|71|73) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|51|52|53|54|55|57|58|59|60|61|62|63|64|65|67|68|69|70|71|73) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00cb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00ec */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00f4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x010d */
        static {
            /*
                jp.co.sony.reonpocket.constant.AuthenticationType[] r0 = jp.co.sony.reonpocket.constant.AuthenticationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.constant.AuthenticationType r2 = jp.co.sony.reonpocket.constant.AuthenticationType.OWNER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reonpocket.constant.AuthenticationType r3 = jp.co.sony.reonpocket.constant.AuthenticationType.TAG     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                jp.co.sony.reonpocket.constant.AuthenticationType r4 = jp.co.sony.reonpocket.constant.AuthenticationType.OWNER_UNREGISTER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode[] r0 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode r4 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.COOL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                jp.co.sony.reonpocket.constant.CoolHeatTypeCode r4 = jp.co.sony.reonpocket.constant.CoolHeatTypeCode.HEAT     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus[] r0 = jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus r4 = jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus.WAIT_SWITCHING     // Catch:{ NoSuchFieldError -> 0x004c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus r4 = jp.co.sony.reonpocket.constant.SwitchCoolHeatWaitStatus.NORMAL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$2 = r0
                jp.co.sony.reonpocket.constant.DeviceModeActionCode[] r0 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r4 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MANUAL     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r4 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.AUTO     // Catch:{ NoSuchFieldError -> 0x006d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r4 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MY     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                r4 = 4
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r5 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.FAN     // Catch:{ NoSuchFieldError -> 0x007e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r5 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.MY_SETTING     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r5 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.TEMPERATURE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r6 = 6
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                jp.co.sony.reonpocket.constant.DeviceModeActionCode r5 = jp.co.sony.reonpocket.constant.DeviceModeActionCode.POWER_OFF     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r6 = 7
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                $EnumSwitchMapping$3 = r0
                jp.co.sony.reonpocket.constant.BleActionCode[] r0 = jp.co.sony.reonpocket.constant.BleActionCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.BleActionCode r5 = jp.co.sony.reonpocket.constant.BleActionCode.READ     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                jp.co.sony.reonpocket.constant.BleActionCode r5 = jp.co.sony.reonpocket.constant.BleActionCode.NOTIFY     // Catch:{ NoSuchFieldError -> 0x00b2 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b2 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00b2 }
            L_0x00b2:
                jp.co.sony.reonpocket.constant.BleActionCode r5 = jp.co.sony.reonpocket.constant.BleActionCode.WRITE     // Catch:{ NoSuchFieldError -> 0x00ba }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ba }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00ba }
            L_0x00ba:
                $EnumSwitchMapping$4 = r0
                jp.co.sony.reonpocket.constant.TemperatureOnOffCode[] r0 = jp.co.sony.reonpocket.constant.TemperatureOnOffCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.TemperatureOnOffCode r5 = jp.co.sony.reonpocket.constant.TemperatureOnOffCode.OFF     // Catch:{ NoSuchFieldError -> 0x00cb }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cb }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00cb }
            L_0x00cb:
                jp.co.sony.reonpocket.constant.TemperatureOnOffCode r5 = jp.co.sony.reonpocket.constant.TemperatureOnOffCode.ON     // Catch:{ NoSuchFieldError -> 0x00d3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                $EnumSwitchMapping$5 = r0
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode[] r0 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r5 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.COOL     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r5 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.COOL_HEAT_MIX     // Catch:{ NoSuchFieldError -> 0x00ec }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ec }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00ec }
            L_0x00ec:
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r5 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.HEAT     // Catch:{ NoSuchFieldError -> 0x00f4 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f4 }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00f4 }
            L_0x00f4:
                jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r3 = jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode.OFF     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                $EnumSwitchMapping$6 = r0
                jp.co.sony.reonpocket.util.CancelTimeActionNotificationReceiverModel$StopCauseMode[] r0 = jp.co.sony.reonpocket.util.CancelTimeActionNotificationReceiverModel.StopCauseMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.util.CancelTimeActionNotificationReceiverModel$StopCauseMode r3 = jp.co.sony.reonpocket.util.CancelTimeActionNotificationReceiverModel.StopCauseMode.COMMON     // Catch:{ NoSuchFieldError -> 0x010d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x010d }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x010d }
            L_0x010d:
                jp.co.sony.reonpocket.util.CancelTimeActionNotificationReceiverModel$StopCauseMode r1 = jp.co.sony.reonpocket.util.CancelTimeActionNotificationReceiverModel.StopCauseMode.SMART     // Catch:{ NoSuchFieldError -> 0x0115 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0115 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0115 }
            L_0x0115:
                $EnumSwitchMapping$7 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.presenter.MainPresenter.WhenMappings.<clinit>():void");
        }
    }

    public void tagScan() {
    }

    public MainPresenter(Context context, MainViewInput mainViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = mainViewInput;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity");
        this.mRouter = new MainRouter((MainActivity) context);
        this.mDeviceInfoInteractor = new DeviceInfoInteractor();
        this.mUserInfoInteractor = new UserInfoInteractor();
        this.mTagInfoInteractor = new TagInfoInteractor();
        this.mDeviceModeActionCode = DeviceModeActionCode.MANUAL;
        this.mDefaultTempLevel = MyTempStepCode.OFF.ordinal();
        this.mDefaultDuration = 10;
        this.mDefaultTimer = 30;
        this.NO_SETTING_TEMPERATURE = 255;
        this.DAY_RANGE = new LongRange(0, 5);
        this.mCurrentCoolHeatTypeCode = CoolHeatTypeCode.OFF_COOL;
        this.mTagDfuInteractor = new TagDfuInteractor(context, this);
        this.mTagWriteInteractor = new TagWriteInteractor(context, this);
        this.mAutoStopArray = new DeviceModeSettingTriggerCode[]{DeviceModeSettingTriggerCode.AUTO_STOP_UNKNOWN, DeviceModeSettingTriggerCode.AUTO_STOP_THERMO_TEMP_CHANGE, DeviceModeSettingTriggerCode.AUTO_STOP_DEVICE_LEFT_ON_SURFACE, DeviceModeSettingTriggerCode.AUTO_STOP_DEVICE_NO_ACTION, DeviceModeSettingTriggerCode.AUTO_STOP_DEVICE_NOT_WEAR};
        TagScanInteractor tagScanInteractor = new TagScanInteractor(context);
        this.mTagScanInteractor = tagScanInteractor;
        registerActionCallbackListener();
        tagScanInteractor.setListener(new TagScanInteractorCallbackListener(this) {
            final /* synthetic */ MainPresenter this$0;

            {
                this.this$0 = r1;
            }

            public void discover(String str, String str2, TagDataEntity tagDataEntity) {
                MainViewInput access$getAView$p;
                Intrinsics.checkNotNullParameter(str, "bdAddress");
                Intrinsics.checkNotNullParameter(str2, "deviceName");
                Intrinsics.checkNotNullParameter(tagDataEntity, "aData");
                if (!this.this$0.mPaused && (access$getAView$p = this.this$0.aView) != null) {
                    access$getAView$p.showTagRegisterDialog(str, tagDataEntity, str2);
                }
            }
        });
        this.mDayFormat = new SimpleDateFormat("yyyy/MM/dd");
    }

    private final boolean isShowReview() {
        Long reviewPopupTime = this.mUserInfoInteractor.getReviewPopupTime(this.aContext);
        if (reviewPopupTime != null) {
            if (System.currentTimeMillis() - reviewPopupTime.longValue() < TimeUnit.DAYS.toMillis(14)) {
                return false;
            }
        }
        if (this.mUserInfoInteractor.getConnectionErrorTime(this.aContext) > 0) {
            return false;
        }
        List arrayList = new ArrayList();
        LongRange longRange = this.DAY_RANGE;
        long first = longRange.getFirst();
        long last = longRange.getLast();
        if (first <= last) {
            while (true) {
                SimpleDateFormat simpleDateFormat = this.mDayFormat;
                SimpleDateFormat simpleDateFormat2 = this.mDayFormat;
                String format = simpleDateFormat.format(new Date(simpleDateFormat2.parse(simpleDateFormat2.format(new Date())).getTime() - TimeUnit.DAYS.toMillis(first)));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                arrayList.add(format);
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        int i = 0;
        for (String contains : this.mUserInfoInteractor.getOperationTimeSet(this.aContext)) {
            if (arrayList.contains(contains)) {
                i++;
            }
        }
        if (i > 2) {
            return true;
        }
        return false;
    }

    private final void saveOperateTime() {
        this.mUserInfoInteractor.saveOperationTime(this.aContext, new Date());
    }

    private final void registerActionCallbackListener() {
        this.mBleInteractor.setDataReceivedCallbackListener(new MainPresenter$registerActionCallbackListener$1(this));
    }

    private final void registerConnectCallbackListener() {
        BleInteractor.Companion.setMConnectCallbackListener(new MainPresenter$registerConnectCallbackListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            switch (characteristicUuid.hashCode()) {
                case 1512231:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_DEVICE_MODE)) {
                        handleDeviceMode(bleDataEntity);
                        return;
                    }
                    return;
                case 1512233:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_AUTO_START)) {
                        handleAutoStart(bleDataEntity);
                        return;
                    }
                    return;
                case 1512234:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_AUTHENTICATION)) {
                        handleAuthentication(bleDataEntity);
                        return;
                    }
                    return;
                case 1512477:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY)) {
                        handleDeviceTemp(bleDataEntity);
                        return;
                    }
                    return;
                case 1512478:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_BATTERY)) {
                        handleBattery(bleDataEntity);
                        return;
                    }
                    return;
                case 1512480:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_READ_THERMO_CONTROL_STATUS)) {
                        handleThermoStatus(bleDataEntity);
                        return;
                    }
                    return;
                case 1512482:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_ALERT)) {
                        handleAlert(bleDataEntity);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (bleDataEntity.getResponseCode().getCode() != 144) {
            String characteristicUuid2 = bleDataEntity.getCharacteristicUuid();
            switch (characteristicUuid2.hashCode()) {
                case 1512233:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_AUTO_START)) {
                        handleDataError("auto start data error");
                        return;
                    }
                    break;
                case 1512477:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY)) {
                        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                        String characteristicUuid3 = bleDataEntity.getCharacteristicUuid();
                        BleActionCode action = bleDataEntity.getAction();
                        ResponseCode responseCode = bleDataEntity.getResponseCode();
                        debugLogUtil.e("error characteristic: " + characteristicUuid3 + ", action: " + action + ", response: " + responseCode);
                        new Handler(Looper.getMainLooper()).postDelayed(new MainPresenter$$ExternalSyntheticLambda1(this), 1500);
                        return;
                    }
                    break;
                case 1512478:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_BATTERY)) {
                        handleDataError("battery data error");
                        return;
                    }
                    break;
                case 1512480:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_READ_THERMO_CONTROL_STATUS)) {
                        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                        String characteristicUuid4 = bleDataEntity.getCharacteristicUuid();
                        BleActionCode action2 = bleDataEntity.getAction();
                        ResponseCode responseCode2 = bleDataEntity.getResponseCode();
                        debugLogUtil2.e("error characteristic: " + characteristicUuid4 + ", action: " + action2 + ", response: " + responseCode2);
                        new Handler(Looper.getMainLooper()).postDelayed(new MainPresenter$$ExternalSyntheticLambda2(this), 1500);
                        return;
                    }
                    break;
                case 1512481:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_BOOST)) {
                        handleDataError("boost setting data error");
                        return;
                    }
                    break;
            }
            handleDataError("operation fail");
        }
    }

    /* access modifiers changed from: private */
    public static final void onDataReceived$lambda$2(MainPresenter mainPresenter) {
        Intrinsics.checkNotNullParameter(mainPresenter, "this$0");
        mainPresenter.openDeviceTempNotification();
    }

    /* access modifiers changed from: private */
    public static final void onDataReceived$lambda$3(MainPresenter mainPresenter) {
        Intrinsics.checkNotNullParameter(mainPresenter, "this$0");
        mainPresenter.openThermoStatusNotification();
    }

    private final void handleAuthentication(BleDataEntity bleDataEntity) {
        AuthenticationEntity object = AuthenticationEntity.Companion.getObject(bleDataEntity);
        if (object == null) {
            DebugLogUtil.INSTANCE.w("authentication format error");
            return;
        }
        if (WhenMappings.$EnumSwitchMapping$0[object.getType().ordinal()] == 3) {
            BleInteractor.Companion.setMConnectCallbackListener((Function2<? super BleConnStatusCode, ? super ArrayList<String>, Unit>) null);
            MainWireFrame.DefaultImpls.goToConnectionAndClear$default(this.mRouter, (Bundle) null, 1, (Object) null);
        }
    }

    public void writeDeviceMode(DeviceModeEntity deviceModeEntity) {
        Intrinsics.checkNotNullParameter(deviceModeEntity, "aEntity");
        byte[] bArr = deviceModeEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, bArr, 2, (Object) null);
            return;
        }
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.onFail("bytes error");
        }
    }

    public void writeDeviceModeOff() {
        DeviceModeEntity deviceModeEntity = r0;
        DeviceModeEntity deviceModeEntity2 = new DeviceModeEntity(DeviceModeActionCode.MY, DeviceModeSettingTriggerCode.SET_DEVICE_MODE, (DeviceCoolingCode) null, (ContinuousOperationStatus) null, (SwitchCoolHeatWaitStatus) null, (CoolHeatTypeCode) null, (DeviceModeEntity.Temperature) null, (ModeCommonSettingOperation) null, (Integer) null, (TempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (Integer) null, (MyModeActionType) null, (MyModeSpecialSubMode) null, (Integer) null, (Integer) null, MyModeOperationCode.CTRL_STOP, 1, MyModeTypeCode.COOL_HEAT_REPEAT, (Integer) null, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, (Integer) null, (Integer) null, TempBoostOption.NONE, TempWaveOption.WAVE_OFF, 0, (Integer) null, (Integer) null, (MyTempStepCode) null, (TempBoostOption) null, (TempWaveOption) null, (Integer) null, (Integer) null, (FanStepCode) null, 524284, 63, (DefaultConstructorMarker) null);
        writeDeviceMode(deviceModeEntity);
    }

    public void readDeviceMode() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_DEVICE_MODE, (String) null, 2, (Object) null);
    }

    public void readBattery() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_BATTERY, (String) null, 2, (Object) null);
    }

    public void readAutoStart() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTO_START, (String) null, 2, (Object) null);
    }

    private final void writeAuthentication(AuthenticationEntity authenticationEntity) {
        byte[] bArr = authenticationEntity.toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTHENTICATION, (String) null, bArr, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void setUsageInfo(BleDataEntity bleDataEntity) {
        int i;
        Unit unit;
        TempBoostOption tempBoostOption;
        CoolHeatTypeCode coolHeatTypeCode;
        int i2;
        if (RemoteConfigUtil.INSTANCE.getMUsageEntity() != null && bleDataEntity.getAction() != BleActionCode.READ) {
            DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
            if (object != null) {
                coolHeatTypeCode = object.getCoolHeatType();
                tempBoostOption = object.getBoostOption();
                TempStepCode temperature = object.getTemperature();
                if (temperature != null) {
                    i = temperature.getCode();
                    unit = Unit.INSTANCE;
                } else {
                    return;
                }
            } else {
                coolHeatTypeCode = null;
                i = 0;
                tempBoostOption = null;
                unit = null;
            }
            if (unit != null) {
                UserBehaviorInteractor userBehaviorInteractor = this.mUserBehaviorInteractor;
                if (userBehaviorInteractor != null) {
                    UsageEntity mUsageEntity = RemoteConfigUtil.INSTANCE.getMUsageEntity();
                    Intrinsics.checkNotNull(mUsageEntity);
                    userBehaviorInteractor.setMCoolThreshold(mUsageEntity.getCoolRatio());
                }
                UserBehaviorInteractor userBehaviorInteractor2 = this.mUserBehaviorInteractor;
                if (userBehaviorInteractor2 != null) {
                    UsageEntity mUsageEntity2 = RemoteConfigUtil.INSTANCE.getMUsageEntity();
                    Intrinsics.checkNotNull(mUsageEntity2);
                    userBehaviorInteractor2.setMWarmThreshold(mUsageEntity2.getWarmRatio());
                }
                UserBehaviorInteractor userBehaviorInteractor3 = this.mUserBehaviorInteractor;
                if (userBehaviorInteractor3 != null) {
                    UsageEntity mUsageEntity3 = RemoteConfigUtil.INSTANCE.getMUsageEntity();
                    Intrinsics.checkNotNull(mUsageEntity3);
                    userBehaviorInteractor3.setMCoolSizeFromConfig(mUsageEntity3.getCoolCount());
                }
                UserBehaviorInteractor userBehaviorInteractor4 = this.mUserBehaviorInteractor;
                if (userBehaviorInteractor4 != null) {
                    UsageEntity mUsageEntity4 = RemoteConfigUtil.INSTANCE.getMUsageEntity();
                    Intrinsics.checkNotNull(mUsageEntity4);
                    userBehaviorInteractor4.setMWarmSizeFromConfig(mUsageEntity4.getWarmCount());
                }
                if (coolHeatTypeCode == null) {
                    i2 = -1;
                } else {
                    i2 = WhenMappings.$EnumSwitchMapping$1[coolHeatTypeCode.ordinal()];
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        if (tempBoostOption == TempBoostOption.BOOST) {
                            UserBehaviorInteractor userBehaviorInteractor5 = this.mUserBehaviorInteractor;
                            if (userBehaviorInteractor5 != null) {
                                userBehaviorInteractor5.setNewWarmLevel(4);
                                return;
                            }
                            return;
                        }
                        UserBehaviorInteractor userBehaviorInteractor6 = this.mUserBehaviorInteractor;
                        if (userBehaviorInteractor6 != null) {
                            userBehaviorInteractor6.setNewWarmLevel(i + 1);
                        }
                    }
                } else if (tempBoostOption == TempBoostOption.BOOST) {
                    UserBehaviorInteractor userBehaviorInteractor7 = this.mUserBehaviorInteractor;
                    if (userBehaviorInteractor7 != null) {
                        userBehaviorInteractor7.setNewCoolLevel(4);
                    }
                } else {
                    UserBehaviorInteractor userBehaviorInteractor8 = this.mUserBehaviorInteractor;
                    if (userBehaviorInteractor8 != null) {
                        userBehaviorInteractor8.setNewCoolLevel(i + 1);
                    }
                }
            }
        }
    }

    private final void handleDeviceMode(BleDataEntity bleDataEntity) {
        MainViewInput mainViewInput;
        MainViewInput mainViewInput2;
        DeviceCoolingCode coolingCode;
        MainViewInput mainViewInput3;
        int i = WhenMappings.$EnumSwitchMapping$4[bleDataEntity.getAction().ordinal()];
        if (i == 1 || i == 2) {
            DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
            if (object == null) {
                Integer.valueOf(DebugLogUtil.INSTANCE.e("device mode format"));
            }
            if (!(object == null || (coolingCode = object.getCoolingCode()) == null || (mainViewInput3 = this.aView) == null)) {
                mainViewInput3.updateCoolingStatus(coolingCode);
            }
            DeviceModeActionCode deviceModeActionCode = null;
            SwitchCoolHeatWaitStatus switchCoolHeatWaitStatus = object != null ? object.getSwitchCoolHeatWaitStatus() : null;
            int i2 = switchCoolHeatWaitStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$2[switchCoolHeatWaitStatus.ordinal()];
            if (i2 == 1) {
                MainViewInput mainViewInput4 = this.aView;
                if (mainViewInput4 != null) {
                    mainViewInput4.showModeSwitchingProgress();
                }
            } else if (i2 == 2 && (mainViewInput2 = this.aView) != null) {
                mainViewInput2.dismissModeSwitchingProgress();
            }
            if ((object != null ? object.getSettingTrigger() : null) == DeviceModeSettingTriggerCode.RUNTIME_EXPIRED_MANUAL_AUTO && (mainViewInput = this.aView) != null) {
                mainViewInput.updateDeviceInfo(DeviceInfoConstants.NORMAL_MOVEMENT_AUTO_STOP);
            }
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
            if (intValue$default != null) {
                intValue$default.intValue();
                DeviceModeActionCode[] values = DeviceModeActionCode.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    DeviceModeActionCode deviceModeActionCode2 = values[i3];
                    int code = deviceModeActionCode2.getCode();
                    if (intValue$default != null && code == intValue$default.intValue()) {
                        deviceModeActionCode = deviceModeActionCode2;
                        break;
                    }
                    i3++;
                }
                if (deviceModeActionCode != null) {
                    if (this.mDeviceModeActionCode != deviceModeActionCode) {
                        int i4 = WhenMappings.$EnumSwitchMapping$3[deviceModeActionCode.ordinal()];
                        if (i4 == 1) {
                            AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
                            Context context = this.aContext;
                            FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
                            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
                            analyticsUtil.logEventWithString(context, instance, AnalyticsUtil.EventName.MODE_CHANGE, AnalyticsUtil.EventParameter.MODE, AnalyticsUtil.ParameterConstants.MANUAL.getValue());
                        } else if (i4 == 2) {
                            AnalyticsUtil analyticsUtil2 = AnalyticsUtil.INSTANCE;
                            Context context2 = this.aContext;
                            FirebaseAnalytics instance2 = FirebaseAnalytics.getInstance(context2);
                            Intrinsics.checkNotNullExpressionValue(instance2, "getInstance(...)");
                            analyticsUtil2.logEventWithString(context2, instance2, AnalyticsUtil.EventName.MODE_CHANGE, AnalyticsUtil.EventParameter.MODE, AnalyticsUtil.ParameterConstants.AUTO.getValue());
                        }
                    }
                    this.mDeviceModeActionCode = deviceModeActionCode;
                    if (deviceModeActionCode == DeviceModeActionCode.MANUAL) {
                        setUsageInfo(bleDataEntity);
                    }
                    switch (WhenMappings.$EnumSwitchMapping$3[deviceModeActionCode.ordinal()]) {
                        case 1:
                        case 2:
                            setDeviceMode(bleDataEntity);
                            return;
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            return;
                        case 6:
                            setTemperatureMode(bleDataEntity);
                            return;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
    }

    private final boolean setTemperatureMode(BleDataEntity bleDataEntity) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        MainViewInput mainViewInput;
        MainViewInput mainViewInput2;
        MainViewInput mainViewInput3;
        DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
        boolean z8 = false;
        if (object != null) {
            DeviceModeSettingTriggerCode settingTrigger = object.getSettingTrigger();
            if (!(settingTrigger == null || (mainViewInput3 = this.aView) == null)) {
                mainViewInput3.updateSettingTrigger(settingTrigger);
            }
            DeviceModeEntity.Temperature temperatureEntity = object.getTemperatureEntity();
            TemperatureOnOffCode temperatureOnOffCode = null;
            if ((temperatureEntity != null ? temperatureEntity.getTempOffOnCode() : null) == TemperatureOnOffCode.OFF && bleDataEntity.getAction() == BleActionCode.NOTIFY && ArraysKt.contains((T[]) this.mAutoStopArray, object.getSettingTrigger()) && (mainViewInput2 = this.aView) != null) {
                mainViewInput2.showAutoStopMessage();
            }
            String peripheralName = this.mDeviceInfoInteractor.getPeripheralName(this.aContext);
            if (Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1.getModel())) {
                z = true;
            } else {
                z = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1A.getModel());
            }
            if (z) {
                z2 = true;
            } else {
                z2 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_1L.getModel());
            }
            if (z2) {
                z3 = true;
            } else {
                z3 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_2.getModel());
            }
            if (z3) {
                z4 = true;
            } else {
                z4 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_3.getModel());
            }
            if (z4) {
                z5 = true;
            } else {
                z5 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_4.getModel());
            }
            if (z5) {
                z6 = true;
            } else {
                z6 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_5.getModel());
            }
            if (z6) {
                z7 = true;
            } else {
                z7 = Intrinsics.areEqual((Object) peripheralName, (Object) ModelConstant.ModelName.RNP_P1.getModel());
            }
            if (z7 && (mainViewInput = this.aView) != null) {
                mainViewInput.updateActionMode(bleDataEntity, object);
            }
            coolHeatTypeStatusChange(object);
            MainViewInput mainViewInput4 = this.aView;
            if (mainViewInput4 != null) {
                DeviceModeEntity.Temperature temperatureEntity2 = object.getTemperatureEntity();
                if (temperatureEntity2 != null) {
                    temperatureOnOffCode = temperatureEntity2.getTempOffOnCode();
                }
                int i = temperatureOnOffCode == null ? -1 : WhenMappings.$EnumSwitchMapping$5[temperatureOnOffCode.ordinal()];
                if (i == 1 || i != 2) {
                    z8 = true;
                }
                mainViewInput4.updateIsOff(z8);
            }
            startStopDurationNotification(CancelTimeActionNotificationReceiverModel.StopCauseMode.SMART, object);
            return true;
        }
        handleDataError("data format error");
        return false;
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void coolHeatTypeStatusChange(jp.co.sony.reonpocket.data.entity.DeviceModeEntity r6) {
        /*
            r5 = this;
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r0 = r6.getTemperatureEntity()
            if (r0 == 0) goto L_0x00e6
            jp.co.sony.reonpocket.constant.TemperatureCoolHeatTypeCode r0 = r0.getTempCoolHeatType()
            if (r0 != 0) goto L_0x000e
            goto L_0x00e6
        L_0x000e:
            int[] r1 = jp.co.sony.reonpocket.modules.main.presenter.MainPresenter.WhenMappings.$EnumSwitchMapping$6
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x00c4
            r3 = 2
            if (r0 == r3) goto L_0x0046
            r1 = 3
            if (r0 == r1) goto L_0x0022
            goto L_0x00e6
        L_0x0022:
            jp.co.sony.reonpocket.modules.main.view.MainViewInput r0 = r5.aView
            if (r0 == 0) goto L_0x0033
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r1 = r6.getTemperatureEntity()
            if (r1 == 0) goto L_0x0030
            jp.co.sony.reonpocket.constant.SmartModePreference r2 = r1.getHeatPreference()
        L_0x0030:
            r0.setSmartWarmPreference(r2)
        L_0x0033:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r6 = r6.getTemperatureEntity()
            if (r6 == 0) goto L_0x003f
            jp.co.sony.reonpocket.constant.SmartModePreference r6 = r6.getHeatPreference()
            if (r6 != 0) goto L_0x0041
        L_0x003f:
            jp.co.sony.reonpocket.constant.SmartModePreference r6 = jp.co.sony.reonpocket.constant.SmartModePreference.OFF
        L_0x0041:
            r5.setSmartWarmPreference(r6)
            goto L_0x00e6
        L_0x0046:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r0 = r6.getTemperatureEntity()
            if (r0 == 0) goto L_0x005c
            jp.co.sony.reonpocket.constant.SmartModePreference r0 = r0.getCoolPreference()
            if (r0 == 0) goto L_0x005c
            jp.co.sony.reonpocket.modules.main.view.MainViewInput r3 = r5.aView
            if (r3 == 0) goto L_0x0059
            r3.setSmartCoolPreference(r0)
        L_0x0059:
            r5.setSmartCoolPreference(r0)
        L_0x005c:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r0 = r6.getTemperatureEntity()
            if (r0 == 0) goto L_0x0072
            jp.co.sony.reonpocket.constant.SmartModePreference r0 = r0.getHeatPreference()
            if (r0 == 0) goto L_0x0072
            jp.co.sony.reonpocket.modules.main.view.MainViewInput r3 = r5.aView
            if (r3 == 0) goto L_0x006f
            r3.setSmartWarmPreference(r0)
        L_0x006f:
            r5.setSmartWarmPreference(r0)
        L_0x0072:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r0 = r6.getTemperatureEntity()
            if (r0 == 0) goto L_0x007c
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r2 = r0.getTempCurrentCoolHeatType()
        L_0x007c:
            if (r2 == 0) goto L_0x0093
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.OFF
            if (r2 == r0) goto L_0x0093
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.PAUSE
            if (r2 == r0) goto L_0x0093
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.COOL
            if (r2 == r0) goto L_0x0090
            jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode r0 = jp.co.sony.reonpocket.constant.CurrentCoolHeatTypeCode.WEAKCOOL
            if (r2 != r0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r1 = 0
        L_0x0090:
            r5.setSmartMixPreference(r1)
        L_0x0093:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r0 = r6.getTemperatureEntity()
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r0 == 0) goto L_0x00ac
            java.lang.Integer r0 = r0.getTempCoolSwitchThreshold()
            if (r0 == 0) goto L_0x00ac
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            double r3 = (double) r0
            double r3 = r3 / r1
            r5.setSmartCoolTempSwitchThreshold(r3)
        L_0x00ac:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r6 = r6.getTemperatureEntity()
            if (r6 == 0) goto L_0x00e6
            java.lang.Integer r6 = r6.getTempWarmSwitchThreshold()
            if (r6 == 0) goto L_0x00e6
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            double r3 = (double) r6
            double r3 = r3 / r1
            r5.setSmartWarmTempSwitchThreshold(r3)
            goto L_0x00e6
        L_0x00c4:
            jp.co.sony.reonpocket.modules.main.view.MainViewInput r0 = r5.aView
            if (r0 == 0) goto L_0x00d5
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r1 = r6.getTemperatureEntity()
            if (r1 == 0) goto L_0x00d2
            jp.co.sony.reonpocket.constant.SmartModePreference r2 = r1.getCoolPreference()
        L_0x00d2:
            r0.setSmartCoolPreference(r2)
        L_0x00d5:
            jp.co.sony.reonpocket.data.entity.DeviceModeEntity$Temperature r6 = r6.getTemperatureEntity()
            if (r6 == 0) goto L_0x00e1
            jp.co.sony.reonpocket.constant.SmartModePreference r6 = r6.getCoolPreference()
            if (r6 != 0) goto L_0x00e3
        L_0x00e1:
            jp.co.sony.reonpocket.constant.SmartModePreference r6 = jp.co.sony.reonpocket.constant.SmartModePreference.OFF
        L_0x00e3:
            r5.setSmartCoolPreference(r6)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.modules.main.presenter.MainPresenter.coolHeatTypeStatusChange(jp.co.sony.reonpocket.data.entity.DeviceModeEntity):void");
    }

    public void onCreate() {
        this.mBleInteractor.onCreate(this.aContext);
        this.mUserBehaviorInteractor = new UserBehaviorInteractor(this.aContext);
        if (Build.VERSION.SDK_INT < 26) {
            this.aContext.startService(new Intent(this.aContext, LaunchApplicationNotificationService.class));
        } else if (RequestBLEPermissions.Companion.isAllRequestPermission(this.aContext)) {
            ComponentName unused = this.aContext.startForegroundService(new Intent(this.aContext, LaunchApplicationNotificationService.class));
        }
        if (stopTimeCheck()) {
            MainViewInput mainViewInput = this.aView;
            if (mainViewInput != null) {
                mainViewInput.setIsForeground(true);
            }
            MainViewInput mainViewInput2 = this.aView;
            if (mainViewInput2 != null) {
                mainViewInput2.showAutoStopMessage();
            }
        }
    }

    public void markAutoStartPopupShown() {
        this.mUserInfoInteractor.saveIsNeedAutoStartPopup(this.aContext, false);
    }

    public void onResume() {
        MainViewInput mainViewInput;
        super.onResume();
        boolean z = false;
        this.mPaused = false;
        MainViewInput mainViewInput2 = this.aView;
        if (mainViewInput2 != null) {
            mainViewInput2.setIsForeground(true);
        }
        openDeviceTempNotification();
        openThermoStatusNotification();
        readDeviceTempNotification();
        registerConnectCallbackListener();
        Boolean isShownAutoStartPopup = this.mUserInfoInteractor.getIsShownAutoStartPopup(this.aContext);
        if (isShownAutoStartPopup == null || !isShownAutoStartPopup.booleanValue()) {
            if (Intrinsics.areEqual((Object) this.mUserInfoInteractor.getIsShownLocationPopup(this.aContext), (Object) true) && !this.mIsPermissionShown && Build.VERSION.SDK_INT >= 29) {
                PermissionUtil permissionUtil = PermissionUtil.INSTANCE;
                Context context = this.aContext;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.main.view.MainActivity");
                if (!permissionUtil.isBackgroundLocationGranted((MainActivity) context)) {
                    this.mIsPermissionShown = true;
                    MainViewInput mainViewInput3 = this.aView;
                    if (mainViewInput3 != null) {
                        mainViewInput3.showRequestBackgroundLocationDialog(false);
                        return;
                    }
                    return;
                }
            }
            RemoteConfigUtil remoteConfigUtil = RemoteConfigUtil.INSTANCE;
            Context context2 = this.aContext;
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
            remoteConfigUtil.fetchAndActivate((Activity) context2, instance, new MainPresenter$onResume$2(this));
            if (stopTimeCheck() && (mainViewInput = this.aView) != null) {
                mainViewInput.showAutoStopMessage();
            }
            CharSequence tagBDAddress = this.mTagInfoInteractor.getTagBDAddress(this.aContext);
            if (tagBDAddress == null || tagBDAddress.length() == 0) {
                z = true;
            }
            boolean z2 = !z;
            MainViewInput mainViewInput4 = this.aView;
            if (mainViewInput4 != null) {
                mainViewInput4.updateTagMiniInfoView(z2, (NotifyTagSensorDataEntity) null);
            }
            MainViewInput mainViewInput5 = this.aView;
            if (mainViewInput5 != null) {
                mainViewInput5.updateTagMiniInfoView();
                return;
            }
            return;
        }
        MainViewInput mainViewInput6 = this.aView;
        if (mainViewInput6 != null) {
            mainViewInput6.showAutoStartNotification();
        }
    }

    public void markLocationPopup(boolean z) {
        this.mUserInfoInteractor.saveIsNeedLocationPopup(this.aContext, z);
    }

    public void setNextToastShow(boolean z) {
        this.mUserInfoInteractor.saveIsNextShowAutoStopMessage(this.aContext, z);
    }

    public void saveAutoStopTime(long j) {
        this.mUserInfoInteractor.saveAutoStopTime(this.aContext, j);
    }

    public long getAutoStopTime() {
        Long autoStopTime = this.mUserInfoInteractor.getAutoStopTime(this.aContext);
        if (autoStopTime != null) {
            return autoStopTime.longValue();
        }
        return 0;
    }

    private final boolean stopTimeCheck() {
        if (Intrinsics.areEqual((Object) this.mUserInfoInteractor.getIsNextShowAutoStopMessage(this.aContext), (Object) false)) {
            return false;
        }
        long autoStopTime = getAutoStopTime();
        long currentTimeMillis = System.currentTimeMillis();
        if (autoStopTime != 0 && autoStopTime + ((long) MainPresenterKt.ONE_HOUR_IN_MILLISECONS) >= currentTimeMillis) {
            return true;
        }
        return false;
    }

    public void onPause() {
        super.onPause();
        this.mPaused = true;
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.setIsForeground(false);
        }
        MainViewInput mainViewInput2 = this.aView;
        if (mainViewInput2 != null) {
            mainViewInput2.calcelCustomToast();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mBleInteractor.onDestroy(this.aContext);
    }

    private final boolean setDeviceMode(BleDataEntity bleDataEntity) {
        MainViewInput mainViewInput;
        MainViewInput mainViewInput2;
        MainViewInput mainViewInput3;
        DeviceModeEntity object = DeviceModeEntity.Companion.getObject(bleDataEntity);
        if (object == null) {
            handleDataError("data format error");
            return false;
        }
        DeviceModeSettingTriggerCode settingTrigger = object.getSettingTrigger();
        if (!(settingTrigger == null || (mainViewInput3 = this.aView) == null)) {
            mainViewInput3.updateSettingTrigger(settingTrigger);
        }
        if ((object.getCoolHeatType() == CoolHeatTypeCode.OFF_COOL || object.getCoolHeatType() == CoolHeatTypeCode.OFF_HEAT) && bleDataEntity.getAction() == BleActionCode.NOTIFY && ArraysKt.contains((T[]) this.mAutoStopArray, object.getSettingTrigger()) && (mainViewInput2 = this.aView) != null) {
            mainViewInput2.showAutoStopMessage();
        }
        CoolHeatTypeCode coolHeatType = object.getCoolHeatType();
        if (coolHeatType != null) {
            this.mIsCool = coolHeatType == CoolHeatTypeCode.COOL;
            this.mCurrentCoolHeatTypeCode = coolHeatType;
            MainViewInput mainViewInput4 = this.aView;
            if (mainViewInput4 != null) {
                mainViewInput4.transitToCoolOrWarmByTypeCode(bleDataEntity, object);
            }
            int i = WhenMappings.$EnumSwitchMapping$1[coolHeatType.ordinal()];
            if (i == 1) {
                MainViewInput mainViewInput5 = this.aView;
                if (mainViewInput5 != null) {
                    mainViewInput5.updateDeviceInfo(DeviceInfoConstants.NORMAL_MOVEMENT_COOL);
                }
            } else if (i == 2 && (mainViewInput = this.aView) != null) {
                mainViewInput.updateDeviceInfo(DeviceInfoConstants.NORMAL_MOVEMENT_WARM);
            }
        }
        TempStepCode temperature = object.getTemperature();
        if (temperature == null) {
            temperature = TempStepCode.OFF;
        }
        if (object.getCoolHeatType() == CoolHeatTypeCode.OFF_COOL || object.getCoolHeatType() == CoolHeatTypeCode.OFF_HEAT || temperature == TempStepCode.OFF) {
            MainViewInput mainViewInput6 = this.aView;
            if (mainViewInput6 != null) {
                mainViewInput6.updateIsOff(true);
            }
        } else {
            MainViewInput mainViewInput7 = this.aView;
            if (mainViewInput7 != null) {
                mainViewInput7.updateIsOff(false);
            }
        }
        startStopDurationNotification(CancelTimeActionNotificationReceiverModel.StopCauseMode.COMMON, object);
        return true;
    }

    private final void startStopDurationNotification(CancelTimeActionNotificationReceiverModel.StopCauseMode stopCauseMode, DeviceModeEntity deviceModeEntity) {
        DeviceModeEntity.Temperature temperatureEntity;
        Integer tempModeRemainTime;
        MainViewInput mainViewInput;
        int i = WhenMappings.$EnumSwitchMapping$7[stopCauseMode.ordinal()];
        if (i == 1) {
            Integer remainDuration = deviceModeEntity.getRemainDuration();
            if (remainDuration == null) {
                return;
            }
            if (remainDuration.intValue() != 0) {
                MainViewInput mainViewInput2 = this.aView;
                if (mainViewInput2 != null) {
                    mainViewInput2.updateIsAlert(false);
                }
            } else if (deviceModeEntity.getSettingTrigger() != DeviceModeSettingTriggerCode.RUNTIME_EXPIRED_MANUAL_AUTO) {
                CancelTimeActionNotificationReceiverModel.Companion.getInstance(this.aContext).cancelNotification();
            }
        } else if (i == 2 && (temperatureEntity = deviceModeEntity.getTemperatureEntity()) != null && (tempModeRemainTime = temperatureEntity.getTempModeRemainTime()) != null) {
            int intValue = tempModeRemainTime.intValue();
            if (intValue == 0) {
                if (deviceModeEntity.getSettingTrigger() != DeviceModeSettingTriggerCode.RUNTIME_EXPIRED_MANUAL_AUTO) {
                    CancelTimeActionNotificationReceiverModel.Companion.getInstance(this.aContext).cancelNotification();
                }
            } else if (TimeUnit.SECONDS.toMinutes((long) intValue) / ((long) 60) <= 1 && (mainViewInput = this.aView) != null) {
                mainViewInput.updateIsAlert(false);
            }
        }
    }

    public void disconnect() {
        this.mBleInteractor.disconnect();
    }

    private final void handleDataError(String str) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("data error:" + str);
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.onFail(str);
        }
    }

    /* access modifiers changed from: private */
    public final void onConnectionStatus(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList) {
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.onConnectionStatus(bleConnStatusCode, arrayList);
        }
    }

    public void readBoost() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_BOOST, (String) null, 2, (Object) null);
    }

    private final void handleBattery(BleDataEntity bleDataEntity) {
        Unit unit;
        BatteryChargeStatus batteryChargeStatus;
        Unit unit2;
        PowerSupplyStatus powerSupplyStatus;
        MainViewInput mainViewInput;
        Unit unit3;
        MainViewInput mainViewInput2;
        if (bleDataEntity.getAction() != BleActionCode.NOTIFY || bleDataEntity.getData() != null) {
            int i = WhenMappings.$EnumSwitchMapping$4[bleDataEntity.getAction().ordinal()];
            if (i == 1 || i == 2) {
                Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
                Unit unit4 = null;
                if (intValue$default != null) {
                    int intValue = intValue$default.intValue();
                    if ((intValue < 0 || intValue >= 101) && intValue != 255) {
                        handleDataError("battery's level format");
                        return;
                    }
                    if (intValue$default.intValue() < 25 && (mainViewInput2 = this.aView) != null) {
                        mainViewInput2.updateDeviceInfo(DeviceInfoConstants.NORMAL_MOVEMENT_LOW_BATTERY);
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
                    DeviceInfoInteractorInput deviceInfoInteractorInput = this.mDeviceInfoInteractor;
                    Context context = this.aContext;
                    Intrinsics.checkNotNull(powerSupplyStatus);
                    deviceInfoInteractorInput.saveVbusStatusCode(context, powerSupplyStatus.getCode());
                    int i4 = WhenMappings.$EnumSwitchMapping$4[bleDataEntity.getAction().ordinal()];
                    if ((i4 == 1 || i4 == 2) && (mainViewInput = this.aView) != null) {
                        int intValue2 = intValue$default.intValue();
                        Intrinsics.checkNotNull(batteryChargeStatus);
                        mainViewInput.onBatteryStateChange(new BatteryEntity(intValue2, batteryChargeStatus, powerSupplyStatus, intValue$default4.intValue()));
                        return;
                    }
                    return;
                }
                handleDataError("battery's remain time format");
            }
        }
    }

    private final void handleAlert(BleDataEntity bleDataEntity) {
        Integer intValue$default;
        if (bleDataEntity.getData() != null && (intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null)) != null) {
            int intValue = intValue$default.intValue();
            MainViewInput mainViewInput = this.aView;
            if (mainViewInput != null) {
                mainViewInput.updateIsAlert(true);
            }
            if (intValue == NotifyAlertCode.CHARGING_LOW_BATTERY.getCode()) {
                MainViewInput mainViewInput2 = this.aView;
                if (mainViewInput2 != null) {
                    mainViewInput2.onFail(BaseActivityKt.ERROR_OPERATE_WHEN_NO_ENOUGH_BATTERY);
                }
                readDeviceMode();
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_LOW_TEMP.getCode()) {
                MainViewInput mainViewInput3 = this.aView;
                if (mainViewInput3 != null) {
                    mainViewInput3.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE);
                }
                MainViewInput mainViewInput4 = this.aView;
                if (mainViewInput4 != null) {
                    mainViewInput4.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_HIGH_TEMP.getCode()) {
                MainViewInput mainViewInput5 = this.aView;
                if (mainViewInput5 != null) {
                    mainViewInput5.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE);
                }
                MainViewInput mainViewInput6 = this.aView;
                if (mainViewInput6 != null) {
                    mainViewInput6.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_CAUSE_HIGH_TEMP);
                }
            } else if (intValue == NotifyAlertCode.CHARGING_FAIL_UNKNOWN.getCode()) {
                MainViewInput mainViewInput7 = this.aView;
                if (mainViewInput7 != null) {
                    mainViewInput7.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE_UNKNOWN);
                }
                MainViewInput mainViewInput8 = this.aView;
                if (mainViewInput8 != null) {
                    mainViewInput8.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_CANNOT_CHARGING_UNKNOWN);
                }
            } else if (intValue == NotifyAlertCode.SHUTDOWN_BY_LOW_BATTERY.getCode()) {
                if (Build.VERSION.SDK_INT >= 26) {
                    Context context = this.aContext;
                    Intent intent = new Intent(this.aContext, LaunchApplicationNotificationService.class);
                    intent.putExtra(LaunchApplicationNotificationService.REQUEST_CODE, LaunchApplicationNotificationService.REQUEST_LOW_BATTERY_NOTIFICATION_1);
                    ComponentName unused = context.startForegroundService(intent);
                } else {
                    Context context2 = this.aContext;
                    Intent intent2 = new Intent(this.aContext, LaunchApplicationNotificationService.class);
                    intent2.putExtra(LaunchApplicationNotificationService.REQUEST_CODE, LaunchApplicationNotificationService.REQUEST_LOW_BATTERY_NOTIFICATION_1);
                    context2.startService(intent2);
                }
                MainViewInput mainViewInput9 = this.aView;
                if (mainViewInput9 != null) {
                    mainViewInput9.onFail(MainPresenterKt.BUNDLE_SHUTDOWN_BY_LOW_BATTERY);
                }
            } else if (intValue == NotifyAlertCode.STOP_BY_OVER_CURRENT.getCode()) {
                MainViewInput mainViewInput10 = this.aView;
                if (mainViewInput10 != null) {
                    mainViewInput10.onFail(BaseActivityKt.ERROR_DEVICE_STOP);
                }
                MainViewInput mainViewInput11 = this.aView;
                if (mainViewInput11 != null) {
                    mainViewInput11.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_DEVICE_STOP);
                }
                readDeviceMode();
            } else if (intValue == NotifyAlertCode.INVALID_BATTERY_TEMP.getCode()) {
                MainViewInput mainViewInput12 = this.aView;
                if (mainViewInput12 != null) {
                    mainViewInput12.onFail(BaseActivityKt.ERROR_DEVICE_COULD_NOT_CHARGE);
                }
            } else if (intValue == NotifyAlertCode.STOP_BY_INVALID_FAN_RATE.getCode()) {
                MainViewInput mainViewInput13 = this.aView;
                if (mainViewInput13 != null) {
                    mainViewInput13.onFail(BaseActivityKt.ERROR_DEVICE_FAN_INVALID);
                }
                MainViewInput mainViewInput14 = this.aView;
                if (mainViewInput14 != null) {
                    mainViewInput14.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_FAN_STOP);
                }
                readDeviceMode();
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_TEMP.getCode()) {
                MainViewInput mainViewInput15 = this.aView;
                if (mainViewInput15 != null) {
                    mainViewInput15.onFail(BaseActivityKt.ERROR_DEVICE_LOWTEMP);
                }
                MainViewInput mainViewInput16 = this.aView;
                if (mainViewInput16 != null) {
                    mainViewInput16.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_INTERNAL_LOW_TEMP);
                }
                readDeviceMode();
            } else if (intValue == NotifyAlertCode.COOL_STOP_BY_INVALID_FAN_TEMP.getCode()) {
                MainViewInput mainViewInput17 = this.aView;
                if (mainViewInput17 != null) {
                    mainViewInput17.onFail(BaseActivityKt.ERROR_DEVICE_OVERHEAT);
                }
                MainViewInput mainViewInput18 = this.aView;
                if (mainViewInput18 != null) {
                    mainViewInput18.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_INTERNAL_HIGH_TEMP);
                }
                readDeviceMode();
            } else if (intValue == NotifyAlertCode.HEAT_STOP_BY_INVALID_TEMP.getCode()) {
                MainViewInput mainViewInput19 = this.aView;
                if (mainViewInput19 != null) {
                    mainViewInput19.onFail(BaseActivityKt.ERROR_TEMP);
                }
                MainViewInput mainViewInput20 = this.aView;
                if (mainViewInput20 != null) {
                    mainViewInput20.updateDeviceInfo(DeviceInfoConstants.EXCEPTION_INTERNAL_HIGH_TEMP);
                }
                readDeviceMode();
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

    public void checkRemoteConfig() {
        if (!MainPresenterTemporaryModel.INSTANCE.checkEulaVersion(this.aContext, this.mRouter, "release") && !MainPresenterTemporaryModel.INSTANCE.checkPrivacyPolicyVersion(this.aContext, this.mRouter, "release")) {
            checkNotification();
        }
    }

    private final boolean checkNotification() {
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity == null) {
            DebugLogUtil.INSTANCE.w("RemoteConfigUtil.mNotificationEntity is null.");
            return false;
        }
        String localeCountry = RemoteConfigUtil.INSTANCE.getLocaleCountry();
        if (localeCountry == null) {
            DebugLogUtil.INSTANCE.w("RemoteConfigUtil.localeCountry is null.");
            return false;
        }
        if (!RemoteConfigUtil.shouldShowNotification$default(RemoteConfigUtil.INSTANCE, this.aContext, localeCountry, Integer.valueOf(mNotificationEntity.getVersion()), mNotificationEntity.getDate(), (Date) null, 16, (Object) null)) {
            return false;
        }
        downloadImage(this.aContext, localeCountry, mNotificationEntity);
        return true;
    }

    private final void downloadImage(Context context, String str, NotificationEntity notificationEntity) {
        Unit unit;
        String path = notificationEntity.getPath();
        if (path != null) {
            File file = new File(context.getApplicationContext().getCacheDir(), path);
            S3FileManager.INSTANCE.download(context, path, file, new MainPresenter$downloadImage$1$1(this, notificationEntity, file, context, str));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            MainViewInput mainViewInput = this.aView;
            if (mainViewInput != null) {
                mainViewInput.showNotification(notificationEntity.getButtonPreference(), notificationEntity.getTitle(), notificationEntity.getSubtitle(), notificationEntity.getDescription(), notificationEntity.getUrl(), (Bitmap) null);
            }
            RemoteConfigUtil.INSTANCE.saveNotificationVersion(context, str, notificationEntity.getVersion());
        }
    }

    public CapabilityEntity getCapability() {
        return this.mDeviceInfoInteractor.getCapability(this.aContext);
    }

    public AutoModeStatus getAutoModeStatus() {
        return this.mDeviceInfoInteractor.getAutoModeStatus(this.aContext);
    }

    public void transitToConnection(Bundle bundle) {
        this.mRouter.goToConnectionAndClear(bundle);
    }

    public void transitToSetting() {
        this.mRouter.goToSetting();
    }

    private final TempBoostOption getOption1ByValue(String str) {
        TempBoostOption tempBoostOption;
        TempBoostOption[] values = TempBoostOption.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                tempBoostOption = null;
                break;
            }
            tempBoostOption = values[i];
            if (Intrinsics.areEqual((Object) String.valueOf(tempBoostOption.getCode()), (Object) str)) {
                break;
            }
            i++;
        }
        if (tempBoostOption != null) {
            return tempBoostOption;
        }
        DebugLogUtil.INSTANCE.e("option1 value is error:" + str);
        return null;
    }

    private final TempWaveOption getOption2ByValue(String str) {
        TempWaveOption tempWaveOption;
        TempWaveOption[] values = TempWaveOption.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                tempWaveOption = null;
                break;
            }
            tempWaveOption = values[i];
            if (Intrinsics.areEqual((Object) String.valueOf(tempWaveOption.getCode()), (Object) str)) {
                break;
            }
            i++;
        }
        if (tempWaveOption != null) {
            return tempWaveOption;
        }
        DebugLogUtil.INSTANCE.e("option2 value is error:" + str);
        return null;
    }

    public void transitToDeviceInfo(Integer num) {
        MainActivity.Companion.Page page;
        MainViewInput mainViewInput = this.aView;
        Boolean valueOf = mainViewInput != null ? Boolean.valueOf(mainViewInput.isActiveSmartMode()) : null;
        MainViewInput mainViewInput2 = this.aView;
        Boolean valueOf2 = mainViewInput2 != null ? Boolean.valueOf(mainViewInput2.isSmartMixTypeCool()) : null;
        MainViewInput mainViewInput3 = this.aView;
        if (mainViewInput3 == null || (page = mainViewInput3.getLastSelectedPage()) == null) {
            page = MainActivity.Companion.Page.COOL;
        }
        this.mRouter.goToDeviceInfo(num, this.mCurrentTemperature, this.mCurrentFinTemperature, this.mCurrentCoolHeatTypeCode, valueOf2 != null ? valueOf2.booleanValue() : false, new Pair(null, null), valueOf != null ? valueOf.booleanValue() : false, page, this.mDeviceModeActionCode);
    }

    public void transitToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity) {
        this.mRouter.goToTagInfo(z, z2, notifyTagSensorDataEntity);
    }

    private final void handleAutoStart(BleDataEntity bleDataEntity) {
        MainViewInput mainViewInput;
        if (bleDataEntity.getData() != null && (mainViewInput = this.aView) != null) {
            mainViewInput.updateIsAutoStartEnable(AutoStartEntity.Companion.getObject(bleDataEntity) != null);
        }
    }

    private final void handleDeviceTemp(BleDataEntity bleDataEntity) {
        MainViewInput mainViewInput;
        if (bleDataEntity.getData() != null) {
            SensorDataEntity object = SensorDataEntity.Companion.getObject(bleDataEntity);
            if (object instanceof NotifyDeviceSensorDataEntity) {
                MainViewInput mainViewInput2 = this.aView;
                if (mainViewInput2 != null) {
                    mainViewInput2.updateDeviceTemp(((NotifyDeviceSensorDataEntity) object).getTec1Temp());
                }
                NotifyDeviceSensorDataEntity notifyDeviceSensorDataEntity = (NotifyDeviceSensorDataEntity) object;
                this.mCurrentTemperature = notifyDeviceSensorDataEntity.getTec1Temp();
                this.mCurrentFinTemperature = notifyDeviceSensorDataEntity.getFinTemp();
                if (notifyDeviceSensorDataEntity.getFinTemp() >= 41.0f && (mainViewInput = this.aView) != null) {
                    mainViewInput.updateDeviceInfo(DeviceInfoConstants.NORMAL_MOVEMENT_HIGH_TEMP);
                }
                MainViewInput mainViewInput3 = this.aView;
                if (mainViewInput3 != null) {
                    mainViewInput3.updateStatusText(notifyDeviceSensorDataEntity);
                }
            }
            if ((object instanceof NotifyTagSensorDataEntity) && !this.mIsTagUpdate && !this.isShowTagRegistDialog) {
                boolean z = true;
                if (getIsRegisterTag()) {
                    NotifyTagSensorDataEntity notifyTagSensorDataEntity = (NotifyTagSensorDataEntity) object;
                    if (notifyTagSensorDataEntity.getTagFWVersionCode() < Integer.parseInt(UpdateVersionConstant.TAG_FIRMWARE_VERSION_CODE) && notifyTagSensorDataEntity.getTagFWVersionCode() != 0) {
                        this.mIsTagUpdate = true;
                        MainViewInput mainViewInput4 = this.aView;
                        if (mainViewInput4 != null) {
                            mainViewInput4.showTagUpdateMessage();
                            return;
                        }
                        return;
                    }
                }
                NotifyTagSensorDataEntity notifyTagSensorDataEntity2 = (NotifyTagSensorDataEntity) object;
                if (notifyTagSensorDataEntity2.getDataReceivedStatus() != TagSensorDataReceivedStatus.RECEIVING) {
                    z = false;
                }
                ThreadUtils.runOnUiThread(new MainPresenter$$ExternalSyntheticLambda3(this, z, object));
                MainViewInput mainViewInput5 = this.aView;
                if (mainViewInput5 != null) {
                    mainViewInput5.updateTagStatusText(notifyTagSensorDataEntity2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void handleDeviceTemp$lambda$60(MainPresenter mainPresenter, boolean z, SensorDataEntity sensorDataEntity) {
        Intrinsics.checkNotNullParameter(mainPresenter, "this$0");
        CustomCountDown customCountDown = mainPresenter.mCountDown;
        if (customCountDown != null) {
            customCountDown.cancel();
        }
        CustomCountDown customCountDown2 = new CustomCountDown(65000, 1000);
        mainPresenter.mCountDown = customCountDown2;
        customCountDown2.start();
        MainViewInput mainViewInput = mainPresenter.aView;
        if (mainViewInput != null) {
            mainViewInput.updateSmartModeIconDisplay(z);
        }
        MainViewInput mainViewInput2 = mainPresenter.aView;
        if (mainViewInput2 != null) {
            mainViewInput2.updateTagMiniInfoView(mainPresenter.isTagRegistered(), (NotifyTagSensorDataEntity) sensorDataEntity);
        }
        MainViewInput mainViewInput3 = mainPresenter.aView;
        if (mainViewInput3 != null) {
            mainViewInput3.updateTagEntity((NotifyTagSensorDataEntity) sensorDataEntity, z);
        }
    }

    private final void handleThermoStatus(BleDataEntity bleDataEntity) {
        MainViewInput mainViewInput;
        ThermoControlStatusEntity object = ThermoControlStatusEntity.Companion.toObject(bleDataEntity);
        if (object != null && (mainViewInput = this.aView) != null) {
            mainViewInput.updateStatusText(object);
        }
    }

    private final void openThermoStatusNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_READ_THERMO_CONTROL_STATUS, (String) null, true, 2, (Object) null);
    }

    public final void readDeviceTempNotification() {
        BleInteractorInput.DefaultImpls.read$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY, (String) null, 2, (Object) null);
    }

    public final void openDeviceTempNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY, (String) null, true, 2, (Object) null);
    }

    public final void closeDeviceTempNotification() {
        BleInteractorInput.DefaultImpls.toggleNotification$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_TEMPERATURE_HUMIDUTY, (String) null, false, 2, (Object) null);
    }

    public void savePagePosition(int i) {
        this.mDeviceInfoInteractor.savePagePosition(this.aContext, i);
    }

    public int getPagePosition() {
        return this.mDeviceInfoInteractor.getPagePosition(this.aContext);
    }

    public boolean isConnected() {
        return BleInteractor.Companion.getMConnectionStatus() == BleConnStatusCode.CONNECTED;
    }

    public void transitToSplash() {
        this.mRouter.goToSplash();
    }

    public void transitToSupport() {
        this.mRouter.transitToSupport(this.aContext);
    }

    public boolean getIsRegisterTag() {
        String tagBDAddress = this.mTagInfoInteractor.getTagBDAddress(this.aContext);
        boolean z = false;
        if (tagBDAddress == null) {
            return false;
        }
        if (tagBDAddress.length() == 0) {
            z = true;
        }
        return !z;
    }

    public boolean getAutoStartState() {
        return this.mDeviceInfoInteractor.getAutoStartEnable(this.aContext);
    }

    public void saveAutoStartState(boolean z) {
        this.mDeviceInfoInteractor.saveAutoStartEnable(this.aContext, z);
    }

    public void setAutoStart(boolean z) {
        byte[] bArr = new AutoStartEntity(z ? AutoStartOperationCode.CTRL_REGIST : AutoStartOperationCode.CTRL_CLEAR, z ? AutoStartDeviceModeActionCode.LAST_MODE : null, (Integer) null, (CoolHeatTypeCode) null, (TemperatureCoolHeatTypeCode) null, (Integer) null, (SmartModePreference) null, (SmartModePreference) null, (Integer) null, (Integer) null, (TempBoostOption) null, (TempWaveOption) null, 4092, (DefaultConstructorMarker) null).toByte();
        if (bArr != null) {
            BleInteractorInput.DefaultImpls.write$default(this.mBleInteractor, GattProfileConstant.CHARACTERISTIC_AUTO_START, (String) null, bArr, 2, (Object) null);
        }
    }

    public void saveIsShownSmartCoolBefore(boolean z) {
        this.mUserInfoInteractor.saveIsShownSmartCoolBefore(this.aContext, z);
    }

    public boolean getIsShownSmartCoolBefore() {
        Boolean isShownSmartCoolBefore = this.mUserInfoInteractor.getIsShownSmartCoolBefore(this.aContext);
        if (isShownSmartCoolBefore != null) {
            return isShownSmartCoolBefore.booleanValue();
        }
        return false;
    }

    public void saveIsShownSmartWarmBefore(boolean z) {
        this.mUserInfoInteractor.saveIsShownSmartWarmBefore(this.aContext, z);
    }

    public boolean getIsShownSmartWarmBefore() {
        Boolean isShownSmartWarmBefore = this.mUserInfoInteractor.getIsShownSmartWarmBefore(this.aContext);
        if (isShownSmartWarmBefore != null) {
            return isShownSmartWarmBefore.booleanValue();
        }
        return false;
    }

    public void setSmartCoolPreference(SmartModePreference smartModePreference) {
        Intrinsics.checkNotNullParameter(smartModePreference, "aSmartPreference");
        this.mUserInfoInteractor.saveSmartCoolPreference(this.aContext, smartModePreference.getCode());
    }

    public SmartModePreference getSmartCoolPreference() {
        SmartModePreference smartModePreference;
        SmartModePreference[] values = SmartModePreference.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                smartModePreference = null;
                break;
            }
            smartModePreference = values[i];
            int code = smartModePreference.getCode();
            Integer smartCoolPreference = this.mUserInfoInteractor.getSmartCoolPreference(this.aContext);
            if (smartCoolPreference != null && code == smartCoolPreference.intValue()) {
                break;
            }
            i++;
        }
        return smartModePreference == null ? SmartModePreference.OFF : smartModePreference;
    }

    public void setSmartWarmPreference(SmartModePreference smartModePreference) {
        Intrinsics.checkNotNullParameter(smartModePreference, "aSmartPreference");
        this.mUserInfoInteractor.saveSmartWarmPreference(this.aContext, smartModePreference.getCode());
    }

    public SmartModePreference getSmartWarmPreference() {
        SmartModePreference smartModePreference;
        SmartModePreference[] values = SmartModePreference.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                smartModePreference = null;
                break;
            }
            smartModePreference = values[i];
            int code = smartModePreference.getCode();
            Integer smartWarmPreference = this.mUserInfoInteractor.getSmartWarmPreference(this.aContext);
            if (smartWarmPreference != null && code == smartWarmPreference.intValue()) {
                break;
            }
            i++;
        }
        return smartModePreference == null ? SmartModePreference.OFF : smartModePreference;
    }

    public void setSmartMixPreference(boolean z) {
        this.mUserInfoInteractor.saveSmartMixPreference(this.aContext, z);
    }

    public boolean getSmartMixPreference() {
        Boolean smartMixPreference = this.mUserInfoInteractor.getSmartMixPreference(this.aContext);
        if (smartMixPreference != null) {
            return smartMixPreference.booleanValue();
        }
        return true;
    }

    public void setSmartCoolTempSwitchThreshold(double d) {
        this.mUserInfoInteractor.saveSmartCoolTempSwitchThreshold(this.aContext, d);
    }

    public double getSmartCoolTempSwitchThreshold() {
        Double smartCoolTempSwitchThreshold = this.mUserInfoInteractor.getSmartCoolTempSwitchThreshold(this.aContext);
        return smartCoolTempSwitchThreshold != null ? smartCoolTempSwitchThreshold.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public void setSmartWarmTempSwitchThreshold(double d) {
        this.mUserInfoInteractor.saveSmartWarmTempSwitchThreshold(this.aContext, d);
    }

    public double getSmartWarmTempSwitchThreshold() {
        Double smartWarmTempSwitchThreshold = this.mUserInfoInteractor.getSmartWarmTempSwitchThreshold(this.aContext);
        return smartWarmTempSwitchThreshold != null ? smartWarmTempSwitchThreshold.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public boolean isTagRegistered() {
        CharSequence tagBDAddress = this.mTagInfoInteractor.getTagBDAddress(this.aContext);
        return !(tagBDAddress == null || tagBDAddress.length() == 0);
    }

    public void startDfu() {
        this.mTagDfuInteractor.startDfu();
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
            MainViewInput mainViewInput = this.aView;
            if (mainViewInput != null) {
                mainViewInput.showDfuComplete();
            }
            this.mIsTagUpdate = false;
            return;
        }
        MainViewInput mainViewInput2 = this.aView;
        if (mainViewInput2 != null) {
            mainViewInput2.hiddenProgress();
        }
        MainViewInput mainViewInput3 = this.aView;
        if (mainViewInput3 != null) {
            mainViewInput3.hiddenTagDfuProgress();
        }
    }

    public void onTagDfuFailed(String str) {
        Intrinsics.checkNotNullParameter(str, "aErrorMessage");
        if (this.mIsTagUpdate) {
            MainViewInput mainViewInput = this.aView;
            if (mainViewInput != null) {
                mainViewInput.showDfuFail();
            }
            this.mIsTagUpdate = false;
        }
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

    public void registerTag(String str, TagDataEntity tagDataEntity, String str2) {
        Intrinsics.checkNotNullParameter(str, "bdAddress");
        Intrinsics.checkNotNullParameter(tagDataEntity, "entity");
        Intrinsics.checkNotNullParameter(str2, "deviceName");
        this.mTagInfoInteractor.saveTagBDAddress(this.aContext, str);
        this.mTagInfoInteractor.saveTagInfo(this.aContext, tagDataEntity);
        this.mTagInfoInteractor.saveTagModel(this.aContext, str2);
        writeAuthentication(new AuthenticationTagEntity(TagStatus.REGISTER, str, TagDeviceType.REON_TAG));
    }

    public void unregisterTag() {
        this.mTagInfoInteractor.removeTagInfo(this.aContext);
        this.mTagInfoInteractor.removeTagBDAddress(this.aContext);
        this.mTagInfoInteractor.removeTagModel(this.aContext);
        writeAuthentication(new AuthenticationTagUnregisterEntity(TagStatus.UNREGISTER, TagDeviceType.REON_TAG));
    }

    public void onTagDfuProgressChanged(int i) {
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.updateDfuProgress(i);
        }
    }

    public void onTagDfuDeviceDisconnecting() {
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.showDfuDisconnect();
        }
    }

    public void onTagDfuProcessStarting() {
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.showDfuStarting();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/presenter/MainPresenter$CustomCountDown;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Ljp/co/sony/reonpocket/modules/main/presenter/MainPresenter;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainPresenter.kt */
    public final class CustomCountDown extends CountDownTimer {
        public void onTick(long j) {
        }

        public CustomCountDown(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            ThreadUtils.runOnUiThread(new MainPresenter$CustomCountDown$$ExternalSyntheticLambda0(MainPresenter.this));
        }

        /* access modifiers changed from: private */
        public static final void onFinish$lambda$0(MainPresenter mainPresenter) {
            Intrinsics.checkNotNullParameter(mainPresenter, "this$0");
            MainViewInput access$getAView$p = mainPresenter.aView;
            if (access$getAView$p != null) {
                access$getAView$p.updateSmartModeIconDisplay(false);
            }
            MainViewInput access$getAView$p2 = mainPresenter.aView;
            if (access$getAView$p2 != null) {
                access$getAView$p2.updateSmartWarmTagNoReceiving();
            }
        }
    }

    public void onTagWriteSuccess() {
        DebugLogUtil.INSTANCE.d("onTagWriteSuccess");
    }

    public void onTagWriteFailed() {
        DebugLogUtil.INSTANCE.d("onTagWriteFailed");
        MainViewInput mainViewInput = this.aView;
        if (mainViewInput != null) {
            mainViewInput.showTagRegistrationFailedDialog();
        }
        MainViewInput mainViewInput2 = this.aView;
        if (mainViewInput2 != null) {
            mainViewInput2.unRegisterTagStatus();
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
