package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\fH\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fH\u0000\u001a\u001c\u0010\u0018\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\u0019"}, d2 = {"isSurrogatePair", "", "high", "", "low", "backspace", "", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "commitText", "text", "", "newCursorPosition", "", "deleteAll", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "moveCursor", "amount", "setComposingRegion", "start", "end", "setComposingText", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditCommand.kt */
public final class EditCommandKt {
    public static final void commitText(EditingBuffer editingBuffer, String str, int i) {
        int i2;
        if (editingBuffer.hasComposition()) {
            editingBuffer.replace(editingBuffer.getCompositionStart(), editingBuffer.getCompositionEnd(), str);
        } else {
            editingBuffer.replace(editingBuffer.getSelectionStart(), editingBuffer.getSelectionEnd(), str);
        }
        int cursor = editingBuffer.getCursor();
        if (i > 0) {
            i2 = (cursor + i) - 1;
        } else {
            i2 = (cursor + i) - str.length();
        }
        editingBuffer.setCursor(RangesKt.coerceIn(i2, 0, editingBuffer.getLength()));
    }

    public static final void setComposingRegion(EditingBuffer editingBuffer, int i, int i2) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.commitComposition();
        }
        int coerceIn = RangesKt.coerceIn(i, 0, editingBuffer.getLength());
        int coerceIn2 = RangesKt.coerceIn(i2, 0, editingBuffer.getLength());
        if (coerceIn == coerceIn2) {
            return;
        }
        if (coerceIn < coerceIn2) {
            editingBuffer.setComposition(coerceIn, coerceIn2);
        } else {
            editingBuffer.setComposition(coerceIn2, coerceIn);
        }
    }

    public static final void setComposingText(EditingBuffer editingBuffer, String str, int i) {
        int i2;
        if (editingBuffer.hasComposition()) {
            int compositionStart = editingBuffer.getCompositionStart();
            CharSequence charSequence = str;
            editingBuffer.replace(compositionStart, editingBuffer.getCompositionEnd(), charSequence);
            if (charSequence.length() > 0) {
                editingBuffer.setComposition(compositionStart, str.length() + compositionStart);
            }
        } else {
            int selectionStart = editingBuffer.getSelectionStart();
            CharSequence charSequence2 = str;
            editingBuffer.replace(selectionStart, editingBuffer.getSelectionEnd(), charSequence2);
            if (charSequence2.length() > 0) {
                editingBuffer.setComposition(selectionStart, str.length() + selectionStart);
            }
        }
        int cursor = editingBuffer.getCursor();
        if (i > 0) {
            i2 = (cursor + i) - 1;
        } else {
            i2 = (cursor + i) - str.length();
        }
        editingBuffer.setCursor(RangesKt.coerceIn(i2, 0, editingBuffer.getLength()));
    }

    public static final void deleteSurroundingText(EditingBuffer editingBuffer, int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.").toString());
        }
        int selectionEnd = editingBuffer.getSelectionEnd();
        int i3 = selectionEnd + i2;
        if (((i2 ^ i3) & (selectionEnd ^ i3)) < 0) {
            i3 = editingBuffer.getLength();
        }
        editingBuffer.delete(editingBuffer.getSelectionEnd(), Math.min(i3, editingBuffer.getLength()));
        int selectionStart = editingBuffer.getSelectionStart();
        int i4 = selectionStart - i;
        if (((i ^ selectionStart) & (selectionStart ^ i4)) < 0) {
            i4 = 0;
        }
        editingBuffer.delete(Math.max(0, i4), editingBuffer.getSelectionStart());
    }

    public static final void deleteSurroundingTextInCodePoints(EditingBuffer editingBuffer, int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException(("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.").toString());
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            i3 = (editingBuffer.getSelectionStart() <= i5 || !isSurrogatePair(editingBuffer.get((editingBuffer.getSelectionStart() - i5) + -1), editingBuffer.get(editingBuffer.getSelectionStart() - i5))) ? i5 : i3 + 2;
            if (i3 == editingBuffer.getSelectionStart()) {
                break;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i6 + 1;
            i6 = (editingBuffer.getSelectionEnd() + i8 >= editingBuffer.getLength() || !isSurrogatePair(editingBuffer.get((editingBuffer.getSelectionEnd() + i8) + -1), editingBuffer.get(editingBuffer.getSelectionEnd() + i8))) ? i8 : i6 + 2;
            if (editingBuffer.getSelectionEnd() + i6 == editingBuffer.getLength()) {
                break;
            }
        }
        editingBuffer.delete(editingBuffer.getSelectionEnd(), editingBuffer.getSelectionEnd() + i6);
        editingBuffer.delete(editingBuffer.getSelectionStart() - i3, editingBuffer.getSelectionStart());
    }

    public static final void finishComposingText(EditingBuffer editingBuffer) {
        editingBuffer.commitComposition();
    }

    public static final void backspace(EditingBuffer editingBuffer) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.delete(editingBuffer.getCompositionStart(), editingBuffer.getCompositionEnd());
        } else if (editingBuffer.getCursor() == -1) {
            int selectionStart = editingBuffer.getSelectionStart();
            int selectionEnd = editingBuffer.getSelectionEnd();
            editingBuffer.setCursor(editingBuffer.getSelectionStart());
            editingBuffer.delete(selectionStart, selectionEnd);
        } else if (editingBuffer.getCursor() != 0) {
            editingBuffer.delete(StringHelpers_androidKt.findPrecedingBreak(editingBuffer.toString(), editingBuffer.getCursor()), editingBuffer.getCursor());
        }
    }

    public static final void moveCursor(EditingBuffer editingBuffer, int i) {
        if (editingBuffer.getCursor() == -1) {
            editingBuffer.setCursor(editingBuffer.getSelectionStart());
        }
        int selectionStart = editingBuffer.getSelectionStart();
        String editingBuffer2 = editingBuffer.toString();
        int i2 = 0;
        if (i <= 0) {
            int i3 = -i;
            while (i2 < i3) {
                int findPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(editingBuffer2, selectionStart);
                if (findPrecedingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart = findPrecedingBreak;
            }
        } else {
            while (i2 < i) {
                int findFollowingBreak = StringHelpers_androidKt.findFollowingBreak(editingBuffer2, selectionStart);
                if (findFollowingBreak == -1) {
                    break;
                }
                i2++;
                selectionStart = findFollowingBreak;
            }
        }
        editingBuffer.setCursor(selectionStart);
    }

    public static final void deleteAll(EditingBuffer editingBuffer) {
        editingBuffer.replace(0, editingBuffer.getLength(), "");
    }

    private static final boolean isSurrogatePair(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }
}
