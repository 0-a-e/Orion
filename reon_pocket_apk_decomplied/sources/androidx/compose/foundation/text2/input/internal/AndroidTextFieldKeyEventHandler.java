package androidx.compose.foundation.text2.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/text2/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text2/input/internal/TextFieldKeyEventHandler;", "()V", "onPreKeyEvent", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text2/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text2/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldKeyEventHandler.android.kt */
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 0;

    /* renamed from: onPreKeyEvent-MyFupTE  reason: not valid java name */
    public boolean m1364onPreKeyEventMyFupTE(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        if (super.m1401onPreKeyEventMyFupTE(keyEvent, transformedTextFieldState, textFieldSelectionState, focusManager, softwareKeyboardController)) {
            return true;
        }
        InputDevice device = keyEvent.getDevice();
        if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m4950equalsimpl0(KeyEvent_androidKt.m4958getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4954getKeyDownCS__XNY())) {
            if (TextFieldKeyEventHandler_androidKt.m1403isKeyCodeYhN2O0w(keyEvent, 19)) {
                return focusManager.m3493moveFocus3ESFkO8(FocusDirection.Companion.m3492getUpdhqQ8s());
            }
            if (TextFieldKeyEventHandler_androidKt.m1403isKeyCodeYhN2O0w(keyEvent, 20)) {
                return focusManager.m3493moveFocus3ESFkO8(FocusDirection.Companion.m3485getDowndhqQ8s());
            }
            if (TextFieldKeyEventHandler_androidKt.m1403isKeyCodeYhN2O0w(keyEvent, 21)) {
                return focusManager.m3493moveFocus3ESFkO8(FocusDirection.Companion.m3488getLeftdhqQ8s());
            }
            if (TextFieldKeyEventHandler_androidKt.m1403isKeyCodeYhN2O0w(keyEvent, 22)) {
                return focusManager.m3493moveFocus3ESFkO8(FocusDirection.Companion.m3491getRightdhqQ8s());
            }
            if (TextFieldKeyEventHandler_androidKt.m1403isKeyCodeYhN2O0w(keyEvent, 23)) {
                softwareKeyboardController.show();
                return true;
            }
        }
        return false;
    }
}
