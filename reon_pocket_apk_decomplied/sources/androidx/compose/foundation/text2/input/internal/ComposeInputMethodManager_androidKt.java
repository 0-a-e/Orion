package androidx.compose.foundation.text2.input.internal;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0000\u001a(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0001\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ComposeInputMethodManagerFactory", "Lkotlin/Function1;", "Landroid/view/View;", "Landroidx/compose/foundation/text2/input/internal/ComposeInputMethodManager;", "ComposeInputMethodManager", "view", "overrideComposeInputMethodManagerFactoryForTests", "factory", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeInputMethodManager.android.kt */
public final class ComposeInputMethodManager_androidKt {
    private static Function1<? super View, ? extends ComposeInputMethodManager> ComposeInputMethodManagerFactory = ComposeInputMethodManager_androidKt$ComposeInputMethodManagerFactory$1.INSTANCE;

    public static final ComposeInputMethodManager ComposeInputMethodManager(View view) {
        return (ComposeInputMethodManager) ComposeInputMethodManagerFactory.invoke(view);
    }

    public static final Function1<View, ComposeInputMethodManager> overrideComposeInputMethodManagerFactoryForTests(Function1<? super View, ? extends ComposeInputMethodManager> function1) {
        Function1<? super View, ? extends ComposeInputMethodManager> function12 = ComposeInputMethodManagerFactory;
        ComposeInputMethodManagerFactory = function1;
        return function12;
    }
}
