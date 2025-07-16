package androidx.compose.material3;

import androidx.compose.foundation.text.KeyboardActionScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/KeyboardActionScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SearchBar.android.kt */
final class SearchBar_androidKt$SearchBarInputField$4$1 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    final /* synthetic */ Function1<String, Unit> $onSearch;
    final /* synthetic */ String $query;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBarInputField$4$1(Function1<? super String, Unit> function1, String str) {
        super(1);
        this.$onSearch = function1;
        this.$query = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        this.$onSearch.invoke(this.$query);
    }
}
