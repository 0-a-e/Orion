package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "emit", "(Landroidx/compose/foundation/text2/input/TextFieldCharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$observeTextChanges$4<T> implements FlowCollector {
    final /* synthetic */ TextFieldSelectionState this$0;

    TextFieldSelectionState$observeTextChanges$4(TextFieldSelectionState textFieldSelectionState) {
        this.this$0 = textFieldSelectionState;
    }

    public final Object emit(TextFieldCharSequence textFieldCharSequence, Continuation<? super Unit> continuation) {
        this.this$0.setShowCursorHandle(false);
        this.this$0.updateTextToolbarState(TextToolbarState.None);
        return Unit.INSTANCE;
    }
}
