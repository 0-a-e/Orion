package jp.co.sony.reonpocket.modules.pairing.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivity;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.PermissionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"jp/co/sony/reonpocket/modules/pairing/view/PairingActivity$mLocationProviderChangedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingActivity.kt */
public final class PairingActivity$mLocationProviderChangedReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ PairingActivity this$0;

    PairingActivity$mLocationProviderChangedReceiver$1(PairingActivity pairingActivity) {
        this.this$0 = pairingActivity;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean isLocationEnabled = PermissionUtil.INSTANCE.isLocationEnabled(context);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("location enabled:" + isLocationEnabled);
        if (!isLocationEnabled) {
            this.this$0.changeNextBtnState(false);
            this.this$0.changeHelpGuideBtnState(false);
            PairingActivity.PairingViewOutput access$getMOutput$p = this.this$0.mOutput;
            if (access$getMOutput$p != null) {
                access$getMOutput$p.disconnect();
            }
        }
        this.this$0.checkBTPermission();
    }
}
