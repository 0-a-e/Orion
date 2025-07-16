package jp.co.sony.reonpocket.util.service;

import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractor;
import jp.co.sony.reonpocket.data.interactor.UserInfoInteractorInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.LocaleUtil$$ExternalSyntheticApiModelOutline0;
import jp.co.sony.reonpocket.util.PendingIntentExtensionKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u001b\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020\"H\u0002J\u0012\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\"H\u0002J\b\u00100\u001a\u000201H\u0016J\u0014\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u00106\u001a\u000201H\u0016J\b\u00107\u001a\u000201H\u0016J \u00108\u001a\u00020\u00192\u0006\u00104\u001a\u0002052\u0006\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\u0019H\u0016J\b\u0010;\u001a\u000201H\u0016J\u0010\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\"H\u0002J\u0006\u0010>\u001a\u000201R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\b\u0018\u00010&R\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006@"}, d2 = {"Ljp/co/sony/reonpocket/util/service/LaunchApplicationNotificationService;", "Landroid/app/Service;", "Lorg/altbeacon/beacon/BeaconConsumer;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "keyguard", "Landroid/app/KeyguardManager;", "getKeyguard", "()Landroid/app/KeyguardManager;", "setKeyguard", "(Landroid/app/KeyguardManager;)V", "keylock", "Landroid/app/KeyguardManager$KeyguardLock;", "getKeylock", "()Landroid/app/KeyguardManager$KeyguardLock;", "setKeylock", "(Landroid/app/KeyguardManager$KeyguardLock;)V", "mBeaconManager", "Lorg/altbeacon/beacon/BeaconManager;", "mCurrentBatteryRemainingTime", "", "mMonitorNotifier", "jp/co/sony/reonpocket/util/service/LaunchApplicationNotificationService$mMonitorNotifier$1", "Ljp/co/sony/reonpocket/util/service/LaunchApplicationNotificationService$mMonitorNotifier$1;", "mRangeNotifier", "Lorg/altbeacon/beacon/RangeNotifier;", "mRegion", "Lorg/altbeacon/beacon/Region;", "mTargetUUID", "", "mUserInfoInteractor", "Ljp/co/sony/reonpocket/data/interactor/UserInfoInteractorInput;", "wakelock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "getWakelock", "()Landroid/os/PowerManager$WakeLock;", "setWakelock", "(Landroid/os/PowerManager$WakeLock;)V", "convertOwnerId2UUID", "getNotification", "Landroid/app/Notification;", "message", "onBeaconServiceConnect", "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "flags", "startId", "stopAlarmService", "updateNotification", "newMessage", "wakeFromSleep", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LaunchApplicationNotificationService.kt */
public final class LaunchApplicationNotificationService extends Service implements BeaconConsumer {
    public static final int $stable = 8;
    public static final long BEACON_SCAN_CYCLE_MS = 60000;
    public static final long BEACON_SCAN_PERIOD_MS = 1000;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOTIFY_ID = 2;
    public static final String REQUEST_CODE = "REQUEST_CODE";
    public static final String REQUEST_LOW_BATTERY_NOTIFICATION_1 = "REQUEST_LOW_BATTERY_NOTIFICATION_1";
    public static final String REQUEST_LOW_BATTERY_NOTIFICATION_10 = "REQUEST_LOW_BATTERY_NOTIFICATION_10";
    public static final String REQUEST_STOP_NOTIFICATION = "REQUEST_STOP_NOTIFICATION";
    private static boolean mIsNotificationShown = false;
    public static final String sBeaconFormat = "m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24";
    /* access modifiers changed from: private */
    public static final int sMinimumBatteryTimeInSec = ((int) TimeUnit.MINUTES.toSeconds(10));
    /* access modifiers changed from: private */
    public static final long sMinimumIntervalInMills = TimeUnit.HOURS.toMillis(1);
    private Context context;
    private KeyguardManager keyguard;
    private KeyguardManager.KeyguardLock keylock;
    /* access modifiers changed from: private */
    public BeaconManager mBeaconManager;
    private int mCurrentBatteryRemainingTime;
    private final LaunchApplicationNotificationService$mMonitorNotifier$1 mMonitorNotifier = new LaunchApplicationNotificationService$mMonitorNotifier$1(this);
    private final RangeNotifier mRangeNotifier = new LaunchApplicationNotificationService$$ExternalSyntheticLambda4(this);
    private Region mRegion;
    private String mTargetUUID = "";
    private final UserInfoInteractorInput mUserInfoInteractor = new UserInfoInteractor();
    private PowerManager.WakeLock wakelock;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/util/service/LaunchApplicationNotificationService$Companion;", "", "()V", "BEACON_SCAN_CYCLE_MS", "", "BEACON_SCAN_PERIOD_MS", "NOTIFY_ID", "", "REQUEST_CODE", "", "REQUEST_LOW_BATTERY_NOTIFICATION_1", "REQUEST_LOW_BATTERY_NOTIFICATION_10", "REQUEST_STOP_NOTIFICATION", "mIsNotificationShown", "", "sBeaconFormat", "sMinimumBatteryTimeInSec", "getSMinimumBatteryTimeInSec", "()I", "sMinimumIntervalInMills", "getSMinimumIntervalInMills", "()J", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LaunchApplicationNotificationService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getSMinimumIntervalInMills() {
            return LaunchApplicationNotificationService.sMinimumIntervalInMills;
        }

        public final int getSMinimumBatteryTimeInSec() {
            return LaunchApplicationNotificationService.sMinimumBatteryTimeInSec;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        BroadcastReceiver timeActionNotificationReceiver = new TimeActionNotificationReceiver();
        IntentFilter intentFilter = new IntentFilter("TIMER_ACTION");
        if (Build.VERSION.SDK_INT >= 34) {
            Intent unused = registerReceiver(timeActionNotificationReceiver, intentFilter, 4);
        } else {
            registerReceiver(timeActionNotificationReceiver, intentFilter);
        }
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(this);
        Intrinsics.checkNotNullExpressionValue(instanceForApplication, "getInstanceForApplication(...)");
        this.mBeaconManager = instanceForApplication;
        BeaconManager beaconManager = null;
        if (instanceForApplication == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            instanceForApplication = null;
        }
        instanceForApplication.getBeaconParsers().add(new BeaconParser().setBeaconLayout(sBeaconFormat));
        String convertOwnerId2UUID = convertOwnerId2UUID();
        this.mTargetUUID = convertOwnerId2UUID;
        this.mRegion = new Region("unique-id-123456789", Identifier.parse(convertOwnerId2UUID), (Identifier) null, (Identifier) null);
        BeaconManager beaconManager2 = this.mBeaconManager;
        if (beaconManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager2 = null;
        }
        beaconManager2.setForegroundScanPeriod(1000);
        BeaconManager beaconManager3 = this.mBeaconManager;
        if (beaconManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager3 = null;
        }
        beaconManager3.setBackgroundScanPeriod(1000);
        BeaconManager beaconManager4 = this.mBeaconManager;
        if (beaconManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager4 = null;
        }
        BeaconManager beaconManager5 = this.mBeaconManager;
        if (beaconManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager5 = null;
        }
        beaconManager4.setForegroundBetweenScanPeriod(BEACON_SCAN_CYCLE_MS - beaconManager5.getForegroundScanPeriod());
        BeaconManager beaconManager6 = this.mBeaconManager;
        if (beaconManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager6 = null;
        }
        BeaconManager beaconManager7 = this.mBeaconManager;
        if (beaconManager7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager7 = null;
        }
        beaconManager6.setBackgroundBetweenScanPeriod(BEACON_SCAN_CYCLE_MS - beaconManager7.getBackgroundScanPeriod());
        BeaconManager beaconManager8 = this.mBeaconManager;
        if (beaconManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager8 = null;
        }
        beaconManager8.setEnableScheduledScanJobs(false);
        BeaconManager beaconManager9 = this.mBeaconManager;
        if (beaconManager9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
        } else {
            beaconManager = beaconManager9;
        }
        beaconManager.bind(this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Notification notification;
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!mIsNotificationShown) {
            String format = new SimpleDateFormat("hh:mm:ss", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            Intrinsics.checkNotNull(format);
            debugLogUtil.d(format);
            String string = getString(R.string.setting_android_notification_bar_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            Intrinsics.checkNotNull(launchIntentForPackage);
            Intent flags = launchIntentForPackage.setPackage((String) null).setFlags(270532608);
            Intrinsics.checkNotNullExpressionValue(flags, "setFlags(...)");
            PendingIntent activity = PendingIntent.getActivity(this.context, 1, flags, PendingIntentExtensionKt.asPendingIntentMutableFlag(134217728));
            Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                LocaleUtil$$ExternalSyntheticApiModelOutline0.m();
                CharSequence charSequence = string;
                NotificationChannel m = LocaleUtil$$ExternalSyntheticApiModelOutline0.m("jp.co.sony.reonpocket", charSequence, 1);
                m.setDescription("Silent Notification");
                m.setImportance(1);
                m.setLockscreenVisibility(0);
                m.setSound((Uri) null, (AudioAttributes) null);
                m.enableLights(false);
                m.setLightColor(-16776961);
                m.setVibrationPattern(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
                m.enableVibration(true);
                notificationManager.createNotificationChannel(m);
                LocaleUtil$$ExternalSyntheticApiModelOutline0.m$1();
                notification = LocaleUtil$$ExternalSyntheticApiModelOutline0.m((Context) this, "jp.co.sony.reonpocket").setContentTitle(charSequence).setSmallIcon(R.mipmap.ic_notification).setContentText("").setAutoCancel(true).setContentIntent(activity).setWhen(System.currentTimeMillis()).setPriority(-2).setCategory(NotificationCompat.CATEGORY_SERVICE).build();
            } else {
                notification = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_notification).setContentTitle(string).setContentText("").setVibrate(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0}).setContentIntent(activity).build();
            }
            Intrinsics.checkNotNull(notification);
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(1, notification, 16);
            } else {
                startForeground(1, notification);
            }
            mIsNotificationShown = true;
        }
        String stringExtra = intent.getStringExtra(REQUEST_CODE);
        if (stringExtra == null || !Intrinsics.areEqual((Object) stringExtra, (Object) REQUEST_LOW_BATTERY_NOTIFICATION_1)) {
            return 2;
        }
        String string2 = getString(R.string.setting_push_notification_battery_remaining_almost_zero_description);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        updateNotification(string2);
        return 2;
    }

    public void stopAlarmService() {
        PendingIntent service = PendingIntent.getService(this.context, 0, new Intent(this.context, LaunchApplicationNotificationService.class), PendingIntentExtensionKt.asPendingIntentMutableFlag(134217728));
        Context context2 = this.context;
        Intrinsics.checkNotNull(context2);
        Object systemService = context2.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).cancel(service);
    }

    public void onDestroy() {
        super.onDestroy();
        new TimeActionNotificationReceiver();
        stopAlarmService();
        BeaconManager beaconManager = this.mBeaconManager;
        if (beaconManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager = null;
        }
        beaconManager.unbind(this);
        DebugLogUtil.INSTANCE.e("unbind beacon service");
        stopSelf();
    }

    public final KeyguardManager getKeyguard() {
        return this.keyguard;
    }

    public final void setKeyguard(KeyguardManager keyguardManager) {
        this.keyguard = keyguardManager;
    }

    public final KeyguardManager.KeyguardLock getKeylock() {
        return this.keylock;
    }

    public final void setKeylock(KeyguardManager.KeyguardLock keyguardLock) {
        this.keylock = keyguardLock;
    }

    public final PowerManager.WakeLock getWakelock() {
        return this.wakelock;
    }

    public final void setWakelock(PowerManager.WakeLock wakeLock) {
        this.wakelock = wakeLock;
    }

    public final void wakeFromSleep() {
        Object systemService = getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(805306394, "AppName:tag");
        this.wakelock = newWakeLock;
        Intrinsics.checkNotNull(newWakeLock);
        newWakeLock.acquire(20000);
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        this.keyguard = keyguardManager;
        Intrinsics.checkNotNull(keyguardManager);
        KeyguardManager.KeyguardLock newKeyguardLock = keyguardManager.newKeyguardLock("AppName:tag");
        this.keylock = newKeyguardLock;
        Intrinsics.checkNotNull(newKeyguardLock);
        newKeyguardLock.disableKeyguard();
    }

    private final String convertOwnerId2UUID() {
        String str;
        String ownerID = this.mUserInfoInteractor.getOwnerID(this);
        List split$default = ownerID != null ? StringsKt.split$default((CharSequence) ownerID, new String[]{" "}, false, 0, 6, (Object) null) : null;
        String str2 = "";
        if (split$default != null) {
            int i = 0;
            for (Object next : split$default) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) next;
                if (str3.length() != 0) {
                    if (i == 4 || i == 6 || i == 8 || i == 10) {
                        str2 = str2 + "-";
                    }
                    Integer valueOf = Integer.valueOf(str3);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    if (Integer.toHexString(valueOf.intValue()).length() < 2) {
                        Integer valueOf2 = Integer.valueOf(str3);
                        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
                        str = "0" + Integer.toHexString(valueOf2.intValue());
                    } else {
                        Integer valueOf3 = Integer.valueOf(str3);
                        Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(...)");
                        str = Integer.toHexString(valueOf3.intValue());
                    }
                    str2 = str2 + str;
                }
                i = i2;
            }
        }
        return str2;
    }

    public void onBeaconServiceConnect() {
        BeaconManager beaconManager = this.mBeaconManager;
        Region region = null;
        if (beaconManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager = null;
        }
        beaconManager.removeAllMonitorNotifiers();
        BeaconManager beaconManager2 = this.mBeaconManager;
        if (beaconManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager2 = null;
        }
        beaconManager2.removeAllRangeNotifiers();
        BeaconManager beaconManager3 = this.mBeaconManager;
        if (beaconManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager3 = null;
        }
        Collection<Region> rangedRegions = beaconManager3.getRangedRegions();
        Intrinsics.checkNotNullExpressionValue(rangedRegions, "getRangedRegions(...)");
        for (Region region2 : rangedRegions) {
            BeaconManager beaconManager4 = this.mBeaconManager;
            if (beaconManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
                beaconManager4 = null;
            }
            beaconManager4.stopRangingBeaconsInRegion(region2);
        }
        BeaconManager beaconManager5 = this.mBeaconManager;
        if (beaconManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager5 = null;
        }
        Collection<Region> monitoredRegions = beaconManager5.getMonitoredRegions();
        Intrinsics.checkNotNullExpressionValue(monitoredRegions, "getMonitoredRegions(...)");
        for (Region region3 : monitoredRegions) {
            BeaconManager beaconManager6 = this.mBeaconManager;
            if (beaconManager6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
                beaconManager6 = null;
            }
            beaconManager6.stopMonitoringBeaconsInRegion(region3);
        }
        BeaconManager beaconManager7 = this.mBeaconManager;
        if (beaconManager7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager7 = null;
        }
        beaconManager7.addMonitorNotifier(this.mMonitorNotifier);
        BeaconManager beaconManager8 = this.mBeaconManager;
        if (beaconManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            beaconManager8 = null;
        }
        beaconManager8.addRangeNotifier(this.mRangeNotifier);
        try {
            BeaconManager beaconManager9 = this.mBeaconManager;
            if (beaconManager9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
                beaconManager9 = null;
            }
            Region region4 = this.mRegion;
            if (region4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRegion");
            } else {
                region = region4;
            }
            beaconManager9.startMonitoringBeaconsInRegion(region);
        } catch (RemoteException e) {
            DebugLogUtil.INSTANCE.e("TEST_IBEACON", "Exception" + e);
        }
    }

    /* access modifiers changed from: private */
    public static final void mRangeNotifier$lambda$4(LaunchApplicationNotificationService launchApplicationNotificationService, Collection collection, Region region) {
        Intrinsics.checkNotNullParameter(launchApplicationNotificationService, "this$0");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Beacon beacon = (Beacon) it.next();
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            Identifier id1 = beacon.getId1();
            Identifier id2 = beacon.getId2();
            Identifier id3 = beacon.getId3();
            double distance = beacon.getDistance();
            int rssi = beacon.getRssi();
            int txPower = beacon.getTxPower();
            debugLogUtil.e("TEST_IBEACON", "UUID:" + id1 + ", major:" + id2 + ", minor:" + id3 + ", Distance:" + distance + ",RSSI" + rssi + ", TxPower" + txPower);
            if (Intrinsics.areEqual((Object) beacon.getId1().toString(), (Object) launchApplicationNotificationService.mTargetUUID)) {
                DebugLogUtil.INSTANCE.e("TEST_IBEACON", "#### ターゲットBeacon検出");
                int i = beacon.getId2().toInt();
                int i2 = launchApplicationNotificationService.mCurrentBatteryRemainingTime;
                if (i != i2) {
                    i2 = beacon.getId2().toInt();
                }
                launchApplicationNotificationService.mCurrentBatteryRemainingTime = i2;
                if (i2 == 0) {
                    String string = launchApplicationNotificationService.getString(R.string.setting_push_notification_battery_remaining_almost_zero_description);
                    Intrinsics.checkNotNull(string);
                    launchApplicationNotificationService.updateNotification(string);
                    return;
                }
                return;
            }
        }
    }

    private final void updateNotification(String str) {
        Context context2 = this.context;
        Object systemService = context2 != null ? context2.getSystemService(TransferService.INTENT_KEY_NOTIFICATION) : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.cancel(2);
        notificationManager.notify(2, getNotification(str));
    }

    static /* synthetic */ Notification getNotification$default(LaunchApplicationNotificationService launchApplicationNotificationService, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return launchApplicationNotificationService.getNotification(str);
    }

    private final Notification getNotification(String str) {
        Notification notification;
        String format = new SimpleDateFormat("hh:mm:ss", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        Intrinsics.checkNotNull(format);
        debugLogUtil.d(format);
        Context context2 = this.context;
        Object systemService = context2 != null ? context2.getSystemService(TransferService.INTENT_KEY_NOTIFICATION) : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            LocaleUtil$$ExternalSyntheticApiModelOutline0.m();
            CharSequence charSequence = str;
            NotificationChannel m = LocaleUtil$$ExternalSyntheticApiModelOutline0.m("jp.co.sony.reonpocket", charSequence, 1);
            m.setDescription("Silent Notification");
            m.setImportance(1);
            m.setLockscreenVisibility(0);
            m.setSound((Uri) null, (AudioAttributes) null);
            m.enableLights(false);
            m.setLightColor(-16776961);
            m.setVibrationPattern(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
            m.enableVibration(true);
            notificationManager.createNotificationChannel(m);
            LocaleUtil$$ExternalSyntheticApiModelOutline0.m$1();
            notification = LocaleUtil$$ExternalSyntheticApiModelOutline0.m((Context) this, "jp.co.sony.reonpocket").setContentTitle(charSequence).setSmallIcon(R.mipmap.ic_notification).setContentText("").setAutoCancel(true).setWhen(System.currentTimeMillis()).setPriority(-2).setCategory(NotificationCompat.CATEGORY_SERVICE).build();
        } else {
            notification = new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.ic_notification).setContentTitle(str).setContentText("").setVibrate(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0}).build();
        }
        Intrinsics.checkNotNull(notification);
        return notification;
    }
}
