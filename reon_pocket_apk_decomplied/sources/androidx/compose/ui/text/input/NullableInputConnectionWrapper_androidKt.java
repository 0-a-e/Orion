package androidx.compose.ui.text.input;

import android.os.Build;
import android.view.inputmethod.InputConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\u0007"}, d2 = {"NullableInputConnectionWrapper", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function0;", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NullableInputConnectionWrapper.android.kt */
public final class NullableInputConnectionWrapper_androidKt {
    public static final NullableInputConnectionWrapper NullableInputConnectionWrapper(InputConnection inputConnection, Function0<Unit> function0) {
        if (Build.VERSION.SDK_INT >= 25) {
            return new NullableInputConnectionWrapperApi25(inputConnection, function0);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return new NullableInputConnectionWrapperApi24(inputConnection, function0);
        }
        return new NullableInputConnectionWrapperApi21(inputConnection, function0);
    }
}
