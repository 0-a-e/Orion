package androidx.compose.material3;

import androidx.compose.ui.focus.FocusState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/focus/FocusState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarInputField$2$1 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $onActiveChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBarInputField$2$1(Function1<? super Boolean, Unit> function1) {
        super(1);
        this.$onActiveChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusState focusState) {
        if (focusState.isFocused()) {
            this.$onActiveChange.invoke(true);
        }
    }
}
