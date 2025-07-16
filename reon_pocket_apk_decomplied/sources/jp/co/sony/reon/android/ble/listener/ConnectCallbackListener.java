package jp.co.sony.reon.android.ble.listener;

import java.util.ArrayList;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000eH&¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reon/android/ble/listener/ConnectCallbackListener;", "", "onConnectFailed", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onConnected", "aMacAddress", "", "aDeviceName", "onConnectionSuspended", "onServicesDiscovered", "aServiceUuidList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectCallbackListener.kt */
public interface ConnectCallbackListener {
    void onConnectFailed(ReasonCodeConstant reasonCodeConstant);

    void onConnected(String str, String str2);

    void onConnectionSuspended(ReasonCodeConstant reasonCodeConstant);

    void onServicesDiscovered(ArrayList<String> arrayList);
}
