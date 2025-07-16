package androidx.compose.foundation.text2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
/* synthetic */ class SecureTextFieldController$passwordRevealFilter$1 extends FunctionReferenceImpl implements Function0<Unit> {
    SecureTextFieldController$passwordRevealFilter$1(Object obj) {
        super(0, obj, SecureTextFieldController.class, "scheduleHide", "scheduleHide()V", 0);
    }

    public final void invoke() {
        ((SecureTextFieldController) this.receiver).scheduleHide();
    }
}
