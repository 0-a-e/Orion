package jp.co.sony.reonpocket.data.interactor;

import java.util.ArrayList;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.ConnectCallbackListener;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000eH\u0016¨\u0006\u000f"}, d2 = {"jp/co/sony/reonpocket/data/interactor/BleInteractor$connect$1", "Ljp/co/sony/reon/android/ble/listener/ConnectCallbackListener;", "onConnectFailed", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onConnected", "aMacAddress", "", "aDeviceName", "onConnectionSuspended", "onServicesDiscovered", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleInteractor.kt */
public final class BleInteractor$connect$1 implements ConnectCallbackListener {
    final /* synthetic */ BleInteractor this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleInteractor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant[] r0 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.DFU_MODE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.PERMISSION_MISS_LOCATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.PERMISSION_MISS_BLUETOOTH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reon.android.ble.constant.ReasonCodeConstant r1 = jp.co.sony.reon.android.ble.constant.ReasonCodeConstant.PERMISSION_MISS_UNEXPECTED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.data.interactor.BleInteractor$connect$1.WhenMappings.<clinit>():void");
        }
    }

    BleInteractor$connect$1(BleInteractor bleInteractor) {
        this.this$0 = bleInteractor;
    }

    public void onConnected(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "aMacAddress");
        BleInteractor.Companion.setMIsConnected(true);
        BleInteractor.Companion.setMMacAddress(str);
        BleInteractor.Companion.setMDeviceName(str2);
        BleInteractor.Companion.setMConnectionStatus(BleConnStatusCode.CONNECTED);
        Function2<BleConnStatusCode, ArrayList<String>, Unit> mConnectCallbackListener = BleInteractor.Companion.getMConnectCallbackListener();
        if (mConnectCallbackListener != null) {
            mConnectCallbackListener.invoke(BleConnStatusCode.CONNECTED, null);
        }
    }

    public void onConnectFailed(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String name = reasonCodeConstant.name();
        debugLogUtil.e("connect failed:" + name);
        BleInteractor.Companion.setMIsConnected(false);
        int i = WhenMappings.$EnumSwitchMapping$0[reasonCodeConstant.ordinal()];
        if (i == 1) {
            BleInteractor.Companion.setMConnectionStatus(BleConnStatusCode.DFU_MODE);
            Function2<BleConnStatusCode, ArrayList<String>, Unit> mConnectCallbackListener = BleInteractor.Companion.getMConnectCallbackListener();
            if (mConnectCallbackListener != null) {
                mConnectCallbackListener.invoke(BleConnStatusCode.DFU_MODE, null);
            }
        } else if (i == 2 || i == 3 || i == 4) {
            BleConnStatusCode access$handlerBleConnStatusPermissionCode = this.this$0.handlerBleConnStatusPermissionCode(reasonCodeConstant);
            BleInteractor.Companion.setMConnectionStatus(access$handlerBleConnStatusPermissionCode);
            Function2<BleConnStatusCode, ArrayList<String>, Unit> mConnectCallbackListener2 = BleInteractor.Companion.getMConnectCallbackListener();
            if (mConnectCallbackListener2 != null) {
                mConnectCallbackListener2.invoke(access$handlerBleConnStatusPermissionCode, null);
            }
        } else {
            BleInteractor.Companion.setMConnectionStatus(BleConnStatusCode.CONNECT_FAILED);
            Function2<BleConnStatusCode, ArrayList<String>, Unit> mConnectCallbackListener3 = BleInteractor.Companion.getMConnectCallbackListener();
            if (mConnectCallbackListener3 != null) {
                mConnectCallbackListener3.invoke(BleConnStatusCode.CONNECT_FAILED, null);
            }
        }
    }

    public void onConnectionSuspended(ReasonCodeConstant reasonCodeConstant) {
        Intrinsics.checkNotNullParameter(reasonCodeConstant, "aReason");
        BleInteractor.Companion.setMIsConnected(false);
        if (!BleInteractor.Companion.getHasRequestDfu() || reasonCodeConstant != ReasonCodeConstant.CONNECT_EXCEPTION) {
            BleInteractor.Companion.setDFUMode(false);
        } else {
            BleInteractor.Companion.setHasRequestDfu(false);
            BleInteractor.Companion.setDFUMode(true);
        }
        BleInteractor.Companion.setMConnectionStatus(BleConnStatusCode.CONNECT_SUSPENDED);
        Function2<BleConnStatusCode, ArrayList<String>, Unit> mConnectCallbackListener = BleInteractor.Companion.getMConnectCallbackListener();
        if (mConnectCallbackListener != null) {
            mConnectCallbackListener.invoke(BleConnStatusCode.CONNECT_SUSPENDED, null);
        }
    }

    public void onServicesDiscovered(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "aServiceUuidList");
        this.this$0.checkDfuMode(arrayList);
        Function2<BleConnStatusCode, ArrayList<String>, Unit> mConnectCallbackListener = BleInteractor.Companion.getMConnectCallbackListener();
        if (mConnectCallbackListener != null) {
            mConnectCallbackListener.invoke(BleConnStatusCode.SERVICE_DISCOVERED, arrayList);
        }
    }
}
