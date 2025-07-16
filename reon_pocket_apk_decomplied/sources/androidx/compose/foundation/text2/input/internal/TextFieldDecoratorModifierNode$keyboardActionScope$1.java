package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"androidx/compose/foundation/text2/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/KeyboardActionScope;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
public final class TextFieldDecoratorModifierNode$keyboardActionScope$1 implements KeyboardActionScope {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    TextFieldDecoratorModifierNode$keyboardActionScope$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        this.this$0 = textFieldDecoratorModifierNode;
    }

    private final FocusManager getFocusManager() {
        return (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalFocusManager());
    }

    /* renamed from: defaultKeyboardAction-KlQnJC8  reason: not valid java name */
    public void m1398defaultKeyboardActionKlQnJC8(int i) {
        if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6240getNexteUduSuo())) {
            getFocusManager().m3493moveFocus3ESFkO8(FocusDirection.Companion.m3489getNextdhqQ8s());
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6242getPreviouseUduSuo())) {
            getFocusManager().m3493moveFocus3ESFkO8(FocusDirection.Companion.m3490getPreviousdhqQ8s());
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6238getDoneeUduSuo())) {
            this.this$0.requireKeyboardController().hide();
        } else {
            boolean z = true;
            if (!(ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6239getGoeUduSuo()) ? true : ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6243getSearcheUduSuo()) ? true : ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6244getSendeUduSuo()))) {
                z = ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6237getDefaulteUduSuo());
            }
            if (!z) {
                ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6241getNoneeUduSuo());
            }
        }
    }
}
