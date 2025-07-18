package androidx.compose.ui.platform;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/ClipboardManager;", "", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "hasText", "", "setText", "", "annotatedString", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClipboardManager.kt */
public interface ClipboardManager {
    AnnotatedString getText();

    boolean hasText();

    void setText(AnnotatedString annotatedString);

    /* renamed from: androidx.compose.ui.platform.ClipboardManager$-CC  reason: invalid class name */
    /* compiled from: ClipboardManager.kt */
    public final /* synthetic */ class CC {
        public static boolean $default$hasText(ClipboardManager _this) {
            AnnotatedString text = _this.getText();
            return text != null && text.length() > 0;
        }
    }
}
