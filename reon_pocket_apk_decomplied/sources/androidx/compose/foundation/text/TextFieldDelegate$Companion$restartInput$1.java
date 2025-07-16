package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroidx/compose/ui/text/input/EditCommand;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDelegate.kt */
final class TextFieldDelegate$Companion$restartInput$1 extends Lambda implements Function1<List<? extends EditCommand>, Unit> {
    final /* synthetic */ EditProcessor $editProcessor;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ Ref.ObjectRef<TextInputSession> $session;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDelegate$Companion$restartInput$1(EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, Ref.ObjectRef<TextInputSession> objectRef) {
        super(1);
        this.$editProcessor = editProcessor;
        this.$onValueChange = function1;
        this.$session = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends EditCommand>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends EditCommand> list) {
        TextFieldDelegate.Companion.onEditCommand$foundation_release(list, this.$editProcessor, this.$onValueChange, (TextInputSession) this.$session.element);
    }
}
