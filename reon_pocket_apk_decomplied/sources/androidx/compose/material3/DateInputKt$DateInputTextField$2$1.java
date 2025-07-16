package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$2$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ MutableState<String> $errorText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputTextField$2$1(MutableState<String> mutableState) {
        super(1);
        this.$errorText = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!StringsKt.isBlank(this.$errorText.getValue())) {
            SemanticsPropertiesKt.error(semanticsPropertyReceiver, this.$errorText.getValue());
        }
    }
}
