package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInfo.kt */
final class WindowInfoKt$WindowFocusObserver$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function1<Boolean, Unit> $onWindowFocusChanged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInfoKt$WindowFocusObserver$2(Function1<? super Boolean, Unit> function1, int i) {
        super(2);
        this.$onWindowFocusChanged = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        WindowInfoKt.WindowFocusObserver(this.$onWindowFocusChanged, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
