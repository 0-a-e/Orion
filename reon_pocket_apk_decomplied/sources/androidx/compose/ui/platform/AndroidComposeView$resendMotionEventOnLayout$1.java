package androidx.compose.ui.platform;

import android.os.SystemClock;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$resendMotionEventOnLayout$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$resendMotionEventOnLayout$1(AndroidComposeView androidComposeView) {
        super(0);
        this.this$0 = androidComposeView;
    }

    public final void invoke() {
        MotionEvent access$getPreviousMotionEvent$p = this.this$0.previousMotionEvent;
        if (access$getPreviousMotionEvent$p != null) {
            int actionMasked = access$getPreviousMotionEvent$p.getActionMasked();
            if (actionMasked == 7 || actionMasked == 9) {
                this.this$0.relayoutTime = SystemClock.uptimeMillis();
                AndroidComposeView androidComposeView = this.this$0;
                androidComposeView.post(androidComposeView.resendMotionEventRunnable);
            }
        }
    }
}
