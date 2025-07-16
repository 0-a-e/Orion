package androidx.compose.foundation.text2.input.internal.undo;

import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.EditingBuffer;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0006"}, d2 = {"redo", "", "Landroidx/compose/foundation/text2/input/TextFieldState;", "op", "Landroidx/compose/foundation/text2/input/internal/undo/TextUndoOperation;", "undo", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextUndoOperation.kt */
public final class TextUndoOperationKt {
    public static final void undo(TextFieldState textFieldState, TextUndoOperation textUndoOperation) {
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.replace(textUndoOperation.getIndex(), textUndoOperation.getIndex() + textUndoOperation.getPostText().length(), textUndoOperation.getPreText());
        mainBuffer$foundation_release.setSelection(TextRange.m6042getStartimpl(textUndoOperation.m1476getPreSelectiond9O1mEE()), TextRange.m6037getEndimpl(textUndoOperation.m1476getPreSelectiond9O1mEE()));
        TextFieldCharSequence r6 = TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(textFieldState.getMainBuffer$foundation_release().toString(), textFieldState.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE(), textFieldState.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA());
        textFieldState.setText(r6);
        textFieldState.notifyIme(text, r6);
    }

    public static final void redo(TextFieldState textFieldState, TextUndoOperation textUndoOperation) {
        TextFieldCharSequence text = textFieldState.getText();
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer$foundation_release = textFieldState.getMainBuffer$foundation_release();
        mainBuffer$foundation_release.replace(textUndoOperation.getIndex(), textUndoOperation.getIndex() + textUndoOperation.getPreText().length(), textUndoOperation.getPostText());
        mainBuffer$foundation_release.setSelection(TextRange.m6042getStartimpl(textUndoOperation.m1475getPostSelectiond9O1mEE()), TextRange.m6037getEndimpl(textUndoOperation.m1475getPostSelectiond9O1mEE()));
        TextFieldCharSequence r6 = TextFieldCharSequenceKt.m1347TextFieldCharSequence3r_uNRQ(textFieldState.getMainBuffer$foundation_release().toString(), textFieldState.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE(), textFieldState.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA());
        textFieldState.setText(r6);
        textFieldState.notifyIme(text, r6);
    }
}
