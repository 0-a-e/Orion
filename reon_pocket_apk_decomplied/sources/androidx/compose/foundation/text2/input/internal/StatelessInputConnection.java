package androidx.compose.foundation.text2.input.internal;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0011\u001a\u00020\u000b2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\u0014H\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0016J\u001a\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u0004\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0018\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0018\u00109\u001a\u00020%2\u0006\u00108\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0006H\u0016J\u0010\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u0006H\u0016J\u001c\u0010A\u001a\u00020\u00142\b\u0010B\u001a\u0004\u0018\u00010<2\b\u0010C\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020\u0014H\u0016J\u0010\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u0006H\u0016J\u0010\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u0006H\u0002J\u0018\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0016J\u001a\u0010P\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0018\u0010Q\u001a\u00020\u00142\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R%\u0010\u0007\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\f0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006R"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", "session", "Landroidx/compose/foundation/text2/input/internal/TextInputSession;", "(Landroidx/compose/foundation/text2/input/internal/TextInputSession;)V", "batchDepth", "", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "", "Lkotlin/ExtensionFunctionType;", "text", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "addEditCommandWithBatch", "editCommand", "beginBatchEdit", "", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performPrivateCommand", "action", "data", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "sendSynthesizedKeyEvent", "code", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: StatelessInputConnection.android.kt */
public final class StatelessInputConnection implements InputConnection {
    public static final int $stable = 8;
    private int batchDepth;
    /* access modifiers changed from: private */
    public final MutableVector<Function1<EditingBuffer, Unit>> editCommands = new MutableVector<>(new Function1[16], 0);
    private final TextInputSession session;

    private final void logDebug(String str) {
    }

    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return true;
    }

    public StatelessInputConnection(TextInputSession textInputSession) {
        this.session = textInputSession;
    }

    /* access modifiers changed from: private */
    public final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    private final void addEditCommandWithBatch(Function1<? super EditingBuffer, Unit> function1) {
        beginBatchEditInternal();
        try {
            this.editCommands.add(function1);
        } finally {
            endBatchEditInternal();
        }
    }

    public boolean beginBatchEdit() {
        logDebug("beginBatchEdit()");
        return beginBatchEditInternal();
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    public boolean endBatchEdit() {
        logDebug("endBatchEdit()");
        return endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && this.editCommands.isNotEmpty()) {
            this.session.requestEdit(new StatelessInputConnection$endBatchEditInternal$1(this));
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }

    public void closeConnection() {
        logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        logDebug("commitText(\"" + charSequence + "\", " + i + ')');
        addEditCommandWithBatch(new StatelessInputConnection$commitText$1(charSequence, i));
        return true;
    }

    public boolean setComposingRegion(int i, int i2) {
        logDebug("setComposingRegion(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$setComposingRegion$1(i, i2));
        return true;
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        logDebug("setComposingText(\"" + charSequence + "\", " + i + ')');
        addEditCommandWithBatch(new StatelessInputConnection$setComposingText$1(charSequence, i));
        return true;
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        logDebug("deleteSurroundingTextInCodePoints(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$deleteSurroundingTextInCodePoints$1(i, i2));
        return true;
    }

    public boolean deleteSurroundingText(int i, int i2) {
        logDebug("deleteSurroundingText(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$deleteSurroundingText$1(i, i2));
        return true;
    }

    public boolean setSelection(int i, int i2) {
        logDebug("setSelection(" + i + ", " + i2 + ')');
        addEditCommandWithBatch(new StatelessInputConnection$setSelection$1(i, i2));
        return true;
    }

    public boolean finishComposingText() {
        logDebug("finishComposingText()");
        addEditCommandWithBatch(StatelessInputConnection$finishComposingText$1.INSTANCE);
        return true;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        logDebug("sendKeyEvent(" + keyEvent + ')');
        this.session.sendKeyEvent(keyEvent);
        return true;
    }

    public CharSequence getTextBeforeCursor(int i, int i2) {
        String obj = TextFieldCharSequenceKt.getTextBeforeSelection(getText(), i).toString();
        logDebug("getTextBeforeCursor(" + i + ", " + i2 + "): " + obj);
        return obj;
    }

    public CharSequence getTextAfterCursor(int i, int i2) {
        String obj = TextFieldCharSequenceKt.getTextAfterSelection(getText(), i).toString();
        logDebug("getTextAfterCursor(" + i + ", " + i2 + "): " + obj);
        return obj;
    }

    public CharSequence getSelectedText(int i) {
        CharSequence charSequence;
        if (TextRange.m6036getCollapsedimpl(getText().m1346getSelectionInCharsd9O1mEE())) {
            charSequence = null;
        } else {
            charSequence = TextFieldCharSequenceKt.getSelectedText(getText()).toString();
        }
        logDebug("getSelectedText(" + i + "): " + charSequence);
        return charSequence;
    }

    public boolean requestCursorUpdates(int i) {
        logDebug("requestCursorUpdates(" + i + ')');
        return false;
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        logDebug("getExtractedText(" + extractedTextRequest + ", " + i + ')');
        return StatelessInputConnection_androidKt.toExtractedText(getText());
    }

    public int getCursorCapsMode(int i) {
        logDebug("getCursorCapsMode(" + i + ')');
        return TextUtils.getCapsMode(getText(), TextRange.m6040getMinimpl(getText().m1346getSelectionInCharsd9O1mEE()), i);
    }

    public boolean performContextMenuAction(int i) {
        logDebug("performContextMenuAction(" + i + ')');
        switch (i) {
            case 16908319:
                addEditCommandWithBatch(new StatelessInputConnection$performContextMenuAction$1(this));
                return false;
            case 16908320:
                sendSynthesizedKeyEvent(277);
                return false;
            case 16908321:
                sendSynthesizedKeyEvent(278);
                return false;
            case 16908322:
                sendSynthesizedKeyEvent(279);
                return false;
            default:
                return false;
        }
    }

    private final void sendSynthesizedKeyEvent(int i) {
        sendKeyEvent(new KeyEvent(0, i));
        sendKeyEvent(new KeyEvent(1, i));
    }

    public boolean performEditorAction(int i) {
        int i2;
        logDebug("performEditorAction(" + i + ')');
        if (i != 0) {
            switch (i) {
                case 2:
                    i2 = ImeAction.Companion.m6239getGoeUduSuo();
                    break;
                case 3:
                    i2 = ImeAction.Companion.m6243getSearcheUduSuo();
                    break;
                case 4:
                    i2 = ImeAction.Companion.m6244getSendeUduSuo();
                    break;
                case 5:
                    i2 = ImeAction.Companion.m6240getNexteUduSuo();
                    break;
                case 6:
                    i2 = ImeAction.Companion.m6238getDoneeUduSuo();
                    break;
                case 7:
                    i2 = ImeAction.Companion.m6242getPreviouseUduSuo();
                    break;
                default:
                    logDebug("IME sent an unrecognized editor action: " + i);
                    i2 = ImeAction.Companion.m6237getDefaulteUduSuo();
                    break;
            }
        } else {
            i2 = ImeAction.Companion.m6237getDefaulteUduSuo();
        }
        this.session.m1411onImeActionKlQnJC8(i2);
        return true;
    }

    public boolean commitCompletion(CompletionInfo completionInfo) {
        StringBuilder sb = new StringBuilder("commitCompletion(");
        sb.append(completionInfo != null ? completionInfo.getText() : null);
        sb.append(')');
        logDebug(sb.toString());
        return false;
    }

    public Handler getHandler() {
        logDebug("getHandler()");
        return null;
    }

    public boolean clearMetaKeyStates(int i) {
        logDebug("clearMetaKeyStates(" + i + ')');
        return false;
    }

    public boolean reportFullscreenMode(boolean z) {
        logDebug("reportFullscreenMode(" + z + ')');
        return false;
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        logDebug("performPrivateCommand(" + str + ", " + bundle + ')');
        return true;
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        logDebug("commitContent(" + inputContentInfo + ", " + i + ", " + bundle + ')');
        return false;
    }
}
