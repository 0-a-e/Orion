package jp.co.sony.reonpocket.view;

import android.os.Handler;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"jp/co/sony/reonpocket/view/CustomSlideView$mCircleHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomSlideView.kt */
public final class CustomSlideView$mCircleHandler$1 extends Handler {
    final /* synthetic */ CustomSlideView this$0;

    CustomSlideView$mCircleHandler$1(CustomSlideView customSlideView) {
        this.this$0 = customSlideView;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        super.handleMessage(message);
        if (message.what == 1) {
            Object obj = message.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.this$0.setTop(((Float) obj).floatValue());
        }
    }
}
