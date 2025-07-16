package jp.co.sony.reonpocket.modules.connect.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"jp/co/sony/reonpocket/modules/connect/view/ConnectionActivity$mBluetoothStateBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionActivity.kt */
public final class ConnectionActivity$mBluetoothStateBroadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ ConnectionActivity this$0;

    ConnectionActivity$mBluetoothStateBroadcastReceiver$1(ConnectionActivity connectionActivity) {
        this.this$0 = connectionActivity;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("bluetooth state:" + intExtra + ", previousState:" + intExtra2);
        if (intExtra != 10) {
            if (intExtra == 12 && intExtra2 != 12) {
                this.this$0.checkBTPermission();
            }
        } else if (intExtra2 != 10) {
            this.this$0.checkBTPermission();
        }
    }
}
