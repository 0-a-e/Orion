package androidx.compose.material3;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ FocusRequester $focusRequester;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1(boolean z, FocusRequester focusRequester) {
        super(0);
        this.$expanded = z;
        this.$focusRequester = focusRequester;
    }

    public final void invoke() {
        if (this.$expanded) {
            this.$focusRequester.requestFocus();
        }
    }
}
