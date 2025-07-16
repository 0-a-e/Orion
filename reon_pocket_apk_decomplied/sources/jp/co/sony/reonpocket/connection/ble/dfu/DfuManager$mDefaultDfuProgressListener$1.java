package jp.co.sony.reonpocket.connection.ble.dfu;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J8\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0016¨\u0006\u0018"}, d2 = {"jp/co/sony/reonpocket/connection/ble/dfu/DfuManager$mDefaultDfuProgressListener$1", "Lno/nordicsemi/android/dfu/DfuProgressListenerAdapter;", "onDeviceConnecting", "", "deviceAddress", "", "onDeviceDisconnecting", "onDfuAborted", "onDfuCompleted", "onDfuProcessStarting", "onEnablingDfuMode", "onError", "error", "", "errorType", "message", "onFirmwareValidating", "onProgressChanged", "percent", "speed", "", "avgSpeed", "currentPart", "partsTotal", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DfuManager.kt */
public final class DfuManager$mDefaultDfuProgressListener$1 extends DfuProgressListenerAdapter {
    DfuManager$mDefaultDfuProgressListener$1() {
    }

    public void onDeviceConnecting(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onDeviceConnecting(str);
        }
    }

    public void onDfuProcessStarting(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onDfuProcessStarting(str);
        }
    }

    public void onEnablingDfuMode(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onEnablingDfuMode(str);
        }
    }

    public void onFirmwareValidating(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onFirmwareValidating(str);
        }
    }

    public void onDeviceDisconnecting(String str) {
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onDeviceDisconnecting(str);
        }
    }

    public void onDfuCompleted(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onDfuCompleted(str);
        }
    }

    public void onDfuAborted(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onDfuAborted(str);
        }
    }

    public void onProgressChanged(String str, int i, float f, float f2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onProgressChanged(str, i, f, f2, i2, i3);
        }
    }

    public void onError(String str, int i, int i2, String str2) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        DfuProgressListener access$getMDfuProgressListener$p = DfuManager.mDfuProgressListener;
        if (access$getMDfuProgressListener$p != null) {
            access$getMDfuProgressListener$p.onError(str, i, i2, str2);
        }
    }
}
