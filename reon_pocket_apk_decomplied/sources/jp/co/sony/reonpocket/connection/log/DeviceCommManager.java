package jp.co.sony.reonpocket.connection.log;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.ConnectCallbackListener;
import jp.co.sony.reon.android.ble.util.BluetoothUtil;
import jp.co.sony.reonpocket.ReonPocketApplication;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.constant.ModelConstant;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.PermissionUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0002\u001e'\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020\u0015H\u0002J\u0016\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u000fJ\u0010\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u000200H\u0002J\u0006\u00103\u001a\u00020#J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0011H\u0002J\u0012\u00106\u001a\u00020#2\b\b\u0002\u00107\u001a\u00020#H\u0002J\u001c\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010;\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00072\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010<\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u001bH\u0002J2\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002002\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0014\u0010D\u001a\u00020\u00152\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0002J \u0010G\u001a\u00020\u00152\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u0010\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020CH\u0002J\u0012\u0010J\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010CH\u0002J\u0016\u0010K\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007J\u001e\u0010L\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010M\u001a\u00020#J\u0018\u0010N\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u00112\u0006\u0010O\u001a\u00020FH\u0002J\u001e\u0010P\u001a\u00020\u00152\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010B\u001a\u00020CR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/DeviceCommManager;", "", "()V", "HEX_ARRAY", "", "aServiceUuidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mAddress", "mBleGatt", "Landroid/bluetooth/BluetoothGatt;", "mBleScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mConnectCallbackListener", "Ljp/co/sony/reon/android/ble/listener/ConnectCallbackListener;", "mContext", "Landroid/content/Context;", "mDataReceivedCallbackListener", "Lkotlin/Function1;", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "", "getMDataReceivedCallbackListener", "()Lkotlin/jvm/functions/Function1;", "setMDataReceivedCallbackListener", "(Lkotlin/jvm/functions/Function1;)V", "mDevice", "Landroid/bluetooth/BluetoothDevice;", "mDeviceName", "mGattCallback", "jp/co/sony/reonpocket/connection/log/DeviceCommManager$mGattCallback$1", "Ljp/co/sony/reonpocket/connection/log/DeviceCommManager$mGattCallback$1;", "mHandler", "Landroid/os/Handler;", "mIsConnected", "", "mLock", "mManualDisconnect", "mScanCallback", "jp/co/sony/reonpocket/connection/log/DeviceCommManager$mScanCallback$1", "Ljp/co/sony/reonpocket/connection/log/DeviceCommManager$mScanCallback$1;", "mScanning", "close", "connect", "aContext", "aCallbackListener", "convertConnectStateToString", "aConnectState", "", "convertResultStateToString", "aResultState", "disconnect", "doConnect", "appContext", "doDisconnect", "aManualDisconnect", "getLongUuidByShortUuid", "aServiceUuid", "aCharacteristicUuid", "getShortUuidByLongUuid", "handleActionScanConnect", "aDevice", "handleCommandResult", "aAction", "Ljp/co/sony/reonpocket/constant/BleActionCode;", "aResultCode", "aData", "", "handleConnectError", "aErrorReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "handleConnectSuccess", "isBeaconDevice", "aScanRecord", "parseData", "read", "setNotification", "aEnabled", "stopScan", "aReason", "write", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceCommManager.kt */
public final class DeviceCommManager {
    public static final int $stable = 8;
    private static final UUID CHARACTERISTIC_CONFIG_DESCRIPTOR;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int GATT_CONN_TIMEOUT = 8;
    private static final int GATT_ERROR = 133;
    private static final int LONG_DISCOVER_SERVICE_DELAY = 1500;
    private static final int SCAN_NO_TIME_OUT_LIMIT = -1;
    private static final int SCAN_TIME_OUT = 30000;
    private static final String TAG = "AwsLog_DeviceCommManager";
    private final char[] HEX_ARRAY;
    /* access modifiers changed from: private */
    public ArrayList<String> aServiceUuidList;
    /* access modifiers changed from: private */
    public String mAddress;
    private BluetoothGatt mBleGatt;
    private BluetoothLeScanner mBleScanner;
    private ConnectCallbackListener mConnectCallbackListener;
    private Context mContext;
    private Function1<? super BleDataEntity, Unit> mDataReceivedCallbackListener;
    /* access modifiers changed from: private */
    public BluetoothDevice mDevice;
    /* access modifiers changed from: private */
    public String mDeviceName;
    private DeviceCommManager$mGattCallback$1 mGattCallback;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean mIsConnected;
    private final Object mLock;
    /* access modifiers changed from: private */
    public boolean mManualDisconnect;
    private final DeviceCommManager$mScanCallback$1 mScanCallback;
    /* access modifiers changed from: private */
    public boolean mScanning;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceCommManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant[] r0 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.DEVICE_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.DFU_MODE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.SCAN_TIME_OUT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.MANUAL_SCAN_STOP     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.DeviceCommManager.WhenMappings.<clinit>():void");
        }
    }

    public DeviceCommManager() {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        this.HEX_ARRAY = charArray;
        this.mLock = new Object();
        this.aServiceUuidList = new ArrayList<>();
        this.mScanCallback = new DeviceCommManager$mScanCallback$1(this);
        this.mGattCallback = new DeviceCommManager$mGattCallback$1(this);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/DeviceCommManager$Companion;", "", "()V", "CHARACTERISTIC_CONFIG_DESCRIPTOR", "Ljava/util/UUID;", "GATT_CONN_TIMEOUT", "", "GATT_ERROR", "LONG_DISCOVER_SERVICE_DELAY", "SCAN_NO_TIME_OUT_LIMIT", "SCAN_TIME_OUT", "TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceCommManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        UUID fromString = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        CHARACTERISTIC_CONFIG_DESCRIPTOR = fromString;
    }

    public final Function1<BleDataEntity, Unit> getMDataReceivedCallbackListener() {
        return this.mDataReceivedCallbackListener;
    }

    public final void setMDataReceivedCallbackListener(Function1<? super BleDataEntity, Unit> function1) {
        this.mDataReceivedCallbackListener = function1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: android.bluetooth.BluetoothManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect(android.content.Context r5, jp.co.sony.reon.android.ble.listener.ConnectCallbackListener r6) {
        /*
            r4 = this;
            java.lang.String r0 = "aContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "aCallbackListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            jp.co.sony.reonpocket.util.DebugLogUtil r0 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r1 = "Start connect"
            java.lang.String r2 = "AwsLog_DeviceCommManager"
            r0.d((java.lang.String) r2, (java.lang.String) r1)
            jp.co.sony.reonpocket.util.SimpleStorageUtil r0 = jp.co.sony.reonpocket.util.SimpleStorageUtil.INSTANCE
            java.lang.String r1 = "reon_mac_address"
            java.lang.String r0 = r0.getStringValue(r5, r1)
            r4.mAddress = r0
            if (r0 != 0) goto L_0x0025
            jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r5 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.DEVICE_NOT_FOUND
            r6.onConnectFailed(r5)
            return
        L_0x0025:
            jp.co.sony.reonpocket.util.PermissionUtil r0 = jp.co.sony.reonpocket.util.PermissionUtil.INSTANCE
            android.content.Context r1 = r5.getApplicationContext()
            java.lang.String r3 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            boolean r0 = r0.isBleEnabled(r1)
            r1 = 0
            if (r0 != 0) goto L_0x004a
            jp.co.sony.reon.android.ble.listener.ConnectCallbackListener r5 = r4.mConnectCallbackListener
            if (r5 == 0) goto L_0x0040
            jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r6 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.BLUETOOTH_OFF
            r5.onConnectFailed(r6)
        L_0x0040:
            jp.co.sony.reonpocket.util.DebugLogUtil r5 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r6 = "bluetooth off"
            r5.d((java.lang.String) r2, (java.lang.String) r6)
            r4.mConnectCallbackListener = r1
            return
        L_0x004a:
            r4.mContext = r5
            r4.mConnectCallbackListener = r6
            android.bluetooth.le.BluetoothLeScanner r6 = r4.mBleScanner
            if (r6 != 0) goto L_0x008a
            r6 = r4
            jp.co.sony.reonpocket.connection.log.DeviceCommManager r6 = (jp.co.sony.reonpocket.connection.log.DeviceCommManager) r6
            android.content.Context r6 = r5.getApplicationContext()
            java.lang.String r0 = "bluetooth"
            java.lang.Object r6 = r6.getSystemService(r0)
            boolean r0 = r6 instanceof android.bluetooth.BluetoothManager
            if (r0 == 0) goto L_0x0066
            r1 = r6
            android.bluetooth.BluetoothManager r1 = (android.bluetooth.BluetoothManager) r1
        L_0x0066:
            if (r1 == 0) goto L_0x0082
            android.bluetooth.BluetoothAdapter r6 = r1.getAdapter()
            if (r6 == 0) goto L_0x007a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            android.bluetooth.le.BluetoothLeScanner r6 = r6.getBluetoothLeScanner()
            r4.mBleScanner = r6
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L_0x008a
        L_0x007a:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "BluetoothAdapter is null!"
            r5.<init>(r6)
            throw r5
        L_0x0082:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "BluetoothManager is null!"
            r5.<init>(r6)
            throw r5
        L_0x008a:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            android.bluetooth.le.ScanFilter$Builder r0 = new android.bluetooth.le.ScanFilter$Builder
            r0.<init>()
            java.lang.String r1 = "04ca1501-fd57-404e-8459-c5ef8d765c8d"
            android.os.ParcelUuid r1 = android.os.ParcelUuid.fromString(r1)
            android.bluetooth.le.ScanFilter$Builder r0 = r0.setServiceUuid(r1)
            android.bluetooth.le.ScanFilter r0 = r0.build()
            java.lang.String r1 = "build(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6.add(r0)
            android.bluetooth.le.ScanSettings$Builder r0 = new android.bluetooth.le.ScanSettings$Builder
            r0.<init>()
            r1 = 2
            android.bluetooth.le.ScanSettings$Builder r0 = r0.setScanMode(r1)
            android.bluetooth.le.ScanSettings r0 = r0.build()
            jp.co.sony.reonpocket.util.DebugLogUtil r1 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            java.lang.String r3 = "Start scan device"
            r1.d((java.lang.String) r2, (java.lang.String) r3)
            r1 = 1
            r4.mScanning = r1
            android.bluetooth.le.BluetoothLeScanner r1 = r4.mBleScanner
            if (r1 == 0) goto L_0x00cf
            jp.co.sony.reonpocket.connection.log.DeviceCommManager$mScanCallback$1 r2 = r4.mScanCallback
            android.bluetooth.le.ScanCallback r2 = (android.bluetooth.le.ScanCallback) r2
            r1.startScan(r6, r0, r2)
        L_0x00cf:
            android.os.Handler r6 = r4.mHandler
            jp.co.sony.reonpocket.connection.log.DeviceCommManager$$ExternalSyntheticLambda0 r0 = new jp.co.sony.reonpocket.connection.log.DeviceCommManager$$ExternalSyntheticLambda0
            r0.<init>(r4, r5)
            r1 = 30000(0x7530, double:1.4822E-319)
            r6.postDelayed(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.DeviceCommManager.connect(android.content.Context, jp.co.sony.reon.android.ble.listener.ConnectCallbackListener):void");
    }

    /* access modifiers changed from: private */
    public static final void connect$lambda$2(DeviceCommManager deviceCommManager, Context context) {
        Intrinsics.checkNotNullParameter(deviceCommManager, "this$0");
        Intrinsics.checkNotNullParameter(context, "$aContext");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        deviceCommManager.stopScan(applicationContext, ReasonCodeConstant.SCAN_TIME_OUT);
    }

    public final boolean disconnect() {
        if (this.mScanning) {
            stopScan(ReonPocketApplication.Companion.getApplicationContext(), ReasonCodeConstant.MANUAL_SCAN_STOP);
            return true;
        }
        DebugLogUtil.INSTANCE.d(TAG, "Start disconnect");
        return doDisconnect(true);
    }

    public final void setNotification(String str, String str2, boolean z) {
        BluetoothGatt bluetoothGatt;
        Intrinsics.checkNotNullParameter(str, "aServiceUuid");
        Intrinsics.checkNotNullParameter(str2, "aCharacteristicUuid");
        DebugLogUtil.INSTANCE.d(TAG, "Start set notify(" + str2 + ") to enabled(" + z + ")");
        String longUuidByShortUuid = getLongUuidByShortUuid(str, str2);
        Unit unit = null;
        String longUuidByShortUuid$default = getLongUuidByShortUuid$default(this, str, (String) null, 2, (Object) null);
        DeviceCommManager deviceCommManager = this;
        boolean z2 = true;
        if (!this.mIsConnected || (bluetoothGatt = this.mBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device not connect of GATT is NULL");
        } else {
            Intrinsics.checkNotNull(bluetoothGatt);
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(longUuidByShortUuid$default));
            if (service == null) {
                DebugLogUtil.INSTANCE.e(TAG, "Service not available: " + str);
            } else {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(longUuidByShortUuid));
                if (characteristic == null) {
                    DebugLogUtil.INSTANCE.e(TAG, "Characteristic not available:" + str2);
                } else {
                    BluetoothGatt bluetoothGatt2 = this.mBleGatt;
                    boolean z3 = false;
                    if (bluetoothGatt2 != null) {
                        if (bluetoothGatt2.setCharacteristicNotification(characteristic, z)) {
                            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CHARACTERISTIC_CONFIG_DESCRIPTOR);
                            if (z) {
                                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            } else {
                                descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                            }
                            if (!bluetoothGatt2.writeDescriptor(descriptor)) {
                                DebugLogUtil.INSTANCE.e(TAG, "Notification(" + characteristic.getUuid() + ") enabled(" + z + ") writeDescriptor failed");
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            DebugLogUtil.INSTANCE.e(TAG, "Notification(" + characteristic.getUuid() + ") enabled(" + z + ") setCharacteristicNotification failed");
                        }
                        z3 = true;
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        DebugLogUtil.INSTANCE.e(TAG, "Notification(" + characteristic.getUuid() + ") enabled(" + z + ") is failed, gatt is null");
                    } else {
                        z2 = z3;
                    }
                }
            }
        }
        if (z2) {
            handleCommandResult(BleActionCode.NOTIFY, ResponseCode.CUSTOM_RESPONSE_BEFORE_ERROR.getCode(), longUuidByShortUuid$default, longUuidByShortUuid, (byte[]) null);
        }
    }

    public final void read(String str, String str2) {
        BluetoothGatt bluetoothGatt;
        Intrinsics.checkNotNullParameter(str, "aServiceUuid");
        Intrinsics.checkNotNullParameter(str2, "aCharacteristicUuid");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d(TAG, "Start to read:" + str2);
        String longUuidByShortUuid = getLongUuidByShortUuid(str, str2);
        Unit unit = null;
        String longUuidByShortUuid$default = getLongUuidByShortUuid$default(this, str, (String) null, 2, (Object) null);
        DeviceCommManager deviceCommManager = this;
        boolean z = true;
        if (!this.mIsConnected || (bluetoothGatt = this.mBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device is not connected, or GATT is null");
        } else {
            Intrinsics.checkNotNull(bluetoothGatt);
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(longUuidByShortUuid$default));
            if (service == null) {
                DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                debugLogUtil2.e(TAG, "Service not available:" + str);
            } else {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(longUuidByShortUuid));
                if (characteristic == null) {
                    DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
                    debugLogUtil3.e(TAG, "Characteristic not available:" + str2);
                } else {
                    BluetoothGatt bluetoothGatt2 = this.mBleGatt;
                    boolean z2 = false;
                    if (bluetoothGatt2 != null) {
                        if (!bluetoothGatt2.readCharacteristic(characteristic)) {
                            DebugLogUtil debugLogUtil4 = DebugLogUtil.INSTANCE;
                            UUID uuid = characteristic.getUuid();
                            debugLogUtil4.e(TAG, "Read(" + uuid + ") is failed");
                            z2 = true;
                        }
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        DebugLogUtil debugLogUtil5 = DebugLogUtil.INSTANCE;
                        UUID uuid2 = characteristic.getUuid();
                        debugLogUtil5.e(TAG, "Read(" + uuid2 + ") is failed, gatt is null");
                    } else {
                        z = z2;
                    }
                }
            }
        }
        if (z) {
            handleCommandResult(BleActionCode.READ, ResponseCode.CUSTOM_RESPONSE_BEFORE_ERROR.getCode(), longUuidByShortUuid$default, longUuidByShortUuid, (byte[]) null);
        }
    }

    public final void write(String str, String str2, byte[] bArr) {
        BluetoothGatt bluetoothGatt;
        Intrinsics.checkNotNullParameter(str, "aServiceUuid");
        Intrinsics.checkNotNullParameter(str2, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(bArr, "aData");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String arrays = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        debugLogUtil.d(TAG, "Start to write " + arrays + " to " + str2);
        String longUuidByShortUuid = getLongUuidByShortUuid(str, str2);
        Unit unit = null;
        String longUuidByShortUuid$default = getLongUuidByShortUuid$default(this, str, (String) null, 2, (Object) null);
        DeviceCommManager deviceCommManager = this;
        boolean z = true;
        if (!this.mIsConnected || (bluetoothGatt = this.mBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device is not connected, or GATT is null");
        } else {
            Intrinsics.checkNotNull(bluetoothGatt);
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(longUuidByShortUuid$default));
            if (service == null) {
                DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                debugLogUtil2.e(TAG, "Service not available " + str);
            } else {
                BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(longUuidByShortUuid));
                if (characteristic == null) {
                    DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
                    debugLogUtil3.e(TAG, "Characteristic not available " + str2);
                } else if (characteristic.setValue(bArr)) {
                    if ((characteristic.getProperties() & 4) != 0) {
                        characteristic.setWriteType(1);
                    } else if ((characteristic.getProperties() & 8) != 0) {
                        characteristic.setWriteType(2);
                    }
                    BluetoothGatt bluetoothGatt2 = this.mBleGatt;
                    boolean z2 = false;
                    if (bluetoothGatt2 != null) {
                        if (!bluetoothGatt2.writeCharacteristic(characteristic)) {
                            DebugLogUtil debugLogUtil4 = DebugLogUtil.INSTANCE;
                            UUID uuid = characteristic.getUuid();
                            debugLogUtil4.e(TAG, "Write(" + uuid + ") is failed");
                            z2 = true;
                        }
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        DebugLogUtil debugLogUtil5 = DebugLogUtil.INSTANCE;
                        UUID uuid2 = characteristic.getUuid();
                        debugLogUtil5.e(TAG, "Write(" + uuid2 + ") is failed, gatt is null");
                    } else {
                        z = z2;
                    }
                }
            }
        }
        if (z) {
            handleCommandResult(BleActionCode.WRITE, ResponseCode.CUSTOM_RESPONSE_BEFORE_ERROR.getCode(), longUuidByShortUuid$default, longUuidByShortUuid, (byte[]) null);
        }
    }

    /* access modifiers changed from: private */
    public final void stopScan(Context context, ReasonCodeConstant reasonCodeConstant) {
        if (this.mScanning) {
            DebugLogUtil.INSTANCE.d(TAG, "Stop scan device");
            this.mScanning = false;
            this.mHandler.removeCallbacksAndMessages((Object) null);
            if (!PermissionUtil.INSTANCE.isBleEnabled(context)) {
                DebugLogUtil.INSTANCE.d(TAG, "bluetooth off");
                ConnectCallbackListener connectCallbackListener = this.mConnectCallbackListener;
                if (connectCallbackListener != null) {
                    connectCallbackListener.onConnectFailed(ReasonCodeConstant.BLUETOOTH_OFF);
                }
                this.mConnectCallbackListener = null;
                return;
            }
            BluetoothLeScanner bluetoothLeScanner = this.mBleScanner;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.mScanCallback);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[reasonCodeConstant.ordinal()];
            if (i == 1) {
                DebugLogUtil.INSTANCE.d(TAG, "scan success");
            } else if (i == 2) {
                DebugLogUtil.INSTANCE.e(TAG, "scan failed！！！");
            } else if (i == 3) {
                DebugLogUtil.INSTANCE.e(TAG, "device is dfu mode！！！");
            } else if (i == 4) {
                DebugLogUtil.INSTANCE.e(TAG, "scan timeout！！！");
            } else if (i != 5) {
                DebugLogUtil.INSTANCE.e(TAG, "other error");
            } else {
                DebugLogUtil.INSTANCE.e(TAG, "manual scan stop");
            }
            if (reasonCodeConstant != ReasonCodeConstant.NONE) {
                ConnectCallbackListener connectCallbackListener2 = this.mConnectCallbackListener;
                if (connectCallbackListener2 != null) {
                    connectCallbackListener2.onConnectFailed(reasonCodeConstant);
                }
                this.mConnectCallbackListener = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean isBeaconDevice(byte[] bArr) {
        for (int i = 2; i <= 5; i++) {
            if ((bArr[i + 2] & 255) == 2 && (bArr[i + 3] & 255) == 21) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void handleActionScanConnect(Context context, BluetoothDevice bluetoothDevice) {
        String name = bluetoothDevice.getName();
        String address = bluetoothDevice.getAddress();
        if (Intrinsics.areEqual((Object) this.mAddress, (Object) address)) {
            DebugLogUtil.INSTANCE.d(TAG, "find want connect device's name:" + name + " address:" + address);
            String[] dfuModelNames = ModelConstant.INSTANCE.getDfuModelNames();
            CharSequence charSequence = name;
            if (charSequence != null && charSequence.length() != 0) {
                DeviceCommManager deviceCommManager = this;
                for (String str : dfuModelNames) {
                    Intrinsics.checkNotNull(name);
                    if (new Regex(str).matches(charSequence)) {
                        DebugLogUtil.INSTANCE.e(TAG, "device is dfu mode");
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        stopScan(applicationContext, ReasonCodeConstant.DFU_MODE);
                        return;
                    }
                }
                DebugLogUtil.INSTANCE.d(TAG, "device isn't dfu mode");
                String[] modelNames = ModelConstant.INSTANCE.getModelNames();
                if (charSequence != null && charSequence.length() != 0) {
                    for (String str2 : modelNames) {
                        Intrinsics.checkNotNull(name);
                        if (new Regex(str2).matches(charSequence)) {
                            Context applicationContext2 = context.getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                            stopScan(applicationContext2, ReasonCodeConstant.NONE);
                            doConnect(context);
                            return;
                        }
                    }
                    DebugLogUtil.INSTANCE.e(TAG, "device's name is error");
                    Context applicationContext3 = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                    stopScan(applicationContext3, ReasonCodeConstant.DEVICE_NAME_ERROR);
                }
            }
        }
    }

    private final void doConnect(Context context) {
        BluetoothUtil bluetoothUtil = BluetoothUtil.INSTANCE;
        String str = this.mAddress;
        if (str != null) {
            BluetoothDevice remoteDevice = bluetoothUtil.getRemoteDevice(context, str);
            if (remoteDevice == null) {
                DebugLogUtil.INSTANCE.e(TAG, "Device not found, unable to connect");
                return;
            }
            this.mDevice = remoteDevice;
            DebugLogUtil.INSTANCE.d(TAG, "Trying to create a new connection");
            this.mIsConnected = false;
            this.mManualDisconnect = false;
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            this.mBleGatt = remoteDevice.connectGatt(context2, false, this.mGattCallback, 2);
        }
    }

    static /* synthetic */ boolean doDisconnect$default(DeviceCommManager deviceCommManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return deviceCommManager.doDisconnect(z);
    }

    private final boolean doDisconnect(boolean z) {
        if (this.mIsConnected) {
            this.mManualDisconnect = z;
            BluetoothGatt bluetoothGatt = this.mBleGatt;
            if (bluetoothGatt != null) {
                DebugLogUtil.INSTANCE.d(TAG, "Execute disconnect");
                bluetoothGatt.disconnect();
                return true;
            }
            DebugLogUtil.INSTANCE.w(TAG, "Device not connect of GATT is NULL");
            return false;
        }
        DebugLogUtil.INSTANCE.w(TAG, "No connected device");
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|(1:9)|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            android.bluetooth.BluetoothGatt r1 = r5.mBleGatt     // Catch:{ all -> 0x0023 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            jp.co.sony.reonpocket.util.DebugLogUtil r1 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x0023 }
            java.lang.String r3 = "AwsLog_DeviceCommManager"
            java.lang.String r4 = "gatt.close()"
            r1.d((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0023 }
            android.bluetooth.BluetoothGatt r1 = r5.mBleGatt     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0018
            r1.close()     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r5.mBleGatt = r2     // Catch:{ all -> 0x0023 }
        L_0x001a:
            r1 = 0
            r5.mIsConnected = r1     // Catch:{ all -> 0x0023 }
            r5.mDevice = r2     // Catch:{ all -> 0x0023 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.DeviceCommManager.close():void");
    }

    static /* synthetic */ String getLongUuidByShortUuid$default(DeviceCommManager deviceCommManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return deviceCommManager.getLongUuidByShortUuid(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceControlService.INSTANCE.getLongUuidByShortUuid(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getLongUuidByShortUuid(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 1512229(0x171325, float:2.119084E-39)
            if (r0 == r1) goto L_0x0047
            r1 = 1515160(0x171e98, float:2.123191E-39)
            if (r0 == r1) goto L_0x002e
            r1 = 3137443(0x2fdfa3, float:4.396494E-39)
            if (r0 == r1) goto L_0x0014
            goto L_0x004f
        L_0x0014:
            java.lang.String r0 = "fe59"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x001d
            goto L_0x004f
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            jp.co.sony.reonpocket.util.UuidHelperUtil$DfuService r0 = jp.co.sony.reonpocket.util.UuidHelperUtil.DfuService.INSTANCE
            java.lang.String r4 = r0.getLongUuidByShortUuid(r4)
            if (r4 != 0) goto L_0x0062
        L_0x0027:
            jp.co.sony.reonpocket.util.UuidHelperUtil$DfuService r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DfuService.INSTANCE
            java.lang.String r4 = r4.getLongUuidByShortUuid(r3)
            goto L_0x0062
        L_0x002e:
            java.lang.String r0 = "180a"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x0040
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceInformationService r0 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceInformationService.INSTANCE
            java.lang.String r4 = r0.getLongUuidByShortUuid(r4)
            if (r4 != 0) goto L_0x0062
        L_0x0040:
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceInformationService r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceInformationService.INSTANCE
            java.lang.String r4 = r4.getLongUuidByShortUuid(r3)
            goto L_0x0062
        L_0x0047:
            java.lang.String r0 = "1501"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0052
        L_0x004f:
            java.lang.String r4 = ""
            goto L_0x0062
        L_0x0052:
            if (r4 == 0) goto L_0x005c
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceControlService r0 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceControlService.INSTANCE
            java.lang.String r4 = r0.getLongUuidByShortUuid(r4)
            if (r4 != 0) goto L_0x0062
        L_0x005c:
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceControlService r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceControlService.INSTANCE
            java.lang.String r4 = r4.getLongUuidByShortUuid(r3)
        L_0x0062:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.DeviceCommManager.getLongUuidByShortUuid(java.lang.String, java.lang.String):java.lang.String");
    }

    static /* synthetic */ String getShortUuidByLongUuid$default(DeviceCommManager deviceCommManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return deviceCommManager.getShortUuidByLongUuid(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceControlService.INSTANCE.getShortUuidByLongUuid(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getShortUuidByLongUuid(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = -1650751732(0xffffffff9d9b870c, float:-4.1167794E-21)
            if (r0 == r1) goto L_0x0047
            r1 = -495980365(0xffffffffe26ff0b3, float:-1.106529E21)
            if (r0 == r1) goto L_0x002d
            r1 = 1562495534(0x5d21ca2e, float:7.2863632E17)
            if (r0 == r1) goto L_0x0014
            goto L_0x004f
        L_0x0014:
            java.lang.String r0 = "0000180a-0000-1000-8000-00805f9b34fb"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x0026
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceInformationService r0 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceInformationService.INSTANCE
            java.lang.String r4 = r0.getShortUuidByLongUuid(r4)
            if (r4 != 0) goto L_0x0062
        L_0x0026:
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceInformationService r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceInformationService.INSTANCE
            java.lang.String r4 = r4.getShortUuidByLongUuid(r3)
            goto L_0x0062
        L_0x002d:
            java.lang.String r0 = "f355fe59-dfbd-70a3-9b45-4f26abe71cf1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0036
            goto L_0x004f
        L_0x0036:
            if (r4 == 0) goto L_0x0040
            jp.co.sony.reonpocket.util.UuidHelperUtil$DfuService r0 = jp.co.sony.reonpocket.util.UuidHelperUtil.DfuService.INSTANCE
            java.lang.String r4 = r0.getShortUuidByLongUuid(r4)
            if (r4 != 0) goto L_0x0062
        L_0x0040:
            jp.co.sony.reonpocket.util.UuidHelperUtil$DfuService r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DfuService.INSTANCE
            java.lang.String r4 = r4.getShortUuidByLongUuid(r3)
            goto L_0x0062
        L_0x0047:
            java.lang.String r0 = "04ca1501-fd57-404e-8459-c5ef8d765c8d"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0052
        L_0x004f:
            java.lang.String r4 = ""
            goto L_0x0062
        L_0x0052:
            if (r4 == 0) goto L_0x005c
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceControlService r0 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceControlService.INSTANCE
            java.lang.String r4 = r0.getShortUuidByLongUuid(r4)
            if (r4 != 0) goto L_0x0062
        L_0x005c:
            jp.co.sony.reonpocket.util.UuidHelperUtil$DeviceControlService r4 = jp.co.sony.reonpocket.util.UuidHelperUtil.DeviceControlService.INSTANCE
            java.lang.String r4 = r4.getShortUuidByLongUuid(r3)
        L_0x0062:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.DeviceCommManager.getShortUuidByLongUuid(java.lang.String, java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final String convertResultStateToString(int i) {
        if (i == 0) {
            return FirebaseAnalytics.Param.SUCCESS;
        }
        if (i != 257) {
            return String.valueOf(i);
        }
        return "failure";
    }

    /* access modifiers changed from: private */
    public final String convertConnectStateToString(int i) {
        if (i == 1) {
            return "connecting";
        }
        if (i == 2) {
            return "connected";
        }
        if (i != 3) {
            return "disconnected";
        }
        return "disconnecting";
    }

    /* access modifiers changed from: private */
    public final String parseData(byte[] bArr) {
        if (bArr == null) {
            return "error:data is null";
        }
        if (bArr.length == 0) {
            return "error:data is empty";
        }
        char[] cArr = new char[((bArr.length * 3) - 1)];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 3;
            char[] cArr2 = this.HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
            if (i != bArr.length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        return "(0x) ".concat(new String(cArr));
    }

    static /* synthetic */ void handleConnectError$default(DeviceCommManager deviceCommManager, ReasonCodeConstant reasonCodeConstant, int i, Object obj) {
        if ((i & 1) != 0) {
            reasonCodeConstant = null;
        }
        deviceCommManager.handleConnectError(reasonCodeConstant);
    }

    /* access modifiers changed from: private */
    public final void handleConnectError(ReasonCodeConstant reasonCodeConstant) {
        if (reasonCodeConstant != null) {
            ConnectCallbackListener connectCallbackListener = this.mConnectCallbackListener;
            if (connectCallbackListener != null) {
                connectCallbackListener.onConnectionSuspended(reasonCodeConstant);
            }
            this.mConnectCallbackListener = null;
            return;
        }
        ConnectCallbackListener connectCallbackListener2 = this.mConnectCallbackListener;
        if (connectCallbackListener2 != null) {
            connectCallbackListener2.onConnectFailed(ReasonCodeConstant.ERROR_IN_SERVICE);
        }
    }

    /* access modifiers changed from: private */
    public final void handleConnectSuccess(ArrayList<String> arrayList) {
        ConnectCallbackListener connectCallbackListener = this.mConnectCallbackListener;
        if (connectCallbackListener != null) {
            String str = this.mAddress;
            Intrinsics.checkNotNull(str);
            connectCallbackListener.onConnected(str, this.mDeviceName);
        }
        ConnectCallbackListener connectCallbackListener2 = this.mConnectCallbackListener;
        if (connectCallbackListener2 != null) {
            connectCallbackListener2.onServicesDiscovered(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public final void handleCommandResult(BleActionCode bleActionCode, int i, String str, String str2, byte[] bArr) {
        ResponseCode responseCode;
        String shortUuidByLongUuid = getShortUuidByLongUuid(str, str2);
        Unit unit = null;
        String shortUuidByLongUuid$default = getShortUuidByLongUuid$default(this, str, (String) null, 2, (Object) null);
        int i2 = 0;
        boolean z = i == ResponseCode.SUCCESS.getCode();
        ResponseCode[] values = ResponseCode.values();
        int length = values.length;
        while (true) {
            if (i2 >= length) {
                responseCode = null;
                break;
            }
            responseCode = values[i2];
            if (responseCode.getCode() == i) {
                break;
            }
            i2++;
        }
        if (responseCode != null) {
            unit = Unit.INSTANCE;
        } else {
            responseCode = null;
        }
        ResponseCode responseCode2 = unit == null ? ResponseCode.CUSTOM_UNKNOWN_RESPONSE_CODE : responseCode;
        Intrinsics.checkNotNull(responseCode2);
        BleDataEntity bleDataEntity = new BleDataEntity(bleActionCode, shortUuidByLongUuid, shortUuidByLongUuid$default, bArr, z, responseCode2);
        Function1<? super BleDataEntity, Unit> function1 = this.mDataReceivedCallbackListener;
        if (function1 != null) {
            function1.invoke(bleDataEntity);
        }
    }
}
