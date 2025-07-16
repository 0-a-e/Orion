package androidx.compose.ui.text.input;

import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "(II)V", "getLengthAfterCursor", "()I", "getLengthBeforeCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditCommand.kt */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i, int i2) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i2;
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.").toString());
        }
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public void applyTo(EditingBuffer editingBuffer) {
        int i = this.lengthBeforeCursor;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + 1;
            i2 = (editingBuffer.getSelectionStart$ui_text_release() <= i4 || !EditCommandKt.isSurrogatePair(editingBuffer.get$ui_text_release((editingBuffer.getSelectionStart$ui_text_release() - i4) + -1), editingBuffer.get$ui_text_release(editingBuffer.getSelectionStart$ui_text_release() - i4))) ? i4 : i2 + 2;
            if (i2 == editingBuffer.getSelectionStart$ui_text_release()) {
                break;
            }
        }
        int i5 = this.lengthAfterCursor;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i6 + 1;
            i6 = (editingBuffer.getSelectionEnd$ui_text_release() + i8 >= editingBuffer.getLength$ui_text_release() || !EditCommandKt.isSurrogatePair(editingBuffer.get$ui_text_release((editingBuffer.getSelectionEnd$ui_text_release() + i8) + -1), editingBuffer.get$ui_text_release(editingBuffer.getSelectionEnd$ui_text_release() + i8))) ? i8 : i6 + 2;
            if (editingBuffer.getSelectionEnd$ui_text_release() + i6 == editingBuffer.getLength$ui_text_release()) {
                break;
            }
        }
        editingBuffer.delete$ui_text_release(editingBuffer.getSelectionEnd$ui_text_release(), editingBuffer.getSelectionEnd$ui_text_release() + i6);
        editingBuffer.delete$ui_text_release(editingBuffer.getSelectionStart$ui_text_release() - i2, editingBuffer.getSelectionStart$ui_text_release());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }
}
