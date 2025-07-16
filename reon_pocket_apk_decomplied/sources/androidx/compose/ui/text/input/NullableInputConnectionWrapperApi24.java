package androidx.compose.ui.text.input;

import android.os.Handler;
import android.view.inputmethod.InputConnection;
import androidx.core.app.NotificationCompat$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0013\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi24;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi21;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function0;", "", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function0;)V", "closeDelegate", "deleteSurroundingTextInCodePoints", "", "p0", "", "p1", "getHandler", "Landroid/os/Handler;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NullableInputConnectionWrapper.android.kt */
class NullableInputConnectionWrapperApi24 extends NullableInputConnectionWrapperApi21 {
    public NullableInputConnectionWrapperApi24(InputConnection inputConnection, Function0<Unit> function0) {
        super(inputConnection, function0);
    }

    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        InputConnection delegate = getDelegate();
        if (delegate != null) {
            return delegate.deleteSurroundingTextInCodePoints(i, i2);
        }
        return false;
    }

    public final Handler getHandler() {
        InputConnection delegate = getDelegate();
        if (delegate != null) {
            return NotificationCompat$$ExternalSyntheticApiModelOutline0.m(delegate);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void closeDelegate(InputConnection inputConnection) {
        NotificationCompat$$ExternalSyntheticApiModelOutline0.m(inputConnection);
    }
}
