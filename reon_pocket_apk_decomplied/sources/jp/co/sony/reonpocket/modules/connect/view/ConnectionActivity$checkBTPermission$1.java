package jp.co.sony.reonpocket.modules.connect.view;

import jp.co.sony.reonpocket.connection.log.logcat.LogCatLoggingService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionActivity.kt */
final class ConnectionActivity$checkBTPermission$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConnectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionActivity$checkBTPermission$1(ConnectionActivity connectionActivity) {
        super(0);
        this.this$0 = connectionActivity;
    }

    public final void invoke() {
        LogCatLoggingService.Companion.startService(this.this$0);
        this.this$0.scanBoundedDevice();
    }
}
