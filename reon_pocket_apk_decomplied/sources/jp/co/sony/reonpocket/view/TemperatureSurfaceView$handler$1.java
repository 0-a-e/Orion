package jp.co.sony.reonpocket.view;

import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/view/TemperatureSurfaceView$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TemperatureSurfaceView.kt */
public final class TemperatureSurfaceView$handler$1 extends Handler {
    final /* synthetic */ TemperatureSurfaceView this$0;

    TemperatureSurfaceView$handler$1(TemperatureSurfaceView temperatureSurfaceView) {
        this.this$0 = temperatureSurfaceView;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        super.handleMessage(message);
        if (message.what == 1) {
            if (this.this$0.rippleIndex >= this.this$0.maxRippleIndex - 1) {
                this.this$0.rippleIndex = 0;
            } else {
                TemperatureSurfaceView temperatureSurfaceView = this.this$0;
                temperatureSurfaceView.rippleIndex = temperatureSurfaceView.rippleIndex + 1;
            }
            this.this$0.postInvalidate();
        }
    }
}
