package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0006\u0010\u001f\u001a\u00020\u0006J\b\u0010 \u001a\u00020\fH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010#\u001a\u00020$2\b\u0010\u000e\u001a\u0004\u0018\u00010%2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010)\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010,\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010-\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010.2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010/\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u00101\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u000102H\u0016J\u0018\u00103\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u001a\u00104\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi21;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function0;", "", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "getDelegate", "()Landroid/view/inputmethod/InputConnection;", "beginBatchEdit", "", "clearMetaKeyStates", "p0", "", "closeConnection", "closeDelegate", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "Landroid/view/inputmethod/InputContentInfo;", "p1", "p2", "Landroid/os/Bundle;", "commitCorrection", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "deleteSurroundingText", "deleteSurroundingTextInCodePoints", "disposeDelegate", "endBatchEdit", "finishComposingText", "getCursorCapsMode", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "getTextBeforeCursor", "performContextMenuAction", "performEditorAction", "performPrivateCommand", "", "reportFullscreenMode", "requestCursorUpdates", "sendKeyEvent", "Landroid/view/KeyEvent;", "setComposingRegion", "setComposingText", "setSelection", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NullableInputConnectionWrapper.android.kt */
class NullableInputConnectionWrapperApi21 implements NullableInputConnectionWrapper {
    private InputConnection delegate;
    private final Function0<Unit> onConnectionClosed;

    /* access modifiers changed from: protected */
    public void closeDelegate(InputConnection inputConnection) {
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        return false;
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return false;
    }

    public Handler getHandler() {
        return null;
    }

    public NullableInputConnectionWrapperApi21(InputConnection inputConnection, Function0<Unit> function0) {
        this.onConnectionClosed = function0;
        this.delegate = inputConnection;
    }

    /* access modifiers changed from: protected */
    public final InputConnection getDelegate() {
        return this.delegate;
    }

    public final void disposeDelegate() {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            closeDelegate(inputConnection);
            this.delegate = null;
        }
    }

    public final void closeConnection() {
        if (this.delegate != null) {
            disposeDelegate();
            this.onConnectionClosed.invoke();
        }
    }

    public CharSequence getTextBeforeCursor(int i, int i2) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.getTextBeforeCursor(i, i2);
        }
        return null;
    }

    public CharSequence getTextAfterCursor(int i, int i2) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.getTextAfterCursor(i, i2);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.getSelectedText(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence getSelectedText(int r2) {
        /*
            r1 = this;
            android.view.inputmethod.InputConnection r0 = r1.delegate
            if (r0 == 0) goto L_0x000a
            java.lang.CharSequence r2 = r0.getSelectedText(r2)
            if (r2 != 0) goto L_0x000e
        L_0x000a:
            java.lang.String r2 = ""
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x000e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21.getSelectedText(int):java.lang.CharSequence");
    }

    public int getCursorCapsMode(int i) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.getCursorCapsMode(i);
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r0.getExtractedText(r2, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.inputmethod.ExtractedText getExtractedText(android.view.inputmethod.ExtractedTextRequest r2, int r3) {
        /*
            r1 = this;
            android.view.inputmethod.InputConnection r0 = r1.delegate
            if (r0 == 0) goto L_0x000a
            android.view.inputmethod.ExtractedText r2 = r0.getExtractedText(r2, r3)
            if (r2 != 0) goto L_0x000f
        L_0x000a:
            android.view.inputmethod.ExtractedText r2 = new android.view.inputmethod.ExtractedText
            r2.<init>()
        L_0x000f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.NullableInputConnectionWrapperApi21.getExtractedText(android.view.inputmethod.ExtractedTextRequest, int):android.view.inputmethod.ExtractedText");
    }

    public boolean deleteSurroundingText(int i, int i2) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.deleteSurroundingText(i, i2);
        }
        return false;
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.setComposingText(charSequence, i);
        }
        return false;
    }

    public boolean setComposingRegion(int i, int i2) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.setComposingRegion(i, i2);
        }
        return false;
    }

    public boolean finishComposingText() {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.finishComposingText();
        }
        return false;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.commitText(charSequence, i);
        }
        return false;
    }

    public boolean commitCompletion(CompletionInfo completionInfo) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.commitCompletion(completionInfo);
        }
        return false;
    }

    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.commitCorrection(correctionInfo);
        }
        return false;
    }

    public boolean setSelection(int i, int i2) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.setSelection(i, i2);
        }
        return false;
    }

    public boolean performEditorAction(int i) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.performEditorAction(i);
        }
        return false;
    }

    public boolean performContextMenuAction(int i) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.performContextMenuAction(i);
        }
        return false;
    }

    public boolean beginBatchEdit() {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.beginBatchEdit();
        }
        return false;
    }

    public boolean endBatchEdit() {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.endBatchEdit();
        }
        return false;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.sendKeyEvent(keyEvent);
        }
        return false;
    }

    public boolean clearMetaKeyStates(int i) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.clearMetaKeyStates(i);
        }
        return false;
    }

    public boolean reportFullscreenMode(boolean z) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.reportFullscreenMode(z);
        }
        return false;
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.performPrivateCommand(str, bundle);
        }
        return false;
    }

    public boolean requestCursorUpdates(int i) {
        InputConnection inputConnection = this.delegate;
        if (inputConnection != null) {
            return inputConnection.requestCursorUpdates(i);
        }
        return false;
    }
}
