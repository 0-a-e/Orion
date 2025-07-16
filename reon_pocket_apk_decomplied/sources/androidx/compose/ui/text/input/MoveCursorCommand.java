package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/MoveCursorCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "amount", "", "(I)V", "getAmount", "()I", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditCommand.kt */
public final class MoveCursorCommand implements EditCommand {
    public static final int $stable = 0;
    private final int amount;

    public MoveCursorCommand(int i) {
        this.amount = i;
    }

    public final int getAmount() {
        return this.amount;
    }

    public void applyTo(EditingBuffer editingBuffer) {
        if (editingBuffer.getCursor$ui_text_release() == -1) {
            editingBuffer.setCursor$ui_text_release(editingBuffer.getSelectionStart$ui_text_release());
        }
        int selectionStart$ui_text_release = editingBuffer.getSelectionStart$ui_text_release();
        String editingBuffer2 = editingBuffer.toString();
        int i = this.amount;
        int i2 = 0;
        if (i <= 0) {
            int i3 = -i;
            while (i2 < i3) {
                int findPrecedingBreak = JvmCharHelpers_androidKt.findPrecedingBreak(editingBuffer2, selectionStart$ui_text_release);
                if (findPrecedingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart$ui_text_release = findPrecedingBreak;
            }
        } else {
            while (i2 < i) {
                int findFollowingBreak = JvmCharHelpers_androidKt.findFollowingBreak(editingBuffer2, selectionStart$ui_text_release);
                if (findFollowingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart$ui_text_release = findFollowingBreak;
            }
        }
        editingBuffer.setCursor$ui_text_release(selectionStart$ui_text_release);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MoveCursorCommand) && this.amount == ((MoveCursorCommand) obj).amount;
    }

    public int hashCode() {
        return this.amount;
    }

    public String toString() {
        return "MoveCursorCommand(amount=" + this.amount + ')';
    }
}
