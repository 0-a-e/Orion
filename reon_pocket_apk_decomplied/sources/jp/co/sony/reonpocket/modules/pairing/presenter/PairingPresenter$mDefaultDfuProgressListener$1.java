package jp.co.sony.reonpocket.modules.pairing.presenter;

import jp.co.sony.reonpocket.modules.pairing.presenter.PairingPresenter;
import jp.co.sony.reonpocket.modules.pairing.view.PairingViewInput;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0016¨\u0006\u001b"}, d2 = {"jp/co/sony/reonpocket/modules/pairing/presenter/PairingPresenter$mDefaultDfuProgressListener$1", "Lno/nordicsemi/android/dfu/DfuProgressListenerAdapter;", "onDeviceConnected", "", "deviceAddress", "", "onDeviceConnecting", "onDeviceDisconnected", "onDeviceDisconnecting", "onDfuAborted", "onDfuCompleted", "onDfuProcessStarted", "onDfuProcessStarting", "onEnablingDfuMode", "onError", "error", "", "errorType", "message", "onFirmwareValidating", "onProgressChanged", "percent", "speed", "", "avgSpeed", "currentPart", "partsTotal", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingPresenter.kt */
public final class PairingPresenter$mDefaultDfuProgressListener$1 extends DfuProgressListenerAdapter {
    final /* synthetic */ PairingPresenter this$0;

    public void onDeviceConnected(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
    }

    public void onDeviceConnecting(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
    }

    public void onDeviceDisconnected(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
    }

    public void onDfuProcessStarted(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
    }

    public void onEnablingDfuMode(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
    }

    public void onFirmwareValidating(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
    }

    PairingPresenter$mDefaultDfuProgressListener$1(PairingPresenter pairingPresenter) {
        this.this$0 = pairingPresenter;
    }

    public void onProgressChanged(String str, int i, float f, float f2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        PairingViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.updateDfuProgress(i);
        }
        if (i == 100) {
            this.this$0.mIsDfuSuccess = true;
            this.this$0.setDfuState(PairingPresenter.DfuState.DFU_FINISHED);
        }
    }

    public void onDeviceDisconnecting(String str) {
        PairingPresenter.DfuState dfuState;
        PairingViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showDfuDisconnect();
        }
        PairingPresenter pairingPresenter = this.this$0;
        if (pairingPresenter.mIsDfuSuccess) {
            dfuState = PairingPresenter.DfuState.DFU_FINISHED;
        } else {
            dfuState = PairingPresenter.DfuState.DFU_FAILED;
        }
        pairingPresenter.setDfuState(dfuState);
    }

    public void onDfuProcessStarting(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        PairingViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showDfuStarting();
        }
        this.this$0.setDfuState(PairingPresenter.DfuState.DFU_GOING);
    }

    public void onDfuAborted(String str) {
        PairingPresenter.DfuState dfuState;
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        this.this$0.mIsDfuSuccess = false;
        PairingPresenter pairingPresenter = this.this$0;
        if (pairingPresenter.mIsDfuSuccess) {
            dfuState = PairingPresenter.DfuState.DFU_FINISHED;
        } else {
            dfuState = PairingPresenter.DfuState.DFU_FAILED;
        }
        pairingPresenter.setDfuState(dfuState);
    }

    public void onDfuCompleted(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        PairingViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showDfuComplete();
        }
        this.this$0.mIsDfuSuccess = true;
        this.this$0.setDfuState(PairingPresenter.DfuState.DFU_FINISHED);
    }

    public void onError(String str, int i, int i2, String str2) {
        Intrinsics.checkNotNullParameter(str, "deviceAddress");
        this.this$0.mIsDfuSuccess = false;
        if (str2 != null) {
            DebugLogUtil.INSTANCE.e(str2);
        }
        this.this$0.setDfuState(PairingPresenter.DfuState.DFU_FAILED);
        this.this$0.disconnect();
    }
}
