package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Function0<Unit> $onKeyboardVisibilityChange;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1(View view, Function0<Unit> function0) {
        super(1);
        this.$view = view;
        this.$onKeyboardVisibilityChange = function0;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        return new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$invoke$$inlined$onDispose$1(new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(this.$view, this.$onKeyboardVisibilityChange));
    }
}
