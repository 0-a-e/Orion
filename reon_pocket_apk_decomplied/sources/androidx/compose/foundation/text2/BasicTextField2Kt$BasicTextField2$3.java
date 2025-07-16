package androidx.compose.foundation.text2;

import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
final class BasicTextField2Kt$BasicTextField2$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ClipboardManager $currentClipboardManager;
    final /* synthetic */ HapticFeedback $currentHapticFeedback;
    final /* synthetic */ TextToolbar $currentTextToolbar;
    final /* synthetic */ Density $density;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldSelectionState $textFieldSelectionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextField2Kt$BasicTextField2$3(TextFieldSelectionState textFieldSelectionState, HapticFeedback hapticFeedback, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean z, boolean z2) {
        super(0);
        this.$textFieldSelectionState = textFieldSelectionState;
        this.$currentHapticFeedback = hapticFeedback;
        this.$currentClipboardManager = clipboardManager;
        this.$currentTextToolbar = textToolbar;
        this.$density = density;
        this.$enabled = z;
        this.$readOnly = z2;
    }

    public final void invoke() {
        this.$textFieldSelectionState.update(this.$currentHapticFeedback, this.$currentClipboardManager, this.$currentTextToolbar, this.$density, this.$enabled, this.$readOnly);
    }
}
