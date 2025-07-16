package androidx.compose.material3;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarInputField$3$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $active;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ String $searchSemantics;
    final /* synthetic */ String $suggestionsAvailableSemantics;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBarInputField$3$1(String str, boolean z, String str2, FocusRequester focusRequester) {
        super(1);
        this.$searchSemantics = str;
        this.$active = z;
        this.$suggestionsAvailableSemantics = str2;
        this.$focusRequester = focusRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.$searchSemantics);
        if (this.$active) {
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, this.$suggestionsAvailableSemantics);
        }
        final FocusRequester focusRequester = this.$focusRequester;
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                focusRequester.requestFocus();
                return true;
            }
        }, 1, (Object) null);
    }
}
