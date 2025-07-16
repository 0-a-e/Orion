package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.android.kt */
final class ExposedDropdownMenu_androidKt$SoftKeyboardListener$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Density $density;
    final /* synthetic */ Function0<Unit> $onKeyboardVisibilityChange;
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenu_androidKt$SoftKeyboardListener$2(View view, Density density, Function0<Unit> function0, int i) {
        super(2);
        this.$view = view;
        this.$density = density;
        this.$onKeyboardVisibilityChange = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ExposedDropdownMenu_androidKt.SoftKeyboardListener(this.$view, this.$density, this.$onKeyboardVisibilityChange, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
