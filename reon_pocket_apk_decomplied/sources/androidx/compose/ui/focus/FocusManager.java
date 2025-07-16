package androidx.compose.ui.focus;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nø\u0001\u0001\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/focus/FocusManager;", "", "clearFocus", "", "force", "", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusManager.kt */
public interface FocusManager {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusManager.kt */
    public static final class DefaultImpls {
    }

    void clearFocus(boolean z);

    /* renamed from: moveFocus-3ESFkO8  reason: not valid java name */
    boolean m3493moveFocus3ESFkO8(int i);

    /* renamed from: androidx.compose.ui.focus.FocusManager$-CC  reason: invalid class name */
    /* compiled from: FocusManager.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void clearFocus$default(FocusManager focusManager, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                focusManager.clearFocus(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
        }
    }
}
