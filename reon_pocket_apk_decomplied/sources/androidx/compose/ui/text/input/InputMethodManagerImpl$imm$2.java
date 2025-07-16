package androidx.compose.ui.text.input;

import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/inputmethod/InputMethodManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InputMethodManager.android.kt */
final class InputMethodManagerImpl$imm$2 extends Lambda implements Function0<InputMethodManager> {
    final /* synthetic */ InputMethodManagerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InputMethodManagerImpl$imm$2(InputMethodManagerImpl inputMethodManagerImpl) {
        super(0);
        this.this$0 = inputMethodManagerImpl;
    }

    public final InputMethodManager invoke() {
        Object systemService = this.this$0.view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (InputMethodManager) systemService;
    }
}
