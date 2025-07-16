package androidx.compose.foundation.text2.input;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u0017\u0010\u0005\u001a\u00020\u00068F¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00068F¢\u0006\f\u0012\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text2/input/UndoState;", "", "state", "Landroidx/compose/foundation/text2/input/TextFieldState;", "(Landroidx/compose/foundation/text2/input/TextFieldState;)V", "canRedo", "", "getCanRedo$annotations", "()V", "getCanRedo", "()Z", "canUndo", "getCanUndo$annotations", "getCanUndo", "clearHistory", "", "redo", "undo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UndoState.kt */
public final class UndoState {
    public static final int $stable = 0;
    private final TextFieldState state;

    public static /* synthetic */ void getCanRedo$annotations() {
    }

    public static /* synthetic */ void getCanUndo$annotations() {
    }

    public UndoState(TextFieldState textFieldState) {
        this.state = textFieldState;
    }

    public final boolean getCanUndo() {
        return this.state.getTextUndoManager$foundation_release().getCanUndo();
    }

    public final boolean getCanRedo() {
        return this.state.getTextUndoManager$foundation_release().getCanRedo();
    }

    public final void undo() {
        this.state.getTextUndoManager$foundation_release().undo(this.state);
    }

    public final void redo() {
        this.state.getTextUndoManager$foundation_release().redo(this.state);
    }

    public final void clearHistory() {
        this.state.getTextUndoManager$foundation_release().clearHistory();
    }
}
