package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        String privateImeOptions;
        int r0 = imeOptions.m6250getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6237getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6241getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6239getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6240getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6242getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6243getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6244getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m6225equalsimpl0(r0, ImeAction.Companion.m6238getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (!(platformImeOptions == null || (privateImeOptions = platformImeOptions.getPrivateImeOptions()) == null)) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int r02 = imeOptions.m6251getKeyboardTypePjHm6EE();
        if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6292getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6285getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6288getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6291getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6293getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6287getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6290getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6289getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m6272equalsimpl0(r02, KeyboardType.Companion.m6286getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m6225equalsimpl0(imeOptions.m6250getImeActioneUduSuo(), ImeAction.Companion.m6237getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int r03 = imeOptions.m6249getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m6257equalsimpl0(r03, KeyboardCapitalization.Companion.m6265getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m6257equalsimpl0(r03, KeyboardCapitalization.Companion.m6268getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m6257equalsimpl0(r03, KeyboardCapitalization.Companion.m6267getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m6042getStartimpl(textFieldValue.m6299getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m6037getEndimpl(textFieldValue.m6299getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(Choreographer choreographer) {
        return new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1(choreographer);
    }

    /* access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, Runnable runnable) {
        choreographer.postFrameCallback(new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(runnable));
    }

    /* access modifiers changed from: private */
    public static final void asExecutor$lambda$2$lambda$1(Runnable runnable, long j) {
        runnable.run();
    }
}
