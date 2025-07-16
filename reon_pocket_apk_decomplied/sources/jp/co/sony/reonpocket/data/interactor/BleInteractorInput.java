package jp.co.sony.reonpocket.data.interactor;

import android.content.Context;
import java.util.ArrayList;
import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallback;
import jp.co.sony.reon.android.ble.listener.TagScanRegisterCallback;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import no.nordicsemi.android.dfu.DfuProgressListener;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u0007H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JY\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u001eJV\u0010\u001f\u001a\u00020\u00032L\u0010 \u001aH\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012'\u0012%\u0012\u0004\u0012\u00020\u0007\u0018\u00010&j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`'¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u0003\u0018\u00010!H&J\u001e\u0010)\u001a\u00020\u00032\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0003\u0018\u00010*H&J\u001e\u0010,\u001a\u00020\u00032\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0003\u0018\u00010*H&J\b\u0010-\u001a\u00020\u0003H&J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020/H&J'\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bH&¢\u0006\u0002\u00102J \u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00072\u0006\u0010 \u001a\u000205H&J\"\u00106\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u0006\u00107\u001a\u000208H&J\"\u00109\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0010H&J\"\u0010;\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u0006\u00107\u001a\u000208H&¨\u0006<"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/BleInteractorInput;", "Ljp/co/sony/reonpocket/data/interactor/BaseInteractorInput;", "connect", "", "aContext", "Landroid/content/Context;", "aMacAddress", "", "disconnect", "disconnectTag", "executeDfu", "aDeviceName", "aDfuProgressListener", "Lno/nordicsemi/android/dfu/DfuProgressListener;", "executeTagDfu", "getIsTagConnected", "", "onCreate", "onDestroy", "onPause", "onResume", "read", "aCharacteristicUuid", "aServiceUuid", "registerDfuProgressListener", "scanConnect", "aDeviceFilterNameArray", "", "aDfuDeviceFilterNameArray", "aOwnerId", "(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setConnectCallbackListener", "callback", "Lkotlin/Function2;", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "Lkotlin/ParameterName;", "name", "aConnStatusCode", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "aServiceUuidList", "setDataReceivedCallbackListener", "Lkotlin/Function1;", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "setTagDataReceivedCallbackListener", "tagDFUProcessAbort", "tagScan", "Ljp/co/sony/reon/android/ble/listener/TagScanRegisterCallback;", "tagScanConnect", "aDfuTagFilterNameArray", "(Landroid/content/Context;[Ljava/lang/String;)V", "tagScanNoReceiving", "aAddress", "Ljp/co/sony/reon/android/ble/listener/TagScanNoReceivingCallback;", "tagWrite", "aData", "", "toggleNotification", "aIsEnable", "write", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleInteractorInput.kt */
public interface BleInteractorInput extends BaseInteractorInput {
    void connect(Context context, String str);

    void disconnect();

    void disconnectTag();

    void executeDfu(Context context, String str, DfuProgressListener dfuProgressListener);

    void executeTagDfu(Context context, String str, DfuProgressListener dfuProgressListener);

    boolean getIsTagConnected();

    void onCreate(Context context);

    void onDestroy(Context context);

    void onPause();

    void onResume();

    void read(String str, String str2);

    void registerDfuProgressListener(Context context);

    void scanConnect(Context context, String str, String[] strArr, String[] strArr2, String str2, String str3);

    void setConnectCallbackListener(Function2<? super BleConnStatusCode, ? super ArrayList<String>, Unit> function2);

    void setDataReceivedCallbackListener(Function1<? super BleDataEntity, Unit> function1);

    void setTagDataReceivedCallbackListener(Function1<? super BleDataEntity, Unit> function1);

    void tagDFUProcessAbort();

    void tagScan(Context context, TagScanRegisterCallback tagScanRegisterCallback);

    void tagScanConnect(Context context, String[] strArr);

    void tagScanNoReceiving(Context context, String str, TagScanNoReceivingCallback tagScanNoReceivingCallback);

    void tagWrite(String str, String str2, byte[] bArr);

    void toggleNotification(String str, String str2, boolean z);

    void write(String str, String str2, byte[] bArr);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleInteractorInput.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void scanConnect$default(BleInteractorInput bleInteractorInput, Context context, String str, String[] strArr, String[] strArr2, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                bleInteractorInput.scanConnect(context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : strArr, (i & 8) != 0 ? null : strArr2, (i & 16) != 0 ? null : str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scanConnect");
        }

        public static /* synthetic */ void toggleNotification$default(BleInteractorInput bleInteractorInput, String str, String str2, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = GattProfileConstant.SERVICE_DEVICE_CONTROL;
                }
                bleInteractorInput.toggleNotification(str, str2, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleNotification");
        }

        public static /* synthetic */ void read$default(BleInteractorInput bleInteractorInput, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = GattProfileConstant.SERVICE_DEVICE_CONTROL;
                }
                bleInteractorInput.read(str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: read");
        }

        public static /* synthetic */ void write$default(BleInteractorInput bleInteractorInput, String str, String str2, byte[] bArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = GattProfileConstant.SERVICE_DEVICE_CONTROL;
                }
                bleInteractorInput.write(str, str2, bArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }

        public static /* synthetic */ void tagWrite$default(BleInteractorInput bleInteractorInput, String str, String str2, byte[] bArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = GattProfileConstant.SERVICE_DEVICE_CONTROL;
                }
                bleInteractorInput.tagWrite(str, str2, bArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tagWrite");
        }

        public static /* synthetic */ void tagScanConnect$default(BleInteractorInput bleInteractorInput, Context context, String[] strArr, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    strArr = null;
                }
                bleInteractorInput.tagScanConnect(context, strArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tagScanConnect");
        }
    }
}
