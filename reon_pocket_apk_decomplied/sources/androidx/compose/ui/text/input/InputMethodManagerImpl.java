package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/input/InputMethodManagerImpl;", "Landroidx/compose/ui/text/input/InputMethodManager;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imm", "Landroid/view/inputmethod/InputMethodManager;", "getImm", "()Landroid/view/inputmethod/InputMethodManager;", "imm$delegate", "Lkotlin/Lazy;", "softwareKeyboardControllerCompat", "Landroidx/core/view/SoftwareKeyboardControllerCompat;", "hideSoftInput", "", "isActive", "", "restartInput", "showSoftInput", "updateCursorAnchorInfo", "cursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "updateExtractedText", "token", "", "extractedText", "Landroid/view/inputmethod/ExtractedText;", "updateSelection", "selectionStart", "selectionEnd", "compositionStart", "compositionEnd", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InputMethodManager.android.kt */
public final class InputMethodManagerImpl implements InputMethodManager {
    public static final int $stable = 8;
    private final Lazy imm$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new InputMethodManagerImpl$imm$2(this));
    private final SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
    /* access modifiers changed from: private */
    public final View view;

    public InputMethodManagerImpl(View view2) {
        this.view = view2;
        this.softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view2);
    }

    private final InputMethodManager getImm() {
        return (InputMethodManager) this.imm$delegate.getValue();
    }

    public boolean isActive() {
        return getImm().isActive(this.view);
    }

    public void restartInput() {
        getImm().restartInput(this.view);
    }

    public void showSoftInput() {
        this.softwareKeyboardControllerCompat.show();
    }

    public void hideSoftInput() {
        this.softwareKeyboardControllerCompat.hide();
    }

    public void updateExtractedText(int i, ExtractedText extractedText) {
        getImm().updateExtractedText(this.view, i, extractedText);
    }

    public void updateSelection(int i, int i2, int i3, int i4) {
        getImm().updateSelection(this.view, i, i2, i3, i4);
    }

    public void updateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
        getImm().updateCursorAnchorInfo(this.view, cursorAnchorInfo);
    }
}
