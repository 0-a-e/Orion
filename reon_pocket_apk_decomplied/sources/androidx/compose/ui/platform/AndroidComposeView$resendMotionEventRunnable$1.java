package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Ljava/lang/Runnable;", "run", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView$resendMotionEventRunnable$1 implements Runnable {
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$resendMotionEventRunnable$1(AndroidComposeView androidComposeView) {
        this.this$0 = androidComposeView;
    }

    public void run() {
        this.this$0.removeCallbacks(this);
        MotionEvent access$getPreviousMotionEvent$p = this.this$0.previousMotionEvent;
        if (access$getPreviousMotionEvent$p != null) {
            boolean z = false;
            if (access$getPreviousMotionEvent$p.getToolType(0) == 3) {
                z = true;
            }
            int actionMasked = access$getPreviousMotionEvent$p.getActionMasked();
            if (z) {
                if (actionMasked == 10 || actionMasked == 1) {
                    return;
                }
            } else if (actionMasked == 1) {
                return;
            }
            int i = 7;
            if (!(actionMasked == 7 || actionMasked == 9)) {
                i = 2;
            }
            AndroidComposeView androidComposeView = this.this$0;
            androidComposeView.sendSimulatedEvent(access$getPreviousMotionEvent$p, i, androidComposeView.relayoutTime, false);
        }
    }
}
