package jp.co.sony.reonpocket.connection.ble.dfu;

import android.app.Activity;
import kotlin.Metadata;
import no.nordicsemi.android.dfu.DfuBaseService;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/connection/ble/dfu/DfuService;", "Lno/nordicsemi/android/dfu/DfuBaseService;", "()V", "getNotificationTarget", "Ljava/lang/Class;", "Landroid/app/Activity;", "isDebug", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DfuService.kt */
public final class DfuService extends DfuBaseService {
    public static final int $stable = 0;

    /* access modifiers changed from: protected */
    public Class<? extends Activity> getNotificationTarget() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isDebug() {
        return false;
    }
}
