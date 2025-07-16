package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "(Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "runAction", "runAction-KlQnJC8", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyboardActionRunner.kt */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public static final int $stable = 8;
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;
    private final SoftwareKeyboardController keyboardController;

    public KeyboardActionRunner(SoftwareKeyboardController softwareKeyboardController) {
        this.keyboardController = softwareKeyboardController;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions2 = this.keyboardActions;
        if (keyboardActions2 != null) {
            return keyboardActions2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions2) {
        this.keyboardActions = keyboardActions2;
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager2 = this.focusManager;
        if (focusManager2 != null) {
            return focusManager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final void setFocusManager(FocusManager focusManager2) {
        this.focusManager = focusManager2;
    }

    /* renamed from: runAction-KlQnJC8  reason: not valid java name */
    public final void m1076runActionKlQnJC8(int i) {
        Function1<KeyboardActionScope, Unit> function1;
        Unit unit = null;
        if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6238getDoneeUduSuo())) {
            function1 = getKeyboardActions().getOnDone();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6239getGoeUduSuo())) {
            function1 = getKeyboardActions().getOnGo();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6240getNexteUduSuo())) {
            function1 = getKeyboardActions().getOnNext();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6242getPreviouseUduSuo())) {
            function1 = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6243getSearcheUduSuo())) {
            function1 = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6244getSendeUduSuo())) {
            function1 = getKeyboardActions().getOnSend();
        } else {
            if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6237getDefaulteUduSuo()) ? true : ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6241getNoneeUduSuo())) {
                function1 = null;
            } else {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
        }
        if (function1 != null) {
            function1.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m1075defaultKeyboardActionKlQnJC8(i);
        }
    }

    /* renamed from: defaultKeyboardAction-KlQnJC8  reason: not valid java name */
    public void m1075defaultKeyboardActionKlQnJC8(int i) {
        if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6240getNexteUduSuo())) {
            getFocusManager().m3493moveFocus3ESFkO8(FocusDirection.Companion.m3489getNextdhqQ8s());
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6242getPreviouseUduSuo())) {
            getFocusManager().m3493moveFocus3ESFkO8(FocusDirection.Companion.m3490getPreviousdhqQ8s());
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6238getDoneeUduSuo())) {
            SoftwareKeyboardController softwareKeyboardController = this.keyboardController;
            if (softwareKeyboardController != null) {
                softwareKeyboardController.hide();
            }
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
