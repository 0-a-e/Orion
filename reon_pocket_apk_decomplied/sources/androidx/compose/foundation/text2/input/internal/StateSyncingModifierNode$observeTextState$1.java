package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: StateSyncingModifier.kt */
final class StateSyncingModifierNode$observeTextState$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<TextFieldCharSequence> $text;
    final /* synthetic */ StateSyncingModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StateSyncingModifierNode$observeTextState$1(Ref.ObjectRef<TextFieldCharSequence> objectRef, StateSyncingModifierNode stateSyncingModifierNode) {
        super(0);
        this.$text = objectRef;
        this.this$0 = stateSyncingModifierNode;
    }

    public final void invoke() {
        this.$text.element = this.this$0.state.getText();
    }
}
