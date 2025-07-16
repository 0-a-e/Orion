package no.nordicsemi.android.dfu;

import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuProgressInfo;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;

public abstract class DfuBaseService extends IntentService implements DfuProgressInfo.ProgressListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ACTION_ABORT = 2;
    public static final int ACTION_PAUSE = 0;
    public static final int ACTION_RESUME = 1;
    public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
    public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
    public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
    public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
    static boolean DEBUG = false;
    public static final int ERROR_BLUETOOTH_DISABLED = 4106;
    public static final int ERROR_CONNECTION_MASK = 16384;
    public static final int ERROR_CONNECTION_STATE_MASK = 32768;
    public static final int ERROR_CRC_ERROR = 4109;
    public static final int ERROR_DEVICE_DISCONNECTED = 4096;
    public static final int ERROR_DEVICE_NOT_BONDED = 4110;
    public static final int ERROR_FILE_ERROR = 4098;
    public static final int ERROR_FILE_INVALID = 4099;
    public static final int ERROR_FILE_IO_EXCEPTION = 4100;
    public static final int ERROR_FILE_NOT_FOUND = 4097;
    public static final int ERROR_FILE_SIZE_INVALID = 4108;
    public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
    public static final int ERROR_INIT_PACKET_REQUIRED = 4107;
    public static final int ERROR_INVALID_RESPONSE = 4104;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_PROGRESS_LOST = 4111;
    public static final int ERROR_REMOTE_MASK = 8192;
    public static final int ERROR_REMOTE_TYPE_LEGACY = 256;
    public static final int ERROR_REMOTE_TYPE_SECURE = 512;
    public static final int ERROR_REMOTE_TYPE_SECURE_BUTTONLESS = 2048;
    public static final int ERROR_REMOTE_TYPE_SECURE_EXTENDED = 1024;
    public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
    public static final int ERROR_SERVICE_NOT_FOUND = 4102;
    public static final int ERROR_TYPE_COMMUNICATION = 2;
    public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
    public static final int ERROR_TYPE_DFU_REMOTE = 3;
    public static final int ERROR_TYPE_OTHER = 0;
    public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
    public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
    public static final String EXTRA_CURRENT_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU";
    public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
    public static final String EXTRA_DATA_OBJECT_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_DATA_OBJECT_DELAY";
    public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
    static final String EXTRA_DFU_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT";
    public static final String EXTRA_DISABLE_NOTIFICATION = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
    public static final String EXTRA_DISABLE_RESUME = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME";
    public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
    public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
    public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
    public static final String EXTRA_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
    public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
    public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
    public static final String EXTRA_FORCE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU";
    public static final String EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU";
    public static final String EXTRA_FOREGROUND_SERVICE = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE";
    public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
    public static final String EXTRA_INIT_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
    public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
    public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
    public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
    public static final String EXTRA_MAX_DFU_ATTEMPTS = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS";
    public static final String EXTRA_MBR_SIZE = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE";
    public static final String EXTRA_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_MTU";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE";
    public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
    public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
    public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
    private static final String EXTRA_RECONNECTION_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT";
    public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
    public static final String EXTRA_SCAN_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_DELAY";
    public static final String EXTRA_SCAN_TIMEOUT = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_TIMEOUT";
    public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
    public static final String EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final int LOG_LEVEL_APPLICATION = 10;
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 20;
    public static final int LOG_LEVEL_INFO = 5;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 15;
    public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_ZIP = "application/zip";
    public static final String NOTIFICATION_CHANNEL_DFU = "dfu";
    public static final int NOTIFICATION_ID = 283;
    public static final int PROGRESS_ABORTED = -7;
    public static final int PROGRESS_COMPLETED = -6;
    public static final int PROGRESS_CONNECTING = -1;
    public static final int PROGRESS_DISCONNECTING = -5;
    public static final int PROGRESS_ENABLING_DFU_MODE = -3;
    public static final int PROGRESS_STARTING = -2;
    public static final int PROGRESS_VALIDATING = -4;
    protected static final int STATE_CLOSED = -5;
    protected static final int STATE_CONNECTED = -2;
    protected static final int STATE_CONNECTED_AND_READY = -3;
    protected static final int STATE_CONNECTING = -1;
    protected static final int STATE_DISCONNECTED = 0;
    protected static final int STATE_DISCONNECTING = -4;
    private static final String TAG = "DfuBaseService";
    public static final int TYPE_APPLICATION = 4;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_BOOTLOADER = 2;
    public static final int TYPE_SOFT_DEVICE = 1;
    /* access modifiers changed from: private */
    public boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothStateBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
            DfuBaseService dfuBaseService = DfuBaseService.this;
            dfuBaseService.logw("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: " + intExtra + ", previous state: " + intExtra2 + "]");
            if (intExtra2 != 12) {
                return;
            }
            if (intExtra == 13 || intExtra == 10) {
                DfuBaseService.this.sendLogBroadcast(15, "Bluetooth adapter disabled");
                DfuBaseService.this.mConnectionState = 0;
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }
        }
    };
    private final BroadcastReceiver mBondStateBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress) && (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) != 11 && DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.onBondStateChanged(intExtra);
            }
        }
    };
    protected int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                String action = intent.getAction();
                DfuBaseService dfuBaseService = DfuBaseService.this;
                dfuBaseService.logi("Action received: " + action);
                DfuBaseService dfuBaseService2 = DfuBaseService.this;
                dfuBaseService2.sendLogBroadcast(0, "[Broadcast] Action received: " + action);
            }
        }
    };
    /* access modifiers changed from: private */
    public String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_ACTION, 0);
            DfuBaseService dfuBaseService = DfuBaseService.this;
            dfuBaseService.logi("User action received: " + intExtra);
            if (intExtra == 0) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Pause action received");
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.pause();
                }
            } else if (intExtra == 1) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Resume action received");
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.resume();
                }
            } else if (intExtra == 2) {
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Abort action received");
                DfuBaseService.this.mAborted = true;
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.abort();
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public DfuCallback mDfuServiceImpl;
    private boolean mDisableNotification;
    /* access modifiers changed from: private */
    public int mError;
    private InputStream mFirmwareInputStream;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i != 0) {
                if (i == 8 || i == 19) {
                    DfuBaseService dfuBaseService = DfuBaseService.this;
                    dfuBaseService.logw("Target device disconnected with status: " + i);
                } else {
                    DfuBaseService dfuBaseService2 = DfuBaseService.this;
                    dfuBaseService2.loge("Connection state change error: " + i + " newState: " + i2);
                }
                DfuBaseService.this.mError = i | 32768;
                if (i2 == 0) {
                    DfuBaseService.this.mConnectionState = 0;
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                    }
                }
            } else if (i2 == 2) {
                DfuBaseService.this.logi("Connected to GATT server");
                DfuBaseService dfuBaseService3 = DfuBaseService.this;
                dfuBaseService3.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                DfuBaseService.this.mConnectionState = -2;
                if (bluetoothGatt.getDevice().getBondState() == 12) {
                    DfuBaseService.this.logi("Waiting 1600 ms for a possible Service Changed indication...");
                    DfuBaseService.this.waitFor(1600);
                }
                DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                boolean discoverServices = bluetoothGatt.discoverServices();
                DfuBaseService.this.logi("Attempting to start service discovery... ".concat(discoverServices ? "succeed" : "failed"));
                if (!discoverServices) {
                    DfuBaseService.this.mError = DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
                } else {
                    return;
                }
            } else if (i2 == 0) {
                DfuBaseService.this.logi("Disconnected from GATT server");
                DfuBaseService.this.mConnectionState = 0;
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                }
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                DfuBaseService.this.logi("Services discovered");
                DfuBaseService.this.mConnectionState = -3;
            } else {
                DfuBaseService dfuBaseService = DfuBaseService.this;
                dfuBaseService.loge("Service discovery error: " + i);
                DfuBaseService.this.mError = i | 16384;
            }
            synchronized (DfuBaseService.this.mLock) {
                DfuBaseService.this.mLock.notifyAll();
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            }
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onMtuChanged(bluetoothGatt, i, i2);
            }
        }

        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (DfuBaseService.this.mDfuServiceImpl != null) {
                DfuBaseService.this.mDfuServiceImpl.getGattCallback().onPhyUpdate(bluetoothGatt, i, i2, i3);
            }
        }
    };
    private InputStream mInitFileInputStream;
    private long mLastNotificationTime;
    private int mLastProgress = -1;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    DfuProgressInfo mProgressInfo;

    /* access modifiers changed from: protected */
    public abstract Class<? extends Activity> getNotificationTarget();

    /* access modifiers changed from: protected */
    public boolean isDebug() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void updateErrorNotification(NotificationCompat.Builder builder) {
    }

    /* access modifiers changed from: protected */
    public void updateForegroundNotification(NotificationCompat.Builder builder) {
    }

    public DfuBaseService() {
        super(TAG);
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        return intentFilter;
    }

    public void onCreate() {
        super.onCreate();
        DEBUG = isDebug();
        logi("DFU service created. Version: 2.5.0");
        initialize();
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this);
        IntentFilter makeDfuActionIntentFilter = makeDfuActionIntentFilter();
        instance.registerReceiver(this.mDfuActionReceiver, makeDfuActionIntentFilter);
        ContextCompat.registerReceiver(this, this.mDfuActionReceiver, makeDfuActionIntentFilter, 2);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        ContextCompat.registerReceiver(this, this.mConnectionStateBroadcastReceiver, intentFilter, 2);
        ContextCompat.registerReceiver(this, this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"), 2);
        ContextCompat.registerReceiver(this, this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 2);
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.cancel(NOTIFICATION_ID);
        }
        stopSelf();
    }

    public void onDestroy() {
        super.onDestroy();
        DfuCallback dfuCallback = this.mDfuServiceImpl;
        if (dfuCallback != null) {
            dfuCallback.abort();
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        try {
            InputStream inputStream = this.mFirmwareInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            InputStream inputStream2 = this.mInitFileInputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.mFirmwareInputStream = null;
            this.mInitFileInputStream = null;
            throw th;
        }
        this.mFirmwareInputStream = null;
        this.mInitFileInputStream = null;
        logi("DFU service destroyed");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x04d1, code lost:
        if (r2 != null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x055d, code lost:
        if (r2 != null) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0126, code lost:
        if (r3 < 0) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0133, code lost:
        if (r3 < 0) goto L_0x0135;
     */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0239 A[Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0261 A[SYNTHETIC, Splitter:B:147:0x0261] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0482 A[Catch:{ all -> 0x0471 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x04a4 A[Catch:{ all -> 0x0471 }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x04fa A[Catch:{ all -> 0x0471 }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0543  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0569 A[SYNTHETIC, Splitter:B:295:0x0569] */
    /* JADX WARNING: Removed duplicated region for block: B:345:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r32) {
        /*
            r31 = this;
            r1 = r31
            r8 = r32
            java.lang.String r2 = "Bluetooth adapter disabled"
            java.lang.String r3 = "Attempt: "
            java.lang.String r9 = "Restarting the service ("
            java.lang.String r4 = "Device not reachable. Check if the device with address "
            java.lang.String r5 = "An error occurred while connecting to the device: "
            java.lang.String r6 = "Connection error after: "
            java.lang.String r7 = "An error occurred during discovering services:"
            if (r8 != 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r10 = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS"
            java.lang.String r10 = r8.getStringExtra(r10)
            java.lang.String r11 = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME"
            java.lang.String r11 = r8.getStringExtra(r11)
            java.lang.String r12 = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION"
            r13 = 0
            boolean r12 = r8.getBooleanExtra(r12, r13)
            java.lang.String r14 = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE"
            r15 = 1
            boolean r14 = r8.getBooleanExtra(r14, r15)
            java.lang.String r15 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH"
            java.lang.String r15 = r8.getStringExtra(r15)
            java.lang.String r13 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI"
            android.os.Parcelable r13 = r8.getParcelableExtra(r13)
            android.net.Uri r13 = (android.net.Uri) r13
            r16 = r9
            java.lang.String r9 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID"
            r17 = r3
            r3 = 0
            int r9 = r8.getIntExtra(r9, r3)
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH"
            java.lang.String r3 = r8.getStringExtra(r3)
            r18 = r7
            java.lang.String r7 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI"
            android.os.Parcelable r7 = r8.getParcelableExtra(r7)
            android.net.Uri r7 = (android.net.Uri) r7
            r19 = r5
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID"
            r20 = r4
            r4 = 0
            int r5 = r8.getIntExtra(r5, r4)
            r21 = r6
            java.lang.String r6 = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE"
            int r6 = r8.getIntExtra(r6, r4)
            if (r15 == 0) goto L_0x0081
            if (r6 != 0) goto L_0x0081
            java.util.Locale r6 = java.util.Locale.US
            java.lang.String r6 = r15.toLowerCase(r6)
            java.lang.String r4 = "zip"
            boolean r4 = r6.endsWith(r4)
            if (r4 == 0) goto L_0x007f
            r4 = 0
            goto L_0x0080
        L_0x007f:
            r4 = 4
        L_0x0080:
            r6 = r4
        L_0x0081:
            java.lang.String r4 = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE"
            java.lang.String r4 = r8.getStringExtra(r4)
            r22 = r2
            java.lang.String r2 = "application/zip"
            r23 = r5
            java.lang.String r5 = "application/octet-stream"
            if (r4 == 0) goto L_0x0092
            goto L_0x0097
        L_0x0092:
            if (r6 != 0) goto L_0x0096
            r4 = r2
            goto L_0x0097
        L_0x0096:
            r4 = r5
        L_0x0097:
            if (r10 == 0) goto L_0x0612
            if (r15 != 0) goto L_0x00a1
            if (r13 != 0) goto L_0x00a1
            if (r9 != 0) goto L_0x00a1
            goto L_0x0612
        L_0x00a1:
            r24 = r6 & -8
            r25 = r3
            if (r24 > 0) goto L_0x0602
            boolean r24 = r2.equals(r4)
            if (r24 != 0) goto L_0x00b5
            boolean r24 = r5.equals(r4)
            if (r24 != 0) goto L_0x00b5
            goto L_0x0602
        L_0x00b5:
            boolean r5 = r5.equals(r4)
            r3 = 2
            if (r5 == 0) goto L_0x00d4
            r5 = 1
            if (r6 == r5) goto L_0x00d4
            if (r6 == r3) goto L_0x00d4
            r5 = 4
            if (r6 == r5) goto L_0x00d4
            java.lang.String r2 = "Unable to determine file type"
            r1.logw(r2)
            r3 = 15
            r1.sendLogBroadcast(r3, r2)
            r2 = 4105(0x1009, float:5.752E-42)
            r1.report(r2)
            return
        L_0x00d4:
            if (r12 != 0) goto L_0x00e5
            java.lang.Class r5 = r31.getNotificationTarget()
            if (r5 == 0) goto L_0x00dd
            goto L_0x00e5
        L_0x00dd:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "getNotificationTarget() must not return null if notifications are enabled"
            r2.<init>(r3)
            throw r2
        L_0x00e5:
            r5 = 26
            if (r14 != 0) goto L_0x00f2
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r5) goto L_0x00f2
            java.lang.String r3 = "Foreground service disabled. Android Oreo or newer may kill a background service few moments after user closes the application.\nConsider enabling foreground service using DfuServiceInitiator#setForeground(boolean)"
            r1.logw(r3)
        L_0x00f2:
            no.nordicsemi.android.dfu.UuidHelper.assignCustomUuids(r32)
            if (r14 == 0) goto L_0x00ff
            java.lang.String r3 = "Starting DFU service in foreground"
            r1.logi(r3)
            r31.startForeground()
        L_0x00ff:
            r1.mDeviceAddress = r10
            r1.mDeviceName = r11
            r1.mDisableNotification = r12
            r3 = 0
            r1.mConnectionState = r3
            r1.mError = r3
            android.content.SharedPreferences r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r31)
            java.lang.String r11 = "settings_mbr_size"
            boolean r26 = r3.contains(r11)
            r5 = 4096(0x1000, float:5.74E-42)
            if (r26 == 0) goto L_0x012b
            r26 = r10
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r3 = r3.getString(r11, r10)
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0129 }
            if (r3 >= 0) goto L_0x0136
            goto L_0x0135
        L_0x0129:
            r3 = r5
            goto L_0x0136
        L_0x012b:
            r26 = r10
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE"
            int r3 = r8.getIntExtra(r3, r5)
            if (r3 >= 0) goto L_0x0136
        L_0x0135:
            r3 = 0
        L_0x0136:
            java.lang.String r10 = "DFU service started"
            r11 = 1
            r1.sendLogBroadcast(r11, r10)
            java.io.InputStream r10 = r1.mFirmwareInputStream
            java.io.InputStream r11 = r1.mInitFileInputStream
            if (r10 != 0) goto L_0x0145
            r27 = 1
            goto L_0x0147
        L_0x0145:
            r27 = 0
        L_0x0147:
            r29 = r10
            java.lang.String r5 = "Opening file failed: "
            if (r27 == 0) goto L_0x01b9
            java.lang.String r10 = "Opening file..."
            r30 = r11
            r11 = 1
            r1.sendLogBroadcast(r11, r10)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            if (r13 == 0) goto L_0x015c
            java.io.InputStream r10 = r1.openInputStream((android.net.Uri) r13, (java.lang.String) r4, (int) r3, (int) r6)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x016c
        L_0x015c:
            if (r15 == 0) goto L_0x0163
            java.io.InputStream r10 = r1.openInputStream((java.lang.String) r15, (java.lang.String) r4, (int) r3, (int) r6)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x016c
        L_0x0163:
            if (r9 <= 0) goto L_0x016a
            java.io.InputStream r10 = r1.openInputStream((int) r9, (java.lang.String) r4, (int) r3, (int) r6)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x016c
        L_0x016a:
            r10 = r29
        L_0x016c:
            if (r7 == 0) goto L_0x0177
            android.content.ContentResolver r3 = r31.getContentResolver()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            java.io.InputStream r11 = r3.openInputStream(r7)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x0190
        L_0x0177:
            if (r25 == 0) goto L_0x0181
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r3 = r25
            r11.<init>(r3)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x0190
        L_0x0181:
            if (r23 <= 0) goto L_0x018e
            android.content.res.Resources r3 = r31.getResources()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r7 = r23
            java.io.InputStream r11 = r3.openRawResource(r7)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x0190
        L_0x018e:
            r11 = r30
        L_0x0190:
            int r3 = r10.available()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r7 = 4
            int r3 = r3 % r7
            if (r3 != 0) goto L_0x0199
            goto L_0x01bd
        L_0x0199:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            java.lang.String r3 = "The new firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            throw r2     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
        L_0x01a1:
            r0 = move-exception
            r2 = r0
            goto L_0x05fc
        L_0x01a5:
            r0 = move-exception
            r2 = r0
            goto L_0x056d
        L_0x01a9:
            r0 = move-exception
            r2 = r0
            goto L_0x0592
        L_0x01ad:
            r0 = move-exception
            r2 = r0
            goto L_0x05b7
        L_0x01b1:
            r0 = move-exception
            r2 = r0
            goto L_0x05ce
        L_0x01b5:
            r0 = move-exception
            r2 = r0
            goto L_0x05e5
        L_0x01b9:
            r30 = r11
            r10 = r29
        L_0x01bd:
            boolean r2 = r2.equals(r4)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            if (r2 == 0) goto L_0x0236
            r2 = r10
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r2 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r2     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            if (r6 != 0) goto L_0x01cd
            int r3 = r2.getContentType()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x01d1
        L_0x01cd:
            int r3 = r2.setContentType(r6)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
        L_0x01d1:
            r4 = r3 & 4
            if (r4 <= 0) goto L_0x01e6
            int r4 = r2.applicationImageSize()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r6 = 4
            int r4 = r4 % r6
            if (r4 != 0) goto L_0x01de
            goto L_0x01e6
        L_0x01de:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            java.lang.String r3 = "Application firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            throw r2     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
        L_0x01e6:
            r4 = r3 & 2
            if (r4 <= 0) goto L_0x01fb
            int r4 = r2.bootloaderImageSize()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r6 = 4
            int r4 = r4 % r6
            if (r4 != 0) goto L_0x01f3
            goto L_0x01fb
        L_0x01f3:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            java.lang.String r3 = "Bootloader firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            throw r2     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
        L_0x01fb:
            r4 = r3 & 1
            if (r4 <= 0) goto L_0x0210
            int r4 = r2.softDeviceImageSize()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r6 = 4
            int r4 = r4 % r6
            if (r4 != 0) goto L_0x0208
            goto L_0x0210
        L_0x0208:
            no.nordicsemi.android.dfu.internal.exception.SizeValidationException r2 = new no.nordicsemi.android.dfu.internal.exception.SizeValidationException     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            java.lang.String r3 = "Soft Device firmware is not word-aligned."
            r2.<init>(r3)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            throw r2     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
        L_0x0210:
            r4 = 4
            if (r3 != r4) goto L_0x0223
            byte[] r4 = r2.getApplicationInit()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            if (r4 == 0) goto L_0x0235
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            byte[] r2 = r2.getApplicationInit()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r4.<init>(r2)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            goto L_0x0232
        L_0x0223:
            byte[] r4 = r2.getSystemInit()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            if (r4 == 0) goto L_0x0235
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            byte[] r2 = r2.getSystemInit()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r4.<init>(r2)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
        L_0x0232:
            r6 = r3
            r7 = r4
            goto L_0x0237
        L_0x0235:
            r6 = r3
        L_0x0236:
            r7 = r11
        L_0x0237:
            if (r27 == 0) goto L_0x0249
            int r2 = r10.available()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r10.mark(r2)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            if (r7 == 0) goto L_0x0249
            int r2 = r7.available()     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r7.mark(r2)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
        L_0x0249:
            r1.mFirmwareInputStream = r10     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            r1.mInitFileInputStream = r7     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            java.lang.String r2 = "Firmware file opened successfully"
            r3 = 5
            r1.sendLogBroadcast(r3, r2)     // Catch:{ SecurityException -> 0x01b5, FileNotFoundException -> 0x01b1, SizeValidationException -> 0x01ad, IOException -> 0x01a9, Exception -> 0x01a5 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = new no.nordicsemi.android.dfu.DfuProgressInfo     // Catch:{ all -> 0x01a1 }
            r2.<init>(r1)     // Catch:{ all -> 0x01a1 }
            r1.mProgressInfo = r2     // Catch:{ all -> 0x01a1 }
            boolean r2 = r1.mAborted     // Catch:{ all -> 0x01a1 }
            r9 = -7
            java.lang.String r11 = "Upload aborted"
            if (r2 == 0) goto L_0x0274
            r1.logw(r11)     // Catch:{ all -> 0x01a1 }
            r2 = 15
            r1.sendLogBroadcast(r2, r11)     // Catch:{ all -> 0x01a1 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r1.mProgressInfo     // Catch:{ all -> 0x01a1 }
            r2.setProgress(r9)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x0273
            r1.stopForeground(r12)
        L_0x0273:
            return
        L_0x0274:
            java.lang.String r2 = "Connecting to DFU target..."
            r4 = 1
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x01a1 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r1.mProgressInfo     // Catch:{ all -> 0x01a1 }
            r4 = -1
            r2.setProgress(r4)     // Catch:{ all -> 0x01a1 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01a1 }
            r2 = r26
            android.bluetooth.BluetoothGatt r13 = r1.connect(r2)     // Catch:{ all -> 0x01a1 }
            long r28 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x01a1 }
            if (r13 != 0) goto L_0x02a5
            r15 = r22
            r1.loge(r15)     // Catch:{ all -> 0x01a1 }
            r2 = 20
            r1.sendLogBroadcast(r2, r15)     // Catch:{ all -> 0x01a1 }
            r2 = 4106(0x100a, float:5.754E-42)
            r1.report(r2)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x02a4
            r1.stopForeground(r12)
        L_0x02a4:
            return
        L_0x02a5:
            int r15 = r1.mError     // Catch:{ all -> 0x01a1 }
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT"
            if (r15 <= 0) goto L_0x03b9
            r6 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 & r15
            if (r6 <= 0) goto L_0x0327
            r6 = -32769(0xffffffffffff7fff, float:NaN)
            r6 = r6 & r15
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r9 = r21
            r7.<init>(r9)     // Catch:{ all -> 0x01a1 }
            long r9 = r28 - r4
            r7.append(r9)     // Catch:{ all -> 0x01a1 }
            java.lang.String r9 = " ms"
            r7.append(r9)     // Catch:{ all -> 0x01a1 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01a1 }
            r1.logi(r7)     // Catch:{ all -> 0x01a1 }
            r7 = 133(0x85, float:1.86E-43)
            if (r6 != r7) goto L_0x02f6
            r9 = 25000(0x61a8, double:1.23516E-319)
            long r4 = r4 + r9
            int r4 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x02f6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r5 = r20
            r4.<init>(r5)     // Catch:{ all -> 0x01a1 }
            r4.append(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = " is in range, is advertising and is connectable"
            r4.append(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x01a1 }
            r1.loge(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "Error 133: Connection timeout"
            r4 = 20
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x01a1 }
            goto L_0x0325
        L_0x02f6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r4 = r19
            r2.<init>(r4)     // Catch:{ all -> 0x01a1 }
            r2.append(r6)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01a1 }
            r1.loge(r2)     // Catch:{ all -> 0x01a1 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = "Connection failed (0x%02X): %s"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x01a1 }
            java.lang.String r6 = no.nordicsemi.android.error.GattError.parseConnectionError(r6)     // Catch:{ all -> 0x01a1 }
            r7 = 2
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ all -> 0x01a1 }
            r7 = 0
            r9[r7] = r5     // Catch:{ all -> 0x01a1 }
            r5 = 1
            r9[r5] = r6     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = java.lang.String.format(r2, r4, r9)     // Catch:{ all -> 0x01a1 }
            r4 = 20
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x01a1 }
        L_0x0325:
            r7 = 0
            goto L_0x0358
        L_0x0327:
            r2 = r15 & -16385(0xffffffffffffbfff, float:NaN)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r5 = r18
            r4.<init>(r5)     // Catch:{ all -> 0x01a1 }
            r4.append(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01a1 }
            r1.loge(r4)     // Catch:{ all -> 0x01a1 }
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ all -> 0x01a1 }
            java.lang.String r5 = "Connection failed (0x%02X): %s"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = no.nordicsemi.android.error.GattError.parse(r2)     // Catch:{ all -> 0x01a1 }
            r7 = 2
            java.lang.Object[] r9 = new java.lang.Object[r7]     // Catch:{ all -> 0x01a1 }
            r7 = 0
            r9[r7] = r6     // Catch:{ all -> 0x01a1 }
            r6 = 1
            r9[r6] = r2     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = java.lang.String.format(r4, r5, r9)     // Catch:{ all -> 0x01a1 }
            r4 = 20
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x01a1 }
        L_0x0358:
            int r2 = r8.getIntExtra(r3, r7)     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r5 = r17
            r4.<init>(r5)     // Catch:{ all -> 0x01a1 }
            int r5 = r2 + 1
            r4.append(r5)     // Catch:{ all -> 0x01a1 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01a1 }
            r1.logi(r4)     // Catch:{ all -> 0x01a1 }
            r4 = 2
            if (r2 >= r4) goto L_0x03ae
            java.lang.String r2 = "Retrying..."
            r4 = 15
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x01a1 }
            int r2 = r1.mConnectionState     // Catch:{ all -> 0x01a1 }
            if (r2 == 0) goto L_0x0380
            r1.disconnect(r13)     // Catch:{ all -> 0x01a1 }
        L_0x0380:
            r2 = 1
            r1.refreshDeviceCache(r13, r2)     // Catch:{ all -> 0x01a1 }
            r1.close(r13)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "Restarting the service"
            r1.logi(r2)     // Catch:{ all -> 0x01a1 }
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x01a1 }
            r2.<init>()     // Catch:{ all -> 0x01a1 }
            r4 = 24
            r2.fillIn(r8, r4)     // Catch:{ all -> 0x01a1 }
            r2.putExtra(r3, r5)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x03a5
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01a1 }
            r5 = 26
            if (r3 < r5) goto L_0x03a5
            android.content.ComponentName unused = r1.startForegroundService(r2)     // Catch:{ all -> 0x01a1 }
            goto L_0x03a8
        L_0x03a5:
            r1.startService(r2)     // Catch:{ all -> 0x01a1 }
        L_0x03a8:
            if (r14 == 0) goto L_0x03ad
            r1.stopForeground(r12)
        L_0x03ad:
            return
        L_0x03ae:
            int r2 = r1.mError     // Catch:{ all -> 0x01a1 }
            r1.terminateConnection(r13, r2)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x03b8
            r1.stopForeground(r12)
        L_0x03b8:
            return
        L_0x03b9:
            r4 = 2
            r5 = 26
            int r2 = r1.mConnectionState     // Catch:{ all -> 0x01a1 }
            if (r2 != 0) goto L_0x03d2
            java.lang.String r2 = "Disconnected"
            r3 = 20
            r1.sendLogBroadcast(r3, r2)     // Catch:{ all -> 0x01a1 }
            r15 = 4096(0x1000, float:5.74E-42)
            r1.terminateConnection(r13, r15)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x03d1
            r1.stopForeground(r12)
        L_0x03d1:
            return
        L_0x03d2:
            r15 = 4096(0x1000, float:5.74E-42)
            boolean r2 = r1.mAborted     // Catch:{ all -> 0x01a1 }
            if (r2 == 0) goto L_0x03ef
            r1.logw(r11)     // Catch:{ all -> 0x01a1 }
            r2 = 15
            r1.sendLogBroadcast(r2, r11)     // Catch:{ all -> 0x01a1 }
            r2 = 0
            r1.terminateConnection(r13, r2)     // Catch:{ all -> 0x01a1 }
            no.nordicsemi.android.dfu.DfuProgressInfo r2 = r1.mProgressInfo     // Catch:{ all -> 0x01a1 }
            r2.setProgress(r9)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x03ee
            r1.stopForeground(r12)
        L_0x03ee:
            return
        L_0x03ef:
            java.lang.String r2 = "Services discovered"
            r4 = 5
            r1.sendLogBroadcast(r4, r2)     // Catch:{ all -> 0x01a1 }
            r2 = 0
            r8.putExtra(r3, r2)     // Catch:{ all -> 0x01a1 }
            r2 = 0
            no.nordicsemi.android.dfu.DfuServiceProvider r3 = new no.nordicsemi.android.dfu.DfuServiceProvider     // Catch:{ UploadAbortedException -> 0x054b, DeviceDisconnectedException -> 0x04d8, DfuException -> 0x0475 }
            r3.<init>()     // Catch:{ UploadAbortedException -> 0x054b, DeviceDisconnectedException -> 0x04d8, DfuException -> 0x0475 }
            r1.mDfuServiceImpl = r3     // Catch:{ UploadAbortedException -> 0x054b, DeviceDisconnectedException -> 0x04d8, DfuException -> 0x0475 }
            no.nordicsemi.android.dfu.DfuService r4 = r3.getServiceImpl(r8, r1, r13)     // Catch:{ UploadAbortedException -> 0x054b, DeviceDisconnectedException -> 0x04d8, DfuException -> 0x0475 }
            r1.mDfuServiceImpl = r4     // Catch:{ UploadAbortedException -> 0x046d, DeviceDisconnectedException -> 0x0467, DfuException -> 0x0461, all -> 0x045b }
            if (r4 != 0) goto L_0x043a
            java.lang.String r2 = "DfuBaseService"
            java.lang.String r3 = "DFU Service not found."
            android.util.Log.w(r2, r3)     // Catch:{ UploadAbortedException -> 0x0437, DeviceDisconnectedException -> 0x0432, DfuException -> 0x042c, all -> 0x0427 }
            java.lang.String r2 = "DFU Service not found"
            r3 = 15
            r1.sendLogBroadcast(r3, r2)     // Catch:{ UploadAbortedException -> 0x0437, DeviceDisconnectedException -> 0x0432, DfuException -> 0x042c, all -> 0x0427 }
            r2 = 4102(0x1006, float:5.748E-42)
            r1.terminateConnection(r13, r2)     // Catch:{ UploadAbortedException -> 0x0437, DeviceDisconnectedException -> 0x0432, DfuException -> 0x042c, all -> 0x0427 }
            if (r4 == 0) goto L_0x0421
            r4.release()     // Catch:{ all -> 0x01a1 }
        L_0x0421:
            if (r14 == 0) goto L_0x0426
            r1.stopForeground(r12)
        L_0x0426:
            return
        L_0x0427:
            r0 = move-exception
            r3 = r0
            r2 = r4
            goto L_0x0567
        L_0x042c:
            r0 = move-exception
            r3 = r0
            r2 = r4
            r15 = 2
            goto L_0x0478
        L_0x0432:
            r0 = move-exception
            r3 = r0
            r2 = r4
            goto L_0x04da
        L_0x0437:
            r2 = r4
            goto L_0x054b
        L_0x043a:
            r3 = 15
            r2 = r4
            r9 = r3
            r15 = 2
            r3 = r32
            r9 = r4
            r4 = r13
            r5 = r6
            r6 = r10
            boolean r2 = r2.initialize(r3, r4, r5, r6, r7)     // Catch:{ UploadAbortedException -> 0x046e, DeviceDisconnectedException -> 0x0459, DfuException -> 0x0457, all -> 0x0455 }
            if (r2 == 0) goto L_0x044e
            r9.performDfu(r8)     // Catch:{ UploadAbortedException -> 0x046e, DeviceDisconnectedException -> 0x0459, DfuException -> 0x0457, all -> 0x0455 }
        L_0x044e:
            if (r9 == 0) goto L_0x0561
            r9.release()     // Catch:{ all -> 0x01a1 }
            goto L_0x0561
        L_0x0455:
            r0 = move-exception
            goto L_0x045d
        L_0x0457:
            r0 = move-exception
            goto L_0x0464
        L_0x0459:
            r0 = move-exception
            goto L_0x0469
        L_0x045b:
            r0 = move-exception
            r9 = r4
        L_0x045d:
            r3 = r0
            r2 = r9
            goto L_0x0567
        L_0x0461:
            r0 = move-exception
            r9 = r4
            r15 = 2
        L_0x0464:
            r3 = r0
            r2 = r9
            goto L_0x0478
        L_0x0467:
            r0 = move-exception
            r9 = r4
        L_0x0469:
            r3 = r0
            r2 = r9
            goto L_0x04da
        L_0x046d:
            r9 = r4
        L_0x046e:
            r2 = r9
            goto L_0x054b
        L_0x0471:
            r0 = move-exception
            r3 = r0
            goto L_0x0567
        L_0x0475:
            r0 = move-exception
            r15 = 2
            r3 = r0
        L_0x0478:
            int r4 = r3.getErrorNumber()     // Catch:{ all -> 0x0471 }
            r5 = 32768(0x8000, float:4.5918E-41)
            r5 = r5 & r4
            if (r5 <= 0) goto L_0x04a4
            r5 = -32769(0xffffffffffff7fff, float:NaN)
            r4 = r4 & r5
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x0471 }
            java.lang.String r6 = "Error (0x%02X): %s"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = no.nordicsemi.android.error.GattError.parseConnectionError(r4)     // Catch:{ all -> 0x0471 }
            java.lang.Object[] r8 = new java.lang.Object[r15]     // Catch:{ all -> 0x0471 }
            r9 = 0
            r8[r9] = r7     // Catch:{ all -> 0x0471 }
            r7 = 1
            r8[r7] = r4     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = java.lang.String.format(r5, r6, r8)     // Catch:{ all -> 0x0471 }
            r5 = 20
            r1.sendLogBroadcast(r5, r4)     // Catch:{ all -> 0x0471 }
            goto L_0x04c3
        L_0x04a4:
            r4 = r4 & -16385(0xffffffffffffbfff, float:NaN)
            java.util.Locale r5 = java.util.Locale.US     // Catch:{ all -> 0x0471 }
            java.lang.String r6 = "Error (0x%02X): %s"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = no.nordicsemi.android.error.GattError.parse(r4)     // Catch:{ all -> 0x0471 }
            java.lang.Object[] r8 = new java.lang.Object[r15]     // Catch:{ all -> 0x0471 }
            r9 = 0
            r8[r9] = r7     // Catch:{ all -> 0x0471 }
            r7 = 1
            r8[r7] = r4     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = java.lang.String.format(r5, r6, r8)     // Catch:{ all -> 0x0471 }
            r5 = 20
            r1.sendLogBroadcast(r5, r4)     // Catch:{ all -> 0x0471 }
        L_0x04c3:
            java.lang.String r4 = r3.getMessage()     // Catch:{ all -> 0x0471 }
            r1.loge(r4)     // Catch:{ all -> 0x0471 }
            int r3 = r3.getErrorNumber()     // Catch:{ all -> 0x0471 }
            r1.terminateConnection(r13, r3)     // Catch:{ all -> 0x0471 }
            if (r2 == 0) goto L_0x0561
        L_0x04d3:
            r2.release()     // Catch:{ all -> 0x01a1 }
            goto L_0x0561
        L_0x04d8:
            r0 = move-exception
            r3 = r0
        L_0x04da:
            java.lang.String r4 = "Device has disconnected"
            r5 = 20
            r1.sendLogBroadcast(r5, r4)     // Catch:{ all -> 0x0471 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0471 }
            r1.loge(r3)     // Catch:{ all -> 0x0471 }
            r1.close(r13)     // Catch:{ all -> 0x0471 }
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT"
            r4 = 0
            int r3 = r8.getIntExtra(r3, r4)     // Catch:{ all -> 0x0471 }
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS"
            int r4 = r8.getIntExtra(r5, r4)     // Catch:{ all -> 0x0471 }
            if (r3 >= r4) goto L_0x0543
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0471 }
            r6 = r16
            r5.<init>(r6)     // Catch:{ all -> 0x0471 }
            r6 = 1
            int r3 = r3 + r6
            r5.append(r3)     // Catch:{ all -> 0x0471 }
            java.lang.String r6 = " /"
            r5.append(r6)     // Catch:{ all -> 0x0471 }
            r5.append(r4)     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = ")"
            r5.append(r4)     // Catch:{ all -> 0x0471 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0471 }
            r1.logi(r4)     // Catch:{ all -> 0x0471 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x0471 }
            r4.<init>()     // Catch:{ all -> 0x0471 }
            r5 = 24
            r4.fillIn(r8, r5)     // Catch:{ all -> 0x0471 }
            java.lang.String r5 = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT"
            r4.putExtra(r5, r3)     // Catch:{ all -> 0x0471 }
            if (r14 == 0) goto L_0x0535
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0471 }
            r5 = 26
            if (r3 < r5) goto L_0x0535
            android.content.ComponentName unused = r1.startForegroundService(r4)     // Catch:{ all -> 0x0471 }
            goto L_0x0538
        L_0x0535:
            r1.startService(r4)     // Catch:{ all -> 0x0471 }
        L_0x0538:
            if (r2 == 0) goto L_0x053d
            r2.release()     // Catch:{ all -> 0x01a1 }
        L_0x053d:
            if (r14 == 0) goto L_0x0542
            r1.stopForeground(r12)
        L_0x0542:
            return
        L_0x0543:
            r3 = 4096(0x1000, float:5.74E-42)
            r1.report(r3)     // Catch:{ all -> 0x0471 }
            if (r2 == 0) goto L_0x0561
            goto L_0x04d3
        L_0x054b:
            r1.logw(r11)     // Catch:{ all -> 0x0471 }
            r3 = 15
            r1.sendLogBroadcast(r3, r11)     // Catch:{ all -> 0x0471 }
            r3 = 0
            r1.terminateConnection(r13, r3)     // Catch:{ all -> 0x0471 }
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r1.mProgressInfo     // Catch:{ all -> 0x0471 }
            r4 = -7
            r3.setProgress(r4)     // Catch:{ all -> 0x0471 }
            if (r2 == 0) goto L_0x0561
            goto L_0x04d3
        L_0x0561:
            if (r14 == 0) goto L_0x0566
            r1.stopForeground(r12)
        L_0x0566:
            return
        L_0x0567:
            if (r2 == 0) goto L_0x056c
            r2.release()     // Catch:{ all -> 0x01a1 }
        L_0x056c:
            throw r3     // Catch:{ all -> 0x01a1 }
        L_0x056d:
            java.lang.String r3 = "An exception occurred while opening files. Did you set the firmware file?"
            r1.loge(r3, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r3.<init>(r5)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x01a1 }
            r3.append(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01a1 }
            r3 = 20
            r1.sendLogBroadcast(r3, r2)     // Catch:{ all -> 0x01a1 }
            r2 = 4098(0x1002, float:5.743E-42)
            r1.report(r2)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x0591
            r1.stopForeground(r12)
        L_0x0591:
            return
        L_0x0592:
            java.lang.String r3 = "An exception occurred while calculating file size"
            r1.loge(r3, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a1 }
            r3.<init>(r5)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x01a1 }
            r3.append(r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01a1 }
            r3 = 20
            r1.sendLogBroadcast(r3, r2)     // Catch:{ all -> 0x01a1 }
            r2 = 4098(0x1002, float:5.743E-42)
            r1.report(r2)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x05b6
            r1.stopForeground(r12)
        L_0x05b6:
            return
        L_0x05b7:
            java.lang.String r3 = "Firmware not word-aligned"
            r1.loge(r3, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "Opening file failed: Firmware size must be word-aligned"
            r3 = 20
            r1.sendLogBroadcast(r3, r2)     // Catch:{ all -> 0x01a1 }
            r2 = 4108(0x100c, float:5.757E-42)
            r1.report(r2)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x05cd
            r1.stopForeground(r12)
        L_0x05cd:
            return
        L_0x05ce:
            java.lang.String r3 = "An exception occurred while opening file"
            r1.loge(r3, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "Opening file failed: File not found"
            r3 = 20
            r1.sendLogBroadcast(r3, r2)     // Catch:{ all -> 0x01a1 }
            r2 = 4097(0x1001, float:5.741E-42)
            r1.report(r2)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x05e4
            r1.stopForeground(r12)
        L_0x05e4:
            return
        L_0x05e5:
            java.lang.String r3 = "A security exception occurred while opening file"
            r1.loge(r3, r2)     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "Opening file failed: Permission required"
            r3 = 20
            r1.sendLogBroadcast(r3, r2)     // Catch:{ all -> 0x01a1 }
            r2 = 4097(0x1001, float:5.741E-42)
            r1.report(r2)     // Catch:{ all -> 0x01a1 }
            if (r14 == 0) goto L_0x05fb
            r1.stopForeground(r12)
        L_0x05fb:
            return
        L_0x05fc:
            if (r14 == 0) goto L_0x0601
            r1.stopForeground(r12)
        L_0x0601:
            throw r2
        L_0x0602:
            java.lang.String r2 = "File type or file mime-type not supported"
            r1.logw(r2)
            r3 = 15
            r1.sendLogBroadcast(r3, r2)
            r2 = 4105(0x1009, float:5.752E-42)
            r1.report(r2)
            return
        L_0x0612:
            java.lang.String r2 = "Device Address of firmware location are empty. Hint: use DfuServiceInitiator to start DFU"
            r1.loge(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.onHandleIntent(android.content.Intent):void");
    }

    private InputStream openInputStream(String str, String str2, int i, int i2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        if (MIME_TYPE_ZIP.equals(str2)) {
            return new ArchiveInputStream(fileInputStream, i, i2);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream((InputStream) fileInputStream, i) : fileInputStream;
    }

    private InputStream openInputStream(Uri uri, String str, int i, int i2) throws IOException {
        InputStream inputStream;
        if (uri.toString().startsWith("file:///android_asset/")) {
            inputStream = getAssets().open(uri.getPath().substring(15));
        } else {
            inputStream = getContentResolver().openInputStream(uri);
        }
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(inputStream, i, i2);
        }
        Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, (String) null, (String[]) null, (String) null);
        if (query != null) {
            try {
                if (query.moveToNext() && query.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(inputStream, i);
                    if (query != null) {
                        query.close();
                    }
                    return hexInputStream;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        if (query != null) {
            query.close();
        }
        return inputStream;
        throw th;
    }

    private InputStream openInputStream(int i, String str, int i2, int i3) throws IOException {
        InputStream openRawResource = getResources().openRawResource(i);
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(openRawResource, i2, i3);
        }
        openRawResource.mark(2);
        int read = openRawResource.read();
        openRawResource.reset();
        return read == 58 ? new HexInputStream(openRawResource, i2) : openRawResource;
    }

    /* access modifiers changed from: protected */
    public BluetoothGatt connect(String str) {
        BluetoothGatt bluetoothGatt;
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        if (Build.VERSION.SDK_INT >= 26) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, preferredPhy = LE_1M | LE_2M)");
            bluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2, 3);
        } else {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE)");
            bluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    int i = this.mConnectionState;
                    if ((i == -1 || i == -2) && this.mError == 0 && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return bluetoothGatt;
    }

    /* access modifiers changed from: protected */
    public void terminateConnection(BluetoothGatt bluetoothGatt, int i) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt);
        }
        refreshDeviceCache(bluetoothGatt, false);
        close(bluetoothGatt);
        waitFor(600);
        if (i != 0) {
            report(i);
        }
    }

    /* access modifiers changed from: protected */
    public void disconnect(BluetoothGatt bluetoothGatt) {
        if (this.mConnectionState != 0) {
            sendLogBroadcast(1, "Disconnecting...");
            this.mProgressInfo.setProgress(-5);
            logi("Disconnecting from the device...");
            sendLogBroadcast(0, "gatt.disconnect()");
            bluetoothGatt.disconnect();
            waitUntilDisconnected();
            sendLogBroadcast(5, "Disconnected");
        }
    }

    /* access modifiers changed from: protected */
    public void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    /* access modifiers changed from: protected */
    public void waitFor(long j) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + j + ")");
                this.mLock.wait(j);
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void close(BluetoothGatt bluetoothGatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        sendLogBroadcast(0, "gatt.close()");
        bluetoothGatt.close();
        this.mConnectionState = -5;
    }

    /* access modifiers changed from: protected */
    public void refreshDeviceCache(BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                boolean booleanValue = ((Boolean) bluetoothGatt.getClass().getMethod("refresh", (Class[]) null).invoke(bluetoothGatt, (Object[]) null)).booleanValue();
                logi("Refreshing result: " + booleanValue);
            } catch (Exception e) {
                loge("An exception occurred while refreshing device", e);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    public void updateProgressNotification() {
        String str;
        DfuProgressInfo dfuProgressInfo = this.mProgressInfo;
        int progress = dfuProgressInfo.getProgress();
        if (this.mLastProgress != progress) {
            this.mLastProgress = progress;
            sendProgressBroadcast(dfuProgressInfo);
            if (!this.mDisableNotification) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.mLastNotificationTime >= 250 || -6 == progress || -7 == progress) {
                    this.mLastNotificationTime = elapsedRealtime;
                    String str2 = this.mDeviceAddress;
                    String str3 = this.mDeviceName;
                    if (str3 == null) {
                        str3 = getString(R.string.dfu_unknown_name);
                    }
                    NotificationCompat.Builder onlyAlertOnce = new NotificationCompat.Builder((Context) this, NOTIFICATION_CHANNEL_DFU).setSmallIcon(17301640).setOnlyAlertOnce(true);
                    onlyAlertOnce.setColor(-7829368);
                    switch (progress) {
                        case PROGRESS_ABORTED /*-7*/:
                            onlyAlertOnce.setOngoing(false).setContentTitle(getString(R.string.dfu_status_aborted)).setSmallIcon(17301641).setContentText(getString(R.string.dfu_status_aborted_msg)).setAutoCancel(true);
                            break;
                        case PROGRESS_COMPLETED /*-6*/:
                            onlyAlertOnce.setOngoing(false).setContentTitle(getString(R.string.dfu_status_completed)).setSmallIcon(17301641).setContentText(getString(R.string.dfu_status_completed_msg)).setAutoCancel(true).setColor(-16730086);
                            break;
                        case -5:
                            onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_disconnecting)).setContentText(getString(R.string.dfu_status_disconnecting_msg, new Object[]{str3})).setProgress(100, 0, true);
                            break;
                        case -4:
                            onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_validating)).setContentText(getString(R.string.dfu_status_validating_msg)).setProgress(100, 0, true);
                            break;
                        case -3:
                            onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_switching_to_dfu)).setContentText(getString(R.string.dfu_status_switching_to_dfu_msg)).setProgress(100, 0, true);
                            break;
                        case -2:
                            onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_starting)).setContentText(getString(R.string.dfu_status_starting_msg)).setProgress(100, 0, true);
                            break;
                        case -1:
                            onlyAlertOnce.setOngoing(true).setContentTitle(getString(R.string.dfu_status_connecting)).setContentText(getString(R.string.dfu_status_connecting_msg, new Object[]{str3})).setProgress(100, 0, true);
                            break;
                        default:
                            if (dfuProgressInfo.getTotalParts() == 1) {
                                str = getString(R.string.dfu_status_uploading);
                            } else {
                                str = getString(R.string.dfu_status_uploading_part, new Object[]{Integer.valueOf(dfuProgressInfo.getCurrentPart()), Integer.valueOf(dfuProgressInfo.getTotalParts())});
                            }
                            onlyAlertOnce.setOngoing(true).setContentTitle(str).setContentText(getString(R.string.dfu_status_uploading_msg, new Object[]{str3})).setProgress(100, progress, false);
                            break;
                    }
                    Intent intent = new Intent(this, getNotificationTarget());
                    intent.addFlags(268435456);
                    intent.putExtra(EXTRA_DEVICE_ADDRESS, str2);
                    intent.putExtra(EXTRA_DEVICE_NAME, str3);
                    intent.putExtra(EXTRA_PROGRESS, progress);
                    onlyAlertOnce.setContentIntent(PendingIntent.getActivity(this, 0, intent, 201326592));
                    updateProgressNotification(onlyAlertOnce, progress);
                    NotificationManager notificationManager = (NotificationManager) getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
                    if (notificationManager != null) {
                        notificationManager.notify(NOTIFICATION_ID, onlyAlertOnce.build());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateProgressNotification(NotificationCompat.Builder builder, int i) {
        if (i != -7 && i != -6) {
            Intent intent = new Intent(BROADCAST_ACTION);
            intent.putExtra(EXTRA_ACTION, 2);
            builder.addAction(R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent, 201326592));
        }
    }

    private void report(int i) {
        sendErrorBroadcast(i);
        if (!this.mDisableNotification) {
            String str = this.mDeviceAddress;
            String str2 = this.mDeviceName;
            if (str2 == null) {
                str2 = getString(R.string.dfu_unknown_name);
            }
            NotificationCompat.Builder autoCancel = new NotificationCompat.Builder((Context) this, NOTIFICATION_CHANNEL_DFU).setSmallIcon(17301640).setOnlyAlertOnce(true).setColor(SupportMenu.CATEGORY_MASK).setOngoing(false).setContentTitle(getString(R.string.dfu_status_error)).setSmallIcon(17301641).setContentText(getString(R.string.dfu_status_error_msg)).setAutoCancel(true);
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
            intent.putExtra(EXTRA_DEVICE_NAME, str2);
            intent.putExtra(EXTRA_PROGRESS, i);
            autoCancel.setContentIntent(PendingIntent.getActivity(this, 0, intent, 201326592));
            updateErrorNotification(autoCancel);
            NotificationManager notificationManager = (NotificationManager) getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.notify(NOTIFICATION_ID, autoCancel.build());
            }
        }
    }

    private void startForeground() {
        NotificationCompat.Builder ongoing = new NotificationCompat.Builder((Context) this, NOTIFICATION_CHANNEL_DFU).setSmallIcon(17301640).setContentTitle(getString(R.string.dfu_status_foreground_title)).setContentText(getString(R.string.dfu_status_foreground_content)).setColor(-7829368).setPriority(-1).setOngoing(true);
        Class<? extends Activity> notificationTarget = getNotificationTarget();
        if (notificationTarget != null) {
            Intent intent = new Intent(this, notificationTarget);
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
            intent.putExtra(EXTRA_DEVICE_NAME, this.mDeviceName);
            ongoing.setContentIntent(PendingIntent.getActivity(this, 0, intent, 201326592));
        } else {
            logw("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        updateForegroundNotification(ongoing);
        try {
            startForeground(NOTIFICATION_ID, ongoing.build());
        } catch (SecurityException e) {
            loge("Service cannot be started in foreground", e);
            logi("Starting DFU service in background instead");
        }
    }

    /* access modifiers changed from: protected */
    public DfuDeviceSelector getDeviceSelector() {
        return new DfuDefaultDeviceSelector();
    }

    private void sendProgressBroadcast(DfuProgressInfo dfuProgressInfo) {
        Intent intent = new Intent(BROADCAST_PROGRESS);
        intent.putExtra(EXTRA_DATA, dfuProgressInfo.getProgress());
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        intent.putExtra(EXTRA_PART_CURRENT, dfuProgressInfo.getCurrentPart());
        intent.putExtra(EXTRA_PARTS_TOTAL, dfuProgressInfo.getTotalParts());
        intent.putExtra(EXTRA_SPEED_B_PER_MS, dfuProgressInfo.getSpeed());
        intent.putExtra(EXTRA_AVG_SPEED_B_PER_MS, dfuProgressInfo.getAverageSpeed());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void sendErrorBroadcast(int i) {
        Intent intent = new Intent(BROADCAST_ERROR);
        if ((i & 16384) > 0) {
            intent.putExtra(EXTRA_DATA, i & -16385);
            intent.putExtra(EXTRA_ERROR_TYPE, 2);
        } else if ((32768 & i) > 0) {
            intent.putExtra(EXTRA_DATA, i & -32769);
            intent.putExtra(EXTRA_ERROR_TYPE, 1);
        } else if ((i & 8192) > 0) {
            intent.putExtra(EXTRA_DATA, i & -8193);
            intent.putExtra(EXTRA_ERROR_TYPE, 3);
        } else {
            intent.putExtra(EXTRA_DATA, i);
            intent.putExtra(EXTRA_ERROR_TYPE, 0);
        }
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    /* access modifiers changed from: package-private */
    public void sendLogBroadcast(int i, String str) {
        Intent intent = new Intent(BROADCAST_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, "[DFU] " + str);
        intent.putExtra(EXTRA_LOG_LEVEL, i);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        loge("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    /* access modifiers changed from: private */
    public void loge(String str) {
        Log.e(TAG, str);
    }

    private void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    /* access modifiers changed from: private */
    public void logw(String str) {
        if (DEBUG) {
            Log.w(TAG, str);
        }
    }

    /* access modifiers changed from: private */
    public void logi(String str) {
        if (DEBUG) {
            Log.i(TAG, str);
        }
    }
}
