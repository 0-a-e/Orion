package jp.co.sony.reon.android.ble.service;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import jp.co.sony.reon.android.ble.util.BluetoothUtil;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0004\u000e\u0011$,\b\u0007\u0018\u0000 v2\u00020\u0001:\u0005rstuvB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0005H\u0002J\b\u0010?\u001a\u00020<H\u0002J\b\u0010@\u001a\u00020<H\u0002J\b\u0010A\u001a\u00020\bH\u0002J\b\u0010B\u001a\u00020\bH\u0002J\u0014\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020<H\u0016J\b\u0010H\u001a\u00020<H\u0016J\b\u0010I\u001a\u00020<H\u0016J\u0012\u0010J\u001a\u00020<2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\"\u0010K\u001a\u00020\u001f2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001fH\u0016J\u0012\u0010N\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010O\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0014\u0010R\u001a\u00020<2\n\u0010S\u001a\u00060\u001cR\u00020\u0000H\u0002J\u0014\u0010T\u001a\u00020<2\n\u0010S\u001a\u00060\u001cR\u00020\u0000H\u0002J\u0018\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020WH\u0002J\u0010\u0010Y\u001a\u00020<2\u0006\u0010Z\u001a\u00020\fH\u0002J\b\u0010[\u001a\u00020<H\u0002J\u0010\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u000204H\u0002J\u0010\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020!H\u0002J\u0010\u0010`\u001a\u00020<2\u0006\u0010a\u001a\u00020\u001fH\u0002J$\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001f2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010fH\u0002J\u0010\u0010g\u001a\u00020<2\u0006\u0010c\u001a\u00020\u001fH\u0002J \u0010h\u001a\u00020<2\u0006\u0010c\u001a\u00020\u001f2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u0005H\u0002J\u0010\u0010i\u001a\u00020<2\u0006\u0010c\u001a\u00020\u001fH\u0002J \u0010j\u001a\u00020\b2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010k\u001a\u00020\bH\u0002J\b\u0010l\u001a\u00020<H\u0002J\u0010\u0010m\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0005H\u0002J\b\u0010n\u001a\u00020<H\u0002J\b\u0010o\u001a\u00020<H\u0002J \u0010p\u001a\u00020\b2\u0006\u0010P\u001a\u00020Q2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020WH\u0002J \u0010q\u001a\u00020\b2\u0006\u0010P\u001a\u00020Q2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020WH\u0002R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u001cR\u00020\u00000\u001bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u001cR\u00020\u00000\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u000e¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0004¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, d2 = {"Ljp/co/sony/reon/android/ble/service/BleService;", "Landroid/app/Service;", "()V", "aServiceUuidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isReceivedNotifyDataFromWear", "", "isSendDataToClient", "mAddress", "mBleGatt", "Landroid/bluetooth/BluetoothGatt;", "mBluetoothStateBroadcastReceiver", "jp/co/sony/reon/android/ble/service/BleService$mBluetoothStateBroadcastReceiver$1", "Ljp/co/sony/reon/android/ble/service/BleService$mBluetoothStateBroadcastReceiver$1;", "mBondingBroadcastReceiver", "jp/co/sony/reon/android/ble/service/BleService$mBondingBroadcastReceiver$1", "Ljp/co/sony/reon/android/ble/service/BleService$mBondingBroadcastReceiver$1;", "mCommandExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "mCommandExecutorTag", "mCommandLock", "Ljava/util/concurrent/Semaphore;", "mCommandLockTag", "mCommandQueue", "Ljava/util/LinkedList;", "Ljp/co/sony/reon/android/ble/service/BleService$Command;", "mCommandQueueTag", "mConnectRetryCount", "", "mDevice", "Landroid/bluetooth/BluetoothDevice;", "mDeviceName", "mGattCallback", "jp/co/sony/reon/android/ble/service/BleService$mGattCallback$1", "Ljp/co/sony/reon/android/ble/service/BleService$mGattCallback$1;", "mHandler", "Landroid/os/Handler;", "mHasRequestDFU", "mIsConnected", "mIsTagConnected", "mLocationProviderChangedReceiver", "jp/co/sony/reon/android/ble/service/BleService$mLocationProviderChangedReceiver$1", "Ljp/co/sony/reon/android/ble/service/BleService$mLocationProviderChangedReceiver$1;", "mLock", "", "mManualDisconnect", "mManualTagDisconnect", "mOwnerId", "mReceiveMessenger", "Landroid/os/Messenger;", "mRegisterClient", "mSendMessenger", "mServiceDiscoveryRequested", "mServicesDiscovered", "mTagBleGatt", "mTagConnectRetryCount", "close", "", "connect", "aAddress", "dequeueCommand", "dequeueTagCommand", "disconnect", "disconnectTag", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onLowMemory", "onRebind", "onStartCommand", "flags", "startId", "onUnbind", "parseData", "aData", "", "queueCommand", "aCommand", "queueCommandTag", "readCharacteristic", "aCharacteristicUuid", "Ljava/util/UUID;", "aServiceUuid", "refreshDeviceCache", "aGatt", "registerBroadcastReceivers", "registerClient", "aMessenger", "removeBond", "aDevice", "requestMaxMTU", "aMtu", "sendClientMessage", "aWhat", "aArg", "aBundle", "Landroid/os/Bundle;", "sendFailedMsg", "sendFailedMsgWithUuid", "sendSuccessMsg", "setCharacteristicNotification", "aEnabled", "tagClose", "tagConnect", "unregisterBroadcastReceivers", "unregisterClient", "writeCharacteristic", "writeCharacteristicTag", "ClientHandler", "Command", "CommandRunnable", "CommandRunnableTag", "Companion", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleService extends Service {
    private static final int BLE_ERROR_CODE = 65535;
    /* access modifiers changed from: private */
    public static final UUID CHARACTERISTIC_CONFIG_DESCRIPTOR;
    private static final long COMMAND_FAILED_TRY_DELAY = 300;
    private static final long COMMAND_READ_FAILED_RETRY_DELAY = 300;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EVENT_MESSAGE_CLIENT_RECEIVE_DATA_PAUSE = 8;
    public static final int EVENT_MESSAGE_CLIENT_RECEIVE_DATA_RESUME = 9;
    public static final int EVENT_MESSAGE_CONNECT = 2;
    public static final int EVENT_MESSAGE_DEVICE_CONNECTED_STATE = 12;
    public static final int EVENT_MESSAGE_DISCONNECT = 3;
    public static final int EVENT_MESSAGE_DISCONNECT_EXCEPTION = 10;
    public static final int EVENT_MESSAGE_NOTIFY = 4;
    public static final int EVENT_MESSAGE_READ = 5;
    public static final int EVENT_MESSAGE_REGISTER_CLIENT = 0;
    public static final int EVENT_MESSAGE_REQUEST_DFU = 11;
    public static final int EVENT_MESSAGE_REQUEST_MTU = 7;
    public static final int EVENT_MESSAGE_TAG_CONNECT = 13;
    public static final int EVENT_MESSAGE_TAG_DISCONNECT = 19;
    public static final int EVENT_MESSAGE_TAG_DISCONNECTED = 15;
    public static final int EVENT_MESSAGE_TAG_DISCONNECT_EXCEPTION = 18;
    public static final int EVENT_MESSAGE_TAG_GATT_ERROR = 17;
    public static final int EVENT_MESSAGE_TAG_RECONNECT = 16;
    public static final int EVENT_MESSAGE_TAG_WRITE = 14;
    public static final int EVENT_MESSAGE_UNREGISTER_CLIENT = 1;
    public static final int EVENT_MESSAGE_WRITE = 6;
    public static final int GATT_CONN_TERMINATE_LOCAL_HOST = 22;
    public static final int GATT_CONN_TERMINATE_PEER_USER = 19;
    public static final int GATT_CONN_TIMEOUT = 8;
    public static final int GATT_ERROR = 133;
    private static final String HEX_STRING = "0123456789ABCDEF";
    public static final String KEY_ARGUMENT_ADDRESS = "key_argument_address";
    public static final String KEY_ARGUMENT_CHARACTERISTIC_UUID = "key_argument_characteristic_uuid";
    public static final String KEY_ARGUMENT_DEVICE_NAME = "key_argument_device_name";
    public static final String KEY_ARGUMENT_MANUAL = "key_argument_manual";
    public static final String KEY_ARGUMENT_MANUAL_TAG = "key_argument_manual_tag";
    public static final String KEY_ARGUMENT_MTU = "key_argument_mtu";
    public static final String KEY_ARGUMENT_NOTIFY_DATA = "key_argument_notify_data";
    public static final String KEY_ARGUMENT_NOTIFY_ENABLED = "key_argument_notify_status";
    public static final String KEY_ARGUMENT_RESPONSE_CODE = "key_argument_response_code";
    public static final String KEY_ARGUMENT_SERVICE_UUID = "key_argument_service_uuid";
    public static final String KEY_ARGUMENT_SERVICE_UUID_LIST = "key_argument_service_uuid_list";
    public static final String KEY_ARGUMENT_WRITE_DATA = "key_argument_write_data";
    public static final String KEY_INTENT_OWNER_ID = "key_intent_owner_id";
    private static final int LONG_DISCOVER_SERVICE_DELAY = 1500;
    private static final int NUM_CONNECT_RETRY = 3;
    public static final int RESULT_CODE_FAIL = 1;
    public static final int RESULT_CODE_SUCCESS = 0;
    private static final int SHORT_DISCOVER_SERVICE_DELAY = 500;
    private static final String TAG = "BleService";
    /* access modifiers changed from: private */
    public ArrayList<String> aServiceUuidList;
    /* access modifiers changed from: private */
    public boolean isReceivedNotifyDataFromWear;
    /* access modifiers changed from: private */
    public boolean isSendDataToClient = true;
    /* access modifiers changed from: private */
    public String mAddress;
    /* access modifiers changed from: private */
    public BluetoothGatt mBleGatt;
    private final BleService$mBluetoothStateBroadcastReceiver$1 mBluetoothStateBroadcastReceiver = new BleService$mBluetoothStateBroadcastReceiver$1(this);
    private final BleService$mBondingBroadcastReceiver$1 mBondingBroadcastReceiver = new BleService$mBondingBroadcastReceiver$1(this);
    private ExecutorService mCommandExecutor = Executors.newSingleThreadExecutor();
    private ExecutorService mCommandExecutorTag = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public Semaphore mCommandLock = new Semaphore(1, true);
    /* access modifiers changed from: private */
    public Semaphore mCommandLockTag = new Semaphore(1, true);
    private LinkedList<Command> mCommandQueue = new LinkedList<>();
    private LinkedList<Command> mCommandQueueTag = new LinkedList<>();
    /* access modifiers changed from: private */
    public int mConnectRetryCount;
    /* access modifiers changed from: private */
    public BluetoothDevice mDevice;
    /* access modifiers changed from: private */
    public String mDeviceName;
    private BleService$mGattCallback$1 mGattCallback = new BleService$mGattCallback$1(this);
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public boolean mHasRequestDFU;
    /* access modifiers changed from: private */
    public boolean mIsConnected;
    /* access modifiers changed from: private */
    public boolean mIsTagConnected;
    private final BleService$mLocationProviderChangedReceiver$1 mLocationProviderChangedReceiver = new BleService$mLocationProviderChangedReceiver$1(this);
    private final Object mLock = new Object();
    /* access modifiers changed from: private */
    public boolean mManualDisconnect;
    /* access modifiers changed from: private */
    public boolean mManualTagDisconnect;
    /* access modifiers changed from: private */
    public String mOwnerId = "";
    private Messenger mReceiveMessenger = new Messenger(new ClientHandler());
    private boolean mRegisterClient;
    private Messenger mSendMessenger;
    /* access modifiers changed from: private */
    public boolean mServiceDiscoveryRequested;
    /* access modifiers changed from: private */
    public boolean mServicesDiscovered;
    /* access modifiers changed from: private */
    public BluetoothGatt mTagBleGatt;
    /* access modifiers changed from: private */
    public int mTagConnectRetryCount;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020%XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020%XT¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Ljp/co/sony/reon/android/ble/service/BleService$Companion;", "", "()V", "BLE_ERROR_CODE", "", "CHARACTERISTIC_CONFIG_DESCRIPTOR", "Ljava/util/UUID;", "getCHARACTERISTIC_CONFIG_DESCRIPTOR", "()Ljava/util/UUID;", "COMMAND_FAILED_TRY_DELAY", "", "COMMAND_READ_FAILED_RETRY_DELAY", "EVENT_MESSAGE_CLIENT_RECEIVE_DATA_PAUSE", "EVENT_MESSAGE_CLIENT_RECEIVE_DATA_RESUME", "EVENT_MESSAGE_CONNECT", "EVENT_MESSAGE_DEVICE_CONNECTED_STATE", "EVENT_MESSAGE_DISCONNECT", "EVENT_MESSAGE_DISCONNECT_EXCEPTION", "EVENT_MESSAGE_NOTIFY", "EVENT_MESSAGE_READ", "EVENT_MESSAGE_REGISTER_CLIENT", "EVENT_MESSAGE_REQUEST_DFU", "EVENT_MESSAGE_REQUEST_MTU", "EVENT_MESSAGE_TAG_CONNECT", "EVENT_MESSAGE_TAG_DISCONNECT", "EVENT_MESSAGE_TAG_DISCONNECTED", "EVENT_MESSAGE_TAG_DISCONNECT_EXCEPTION", "EVENT_MESSAGE_TAG_GATT_ERROR", "EVENT_MESSAGE_TAG_RECONNECT", "EVENT_MESSAGE_TAG_WRITE", "EVENT_MESSAGE_UNREGISTER_CLIENT", "EVENT_MESSAGE_WRITE", "GATT_CONN_TERMINATE_LOCAL_HOST", "GATT_CONN_TERMINATE_PEER_USER", "GATT_CONN_TIMEOUT", "GATT_ERROR", "HEX_STRING", "", "KEY_ARGUMENT_ADDRESS", "KEY_ARGUMENT_CHARACTERISTIC_UUID", "KEY_ARGUMENT_DEVICE_NAME", "KEY_ARGUMENT_MANUAL", "KEY_ARGUMENT_MANUAL_TAG", "KEY_ARGUMENT_MTU", "KEY_ARGUMENT_NOTIFY_DATA", "KEY_ARGUMENT_NOTIFY_ENABLED", "KEY_ARGUMENT_RESPONSE_CODE", "KEY_ARGUMENT_SERVICE_UUID", "KEY_ARGUMENT_SERVICE_UUID_LIST", "KEY_ARGUMENT_WRITE_DATA", "KEY_INTENT_OWNER_ID", "LONG_DISCOVER_SERVICE_DELAY", "NUM_CONNECT_RETRY", "RESULT_CODE_FAIL", "RESULT_CODE_SUCCESS", "SHORT_DISCOVER_SERVICE_DELAY", "TAG", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UUID getCHARACTERISTIC_CONFIG_DESCRIPTOR() {
            return BleService.CHARACTERISTIC_CONFIG_DESCRIPTOR;
        }
    }

    static {
        UUID fromString = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        CHARACTERISTIC_CONFIG_DESCRIPTOR = fromString;
    }

    public void onCreate() {
        super.onCreate();
        DebugLogUtil.INSTANCE.d(TAG, "onCreate");
        this.mHandler = new Handler(Looper.getMainLooper());
        registerBroadcastReceivers();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        DebugLogUtil.INSTANCE.d(TAG, "onStartCommand");
        this.mConnectRetryCount = 0;
        this.mTagConnectRetryCount = 0;
        String stringExtra = intent != null ? intent.getStringExtra(KEY_INTENT_OWNER_ID) : null;
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.mOwnerId = stringExtra;
        return 1;
    }

    public IBinder onBind(Intent intent) {
        DebugLogUtil.INSTANCE.d(TAG, "onBind");
        return this.mReceiveMessenger.getBinder();
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        DebugLogUtil.INSTANCE.d(TAG, "onRebind");
    }

    public void onLowMemory() {
        super.onLowMemory();
        DebugLogUtil.INSTANCE.d(TAG, "onLowMemory");
    }

    public boolean onUnbind(Intent intent) {
        DebugLogUtil.INSTANCE.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        DebugLogUtil.INSTANCE.d(TAG, "onDestroy");
        unregisterClient();
        disconnect();
        this.mCommandExecutor.shutdownNow();
        this.mCommandExecutorTag.shutdownNow();
        unregisterBroadcastReceivers();
        super.onDestroy();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reon/android/ble/service/BleService$Command;", "", "(Ljp/co/sony/reon/android/ble/service/BleService;)V", "execute", "", "aGatt", "Landroid/bluetooth/BluetoothGatt;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleService.kt */
    public class Command {
        public void execute(BluetoothGatt bluetoothGatt) {
        }

        public Command() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ljp/co/sony/reon/android/ble/service/BleService$CommandRunnable;", "Ljava/lang/Runnable;", "aCommand", "Ljp/co/sony/reon/android/ble/service/BleService$Command;", "Ljp/co/sony/reon/android/ble/service/BleService;", "(Ljp/co/sony/reon/android/ble/service/BleService;Ljp/co/sony/reon/android/ble/service/BleService$Command;)V", "run", "", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleService.kt */
    public final class CommandRunnable implements Runnable {
        private final Command aCommand;
        final /* synthetic */ BleService this$0;

        public CommandRunnable(BleService bleService, Command command) {
            Intrinsics.checkNotNullParameter(command, "aCommand");
            this.this$0 = bleService;
            this.aCommand = command;
        }

        public void run() {
            this.this$0.mCommandLock.acquireUninterruptibly();
            if (!this.this$0.mIsConnected || this.this$0.mBleGatt == null) {
                DebugLogUtil.INSTANCE.e(BleService.TAG, "Device is not connected, or GATT is null");
                this.this$0.mCommandLock.release();
                return;
            }
            this.aCommand.execute(this.this$0.mBleGatt);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ljp/co/sony/reon/android/ble/service/BleService$CommandRunnableTag;", "Ljava/lang/Runnable;", "aCommand", "Ljp/co/sony/reon/android/ble/service/BleService$Command;", "Ljp/co/sony/reon/android/ble/service/BleService;", "(Ljp/co/sony/reon/android/ble/service/BleService;Ljp/co/sony/reon/android/ble/service/BleService$Command;)V", "run", "", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleService.kt */
    public final class CommandRunnableTag implements Runnable {
        private final Command aCommand;
        final /* synthetic */ BleService this$0;

        public CommandRunnableTag(BleService bleService, Command command) {
            Intrinsics.checkNotNullParameter(command, "aCommand");
            this.this$0 = bleService;
            this.aCommand = command;
        }

        public void run() {
            if (!this.this$0.mIsTagConnected || this.this$0.mTagBleGatt == null) {
                DebugLogUtil.INSTANCE.e(BleService.TAG, "Tag Device is not connected, or GATT is null");
                this.this$0.mCommandLockTag.release();
                return;
            }
            this.aCommand.execute(this.this$0.mTagBleGatt);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reon/android/ble/service/BleService$ClientHandler;", "Landroid/os/Handler;", "(Ljp/co/sony/reon/android/ble/service/BleService;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleService.kt */
    public final class ClientHandler extends Handler {
        public ClientHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(message);
            Bundle data = message.getData();
            BleService bleService = BleService.this;
            synchronized (this) {
                int i = message.what;
                if (i != 11) {
                    if (i == 19) {
                        bleService.mManualTagDisconnect = data.getBoolean(BleService.KEY_ARGUMENT_MANUAL_TAG, false);
                        if (!bleService.disconnectTag()) {
                            bleService.sendFailedMsg(19);
                        }
                    } else if (i == 13) {
                        String string = data.getString(BleService.KEY_ARGUMENT_ADDRESS, "");
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        bleService.tagConnect(string);
                        Unit unit = Unit.INSTANCE;
                    } else if (i != 14) {
                        switch (i) {
                            case 0:
                                Messenger messenger = message.replyTo;
                                Intrinsics.checkNotNullExpressionValue(messenger, "replyTo");
                                bleService.registerClient(messenger);
                                BleService.sendClientMessage$default(bleService, 12, bleService.mIsConnected ^ true ? 1 : 0, (Bundle) null, 4, (Object) null);
                                Unit unit2 = Unit.INSTANCE;
                                break;
                            case 1:
                                bleService.unregisterClient();
                                Unit unit3 = Unit.INSTANCE;
                                break;
                            case 2:
                                String string2 = data.getString(BleService.KEY_ARGUMENT_ADDRESS, "");
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                bleService.connect(string2);
                                Unit unit4 = Unit.INSTANCE;
                                break;
                            case 3:
                                bleService.mManualDisconnect = data.getBoolean(BleService.KEY_ARGUMENT_MANUAL, false);
                                if (!bleService.disconnect()) {
                                    bleService.sendFailedMsg(3);
                                    Unit unit5 = Unit.INSTANCE;
                                    break;
                                }
                                break;
                            case 4:
                                UUID fromString = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID));
                                Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
                                UUID fromString2 = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID));
                                Intrinsics.checkNotNullExpressionValue(fromString2, "fromString(...)");
                                boolean access$setCharacteristicNotification = bleService.setCharacteristicNotification(fromString, fromString2, data.getBoolean(BleService.KEY_ARGUMENT_NOTIFY_ENABLED, true));
                                String string3 = data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID);
                                String string4 = data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID);
                                if (string3 != null) {
                                    if (string4 != null) {
                                        if (!access$setCharacteristicNotification) {
                                            bleService.sendFailedMsgWithUuid(4, string3, string4);
                                            Unit unit6 = Unit.INSTANCE;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 5:
                                UUID fromString3 = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID));
                                Intrinsics.checkNotNullExpressionValue(fromString3, "fromString(...)");
                                UUID fromString4 = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID));
                                Intrinsics.checkNotNullExpressionValue(fromString4, "fromString(...)");
                                boolean access$readCharacteristic = bleService.readCharacteristic(fromString3, fromString4);
                                String string5 = data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID);
                                String string6 = data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID);
                                if (string5 != null) {
                                    if (string6 != null) {
                                        if (!access$readCharacteristic) {
                                            bleService.sendFailedMsgWithUuid(5, string5, string6);
                                            Unit unit7 = Unit.INSTANCE;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 6:
                                byte[] byteArray = data.getByteArray(BleService.KEY_ARGUMENT_WRITE_DATA);
                                Intrinsics.checkNotNull(byteArray);
                                UUID fromString5 = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID));
                                Intrinsics.checkNotNullExpressionValue(fromString5, "fromString(...)");
                                UUID fromString6 = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID));
                                Intrinsics.checkNotNullExpressionValue(fromString6, "fromString(...)");
                                boolean access$writeCharacteristic = bleService.writeCharacteristic(byteArray, fromString5, fromString6);
                                String string7 = data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID);
                                String string8 = data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID);
                                if (string7 != null) {
                                    if (string8 != null) {
                                        if (!access$writeCharacteristic) {
                                            bleService.sendFailedMsgWithUuid(5, string7, string8);
                                            Unit unit8 = Unit.INSTANCE;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 7:
                                bleService.requestMaxMTU(data.getInt(BleService.KEY_ARGUMENT_MTU));
                                Unit unit9 = Unit.INSTANCE;
                                break;
                            case 8:
                                bleService.isSendDataToClient = false;
                                Unit unit10 = Unit.INSTANCE;
                                break;
                            case 9:
                                bleService.isSendDataToClient = true;
                                Unit unit11 = Unit.INSTANCE;
                                break;
                        }
                    } else {
                        bleService.dequeueTagCommand();
                        byte[] byteArray2 = data.getByteArray(BleService.KEY_ARGUMENT_WRITE_DATA);
                        Intrinsics.checkNotNull(byteArray2);
                        UUID fromString7 = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID));
                        Intrinsics.checkNotNullExpressionValue(fromString7, "fromString(...)");
                        UUID fromString8 = UUID.fromString(data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID));
                        Intrinsics.checkNotNullExpressionValue(fromString8, "fromString(...)");
                        boolean access$writeCharacteristicTag = bleService.writeCharacteristicTag(byteArray2, fromString7, fromString8);
                        String string9 = data.getString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID);
                        String string10 = data.getString(BleService.KEY_ARGUMENT_SERVICE_UUID);
                        if (string9 != null) {
                            if (string10 != null) {
                                if (!access$writeCharacteristicTag) {
                                    bleService.sendFailedMsgWithUuid(14, string9, string10);
                                    Unit unit12 = Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    Unit unit13 = Unit.INSTANCE;
                } else {
                    bleService.mHasRequestDFU = true;
                    Unit unit14 = Unit.INSTANCE;
                }
            }
        }
    }

    private final void registerBroadcastReceivers() {
        if (Build.VERSION.SDK_INT >= 33) {
            Intent unused = registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 4);
        } else {
            registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
        registerReceiver(this.mLocationProviderChangedReceiver, new IntentFilter("android.location.MODE_CHANGED"));
    }

    private final void unregisterBroadcastReceivers() {
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        unregisterReceiver(this.mLocationProviderChangedReceiver);
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
            char[] charArray = HEX_STRING.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            int i2 = i * 3;
            cArr[i2] = charArray[(b & 255) >>> 4];
            cArr[i2 + 1] = charArray[b & 15];
            if (i != bArr.length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        return "(0x) ".concat(new String(cArr));
    }

    /* access modifiers changed from: private */
    public final void registerClient(Messenger messenger) {
        if (!this.mRegisterClient) {
            this.mSendMessenger = messenger;
            this.mRegisterClient = true;
        }
    }

    /* access modifiers changed from: private */
    public final void unregisterClient() {
        if (this.mRegisterClient) {
            this.mRegisterClient = false;
            sendFailedMsg(2);
            this.mSendMessenger = null;
        }
    }

    /* access modifiers changed from: private */
    public final void sendFailedMsg(int i) {
        sendClientMessage$default(this, i, 1, (Bundle) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void sendFailedMsgWithUuid(int i, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_ARGUMENT_CHARACTERISTIC_UUID, str);
        bundle.putString(KEY_ARGUMENT_SERVICE_UUID, str2);
        bundle.putInt(KEY_ARGUMENT_RESPONSE_CODE, 65535);
        sendClientMessage(i, 1, bundle);
    }

    /* access modifiers changed from: private */
    public final void sendSuccessMsg(int i) {
        sendClientMessage$default(this, i, 0, (Bundle) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void requestMaxMTU(int i) {
        BluetoothGatt bluetoothGatt;
        if (!this.mIsConnected || (bluetoothGatt = this.mBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device not connect of GATT is NULL");
            sendFailedMsg(7);
            return;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        bluetoothGatt.requestMtu(i);
    }

    static /* synthetic */ void sendClientMessage$default(BleService bleService, int i, int i2, Bundle bundle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        bleService.sendClientMessage(i, i2, bundle);
    }

    /* access modifiers changed from: private */
    public final void sendClientMessage(int i, int i2, Bundle bundle) {
        Messenger messenger = this.mSendMessenger;
        if (messenger != null) {
            Message obtain = Message.obtain((Handler) null, i, i2, 0);
            obtain.arg1 = i2;
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean setCharacteristicNotification(UUID uuid, UUID uuid2, boolean z) {
        BluetoothGatt bluetoothGatt;
        if (!this.mIsConnected || (bluetoothGatt = this.mBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device not connect of GATT is NULL");
            return false;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        BluetoothGattService service = bluetoothGatt.getService(uuid2);
        if (service == null) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.e(TAG, "Service not available: " + uuid2);
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid);
        if (characteristic == null) {
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            debugLogUtil2.e(TAG, "Characteristic not available:" + uuid);
            return false;
        }
        queueCommand(new BleService$setCharacteristicNotification$command$1(this, uuid, uuid2, characteristic, z));
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean removeBond(BluetoothDevice bluetoothDevice) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d(TAG, "removeBond(" + bluetoothDevice + ")");
        if (bluetoothDevice.getBondState() == 10) {
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String address = bluetoothDevice.getAddress();
            debugLogUtil2.e(TAG, "Device(" + address + ") is not bonded");
            return false;
        }
        try {
            bluetoothDevice.getClass().getMethod("removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
            return true;
        } catch (Exception e) {
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            String message = e.getMessage();
            debugLogUtil3.e(TAG, "Removing bond has been failed. " + message);
            return false;
        }
    }

    private final void refreshDeviceCache(BluetoothGatt bluetoothGatt) {
        DebugLogUtil.INSTANCE.v(TAG, "Refreshing device cache");
        try {
            bluetoothGatt.getClass().getMethod("refresh", (Class[]) null).invoke(bluetoothGatt, (Object[]) null);
        } catch (Exception e) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String message = e.getMessage();
            debugLogUtil.e(TAG, "An exception occurred while refreshing device. " + message);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r0 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE;
        r2 = getApplicationContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "getApplicationContext(...)");
        r0 = r0.getRemoteDevice(r2, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        if (r0 != null) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE.e(TAG, "Device not found, unable to connect");
        sendFailedMsg(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r7.mDevice = r0;
        jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE.v(TAG, "Trying to create a new connection");
        r7.mIsConnected = false;
        r7.mManualDisconnect = false;
        r7.isReceivedNotifyDataFromWear = false;
        r7.isSendDataToClient = true;
        r7.mBleGatt = r0.connectGatt(r7, false, r7.mGattCallback, 2);
        r7.mAddress = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect(java.lang.String r8) {
        /*
            r7 = this;
            jp.co.sony.reon.android.ble.util.DebugLogUtil r0 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r1 = "BleService"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "connect("
            r2.<init>(r3)
            r2.append(r8)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.d((java.lang.String) r1, (java.lang.String) r2)
            jp.co.sony.reon.android.ble.util.BluetoothUtil r0 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE
            android.content.Context r1 = r7.getApplicationContext()
            java.lang.String r2 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.bluetooth.BluetoothAdapter r0 = r0.bluetoothAdapter(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0031
            boolean r0 = r0.isEnabled()
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            boolean r2 = r7.mIsConnected
            r3 = 2
            if (r2 != 0) goto L_0x00ab
            if (r0 != 0) goto L_0x003a
            goto L_0x00ab
        L_0x003a:
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            android.bluetooth.BluetoothGatt r2 = r7.mBleGatt     // Catch:{ all -> 0x00a8 }
            if (r2 == 0) goto L_0x0053
            jp.co.sony.reon.android.ble.util.DebugLogUtil r8 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = "BleService"
            java.lang.String r2 = "gatt.connect()"
            r8.v(r1, r2)     // Catch:{ all -> 0x00a8 }
            android.bluetooth.BluetoothGatt r8 = r7.mBleGatt     // Catch:{ all -> 0x00a8 }
            if (r8 == 0) goto L_0x0051
            r8.connect()     // Catch:{ all -> 0x00a8 }
        L_0x0051:
            monitor-exit(r0)
            return
        L_0x0053:
            android.content.Context r2 = r7.getApplicationContext()     // Catch:{ all -> 0x00a8 }
            jp.co.sony.reon.android.ble.service.BleService$mBondingBroadcastReceiver$1 r4 = r7.mBondingBroadcastReceiver     // Catch:{ all -> 0x00a8 }
            android.content.BroadcastReceiver r4 = (android.content.BroadcastReceiver) r4     // Catch:{ all -> 0x00a8 }
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x00a8 }
            java.lang.String r6 = "android.bluetooth.device.action.BOND_STATE_CHANGED"
            r5.<init>(r6)     // Catch:{ all -> 0x00a8 }
            r2.registerReceiver(r4, r5)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)
            jp.co.sony.reon.android.ble.util.BluetoothUtil r0 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE
            android.content.Context r2 = r7.getApplicationContext()
            java.lang.String r4 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            android.bluetooth.BluetoothDevice r0 = r0.getRemoteDevice(r2, r8)
            if (r0 != 0) goto L_0x0084
            jp.co.sony.reon.android.ble.util.DebugLogUtil r8 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "BleService"
            java.lang.String r1 = "Device not found, unable to connect"
            r8.e(r0, r1)
            r7.sendFailedMsg(r3)
            return
        L_0x0084:
            r7.mDevice = r0
            jp.co.sony.reon.android.ble.util.DebugLogUtil r2 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r4 = "BleService"
            java.lang.String r5 = "Trying to create a new connection"
            r2.v(r4, r5)
            r7.mIsConnected = r1
            r7.mManualDisconnect = r1
            r7.isReceivedNotifyDataFromWear = r1
            r2 = 1
            r7.isSendDataToClient = r2
            r2 = r7
            android.content.Context r2 = (android.content.Context) r2
            jp.co.sony.reon.android.ble.service.BleService$mGattCallback$1 r4 = r7.mGattCallback
            android.bluetooth.BluetoothGattCallback r4 = (android.bluetooth.BluetoothGattCallback) r4
            android.bluetooth.BluetoothGatt r0 = r0.connectGatt(r2, r1, r4, r3)
            r7.mBleGatt = r0
            r7.mAddress = r8
            return
        L_0x00a8:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        L_0x00ab:
            if (r0 == 0) goto L_0x00e6
            android.bluetooth.BluetoothDevice r0 = r7.mDevice
            if (r0 == 0) goto L_0x00e6
            if (r0 == 0) goto L_0x00b8
            java.lang.String r0 = r0.getAddress()
            goto L_0x00b9
        L_0x00b8:
            r0 = 0
        L_0x00b9:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x00e6
            jp.co.sony.reon.android.ble.util.DebugLogUtil r8 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "BleService"
            java.lang.String r2 = "has connected"
            r8.v(r0, r2)
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            java.lang.String r0 = "key_argument_address"
            java.lang.String r2 = r7.mAddress
            r8.putString(r0, r2)
            java.lang.String r0 = "key_argument_device_name"
            java.lang.String r2 = r7.mDeviceName
            r8.putString(r0, r2)
            java.lang.String r0 = "key_argument_service_uuid_list"
            java.util.ArrayList<java.lang.String> r2 = r7.aServiceUuidList
            r8.putStringArrayList(r0, r2)
            r7.sendClientMessage(r3, r1, r8)
            goto L_0x00f2
        L_0x00e6:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r8 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "BleService"
            java.lang.String r1 = "Device instance instead, and Device may be null or a wrong device"
            r8.e(r0, r1)
            r7.sendFailedMsg(r3)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.service.BleService.connect(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final boolean disconnect() {
        DebugLogUtil.INSTANCE.d(TAG, "Execute disconnect");
        BluetoothGatt bluetoothGatt = this.mBleGatt;
        if (bluetoothGatt == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device not connect of GATT is NULL");
            return false;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        bluetoothGatt.disconnect();
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|(1:13)|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r5 = this;
            android.content.Context r0 = r5.getApplicationContext()     // Catch:{ Exception -> 0x000c }
            jp.co.sony.reon.android.ble.service.BleService$mBondingBroadcastReceiver$1 r1 = r5.mBondingBroadcastReceiver     // Catch:{ Exception -> 0x000c }
            android.content.BroadcastReceiver r1 = (android.content.BroadcastReceiver) r1     // Catch:{ Exception -> 0x000c }
            r0.unregisterReceiver(r1)     // Catch:{ Exception -> 0x000c }
            goto L_0x0010
        L_0x000c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0010:
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            android.bluetooth.BluetoothGatt r1 = r5.mBleGatt     // Catch:{ all -> 0x0045 }
            r2 = 0
            if (r1 == 0) goto L_0x0032
            jp.co.sony.reon.android.ble.util.DebugLogUtil r1 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "BleService"
            java.lang.String r4 = "gatt.close()"
            r1.v(r3, r4)     // Catch:{ all -> 0x0045 }
            android.bluetooth.BluetoothGatt r1 = r5.mBleGatt     // Catch:{ all -> 0x0030 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x0030 }
            r5.refreshDeviceCache(r1)     // Catch:{ all -> 0x0030 }
            android.bluetooth.BluetoothGatt r1 = r5.mBleGatt     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            r5.mBleGatt = r2     // Catch:{ all -> 0x0045 }
        L_0x0032:
            r1 = 0
            r5.mIsConnected = r1     // Catch:{ all -> 0x0045 }
            java.util.concurrent.Semaphore r1 = r5.mCommandLock     // Catch:{ all -> 0x0045 }
            r1.release()     // Catch:{ all -> 0x0045 }
            java.util.LinkedList<jp.co.sony.reon.android.ble.service.BleService$Command> r1 = r5.mCommandQueue     // Catch:{ all -> 0x0045 }
            r1.clear()     // Catch:{ all -> 0x0045 }
            r5.mDevice = r2     // Catch:{ all -> 0x0045 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)
            return
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.service.BleService.close():void");
    }

    /* access modifiers changed from: private */
    public final boolean readCharacteristic(UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d(TAG, "Attempting to read:" + uuid);
        if (!this.mIsConnected || (bluetoothGatt = this.mBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device is not connected, or GATT is null");
            return false;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        BluetoothGattService service = bluetoothGatt.getService(uuid2);
        if (service == null) {
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            debugLogUtil2.e(TAG, "Service not available:" + uuid2);
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid);
        if (characteristic == null) {
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            debugLogUtil3.e(TAG, "Characteristic not available:" + uuid);
            return false;
        }
        queueCommand(new BleService$readCharacteristic$command$1(this, characteristic));
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean writeCharacteristic(byte[] bArr, UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String arrays = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        debugLogUtil.d(TAG, "Attempting to write " + arrays + " to " + uuid);
        if (!this.mIsConnected || (bluetoothGatt = this.mBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device is not connected, or GATT is null");
            return false;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        BluetoothGattService service = bluetoothGatt.getService(uuid2);
        if (service == null) {
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            debugLogUtil2.e(TAG, "Service not available " + uuid2);
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid);
        if (characteristic == null) {
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            debugLogUtil3.e(TAG, "Characteristic not available " + uuid);
            return false;
        }
        boolean value = characteristic.setValue(bArr);
        if ((characteristic.getProperties() & 4) != 0) {
            characteristic.setWriteType(1);
        } else if ((characteristic.getProperties() & 8) != 0) {
            characteristic.setWriteType(2);
        }
        queueCommand(new BleService$writeCharacteristic$command$1(this, characteristic));
        return value;
    }

    private final void queueCommand(Command command) {
        synchronized (this.mCommandQueue) {
            this.mCommandQueue.add(command);
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            int size = this.mCommandQueue.size();
            debugLogUtil.d(TAG, "Add command to queue: " + size);
            this.mCommandExecutor.execute(new CommandRunnable(this, command));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void dequeueCommand() {
        if (!this.mCommandQueue.isEmpty()) {
            try {
                this.mCommandQueue.pop();
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                int size = this.mCommandQueue.size();
                debugLogUtil.d(TAG, "Remove command from queue: " + size);
            } catch (Exception e) {
                DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                String message = e.getMessage();
                debugLogUtil2.e(TAG, "Exception occurred：" + message);
            } catch (Throwable th) {
                this.mCommandLock.release();
                throw th;
            }
            this.mCommandLock.release();
        }
    }

    /* access modifiers changed from: private */
    public final void tagConnect(String str) {
        if (!this.mIsTagConnected) {
            BluetoothUtil bluetoothUtil = BluetoothUtil.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            BluetoothDevice remoteDevice = bluetoothUtil.getRemoteDevice(applicationContext, str);
            if (remoteDevice == null) {
                DebugLogUtil.INSTANCE.e(TAG, "Tag not found, unable to connect");
                sendFailedMsg(13);
                return;
            }
            this.mTagBleGatt = remoteDevice.connectGatt(this, false, new BleTagGattCallback(new BleService$tagConnect$1(this)), 2);
        }
    }

    /* access modifiers changed from: private */
    public final boolean disconnectTag() {
        DebugLogUtil.INSTANCE.d(TAG, "Execute disconnect Tag");
        BluetoothGatt bluetoothGatt = this.mTagBleGatt;
        if (bluetoothGatt == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device not connect of GATT is NULL");
            return false;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        bluetoothGatt.disconnect();
        return true;
    }

    /* access modifiers changed from: private */
    public final void tagClose() {
        try {
            getApplicationContext().unregisterReceiver(this.mBondingBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (this.mLock) {
            if (this.mTagBleGatt != null) {
                DebugLogUtil.INSTANCE.v(TAG, "gatt.close()");
                try {
                    BluetoothGatt bluetoothGatt = this.mTagBleGatt;
                    Intrinsics.checkNotNull(bluetoothGatt);
                    refreshDeviceCache(bluetoothGatt);
                    BluetoothGatt bluetoothGatt2 = this.mTagBleGatt;
                    if (bluetoothGatt2 != null) {
                        bluetoothGatt2.close();
                    }
                } catch (Throwable unused) {
                }
                this.mTagBleGatt = null;
            }
            this.mIsTagConnected = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final boolean writeCharacteristicTag(byte[] bArr, UUID uuid, UUID uuid2) {
        BluetoothGatt bluetoothGatt;
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String arrays = Arrays.toString(bArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        debugLogUtil.d(TAG, "Attempting to write " + arrays + " to " + uuid);
        if (!this.mIsTagConnected || (bluetoothGatt = this.mTagBleGatt) == null) {
            DebugLogUtil.INSTANCE.e(TAG, "Device is not connected, or GATT is null");
            return false;
        }
        Intrinsics.checkNotNull(bluetoothGatt);
        BluetoothGattService service = bluetoothGatt.getService(uuid2);
        if (service == null) {
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            debugLogUtil2.e(TAG, "Service not available " + uuid2);
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid);
        if (characteristic == null) {
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            debugLogUtil3.e(TAG, "Characteristic not available " + uuid);
            return false;
        }
        boolean value = characteristic.setValue(bArr);
        if ((characteristic.getProperties() & 4) != 0) {
            characteristic.setWriteType(1);
        } else if ((characteristic.getProperties() & 8) != 0) {
            characteristic.setWriteType(2);
        }
        queueCommandTag(new BleService$writeCharacteristicTag$command$1(this, characteristic));
        return value;
    }

    private final void queueCommandTag(Command command) {
        synchronized (this.mCommandQueueTag) {
            this.mCommandQueueTag.add(command);
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            int size = this.mCommandQueueTag.size();
            debugLogUtil.d(TAG, "Add command to queue: " + size);
            this.mCommandExecutorTag.execute(new CommandRunnableTag(this, command));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void dequeueTagCommand() {
        if (!this.mCommandQueueTag.isEmpty()) {
            this.mCommandQueueTag.pop();
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            int size = this.mCommandQueueTag.size();
            debugLogUtil.d(TAG, "Remove command from queue: " + size);
            this.mCommandLockTag.release();
        }
    }
}
