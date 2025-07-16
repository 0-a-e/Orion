package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$pointerIconService$1", "Landroidx/compose/ui/input/pointer/PointerIconService;", "currentIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getIcon", "setIcon", "", "value", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView$pointerIconService$1 implements PointerIconService {
    private PointerIcon currentIcon = PointerIcon.Companion.getDefault();
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$pointerIconService$1(AndroidComposeView androidComposeView) {
        this.this$0 = androidComposeView;
    }

    public PointerIcon getIcon() {
        return this.currentIcon;
    }

    public void setIcon(PointerIcon pointerIcon) {
        if (pointerIcon == null) {
            pointerIcon = PointerIcon.Companion.getDefault();
        }
        this.currentIcon = pointerIcon;
        if (Build.VERSION.SDK_INT >= 24) {
            AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this.this$0, this.currentIcon);
        }
    }
}
