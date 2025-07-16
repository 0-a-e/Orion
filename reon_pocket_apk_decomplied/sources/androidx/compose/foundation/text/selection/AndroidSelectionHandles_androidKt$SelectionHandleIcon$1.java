package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandleIcon$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Boolean> $iconVisible;
    final /* synthetic */ boolean $isLeft;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandleIcon$1(Modifier modifier, Function0<Boolean> function0, boolean z, int i) {
        super(2);
        this.$modifier = modifier;
        this.$iconVisible = function0;
        this.$isLeft = z;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AndroidSelectionHandles_androidKt.SelectionHandleIcon(this.$modifier, this.$iconVisible, this.$isLeft, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
