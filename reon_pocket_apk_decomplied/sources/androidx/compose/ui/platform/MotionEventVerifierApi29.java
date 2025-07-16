package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/MotionEventVerifierApi29;", "", "()V", "isValidMotionEvent", "", "event", "Landroid/view/MotionEvent;", "index", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class MotionEventVerifierApi29 {
    public static final MotionEventVerifierApi29 INSTANCE = new MotionEventVerifierApi29();

    private MotionEventVerifierApi29() {
    }

    public final boolean isValidMotionEvent(MotionEvent motionEvent, int i) {
        float m = motionEvent.getRawX(i);
        if (!Float.isInfinite(m) && !Float.isNaN(m)) {
            float m$1 = motionEvent.getRawY(i);
            return !Float.isInfinite(m$1) && !Float.isNaN(m$1);
        }
    }
}
