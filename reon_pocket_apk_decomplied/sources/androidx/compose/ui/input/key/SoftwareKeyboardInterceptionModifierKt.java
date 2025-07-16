package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007\u001a \u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¨\u0006\u0006"}, d2 = {"onInterceptKeyBeforeSoftKeyboard", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreInterceptKeyBeforeSoftKeyboard", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SoftwareKeyboardInterceptionModifier.kt */
public final class SoftwareKeyboardInterceptionModifierKt {
    public static final Modifier onInterceptKeyBeforeSoftKeyboard(Modifier modifier, Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new SoftKeyboardInterceptionElement(function1, (Function1<? super KeyEvent, Boolean>) null));
    }

    public static final Modifier onPreInterceptKeyBeforeSoftKeyboard(Modifier modifier, Function1<? super KeyEvent, Boolean> function1) {
        return modifier.then(new SoftKeyboardInterceptionElement((Function1<? super KeyEvent, Boolean>) null, function1));
    }
}
