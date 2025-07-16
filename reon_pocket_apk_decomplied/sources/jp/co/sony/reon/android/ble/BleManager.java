package jp.co.sony.reon.android.ble;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.ParcelUuid;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.amazonaws.services.s3.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.constant.ResultCodeConstant;
import jp.co.sony.reon.android.ble.constant.TagGattProfileConstant;
import jp.co.sony.reon.android.ble.listener.ConnectCallbackListener;
import jp.co.sony.reon.android.ble.listener.DisconnectCallbackListener;
import jp.co.sony.reon.android.ble.listener.NotificationCallbackListener;
import jp.co.sony.reon.android.ble.listener.ReadCallbackListener;
import jp.co.sony.reon.android.ble.listener.ScanCallbackListener;
import jp.co.sony.reon.android.ble.listener.TagConnectCallbackListener;
import jp.co.sony.reon.android.ble.listener.TagScanCallbackListener;
import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallbackListener;
import jp.co.sony.reon.android.ble.listener.WriteCallbackListener;
import jp.co.sony.reon.android.ble.service.BleService;
import jp.co.sony.reon.android.ble.util.AnalyticsUtil;
import jp.co.sony.reon.android.ble.util.CrashlyticsUtil;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000÷\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0019\u0018\u0000 \u00012\u00020\u0001:\u0006\u0001\u0001\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020+H\u0002J\u001e\u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020+2\b\u00101\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u00020+J\u0010\u00106\u001a\u00020+2\u0006\u00100\u001a\u00020\u0003H\u0002J\u0010\u00107\u001a\u00020+2\u0006\u00100\u001a\u00020\u0003H\u0002J\u0018\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0003J\u0010\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@H\u0003J\u0010\u0010A\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0003J\u0010\u0010B\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0003J\u0010\u0010C\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0003J\u0010\u0010D\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0003J\"\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0018\u0010K\u001a\u00020+2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010F\u001a\u00020GH\u0002J\u0018\u0010L\u001a\u00020+2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010P\u001a\u00020\u0006J\u0010\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020JH\u0002J\u001c\u0010S\u001a\u00020+2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0012\u0010X\u001a\u00020+2\b\u0010T\u001a\u0004\u0018\u00010UH\u0016J \u0010Y\u001a\u00020+2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010ZJ\u0006\u0010[\u001a\u00020+J_\u0010\\\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010_\u001a\u00020\u00032\u0006\u00101\u001a\u000202¢\u0006\u0002\u0010`J/\u0010a\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\b\u00101\u001a\u0004\u0018\u00010c¢\u0006\u0002\u0010dJ\u0018\u0010e\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u00010fJ \u0010g\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010h\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010iJ\u001a\u0010j\u001a\u00020+2\u0006\u0010k\u001a\u00020G2\b\u0010l\u001a\u0004\u0018\u00010mH\u0002J(\u0010n\u001a\u00020+2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\u0006\u0010o\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010pJ\u0006\u0010q\u001a\u00020+Jg\u0010r\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010s\u001a\u00020G2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\b\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010_\u001a\u00020\u00032\b\u0010u\u001a\u0004\u0018\u00010vH\u0007¢\u0006\u0002\u0010wJ_\u0010x\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010y\u001a\u00020G2\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00032\u0006\u0010_\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010vH\u0007¢\u0006\u0002\u0010zJ1\u0010{\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010y\u001a\u00020G2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010|J1\u0010}\u001a\u00020+2\u0006\u0010h\u001a\u00020\u00032\b\b\u0002\u0010y\u001a\u00020G2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010~J\u0006\u0010\u001a\u00020+J\u0011\u0010\u001a\u00020+2\u0007\u0010\u0001\u001a\u00020NH\u0003J\u000f\u0010\u0001\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0007\u0010\u0001\u001a\u00020+J*\u0010\u0001\u001a\u00020+2\u0006\u0010I\u001a\u00020J2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\t\u00101\u001a\u0005\u0018\u00010\u0001J*\u0010\u0001\u001a\u00020+2\u0006\u0010I\u001a\u00020J2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\t\u00101\u001a\u0005\u0018\u00010\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0018\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016X\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R \u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'0&0%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Ljp/co/sony/reon/android/ble/BleManager;", "Landroid/content/ServiceConnection;", "mOwnerId", "", "(Ljava/lang/String;)V", "isCalledScanCallback", "", "isReceivedDeviceConnectState", "()Z", "setReceivedDeviceConnectState", "(Z)V", "isServiceConnected", "mCurrentAction", "Ljp/co/sony/reon/android/ble/BleManager$Action;", "mHandler", "Landroid/os/Handler;", "mMessageQueue", "Ljava/util/LinkedList;", "Landroid/os/Message;", "mReceiveMessenger", "Landroid/os/Messenger;", "mRssiScanDeviceNameFilterArray", "", "[Ljava/lang/String;", "mScanCallback", "jp/co/sony/reon/android/ble/BleManager$mScanCallback$1", "Ljp/co/sony/reon/android/ble/BleManager$mScanCallback$1;", "mScanDeviceNameFilterArray", "mScanDfuDeviceNameFilterArray", "mScanDfuTagNameFilterArray", "mScanInfo", "Ljp/co/sony/reon/android/ble/ScanInfo;", "mScanning", "mSendMessageTaskJob", "Lkotlinx/coroutines/Job;", "mSendMessenger", "mStopCallback", "", "Lkotlin/Pair;", "Ljava/lang/Runnable;", "mTagNoReceivingScanning", "mWantConnectedDeviceAddress", "bind", "", "aContext", "Landroid/content/Context;", "clear", "connect", "aMacAddress", "aCallbackListener", "Ljp/co/sony/reon/android/ble/listener/ConnectCallbackListener;", "disconnect", "Ljp/co/sony/reon/android/ble/listener/DisconnectCallbackListener;", "disconnectTag", "executeConnect", "executeConnectTag", "generateHashKey", "aCharacteristicUuid", "aServiceUuid", "handleActionNone", "aDevice", "Landroid/bluetooth/BluetoothDevice;", "handleActionRssiScan", "aScanResult", "Landroid/bluetooth/le/ScanResult;", "handleActionScanConnect", "handleActionScanConnectDfu", "handleActionScanConnectDfuTag", "handleActionScanConnectWithAddress", "handleReadCallback", "aResponseCode", "", "aHashKey", "aData", "", "handleWriteCallback", "handleWriteTagCallback", "handlerPermissionMiss", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "errorMsg", "hasConnectedToDevice", "isBeaconDevice", "aScanRecord", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "read", "Ljp/co/sony/reon/android/ble/listener/ReadCallbackListener;", "registerClient", "scanConnect", "aDeviceFilterNameArray", "aDfuDeviceFilterNameArray", "aOwnerId", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/co/sony/reon/android/ble/listener/ConnectCallbackListener;)V", "scanConnectTag", "aDfuTagFilterNameArray", "Ljp/co/sony/reon/android/ble/listener/TagConnectCallbackListener;", "(Landroid/content/Context;[Ljava/lang/String;Ljp/co/sony/reon/android/ble/listener/TagConnectCallbackListener;)V", "scanTag", "Ljp/co/sony/reon/android/ble/listener/TagScanCallbackListener;", "scanTagNoReceiving", "aAddress", "Ljp/co/sony/reon/android/ble/listener/TagScanNoReceivingCallbackListener;", "sendServiceMessage", "aWhat", "aBundle", "Landroid/os/Bundle;", "setCharacteristicNotification", "aEnabled", "Ljp/co/sony/reon/android/ble/listener/NotificationCallbackListener;", "setRequestDfuTag", "startRssiScanning", "aNormalScanTime", "aRssiScanDeviceNameFilterArray", "aScanCallbackListener", "Ljp/co/sony/reon/android/ble/listener/ScanCallbackListener;", "(Landroid/content/Context;I[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/co/sony/reon/android/ble/listener/ScanCallbackListener;)V", "startScanning", "aScanTime", "(Landroid/content/Context;I[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljp/co/sony/reon/android/ble/listener/ScanCallbackListener;)V", "startTagScanning", "(Landroid/content/Context;I[Ljava/lang/String;)V", "startTagScanningNoReceiving", "(Ljava/lang/String;I[Ljava/lang/String;)V", "stopScan", "aReason", "unbind", "unregisterClient", "write", "Ljp/co/sony/reon/android/ble/listener/WriteCallbackListener;", "writeTag", "Action", "Companion", "ServiceHandler", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleManager.kt */
public final class BleManager implements ServiceConnection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DELIMITER = "|";
    private static final int SCAN_NO_TIME_OUT_LIMIT = -1;
    private static final int SCAN_TIME_OUT = 15000;
    private static final String TAG = "BleManager";
    private static final int TAG_SCAN_TIME_OUT = 15000;
    private static BluetoothLeScanner mBleScanner;
    /* access modifiers changed from: private */
    public static ConnectCallbackListener mConnectCallbackListener;
    /* access modifiers changed from: private */
    public static DisconnectCallbackListener mDisconnectCallbackListener;
    /* access modifiers changed from: private */
    public static boolean mIsConnected;
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, NotificationCallbackListener> mNotificationCallbackListenerMap = new ConcurrentHashMap<>();
    private static final Map<String, ReadCallbackListener> mReadCallbackListenerMap = new LinkedHashMap();
    private static List<ScanResult> mRssiScanResultList = new ArrayList();
    private static List<BluetoothDevice> mScanBleDeviceList = new ArrayList();
    private static ScanCallbackListener mScanCallbackListener;
    /* access modifiers changed from: private */
    public static TagConnectCallbackListener mTagConnectCallbackListener;
    /* access modifiers changed from: private */
    public static TagScanCallbackListener mTagScanCallbackListener;
    /* access modifiers changed from: private */
    public static TagScanNoReceivingCallbackListener mTagScanNoReceivingCallbackListener;
    private static final Map<String, WriteCallbackListener> mWriteCallbackListenerMap = new LinkedHashMap();
    private static final Map<String, WriteCallbackListener> mWriteTagCallbackListenerMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public boolean isCalledScanCallback;
    private boolean isReceivedDeviceConnectState;
    /* access modifiers changed from: private */
    public boolean isServiceConnected;
    /* access modifiers changed from: private */
    public Action mCurrentAction = Action.NONE;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final LinkedList<Message> mMessageQueue = new LinkedList<>();
    private final String mOwnerId;
    private Messenger mReceiveMessenger;
    private String[] mRssiScanDeviceNameFilterArray = new String[0];
    private final BleManager$mScanCallback$1 mScanCallback = new BleManager$mScanCallback$1(this);
    private String[] mScanDeviceNameFilterArray;
    /* access modifiers changed from: private */
    public String[] mScanDfuDeviceNameFilterArray;
    /* access modifiers changed from: private */
    public String[] mScanDfuTagNameFilterArray;
    private final ScanInfo mScanInfo = new ScanInfo((String) null, (Set) null, 3, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public boolean mScanning;
    private Job mSendMessageTaskJob;
    /* access modifiers changed from: private */
    public Messenger mSendMessenger;
    private Set<? extends Pair<String, ? extends Runnable>> mStopCallback = new HashSet();
    /* access modifiers changed from: private */
    public boolean mTagNoReceivingScanning;
    /* access modifiers changed from: private */
    public String mWantConnectedDeviceAddress;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|(2:21|22)|23|25) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004d */
        static {
            /*
                jp.co.sony.reon.android.ble.BleManager$Action[] r0 = jp.co.sony.reon.android.ble.BleManager.Action.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reon.android.ble.BleManager$Action r2 = jp.co.sony.reon.android.ble.BleManager.Action.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                jp.co.sony.reon.android.ble.BleManager$Action r3 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_CONNECT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                jp.co.sony.reon.android.ble.BleManager$Action r4 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_TAG     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reon.android.ble.BleManager$Action r4 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_CONNECT_TAG     // Catch:{ NoSuchFieldError -> 0x002b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r5 = 4
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reon.android.ble.BleManager$Action r4 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_TAG_NO_RECEIVING     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r5 = 5
                r0[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant[] r0 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r4 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.DEVICE_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.SCAN_TIME_OUT     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.MANUAL_SCAN_STOP     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.BleManager.WhenMappings.<clinit>():void");
        }
    }

    public BleManager(String str) {
        Intrinsics.checkNotNullParameter(str, "mOwnerId");
        this.mOwnerId = str;
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&0\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&0\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ljp/co/sony/reon/android/ble/BleManager$Companion;", "", "()V", "DELIMITER", "", "SCAN_NO_TIME_OUT_LIMIT", "", "SCAN_TIME_OUT", "TAG", "TAG_SCAN_TIME_OUT", "mBleScanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "mConnectCallbackListener", "Ljp/co/sony/reon/android/ble/listener/ConnectCallbackListener;", "mDisconnectCallbackListener", "Ljp/co/sony/reon/android/ble/listener/DisconnectCallbackListener;", "mIsConnected", "", "mNotificationCallbackListenerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljp/co/sony/reon/android/ble/listener/NotificationCallbackListener;", "mReadCallbackListenerMap", "", "Ljp/co/sony/reon/android/ble/listener/ReadCallbackListener;", "mRssiScanResultList", "", "Landroid/bluetooth/le/ScanResult;", "mScanBleDeviceList", "Landroid/bluetooth/BluetoothDevice;", "mScanCallbackListener", "Ljp/co/sony/reon/android/ble/listener/ScanCallbackListener;", "mTagConnectCallbackListener", "Ljp/co/sony/reon/android/ble/listener/TagConnectCallbackListener;", "mTagScanCallbackListener", "Ljp/co/sony/reon/android/ble/listener/TagScanCallbackListener;", "mTagScanNoReceivingCallbackListener", "Ljp/co/sony/reon/android/ble/listener/TagScanNoReceivingCallbackListener;", "mWriteCallbackListenerMap", "Ljp/co/sony/reon/android/ble/listener/WriteCallbackListener;", "mWriteTagCallbackListenerMap", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reon/android/ble/BleManager$Action;", "", "(Ljava/lang/String;I)V", "NONE", "RSSI_SCAN", "SCAN_CONNECT", "SCAN_TAG", "SCAN_TAG_NO_RECEIVING", "SCAN_CONNECT_TAG", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleManager.kt */
    private enum Action {
        NONE,
        RSSI_SCAN,
        SCAN_CONNECT,
        SCAN_TAG,
        SCAN_TAG_NO_RECEIVING,
        SCAN_CONNECT_TAG;

        public static EnumEntries<Action> getEntries() {
            return $ENTRIES;
        }

        static {
            Action[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final boolean isReceivedDeviceConnectState() {
        return this.isReceivedDeviceConnectState;
    }

    public final void setReceivedDeviceConnectState(boolean z) {
        this.isReceivedDeviceConnectState = z;
    }

    public final void bind(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        ComponentName componentName = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            componentName = activity.getComponentName();
        }
        debugLogUtil.v(TAG, "bind(" + componentName + ")");
        this.isReceivedDeviceConnectState = false;
        Intent intent = new Intent(context, BleService.class);
        intent.putExtra(BleService.KEY_INTENT_OWNER_ID, this.mOwnerId);
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    public final void unbind(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        ComponentName componentName = activity != null ? activity.getComponentName() : null;
        debugLogUtil.v(TAG, "unbind(" + componentName + ")");
        try {
            Job job = this.mSendMessageTaskJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.mSendMessenger = null;
            this.mReceiveMessenger = null;
            context.unbindService(this);
            context.stopService(new Intent(context, BleService.class));
            stopScan(ReasonCodeConstant.NONE);
            mScanBleDeviceList.clear();
            mScanCallbackListener = null;
        } catch (IllegalArgumentException e) {
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String message = e.getMessage();
            if (message == null) {
                message = "IllegalArgumentException";
            }
            debugLogUtil2.e(message);
        }
    }

    public final void registerClient() {
        if (this.mSendMessenger != null) {
            sendServiceMessage(0, (Bundle) null);
        }
    }

    public final void unregisterClient() {
        if (this.mSendMessenger != null) {
            sendServiceMessage(1, (Bundle) null);
        }
    }

    private final void sendServiceMessage(int i, Bundle bundle) {
        if (this.isServiceConnected) {
            try {
                Message obtain = Message.obtain((Handler) null, i, (Object) null);
                if (bundle != null) {
                    obtain.setData(bundle);
                }
                obtain.replyTo = this.mReceiveMessenger;
                Messenger messenger = this.mSendMessenger;
                if (messenger != null) {
                    messenger.send(obtain);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            Message obtain2 = Message.obtain((Handler) null, i, (Object) null);
            if (bundle != null) {
                obtain2.setData(bundle);
            }
            obtain2.replyTo = this.mReceiveMessenger;
            this.mMessageQueue.add(obtain2);
            Job job = this.mSendMessageTaskJob;
            if (job == null || job.isCompleted()) {
                this.mSendMessageTaskJob = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new BleManager$sendServiceMessage$4(this, (Continuation<? super BleManager$sendServiceMessage$4>) null), 3, (Object) null);
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.mSendMessenger = null;
        this.mReceiveMessenger = null;
        this.isServiceConnected = false;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mSendMessenger = new Messenger(iBinder);
        this.mReceiveMessenger = new Messenger(new ServiceHandler());
        this.isServiceConnected = true;
        registerClient();
    }

    public final boolean hasConnectedToDevice() {
        return mIsConnected;
    }

    public final void connect(Context context, String str, ConnectCallbackListener connectCallbackListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aMacAddress");
        Intrinsics.checkNotNullParameter(connectCallbackListener, "aCallbackListener");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.v(TAG, "connect(" + str + ")");
        mConnectCallbackListener = connectCallbackListener;
        executeConnect(str);
    }

    public static /* synthetic */ void scanConnect$default(BleManager bleManager, Context context, String str, String[] strArr, String[] strArr2, String str2, String str3, ConnectCallbackListener connectCallbackListener, int i, Object obj) {
        bleManager.scanConnect(context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : strArr, (i & 8) != 0 ? null : strArr2, (i & 16) != 0 ? null : str2, str3, connectCallbackListener);
    }

    public final void scanConnect(Context context, String str, String[] strArr, String[] strArr2, String str2, String str3, ConnectCallbackListener connectCallbackListener) {
        String str4;
        String[] strArr3;
        String str5 = str;
        ConnectCallbackListener connectCallbackListener2 = connectCallbackListener;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str3, "aOwnerId");
        Intrinsics.checkNotNullParameter(connectCallbackListener2, "aCallbackListener");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String str6 = null;
        if (strArr != null) {
            str4 = Arrays.toString(strArr);
            Intrinsics.checkNotNullExpressionValue(str4, "toString(...)");
        } else {
            str4 = null;
        }
        if (strArr2 != null) {
            str6 = Arrays.toString(strArr2);
            Intrinsics.checkNotNullExpressionValue(str6, "toString(...)");
        }
        StringBuilder sb = new StringBuilder("scanConnect macAddress(");
        sb.append(str);
        sb.append("),deviceNameFilter(");
        sb.append(str4);
        sb.append("), dfuDeviceFilterName(");
        sb.append(str6);
        sb.append("), aServiceUuid(");
        String str7 = str2;
        sb.append(str2);
        sb.append(")");
        debugLogUtil.v(TAG, sb.toString());
        mConnectCallbackListener = connectCallbackListener2;
        if (!this.mScanning) {
            this.mScanning = true;
            stopScan(ReasonCodeConstant.INTERRUPT_BY_BLE_SCAN);
            if (str5 == null) {
                this.mCurrentAction = Action.RSSI_SCAN;
                if (strArr == null) {
                    strArr3 = new String[0];
                } else {
                    strArr3 = strArr;
                }
                startRssiScanning(context, 15000, strArr3, strArr, strArr2, str2, str3, (ScanCallbackListener) null);
                return;
            }
            this.mCurrentAction = Action.SCAN_CONNECT;
            this.mWantConnectedDeviceAddress = str5;
            startScanning(context, 15000, strArr, strArr2, str2, str3, (ScanCallbackListener) null);
        }
    }

    public final void startRssiScanning(Context context, int i, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, ScanCallbackListener scanCallbackListener) {
        String[] strArr4 = strArr;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(strArr, "aRssiScanDeviceNameFilterArray");
        Intrinsics.checkNotNullParameter(str2, "aOwnerId");
        if (mBleScanner == null) {
            BleManager bleManager = this;
            Object systemService = context.getApplicationContext().getSystemService("bluetooth");
            BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
            if (bluetoothManager != null) {
                BluetoothAdapter adapter = bluetoothManager.getAdapter();
                if (adapter != null) {
                    Intrinsics.checkNotNull(adapter);
                    mBleScanner = adapter.getBluetoothLeScanner();
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new RuntimeException("BluetoothAdapter is null!");
                }
            } else {
                throw new RuntimeException("BluetoothManager is null!");
            }
        }
        mRssiScanResultList.clear();
        this.mRssiScanDeviceNameFilterArray = strArr4;
        this.mScanning = true;
        DebugLogUtil.INSTANCE.v(TAG, "start RssiScan");
        try {
            BluetoothLeScanner bluetoothLeScanner = mBleScanner;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.startScan(this.mScanCallback);
            }
            this.mHandler.postDelayed(new BleManager$$ExternalSyntheticLambda2(this, context, i, strArr2, strArr3, str, str2, scanCallbackListener), 1000);
        } catch (Exception e) {
            this.mScanning = false;
            ReasonCodeConstant handlerPermissionMiss = handlerPermissionMiss(e.getMessage());
            ConnectCallbackListener connectCallbackListener = mConnectCallbackListener;
            if (connectCallbackListener != null) {
                connectCallbackListener.onConnectFailed(handlerPermissionMiss);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void startRssiScanning$lambda$8(BleManager bleManager, Context context, int i, String[] strArr, String[] strArr2, String str, String str2, ScanCallbackListener scanCallbackListener) {
        String address;
        Intrinsics.checkNotNullParameter(bleManager, "this$0");
        Intrinsics.checkNotNullParameter(context, "$aContext");
        Intrinsics.checkNotNullParameter(str2, "$aOwnerId");
        DebugLogUtil.INSTANCE.v(TAG, "stop RssiScan");
        bleManager.mScanning = false;
        BluetoothLeScanner bluetoothLeScanner = mBleScanner;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(bleManager.mScanCallback);
        }
        if (mRssiScanResultList.isEmpty()) {
            bleManager.mCurrentAction = Action.SCAN_CONNECT;
            bleManager.mWantConnectedDeviceAddress = null;
            bleManager.startScanning(context, i, strArr, strArr2, str, str2, scanCallbackListener);
            return;
        }
        Iterator it = mRssiScanResultList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                BluetoothDevice device = ((ScanResult) next).getDevice();
            } else {
                int rssi = ((ScanResult) next).getRssi();
                do {
                    Object next2 = it.next();
                    int rssi2 = ((ScanResult) next2).getRssi();
                    if (rssi < rssi2) {
                        next = next2;
                        rssi = rssi2;
                    }
                } while (it.hasNext());
            }
            BluetoothDevice device2 = ((ScanResult) next).getDevice();
            if (device2 != null && (address = device2.getAddress()) != null) {
                bleManager.executeConnect(address);
                return;
            }
            return;
        }
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void startScanning$default(BleManager bleManager, Context context, int i, String[] strArr, String[] strArr2, String str, String str2, ScanCallbackListener scanCallbackListener, int i2, Object obj) {
        bleManager.startScanning(context, i, (i2 & 4) != 0 ? null : strArr, (i2 & 8) != 0 ? null : strArr2, (i2 & 16) != 0 ? null : str, str2, scanCallbackListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009a, code lost:
        if (r1 == null) goto L_0x009c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startScanning(android.content.Context r4, int r5, java.lang.String[] r6, java.lang.String[] r7, java.lang.String r8, java.lang.String r9, jp.co.sony.reon.android.ble.listener.ScanCallbackListener r10) {
        /*
            r3 = this;
            java.lang.String r0 = "aContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "aOwnerId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.bluetooth.le.BluetoothLeScanner r0 = mBleScanner
            r1 = 0
            if (r0 != 0) goto L_0x0048
            r0 = r3
            jp.co.sony.reon.android.ble.BleManager r0 = (jp.co.sony.reon.android.ble.BleManager) r0
            android.content.Context r0 = r4.getApplicationContext()
            java.lang.String r2 = "bluetooth"
            java.lang.Object r0 = r0.getSystemService(r2)
            boolean r2 = r0 instanceof android.bluetooth.BluetoothManager
            if (r2 == 0) goto L_0x0023
            android.bluetooth.BluetoothManager r0 = (android.bluetooth.BluetoothManager) r0
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0040
            android.bluetooth.BluetoothAdapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            android.bluetooth.le.BluetoothLeScanner r0 = r0.getBluetoothLeScanner()
            mBleScanner = r0
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x0048
        L_0x0038:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "BluetoothAdapter is null!"
            r4.<init>(r5)
            throw r4
        L_0x0040:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "BluetoothManager is null!"
            r4.<init>(r5)
            throw r4
        L_0x0048:
            jp.co.sony.reon.android.ble.ScanInfo r0 = r3.mScanInfo
            r0.clear()
            java.util.List<android.bluetooth.BluetoothDevice> r0 = mScanBleDeviceList
            r0.clear()
            r0 = 1
            r3.mScanning = r0
            r3.mScanDeviceNameFilterArray = r6
            r3.mScanDfuDeviceNameFilterArray = r7
            mScanCallbackListener = r10
            r6 = 0
            r3.isCalledScanCallback = r6
            jp.co.sony.reon.android.ble.util.DebugLogUtil r7 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r10 = "BleManager"
            java.lang.String r0 = "startScan"
            r7.v(r10, r0)
            if (r8 == 0) goto L_0x009c
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b8 }
            r7.<init>()     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.ScanFilter$Builder r10 = new android.bluetooth.le.ScanFilter$Builder     // Catch:{ Exception -> 0x00b8 }
            r10.<init>()     // Catch:{ Exception -> 0x00b8 }
            android.os.ParcelUuid r8 = android.os.ParcelUuid.fromString(r8)     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.ScanFilter$Builder r8 = r10.setServiceUuid(r8)     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.ScanFilter r8 = r8.build()     // Catch:{ Exception -> 0x00b8 }
            r7.add(r8)     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.BluetoothLeScanner r8 = mBleScanner     // Catch:{ Exception -> 0x00b8 }
            if (r8 == 0) goto L_0x009a
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.ScanSettings$Builder r10 = new android.bluetooth.le.ScanSettings$Builder     // Catch:{ Exception -> 0x00b8 }
            r10.<init>()     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.ScanSettings r10 = r10.build()     // Catch:{ Exception -> 0x00b8 }
            jp.co.sony.reon.android.ble.BleManager$mScanCallback$1 r0 = r3.mScanCallback     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.ScanCallback r0 = (android.bluetooth.le.ScanCallback) r0     // Catch:{ Exception -> 0x00b8 }
            r8.startScan(r7, r10, r0)     // Catch:{ Exception -> 0x00b8 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00b8 }
        L_0x009a:
            if (r1 != 0) goto L_0x00a9
        L_0x009c:
            android.bluetooth.le.BluetoothLeScanner r7 = mBleScanner     // Catch:{ Exception -> 0x00b8 }
            if (r7 == 0) goto L_0x00a9
            jp.co.sony.reon.android.ble.BleManager$mScanCallback$1 r8 = r3.mScanCallback     // Catch:{ Exception -> 0x00b8 }
            android.bluetooth.le.ScanCallback r8 = (android.bluetooth.le.ScanCallback) r8     // Catch:{ Exception -> 0x00b8 }
            r7.startScan(r8)     // Catch:{ Exception -> 0x00b8 }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00b8 }
        L_0x00a9:
            r7 = -1
            if (r5 == r7) goto L_0x00ca
            android.os.Handler r7 = r3.mHandler     // Catch:{ Exception -> 0x00b8 }
            jp.co.sony.reon.android.ble.BleManager$$ExternalSyntheticLambda0 r8 = new jp.co.sony.reon.android.ble.BleManager$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x00b8 }
            r8.<init>(r4, r3, r9)     // Catch:{ Exception -> 0x00b8 }
            long r4 = (long) r5     // Catch:{ Exception -> 0x00b8 }
            r7.postDelayed(r8, r4)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00ca
        L_0x00b8:
            r4 = move-exception
            r3.mScanning = r6
            java.lang.String r4 = r4.getMessage()
            jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r4 = r3.handlerPermissionMiss(r4)
            jp.co.sony.reon.android.ble.listener.ConnectCallbackListener r5 = mConnectCallbackListener
            if (r5 == 0) goto L_0x00ca
            r5.onConnectFailed(r4)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.BleManager.startScanning(android.content.Context, int, java.lang.String[], java.lang.String[], java.lang.String, java.lang.String, jp.co.sony.reon.android.ble.listener.ScanCallbackListener):void");
    }

    /* access modifiers changed from: private */
    public static final void startScanning$lambda$12(Context context, BleManager bleManager, String str) {
        Intrinsics.checkNotNullParameter(context, "$aContext");
        Intrinsics.checkNotNullParameter(bleManager, "this$0");
        Intrinsics.checkNotNullParameter(str, "$aOwnerId");
        AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        AnalyticsUtil.logEventWithBundle$default(analyticsUtil, instance, AnalyticsUtil.EventName.BLE_CONNECT_TIMEOUT_FAILURE, (Bundle) null, 4, (Object) null);
        if (!bleManager.isCalledScanCallback) {
            CrashlyticsUtil.INSTANCE.sendNeveCalledScanCallbackException(str);
        }
        bleManager.stopScan(ReasonCodeConstant.SCAN_TIME_OUT);
    }

    public final void scanTag(Context context, TagScanCallbackListener tagScanCallbackListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        if (!this.mScanning) {
            if (this.mTagNoReceivingScanning) {
                DebugLogUtil.INSTANCE.d(TAG, "stop TagNoReceivingScan");
                stopScan(ReasonCodeConstant.MANUAL_SCAN_STOP);
            }
            if (mBleScanner == null) {
                BleManager bleManager = this;
                Object systemService = context.getApplicationContext().getSystemService("bluetooth");
                BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
                if (bluetoothManager != null) {
                    BluetoothAdapter adapter = bluetoothManager.getAdapter();
                    if (adapter != null) {
                        Intrinsics.checkNotNull(adapter);
                        mBleScanner = adapter.getBluetoothLeScanner();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new RuntimeException("BluetoothAdapter is null!");
                    }
                } else {
                    throw new RuntimeException("BluetoothManager is null!");
                }
            }
            this.mScanning = true;
            mTagScanCallbackListener = tagScanCallbackListener;
            this.mCurrentAction = Action.SCAN_TAG;
            startTagScanning$default(this, context, 0, (String[]) null, 6, (Object) null);
        }
    }

    public final void scanTagNoReceiving(Context context, String str, TagScanNoReceivingCallbackListener tagScanNoReceivingCallbackListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aAddress");
        if (!this.mScanning && !this.mTagNoReceivingScanning) {
            if (mBleScanner == null) {
                BleManager bleManager = this;
                Object systemService = context.getApplicationContext().getSystemService("bluetooth");
                BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
                if (bluetoothManager != null) {
                    BluetoothAdapter adapter = bluetoothManager.getAdapter();
                    if (adapter != null) {
                        Intrinsics.checkNotNull(adapter);
                        mBleScanner = adapter.getBluetoothLeScanner();
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new RuntimeException("BluetoothAdapter is null!");
                    }
                } else {
                    throw new RuntimeException("BluetoothManager is null!");
                }
            }
            this.mTagNoReceivingScanning = true;
            mTagScanNoReceivingCallbackListener = tagScanNoReceivingCallbackListener;
            this.mCurrentAction = Action.SCAN_TAG_NO_RECEIVING;
            startTagScanningNoReceiving$default(this, str, 0, (String[]) null, 6, (Object) null);
        }
    }

    public static /* synthetic */ void scanConnectTag$default(BleManager bleManager, Context context, String[] strArr, TagConnectCallbackListener tagConnectCallbackListener, int i, Object obj) {
        if ((i & 2) != 0) {
            strArr = null;
        }
        bleManager.scanConnectTag(context, strArr, tagConnectCallbackListener);
    }

    public final void scanConnectTag(Context context, String[] strArr, TagConnectCallbackListener tagConnectCallbackListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        if (mBleScanner == null) {
            BleManager bleManager = this;
            Object systemService = context.getApplicationContext().getSystemService("bluetooth");
            BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
            if (bluetoothManager != null) {
                BluetoothAdapter adapter = bluetoothManager.getAdapter();
                if (adapter != null) {
                    Intrinsics.checkNotNull(adapter);
                    mBleScanner = adapter.getBluetoothLeScanner();
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new RuntimeException("BluetoothAdapter is null!");
                }
            } else {
                throw new RuntimeException("BluetoothManager is null!");
            }
        }
        this.mScanning = true;
        mTagConnectCallbackListener = tagConnectCallbackListener;
        this.mCurrentAction = Action.SCAN_CONNECT_TAG;
        startTagScanning$default(this, context, 0, strArr, 2, (Object) null);
    }

    static /* synthetic */ void startTagScanning$default(BleManager bleManager, Context context, int i, String[] strArr, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 15000;
        }
        if ((i2 & 4) != 0) {
            strArr = null;
        }
        bleManager.startTagScanning(context, i, strArr);
    }

    private final void startTagScanning(Context context, int i, String[] strArr) {
        this.mScanDfuTagNameFilterArray = strArr;
        if (strArr == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(TagGattProfileConstant.DeviceControlService.SERVICE_DEVICE_CONTROL.getServiceUuid())).build());
                BluetoothLeScanner bluetoothLeScanner = mBleScanner;
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.startScan(arrayList, new ScanSettings.Builder().build(), this.mScanCallback);
                }
            } catch (Exception unused) {
                this.mScanning = false;
                TagScanCallbackListener tagScanCallbackListener = mTagScanCallbackListener;
                if (tagScanCallbackListener != null) {
                    tagScanCallbackListener.onScanFailed(ReasonCodeConstant.PERMISSION_MISS);
                    return;
                }
                return;
            }
        } else {
            BluetoothLeScanner bluetoothLeScanner2 = mBleScanner;
            if (bluetoothLeScanner2 != null) {
                bluetoothLeScanner2.startScan(this.mScanCallback);
            }
        }
        if (i != -1) {
            this.mHandler.postDelayed(new BleManager$$ExternalSyntheticLambda3(this), (long) i);
        }
    }

    /* access modifiers changed from: private */
    public static final void startTagScanning$lambda$16(BleManager bleManager) {
        Intrinsics.checkNotNullParameter(bleManager, "this$0");
        bleManager.stopScan(ReasonCodeConstant.SCAN_TIME_OUT);
    }

    static /* synthetic */ void startTagScanningNoReceiving$default(BleManager bleManager, String str, int i, String[] strArr, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 15000;
        }
        if ((i2 & 4) != 0) {
            strArr = null;
        }
        bleManager.startTagScanningNoReceiving(str, i, strArr);
    }

    private final void startTagScanningNoReceiving(String str, int i, String[] strArr) {
        this.mScanDfuTagNameFilterArray = strArr;
        if (strArr == null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ScanFilter.Builder().setDeviceAddress(str).build());
                BluetoothLeScanner bluetoothLeScanner = mBleScanner;
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.startScan(arrayList, new ScanSettings.Builder().build(), this.mScanCallback);
                }
            } catch (Exception unused) {
                this.mTagNoReceivingScanning = false;
                TagScanNoReceivingCallbackListener tagScanNoReceivingCallbackListener = mTagScanNoReceivingCallbackListener;
                if (tagScanNoReceivingCallbackListener != null) {
                    tagScanNoReceivingCallbackListener.onScanFailed(ReasonCodeConstant.PERMISSION_MISS);
                    return;
                }
                return;
            }
        } else {
            BluetoothLeScanner bluetoothLeScanner2 = mBleScanner;
            if (bluetoothLeScanner2 != null) {
                bluetoothLeScanner2.startScan(this.mScanCallback);
            }
        }
        if (i != -1) {
            this.mHandler.postDelayed(new BleManager$$ExternalSyntheticLambda1(this), (long) i);
        }
    }

    /* access modifiers changed from: private */
    public static final void startTagScanningNoReceiving$lambda$17(BleManager bleManager) {
        Intrinsics.checkNotNullParameter(bleManager, "this$0");
        bleManager.stopScan(ReasonCodeConstant.SCAN_TIME_OUT);
    }

    private final ReasonCodeConstant handlerPermissionMiss(String str) {
        if (str == null) {
            return ReasonCodeConstant.PERMISSION_MISS_UNEXPECTED;
        }
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, (CharSequence) "android.permission.ACCESS_COARSE_LOCATION", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "android.permission.ACCESS_FINE_LOCATION", false, 2, (Object) null)) {
            return ReasonCodeConstant.PERMISSION_MISS_LOCATION;
        }
        if (StringsKt.contains$default(charSequence, (CharSequence) "android.permission.BLUETOOTH_SCAN", false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "android.permission.BLUETOOTH_CONNECT", false, 2, (Object) null)) {
            return ReasonCodeConstant.PERMISSION_MISS_BLUETOOTH;
        }
        return ReasonCodeConstant.PERMISSION_MISS_UNEXPECTED;
    }

    public final void stopScan() {
        stopScan(ReasonCodeConstant.MANUAL_SCAN_STOP);
    }

    public final void setCharacteristicNotification(String str, String str2, boolean z, NotificationCallbackListener notificationCallbackListener) {
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        if (notificationCallbackListener != null) {
            NotificationCallbackListener put = mNotificationCallbackListenerMap.put(generateHashKey(str, str2), notificationCallbackListener);
        }
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, str);
        bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, str2);
        bundle.putBoolean(BleService.KEY_ARGUMENT_NOTIFY_ENABLED, z);
        sendServiceMessage(4, bundle);
    }

    public final void read(String str, String str2, ReadCallbackListener readCallbackListener) {
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        if (readCallbackListener != null) {
            mReadCallbackListenerMap.put(generateHashKey(str, str2), readCallbackListener);
        }
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, str);
        bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, str2);
        sendServiceMessage(5, bundle);
    }

    public final void write(byte[] bArr, String str, String str2, WriteCallbackListener writeCallbackListener) {
        Intrinsics.checkNotNullParameter(bArr, "aData");
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        if (writeCallbackListener != null) {
            mWriteCallbackListenerMap.put(generateHashKey(str, str2), writeCallbackListener);
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray(BleService.KEY_ARGUMENT_WRITE_DATA, bArr);
        bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, str);
        bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, str2);
        sendServiceMessage(6, bundle);
    }

    public final void writeTag(byte[] bArr, String str, String str2, WriteCallbackListener writeCallbackListener) {
        Intrinsics.checkNotNullParameter(bArr, "aData");
        Intrinsics.checkNotNullParameter(str, "aCharacteristicUuid");
        Intrinsics.checkNotNullParameter(str2, "aServiceUuid");
        if (writeCallbackListener != null) {
            mWriteTagCallbackListenerMap.put(generateHashKey(str, str2), writeCallbackListener);
        }
        Bundle bundle = new Bundle();
        bundle.putByteArray(BleService.KEY_ARGUMENT_WRITE_DATA, bArr);
        bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, str);
        bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, str2);
        sendServiceMessage(14, bundle);
    }

    public final void disconnect(DisconnectCallbackListener disconnectCallbackListener) {
        if (this.mScanning) {
            stopScan(ReasonCodeConstant.MANUAL_SCAN_STOP);
            return;
        }
        mDisconnectCallbackListener = disconnectCallbackListener;
        Bundle bundle = new Bundle();
        bundle.putBoolean(BleService.KEY_ARGUMENT_MANUAL, true);
        sendServiceMessage(3, bundle);
    }

    public final void disconnectTag() {
        if (this.mScanning) {
            stopScan(ReasonCodeConstant.MANUAL_SCAN_STOP);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(BleService.KEY_ARGUMENT_MANUAL_TAG, true);
        sendServiceMessage(19, bundle);
    }

    public final void setRequestDfuTag() {
        sendServiceMessage(11, (Bundle) null);
    }

    private final void executeConnect(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_ADDRESS, str);
        sendServiceMessage(2, bundle);
    }

    /* access modifiers changed from: private */
    public final void executeConnectTag(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_ADDRESS, str);
        sendServiceMessage(13, bundle);
    }

    /* access modifiers changed from: private */
    public final void stopScan(ReasonCodeConstant reasonCodeConstant) {
        boolean z;
        ConnectCallbackListener connectCallbackListener;
        if (this.mScanning || this.mTagNoReceivingScanning) {
            DebugLogUtil.INSTANCE.v(TAG, "stopScan");
            int i = WhenMappings.$EnumSwitchMapping$0[this.mCurrentAction.ordinal()];
            boolean z2 = false;
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                z = false;
            } else if (reasonCodeConstant == ReasonCodeConstant.INTERRUPT_BY_BLE_SCAN) {
                z = true;
            } else {
                z = this.mScanning;
            }
            this.mScanning = z;
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.mCurrentAction.ordinal()];
            if (!(i2 == 3 || i2 == 4 || i2 == 5)) {
                z2 = this.mTagNoReceivingScanning;
            }
            this.mTagNoReceivingScanning = z2;
            Unit unit = null;
            this.mHandler.removeCallbacksAndMessages((Object) null);
            BluetoothLeScanner bluetoothLeScanner = mBleScanner;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.mScanCallback);
            }
            int i3 = WhenMappings.$EnumSwitchMapping$1[reasonCodeConstant.ordinal()];
            if (i3 == 1) {
                DebugLogUtil.INSTANCE.e(TAG, "scan failed！！！");
            } else if (i3 == 2) {
                DebugLogUtil.INSTANCE.e(TAG, "scan timeout！！！");
                if (!this.mScanInfo.getNameIsNullDevices().isEmpty()) {
                    CrashlyticsUtil crashlyticsUtil = CrashlyticsUtil.INSTANCE;
                    String str = this.mOwnerId;
                    String handleFun = this.mScanInfo.getHandleFun();
                    if (handleFun == null) {
                        handleFun = Constants.NULL_VERSION_ID;
                    }
                    crashlyticsUtil.sendReturnedNullDeviceNameException(str, handleFun, CollectionsKt.toSet(this.mScanInfo.getNameIsNullDevices()));
                }
            } else if (i3 == 3) {
                DebugLogUtil.INSTANCE.v(TAG, "manual scan stop");
            }
            if (this.mCurrentAction == Action.SCAN_TAG && reasonCodeConstant != ReasonCodeConstant.NONE) {
                TagScanCallbackListener tagScanCallbackListener = mTagScanCallbackListener;
                if (tagScanCallbackListener != null) {
                    tagScanCallbackListener.onScanFailed(reasonCodeConstant);
                }
            } else if (reasonCodeConstant == ReasonCodeConstant.INTERRUPT_BY_BLE_SCAN) {
                TagScanCallbackListener tagScanCallbackListener2 = mTagScanCallbackListener;
                if (tagScanCallbackListener2 != null) {
                    tagScanCallbackListener2.onScanFailed(reasonCodeConstant);
                }
            } else if (this.mCurrentAction == Action.SCAN_TAG_NO_RECEIVING && reasonCodeConstant != ReasonCodeConstant.NONE) {
                TagScanNoReceivingCallbackListener tagScanNoReceivingCallbackListener = mTagScanNoReceivingCallbackListener;
                if (tagScanNoReceivingCallbackListener != null) {
                    tagScanNoReceivingCallbackListener.onScanFailed(reasonCodeConstant);
                }
            } else if (this.mCurrentAction != Action.SCAN_CONNECT_TAG || reasonCodeConstant == ReasonCodeConstant.NONE) {
                if (mScanCallbackListener != null) {
                    if (reasonCodeConstant == ReasonCodeConstant.NONE || reasonCodeConstant == ReasonCodeConstant.SCAN_TIME_OUT) {
                        ScanCallbackListener scanCallbackListener = mScanCallbackListener;
                        Intrinsics.checkNotNull(scanCallbackListener);
                        scanCallbackListener.onScanSuccess(mScanBleDeviceList);
                    } else {
                        ScanCallbackListener scanCallbackListener2 = mScanCallbackListener;
                        Intrinsics.checkNotNull(scanCallbackListener2);
                        scanCallbackListener2.onScanFailed(reasonCodeConstant);
                    }
                    mScanCallbackListener = null;
                    unit = Unit.INSTANCE;
                }
                if (unit == null && this.mCurrentAction != Action.NONE && reasonCodeConstant != ReasonCodeConstant.NONE && (connectCallbackListener = mConnectCallbackListener) != null) {
                    connectCallbackListener.onConnectFailed(reasonCodeConstant);
                }
            } else {
                TagConnectCallbackListener tagConnectCallbackListener = mTagConnectCallbackListener;
                if (tagConnectCallbackListener != null) {
                    tagConnectCallbackListener.onConnectFailed(reasonCodeConstant);
                }
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
    public final void handleActionRssiScan(ScanResult scanResult) {
        int rssi = scanResult.getRssi();
        String name = scanResult.getDevice().getName();
        String address = scanResult.getDevice().getAddress();
        CharSequence charSequence = name;
        if (charSequence != null && charSequence.length() != 0) {
            for (String str : this.mRssiScanDeviceNameFilterArray) {
                Intrinsics.checkNotNull(name);
                if (new Regex(str).matches(charSequence)) {
                    DebugLogUtil.INSTANCE.d(TAG, "RssiScan: matched device's name:" + name + " address:" + address + ", rssi:" + rssi);
                    mRssiScanResultList.add(scanResult);
                    return;
                }
            }
            DebugLogUtil.INSTANCE.e(TAG, "RssiScan: not matched device's name:" + name);
        }
    }

    /* access modifiers changed from: private */
    public final void handleActionNone(BluetoothDevice bluetoothDevice) {
        Unit unit;
        String name = bluetoothDevice.getName();
        String address = bluetoothDevice.getAddress();
        String[] strArr = this.mScanDeviceNameFilterArray;
        if (strArr != null) {
            CharSequence charSequence = name;
            if (charSequence != null && charSequence.length() != 0) {
                BleManager bleManager = this;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    Intrinsics.checkNotNull(name);
                    if (new Regex(str).matches(charSequence)) {
                        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                        debugLogUtil.d(TAG, "find matched device's name:" + name + " address:" + address);
                        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                        debugLogUtil2.v(TAG, "first scanned device, name:" + name + ", address:" + address);
                        mScanBleDeviceList.add(bluetoothDevice);
                        stopScan(ReasonCodeConstant.NONE);
                        unit = Unit.INSTANCE;
                    } else {
                        i++;
                    }
                }
                DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
                debugLogUtil3.e(TAG, "not matched device's name:" + name);
                return;
            }
            return;
        }
        unit = null;
        if (unit == null && !mScanBleDeviceList.contains(bluetoothDevice)) {
            DebugLogUtil debugLogUtil4 = DebugLogUtil.INSTANCE;
            debugLogUtil4.v(TAG, "add scanned device to list, name:" + name + ", address:" + address);
            mScanBleDeviceList.add(bluetoothDevice);
        }
    }

    /* access modifiers changed from: private */
    public final void handleActionScanConnectWithAddress(BluetoothDevice bluetoothDevice) {
        String name = bluetoothDevice.getName();
        String address = bluetoothDevice.getAddress();
        if (Intrinsics.areEqual((Object) this.mWantConnectedDeviceAddress, (Object) address)) {
            if (name == null) {
                this.mScanInfo.setHandleFun("handleActionScanConnectWithAddress");
                Set<String> nameIsNullDevices = this.mScanInfo.getNameIsNullDevices();
                Intrinsics.checkNotNull(address);
                nameIsNullDevices.add(address);
            } else {
                this.mScanInfo.getNameIsNullDevices().remove(address);
            }
            DebugLogUtil.INSTANCE.d(TAG, "find want connect device's name:" + name + " address:" + address);
            String[] strArr = this.mScanDfuDeviceNameFilterArray;
            int i = 0;
            if (strArr != null) {
                CharSequence charSequence = name;
                if (charSequence != null && charSequence.length() != 0) {
                    BleManager bleManager = this;
                    for (String str : strArr) {
                        Intrinsics.checkNotNull(name);
                        if (new Regex(str).matches(charSequence)) {
                            DebugLogUtil.INSTANCE.e(TAG, "device is dfu mode");
                            stopScan(ReasonCodeConstant.DFU_MODE);
                            return;
                        }
                    }
                    DebugLogUtil.INSTANCE.d(TAG, "device isn't dfu mode");
                } else {
                    return;
                }
            }
            String[] strArr2 = this.mScanDeviceNameFilterArray;
            if (strArr2 != null) {
                CharSequence charSequence2 = name;
                if (charSequence2 != null && charSequence2.length() != 0) {
                    BleManager bleManager2 = this;
                    int length = strArr2.length;
                    while (i < length) {
                        String str2 = strArr2[i];
                        Intrinsics.checkNotNull(name);
                        if (!new Regex(str2).matches(charSequence2)) {
                            i++;
                        }
                    }
                    DebugLogUtil.INSTANCE.e(TAG, "device's name is error");
                    stopScan(ReasonCodeConstant.DEVICE_NAME_ERROR);
                    return;
                }
                return;
            }
            stopScan(ReasonCodeConstant.NONE);
            Intrinsics.checkNotNull(address);
            executeConnect(address);
        }
    }

    /* access modifiers changed from: private */
    public final void handleActionScanConnect(BluetoothDevice bluetoothDevice) {
        String name = bluetoothDevice.getName();
        String address = bluetoothDevice.getAddress();
        if (name == null) {
            this.mScanInfo.setHandleFun("handleActionScanConnect");
            Set<String> nameIsNullDevices = this.mScanInfo.getNameIsNullDevices();
            Intrinsics.checkNotNull(address);
            nameIsNullDevices.add(address);
        } else {
            this.mScanInfo.getNameIsNullDevices().remove(address);
        }
        String[] strArr = this.mScanDeviceNameFilterArray;
        if (strArr != null) {
            CharSequence charSequence = name;
            if (charSequence != null && charSequence.length() != 0) {
                BleManager bleManager = this;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    Intrinsics.checkNotNull(name);
                    if (!new Regex(str).matches(charSequence)) {
                        i++;
                    }
                }
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                debugLogUtil.e(TAG, "not matched device's name:" + name);
                return;
            }
            return;
        }
        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
        debugLogUtil2.v(TAG, "first matched device, name:" + name + ", address:" + address);
        stopScan(ReasonCodeConstant.NONE);
        Intrinsics.checkNotNull(address);
        executeConnect(address);
    }

    /* access modifiers changed from: private */
    public final void handleActionScanConnectDfu(BluetoothDevice bluetoothDevice) {
        String name = bluetoothDevice.getName();
        String address = bluetoothDevice.getAddress();
        String[] strArr = this.mScanDfuDeviceNameFilterArray;
        if (strArr != null) {
            CharSequence charSequence = name;
            if (charSequence != null && charSequence.length() != 0) {
                BleManager bleManager = this;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    Intrinsics.checkNotNull(name);
                    if (!new Regex(str).matches(charSequence)) {
                        i++;
                    }
                }
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                debugLogUtil.e(TAG, "not matched device's name:" + name);
                return;
            }
            return;
        }
        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
        debugLogUtil2.v(TAG, "first matched device, name:" + name + ", address:" + address);
        stopScan(ReasonCodeConstant.NONE);
        Intrinsics.checkNotNull(address);
        executeConnect(address);
    }

    /* access modifiers changed from: private */
    public final void handleActionScanConnectDfuTag(BluetoothDevice bluetoothDevice) {
        String name = bluetoothDevice.getName();
        String address = bluetoothDevice.getAddress();
        String[] strArr = this.mScanDfuTagNameFilterArray;
        if (strArr != null) {
            CharSequence charSequence = name;
            if (charSequence != null && charSequence.length() != 0) {
                BleManager bleManager = this;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    Intrinsics.checkNotNull(name);
                    if (!new Regex(str).matches(charSequence)) {
                        i++;
                    }
                }
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                debugLogUtil.e(TAG, "not matched device's name:" + name);
                return;
            }
            return;
        }
        DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
        debugLogUtil2.e(TAG, "first matched device, name:" + name + ", address:" + address);
        stopScan(ReasonCodeConstant.NONE);
        Intrinsics.checkNotNull(address);
        executeConnectTag(address);
    }

    /* access modifiers changed from: private */
    public final void clear() {
        mReadCallbackListenerMap.clear();
        mWriteCallbackListenerMap.clear();
        mNotificationCallbackListenerMap.clear();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reon/android/ble/BleManager$ServiceHandler;", "Landroid/os/Handler;", "(Ljp/co/sony/reon/android/ble/BleManager;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleManager.kt */
    private final class ServiceHandler extends Handler {
        public ServiceHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            ResultCodeConstant resultCodeConstant;
            TagConnectCallbackListener access$getMTagConnectCallbackListener$cp;
            Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
            int i = message.arg1;
            Bundle data = message.getData();
            String string = data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID);
            String string2 = data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID);
            boolean z = false;
            switch (message.what) {
                case 2:
                    if (i == 0) {
                        Companion companion = BleManager.Companion;
                        BleManager.mIsConnected = true;
                        ConnectCallbackListener access$getMConnectCallbackListener$cp = BleManager.mConnectCallbackListener;
                        if (access$getMConnectCallbackListener$cp != null) {
                            String string3 = data.getString(BleService.KEY_ARGUMENT_ADDRESS);
                            Intrinsics.checkNotNull(string3);
                            access$getMConnectCallbackListener$cp.onConnected(string3, data.getString(BleService.KEY_ARGUMENT_DEVICE_NAME));
                        }
                        ArrayList<String> stringArrayList = data.getStringArrayList(BleService.KEY_ARGUMENT_SERVICE_UUID_LIST);
                        if (stringArrayList == null) {
                            BleManager bleManager = BleManager.this;
                            Companion companion2 = BleManager.Companion;
                            BleManager.mIsConnected = false;
                            ConnectCallbackListener access$getMConnectCallbackListener$cp2 = BleManager.mConnectCallbackListener;
                            if (access$getMConnectCallbackListener$cp2 != null) {
                                access$getMConnectCallbackListener$cp2.onConnectFailed(ReasonCodeConstant.ERROR_IN_SERVICE);
                            }
                            Companion companion3 = BleManager.Companion;
                            BleManager.mConnectCallbackListener = null;
                            bleManager.clear();
                            return;
                        }
                        ConnectCallbackListener access$getMConnectCallbackListener$cp3 = BleManager.mConnectCallbackListener;
                        if (access$getMConnectCallbackListener$cp3 != null) {
                            access$getMConnectCallbackListener$cp3.onServicesDiscovered(stringArrayList);
                            return;
                        }
                        return;
                    }
                    Companion companion4 = BleManager.Companion;
                    BleManager.mIsConnected = false;
                    ConnectCallbackListener access$getMConnectCallbackListener$cp4 = BleManager.mConnectCallbackListener;
                    if (access$getMConnectCallbackListener$cp4 != null) {
                        access$getMConnectCallbackListener$cp4.onConnectFailed(ReasonCodeConstant.ERROR_IN_SERVICE);
                    }
                    Companion companion5 = BleManager.Companion;
                    BleManager.mConnectCallbackListener = null;
                    BleManager.this.clear();
                    return;
                case 3:
                    if (i == 0) {
                        resultCodeConstant = ResultCodeConstant.SUCCESS;
                    } else {
                        resultCodeConstant = ResultCodeConstant.FAILURE;
                    }
                    DisconnectCallbackListener access$getMDisconnectCallbackListener$cp = BleManager.mDisconnectCallbackListener;
                    if (access$getMDisconnectCallbackListener$cp != null) {
                        access$getMDisconnectCallbackListener$cp.onDisconnect(resultCodeConstant);
                    }
                    Companion companion6 = BleManager.Companion;
                    BleManager.mDisconnectCallbackListener = null;
                    if (i == 0) {
                        Companion companion7 = BleManager.Companion;
                        BleManager.mIsConnected = false;
                        ConnectCallbackListener access$getMConnectCallbackListener$cp5 = BleManager.mConnectCallbackListener;
                        if (access$getMConnectCallbackListener$cp5 != null) {
                            access$getMConnectCallbackListener$cp5.onConnectionSuspended(ReasonCodeConstant.MANUAL_DISCONNECT);
                        }
                        Companion companion8 = BleManager.Companion;
                        BleManager.mConnectCallbackListener = null;
                        return;
                    }
                    return;
                case 4:
                    if (data != null && string != null && string2 != null) {
                        String access$generateHashKey = BleManager.this.generateHashKey(string, string2);
                        NotificationCallbackListener notificationCallbackListener = (NotificationCallbackListener) BleManager.mNotificationCallbackListenerMap.get(access$generateHashKey);
                        if (notificationCallbackListener != null) {
                            if (i == 0) {
                                notificationCallbackListener.onNotify(data.getInt(BleService.KEY_ARGUMENT_RESPONSE_CODE), string, string2, data.getByteArray(BleService.KEY_ARGUMENT_NOTIFY_DATA));
                                return;
                            }
                            notificationCallbackListener.onNotify(data.getInt(BleService.KEY_ARGUMENT_RESPONSE_CODE), string, string2, (byte[]) null);
                            BleManager.mNotificationCallbackListenerMap.remove(access$generateHashKey);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (data != null && string != null && string2 != null) {
                        BleManager.this.handleReadCallback(data.getInt(BleService.KEY_ARGUMENT_RESPONSE_CODE), BleManager.this.generateHashKey(string, string2), data.getByteArray(BleService.KEY_ARGUMENT_NOTIFY_DATA));
                        return;
                    }
                    return;
                case 6:
                    if (data != null && string != null && string2 != null) {
                        BleManager bleManager2 = BleManager.this;
                        bleManager2.handleWriteCallback(bleManager2.generateHashKey(string, string2), data.getInt(BleService.KEY_ARGUMENT_RESPONSE_CODE));
                        return;
                    }
                    return;
                case 7:
                case 19:
                    return;
                case 10:
                    Companion companion9 = BleManager.Companion;
                    BleManager.mIsConnected = false;
                    ConnectCallbackListener access$getMConnectCallbackListener$cp6 = BleManager.mConnectCallbackListener;
                    if (access$getMConnectCallbackListener$cp6 != null) {
                        access$getMConnectCallbackListener$cp6.onConnectionSuspended(ReasonCodeConstant.CONNECT_EXCEPTION);
                    }
                    BleManager.this.clear();
                    return;
                case 12:
                    Companion companion10 = BleManager.Companion;
                    if (i == 0) {
                        z = true;
                    }
                    BleManager.mIsConnected = z;
                    BleManager.this.setReceivedDeviceConnectState(true);
                    return;
                case 13:
                    if (i == 0) {
                        TagConnectCallbackListener access$getMTagConnectCallbackListener$cp2 = BleManager.mTagConnectCallbackListener;
                        if (access$getMTagConnectCallbackListener$cp2 != null) {
                            String string4 = data.getString(BleService.KEY_ARGUMENT_ADDRESS);
                            Intrinsics.checkNotNull(string4);
                            access$getMTagConnectCallbackListener$cp2.onConnected(string4, data.getString(BleService.KEY_ARGUMENT_DEVICE_NAME));
                        }
                        ArrayList<String> stringArrayList2 = data.getStringArrayList(BleService.KEY_ARGUMENT_SERVICE_UUID_LIST);
                        if (stringArrayList2 != null && (access$getMTagConnectCallbackListener$cp = BleManager.mTagConnectCallbackListener) != null) {
                            access$getMTagConnectCallbackListener$cp.onServicesDiscovered(stringArrayList2);
                            return;
                        }
                        return;
                    }
                    TagConnectCallbackListener access$getMTagConnectCallbackListener$cp3 = BleManager.mTagConnectCallbackListener;
                    if (access$getMTagConnectCallbackListener$cp3 != null) {
                        access$getMTagConnectCallbackListener$cp3.onConnectFailed(ReasonCodeConstant.ERROR_IN_SERVICE);
                    }
                    Companion companion11 = BleManager.Companion;
                    BleManager.mTagConnectCallbackListener = null;
                    if (BleManager.this.mScanning) {
                        DebugLogUtil.INSTANCE.e("Ble Interactor: EVENT_MESSAGE_TAG_CONNECT stopScan");
                        BleManager.this.stopScan(ReasonCodeConstant.NONE);
                        return;
                    }
                    return;
                case 14:
                    if (data != null && string != null && string2 != null) {
                        BleManager bleManager3 = BleManager.this;
                        bleManager3.handleWriteTagCallback(bleManager3.generateHashKey(string, string2), data.getInt(BleService.KEY_ARGUMENT_RESPONSE_CODE));
                        return;
                    }
                    return;
                case 18:
                    TagConnectCallbackListener access$getMTagConnectCallbackListener$cp4 = BleManager.mTagConnectCallbackListener;
                    if (access$getMTagConnectCallbackListener$cp4 != null) {
                        access$getMTagConnectCallbackListener$cp4.onConnectionSuspended(ReasonCodeConstant.CONNECT_EXCEPTION);
                        return;
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handleReadCallback(int i, String str, byte[] bArr) {
        Map<String, ReadCallbackListener> map = mReadCallbackListenerMap;
        ReadCallbackListener readCallbackListener = map.get(str);
        if (readCallbackListener != null) {
            CharSequence charSequence = str;
            String str2 = (String) SequencesKt.last(StringsKt.splitToSequence$default(charSequence, new String[]{"|"}, false, 0, 6, (Object) null));
            readCallbackListener.onRead(i, str2, (String) SequencesKt.first(StringsKt.splitToSequence$default(charSequence, new String[]{"|"}, false, 0, 6, (Object) null)), bArr);
            ReadCallbackListener remove = map.remove(str);
        }
    }

    /* access modifiers changed from: private */
    public final void handleWriteCallback(String str, int i) {
        Map<String, WriteCallbackListener> map = mWriteCallbackListenerMap;
        WriteCallbackListener writeCallbackListener = map.get(str);
        if (writeCallbackListener != null) {
            CharSequence charSequence = str;
            String str2 = (String) SequencesKt.last(StringsKt.splitToSequence$default(charSequence, new String[]{"|"}, false, 0, 6, (Object) null));
            map.remove(str);
            writeCallbackListener.onWrite(i, str2, (String) SequencesKt.first(StringsKt.splitToSequence$default(charSequence, new String[]{"|"}, false, 0, 6, (Object) null)));
        }
    }

    /* access modifiers changed from: private */
    public final void handleWriteTagCallback(String str, int i) {
        Map<String, WriteCallbackListener> map = mWriteTagCallbackListenerMap;
        WriteCallbackListener writeCallbackListener = map.get(str);
        if (writeCallbackListener != null) {
            CharSequence charSequence = str;
            String str2 = (String) SequencesKt.last(StringsKt.splitToSequence$default(charSequence, new String[]{"|"}, false, 0, 6, (Object) null));
            map.remove(str);
            writeCallbackListener.onWrite(i, str2, (String) SequencesKt.first(StringsKt.splitToSequence$default(charSequence, new String[]{"|"}, false, 0, 6, (Object) null)));
        }
    }

    /* access modifiers changed from: private */
    public final String generateHashKey(String str, String str2) {
        return str2 + "|" + str;
    }
}
