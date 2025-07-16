package androidx.compose.foundation.text2.input.internal;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/ComposeInputMethodManagerImplApi21;", "Landroidx/compose/foundation/text2/input/internal/ComposeInputMethodManagerImpl;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "sendKeyEvent", "", "event", "Landroid/view/KeyEvent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeInputMethodManager.android.kt */
class ComposeInputMethodManagerImplApi21 extends ComposeInputMethodManagerImpl {
    private BaseInputConnection baseInputConnection;

    public ComposeInputMethodManagerImplApi21(View view) {
        super(view);
    }

    public void sendKeyEvent(KeyEvent keyEvent) {
        BaseInputConnection baseInputConnection2 = this.baseInputConnection;
        if (baseInputConnection2 == null) {
            baseInputConnection2 = new BaseInputConnection(getView(), false);
            this.baseInputConnection = baseInputConnection2;
        }
        baseInputConnection2.sendKeyEvent(keyEvent);
    }
}
