package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import jp.co.sony.reon.android.ble.BleManager;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.constant.TagGattProfileConstant;
import jp.co.sony.reon.android.ble.listener.DisconnectCallbackListener;
import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallback;
import jp.co.sony.reon.android.ble.listener.TagScanRegisterCallback;
import jp.co.sony.reonpocket.connection.ble.dfu.DfuManager;
import jp.co.sony.reonpocket.connection.log.LogManager;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.util.UuidHelperUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuProgressListener;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SB\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\b2\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J \u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\u001c\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018H\u0002J\u001c\u0010)\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018H\u0002J\u001c\u0010*\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u00100\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u00101\u001a\u00020\bH\u0016J\b\u00102\u001a\u00020\bH\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016JQ\u00105\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001072\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001072\b\u0010'\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010:JV\u0010;\u001a\u00020\b2L\u0010<\u001aH\u0012\u0013\u0012\u00110,¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012'\u0012%\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010=H\u0016J\u001e\u0010A\u001a\u00020\b2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\u001e\u0010B\u001a\u00020\b2\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016J\b\u0010C\u001a\u00020\bH\u0016J\u0018\u0010D\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020EH\u0016J%\u0010F\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u000107H\u0016¢\u0006\u0002\u0010HJ \u0010I\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u00182\u0006\u0010<\u001a\u00020KH\u0016J \u0010L\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010M\u001a\u00020NH\u0016J \u0010O\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010P\u001a\u00020\u000fH\u0016J\u000e\u0010Q\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010R\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010M\u001a\u00020NH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R@\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR@\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006T"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/BleInteractor;", "Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "()V", "mBleManager", "Ljp/co/sony/reon/android/ble/BleManager;", "value", "Lkotlin/Function1;", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "", "mDataReceivedCallbackListener", "getMDataReceivedCallbackListener", "()Lkotlin/jvm/functions/Function1;", "setMDataReceivedCallbackListener", "(Lkotlin/jvm/functions/Function1;)V", "mInitDeviceConnectStateCallbackListener", "", "getMInitDeviceConnectStateCallbackListener", "setMInitDeviceConnectStateCallbackListener", "mTagDataReceivedCallbackListener", "getMTagDataReceivedCallbackListener", "setMTagDataReceivedCallbackListener", "checkDfuMode", "aServiceUuidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "connect", "aContext", "Landroid/content/Context;", "aMacAddress", "disconnect", "disconnectTag", "executeDfu", "aDeviceName", "aDfuProgressListener", "Lno/nordicsemi/android/dfu/DfuProgressListener;", "executeTagDfu", "getIsTagConnected", "getLongUuidByShortUuid", "aServiceUuid", "aCharacteristicUuid", "getShortUuidByLongUuid", "getTagShortUuidByLongUuid", "handlerBleConnStatusPermissionCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "permission", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onCreate", "onDestroy", "onPause", "onResume", "read", "registerDfuProgressListener", "scanConnect", "aDeviceFilterNameArray", "", "aDfuDeviceFilterNameArray", "aOwnerId", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setConnectCallbackListener", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "aConnStatusCode", "setDataReceivedCallbackListener", "setTagDataReceivedCallbackListener", "tagDFUProcessAbort", "tagScan", "Ljp/co/sony/reon/android/ble/listener/TagScanRegisterCallback;", "tagScanConnect", "aDfuTagFilterNameArray", "(Landroid/content/Context;[Ljava/lang/String;)V", "tagScanNoReceiving", "aAddress", "Ljp/co/sony/reon/android/ble/listener/TagScanNoReceivingCallback;", "tagWrite", "aData", "", "toggleNotification", "aIsEnable", "unregisterDfuProgressListener", "write", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleInteractor.kt */
public final class BleInteractor implements BleInteractorInput {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean hasRequestDfu;
    /* access modifiers changed from: private */
    public static boolean isDFUMode;
    /* access modifiers changed from: private */
    public static Function2<? super BleConnStatusCode, ? super ArrayList<String>, Unit> mConnectCallbackListener;
    /* access modifiers changed from: private */
    public static BleConnStatusCode mConnectionStatus;
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<Integer, Function1<BleDataEntity, Unit>> mDataReceivedCallbackMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public static String mDeviceName;
    /* access modifiers changed from: private */
    public static boolean mIsConnected;
    /* access modifiers changed from: private */
    public static boolean mIsTagConnected;
    /* access modifiers changed from: private */
    public static String mMacAddress;
    /* access modifiers changed from: private */
    public static Function3<? super String, ? super BleConnStatusCode, ? super ArrayList<String>, Unit> mTagConnectCallbackListener;
    /* access modifiers changed from: private */
    public static String mTagDeviceName;
    /* access modifiers changed from: private */
    public static String mTagMacAddress;
    private BleManager mBleManager;
    private Function1<? super BleDataEntity, Unit> mDataReceivedCallbackListener;
    private Function1<? super Boolean, Unit> mInitDeviceConnectStateCallbackListener;
    private Function1<? super BleDataEntity, Unit> mTagDataReceivedCallbackListener;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleInteractor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant[] r0 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.PERMISSION_MISS_LOCATION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.PERMISSION_MISS_BLUETOOTH     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.interactor.BleInteractor.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR`\u0010\u000b\u001aH\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012'\u0012%\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u001c\u0012\u0004\u0012\u00020!\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\"0 ¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010.\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001c\u00101\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*Rw\u00104\u001a_\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012'\u0012%\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*R\u001c\u0010>\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*¨\u0006A"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/BleInteractor$Companion;", "", "()V", "hasRequestDfu", "", "getHasRequestDfu", "()Z", "setHasRequestDfu", "(Z)V", "isDFUMode", "setDFUMode", "mConnectCallbackListener", "Lkotlin/Function2;", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "Lkotlin/ParameterName;", "name", "aConnStatusCode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "aServiceUuidList", "", "getMConnectCallbackListener", "()Lkotlin/jvm/functions/Function2;", "setMConnectCallbackListener", "(Lkotlin/jvm/functions/Function2;)V", "mConnectionStatus", "getMConnectionStatus", "()Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "setMConnectionStatus", "(Ljp/co/sony/reonpocket/constant/BleConnStatusCode;)V", "mDataReceivedCallbackMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "getMDataReceivedCallbackMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "mDeviceName", "getMDeviceName", "()Ljava/lang/String;", "setMDeviceName", "(Ljava/lang/String;)V", "mIsConnected", "getMIsConnected", "setMIsConnected", "mIsTagConnected", "getMIsTagConnected", "setMIsTagConnected", "mMacAddress", "getMMacAddress", "setMMacAddress", "mTagConnectCallbackListener", "Lkotlin/Function3;", "aDeviceName", "getMTagConnectCallbackListener", "()Lkotlin/jvm/functions/Function3;", "setMTagConnectCallbackListener", "(Lkotlin/jvm/functions/Function3;)V", "mTagDeviceName", "getMTagDeviceName", "setMTagDeviceName", "mTagMacAddress", "getMTagMacAddress", "setMTagMacAddress", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleInteractor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getMIsConnected() {
            return BleInteractor.mIsConnected;
        }

        public final void setMIsConnected(boolean z) {
            BleInteractor.mIsConnected = z;
        }

        public final String getMMacAddress() {
            return BleInteractor.mMacAddress;
        }

        public final void setMMacAddress(String str) {
            BleInteractor.mMacAddress = str;
        }

        public final boolean getMIsTagConnected() {
            return BleInteractor.mIsTagConnected;
        }

        public final void setMIsTagConnected(boolean z) {
            BleInteractor.mIsTagConnected = z;
        }

        public final String getMTagMacAddress() {
            return BleInteractor.mTagMacAddress;
        }

        public final void setMTagMacAddress(String str) {
            BleInteractor.mTagMacAddress = str;
        }

        public final String getMTagDeviceName() {
            return BleInteractor.mTagDeviceName;
        }

        public final void setMTagDeviceName(String str) {
            BleInteractor.mTagDeviceName = str;
        }

        public final String getMDeviceName() {
            return BleInteractor.mDeviceName;
        }

        public final void setMDeviceName(String str) {
            BleInteractor.mDeviceName = str;
        }

        public final BleConnStatusCode getMConnectionStatus() {
            return BleInteractor.mConnectionStatus;
        }

        public final void setMConnectionStatus(BleConnStatusCode bleConnStatusCode) {
            BleInteractor.mConnectionStatus = bleConnStatusCode;
        }

        public final boolean isDFUMode() {
            return BleInteractor.isDFUMode;
        }

        public final void setDFUMode(boolean z) {
            BleInteractor.isDFUMode = z;
        }

        public final boolean getHasRequestDfu() {
            return BleInteractor.hasRequestDfu;
        }

        public final void setHasRequestDfu(boolean z) {
            BleInteractor.hasRequestDfu = z;
        }

        public final Function2<BleConnStatusCode, ArrayList<String>, Unit> getMConnectCallbackListener() {
            return BleInteractor.mConnectCallbackListener;
        }

        public final void setMConnectCallbackListener(Function2<? super BleConnStatusCode, ? super ArrayList<String>, Unit> function2) {
            BleInteractor.mConnectCallbackListener = function2;
        }

        public final ConcurrentHashMap<Integer, Function1<BleDataEntity, Unit>> getMDataReceivedCallbackMap() {
            return BleInteractor.mDataReceivedCallbackMap;
        }

        public final Function3<String, BleConnStatusCode, ArrayList<String>, Unit> getMTagConnectCallbackListener() {
            return BleInteractor.mTagConnectCallbackListener;
        }

        public final void setMTagConnectCallbackListener(Function3<? super String, ? super BleConnStatusCode, ? super ArrayList<String>, Unit> function3) {
            BleInteractor.mTagConnectCallbackListener = function3;
        }
    }

    public final Function1<BleDataEntity, Unit> getMDataReceivedCallbackListener() {
        return this.mDataReceivedCallbackListener;
    }

    public final void setMDataReceivedCallbackListener(Function1<? super BleDataEntity, Unit> function1) {
        this.mDataReceivedCallbackListener = function1;
        int hashCode = hashCode();
        if (function1 == null) {
            ConcurrentHashMap<Integer, Function1<BleDataEntity, Unit>> concurrentHashMap = mDataReceivedCallbackMap;
            if (concurrentHashMap.containsKey(Integer.valueOf(hashCode))) {
                concurrentHashMap.remove(Integer.valueOf(hashCode));
                return;
            }
            return;
        }
        ConcurrentHashMap<Integer, Function1<BleDataEntity, Unit>> concurrentHashMap2 = mDataReceivedCallbackMap;
        if (!concurrentHashMap2.containsKey(Integer.valueOf(hashCode))) {
            concurrentHashMap2.put(Integer.valueOf(hashCode), function1);
        }
    }

    public final Function1<BleDataEntity, Unit> getMTagDataReceivedCallbackListener() {
        return this.mTagDataReceivedCallbackListener;
    }

    public final void setMTagDataReceivedCallbackListener(Function1<? super BleDataEntity, Unit> function1) {
        this.mTagDataReceivedCallbackListener = function1;
        int hashCode = hashCode();
        if (function1 == null) {
            ConcurrentHashMap<Integer, Function1<BleDataEntity, Unit>> concurrentHashMap = mDataReceivedCallbackMap;
            if (concurrentHashMap.containsKey(Integer.valueOf(hashCode))) {
                concurrentHashMap.remove(Integer.valueOf(hashCode));
                return;
            }
            return;
        }
        ConcurrentHashMap<Integer, Function1<BleDataEntity, Unit>> concurrentHashMap2 = mDataReceivedCallbackMap;
        if (!concurrentHashMap2.containsKey(Integer.valueOf(hashCode))) {
            concurrentHashMap2.put(Integer.valueOf(hashCode), function1);
        }
    }

    public final Function1<Boolean, Unit> getMInitDeviceConnectStateCallbackListener() {
        return this.mInitDeviceConnectStateCallbackListener;
    }

    public final void setMInitDeviceConnectStateCallbackListener(Function1<? super Boolean, Unit> function1) {
        this.mInitDeviceConnectStateCallbackListener = function1;
    }

    public boolean getIsTagConnected() {
        return mIsTagConnected;
    }

    public void onCreate(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        BleManager bleManager = new BleManager(UuidHelperUtil.INSTANCE.getOwnerId(context));
        this.mBleManager = bleManager;
        bleManager.bind(context);
        LogManager logManager = LogManager.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        logManager.createUploadLogJob(applicationContext);
    }

    public void onResume() {
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.registerClient();
        }
    }

    public void onPause() {
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.unregisterClient();
        }
    }

    public void onDestroy(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.unbind(context);
        }
        this.mBleManager = null;
        setMDataReceivedCallbackListener((Function1<? super BleDataEntity, Unit>) null);
        this.mInitDeviceConnectStateCallbackListener = null;
    }

    public void registerDfuProgressListener(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        DfuManager.INSTANCE.registerProgressListener(context);
    }

    public final void unregisterDfuProgressListener(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        DfuManager.INSTANCE.unregisterProgressListener(context);
    }

    public void connect(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aMacAddress");
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.connect(context, str, new BleInteractor$connect$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final BleConnStatusCode handlerBleConnStatusPermissionCode(ReasonCodeConstant reasonCodeConstant) {
        int i = WhenMappings.$EnumSwitchMapping$0[reasonCodeConstant.ordinal()];
        if (i == 1) {
            return BleConnStatusCode.PERMISSION_MISS_LOCATION;
        }
        if (i != 2) {
            return BleConnStatusCode.PERMISSION_MISS_UNEXPECTED;
        }
        return BleConnStatusCode.PERMISSION_MISS_BLUETOOTH;
    }

    public void scanConnect(Context context, String str, String[] strArr, String[] strArr2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str3, "aOwnerId");
        String str4 = null;
        if (str2 != null) {
            str4 = getLongUuidByShortUuid$default(this, str2, (String) null, 2, (Object) null);
        }
        String str5 = str4;
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.scanConnect(context, str, strArr, strArr2, str5, str3, new BleInteractor$scanConnect$2(this));
        }
    }

    public void disconnect() {
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.disconnect((DisconnectCallbackListener) null);
        }
    }

    public void disconnectTag() {
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.disconnectTag();
        }
    }

    public void toggleNotification(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        String longUuidByShortUuid = getLongUuidByShortUuid(str2, str);
        String longUuidByShortUuid$default = getLongUuidByShortUuid$default(this, str2, (String) null, 2, (Object) null);
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.setCharacteristicNotification(longUuidByShortUuid, longUuidByShortUuid$default, z, new BleInteractor$toggleNotification$1(this));
        }
    }

    public void read(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        String longUuidByShortUuid = getLongUuidByShortUuid(str2, str);
        String longUuidByShortUuid$default = getLongUuidByShortUuid$default(this, str2, (String) null, 2, (Object) null);
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.read(longUuidByShortUuid, longUuidByShortUuid$default, new BleInteractor$read$1(this));
        }
    }

    public void write(String str, String str2, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        Intrinsics.checkNotNullParameter(bArr, "aData");
        String longUuidByShortUuid = getLongUuidByShortUuid(str2, str);
        String longUuidByShortUuid$default = getLongUuidByShortUuid$default(this, str2, (String) null, 2, (Object) null);
        if (Intrinsics.areEqual((Object) str, (Object) GattProfileConstant.CHARACTERISTIC_REQUEST_DFU)) {
            hasRequestDfu = true;
            BleManager bleManager = this.mBleManager;
            if (bleManager != null) {
                bleManager.setRequestDfuTag();
            }
        }
        BleManager bleManager2 = this.mBleManager;
        if (bleManager2 != null) {
            bleManager2.write(bArr, longUuidByShortUuid, longUuidByShortUuid$default, new BleInteractor$write$1(this, bArr));
        }
    }

    public void executeDfu(Context context, String str, DfuProgressListener dfuProgressListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aDeviceName");
        Intrinsics.checkNotNullParameter(dfuProgressListener, "aDfuProgressListener");
        CharSequence charSequence = mMacAddress;
        if (charSequence != null && charSequence.length() != 0) {
            DfuManager dfuManager = DfuManager.INSTANCE;
            String str2 = mMacAddress;
            Intrinsics.checkNotNull(str2);
            DfuManager.executeDfu$default(dfuManager, context, str2, str, (Integer) null, (String) null, (Uri) null, dfuProgressListener, 56, (Object) null);
        }
    }

    public void executeTagDfu(Context context, String str, DfuProgressListener dfuProgressListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aDeviceName");
        Intrinsics.checkNotNullParameter(dfuProgressListener, "aDfuProgressListener");
        CharSequence charSequence = mTagMacAddress;
        if (charSequence != null && charSequence.length() != 0) {
            DfuManager dfuManager = DfuManager.INSTANCE;
            String str2 = mTagMacAddress;
            Intrinsics.checkNotNull(str2);
            DfuManager.executeTagDfu$default(dfuManager, context, str2, str, (Integer) null, (String) null, (Uri) null, dfuProgressListener, 56, (Object) null);
        }
    }

    public void tagDFUProcessAbort() {
        DfuManager.INSTANCE.processAbort();
    }

    /* access modifiers changed from: private */
    public final void checkDfuMode(ArrayList<String> arrayList) {
        isDFUMode = false;
        if (arrayList != null) {
            for (String shortUuidByLongUuid : arrayList) {
                if (Intrinsics.areEqual((Object) UuidHelperUtil.DfuService.INSTANCE.getShortUuidByLongUuid(shortUuidByLongUuid), (Object) GattProfileConstant.SERVICE_DEVICE_DFU)) {
                    isDFUMode = true;
                }
            }
        }
    }

    static /* synthetic */ String getLongUuidByShortUuid$default(BleInteractor bleInteractor, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return bleInteractor.getLongUuidByShortUuid(str, str2);
    }

    private final String getLongUuidByShortUuid(String str, String str2) {
        String longUuidByShortUuid;
        String longUuidByShortUuid2;
        String longUuidByShortUuid3;
        String longUuidByShortUuid4;
        switch (str.hashCode()) {
            case 1512229:
                if (str.equals(GattProfileConstant.SERVICE_DEVICE_CONTROL)) {
                    if (str2 == null || (longUuidByShortUuid = UuidHelperUtil.DeviceControlService.INSTANCE.getLongUuidByShortUuid(str2)) == null) {
                        return UuidHelperUtil.DeviceControlService.INSTANCE.getLongUuidByShortUuid(str);
                    }
                    return longUuidByShortUuid;
                }
                break;
            case 1515111:
                if (str.equals(GattProfileConstant.SERVICE_GENERIC_ACCESS)) {
                    if (str2 == null || (longUuidByShortUuid2 = UuidHelperUtil.GenericAccessService.INSTANCE.getLongUuidByShortUuid(str2)) == null) {
                        return UuidHelperUtil.GenericAccessService.INSTANCE.getLongUuidByShortUuid(str);
                    }
                    return longUuidByShortUuid2;
                }
                break;
            case 1515160:
                if (str.equals(GattProfileConstant.SERVICE_DEVICE_INFORMATION)) {
                    if (str2 == null || (longUuidByShortUuid3 = UuidHelperUtil.DeviceInformationService.INSTANCE.getLongUuidByShortUuid(str2)) == null) {
                        return UuidHelperUtil.DeviceInformationService.INSTANCE.getLongUuidByShortUuid(str);
                    }
                    return longUuidByShortUuid3;
                }
                break;
            case 3137443:
                if (str.equals(GattProfileConstant.SERVICE_DEVICE_DFU)) {
                    if (str2 == null || (longUuidByShortUuid4 = UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(str2)) == null) {
                        return UuidHelperUtil.DfuService.INSTANCE.getLongUuidByShortUuid(str);
                    }
                    return longUuidByShortUuid4;
                }
                break;
        }
        return "";
    }

    static /* synthetic */ String getShortUuidByLongUuid$default(BleInteractor bleInteractor, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return bleInteractor.getShortUuidByLongUuid(str, str2);
    }

    /* access modifiers changed from: private */
    public final String getShortUuidByLongUuid(String str, String str2) {
        String shortUuidByLongUuid;
        String shortUuidByLongUuid2;
        String shortUuidByLongUuid3;
        String shortUuidByLongUuid4;
        switch (str.hashCode()) {
            case -1650751732:
                if (str.equals(GattProfileConstant.LONG_SERVICE_DEVICE_CONTROL)) {
                    if (str2 == null || (shortUuidByLongUuid = UuidHelperUtil.DeviceControlService.INSTANCE.getShortUuidByLongUuid(str2)) == null) {
                        return UuidHelperUtil.DeviceControlService.INSTANCE.getShortUuidByLongUuid(str);
                    }
                    return shortUuidByLongUuid;
                }
                break;
            case -495980365:
                if (str.equals(GattProfileConstant.LONG_SERVICE_DEVICE_DFU)) {
                    if (str2 == null || (shortUuidByLongUuid2 = UuidHelperUtil.DfuService.INSTANCE.getShortUuidByLongUuid(str2)) == null) {
                        return UuidHelperUtil.DfuService.INSTANCE.getShortUuidByLongUuid(str);
                    }
                    return shortUuidByLongUuid2;
                }
                break;
            case 1562495534:
                if (str.equals(GattProfileConstant.LONG_SERVICE_DEVICE_INFORMATION)) {
                    if (str2 == null || (shortUuidByLongUuid3 = UuidHelperUtil.DeviceInformationService.INSTANCE.getShortUuidByLongUuid(str2)) == null) {
                        return UuidHelperUtil.DeviceInformationService.INSTANCE.getShortUuidByLongUuid(str);
                    }
                    return shortUuidByLongUuid3;
                }
                break;
            case 1960250749:
                if (str.equals(GattProfileConstant.LONG_SERVICE_GENERIC_ACCESS)) {
                    if (str2 == null || (shortUuidByLongUuid4 = UuidHelperUtil.GenericAccessService.INSTANCE.getShortUuidByLongUuid(str2)) == null) {
                        return UuidHelperUtil.GenericAccessService.INSTANCE.getShortUuidByLongUuid(str);
                    }
                    return shortUuidByLongUuid4;
                }
                break;
        }
        return "";
    }

    static /* synthetic */ String getTagShortUuidByLongUuid$default(BleInteractor bleInteractor, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return bleInteractor.getTagShortUuidByLongUuid(str, str2);
    }

    /* access modifiers changed from: private */
    public final String getTagShortUuidByLongUuid(String str, String str2) {
        String shortUuidByLongUuid;
        String shortUuidByLongUuid2;
        if (Intrinsics.areEqual((Object) str, (Object) GattProfileConstant.LONG_SERVICE_DEVICE_INFORMATION)) {
            if (str2 == null || (shortUuidByLongUuid2 = UuidHelperUtil.DeviceInformationService.INSTANCE.getShortUuidByLongUuid(str2)) == null) {
                return UuidHelperUtil.DeviceInformationService.INSTANCE.getShortUuidByLongUuid(str);
            }
            return shortUuidByLongUuid2;
        } else if (!Intrinsics.areEqual((Object) str, (Object) TagGattProfileConstant.TAG_LONG_SERVICE_DEVICE_CONTROL)) {
            return "";
        } else {
            if (str2 == null || (shortUuidByLongUuid = UuidHelperUtil.TagService.INSTANCE.getShortUuidByLongUuid(str2)) == null) {
                return UuidHelperUtil.TagService.INSTANCE.getShortUuidByLongUuid(str);
            }
            return shortUuidByLongUuid;
        }
    }

    public void setDataReceivedCallbackListener(Function1<? super BleDataEntity, Unit> function1) {
        setMDataReceivedCallbackListener(function1);
    }

    public void setTagDataReceivedCallbackListener(Function1<? super BleDataEntity, Unit> function1) {
        setMTagDataReceivedCallbackListener(function1);
    }

    public void setConnectCallbackListener(Function2<? super BleConnStatusCode, ? super ArrayList<String>, Unit> function2) {
        mConnectCallbackListener = function2;
    }

    public void tagScan(Context context, TagScanRegisterCallback tagScanRegisterCallback) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(tagScanRegisterCallback, "callback");
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.scanTag(context, new BleInteractor$tagScan$1(tagScanRegisterCallback));
        }
    }

    public void tagScanNoReceiving(Context context, String str, TagScanNoReceivingCallback tagScanNoReceivingCallback) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aAddress");
        Intrinsics.checkNotNullParameter(tagScanNoReceivingCallback, "callback");
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.scanTagNoReceiving(context, str, new BleInteractor$tagScanNoReceiving$1(tagScanNoReceivingCallback));
        }
    }

    public void tagWrite(String str, String str2, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        Intrinsics.checkNotNullParameter(bArr, "aData");
        String serviceUuid = UuidHelperUtil.TagService.INSTANCE.getServiceUuid(str);
        String serviceUuid2 = UuidHelperUtil.TagService.INSTANCE.getServiceUuid(str2);
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.writeTag(bArr, serviceUuid, serviceUuid2, new BleInteractor$tagWrite$1(this, bArr));
        }
    }

    public void tagScanConnect(Context context, String[] strArr) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        BleManager bleManager = this.mBleManager;
        if (bleManager != null) {
            bleManager.scanConnectTag(context, strArr, new BleInteractor$tagScanConnect$1(this));
        }
    }
}
